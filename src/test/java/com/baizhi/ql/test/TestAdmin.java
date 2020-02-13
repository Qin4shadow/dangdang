package com.baizhi.ql.test;

import org.junit.Test;

import com.baizhi.ql.dao.AdminDao;
import com.baizhi.ql.entity.Admin;
import com.baizhi.ql.util.MybatisUtil;

public class TestAdmin {
	
	//登陆
	@Test
	public void testAdminUsername(){
		
		AdminDao adminDao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
		Admin admin = adminDao.checkByUsername("admin");
		System.out.println(admin);
	}
}
