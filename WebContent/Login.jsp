<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function click() {
 	var ob1=document.getElementById("user");
	var ob2=document.getElementById("pass");
	
	if(!(ob1.equals(admin))) {
		alert("아이디가 틀립니다");
		return;
	}
	
	if(!(ob2.equals(admin))) {
		alert("비밀번호가 다릅니다");
		return;
	} 
	LoginForm.submit();
}
</script>
<meta charset="utf-8">
<title>관리자 로그인</title>
</head>
<body>
	 <h2>관리자 로그인</h2>
	<p/>
	<form action="main.do?action=MAIN" name="LoginForm" method="post">
		<table>
			<tr>
				<th id="myid">ID: </th>
				<td><Input type="text" name="user" id="user" /></td>
			</tr>
			<tr>
				<th class="myclass">PW: </th>
				<td><Input type="password" name="pass" id="pass" /></td>
			</tr>
		</table>
		<p/>
		<Input type="button" value="로그인" onclick="click()"/>
	</form>
</body>
</html>