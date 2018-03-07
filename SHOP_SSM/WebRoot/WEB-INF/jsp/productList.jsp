<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>产品列表</title>
<%@ include file="/common/common.jsp"%>
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function pageSkip(id,currentPage,rowCount,uri){
			var url="<%=basePath%>/product/"+id+"/"+currentPage+"/"+rowCount+"/"+uri;
			location.href=url;
		}
	</script>
</head>

<body>
	<jsp:include page="/common/header.jsp" />
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach items="${sessionScope.categoryategorys }" var="category">
					<dl>
						<dt>
							<a
								href="${ pageContext.request.contextPath }/product/${category.cid }/1/20/findProductListByCid.do">${category.cname
								} </a>
						</dt>
						<c:forEach items="${categoryseconds }" var="second">
							<dd>
								<c:if test="${second.cid == category.cid }">
									<a
										href="${ pageContext.request.contextPath }/product/${second.csid }/1/20/findProductListByCsid.do">${second.csname}
									</a>
								</c:if>
							</dd>
						</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>
		<div class="span18 last">
			<form id="productForm"
				action="./image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value=""> <input
					type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">

				<div id="result" class="result table clearfix">
					<ul>
						<c:forEach items="${pager.list }" var="p">
							<li><a href="${pageContext.request.contextPath }/product/${p.pid}/${pager.uri}"> <img
								src="${pageContext.request.contextPath }/${p.image}"
								width="170" height="170" style="display: inline-block;"> <span
								style='color:green'> ${p.pname } </span> <span class="price">
									商城价： ￥${p.shopPrice }</span> </a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="pagination">
					<span>当前第${pager.currentPage}页</span>
					<span>共${pager.pages}页</span>
					<c:choose>
						<c:when test="${1 == pager.currentPage }">
							<span class="firstPage">&nbsp;</span> 
							<span class="previousPage">&nbsp;</span>
						</c:when>
						<c:otherwise>
							<a class="firstPage" href="javascript: pageSkip(${pager.id },1,${pager.rowCount},'${pager.uri}');">&nbsp;</a> 
							<a class="previousPage" href="javascript: pageSkip(${pager.id },${pager.currentPage-1},${pager.rowCount},'${pager.uri}');">&nbsp;</a>
						</c:otherwise> 
					</c:choose>
					 <c:forEach begin="1" end="${pager.pages }" var="page" >
						<c:choose>
							<c:when test="${page == pager.currentPage }">
								<span class="currentPage">${page}</span>
							</c:when>
							<c:otherwise>
								<a href="javascript:pageSkip(${pager.id },${page},${pager.rowCount},'${pager.uri}');">${page }</a> 
							</c:otherwise>
						</c:choose>
					</c:forEach>  
					<c:choose>
						<c:when test="${pager.pages <= pager.currentPage }">
							<span class="nextPage">&nbsp;</span> 
							<span class="lastPage">&nbsp;</span>
						</c:when>
						<c:otherwise>
							<a class="nextPage"	href="javascript: pageSkip(${pager.id },${pager.currentPage+1},${pager.rowCount},'${pager.uri}');">&nbsp;</a> 
							<a class="lastPage" href="javascript: pageSkip(${pager.id },${pager.pages},${pager.rowCount},'${pager.uri}');">&nbsp;</a>
						</c:otherwise>
					</c:choose> 
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
