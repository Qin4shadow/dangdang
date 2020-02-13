package com.baizhi.ql.serviceImpl;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.dao.AdminDao;
import com.baizhi.ql.entity.Admin;
import com.baizhi.ql.service.AdminService;
import com.baizhi.ql.util.MybatisUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public String checkByUsername(Admin admin,String clientCode) {
		try {
			//从session获取验证码
			HttpSession session = ServletActionContext.getRequest().getSession();
			String code =(String) session.getAttribute("code");
			String message=null;
			//判断验证码
			if(clientCode.equals(code)){
				AdminDao adminDao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
				Admin admin2 = adminDao.checkByUsername(admin.getUsername());
				//判断用户是否存在
				if(admin2 != null){
					//判断密码
					if(admin2.getPassword().equals(admin.getPassword())){
						message="success";
						//存储用户标记
						session.setAttribute("admin", admin);
					}else{
						message="密码不正确";
					}
					
				}else{
					message="用户不存在";
				}
				
			}else{
				message="验证码不正确";
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("登陆失败");
		}finally{
			MybatisUtil.close();
		}
	}

}
