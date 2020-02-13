package com.baizhi.ql.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.baizhi.ql.dao.BookDao;
import com.baizhi.ql.entity.Book;
import com.baizhi.ql.service.BookService;
import com.baizhi.ql.util.MybatisUtil;

public class BookServiceImpl implements BookService {

	@Override
	//查所有
	public List<Book> checkAll() {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> list = bookDao.checkAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//删除
	public void delete(String id) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			bookDao.delete(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	//条件查
	public List<Book> checkBy(String term,String key) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> checkBy = bookDao.checkBy("%"+term+"%",key);
			return checkBy;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	//查一个
	public Book checkOne(String id) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			Book book = bookDao.checkOne(id);
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//添加
	public void insert(Book book) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			String uid = UUID.randomUUID().toString();
			book.setId(uid);
			//给页面得不到的项设值
			book.setPublicCount(book.getPrintCount());
			book.seteRecommend(5);
			book.setSaleCount(0);
			bookDao.insert(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	//修改
	public void update(Book book) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			bookDao.update(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	//2.编辑推荐,随机生成2本书
	public List<Book> checkTwo() {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> list = bookDao.checkTwo();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//3.热销图书8,销量没有不展示
	public List<Book> checkHot() {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> list = bookDao.checkHot();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//4.最新上架8,时间降序
	public List<Book> checkNew() {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> list = bookDao.checkNew();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//5.新书热卖8,只展示书名
	public List<Book> checkHotBoard() {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> list = bookDao.checkHotBoard();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//根据id查一个包括所属类别
	public Book checkOneCategory(String id) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			Book book = bookDao.checkOneCategory(id);
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//前台:根据二级类别id查询对应的图书
	public List<Book> checkBySecond(String fid, String sid) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> checkBySecond = bookDao.checkBySecond(fid, sid);
			return checkBySecond;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//前台:分页查
	public List<Book> checkByPage(String fid, String sid, Integer pageNum,
			Integer pageCount) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			List<Book> checkByPage = bookDao.checkByPage(fid, sid, pageNum, pageCount);
			return checkByPage;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	//前台:查所有行数
	public Integer checkCount(String fid, String sid) {
		try {
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			Integer checkCount = bookDao.checkCount(fid, sid);
			return checkCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

}
