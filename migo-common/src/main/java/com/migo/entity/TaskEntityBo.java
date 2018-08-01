package com.migo.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-01 14:46:07
 */
public class TaskEntityBo implements Serializable {
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
	//商品ID
	private String productId;
	//商品名称
	private String productName;
	//创建人ID
	private String createUserId;
	//创建人名称
	private String createUserName;

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
	/**
	 * 设置：商品ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：商品ID
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：商品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：创建人名称
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	/**
	 * 获取：创建人名称
	 */
	public String getCreateUserName() {
		return createUserName;
	}
}
