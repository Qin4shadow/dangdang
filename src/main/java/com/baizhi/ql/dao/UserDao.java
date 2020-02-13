package com.baizhi.ql.dao;

import java.util.List;

import com.baizhi.ql.entity.User;

public interface UserDao {
	//前台用户:根据邮箱查一个，实现用户登陆
	User loginUser(String email);
	//前台用户:注册
	void insertOne(User user);
	//前台用户:修改
	void updateOne(User user);
	//前台用户:查所有
	List<User> checkAll();
	//后台用户:根据id查一个
	User checkOne(String id);
}
