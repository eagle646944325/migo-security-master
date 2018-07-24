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

import com.migo.entity.TaskSearchEntity;
import com.migo.service.TaskSearchService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 任务搜索条件
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
@RestController
@RequestMapping("tasksearch")
public class TaskSearchController {
	@Autowired
	private TaskSearchService taskSearchService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tasksearch:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TaskSearchEntity> taskSearchList = taskSearchService.queryList(query);
		int total = taskSearchService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(taskSearchList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{searchId}")
	@RequiresPermissions("tasksearch:info")
	public R info(@PathVariable("searchId") Long searchId){
		TaskSearchEntity taskSearch = taskSearchService.queryObject(searchId);
		
		return R.ok().put("taskSearch", taskSearch);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tasksearch:save")
	public R save(@RequestBody TaskSearchEntity taskSearch){
		taskSearchService.save(taskSearch);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tasksearch:update")
	public R update(@RequestBody TaskSearchEntity taskSearch){
		taskSearchService.update(taskSearch);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tasksearch:delete")
	public R delete(@RequestBody Long[] searchIds){
		taskSearchService.deleteBatch(searchIds);
		
		return R.ok();
	}
	
}
