/**
 * There are <a href="http://www.banko.com.cn/">lianda</a> code generation
 */
package com.lianda.modules.oa.dao;

import com.lianda.common.persistence.CrudDao;
import com.lianda.common.persistence.annotation.MyBatisDao;
import com.lianda.modules.oa.entity.Leave;

/**
 * 请假DAO接口
 * @author liuj
 * @version 2013-8-23
 */
@MyBatisDao
public interface LeaveDao extends CrudDao<Leave> {
	
	/**
	 * 更新流程实例ID
	 * @param leave
	 * @return
	 */
	public int updateProcessInstanceId(Leave leave);
	
	/**
	 * 更新实际开始结束时间
	 * @param leave
	 * @return
	 */
	public int updateRealityTime(Leave leave);
	
}
