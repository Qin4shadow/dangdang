package com.baizhi.ql.service;

import java.util.List;

import com.baizhi.ql.entity.Category;

public interface CategoryService {
	//后台:查所有
	List<Category> checkAll();
	//后台:删除类别 删除一级  删除二级 
	String delete(Category category);
	//后台:添加类别
	void insertCate(Category category);
	//后台:查所有一级类别
	List<Category> checkFirst(Integer levels);
	//1.前台:查询类别
	List<Category> checkCate();
	//前台:点击分类浏览
	Category checkCategory(String fid);
}
