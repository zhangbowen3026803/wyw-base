/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.tree;

import com.lianda.common.persistence.TreeDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.tree.TestTree;

/**
 * 组织机构DAO接口
 * @author liugf
 * @version 2016-05-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}