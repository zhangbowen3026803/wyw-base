/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.oa.dao;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * @author lianda
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {
	
	/**
	 * 获取通知数目
	 * @param oaNotify
	 * @return
	 */
	public Long findCount(OaNotify oaNotify);
	
}