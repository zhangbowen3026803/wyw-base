/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.monitor.dao;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.monitor.entity.Monitor;

/**
 * 系统监控DAO接口
 * @author liugf
 * @version 2016-02-07
 */
@MyBatisDao
public interface MonitorDao extends CrudDao<Monitor> {
	
}