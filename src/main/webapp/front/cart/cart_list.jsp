<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${path }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${path }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${path }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${path }/front/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" >
			function change(obj){
				var count = $("#"+obj).val();
				//正则表达式，只能填写正整数
				var r = /^\+?[1-9][0-9]*$/;
				if(r.test(count)){
					location.href="${pageContext.request.contextPath }/buycar/update?id="+obj+"&count="+count;
				}else{
					alert("请输入一个正整数！！！");
				}
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${path }/front/images/pic_myshopping.gif" />
		</div>
		
		<c:if test="${empty cars || totalPrice==0}">
		<div id="div_no_choice">
			<div class="choice_title"></div>
			<div class="no_select">
				您还没有挑选商品[<a href='${path }/book/main'> 继续挑选商品&gt;&gt;</a>]
			</div>
		</div>
		</c:if>
		<c:if test="${!empty cars && totalPrice!=0}">
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
                      <c:forEach items="${cars }" var="car">
                      <c:if test="${car.status=='1' }">
						<tr class='td_no_bord'>
							<td style='display: none'>
								${car.book.id }
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="${path }/book/bookOne?id=${book.id}">${car.book.bookName }</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">${car.book.price}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${car.book.ddPrice}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${car.number }
							</td>

							<td >
								<input class="del_num" id="${car.book.id}" type="text" size="3" maxlength="4"/>
								<a onclick="change('${car.book.id}')">变更</a>
							</td>
							<td>
								<a href="${path }/buycar/delete?id=${car.book.id}">删除</a>
							</td>
						</tr>
						</c:if>
						</c:forEach>
						
					<!-- 购物列表结束 -->
				</table>

				<div class="choice_balance">
					<div class="select_merch">
						<a href='${path }/book/main'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${sessionScope.savePrice}</span> </span>
							<span id='total_vip_economy' class='objhide'> 
								( 其中享有优惠： 
								<span class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) 
							</span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${sessionScope.totalPrice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${path }/front/order/order_info.jsp' > 
								<img src="${path }/front/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<!-- 用户删除恢复区 -->
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
			<c:forEach items="${cars }" var="car">
	        <c:if test="${car.status=='0' }">
				<tbody>
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">${car.book.bookName }</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${car.book.price }
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${car.book.ddPrice}</span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${path }/buycar/recover?id=${car.book.id}">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				</tbody>
			</c:if>
			</c:forEach>
			</table>
		</div>
		<!-- 用户删除恢复区结束 -->
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



