<%@page import="model.RecordBean"%>
<%@page import="java.util.*"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<RecordBean> lists = (ArrayList<RecordBean>) request.getAttribute("rcBean");
DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
String msgList = (String) request.getAttribute("msg");
if (msgList == null) {
	msgList = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
<title>記録詳細画面</title>
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div style="color: red;">
		<%=msgList%><br>
	</div>
	<%
	for (RecordBean list : lists) {
		String datetimeformated = datetimeformatter.format(list.getInputDate());
	%>
	<form action="/recordUpdate?id=<%=list.getId()%>" method="POST">
		<%-- <input type="hidden" name="id" value="<%= list.getId()%>"> --%>
		<div class="insert-table">
			<table>
				<tr>
					<th>日付</th>
					<td><%=datetimeformated%></td>
				</tr>
				<tr>
					<th>身長</th>
					<td><input type="text" name="height"
						value="<%=list.getHeight()%>"></td>
					<td>cm</td>
				</tr>
				<tr>
					<th>体重</th>
					<td><input type="text" name="weight"
						value="<%=list.getWeight()%>"></td>
					<td>kg</td>
				</tr>
				<tr>
					<th>体温</th>
					<td><input type="text" name="temp"
						value="<%=list.getTemperature()%>"></td>
					<td>℃</td>
				</tr>
				<tr>
					<th>備考</th>
					<td><textarea name="note" cols="20" rows="5"><%=list.getNote()%></textarea></td>
				</tr>
			</table>
		</div>
		<button type="submit">更新</button>
	</form>
	<form action="/recordDelete?id=<%=list.getId()%>" method="POST">
		<button type="submit">削除</button>
	</form>
	<%
	}
	%>
	<!-- 戻るボタン -->
	<form action="/recordList" method="GET">
		<input type="submit" value="戻る">
	</form>
</body>
</html>