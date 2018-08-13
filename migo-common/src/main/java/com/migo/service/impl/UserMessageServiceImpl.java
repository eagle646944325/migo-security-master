package com.migo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.migo.dao.UserMessageDao;
import com.migo.entity.UserMessageEntity;
import com.migo.service.UserMessageService;



@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
	@Autowired
	private UserMessageDao userMessageDao;
	
	@Override
	public UserMessageEntity queryObject(Long id){
		return userMessageDao.queryObject(id);
	}
	
	@Override
	public List<UserMessageEntity> queryList(Map<String, Object> map){
		return userMessageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userMessageDao.queryTotal(map);
	}
	
	@Override
	public void save(UserMessageEntity userMessage){
		userMessageDao.save(userMessage);
	}
	
	@Override
	public void update(UserMessageEntity userMessage){
		userMessageDao.update(userMessage);
	}
	
	@Override
	public void delete(Long id){
		userMessageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		userMessageDao.deleteBatch(ids);
	}
	
}
