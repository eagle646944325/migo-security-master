package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.ProductDao;
import com.migo.entity.ProductEntity;
import com.migo.service.ProductService;



@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductEntity queryObject(Long id){
		return productDao.queryObject(id);
	}
	
	@Override
	public List<ProductEntity> queryList(Map<String, Object> map){
		return productDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return productDao.queryTotal(map);
	}
	
	@Override
	public void save(ProductEntity product){
		productDao.save(product);
	}
	
	@Override
	public void update(ProductEntity product){
		productDao.update(product);
	}
	
	@Override
	public void delete(Long id){
		productDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		productDao.deleteBatch(ids);
	}
	
}
