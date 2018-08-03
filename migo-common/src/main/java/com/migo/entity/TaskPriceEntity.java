package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务商品价格表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-24 11:36:01
 */
public class TaskPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//价格ID
	private Long priceId;
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

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	private String commission;
	/**
	 * 设置：价格I
	 */
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	/**
	 * 获取：价格ID
	 */
	public Long getPriceId() {
		return priceId;
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
}
