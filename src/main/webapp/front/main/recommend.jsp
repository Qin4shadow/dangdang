<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<!--编辑推荐图书开始-->
		<c:forEach items="${twoList }" var="li">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${path }/book/bookOne?id=${li.id}' target='_blank'>
					<img class="images" src="${path }/back/photo/${li.src}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${path }/book/bookOne?id=${li.id}' target='_blank' title='输赢'>${li.bookName }</a>
				</h3>
				<h4>
					作者：${li.author } 著
					<br />
					出版社：${li.company }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${li.publishTime }" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					简介${li.brief }
				</h5>
				<h6>
					定价：￥${li.price }&nbsp;&nbsp;
					当当价：￥${li.ddPrice }
					销量：<font color="red">${li.saleCount }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		<!--编辑推荐图书结束-->
	</div>
</div>
