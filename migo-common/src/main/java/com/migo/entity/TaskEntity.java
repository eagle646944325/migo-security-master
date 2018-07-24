package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//任务ID
	private Long taskId;
	//任务类型
	private String taskType;
	//创建时间
	private Date createTime;
	//状态
	private String status;
	//快递类型
	private String expressType;

	/**
	 * 设置：任务ID
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取：任务ID
	 */
	public Long getTaskId() {
		return taskId;
	}
	/**
	 * 设置：任务类型
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * 获取：任务类型
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：快递类型
	 */
	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}
	/**
	 * 获取：快递类型
	 */
	public String getExpressType() {
		return expressType;
	}
}
