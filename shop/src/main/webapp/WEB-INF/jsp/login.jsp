<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员登录</title>
<%@ include file="/common/common.jsp"%>
<style type="text/css" >
.tb{
	width:100%;
	margin:0;
	padding:5px 4px;
	border:1px solid #ccc;
	box-sizing:border-box;
}
</style>
</head>
<body>
	<jsp:include page="/common/header.jsp" />
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg"
					width="500" height="330" alt="会员登录" title="会员登录" />
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main easyui-panel">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN

					</div>
					<div align="center" style="color: red">
						
					</div>
					<sp:form id="loginForm" name="loginForm" method="post" commandName="user"  onsubmit="return checkValidator('loginForm')">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td>
										<sp:input path="username" cssClass="text easyui-validatebox tb" maxlength="20"  data-options="required:true,validType:'length[3,10]'"  />
									</td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td>
										<sp:password path="password" cssClass="text easyui-validatebox tb" maxlength="20" autocomplete="off" data-options="required:true" />
									</td>
								</tr>
								<tr>
									<th></th>
									<td align="left" style="color: red">
										<c:if test="${errors !=null && errors.size()>0 }">
											<c:forEach items="${errors }" var="err">
												${err.defaultMessage }
											</c:forEach>
										</c:if>
									</td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td>
									<label> 
										<input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true" />
											记住用户名 
									</label> <label> &nbsp;&nbsp;<a>找回密码</a> </label>
									</td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td>
										<input type="submit" class="submit" value="登 录"  />
									</td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a href="controller/register.do">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</sp:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>