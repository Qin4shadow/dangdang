<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	<!--新书热卖图书开始-->
	<c:forEach items="${hotBoardList }" var="li">
	<ul>
		<li>&nbsp;&nbsp;&nbsp;
			<a  target='_blank' href="${path }/book/bookOne?id=${li.id}">
				${li.bookName }
			</a>
		</li>
	</ul>
	</c:forEach>
	<!--新书热卖图书结束-->
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>