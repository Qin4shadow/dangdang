package com.baizhi.ql.service;

import java.util.List;

import com.baizhi.ql.entity.Order;

public interface OrderService {
	//添加
	void insert();
	//查所有
	List<Order> checkAll();
	//修改状态
	void update(Order order);
	//查一个
	Order checkOne(String id);
}
