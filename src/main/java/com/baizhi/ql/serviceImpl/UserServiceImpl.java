package com.baizhi.ql.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.dao.UserDao;
import com.baizhi.ql.entity.User;
import com.baizhi.ql.service.UserService;
import com.baizhi.ql.util.MD5Utils;
import com.baizhi.ql.util.MybatisUtil;

public class UserServiceImpl implements UserService {

	//前台:根据邮箱查一个，实现用户登陆
	@Override
	public String checkByEmail(User user) {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String message = null;
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			User loginUser = userDao.loginUser(user.getEmail());
			// 判断用户是否存在
			if (loginUser != null) {
				
				//判断该用户邮箱是否激活
				if(loginUser.getCode()==null){
					//没有激活  激活邮箱
					message="邮箱未激活";
				}else{
					// 判断密码
					//根据输入的密码生成MD5
					String md5Code = MD5Utils.getMd5Code(user.getPassword()+loginUser.getSalt());
					if (loginUser.getPassword().equals(md5Code)) {
						if(loginUser.getStatus()==1){
							message = "success";
							// 存储用户标记
							session.setAttribute("suser", loginUser);
						}else{
							message = "账户已冻结";
						}
					} else {
						message = "密码不正确";
					}
				}
				
				
			} else {
				message = "用户不存在";
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			MybatisUtil.close();
		}
	}

	//前台用户:注册
	@Override
	public String insertOne(User user,String clientCode) {
		try {
			//从session获取验证码
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			HttpSession session = ServletActionContext.getRequest().getSession();
			String code =(String) session.getAttribute("code");
			String message=null;
			//判断验证码
			if(clientCode.equals(code)){
				//验证邮箱是否已存在
				User loginUser = userDao.loginUser(user.getEmail());
				if(loginUser==null){
					//邮箱不存在   正常注册
					
					//添加id
					String uid = UUID.randomUUID().toString();
					user.setId(uid);
					//设定状态为0,验证邮箱后更改状态
					user.setStatus(0);
					//系统时间
					user.setRegistTime(new Date());
					//MD5加密
					//获取盐,存入user
					String salt = MD5Utils.getSalt(8);
					user.setSalt(salt);
					//密码拼接盐进行加密
					String md5Code = MD5Utils.getMd5Code(user.getPassword()+salt);
					//获取到的md5Code存入密码
					user.setPassword(md5Code);
					
					userDao.insertOne(user);
					
					//把user存入session，邮箱页进行显示时需要使用
					session.setAttribute("theUser", user);
					message="success";
				}else{
					//邮箱已存在  提示邮箱已存在    //登陆     判断邮箱是否激活  
					message="邮箱已存在，请直接登陆";
				}
				
			}else{
				message="验证码错误！";
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

	//前台用户:修改状态
	@Override
	public void updateOne(String code) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			User user = (User)session.getAttribute("theUser");
			user.setStatus(1);
			//添加激活码
			user.setCode(code);
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			userDao.updateOne(user);
			// 存储用户标记
			session.setAttribute("suser", user);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}
	//后台用户:查所有
	@Override
	public List<User> checkAll() {
		try {
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			List<User> checkAll = userDao.checkAll();
			return checkAll;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	//后台用户:修改状态
	@Override
	public void update(String id) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		try {
			User user = userDao.checkOne(id);
			if(user.getStatus()==0){
				user.setStatus(1);
			}else{
				user.setStatus(0);
			}
			userDao.updateOne(user);
			// 存储用户标记
			session.setAttribute("suser", user);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

}
