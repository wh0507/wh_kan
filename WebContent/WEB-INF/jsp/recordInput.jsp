<%@page import="java.util.ArrayList"%>
<%@page import="model.RecordBean"%>
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
String msgList = (String) request.getAttribute("msg");
if (msgList == null) {
	msgList = "";
}
String height = request.getParameter("height");
String weight = request.getParameter("weight");
String temp = request.getParameter("temp");
String note = request.getParameter("note");
if (height == null) {
	height = ""; weight = ""; temp = ""; note = "";
}
%>

<%-- ユーザー名取得のため追加（arakawa） --%>
<%String user_name = (String)session.getAttribute("user_name"); %>
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

	<!-- 追加（arakawa）-->
	<form action="/logout" method="GET">
		<p><%=user_name%>さん <input type="submit" value="ログアウト"></p>
	</form>

	<div class="message">
		<%=msgList%><br>
	</div>
	<form action="/recordInsert" method="GET">
		<div class="insert-table">
			<table>
				<tr>
					<th>日付</th>
					<td><input type="text" name="date" value=<%=datetimeformated%>></td>
				</tr>
				<tr>
					<th>身長</th>
					<td><input type="text" name="height" value="<%=height%>"></td>

					<td>cm</td>
				</tr>
				<tr>
					<th>体重</th>
					<td><input type="text" name="weight" value="<%=weight%>"></td>
					<td>kg</td>
				</tr>
				<tr>
					<th>体温</th>
					<td><input type="text" name="temp" value="<%=temp%>"></td>
					<td>℃</td>
				</tr>
				<tr>
					<th>備考</th>
					<td><textarea name="note" cols="20" rows="5"><%=note%></textarea></td>
				</tr>
			</table>
		</div>
		<!-- 登録ボタン -->
		<button type="submit">登録</button>
	</form>
	<!-- 戻るボタン -->
	<form action="/recordList" method="GET">
		<input type="submit" value="戻る">
	</form>
</body>
</html>