package com.baizhi.ql.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.CategoryDao;
import com.baizhi.ql.entity.Category;
import com.baizhi.ql.util.MybatisUtil;

public class TestCategory {
	
	//登陆
	@Test
	public void testCheckAll(){
		CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
//		List<Category> list = categoryDao.checkAll();
		List<Category> list = categoryDao.checkFirst(1);
		for (Category li : list) {
			System.out.println(li);
		}
	}
	//查所有一级
	@Test
	public void testFirst(){
		CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
		List<Category> checkFirst = categoryDao.checkFirst(1);
		for (Category cf : checkFirst) {
			System.out.println(cf);
		}
	}
	
	//前台:查询类别
	@Test
	public void checkCate(){
		CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
		List<Category> checkFirst = categoryDao.checkCate();
		for (Category cf : checkFirst) {
			System.out.println(cf);
		}
	}
	
	//前台:点击分类浏览
	@Test
	public void checkCategory(){
		CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
		Category category = categoryDao.checkCategory("1");
		System.out.println(category);
	}

}