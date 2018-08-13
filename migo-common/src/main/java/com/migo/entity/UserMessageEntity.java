package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户信息表
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-08-13 21:50:33
 */
public class UserMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//用户ID
	private Long userId;
	//昵称
	private String nickName;
	//头像
	private String nickImage;
	//用户类型
	private String userType;
	//用户状态
	private String userStatus;
	//用户审核状态
	private String auditStatus;
	//角色ID
	private String level;
	//姓名
	private String userName;
	//身份证号
	private String cardNum;

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
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：头像
	 */
	public void setNickImage(String nickImage) {
		this.nickImage = nickImage;
	}
	/**
	 * 获取：头像
	 */
	public String getNickImage() {
		return nickImage;
	}
	/**
	 * 设置：用户类型
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 设置：用户状态
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：用户状态
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：用户审核状态
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：用户审核状态
	 */
	public String getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：角色ID
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：角色ID
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：身份证号
	 */
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	/**
	 * 获取：身份证号
	 */
	public String getCardNum() {
		return cardNum;
	}
}
