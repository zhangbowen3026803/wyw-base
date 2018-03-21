package com.lianda.modules.gen.dao;


import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;

@MyBatisDao
public abstract interface GenTableColumnDao extends CrudDao<GenTableColumn>
{
  public abstract void deleteByGenTable(GenTable paramGenTable);
}