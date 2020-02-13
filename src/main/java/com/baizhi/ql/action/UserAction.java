package com.baizhi.ql.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.User;
import com.baizhi.ql.serviceImpl.UserServiceImpl;
import com.baizhi.ql.util.ImageCodeUtil;
import com.baizhi.ql.util.MD5Utils;
import com.baizhi.ql.util.NetEasyMailUtil;

public class UserAction {
	
	//前台用户注册:获取输入的验证码
	private String clientCode;
	//前台用户:获取管理员user
	private User uuser;
	//前台用户:错误信息
	private String message;
	//前台用户:从页面获取输入的验证码,存储随机码
	private String inEmailCode;
	//后台用户:查所有
	private List<User> list;
	//后台用户:根据id查一个，修改状态
	private String id;
	
	//后台用户:查所有，更改状态
	public String checkAllUpdate(){
		UserServiceImpl impl = new UserServiceImpl();
		impl.update(id);
		return "checkAllUpdate";
	}
	
	//后台用户:查所有
	public String checkAll(){
		UserServiceImpl impl = new UserServiceImpl();
		list = impl.checkAll();
		return "checkAll";
	}
	
	//邮箱验证码的对比,更改状态
	public String emailTo(){
		String inEmailCode2 = (String)ServletActionContext.getRequest().getSession().getAttribute("inEmailCode");
		UserServiceImpl impl = new UserServiceImpl();
		if(inEmailCode2.equals(inEmailCode)){
			impl.updateOne(inEmailCode);
			return "registOk";
		}else{
			message="邮箱验证失败";
			return "email";
		}
	}
	
	//生成随机码
	public String random(){
		inEmailCode = MD5Utils.getSalt(6);
		
		//发送邮件
		User user = (User)ServletActionContext.getRequest().getSession(true).getAttribute("theUser");
		NetEasyMailUtil.getEmail(user.getEmail(), inEmailCode);
		
		ServletActionContext.getRequest().getSession().setAttribute("inEmailCode", inEmailCode);
		return "inEmailCode";
	}
	
	
	
	//前台用户:生成验证码
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
	
	//前台用户:注册
	public String insertOne(){
		UserServiceImpl impl = new UserServiceImpl();
		message = impl.insertOne(uuser,clientCode);
		if(message.equals("success")){
			return "insertOneSuccess";
		}else{
			return "insertOneError";
		}
	}
	
	//判断下订单登陆标记的方法
	public String loginCheck(){
		
		//获取session中的用户
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		//取出验证码
		User user = (User)session.getAttribute("suser");
		//判断用户是否存在
		if(user==null){
			//不存在  去登陆
			session.setAttribute("loginStatus", 1);
			return "loginCheck";
		}
		return "queryAddress";
	}
	
	//前台:根据邮箱查一个，实现用户登陆
	public String login(){
		UserServiceImpl impl = new UserServiceImpl();
		message = impl.checkByEmail(uuser);
		if(message.equals("success")){
			HttpSession session = ServletActionContext.getRequest().getSession();
			//取出订单强制登陆标识
			Integer loginStatus = (Integer)session.getAttribute("loginStatus");
			if(loginStatus!=null){
				return "queryAddress";
			}else{
				return "loginSuccess";
			}
		}else if(message.equals("邮箱未激活")){
			//激活邮箱  跳转到获取邮箱随机吗  
			return "emailError";
		}else{
			return "loginError";
		}
		
	}
	
	//前台:用户安全退出
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "logout";
	}

	

	
	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUuser() {
		return uuser;
	}

	public void setUuser(User uuser) {
		this.uuser = uuser;
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


	public String getInEmailCode() {
		return inEmailCode;
	}

	public void setInEmailCode(String inEmailCode) {
		this.inEmailCode = inEmailCode;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	
	
}
