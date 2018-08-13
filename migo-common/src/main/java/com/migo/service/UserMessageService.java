package com.migo.service;

import com.migo.entity.UserMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-13 21:50:33
 */
public interface UserMessageService {
	
	UserMessageEntity queryObject(Long id);
	
	List<UserMessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserMessageEntity userMessage);
	
	void update(UserMessageEntity userMessage);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
