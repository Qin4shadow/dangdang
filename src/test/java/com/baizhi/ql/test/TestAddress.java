package com.baizhi.ql.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.AddressDao;
import com.baizhi.ql.entity.Address;
import com.baizhi.ql.util.MybatisUtil;

public class TestAddress {
	
	//添加
	@Test
	public void testAdd(){
		
		AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
		addressDao.addOne(new Address("2","aa","北京2","123","123","123","88eadf6e-77bc-4013-ac54-ffc2f15c71f3"));
		MybatisUtil.commit();
	}
	//根据用户id查所有
	@Test
	public void testAll(){
		AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
		List<Address> checkAll = addressDao.checkAll("88eadf6e-77bc-4013-ac54-ffc2f15c71f3");
		for (Address address : checkAll) {
			System.out.println(address);
		}
	}
	//根据id查一个
	@Test
	public void testOne(){
		AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
		Address checkOne = addressDao.checkOne("1");
		System.out.println(checkOne);
	}
	//修改
	@Test
	public void testUpdate(){
		AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
		addressDao.update(new Address("2","bb","北京1","123","123","123","88eadf6e-77bc-4013-ac54-ffc2f15c71f3"));
		MybatisUtil.commit();
	}
}
