package com.baizhi.ql.serviceImpl;

import java.util.List;
import java.util.UUID;


import com.baizhi.ql.dao.CategoryDao;
import com.baizhi.ql.entity.Category;
import com.baizhi.ql.service.CategoryService;
import com.baizhi.ql.util.MybatisUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	//查所有
	public List<Category> checkAll() {
		try{
		CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
		List<Category> list = categoryDao.checkAll();
		return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	//删除
	public String delete(Category category) {
		String message=null;
		try {
			CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
			//判断删除的类别
			if(category.getLevels()==1){
				//一级类别  判断该一级下是否有二级类别
				//调用查询二级类别数量的方法
				Integer count = categoryDao.queryByCount(category.getId());
				//判断count
				if(count==0){
					//该一级类别下没有二级类别   直接删除
					categoryDao.deletOne(category.getId());
				}else{
					//该一级类别下有二级类别  展示错误信息  不能删除
					message="该一级类别下有二级类别不能删除";
				}
			}else{
				//二级类别   直接删除
				categoryDao.deletOne(category.getId());
			}
			MybatisUtil.commit();
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}	
	}

	@Override
	//添加类别
	public void insertCate(Category category) {
		try {
			CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
			//判断添加的类别
			if(category.getParentId()!=null){
				//添加的是二级类别
				category.setLevels(2);
			}else{
				//添加的是一级类别
				category.setLevels(1);
			}
			//手动给其它属性赋值
			String uid = UUID.randomUUID().toString();
			category.setId(uid);  //手动添加uuid
			category.setCount(0);
			categoryDao.insertCate(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	//查所有一级类别
	public List<Category> checkFirst(Integer levels) {
		try {
			CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
			List<Category> first = categoryDao.checkFirst(levels);
			MybatisUtil.commit();
			return first;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//1.前台:查询类别
	public List<Category> checkCate() {
		try {
			CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
			List<Category> list = categoryDao.checkCate();
			MybatisUtil.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//前台:点击分类浏览
	public Category checkCategory(String fid) {
		try {
			CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
			Category category = categoryDao.checkCategory(fid);
			MybatisUtil.commit();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}
	

}
