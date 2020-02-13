package com.baizhi.ql.action;

import java.util.List;

import com.baizhi.ql.entity.Book;
import com.baizhi.ql.entity.Category;
import com.baizhi.ql.serviceImpl.BookServiceImpl;
import com.baizhi.ql.serviceImpl.CategoryServiceImpl;

public class CategoryAction {
	//查所有list
	private List<Category> list;
	//category用于添加,删除;前台点击分类浏览
	private Category category;
	//查所有一级
	private List<Category> checkFirst;
	//错误信息
	private String message;
	//前台:点击分类浏览 一级fid
	private String fid;
	//前台:点击分类浏览 二级sid
	private String sid;
	//前台:根据二级类别id查询对应的图书
	private List<Book> bookList;
	//前台:当前页数
	private Integer pageNum;
	//前台:总页数
	private Integer totalPage;
	
	
	//前台:点击分类浏览,分页查图书
	public String checkCategory2(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		category = impl.checkCategory(fid);
		BookServiceImpl impl2 = new BookServiceImpl();
		//每页行数
		Integer pageCount = 3;
		//总行数
		Integer checkCount = impl2.checkCount(fid, sid);
		if(checkCount%pageCount==0){
			totalPage=checkCount/pageCount;
		}else{
			totalPage=checkCount/pageCount+1;
		}
		bookList = impl2.checkByPage(fid, sid, pageNum, pageCount);
		return "checkCategory2S";
	}
	
	//前台:点击分类浏览,查图书
	public String checkCategory(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		category = impl.checkCategory(fid);
		BookServiceImpl impl2 = new BookServiceImpl();
		bookList = impl2.checkBySecond(fid, sid);
		return "checkCategoryS";
	}
	
	//查所有
	public String checkAll(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		list = impl.checkAll();
		return "checkSuccess";
	}
	
	//添加类别
	public String insertCate(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		impl.insertCate(category);
		return "insertS";
	}
	//查所有一级类别
	public String checkFirst(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		checkFirst = impl.checkFirst(1);
		return "checkFirstS";
	}
	//删除
	public String delete(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		message = impl.delete(category);
		return "deleteS";
	}
	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public List<Category> getCheckFirst() {
		return checkFirst;
	}

	public void setCheckFirst(List<Category> checkFirst) {
		this.checkFirst = checkFirst;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
