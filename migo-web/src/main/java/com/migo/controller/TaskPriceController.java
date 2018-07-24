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

import com.migo.entity.TaskPriceEntity;
import com.migo.service.TaskPriceService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 任务商品价格表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
@RestController
@RequestMapping("taskprice")
public class TaskPriceController {
	@Autowired
	private TaskPriceService taskPriceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("taskprice:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TaskPriceEntity> taskPriceList = taskPriceService.queryList(query);
		int total = taskPriceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(taskPriceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{priceId}")
	@RequiresPermissions("taskprice:info")
	public R info(@PathVariable("priceId") Long priceId){
		TaskPriceEntity taskPrice = taskPriceService.queryObject(priceId);
		
		return R.ok().put("taskPrice", taskPrice);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("taskprice:save")
	public R save(@RequestBody TaskPriceEntity taskPrice){
		taskPriceService.save(taskPrice);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("taskprice:update")
	public R update(@RequestBody TaskPriceEntity taskPrice){
		taskPriceService.update(taskPrice);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("taskprice:delete")
	public R delete(@RequestBody Long[] priceIds){
		taskPriceService.deleteBatch(priceIds);
		
		return R.ok();
	}
	
}
