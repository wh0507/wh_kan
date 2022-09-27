<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msgList = (String) request.getAttribute("msg");
if (msgList == null) {
	msgList = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	アカウント情報を入力し、ログインしてください。
	<label style="color: red;"> <%=msgList%><br>
	</label>
	<form action="/loginCheck" method="post">
		<table>
			<tr>
				<td>ユーザーID：</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>パスワード：</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>