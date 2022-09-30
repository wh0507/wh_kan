<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String user_name = (String) session.getAttribute("user_name");
List<UserBean> list = (List<UserBean>) session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>

	<form action="/logout" method="GET">
		<p><%=user_name%>さん <input type="submit" value="ログアウト">
		</p>
	</form>

	<table>

		<tr>
			<td>ユーザーID</td>
			<td>ユーザー名</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<%
		UserBean uBean = (UserBean) list.get(i);
		%>

		<tr>
			<td><a href="/userChange?user_id=<%=uBean.getUser_id()%>"><%=uBean.getUser_id()%></a></td>
			<td><%=uBean.getUser_name()%></td>
		</tr>

		<%
		}
		%>

	</table>

	<form action="/userInput" method="POST">
		<input type="submit" value="新規登録">
	</form>

	<form action="/userList" method="POST">
		<input type="submit" value="戻る">
	</form>

</body>
</html>