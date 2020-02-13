<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link href="${path }/front/css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> 
				<span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | 
					<a href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>| 
				</span> 
			</span>
			<div class="cart gray4012">
				<a href="${path }/buycar/showBuyCar">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好，欢迎光临当当网</b>
		<c:if test="${sessionScope.suser == null }">
		[&nbsp;<a href="${path }/front/user/login_form.jsp" class="b">登录</a>|
		<a href="${path }/front/user/register_form.jsp" class="b">注册</a>&nbsp;]
		</c:if>
		<c:if test="${sessionScope.suser != null }">
		[&nbsp;当前用户:${sessionScope.suser.nickName }&nbsp;]
		[&nbsp;<a href="${path }/duser/logout" class="b">登出</a>&nbsp;]
		</c:if>
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo">
				<a href="#" name="backtobook">
					<img src="${path }/front/images/booksaleimg/book_logo.gif" /> 
				</a> 
			</span>
		</div>
		<div class="head_head_list_right">
			<div class="head_head_list_right_b"></div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
