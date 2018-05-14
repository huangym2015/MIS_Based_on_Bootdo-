package com.bootdo.function.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Ian
 * @email XXX@163.com
 * @date 2018-05-08 22:41:02
 */
public class ApplyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long applyId;
	//
	private String applyName;
	//
	private String applyContent;
	//
	private Long userId;
	//用户名
	private String username;
	//
	private Long deptId;
	//邮箱
	private String email;
	//手机号
	private String mobile;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;

	/**
	 * 设置：
	 */
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	/**
	 * 获取：
	 */
	public Long getApplyId() {
		return applyId;
	}
	/**
	 * 设置：
	 */
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	/**
	 * 获取：
	 */
	public String getApplyName() {
		return applyName;
	}
	/**
	 * 设置：
	 */
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}
	/**
	 * 获取：
	 */
	public String getApplyContent() {
		return applyContent;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
