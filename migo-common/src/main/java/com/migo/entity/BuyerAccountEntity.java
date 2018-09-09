package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-26 14:18:51
 */
public class BuyerAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//买家用户名
	private String buyerName;
	//买家账户号
	private String buyerAccount;
	//等级
	private String grade;
	//用户id
	private String userId;
	//图片1
	private String imageUrl1;
	//图片2
	private String imageUrl2;
	//状态 isf
	private String status;
	//创建时间
	private Date createTime;
	//备注
	private String remark;
	//账户类型
	private String accountType;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：买家用户名
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	/**
	 * 获取：买家用户名
	 */
	public String getBuyerName() {
		return buyerName;
	}
	/**
	 * 设置：买家账户号
	 */
	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}
	/**
	 * 获取：买家账户号
	 */
	public String getBuyerAccount() {
		return buyerAccount;
	}
	/**
	 * 设置：等级
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：等级
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：图片1
	 */
	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}
	/**
	 * 获取：图片1
	 */
	public String getImageUrl1() {
		return imageUrl1;
	}
	/**
	 * 设置：图片2
	 */
	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}
	/**
	 * 获取：图片2
	 */
	public String getImageUrl2() {
		return imageUrl2;
	}
	/**
	 * 设置：状态 isf
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 isf
	 */
	public String getStatus() {
		return status;
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
	 * 设置：账户类型
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：账户类型
	 */
	public String getAccountType() {
		return accountType;
	}
}
