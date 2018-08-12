package com.migo.service;

import com.migo.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-12 14:28:40
 */
public interface OrderService {
	
	OrderEntity queryObject(Long orderId);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(Long orderId);
	
	void deleteBatch(Long[] orderIds);
}
