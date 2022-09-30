<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    List<UserBean> list = (List<UserBean>) session.getAttribute("list_id");
    UserBean uBean = (UserBean) list.get(0);

    String msg = (String)request.getAttribute("msg");
    String user_id = (String)session.getAttribute("user_id");
	String user_name = (String)session.getAttribute("user_name");
	String pass = (String)session.getAttribute("pass");

    if(msg == null){
    	msg = "";
    }

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


	<%= msg %>

	<form action="/logout" method="GET">
		<p><%=user_name%>さん <input type="submit" value="ログアウト"></p>
	</form>


	<% if (msg == null || msg == "") {%>

	<form action="/userUpdate?user_id=<%=uBean.getUser_id()%>" method="POST">
		<table>
			<tr>
				<td>ユーザーID</td>
				<td><%=uBean.getUser_id()%></td>
			</tr>

			<tr>
				<td>ユーザー名</td>
				<td><input type="text" value=<%=uBean.getUser_name()%>
					name="user_name"></td>
			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" value=<%=uBean.getPass()%> name="pass"></td>
			</tr>

		</table>

		<input type="submit" value="更新">
	</form>

	<form action="/userDelete?user_id=<%=uBean.getUser_id()%>"
		method="post">
		<input type="submit" value="削除">
	</form>

	<form action="/userDelete" method="GET">
		<input type="submit" value="戻る">
	</form>

	<% } else {%>

	<form action="/userUpdate?user_id=<%=user_id%>" method="post">
		<table>
			<tr>
				<td>ユーザーID</td>
				<td><%=uBean.getUser_id()%></td>
			</tr>

			<tr>
				<td>ユーザー名</td>
				<td><input type="text" value=<%=user_name%>
					name="user_name"></td>
			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" value=<%=pass%> name="pass"></td>
			</tr>

		</table>

		<input type="submit" value="更新">
	</form>

	<form action="/s_arakawa/recordDelete?id=<%=uBean.getUser_id()%>"
		method="post">
		<input type="submit" value="削除">
	</form>

	<form action="/userDelete" method="GET">
		<input type="submit" value="戻る">
	</form>


	<%
	}
	%>




</body>
</html>