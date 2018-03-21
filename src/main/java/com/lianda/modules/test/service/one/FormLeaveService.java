/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.service.one;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.CrudService;
import com.lianda.modules.test.dao.one.FormLeaveDao;
import com.lianda.modules.test.entity.one.FormLeave;

/**
 * 员工请假Service
 * @author liugf
 * @version 2016-06-22
 */
@Service
@Transactional(readOnly = true)
public class FormLeaveService extends CrudService<FormLeaveDao, FormLeave> {

	public FormLeave get(String id) {
		return super.get(id);
	}
	
	public List<FormLeave> findList(FormLeave formLeave) {
		return super.findList(formLeave);
	}
	
	public Page<FormLeave> findPage(Page<FormLeave> page, FormLeave formLeave) {
		return super.findPage(page, formLeave);
	}
	
	@Transactional(readOnly = false)
	public void save(FormLeave formLeave) {
		super.save(formLeave);
	}
	
	@Transactional(readOnly = false)
	public void delete(FormLeave formLeave) {
		super.delete(formLeave);
	}
	
	
	
	
}