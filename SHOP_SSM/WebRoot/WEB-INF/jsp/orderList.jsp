<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<%@ include file="/common/common.jsp"%>
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<jsp:include page="/common/header.jsp" />
	<div class="container cart">
		<div class="span24">
			<!-- <div class="step step1">
				<ul>
					<li class="current"></li>
					<li>我的订单</li>
				</ul>
			</div> -->

			<table>
				<tbody>
					<c:forEach items="${pager.list }" var="p">
						<tr>
							<th colspan="5">订单编号:${p.oid }&nbsp;&nbsp;&nbsp;&nbsp;订单金额:<font
								color="red">${p.total }
							</font>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
								<c:if test="${p.state ==1 }">
									<a href="${ pageContext.request.contextPath }/order/payOrder.do?oid=${p.oid }">付款</a>
								</c:if>
								<c:if test="${p.state ==2 }">
									已付款
								</c:if>
								<c:if test="${p.state ==3 }">
									<a href="${ pageContext.request.contextPath }/order/order_updateState.do?oid=${p.oid }">确认收货</a>
								</c:if>
								<c:if test="${p.state ==4 }">
									交易成功
								</c:if>
							</font>
							</th>
						</tr>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${p.orderItems }" var="orderItem">
							<tr>
								<td width="60"><img
									src="${ pageContext.request.contextPath }/${orderItem.product.image }" />
								</td>
								<td>${orderItem.product.pname }</td>
								<td>${orderItem.product.shopPrice }</td>
								<td class="quantity" width="60">
									${orderItem.count }
								</td>
								<td width="140"><span class="subtotal">￥
									${orderItem.subtotal }
								</span></td>
							</tr>
						</c:forEach>
					</c:forEach>
					<tr>
						<th colspan="5">
						<div class="pagination">
							<span>第${pager.currentPage}/${pager.pages}页 </span>
								<c:choose>
									<c:when test="${1 == pager.currentPage }">
										<span class="firstPage">&nbsp;</span>
										<span class="previousPage">&nbsp;</span>
									</c:when>
									<c:otherwise>
										<a class="firstPage"
											href="javascript: pageSkip(${pager.id },1,${pager.rowCount},'${pager.uri}');">&nbsp;</a>
										<a class="previousPage"
											href="javascript: pageSkip(${pager.id },${pager.currentPage-1},${pager.rowCount},'${pager.uri}');">&nbsp;</a>
									</c:otherwise>
								</c:choose>
							<c:forEach begin="1" end="${pager.pages }" var="page">
								<c:choose>
									<c:when test="${page == pager.currentPage }">
										<span class="currentPage">${page}</span>
									</c:when>
									<c:otherwise>
										<a
											href="javascript:pageSkip(${pager.id },${page},${pager.rowCount},'${pager.uri}');">${page
											}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${pager.pages <= pager.currentPage }">
									<span class="nextPage">&nbsp;</span>
									<span class="lastPage">&nbsp;</span>
								</c:when>
								<c:otherwise>
									<a class="nextPage"
										href="javascript: pageSkip(${pager.id },${pager.currentPage+1},${pager.rowCount},'${pager.uri}');">&nbsp;</a>
									<a class="lastPage"
										href="javascript: pageSkip(${pager.id },${pager.pages},${pager.rowCount},'${pager.uri}');">&nbsp;</a>
								</c:otherwise>
							</c:choose>
							</div>
							</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>