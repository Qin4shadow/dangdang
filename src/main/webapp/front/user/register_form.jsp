<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${path }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${path }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		//点击切换验证码
		function changeImage(){
			$("#imgVcode").prop("src","${path }/duser/creatImage?a="+ new Date().getTime());
		}
				
		//邮箱检查
		function checkEmail(){
			//邮箱验证的正则表达式		
			var email = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
			//判断输入的是否是正确的邮箱格式
			if(email.test($("#txtEmail").val())){
				$("#emailErr").prop("innerText","");
				return true;
			}else{
				$("#emailErr").prop("innerText","请输入正确的邮箱！！！");
				return false;
			}
				
		}
		//用户名检查
		function checkName(){
			//4到16位（字母，数字，下划线，减号）
			var name = /^[a-zA-Z]\w{3,15}$/;
			//判断输入的是否是正确的用户名
			if(name.test($("#txtNickName").val())){
				$("#nameErr").prop("innerText","");
				return true;
			}else{
				$("#nameErr").prop("innerText","请输入正确的昵称！！！");
				return false;
			}
		}
		//密码检查
		function checkPass(){
			//密码至少包含 数字和英文，长度6-20
			var pass = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
			//判断输入的是否是正确的密码
			if(pass.test($("#txtPassword").val())){
				$("#passwordErr").prop("innerText","");
				return true;
			}else{
				$("#passwordErr").prop("innerText","请输入正确的密码！！！");
				return false;
			}
		}
		//在次输入密码检查
		function checkPass1(){
			//判断第二次输入的密码是否与第一个相同
			if($("#txtPassword").val() == $("#txtPassword1").val()){
				$("#password1Err").prop("innerText","");
				return true;
			}else{
				$("#password1Err").prop("innerText","两次密码不同！！！");
				return false;
			}
			
		}
		//验证码验证
		function checkCode(){
			//判断验证码是否为空
			if($("#txtVerifyCode").val() == ""){
				$("#codeErr").prop("innerText","请输入验证码！！！");
				return false;
			}else{
				$("#codeErr").prop("innerText","");
				return true;
			}
		}
		//表单验证
		function checkForm(){
			if (checkEmail()==false | checkName()==false | checkPass()==false | checkPass1()==false | checkCode()== false){
				return false;
			}
			return true;
		}
			
	</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form onsubmit="return checkForm()" name="ctl00" method="post" action="${path }/duser/insertOne" id="f">
			<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="uuser.email" onblur="checkEmail()" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailErr" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="uuser.nickName" onblur="checkName()" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameErr" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="uuser.password" onblur="checkPass()" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordErr" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" onblur="checkPass2()" type="password" id="txtPassword1" class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1Err" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${path }/duser/creatImage" />
							<input name="clientCode" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<span id="codeErr" style="color:red"></span>
									<a href="javascript:changeImage()" id="changeImg">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

