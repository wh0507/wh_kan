<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録一覧</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
			<th>日付</th>
			<td><form action="" name="">
					<select name="year">
						<option value="">年(直近５)</option>
						<option value="1900">1900</option>
						<option value="1901">1901</option>
						<option value="1902">1902</option>
						<option value="1903">1903</option>
						<option value="1904">1904</option>
					</select>年
				</form></td>
			<td><form action="" name="">
					<select name="month">
						<option value="">月</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>月
				</form></td>
			<td><form action="" name="">
					<select name="day">
						<option value="">日</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>日</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>身長</th>
			<td><input type="text"></td>
			<td>~</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<th>体重</th>
			<td><input type="text"></td>
			<td>~</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<th>体温</th>
			<td><input type="text"></td>
			<td>~</td>
			<td><input type="text"></td>
		</tr>
	</table>
	<div>
		<input type="checkbox"> <label for="checkbox">日付の古い順に表示する</label>
	</div>
	<form action="/" method="GET">
		<button type="submit">検索</button>
	</form>
	<table>
		<tr>
			<th>日付</th>
			<th>身長(cm)</th>
			<th>体重(kg)</th>
			<th>体温(°C)</th>
		</tr>
		<tr>
			<th><a href="/recordChange">2020/06/01</a></th>
			<th>163</th>
			<th>71</th>
			<th>36.5</th>
		</tr>
		<tr>
			<th>2020/06/02</th>
			<th>164</th>
			<th>72</th>
			<th>36.5</th>
		</tr>
		<tr>
			<th>2020/06/03</th>
			<th>165</th>
			<th>73</th>
			<th>36.5</th>
		</tr>
	</table>
	<form action="/recordInput" method="GET">
		<button type="submit">新規登録</button>
	</form>
	<form action="/" method="GET">
		<button type="submit">戻る</button>
	</form>
</body>
</html>