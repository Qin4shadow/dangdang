package com.baizhi.ql.dao;

import java.util.List;

import com.baizhi.ql.entity.Category;


public interface CategoryDao {
	//后台:查所有类别
	List<Category> checkAll();
	//后台:删除
	void deletOne(String id);
	//后台:添加类别
	void insertCate(Category category);
	//后台:查询某个一级类别下是否有二级类别，用于删除的判断
	Integer queryByCount(String id);
	//后台:查类别
	List<Category> checkFirst(Integer levels);
	//1.前台:查询类别
	List<Category> checkCate();
	//前台:点击分类浏览
	Category checkCategory(String fid);
}
