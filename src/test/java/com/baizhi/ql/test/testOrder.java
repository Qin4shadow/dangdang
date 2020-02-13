package com.baizhi.ql.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.OrderDao;
import com.baizhi.ql.entity.Order;
import com.baizhi.ql.util.MybatisUtil;

public class testOrder {
	
	//添加
	@Test
	public void testAdd(){
		
		OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		orderDao.insert(new Order("1", "111", new Date(), "aaa", "aaaa", 11.11, "aaa", "aaa", "aaa"));
		MybatisUtil.commit();
	}
	//查所有
	@Test
	public void testAll(){
		OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> checkAll = orderDao.checkAll();
		for (Order order : checkAll) {
			System.out.println(order);
		}
	}
	//修改
	@Test
	public void testUpdate(){
		OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		orderDao.update(new Order("1", "2222", null, null, null, null, "已支付", null, null));
		MybatisUtil.commit();
	}
	
}
