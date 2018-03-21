/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.tools.dao;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.tools.entity.TestInterface;

/**
 * 接口DAO接口
 * @author lgf
 * @version 2016-01-07
 */
@MyBatisDao
public interface TestInterfaceDao extends CrudDao<TestInterface> {
	
}