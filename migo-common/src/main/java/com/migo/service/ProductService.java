package com.migo.service;

import com.migo.entity.ProductEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品信息
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-14 15:10:58
 */
public interface ProductService {
	
	ProductEntity queryObject(Long id);
	
	List<ProductEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProductEntity product);
	
	void update(ProductEntity product);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
