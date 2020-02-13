<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${hotList }" var="li">
	<div class="second_d_wai">
		<div class="img">
			<a href="${path }/book/bookOne?id=${li.id}" target='_blank'>
				<img class="images" src="${path }/back/photo/${li.src}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${path }/book/bookOne?id=${li.id}" target="_blank">${li.bookName }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${li.price }
		</div>
		<div class="price">
			当当价：￥${li.ddPrice }
		</div>
		<div class="price">
			销量：<font color="red">${li.saleCount }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>