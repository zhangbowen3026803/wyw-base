package com.lianda.modules.gen.dao;


import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.gen.entity.GenTemplate;

@MyBatisDao
public abstract interface GenTemplateDao extends CrudDao<GenTemplate>
{
}