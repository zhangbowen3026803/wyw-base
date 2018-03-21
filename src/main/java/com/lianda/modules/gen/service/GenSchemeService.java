package com.lianda.modules.gen.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.BaseService;
import com.lianda.common.utils.StringUtils;
import com.lianda.modules.gen.dao.GenSchemeDao;
import com.lianda.modules.gen.dao.GenTableColumnDao;
import com.lianda.modules.gen.dao.GenTableDao;
import com.lianda.modules.gen.entity.GenConfig;
import com.lianda.modules.gen.entity.GenScheme;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;
import com.lianda.modules.gen.entity.GenTemplate;
import com.lianda.modules.gen.util.a;
import com.lianda.modules.sys.entity.Menu;
import com.lianda.modules.sys.service.SystemService;

@Service
@Transactional(readOnly = true)
public class GenSchemeService extends BaseService {

	@Autowired
	private GenSchemeDao genSchemeDao;

	@Autowired
	private GenTableDao genTableDao;

	@Autowired
	private GenTableColumnDao genTableColumnDao;

	@Autowired
	private SystemService systemService;

	public GenScheme get(String id) {
		return (GenScheme) this.genSchemeDao.get(id);
	}

	public Page<GenScheme> find(Page<GenScheme> page, GenScheme genScheme) {
		a.a();
		genScheme.setPage(page);
		page.setList(this.genSchemeDao.findList(genScheme));
		return page;
	}

	@Transactional(readOnly = false)
	public String save(GenScheme genScheme) {
		if (StringUtils.isBlank(genScheme.getId())) {
			genScheme.preInsert();
			this.genSchemeDao.insert(genScheme);
		} else {
			genScheme.preUpdate();
			this.genSchemeDao.update(genScheme);
		}
		return generateCode(genScheme);
	}

	@Transactional(readOnly = false)
	public void createMenu(GenScheme genScheme, Menu topMenu) {
		String permissionPrefix = StringUtils.lowerCase(genScheme.getModuleName()) + ((StringUtils.isNotBlank(genScheme.getSubModuleName())) ? ":" + StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + ":" + StringUtils.uncapitalize(genScheme.getGenTable().getClassName());
		String url = "/" + StringUtils.lowerCase(genScheme.getModuleName()) + ((StringUtils.isNotBlank(genScheme.getSubModuleName())) ? "/" + StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + "/" + StringUtils.uncapitalize(genScheme.getGenTable().getClassName());

		topMenu.setName(genScheme.getFunctionName());
		topMenu.setHref(url);
		topMenu.setIsShow("1");
		topMenu.setPermission(permissionPrefix + ":list");
		this.systemService.saveMenu(topMenu);

		Menu addMenu = new Menu();
		addMenu.setName("增加");
		addMenu.setIsShow("0");
		addMenu.setSort(Integer.valueOf(30));
		addMenu.setPermission(permissionPrefix + ":add");
		addMenu.setParent(topMenu);
		this.systemService.saveMenu(addMenu);

		Menu delMenu = new Menu();
		delMenu.setName("删除");
		delMenu.setIsShow("0");
		delMenu.setSort(Integer.valueOf(60));
		delMenu.setPermission(permissionPrefix + ":del");
		delMenu.setParent(topMenu);
		this.systemService.saveMenu(delMenu);

		Menu editMenu = new Menu();
		editMenu.setName("编辑");
		editMenu.setIsShow("0");
		editMenu.setSort(Integer.valueOf(90));
		editMenu.setPermission(permissionPrefix + ":edit");
		editMenu.setParent(topMenu);
		this.systemService.saveMenu(editMenu);

		Menu viewMenu = new Menu();
		viewMenu.setName("查看");
		viewMenu.setIsShow("0");
		viewMenu.setSort(Integer.valueOf(120));
		viewMenu.setPermission(permissionPrefix + ":view");
		viewMenu.setParent(topMenu);
		this.systemService.saveMenu(viewMenu);
		Menu importMenu;
		(importMenu = new Menu()).setName("导入");
		importMenu.setIsShow("0");
		importMenu.setSort(Integer.valueOf(150));
		importMenu.setPermission(permissionPrefix + ":import");
		importMenu.setParent(topMenu);
		this.systemService.saveMenu(importMenu);
		Menu exportMenu;
		(exportMenu = new Menu()).setName("导出");
		exportMenu.setIsShow("0");
		exportMenu.setSort(Integer.valueOf(180));
		exportMenu.setPermission(permissionPrefix + ":export");
		exportMenu.setParent(topMenu);
		this.systemService.saveMenu(exportMenu);
	}

	@Transactional(readOnly = false)
	public void delete(GenScheme genScheme) {
		this.genSchemeDao.delete(genScheme);
	}

	private String generateCode(GenScheme genScheme) {
		StringBuilder result = new StringBuilder();
		GenTable genTable = this.genTableDao.get(genScheme.getGenTable().getId());

		List<GenTableColumn> columnList = this.genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId())));

		genTable.setColumnList(columnList);
		GenConfig config = a.b();
		List<GenTemplate> templateList = a.a(config, genScheme.getCategory(), false);
		List<GenTemplate> childTableTemplateList = a.a(config, genScheme.getCategory(), true);
		if (childTableTemplateList.size() > 0) {
			GenTable parentTable;
			(parentTable = new GenTable()).setParentTable(genTable.getName());
			genTable.setChildList(this.genTableDao.findList(parentTable));
		}
		Map childTableModel;
		for (Iterator localIterator1 = genTable.getChildList().iterator(); localIterator1.hasNext();) {
			GenTable childTable;
			(childTable = (GenTable) localIterator1.next()).setParent(genTable);
			childTable.setColumnList(this.genTableColumnDao.findList(new GenTableColumn(new GenTable(childTable.getId()))));
			genScheme.setGenTable(childTable);
			childTableModel = a.a(genScheme);
			for (GenTemplate tpl : childTableTemplateList) {
				result.append(a.a(tpl, childTableModel, true));
			}

		}

		genScheme.setGenTable(genTable);
		Map model = a.a(genScheme);
		for (GenTemplate tpl : templateList) {
			result.append(a.a(tpl, model, true));
		}
		return result.toString();
	}

	public GenScheme findUniqueByProperty(String propertyName, String value) {
		return (GenScheme) this.genSchemeDao.findUniqueByProperty(propertyName, value);
	}
}