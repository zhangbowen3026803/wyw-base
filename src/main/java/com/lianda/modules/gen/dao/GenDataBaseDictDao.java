package com.lianda.modules.gen.dao;


import java.util.List;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;

@MyBatisDao
public abstract interface GenDataBaseDictDao extends CrudDao<GenTableColumn>
{
  public abstract List<GenTable> findTableList(GenTable paramGenTable);

  public abstract List<GenTableColumn> findTableColumnList(GenTable paramGenTable);

  public abstract List<String> findTablePK(GenTable paramGenTable);
}