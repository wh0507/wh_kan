<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userName = (String)session.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<%=userName%>さん
	<form action="/recordList" method="POST">
		<button type="submit">記録一覧</button>
	</form>
</body>
</html>