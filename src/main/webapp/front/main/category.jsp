<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<c:forEach items="${cateList }" var="li">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					<a href='${path }/cate/checkCategory2?fid=${li.id}&pageNum=1&sid='>${li.cateName }</a>
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<c:forEach items="${li.secList }" var="category">
						<li>
							<a href='${path }/cate/checkCategory2?fid=${li.id}&pageNum=1&sid=${category.id}'>${category.cateName }</a>
						</li>
						
						</c:forEach>
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			</c:forEach>
		<!--1级分类结束-->
		


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
