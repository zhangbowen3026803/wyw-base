/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.one;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.one.FormLeave;

/**
 * 员工请假DAO接口
 * @author liugf
 * @version 2016-06-22
 */
@MyBatisDao
public interface FormLeaveDao extends CrudDao<FormLeave> {

	
}