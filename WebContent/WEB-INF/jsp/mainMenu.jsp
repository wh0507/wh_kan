<%-- <%@page import="model.RecordBean"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String user_name = (String)session.getAttribute("user_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>

	<form action="/logout" method="GET">
		<p><%=user_name%>さん <input type="submit" value="ログアウト"></p>
	</form>

	<form action="/recordList" method="POST">
		<button type="submit">記録一覧</button>
	</form>

	<form action="/userList" method="GET">
		<button type="submit">ユーザー一覧</button>
	</form>
</body>
</html>