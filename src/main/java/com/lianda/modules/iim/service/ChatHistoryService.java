/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.iim.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.CrudService;
import com.lianda.modules.iim.dao.ChatHistoryDao;
import com.lianda.modules.iim.entity.ChatHistory;

/**
 * 聊天记录Service
 * @author lianda
 * @version 2015-12-29
 */
@Service
@Transactional(readOnly = true)
public class ChatHistoryService extends CrudService<ChatHistoryDao, ChatHistory> {

	public ChatHistory get(String id) {
		return super.get(id);
	}
	
	public List<ChatHistory> findList(ChatHistory chatHistory) {
		return super.findList(chatHistory);
	}
	
	
	public Page<ChatHistory> findPage(Page<ChatHistory> page, ChatHistory entity) {
		entity.setPage(page);
		page.setList(dao.findLogList(entity));
		return page;
	}
	
	
	@Transactional(readOnly = false)
	public void save(ChatHistory chatHistory) {
		super.save(chatHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ChatHistory chatHistory) {
		super.delete(chatHistory);
	}
	
	public int findUnReadCount(ChatHistory chatHistory){
		return dao.findUnReadCount(chatHistory);
	}
	
}