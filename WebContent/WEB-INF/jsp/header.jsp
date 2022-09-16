<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String no = (String) request.getParameter("no");
int n1, n2, n3, n4 = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<nav aria-label="Breadcrumb" class="breadcrumb">
		<ul>
			<%
			if (no.equals("0")) {
			%>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<%
			}
			%>
			<%
			if (no.equals("1")) {
			%>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<%
			}
			%>
			<%
			if (no.equals("2")) {
			%>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<li><a href="/recordInput">記録入力</a></li>
			<%
			}
			%>
			<%
			if (no.equals("3")) {
			%>
			<li><a href="/mainMenu">メインメニュー</a></li>
			<li><a href="/recordList">記録一覧</a></li>
			<li><a href="/recordChange">記録詳細</a></li>
			<%
			}
			%>
		</ul>
</body>
</html>