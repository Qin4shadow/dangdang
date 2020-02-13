package com.baizhi.ql.entity;

import java.util.Date;

public class User {
	private String id;
	private String nickName;
	private String email;
	private String password;
	private Integer status;  //状态1为正常;状态0为冻结
	private Date registTime;
	private String salt;
	private String code;  //邮箱激活码
	
	//关系属性
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", email=" + email
				+ ", password=" + password + ", status=" + status
				+ ", registTime=" + registTime + ", salt=" + salt + ", code="
				+ code + "]";
	}

	public User(String id, String nickName, String email, String password,
			Integer status, Date registTime, String salt, String code) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.status = status;
		this.registTime = registTime;
		this.salt = salt;
		this.code = code;
	}

	
	
}
