package com.migo.service;

import com.migo.entity.TaskPriceEntity;

import java.util.List;
import java.util.Map;

/**
 * 任务商品价格表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public interface TaskPriceService {
	
	TaskPriceEntity queryObject(Long priceId);
	
	List<TaskPriceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TaskPriceEntity taskPrice);
	
	void update(TaskPriceEntity taskPrice);
	
	void delete(Long priceId);
	
	void deleteBatch(Long[] priceIds);
}
