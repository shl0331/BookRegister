<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.hansung.Project1.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서 등록 완료</title>
</head>
<body>
<h2>도서 등록 결과 화면</h2>
<p/>
<% Book b = (Book)request.getAttribute("Book"); %>
<table><tr><td>도서명: </td><td><%=b.getName()%></td></tr>
<tr><td>장르: </td><td><%=b.getGenre()%></td></tr>
<tr><td>날짜: </td><td><%=b.getDate()%></td></tr>
<tr><td>코드: </td><td><%=b.getCode()%></td></tr>
<tr><td>수: </td><td><%=b.getNumber()%></td></tr>
<tr><td>가격: </td><td><%=b.getPrice()%></td></tr>
<tr><td>출판사: </td><td><%=b.getPublisher()%></td></tr>
<tr><td>상태: </td><td><%=b.getState()%></td></tr>
<tr><td>대출: </td><td><%=b.getLending()%></td></tr>
</table>

<a href="main.do?action=MAIN">메인 화면</a>
<a href="main.do?action=BOOKLIST">도서 목록</a>
</body>
</html>