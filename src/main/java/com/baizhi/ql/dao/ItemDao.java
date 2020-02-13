package com.baizhi.ql.dao;

import java.util.List;

import com.baizhi.ql.entity.Item;

public interface ItemDao {
	//添加
	void insert(Item item);
	//根据订单id查
	List<Item> checkByOrder(String orderId);
}
