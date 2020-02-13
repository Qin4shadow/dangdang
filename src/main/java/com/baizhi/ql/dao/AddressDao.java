package com.baizhi.ql.dao;

import java.util.List;

import com.baizhi.ql.entity.Address;

public interface AddressDao {
	//添加
	void addOne(Address address);
	//根据用户id查所有
	List<Address> checkAll(String userId);
	//查一个
	Address checkOne(String id);
	//修改
	void update(Address address);
}
