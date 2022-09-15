<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録詳細画面</title>
</head>
<body>
	<table>
		<tr>
			<th>日付</th>
			<td>　</td>
		</tr>
		<tr>
			<th>身長</th>
			<td><input type="text"></td>
			<td>cm</td>
		</tr>
		<tr>
			<th>体重</th>
			<td><input type="text"></td>
			<td>kg</td>
		</tr>
		<tr>
			<th>体温</th>
			<td><input type="text"></td>
			<td>℃</td>
		</tr>
		<tr>
			<th>備考</th>
			<td><textarea name="example2" cols="20" rows="5">サンプル</textarea></td>
		</tr>
	</table>
	<form action="/recordUpdate" method="POST">
		<button type="submit">更新</button>
	</form>
	<form action="/recordDelete" method="POST">
		<button type="submit">削除</button>
	</form>
	<form action="/" method="GET">
		<button type="submit">戻る</button>
	</form>

</body>
</html>