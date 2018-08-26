package com.migo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.migo.entity.*;
import com.migo.service.ProductService;
import com.migo.service.TaskPriceService;
import com.migo.service.TaskSearchService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.migo.service.TaskService;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
@RestController
@RequestMapping("task")
public class TaskController   extends AbstractController{
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TaskSearchService taskSearchService;
	@Autowired
	private TaskPriceService taskPriceService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("task:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TaskEntity> taskList = taskService.queryList(query);
		int total = taskService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(taskList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{taskId}")
	@RequiresPermissions("task:info")
	public R info(@PathVariable("taskId") Long taskId){
		TaskEntity task = taskService.queryObject(taskId);
		
		return R.ok().put("task", task);
	}
	/**
	 * 信息
	 */
	@RequestMapping("/productList")
	@RequiresPermissions("task:productList")
	public R productList(){
		SysUserEntity sysUserEntity=getUser();
		Map<String, Object> map=new HashMap<>();
		map.put("createUserId",sysUserEntity.getUserId());
		List<ProductEntity> productList = productService.queryList(map);

		return R.ok().put("productList", productList);
	}
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("task:save")
	@ResponseBody
	public R save(@RequestBody JSONObject obj){
		SysUserEntity sysUserEntity=getUser();
		TaskEntity task =(TaskEntity) JSONObject.toBean((JSONObject) obj.get("task"),TaskEntity.class);
		JSONArray taskSearchJson = JSONArray.fromObject(obj.get("tasksearchlist"));
		List<TaskSearchEntity> taskSearchEntity= (List<TaskSearchEntity>) JSONArray.toCollection(taskSearchJson, TaskSearchEntity.class);
		JSONArray taskPriceJson = JSONArray.fromObject(obj.get("taskPiceList"));
		List<TaskPriceEntity> taskPriceEntity= (List<TaskPriceEntity>) JSONArray.toCollection(taskPriceJson, TaskPriceEntity.class);

		task.setCreateUserId(sysUserEntity.getUserId() + "");
		task.setCreateUserName(sysUserEntity.getUsername());
		task.setCreateTime(new Date());
		long productId=Long.valueOf(task.getProductId());
		ProductEntity productEntity=productService.queryObject(productId);
		task.setProductName(productEntity.getProductName());

		for(int i = 0;i<taskSearchEntity.size();i++){
			taskSearchEntity.get(i).setTaskId(task.getTaskId().toString());
		}

		for(int i = 0;i<taskPriceEntity.size();i++){
			taskPriceEntity.get(i).setTaskId(task.getTaskId().toString());
		}
		taskService.save(task);
		taskSearchService.saveBatch(taskSearchEntity);
		taskPriceService.saveBatch(taskPriceEntity);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("task:update")
	public R update(@RequestBody TaskEntity task){
		taskService.update(task);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("task:delete")
	public R delete(@RequestBody Long[] taskIds){
		taskService.deleteBatch(taskIds);
		
		return R.ok();
	}
	
}
