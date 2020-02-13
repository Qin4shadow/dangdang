package com.baizhi.ql.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Admin;
import com.baizhi.ql.serviceImpl.AdminServiceImpl;
import com.baizhi.ql.util.ImageCodeUtil;

public class AdminAction {
	
	//后台:获取管理员admin
	private Admin admin;
	//后台:获取输入的验证码
	private String clientCode;
	//错误信息
	private String message;
	
	//验证码
	public String creatImage(){
		//1.获取验证码随机字符
		//String code = VerifyCodeUtil.generateVerifyCode(4);
		String code = ImageCodeUtil.getSecurityCode();
		System.out.println(code);
		//2.将验证码随机字符生成验证码图片
		//BufferedImage image = VerifyCodeUtil.getImage(255, 80, code);
		BufferedImage image = ImageCodeUtil.createImage(code);
		//往session中储存code
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("code", code);
		
		//设置响应格式
		ServletActionContext.getResponse().setContentType("image/png");
		try {
			//3.响应验证码图片
			ImageIO.write(image, "png", ServletActionContext.getResponse().getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//后台:管理员登陆
	public String login(){
		AdminServiceImpl impl = new AdminServiceImpl();
		message = impl.checkByUsername(admin,clientCode);
		
		if(message.equals("success")){
			return "loginSuccess";
		}else{
			return "loginError";
		}
	}
	
	//后台:管理员安全退出
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "logout";
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
