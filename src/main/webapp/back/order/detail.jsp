<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
    <title>order</title>
	<link rel="stylesheet" href="${path }/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
  </head>
  <body style="background-color: #f0f9fd;text-align: center">
  <div align=center style="font-size:25px">订单详细信息</div><hr/>
  	 <table bordercolor='#898E90' align='center' border='3px' cellpadding='5px' cellspacing="0px">
          <tr bgcolor="lightblue" align="center"> 
             <td>订单号：${orderDetail.id }</td>
             <td colspan="2">订单金额：¥：${orderDetail.totalPrice }</td>
             <td colspan="2">订单状态：${orderDetail.status }</td>
          </tr>
          	
          	<c:forEach items="${list }" var="li">
			<tr align='center'> 
				 <td>${li.bookName }</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src="${path }/back/photo/${li.bookSrc }"></td>
				 <td style="width: 180px;">单价：¥${li.price }</td>
				 <td style="width: 200px;">当当价：¥${li.price }</td>
				 <td style="width: 100px;">${li.count }本</td>
			</tr>
			</c:forEach>
			

          
     </table> 
	<input class="button btn-p" value="返回上级" onclick="history.go(-1);" style="margin-top: 10px"/>
  </body>
</html>
