/**
 * Copyright &copy; 2015-2020 <a href="http://www.banko.com.cn/">lianda</a> All rights reserved.
 */
package com.lianda.modules.test.dao.grid;

import java.util.List;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.test.entity.grid.Category;
import com.lianda.modules.test.entity.grid.Goods;

/**
 * 商品DAO接口
 * @author liugf
 * @version 2016-05-06
 */
@MyBatisDao
public interface GoodsDao extends CrudDao<Goods> {

	public List<Category> findListBycategory(Category category);
	
}