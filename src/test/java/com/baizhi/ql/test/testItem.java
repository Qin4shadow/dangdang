package com.baizhi.ql.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.ItemDao;
import com.baizhi.ql.entity.Item;
import com.baizhi.ql.util.MybatisUtil;

public class testItem {
	
	//添加
	@Test
	public void testAdd(){
		
		ItemDao itemDao = MybatisUtil.getSqlSession().getMapper(ItemDao.class);
		itemDao.insert(new Item("1", "a", "a", 11.11, 11, 11.11, "1", "1"));
		MybatisUtil.commit();
	}
	
	//根据订单id查
	@Test
	public void testcheckOne(){
		ItemDao itemDao = MybatisUtil.getSqlSession().getMapper(ItemDao.class);
		List<Item> checkByOrder = itemDao.checkByOrder("1");
		for (Item item : checkByOrder) {
			System.out.println(item);
		}
	}
	
}
