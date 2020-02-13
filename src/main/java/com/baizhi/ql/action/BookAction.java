package com.baizhi.ql.action;

import java.io.File;
import java.util.Date;
import java.util.List;



import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Book;
import com.baizhi.ql.entity.Category;
import com.baizhi.ql.serviceImpl.BookServiceImpl;
import com.baizhi.ql.serviceImpl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	//后台:查所有List,添加查二级类别
	private List<Book> list;
	//后台:删除id,前台查一个
	private String id;
	//后台:模糊查
	private String key;
	private String content;
	//后台:查一个book,修改;前台查一个
	private Book book;
	//后台:,添加查二级类别
	private List<Category> list2;
	//后台:接收上传的文件
	private File src;
	//后台:接收上传的文件名
	private String srcFileName;
	
	//1.前台:查询类别
	private List<Category> cateList;
	//2.前台:编辑推荐,随机生成2本书
	private List<Book> twoList;
	//3.前台:热销图书8,销量没有不展示
	private List<Book> hotList;
	//4.前台:最新上架8,时间降序
	private List<Book> newList;
	//5.前台:新书热卖8,只展示书名
	private List<Book> hotBoardList;
	
	
	
	
	//前台:根据id查一个包括所属类别
	public String bookOne(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.checkOneCategory(id);
		return "bookOne";
	}
	
	
	//前台:主页面main.jsp
	public String main(){
		BookServiceImpl impl = new BookServiceImpl();
		CategoryServiceImpl impl2 = new CategoryServiceImpl();
		cateList = impl2.checkCate();
		twoList = impl.checkTwo();
		hotList = impl.checkHot();
		newList = impl.checkNew();
		hotBoardList = impl.checkHotBoard();
		return "main";
	}
	
	//后台:查所有
	public String checkAll(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.checkAll();
		return "checkAllS";
	}
	
	//后台:删除
	public String delete(){
		BookServiceImpl impl = new BookServiceImpl();
		impl.delete(id);
		return "deleteS";
	}
	
	//后台:模糊查
	public String checkBy(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.checkBy(content,key);
		return "checkByS";
	}
	
	//后台:根据id查一个
	public String checkOne(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.checkOne(id);
		CategoryServiceImpl impl2 = new CategoryServiceImpl();
		list2 = impl2.checkFirst(2);
		return "checkOneS";
		
	}
	
	//后台:添加
	public String insert(){
		try {
		//一.文件上传
		//1.根据相对路径获取绝对路径   
		String realPath = ServletActionContext.getRequest().getRealPath("/back/photo");
		
		//2.判断文件夹是否存在
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdirs(); 
		}
		
		String newName=new Date().getTime()+"-"+srcFileName;
		
		//3.文件上传
		//参数: 上传的文件  ,(文件上传的目录,指定文件名)
		FileUtils.copyFile(src, new File(realPath,newName));
		//将图片路径放入图片对象中
		book.setSrc(newName);
		
		BookServiceImpl impl = new BookServiceImpl();
		impl.insert(book);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "insertS";
	}
	//后台:查二级类别
	public String insert2(){
		CategoryServiceImpl impl2 = new CategoryServiceImpl();
		list2 = impl2.checkFirst(2);
		return "insert2S";
	}
	//后台:修改
	public String update(){
		BookServiceImpl impl = new BookServiceImpl();
		
		//判断是否修改了图片
		if(src==null){
			//没有修改图片    不执行上传  只修改普通字段
			impl.update(book);
		}else{
			try {
				//一.文件上传
				//1.根据相对路径获取绝对路径   
				String realPath = ServletActionContext.getRequest().getRealPath("/back/photo");
				
				//2.判断文件夹是否存在
				File file = new File(realPath);
				if(!file.exists()){
					file.mkdirs(); 
				}
				
				String newName=new Date().getTime()+"-"+srcFileName;
				
				//3.文件上传
				//参数: 上传的文件  ,(文件上传的目录,指定文件名)
				FileUtils.copyFile(src, new File(realPath,newName));
				//将图片路径放入图片对象中
				book.setSrc(newName);
				
				impl.update(book);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return "updateS";
	}
	
	
	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Category> getList2() {
		return list2;
	}

	public void setList2(List<Category> list2) {
		this.list2 = list2;
	}

	public File getSrc() {
		return src;
	}

	public void setSrc(File src) {
		this.src = src;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public List<Book> getTwoList() {
		return twoList;
	}

	public void setTwoList(List<Book> twoList) {
		this.twoList = twoList;
	}

	public List<Book> getHotList() {
		return hotList;
	}

	public void setHotList(List<Book> hotList) {
		this.hotList = hotList;
	}

	public List<Book> getNewList() {
		return newList;
	}

	public void setNewList(List<Book> newList) {
		this.newList = newList;
	}

	public List<Book> getHotBoardList() {
		return hotBoardList;
	}

	public void setHotBoardList(List<Book> hotBoardList) {
		this.hotBoardList = hotBoardList;
	}

	public List<Category> getCateList() {
		return cateList;
	}

	public void setCateList(List<Category> cateList) {
		this.cateList = cateList;
	}

	
	
	
	
}
