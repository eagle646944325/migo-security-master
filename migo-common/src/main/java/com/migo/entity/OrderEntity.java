package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-13 22:41:45
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//任务ID
	private Long orderId;
	//任务类型
	private String orderType;
	//创建时间
	private Date createTime;
	//商品价格
	private String goodsPrice;
	//快递费
	private String express;
	//型号
	private String model;
	//拍下件数
	private String number;
	//任务数量
	private String taskNumber;
	//任务ID
	private String taskId;
	//佣金
	private String commission;
	//审核状态I处理中S成功F失败
	private String auditStatus;
	//订单状态，1锁定,2已下单
	private String orderStatus;
	//
	private String buyUser;
	//
	private String orderNum;
	//
	private String sellerName;
	//
	private String taskType;

	/**
	 * 设置：任务ID
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：任务ID
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：任务类型
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：任务类型
	 */
	public String getOrderType() {
		return orderType;
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
	 * 设置：商品价格
	 */
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 获取：商品价格
	 */
	public String getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * 设置：快递费
	 */
	public void setExpress(String express) {
		this.express = express;
	}
	/**
	 * 获取：快递费
	 */
	public String getExpress() {
		return express;
	}
	/**
	 * 设置：型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：拍下件数
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：拍下件数
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：任务数量
	 */
	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	/**
	 * 获取：任务数量
	 */
	public String getTaskNumber() {
		return taskNumber;
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
	/**
	 * 设置：佣金
	 */
	public void setCommission(String commission) {
		this.commission = commission;
	}
	/**
	 * 获取：佣金
	 */
	public String getCommission() {
		return commission;
	}
	/**
	 * 设置：审核状态I处理中S成功F失败
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态I处理中S成功F失败
	 */
	public String getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：订单状态，1锁定,2已下单
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态，1锁定,2已下单
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：
	 */
	public void setBuyUser(String buyUser) {
		this.buyUser = buyUser;
	}
	/**
	 * 获取：
	 */
	public String getBuyUser() {
		return buyUser;
	}
	/**
	 * 设置：
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	/**
	 * 获取：
	 */
	public String getSellerName() {
		return sellerName;
	}
	/**
	 * 设置：
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * 获取：
	 */
	public String getTaskType() {
		return taskType;
	}
}
