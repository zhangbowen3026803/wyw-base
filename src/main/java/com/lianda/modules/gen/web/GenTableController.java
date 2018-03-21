package com.lianda.modules.gen.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lianda.common.config.Global;
import com.lianda.common.persistence.Page;
import com.lianda.common.utils.StringUtils;
import com.lianda.common.web.BaseController;
import com.lianda.modules.gen.dao.GenTemplateDao;
import com.lianda.modules.gen.entity.GenScheme;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;
import com.lianda.modules.gen.service.GenSchemeService;
import com.lianda.modules.gen.service.GenTableService;
import com.lianda.modules.gen.service.GenTemplateService;
import com.lianda.modules.sys.entity.User;
import com.lianda.modules.sys.utils.UserUtils;

@Controller
@RequestMapping({ "${adminPath}/gen/genTable" })
public class GenTableController extends BaseController {

	@Autowired
	public GenTemplateService genTemplateService;

	@Autowired
	public GenTableService genTableService;

	@Autowired
	public GenSchemeService genSchemeService;

	@Autowired
	public GenTemplateDao genTemplateDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAutoGrowCollectionLimit(1024);
	}

	private GenTable a(GenTable genTable) {
		if (StringUtils.isNotBlank(genTable.getId())) {
			return this.genTableService.get(genTable.getId());
		}
		return genTable;
	}

	@RequiresPermissions({ "gen:genTable:list" })
	@RequestMapping({ "list", "" })
	private String a(GenTable genTable, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		genTable = a(genTable);
		User user = UserUtils.getUser();
		if (!user.isAdmin()) {
			genTable.setCreateBy(user);
		}

		Page<GenTable> page = new Page<GenTable>(request, response);
		page = this.genTableService.find(page, genTable);
		model.addAttribute("page", page);
		return "modules/gen/genTableList";
	}

	@RequiresPermissions(value = { "gen:genTable:view", "gen:genTable:add", "gen:genTable:edit" }, logical = Logical.OR)
	@RequestMapping({ "form" })
	private String a(GenTable genTable, HttpServletResponse response, Model model) throws IOException {
		genTable = a(genTable);
		model.addAttribute("genTable", genTable);
		model.addAttribute("config", com.lianda.modules.gen.util.a.b());
		model.addAttribute("tableList", genTableService.findAll());
		return "modules/gen/genTableForm";

	}

	@RequiresPermissions(value = { "gen:genTable:add", "gen:genTable:edit" }, logical = Logical.OR)
	@RequestMapping({ "save" })
	private String a(GenTable genTable, Model model, RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException {
		if (!beanValidator(model, genTable, new Class[0])) {
			// 待优化
			List<GenTable> list = this.genTableService.findAll();
			model.addAttribute("genTable", genTable);
			model.addAttribute("config", com.lianda.modules.gen.util.a.b());
			model.addAttribute("tableList", list);
			return "modules/gen/genTableForm";

		}
		if ((StringUtils.isBlank(genTable.getId())) && (!this.genTableService.checkTableName(genTable.getName()))) {
			addMessage(redirectAttributes, new String[] { "添加失败！" + genTable.getName() + " 记录已存在！" });
			return "redirect:" + this.adminPath + "/gen/genTable/?repage";
		}

		if ((StringUtils.isBlank(genTable.getId())) && (!this.genTableService.checkTableNameFromDB(genTable.getName()))) {
			addMessage(redirectAttributes, new String[] { "添加失败！" + genTable.getName() + "表已经在数据库中存在,请从数据库导入表单！" });
			return "redirect:" + this.adminPath + "/gen/genTable/?repage";
		}

		this.genTableService.save(genTable);
		addMessage(redirectAttributes, new String[] { "保存业务表'" + genTable.getName() + "'成功" });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}

	@RequiresPermissions({ "gen:genTable:importDb" })
	@RequestMapping({ "importTableFromDB" })
	private String a(GenTable genTable, Model model, RedirectAttributes redirectAttributes) {
		if (!StringUtils.isBlank((genTable = a(genTable)).getName())) {
			if (!this.genTableService.checkTableName(genTable.getName())) {
				addMessage(redirectAttributes, new String[] { "下一步失败！" + genTable.getName() + " 表已经添加！" });
				return "redirect:" + this.adminPath + "/gen/genTable/?repage";
			}
			(genTable = this.genTableService.getTableFormDb(genTable)).setTableType("0");
			this.genTableService.saveFromDB(genTable);
			addMessage(redirectAttributes, new String[] { "数据库导入表单'" + genTable.getName() + "'成功" });
			return "redirect:" + this.adminPath + "/gen/genTable/?repage";
		}

		List<GenTable> tableList = this.genTableService.findTableListFormDb(new GenTable());
		model.addAttribute("tableList", tableList);
		model.addAttribute("config", com.lianda.modules.gen.util.a.b());
		return "modules/gen/importTableFromDB";
	}

	@RequiresPermissions({ "gen:genTable:del" })
	@RequestMapping({ "delete" })
	private String a(GenTable genTable, RedirectAttributes redirectAttributes) {
		genTable = a(genTable);
		this.genTableService.delete(genTable);
		this.genSchemeService.delete(this.genSchemeService.findUniqueByProperty("gen_table_id", genTable.getId()));
		addMessage(redirectAttributes, new String[] { "移除业务表记录成功" });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}

	@RequiresPermissions({ "gen:genTable:del" })
	@RequestMapping({ "deleteDb" })
	private String b(GenTable genTable, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode().booleanValue()) {
			addMessage(redirectAttributes, new String[] { "演示模式，不允许操作！" });
			return "redirect:" + this.adminPath + "/gen/genTable/?repage";
		}
		genTable = a(genTable);
		this.genTableService.delete(genTable);
		this.genSchemeService.delete(this.genSchemeService.findUniqueByProperty("gen_table_id", genTable.getId()));
		StringBuffer sql = new StringBuffer();
		String dbType = Global.getConfig("jdbc.type");
		if ("mysql".equals(dbType)) {
			sql.append("drop table if exists " + genTable.getName() + " ;");
		} else if ("oracle".equals(dbType))
			try {
				sql.append("DROP TABLE " + genTable.getName());
			} catch (Exception localException) {
			}
		else if (("mssql".equals(dbType)) || ("sqlserver".equals(dbType))) {
			sql.append("if exists (select * from sysobjects where id = object_id(N'[" + genTable.getName() + "]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)  drop table [" + genTable.getName() + "]");
		}

		this.genTableService.buildTable(sql.toString());
		addMessage(redirectAttributes, new String[] { "删除业务表记录和数据库表成功" });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}

	@RequiresPermissions({ "gen:genTable:del" })
	@RequestMapping({ "deleteAll" })
	private String a(String ids, RedirectAttributes redirectAttributes) {
		String[] idlist = ids.split(",");
		for (String id : idlist) {
			GenTable table = this.genTableService.get(id);
			this.genTableService.delete(table);
		}
		addMessage(redirectAttributes, new String[] { "删除业务表成功" });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}

	@RequiresPermissions({ "gen:genTable:synchDb" })
	@RequestMapping({ "synchDb" })
	private String c(GenTable genTable, RedirectAttributes redirectAttributes) {
		String dbType = Global.getConfig("jdbc.type");

		genTable = a(genTable);
		List<GenTableColumn> getTableColumnList = genTable.getColumnList();

		if ("mysql".equals(dbType)) {
			String drop = "drop table if exists " + genTable.getName() + " ;";
			this.genTableService.buildTable(drop);

			StringBuffer sql = new StringBuffer();
			sql.append("create table " + genTable.getName() + " (");
			String pk = "";
			Iterator<GenTableColumn> localIterator = getTableColumnList.iterator();
			while (localIterator.hasNext()) {
				GenTableColumn column = localIterator.next();
				if (column.getIsPk().equals("1")) {
					sql.append("  " + column.getName() + " " + column.getJdbcType() + " comment '" + column.getComments() + "',");
					pk = pk + column.getName() + ",";
				} else {
					sql.append("  " + column.getName() + " " + column.getJdbcType() + " comment '" + column.getComments() + "',");
				}
			}

			if (StringUtils.isNotBlank(pk)) {
				sql.append("primary key (" + pk.substring(0, pk.length() - 1) + ") ");
				sql.append(") comment '" + genTable.getComments() + "'");
			}else{
				sql.deleteCharAt(sql.length()-1);
				sql.append(" )comment '" + genTable.getComments() + "'");
			}
			this.genTableService.buildTable(sql.toString());
		} else {
			// TODO
		}

		this.genTableService.syncSave(genTable);

		addMessage(redirectAttributes, new String[] { "强制同步数据库表成功" });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}

	@RequiresPermissions({ "gen:genTable:genCode" })
	@RequestMapping({ "genCodeForm" })
	private String a(GenScheme genScheme, Model model) {
		if (StringUtils.isBlank(genScheme.getPackageName())) {
			genScheme.setPackageName("com.lianda.modules");
		}
		GenScheme oldGenScheme = this.genSchemeService.findUniqueByProperty("gen_table_id", genScheme.getGenTable().getId());
		if (oldGenScheme != null) {
			genScheme = oldGenScheme;
		}
		model.addAttribute("genScheme", genScheme);
		model.addAttribute("config", com.lianda.modules.gen.util.a.b());
		model.addAttribute("tableList", this.genTableService.findAll());
		return "modules/gen/genCodeForm";
	}

	@RequestMapping({ "genCode" })
	private String a(GenScheme genScheme, RedirectAttributes redirectAttributes) {
		String result = this.genSchemeService.save(genScheme);
		addMessage(redirectAttributes, new String[] { genScheme.getGenTable().getName() + "代码生成成功<br/>" + result });
		return "redirect:" + this.adminPath + "/gen/genTable/?repage";
	}
}