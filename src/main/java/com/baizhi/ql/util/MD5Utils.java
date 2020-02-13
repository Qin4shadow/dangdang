package com.baizhi.ql.util;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
 
public class MD5Utils {
	
	//参数1:输入明文密码  生成32 16进制数
	public static String getMd5Code(String password){
		StringBuilder sb = null;
		try {
			//创建加密对象
			//参数1: 算法名字
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//进行加密  返回加密之后结果也是字节
			byte[] digest = messageDigest.digest(password.getBytes());
			sb = new StringBuilder();
			for (byte b : digest) {
				//位运算
				int len = b & 0xff;    //0  0x0 0x1 0x2 0x3 0x4 0x9  10  0xa   15  0xf  16 0x10 170x11
				if(len<=15){
					sb.append("0");
				}
				sb.append(Integer.toHexString(len));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
		
	//生成随机的盐
	public static String getSalt(int n){
		char[] code =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(code[new Random().nextInt(code.length)]);
		}
		return sb.toString();
	}
	
	//测试
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String salt = getSalt(8);
		
		System.out.println(salt);
		
		
		String md5Code = getMd5Code("111111rAY5zyLr");
		System.out.println(md5Code);
		
		// 96e79218 965eb72c 92a549d d5a330112   111111
		
		//3761e75fba79ec69a4d259a9690750cb   111111 YcpLFCxo

		
		/**
		 * 注册  111111   
		 * 生成盐
		 * 111111 YcpLFCxo
		 * 存入密码   存入盐
		 * 3761e75fba79ec69a4d259a9690750cb 
		 * **/
		
		/**
		 * zzz     3761e75fba79ec69a4d259a9690750cb 
		 * 
		 * 登陆  zzz  111111   
		 * zzz   96e79218965eb72c92a549dd5a330112 
		 * 根据用户名取出用户数据
		 * 取出盐   YcpLFCxo 
		 * 将页面输入的密码拼接盐
		 * 111111 YcpLFCxo 
		 * 再进行MD5加密
		 * 3761e75fba79ec69a4d259a9690750cb 
		 * **/
		
		//测试spring框架封装的Md5 
		/*String md5DigestAsHex = DigestUtils.md5DigestAsHex("111111".getBytes());
		System.out.println(md5DigestAsHex);*/
	}
	
}

