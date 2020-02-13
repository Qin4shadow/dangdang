package com.baizhi.ql.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.ql.dao.BookDao;
import com.baizhi.ql.entity.Book;
import com.baizhi.ql.util.MybatisUtil;

public class TestBook {
	
	//前台:查所有行数
	@Test
	public void checkCount(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		Integer checkCount = bookDao.checkCount("1","2");
		System.out.println(checkCount);
	}
	
	//前台:分页查
	@Test
	public void checkByPage(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkByPage = bookDao.checkByPage("1", null, 1, 3);
		for (Book book : checkByPage) {
			System.out.println(book);
		}
	}
	
	
	//前台:根据二级类别id查询对应的图书
	@Test
	public void checkBySecond(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkBySecond = bookDao.checkBySecond("1", null);
		for (Book book : checkBySecond) {
			System.out.println(book);
		}
	}
	
	
	//根据id查一个包括所属类别
	@Test
	public void TestCheckOneCategory(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		Book checkOneCategory = bookDao.checkOneCategory("101");
		System.out.println(checkOneCategory);
	}
	//5.新书热卖8,只展示书名
	@Test
	public void testCheckHotBoard(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkHotBoard = bookDao.checkHotBoard();
		for (Book book : checkHotBoard) {
			System.out.println(book);
		}
	}
	
	
	//4.最新上架8,时间降序
	@Test
	public void testCheckNew(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkNew = bookDao.checkNew();
		for (Book book : checkNew) {
			System.out.println(book);
		}
	}
	
	
	//3.热销图书8,销量没有不展示
	@Test
	public void testHot(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkHot = bookDao.checkHot();
		for (Book book : checkHot) {
			System.out.println(book);
		}
	}
	
	
	//2.编辑推荐,随机生成2本书
	@Test
	public void testTwo(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkTwo = bookDao.checkTwo();
		for (Book book : checkTwo) {
			System.out.println(book);
		}
	}
	
	//查所有
	@Test
	public void testBookAll(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkAll = bookDao.checkAll();
		for (Book book : checkAll) {
			System.out.println(book);
		}
	}
	//删除
	@Test
	public void testDelete(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		bookDao.delete("125");
		MybatisUtil.commit();
	}
	//模糊查
	@Test
	public void testCheckBy(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> checkBy = bookDao.checkBy("%薛%", "author");
		for (Book book : checkBy) {
			System.out.println(book);
		}
	}
	//查一个
	@Test
	public void testCheckOne(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		Book checkOne = bookDao.checkOne("101");
		System.out.println(checkOne);
	}
	//添加
	@Test
	public void testInsert(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		bookDao.insert(new Book("125", "计算机组成原理", "薛莹莹", 58.50, 39.50, "薛莹莹有限公司出版社",null, "132440", "15423", null, "13431", 0, "28", 5, "5.jpg",999,"5","4","4k","普通","硬纸","100","十分感人","计算机组成原理", "薛莹莹","目录信息","十分感人",null));
		MybatisUtil.commit();
	}
	//修改
	@Test
	public void testUpdate(){
		BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		bookDao.update(new Book("125", "计算机组成de原理", "薛a莹莹", 58.50, 39.50, "薛莹莹aa有限公司出版社",null, "132440", "15423", null, "13431", 0, "28", 5, "5.jpg",999,"5","4","4k","普通","硬纸","100","十分感人","计算机组成原理", "薛莹莹","目录信息","十分感人",null));
		MybatisUtil.commit();
	}
}
