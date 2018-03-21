/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.iim.dao;

import java.util.List;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.iim.entity.ChatHistory;

/**
 * 聊天记录DAO接口
 * @author lianda
 * @version 2015-12-29
 */
@MyBatisDao
public interface ChatHistoryDao extends CrudDao<ChatHistory> {
	
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<ChatHistory> findLogList(ChatHistory entity);
	
	
	public int findUnReadCount(ChatHistory chatHistory);
	
}