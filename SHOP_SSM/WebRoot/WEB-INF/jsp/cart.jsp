<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>我的购物车</title>
<%@ include file="/common/common.jsp"%>
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="/common/header.jsp" />
	<div class="container cart">
		<div class="span24">
			<div class="step step1"></div>
			<table>
				<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${cart.cartItems }" var="ci">
					<tr>
						<td width="60">
							<input type="hidden" name="id" value="22" />
							<img src="${pageContext.request.contextPath }/${ci.value.product.image}" />
						</td>
						<td><a target="_blank">${ci.value.product.pname}</a></td>
						<td>￥${ci.value.product.shopPrice}</td> 
						<td class="quantity" width="60">${ci.value.count}</td>
						<td width="140"><span class="subtotal">￥${ci.value.subtotal}</span></td>
						<td><a href="${ pageContext.request.contextPath }/cart/${ci.value.product.pid }/deleteCart.do" class="delete">删除</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em> <em> 登录后确认是否享有优惠 </em> 赠送积分: <em
					id="effectivePoint">${cart.total }</em> 商品金额: <strong id="effectivePrice">￥${cart.total }</strong>
			</div>
			<div class="bottom">
				<a href="${ pageContext.request.contextPath }/cart/clearCart.do" id="clear" class="clear">清空购物车</a> <a
					href="${pageContext.request.contextPath }/order/addOrder.do" id="submit" class="submit">提交订单</a>
			</div>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
