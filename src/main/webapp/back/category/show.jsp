<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
	<head>
		<link rel="stylesheet" href="${path}/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${path}/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${path }/cate/checkFirst'">添加二级类别&raquo;</div>
		</div>
		<span style="color:red" >${message}</span>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="li">
			<tr>
				<td>${li.id }</td>
				<td>${li.cateName }</td>
				<td>${li.category.cateName }</td>
				<td>${li.levels }</td>
				<td>
					<div class="button" onclick="location.href='${path}/cate/delete?category.id=${li.id}&category.levels=${li.levels}' ">删除 &raquo;</div>	
				</td>
			</tr>
			</c:forEach>
		</table><br/>
		
	</body>  
</html>



