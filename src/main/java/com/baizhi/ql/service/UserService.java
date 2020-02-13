package com.baizhi.ql.service;

import java.util.List;

import com.baizhi.ql.entity.User;

public interface UserService {
	//前台:根据邮箱查一个，实现用户登陆
	String checkByEmail(User user);
	//前台用户:注册
	String insertOne(User user,String clientCode);
	//前台用户:修改
	void updateOne(String code);
	//后台用户:查所有
	List<User> checkAll();
	//后台用户:修改
	void update(String id);
}
