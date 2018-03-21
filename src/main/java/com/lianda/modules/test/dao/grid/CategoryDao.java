/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.grid;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.grid.Category;

/**
 * 商品分类DAO接口
 * @author liugf
 * @version 2016-05-06
 */
@MyBatisDao
public interface CategoryDao extends CrudDao<Category> {

	
}