package com.lianda.modules.gen.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.BaseService;
import com.lianda.common.utils.StringUtils;
import com.lianda.modules.gen.dao.GenDataBaseDictDao;
import com.lianda.modules.gen.dao.GenTableColumnDao;
import com.lianda.modules.gen.dao.GenTableDao;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;
import com.lianda.modules.gen.util.a;

@Service
@Transactional(readOnly = true)
public class GenTableService extends BaseService {

	@Autowired
	private GenTableDao genTableDao;

	@Autowired
	private GenTableColumnDao genTableColumnDao;

	@Autowired
	private GenDataBaseDictDao genDataBaseDictDao;

	public GenTable get(String id) {
		GenTable genTable = (GenTable) this.genTableDao.get(id);
		GenTableColumn genTableColumn = new GenTableColumn();
		genTableColumn.setGenTable(new GenTable(genTable.getId()));
		List<GenTableColumn> list = this.genTableColumnDao.findList(genTableColumn);
		genTable.setColumnList(list);
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
		if (StringUtils.isBlank(tableName)) {
			return true;
		}
		GenTable genTable = new GenTable();
		genTable.setName(tableName);
		List<GenTable> list = this.genTableDao.findList(genTable);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkTableNameFromDB(String tableName) {
		if (StringUtils.isBlank(tableName))
			return true;
		GenTable genTable = new GenTable();
		genTable.setName(tableName);
		List<GenTable> list = this.genDataBaseDictDao.findTableList(genTable);

		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public GenTable getTableFormDb(GenTable genTable) {
		List list = this.genDataBaseDictDao.findTableList(genTable);
		if ((StringUtils.isNotBlank(genTable.getName())) && (list.size() > 0)) {
			if (StringUtils.isBlank(genTable.getId())) {
				if (StringUtils.isBlank((genTable = (GenTable) list.get(0)).getComments())) {
					genTable.setComments(genTable.getName());
				}
				genTable.setClassName(StringUtils.toCapitalizeCamelCase(genTable.getName()));
			}

			List<GenTableColumn> columnList = this.genDataBaseDictDao.findTableColumnList(genTable);
			for (GenTableColumn column : columnList) {
				boolean b = false;
				Iterator localIterator2 = genTable.getColumnList().iterator();
				while (localIterator2.hasNext()) {
					GenTableColumn e = (GenTableColumn) localIterator2.next();
					if ((e.getName() != null) && (e.getName().equals(column.getName()))) {
						b = true;
					}
				}
				if (!b) {
					genTable.getColumnList().add(column);
				}

			}

			for (GenTableColumn e : genTable.getColumnList()) {
				boolean b = false;
				Iterator localIterator2 = columnList.iterator();
				while (localIterator2.hasNext()) {
					GenTableColumn gtc = (GenTableColumn) localIterator2.next();
					if (gtc.getName().equals(e.getName())) {
						b = true;
					}
				}
				if (!b) {
					e.setDelFlag("1");
				}

			}

			genTable.setPkList(this.genDataBaseDictDao.findTablePK(genTable));

			a.a(genTable);
		}

		return genTable;
	}

	@Transactional(readOnly = false)
	public void save(GenTable genTable) {
		boolean isSync = true;
		if (StringUtils.isBlank(genTable.getId())) {
			isSync = false;
		} else {
			GenTable oldTable = get(genTable.getId());
			if ((oldTable.getColumnList().size() != genTable.getColumnList().size()) || (!oldTable.getName().equals(genTable.getName())) || (!oldTable.getComments().equals(genTable.getComments()))) {
				isSync = false;
			} else {
				Iterator<GenTableColumn> localIterator = genTable.getColumnList().iterator();
				while (localIterator.hasNext()) {
					GenTableColumn column = localIterator.next();
					GenTableColumn oldColumn = genTableColumnDao.get(column.getId());
					if (StringUtils.isBlank(column.getId()) || !(oldColumn.getName().equals(column.getName()) || !oldColumn.getJdbcType().equals(column.getJdbcType()) || !oldColumn.getIsPk().equals(column.getIsPk()) || !oldColumn.getComments().equals(column.getComments()))) {
						continue;
					}
					isSync = false;
				}

			}
		}
		if (!isSync) {
			genTable.setIsSync("0");
		}

		if (StringUtils.isBlank(genTable.getId())) {
			genTable.preInsert();
			this.genTableDao.insert(genTable);
		} else {
			genTable.preUpdate();
			this.genTableDao.update(genTable);
		}

		this.genTableColumnDao.deleteByGenTable(genTable);

		Iterator<GenTableColumn> tableColumnIterator = genTable.getColumnList().iterator();
		while (tableColumnIterator.hasNext()) {
			GenTableColumn column = tableColumnIterator.next();
			column.setGenTable(genTable);
			column.setId(null);
			column.preInsert();
			this.genTableColumnDao.insert(column);
		}
	}

	@Transactional(readOnly = false)
	public void syncSave(GenTable genTable) {
		genTable.setIsSync("1");
		this.genTableDao.update(genTable);
	}

	@Transactional(readOnly = false)
	public void saveFromDB(GenTable genTable) {
		genTable.preInsert();
		this.genTableDao.insert(genTable);

		for (Iterator localIterator = genTable.getColumnList().iterator(); localIterator.hasNext();) {
			GenTableColumn column;
			(column = (GenTableColumn) localIterator.next()).setGenTable(genTable);
			column.setId(null);
			column.preInsert();
			this.genTableColumnDao.insert(column);
		}
	}

	@Transactional(readOnly = false)
	public void delete(GenTable genTable) {
		this.genTableDao.delete(genTable);
		this.genTableColumnDao.deleteByGenTable(genTable);
	}

	@Transactional(readOnly = false)
	public void buildTable(String sql) {
		this.genTableDao.buildTable(sql);
	}
}