package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.BuyerAccountDao;
import com.migo.entity.BuyerAccountEntity;
import com.migo.service.BuyerAccountService;



@Service("buyerAccountService")
public class BuyerAccountServiceImpl implements BuyerAccountService {
	@Autowired
	private BuyerAccountDao buyerAccountDao;
	
	@Override
	public BuyerAccountEntity queryObject(Long id){
		return buyerAccountDao.queryObject(id);
	}
	
	@Override
	public List<BuyerAccountEntity> queryList(Map<String, Object> map){
		return buyerAccountDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return buyerAccountDao.queryTotal(map);
	}
	
	@Override
	public void save(BuyerAccountEntity buyerAccount){
		buyerAccountDao.save(buyerAccount);
	}
	
	@Override
	public void update(BuyerAccountEntity buyerAccount){
		buyerAccountDao.update(buyerAccount);
	}
	
	@Override
	public void delete(Long id){
		buyerAccountDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		buyerAccountDao.deleteBatch(ids);
	}
	
}
