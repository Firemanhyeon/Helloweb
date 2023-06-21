<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello World!!!</h3>
	<p>Java Server Page</p>
	<%
	String name = "홍규연";//꺽새 쓰면 자바코드 사용가능
	String age = "나이트로드" ;
	%>
	<h3>이름은 <%=name %></h3>
	<h3>직업은 <%=age %></h3>
</body>
</html>