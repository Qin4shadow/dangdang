
package com.baizhi.ql.test;
 
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.apache.commons.lang3.RandomStringUtils;
 
/**
 * @Description
 *      username  为发送用户的登录账号
 *      password  为发送用户的登录密码
 */
public class testSinaMailUtil {
 
	//发送邮箱的邮箱名
	public static String username = "15010729294na@sina.com";
	//发送邮箱的授权码
	private static String password = "bda5a4355f71fc24-";
	
	//参数: 接收邮件的邮箱,接收邮件的邮件内容
	public static void sendMessage(String email,String message){
		
		//构建会话对象   包括会话类型   和 会话账号密码
		Properties props = System.getProperties();
		//设置主机类型
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
 
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}
		}); 
		session.setDebug(true);
		
		//构建 会话内容
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			//设置发送地址
			InternetAddress fromAddress = new InternetAddress(username);
			mimeMessage.setFrom(fromAddress);
 
			//设置接收人
			InternetAddress reciAddress = new InternetAddress(email);
			mimeMessage.setRecipient(RecipientType.TO, reciAddress);
			
			//设置邮件的头
			mimeMessage.setSubject("当当网验证码！");
			mimeMessage.setContent(message, "text/plain;charset=UTF-8");
			
			//构建连接	
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.sina.com",username, password);
			transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("send Message SuccessFul!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("send Message fail!");
			e.printStackTrace();
		} 
		
	}
	
	public static void getEmail(String email){
		
		//生成随机数的方法
    	String code = RandomStringUtils.random(6, "01234567890123456789");
    	System.out.println(code);
    	
    	//将邮件验证码存入session
    	
		String context="【当当网】您好，您当前正在进行当当网的注册，您的验证码为："+code+"。为了给您提供更好的服务，请您尽快完成注册。！";
		//参数    要接收邮件的邮箱 ,发送的内容
		sendMessage(email,context);	
	}
	
	public static void main(String[] args) {
		//620017
		//接收邮件的邮箱  任何邮箱都可以
		getEmail("944956645@qq.com");
	}
 
}
