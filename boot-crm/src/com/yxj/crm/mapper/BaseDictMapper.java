package com.yxj.crm.mapper;

import com.yxj.crm.pojo.BaseDict;

import java.util.List;



/**
 * 字典数据表持久化接口
 * @author Steven
 *
 */
public interface BaseDictMapper {
	/**
	 * 跟据字典编码查询字典列表
	 * @param code
	 * @return
	 */
	List<BaseDict> getBaseDictByCode(String code);
}

