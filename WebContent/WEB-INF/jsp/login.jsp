<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String msg = (String) request.getAttribute("msg");
String user_id = (String) session.getAttribute("userId");
String pass = (String) session.getAttribute("pass");
String else_msg = (String)session.getAttribute("msg");

if (msg == null) {
	msg = "";
}
if(else_msg == null){
	else_msg = "";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>アカウント情報を入力し、ログインしてください</p>
	<%=msg%>

	<%
	if (msg == null || msg == "") {
	%>
	<%=else_msg%>

	<form action="/loginCheck" method="post">
		<p>ユーザーID:</p>
		<input type="text" name="userId">
		<p>パスワード:</p>
		<input type="password" name="pass">
		<input type="submit"value="ログイン">
	</form>


	<%
	} else {
	%>

	<form action="/loginCheck" method="post">
		<p>ユーザーID:</p>
		<input type="text" name="userId" value = <%= user_id %>>
		<p>パスワード:</p>
		<input type="password" name="pass" value = <%= pass %>>
		<input type="submit"value="ログイン">
	</form>

	<%
	}
	%>


</body>
</html>