<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
LocalDate date = LocalDate.now();
DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
String datetimeformated = datetimeformatter.format(date);
List<String> msgList = (ArrayList<String>) request.getAttribute("msgList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
<title>登録画面</title>
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<%
	if (request.getAttribute("msgList") != null) {
		for (String list : msgList) {
	%>
	<%=list%><br>
	<%
	}
	msgList.clear();
	%>
	<%
	}
	%>
	<form action="/recordInsert" method="GET">
		<table>
			<tr>
				<th>日付</th>
				<td><input type="text" name="date" value=<%=datetimeformated%>></td>
			</tr>
			<tr>
				<th>身長</th>
				<td><input type="text" name="height"></td>
				<td>cm</td>
			</tr>
			<tr>
				<th>体重</th>
				<td><input type="text" name="weight"></td>
				<td>kg</td>
			</tr>
			<tr>
				<th>体温</th>
				<td><input type="text" name="temp"></td>
				<td>℃</td>
			</tr>
			<tr>
				<th>備考</th>
				<td><textarea name="note" cols="20" rows="5"></textarea></td>
			</tr>
		</table>
		<button type="submit">登録</button>
	</form>
	<form action="/" method="GET">
		<input type="button" value="戻る" onclick="history.back()">
	</form>

</body>
</html>