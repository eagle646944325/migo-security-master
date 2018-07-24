package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务搜索条件
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public class TaskSearchEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//搜索ID
	private Long searchId;
	//流量入口
	private String flowType;
	//关键字
	private String keyWord;
	//数量
	private String number;
	//备注
	private String remark;
	//任务ID
	private String taskId;

	/**
	 * 设置：搜索ID
	 */
	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}
	/**
	 * 获取：搜索ID
	 */
	public Long getSearchId() {
		return searchId;
	}
	/**
	 * 设置：流量入口
	 */
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	/**
	 * 获取：流量入口
	 */
	public String getFlowType() {
		return flowType;
	}
	/**
	 * 设置：关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	/**
	 * 获取：关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 设置：数量
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：数量
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：任务ID
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取：任务ID
	 */
	public String getTaskId() {
		return taskId;
	}
}
