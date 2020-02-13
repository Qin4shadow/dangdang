package com.baizhi.ql.service;

import java.util.List;

import com.baizhi.ql.entity.Item;

public interface ItemService {
	//添加
	void insert();
	//根据订单id查一个
	List<Item> checkByOrder(String orderId);
}
