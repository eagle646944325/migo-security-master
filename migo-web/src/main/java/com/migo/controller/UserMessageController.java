package com.migo.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.migo.entity.UserMessageEntity;
import com.migo.service.UserMessageService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 用户信息表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-13 21:50:33
 */
@RestController
@RequestMapping("usermessage")
public class UserMessageController {
	@Autowired
	private UserMessageService userMessageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("usermessage:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserMessageEntity> userMessageList = userMessageService.queryList(query);
		int total = userMessageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userMessageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("usermessage:info")
	public R info(@PathVariable("id") Long id){
		UserMessageEntity userMessage = userMessageService.queryObject(id);
		
		return R.ok().put("userMessage", userMessage);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("usermessage:save")
	public R save(@RequestBody UserMessageEntity userMessage){
		userMessageService.save(userMessage);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("usermessage:update")
	public R update(@RequestBody UserMessageEntity userMessage){
		userMessageService.update(userMessage);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("usermessage:delete")
	public R delete(@RequestBody Long[] ids){
		userMessageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
