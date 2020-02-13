package com.baizhi.ql.entity;

import java.util.Date;

public class Order {
	private String id;
	private String orderNumber;  //订单编号
	private Date orderTimes;     //订单时间
	private String addrUser;     //收货人
	private String addrName;     //收货地址
	private Double totalPrice;   //总价
	private String status;       //订单状态
	private String addrId;       //地址id
	private String userId;       //用户id
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderTimes() {
		return orderTimes;
	}

	public void setOrderTimes(Date orderTimes) {
		this.orderTimes = orderTimes;
	}

	public String getAddrUser() {
		return addrUser;
	}

	public void setAddrUser(String addrUser) {
		this.addrUser = addrUser;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddrId() {
		return addrId;
	}

	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber
				+ ", orderTimes=" + orderTimes + ", addrUser=" + addrUser
				+ ", addrName=" + addrName + ", totalPrice=" + totalPrice
				+ ", status=" + status + ", addrId=" + addrId + ", userId="
				+ userId + "]";
	}

	public Order(String id, String orderNumber, Date orderTimes,
			String addrUser, String addrName, Double totalPrice, String status,
			String addrId, String userId) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderTimes = orderTimes;
		this.addrUser = addrUser;
		this.addrName = addrName;
		this.totalPrice = totalPrice;
		this.status = status;
		this.addrId = addrId;
		this.userId = userId;
	}

	
	
}
