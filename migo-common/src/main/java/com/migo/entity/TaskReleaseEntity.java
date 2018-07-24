package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务发布生效
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public class TaskReleaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long releaseId;
	//发布时间
	private Date releaseTime;
	//发布数量
	private String releaseNum;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//任务ID
	private String taskId;

	/**
	 * 设置：主键ID
	 */
	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getReleaseId() {
		return releaseId;
	}
	/**
	 * 设置：发布时间
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：发布数量
	 */
	public void setReleaseNum(String releaseNum) {
		this.releaseNum = releaseNum;
	}
	/**
	 * 获取：发布数量
	 */
	public String getReleaseNum() {
		return releaseNum;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
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
