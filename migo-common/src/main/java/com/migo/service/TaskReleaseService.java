package com.migo.service;

import com.migo.entity.TaskReleaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 任务发布生效
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public interface TaskReleaseService {
	
	TaskReleaseEntity queryObject(Long releaseId);
	
	List<TaskReleaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TaskReleaseEntity taskRelease);
	
	void update(TaskReleaseEntity taskRelease);
	
	void delete(Long releaseId);
	
	void deleteBatch(Long[] releaseIds);
}
