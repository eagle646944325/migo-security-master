package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.TaskSearchDao;
import com.migo.entity.TaskSearchEntity;
import com.migo.service.TaskSearchService;



@Service("taskSearchService")
public class TaskSearchServiceImpl implements TaskSearchService {
	@Autowired
	private TaskSearchDao taskSearchDao;
	
	@Override
	public TaskSearchEntity queryObject(Long searchId){
		return taskSearchDao.queryObject(searchId);
	}
	
	@Override
	public List<TaskSearchEntity> queryList(Map<String, Object> map){
		return taskSearchDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return taskSearchDao.queryTotal(map);
	}
	
	@Override
	public void save(TaskSearchEntity taskSearch){
		taskSearchDao.save(taskSearch);
	}
	
	@Override
	public void update(TaskSearchEntity taskSearch){
		taskSearchDao.update(taskSearch);
	}
	
	@Override
	public void delete(Long searchId){
		taskSearchDao.delete(searchId);
	}
	
	@Override
	public void deleteBatch(Long[] searchIds){
		taskSearchDao.deleteBatch(searchIds);
	}
	
}
