/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.sys.dao;

import com.lianda.common.persistence.TreeDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author lianda
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
