<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head> -->
<body>
	<nav aria-label="Breadcrumb" class="breadcrumb">
		<ul>
			<!-- メインメニュー -->
			<% if (no == 0) { %>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<% } %>
			<!-- メインメニュー > 記録一覧 -->
			<% if (no==1) { %>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<% } %>
			<!-- メインメニュー > 記録一覧 > 記録入力 -->
			<% if (no==2) { %>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<li><a href="/recordInput">記録入力</a></li>
			<% } %>
			<!-- メインメニュー > 記録一覧 > 記録詳細 -->
			<% if (no==3) { %>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<li><a href="/recordChange">記録詳細</a></li>
			<% } %>
		</ul>
	</nav>
</body>
</html>