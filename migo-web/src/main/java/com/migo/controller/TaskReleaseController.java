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

import com.migo.entity.TaskReleaseEntity;
import com.migo.service.TaskReleaseService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;


/**
 * 任务发布生效
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
@RestController
@RequestMapping("taskrelease")
public class TaskReleaseController {
	@Autowired
	private TaskReleaseService taskReleaseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("taskrelease:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TaskReleaseEntity> taskReleaseList = taskReleaseService.queryList(query);
		int total = taskReleaseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(taskReleaseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{releaseId}")
	@RequiresPermissions("taskrelease:info")
	public R info(@PathVariable("releaseId") Long releaseId){
		TaskReleaseEntity taskRelease = taskReleaseService.queryObject(releaseId);
		
		return R.ok().put("taskRelease", taskRelease);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("taskrelease:save")
	public R save(@RequestBody TaskReleaseEntity taskRelease){
		taskReleaseService.save(taskRelease);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("taskrelease:update")
	public R update(@RequestBody TaskReleaseEntity taskRelease){
		taskReleaseService.update(taskRelease);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("taskrelease:delete")
	public R delete(@RequestBody Long[] releaseIds){
		taskReleaseService.deleteBatch(releaseIds);
		
		return R.ok();
	}
	
}
