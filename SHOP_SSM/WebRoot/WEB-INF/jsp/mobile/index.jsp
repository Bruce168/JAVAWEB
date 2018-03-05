<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>购物商城首页</title>
<%@ include file="/mobile/common/common.jsp"%>
</head>

<body>
	<header class="mui-bar mui-bar-nav" >
	<h1 class="mui-title">购物商城首页</h1>
	</header>
	<div class="mui-content">
		<div class="mui-slider">
			<div class="mui-slider-group mui-slider-loop">
				<!--支持循环，需要重复图片节点-->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="#"><img src="<%=basePath%>/mobile/images/4.jpg" /> </a>
				</div>
				<div class="mui-slider-item">
					<a href="#"><img src="<%=basePath%>/mobile/images/1.jpg" /> </a>
				</div>
				<div class="mui-slider-item">
					<a href="#"><img src="<%=basePath%>/mobile/images/2.jpg" /> </a>
				</div>
				<div class="mui-slider-item">
					<a href="#"><img src="<%=basePath%>/mobile/images/3.jpg" /> </a>
				</div>
				<div class="mui-slider-item">
					<a href="#"><img src="<%=basePath%>/mobile/images/4.jpg" /> </a>
				</div>
				<!--支持循环，需要重复图片节点-->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="#"><img src="<%=basePath%>/mobile/images/1.jpg" /> </a>
				</div>
			</div>
		</div>
	</div>
	<div class="mui-content">
		<ul class="mui-table-view mui-grid-view">
			<c:forEach items="${products_hot}" var="p">
				<li class="mui-table-view-cell mui-media mui-col-xs-6">
					<a target="_blank" href="${pageContext.request.contextPath}/product/${p.pid}/findProductById.do">
						<img class="mui-media-object" src="<%=basePath%>${p.image}"
						data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg"
						style="display: block;" />
						${p.pname}<br/>
						商城价：<font color="red">￥ ${p.shopPrice } 元</font>    
						参考价：<del>￥ ${p.marketPrice } 元</del>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<nav class="mui-bar mui-bar-tab"> <a
		class="mui-tab-item mui-active" href="index.html"> <span
		class="mui-icon mui-icon-home"></span> <span class="mui-tab-label">首页</span>
	</a> <a class="mui-tab-item" href="productList.html"> <span
		class="mui-icon mui-icon-list"></span> <span class="mui-tab-label">全部商品</span>
	</a> </nav>
	<script>
		mui(".mui-bar-tab").on('click', 'a', function() {
			//获取id
			var id = this.getAttribute("href");
			//打开新闻详情
			mui.openWindow({
				id : id,
				url : id
			});
		});
		//获得slider插件对象
		var gallery = mui('.mui-slider');
		gallery.slider({
			interval : 5000
		//自动轮播周期，若为0则不自动播放，默认为0；
		});
	</script>
</body>
</html>
