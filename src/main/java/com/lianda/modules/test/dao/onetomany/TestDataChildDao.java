/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.onetomany;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.onetomany.TestDataChild;

/**
 * 票务代理DAO接口
 * @author liugf
 * @version 2016-06-22
 */
@MyBatisDao
public interface TestDataChildDao extends CrudDao<TestDataChild> {

	
}