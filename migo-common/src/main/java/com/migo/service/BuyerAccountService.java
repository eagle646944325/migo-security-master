package com.migo.service;

import com.migo.entity.BuyerAccountEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-15 22:14:37
 */
public interface BuyerAccountService {
	
	BuyerAccountEntity queryObject(Long id);
	
	List<BuyerAccountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BuyerAccountEntity buyerAccount);
	
	void update(BuyerAccountEntity buyerAccount);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
