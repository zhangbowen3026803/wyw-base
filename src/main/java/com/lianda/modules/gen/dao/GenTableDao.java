package com.lianda.modules.gen.dao;


import org.apache.ibatis.annotations.Param;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.gen.entity.GenTable;

@MyBatisDao
public abstract interface GenTableDao extends CrudDao<GenTable>
{
  public abstract int buildTable(@Param("sql") String paramString);
}