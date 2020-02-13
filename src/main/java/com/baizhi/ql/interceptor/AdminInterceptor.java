package com.baizhi.ql.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AdminInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//1.获取登陆标记
		Admin admin =(Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
		
		//判断是否登录
		if(admin!=null){
			//否则 放行
			invocation.invoke();
		}
		//如果登陆标记为空   强制登陆
		return "adminLogin";
	}



}
