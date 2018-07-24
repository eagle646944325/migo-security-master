package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.TaskDao;
import com.migo.entity.TaskEntity;
import com.migo.service.TaskService;



@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public TaskEntity queryObject(Long taskId){
		return taskDao.queryObject(taskId);
	}
	
	@Override
	public List<TaskEntity> queryList(Map<String, Object> map){
		return taskDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return taskDao.queryTotal(map);
	}
	
	@Override
	public void save(TaskEntity task){
		taskDao.save(task);
	}
	
	@Override
	public void update(TaskEntity task){
		taskDao.update(task);
	}
	
	@Override
	public void delete(Long taskId){
		taskDao.delete(taskId);
	}
	
	@Override
	public void deleteBatch(Long[] taskIds){
		taskDao.deleteBatch(taskIds);
	}
	
}
