package com.migo.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品信息
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2018-07-14 15:10:58
 */
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品id
	private Long id;
	//商品名称
	private String productName;
	//联系人
	private String contacts;
	//连接地址
	private String productUrl;
	//主图
	private String productImage1;
	//手机图
	private String productImage2;
	//商品描述
	private String remark;
	//商品类型
	private String productType;
	//创建时间
	private Date createData;

	/**
	 * 设置：商品id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：商品id
	 */
	public Long getId() {
		return id;
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
	 * 设置：联系人
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	/**
	 * 获取：联系人
	 */
	public String getContacts() {
		return contacts;
	}
	/**
	 * 设置：连接地址
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	/**
	 * 获取：连接地址
	 */
	public String getProductUrl() {
		return productUrl;
	}
	/**
	 * 设置：主图
	 */
	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}
	/**
	 * 获取：主图
	 */
	public String getProductImage1() {
		return productImage1;
	}
	/**
	 * 设置：手机图
	 */
	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}
	/**
	 * 获取：手机图
	 */
	public String getProductImage2() {
		return productImage2;
	}
	/**
	 * 设置：商品描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：商品描述
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：商品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：商品类型
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateData(Date createData) {
		this.createData = createData;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateData() {
		return createData;
	}
}
