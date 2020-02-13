package com.baizhi.ql.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 作用：MybatisUtil 工具类
 * 作者：張弨莮
 * 版本：1.0
 * 时间：2018-5-6上午9:00:02
 */
public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	private static final ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>(); 
	
	static{
		try {
			Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 返回sqlSession
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = t.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			t.set(sqlSession);
		}
		return sqlSession;
	}
	
	/**
	 * 关闭sqlSession
	 */
	public static void close(){
		SqlSession sqlSession = t.get();
		if(sqlSession!=null){
			sqlSession.close();
			t.remove();
		}
	}
	/**
	 * 提交事务
	 */
	public static void commit(){
		getSqlSession().commit();
		close();
	}
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		getSqlSession().rollback();
		close();
	}
}
