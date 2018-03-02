<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'common.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>



<link href="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/themes/icon.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/themes/default/easyui.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/jquery.min.js"  charset="utf-8" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/jquery.easyui.min.js"  charset="utf-8" ></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/jquery.easyui.mobile.js" ></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/easyloader.js"  ></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"  charset="utf-8"></script>

<script type="text/javascript" >
function submitForm(formName,u){
	var f='#'+formName;
	debugger;
	$(f).form({
		url:u,
		onSubmit:function(){
			debugger;
			return $(this).form('validate');
		},
		success:function(data){
			debugger;
			$.messager.alert('Info', data, 'info');
		}
	});
}
function checkValidator(formName){
	var f='#'+formName;
	debugger;
	var isValid = $(f).form('enableValidation').form('validate');
	return isValid;
}

function checkByParamForAJAX(paraName,checkWidgetName,url1,destWidgetName)
{
	var pName='+paraName+';
	var paraValue= $("#"+checkWidgetName).val();
	
    $.ajax(
    {
        url:"${pageContext.request.contextPath}/"+url1+"?time="+new Date().getTime()+"&"+paraName+"="+paraValue,
        type:"get",
        //data:{"username":paraValue},
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        success:function(data)
        {
            var jsons = data.message;
            $("#"+destWidgetName).html(jsons);
        }
    });
}

</script>
</head>

</html>
