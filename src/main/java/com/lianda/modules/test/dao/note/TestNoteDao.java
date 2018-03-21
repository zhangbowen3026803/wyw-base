/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.note;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.note.TestNote;

/**
 * 富文本测试DAO接口
 * @author liugf
 * @version 2016-05-06
 */
@MyBatisDao
public interface TestNoteDao extends CrudDao<TestNote> {

	
}