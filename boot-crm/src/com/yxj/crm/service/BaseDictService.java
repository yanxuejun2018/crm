package com.yxj.crm.service;

import com.yxj.crm.pojo.BaseDict;

import java.util.List;

/**
 * 字典数据表业务逻辑接口
 * @author Steven
 *
 */
public interface BaseDictService {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
