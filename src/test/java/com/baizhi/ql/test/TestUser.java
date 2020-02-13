package com.baizhi.ql.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.UserDao;
import com.baizhi.ql.entity.User;
import com.baizhi.ql.util.MybatisUtil;

public class TestUser {
	
	//前台:根据邮箱查一个，实现用户登陆
	@Test
	public void testUserEmail(){
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.loginUser("15236674712@163.com");
		System.out.println(user);
	}
	//前台用户:注册
	@Test
	public void testInsertOne(){
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		userDao.insertOne(new User("112", "小新", "123@163.com", "123456", 1, new Date(), "df44","aaas"));
		MybatisUtil.commit();
	}
	//前台用户:修改
	@Test
	public void testUpdateOne(){
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		userDao.updateOne(new User("112", "小新", "123@163.com", "123456", 1, new Date(), "df44","aaas"));
	}
	//前台用户:查所有
	@Test
	public void testCheckAll(){
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		List<User> checkAll = userDao.checkAll();
		for (User user : checkAll) {
			System.out.println(user);
		}
	}
	//后台用户:根据id查一个
	@Test
	public void testCheckOne(){
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.checkOne("111");
		System.out.println(user);
	}
}
