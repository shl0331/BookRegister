<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>메 인 페 이 지</title>
</head>
<body>
	<h2>도서 관리</h2>
	<form action="main.do?action=BOOKVIEW" method = "post">
		<Input type = "submit" value = "도서 등록">
	</form>
	<p/>
	<form action="main.do?action=BOOKLIST" method = "post">
		<Input type = "submit" value = "도서 목록">
	</form>
	<p/>
	<form action="main.do?action=LOGOUT" method = "post">
		<Input type = "submit" value = "로그아웃">
	</form>
</body>
</html>