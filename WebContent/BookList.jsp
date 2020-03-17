<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    info="description" session="true" import="java.util.ArrayList, com.hansung.Project1.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회 원 목 록</title>
</head>
<body>
<h2>회 원 목 록</h2>
<% ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list"); %>
<table>
<tr><th>도서명</th><th>들어온 날짜</th><th>CODE</th></tr>
<% for(Book b : list) { %>
	<tr>
		<td><a href="main.do?action=BOOKDETAIL&name=<%=b.getName() %>"><%=b.getName() %></a></td>
		<td><%=b.getDate() %></td>
		<td><%=b.getCode() %>
	</td>
<% } %>
</table>
</body>
</html>