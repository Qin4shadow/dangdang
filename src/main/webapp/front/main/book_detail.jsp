<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${path}/front/css/book_detail.css"/>
		<link href="${path}/front/css/public_footer.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".images").mouseover(function(e){
					//做一张新的图片
					var bigImage=$("<img id='bimg' src='"+$(this).attr("src")+"' />");
					
					//设置图片样式
					$(bigImage).css({
						"top":e.pageY+1,  //距顶部的距离
						"left":e.pageX+1,  //距左侧的距离
						"width":"300px",  //宽度
						"height":"500px",   //高度
						"position":"absolute",  //绝对定位
						"border":"5px solid #cad", //边框
						"border-radius":"100px"  //设置边框圆角
					});
					
					//将做好的图片放入body
					$("body").append(bigImage);	
				}).mouseout(function(){
					//移除图片
					$("#bimg").remove();
				}).mousemove(function(e){
					//设置图片样式
					$("#bimg").css({
						"top":e.pageY+1,  //距顶部的距离
						"left":e.pageX+1,  //距左侧的距离
						"width":"300px",  //宽度
						"height":"500px",   //高度
						"position":"absolute",  //绝对定位
						"border":"5px solid #cad", //边框
						"border-radius":"100px"  //设置边框圆角
					});
				});
				
			});
		</script>
	</head>
	<body>
		<br/>
		<div>
			<a href="${path }/book/main">回到首页</a>
			<h1>
				丛书名：${book.bookName }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img class="images" src="${path }/back/photo/${book.src}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.company }</td>
			</tr>
			<tr>
				<td>出版时间：<fmt:formatDate value="${book.publishTime }" pattern="yyyy-MM-dd"/> </td>
				<td>字数：${book.publicCount }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${book.pagination }</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${book.printTime }" pattern="yyyy-MM-dd"/></td>
				<td>开本：${book.format }</td>
			</tr>
			<tr>
				<td>印次：${book.impression }</td>
				<td>纸张：${book.paper }</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td>销量：<font color="red">${book.saleCount }</font></td>
			</tr>
			<tr>
				<td>所属类别：<font style='color: #cc3300'><strong>	${book.category.category.cateName }</strong>&gt;&gt;${book.category.cateName }</font>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${book.ddPrice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.price-book.ddPrice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${path }/buycar/addBuyCar?id=${book.id}">
						<img src='${path }/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>${book.recom }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>${book.brief }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>${book.aboutAuthor }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>${book.directory }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>${book.media }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${path}/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
