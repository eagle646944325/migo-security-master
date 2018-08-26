package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.TaskPriceDao;
import com.migo.entity.TaskPriceEntity;
import com.migo.service.TaskPriceService;



@Service("taskPriceService")
public class TaskPriceServiceImpl implements TaskPriceService {
	@Autowired
	private TaskPriceDao taskPriceDao;
	
	@Override
	public TaskPriceEntity queryObject(Long priceId){
		return taskPriceDao.queryObject(priceId);
	}
	
	@Override
	public List<TaskPriceEntity> queryList(Map<String, Object> map){
		return taskPriceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return taskPriceDao.queryTotal(map);
	}
	
	@Override
	public void save(TaskPriceEntity taskPrice){
		taskPriceDao.save(taskPrice);
	}
	
	@Override
	public void update(TaskPriceEntity taskPrice){
		taskPriceDao.update(taskPrice);
	}
	
	@Override
	public void delete(Long priceId){
		taskPriceDao.delete(priceId);
	}
	
	@Override
	public void deleteBatch(Long[] priceIds){
		taskPriceDao.deleteBatch(priceIds);
	}

	@Override
	public void saveBatch(List<TaskPriceEntity> list) {
		taskPriceDao.saveBatch(list);
	}

}
