package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.TaskReleaseDao;
import com.migo.entity.TaskReleaseEntity;
import com.migo.service.TaskReleaseService;



@Service("taskReleaseService")
public class TaskReleaseServiceImpl implements TaskReleaseService {
	@Autowired
	private TaskReleaseDao taskReleaseDao;
	
	@Override
	public TaskReleaseEntity queryObject(Long releaseId){
		return taskReleaseDao.queryObject(releaseId);
	}
	
	@Override
	public List<TaskReleaseEntity> queryList(Map<String, Object> map){
		return taskReleaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return taskReleaseDao.queryTotal(map);
	}
	
	@Override
	public void save(TaskReleaseEntity taskRelease){
		taskReleaseDao.save(taskRelease);
	}
	
	@Override
	public void update(TaskReleaseEntity taskRelease){
		taskReleaseDao.update(taskRelease);
	}
	
	@Override
	public void delete(Long releaseId){
		taskReleaseDao.delete(releaseId);
	}
	
	@Override
	public void deleteBatch(Long[] releaseIds){
		taskReleaseDao.deleteBatch(releaseIds);
	}
	
}
