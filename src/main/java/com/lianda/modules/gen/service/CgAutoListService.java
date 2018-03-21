package com.lianda.modules.gen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.BaseService;
import com.lianda.common.utils.StringUtils;
import com.lianda.modules.gen.dao.GenDataBaseDictDao;
import com.lianda.modules.gen.dao.GenTableColumnDao;
import com.lianda.modules.gen.dao.GenTableDao;
import com.lianda.modules.gen.entity.GenScheme;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;

@Service
@Transactional(readOnly = true)
public class CgAutoListService extends BaseService {

	@Autowired
	private GenTableDao genTableDao;

	@Autowired
	private GenTableColumnDao genTableColumnDao;

	@Autowired
	private GenDataBaseDictDao genDataBaseDictDao;

	public GenTable get(String id) {
		GenTable genTable = (GenTable) this.genTableDao.get(id);
		GenTableColumn genTableColumn;
		(genTableColumn = new GenTableColumn()).setGenTable(new GenTable(genTable.getId()));
		genTable.setColumnList(this.genTableColumnDao.findList(genTableColumn));
		return genTable;
	}

	public Page<GenTable> find(Page<GenTable> page, GenTable genTable) {
		genTable.setPage(page);
		page.setList(this.genTableDao.findList(genTable));
		return page;
	}

	public List<GenTable> findAll() {
		return this.genTableDao.findAllList(new GenTable());
	}

	public List<GenTable> findTableListFormDb(GenTable genTable) {
		return this.genDataBaseDictDao.findTableList(genTable);
	}

	public boolean checkTableName(String tableName) {
		if (StringUtils.isBlank(tableName))
			return true;
		GenTable genTable = new GenTable();
		genTable.setName(tableName);
		 List<GenTable> list = this.genTableDao.findList(genTable);
		if(list.size()==0){
			return true;
		}else{
			return false;
		}
				 
	}

	public boolean checkTableNameFromDB(String tableName) {
		if (StringUtils.isBlank(tableName))
			return true;
		GenTable genTable = new GenTable();
		genTable.setName(tableName);
		
		 List<GenTable> list =this.genDataBaseDictDao.findTableList(genTable);
			if(list.size()==0){
				return true;
			}else{
				return false;
			}

	}

	public String generateCode(GenScheme genScheme) {
		GenTable genTable = this.genTableDao.get(genScheme.getGenTable().getId());
		List<GenTableColumn> columnList = this.genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId())));
		genTable.setColumnList(columnList);

		com.lianda.modules.gen.util.a.b();

		genScheme.setGenTable(genTable);
		Map model = com.lianda.modules.gen.util.a.a(genScheme);

		Map localMap1 = model;
		String tplName = "/com/lianda/modules/gen/template/viewList.ftl";

		return com.lianda.modules.gen.template.a.a(tplName, "utf-8", localMap1);
	}

	public String generateListCode(GenScheme genScheme) {
		GenTable genTable = this.genTableDao.get(genScheme.getGenTable().getId());
		List<GenTableColumn> columnList = this.genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId())));

		com.lianda.modules.gen.util.a.b();

		genScheme.setGenTable(genTable);
		Map model = com.lianda.modules.gen.util.a.a(genScheme);

		Map localMap1 = model;
		String tplName = "/com/lianda/modules/gen/template/findList.ftl";

		return  com.lianda.modules.gen.template.a.a(tplName, "utf-8", localMap1);
	}
}