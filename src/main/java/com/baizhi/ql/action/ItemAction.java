package com.baizhi.ql.action;

import java.util.List;

import com.baizhi.ql.entity.Item;
import com.baizhi.ql.entity.Order;
import com.baizhi.ql.serviceImpl.ItemServiceImpl;
import com.baizhi.ql.serviceImpl.OrderServiceImpl;

public class ItemAction {
	//后台:orderId
	private String orderId;
	//后台:根据订单id查
	private List<Item> list;
	//后台:根据订单id查订单
	private Order orderDetail;
	
	//根据订单id查图书，查order对象
	public String checkByOrder(){
		ItemServiceImpl impl = new ItemServiceImpl();
		list = impl.checkByOrder(orderId);
		OrderServiceImpl impl2 = new OrderServiceImpl();
		orderDetail = impl2.checkOne(orderId);
		return "checkByOrder";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public Order getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Order orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	
}
