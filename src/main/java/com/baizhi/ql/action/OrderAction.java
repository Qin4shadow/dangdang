package com.baizhi.ql.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Order;
import com.baizhi.ql.serviceImpl.ItemServiceImpl;
import com.baizhi.ql.serviceImpl.OrderServiceImpl;

public class OrderAction {
	//后台:查所有list
	private List<Order> list;
	
	//修改支付状态
	public String update(){
		//获取order对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		Order order = (Order)session.getAttribute("order");
		
		OrderServiceImpl impl = new OrderServiceImpl();
		impl.update(order);
		
		//清空购物车
		session.removeAttribute("map");
		return "update";
	}
	
	//查所有
	public String checkAll(){
		OrderServiceImpl impl = new OrderServiceImpl();
		list = impl.checkAll();
		return "checkAll";
	}
	
	//添加到两个订单表
	public String add(){
		OrderServiceImpl impl = new OrderServiceImpl();
		impl.insert();
		ItemServiceImpl impl2 = new ItemServiceImpl();
		impl2.insert();
		
		return "add";
		
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	
	
}
