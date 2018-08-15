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

import com.migo.entity.BuyerAccountEntity;
import com.migo.service.BuyerAccountService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-15 22:14:37
 */
@RestController
@RequestMapping("buyeraccount")
public class BuyerAccountController {
	@Autowired
	private BuyerAccountService buyerAccountService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("buyeraccount:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BuyerAccountEntity> buyerAccountList = buyerAccountService.queryList(query);
		int total = buyerAccountService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(buyerAccountList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("buyeraccount:info")
	public R info(@PathVariable("id") Long id){
		BuyerAccountEntity buyerAccount = buyerAccountService.queryObject(id);
		
		return R.ok().put("buyerAccount", buyerAccount);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("buyeraccount:save")
	public R save(@RequestBody BuyerAccountEntity buyerAccount){
		buyerAccountService.save(buyerAccount);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("buyeraccount:update")
	public R update(@RequestBody BuyerAccountEntity buyerAccount){
		buyerAccountService.update(buyerAccount);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("buyeraccount:delete")
	public R delete(@RequestBody Long[] ids){
		buyerAccountService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
