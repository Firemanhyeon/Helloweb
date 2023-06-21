<%@page import="com.yedam.common.Ydbrd"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.common.YdBrdDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		YdBrdDao dao = new YdBrdDao();
		List<Ydbrd> list = dao.list();
		for(Ydbrd vo : list){
		
	%>
		<li>제목: <%=vo.getTitle() %></li>		
		
	<%
		}
	%>	
	</ul>
	<a href = "second">second servlet</a>
</body>
</html>