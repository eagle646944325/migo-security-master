package com.migo.service;

import com.migo.entity.TaskSearchEntity;

import java.util.List;
import java.util.Map;

/**
 * 任务搜索条件
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public interface TaskSearchService {
	
	TaskSearchEntity queryObject(Long searchId);
	
	List<TaskSearchEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TaskSearchEntity taskSearch);
	
	void update(TaskSearchEntity taskSearch);
	
	void delete(Long searchId);
	
	void deleteBatch(Long[] searchIds);
}
