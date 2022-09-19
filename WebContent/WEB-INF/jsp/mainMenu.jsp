<%@page import="model.RecordBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<form action="/recordList" method="post">
		<button type="submit">記録一覧</button>
	</form>
</body>
</html>