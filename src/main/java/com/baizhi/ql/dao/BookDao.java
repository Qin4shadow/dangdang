package com.baizhi.ql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.ql.entity.Book;

public interface BookDao {
	//后台:查所有
	List<Book> checkAll();
	//后台:根据id查一个
	Book checkOne(String id);
	//后台:删除
	void delete(String id);
	//后台:模糊查询
	List<Book> checkBy(@Param("term")String term,@Param("key")String key);
	//后台:添加
	void insert(Book book);
	//后台:修改
	void update(Book book);
	//前台:2.编辑推荐,随机生成2本书
	List<Book> checkTwo();
	//前台:3.热销图书8,销量没有不展示
	List<Book> checkHot();
	//前台:4.最新上架8,时间降序
	List<Book> checkNew();
	//前台:5.新书热卖8,只展示书名
	List<Book> checkHotBoard();
	//前台:根据id查一个包括所属类别
	Book checkOneCategory(String id);
	//前台:根据二级类别id查询对应的图书
	List<Book> checkBySecond(@Param("fid")String fid,@Param("sid")String sid);
	//前台:分页查
	List<Book> checkByPage(@Param("fid")String fid,@Param("sid")String sid,@Param("pageNum")Integer pageNum,@Param("pageCount")Integer pageCount);
	//前台:查所有行数
	Integer checkCount(@Param("fid")String fid,@Param("sid")String sid);
}
