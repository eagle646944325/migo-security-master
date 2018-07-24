package com.migo.service;

import com.migo.entity.TaskEntity;

import java.util.List;
import java.util.Map;

/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public interface TaskService {
	
	TaskEntity queryObject(Long taskId);
	
	List<TaskEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TaskEntity task);
	
	void update(TaskEntity task);
	
	void delete(Long taskId);
	
	void deleteBatch(Long[] taskIds);
}
