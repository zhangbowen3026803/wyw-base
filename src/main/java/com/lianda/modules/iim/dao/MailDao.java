/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.iim.dao;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.iim.entity.Mail;

/**
 * 发件箱DAO接口
 * @author lianda
 * @version 2015-11-15
 */
@MyBatisDao
public interface MailDao extends CrudDao<Mail> {
	public int getCount(MailDao entity);
}