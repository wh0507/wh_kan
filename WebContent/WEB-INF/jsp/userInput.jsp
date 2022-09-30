<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String msg = (String)request.getAttribute("msg");
	String user_id = (String)session.getAttribute("user_id");
	String user_name = (String)session.getAttribute("user_name");
	String pass = (String)session.getAttribute("pass");

if(msg == null){
	msg = "";
}
%>

	<header>
		<%@ include file="header.jsp"%>
	</header>

	<form action="/logout" method="GET">
		<p><%=user_name%>さん <input type="submit" value="ログアウト">
		</p>
	</form>

	<%= msg %>
	<% if (msg == null || msg == "") {%>

	<form action="/userInsert" method="post">
		<table>
			<tr>
				<td>ユーザーID</td>
				<td><input type="text" name="user_id"></td>

			</tr>

			<tr>
				<td>ユーザー名</td>
				<td><input type="text" name="user_name"></td>

			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" name="pass"></td>

			</tr>

		</table>

		<input type="submit" value="登録">
	</form>

	<form action="/userInsert" method="get">
		<input type="submit" value="戻る">
	</form>

	<% } else {%>

	<form action="/userInsert" method="post">
		<table>
			<tr>
				<td>ユーザーID</td>
				<td><input type="text" name="user_id" value = <%=user_id %>></td>
				<td></td>

			</tr>

			<tr>
				<td>ユーザー名</td>
				<td><input type="text" name="user_name" value = <%=user_name %>></td>

			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" name="pass" value = <%=pass %> ></td>

			</tr>

		</table>

		<input type="submit" value="登録">
	</form>

	<form action="/userInsert" method="GET">
		<input type="submit" value="戻る">
	</form>
	<%
	}
	%>

</body>
</html>