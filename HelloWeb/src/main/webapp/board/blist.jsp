<%@page import="com.yedam.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/blist.jsp</title>
</head>
<body>
	<h3>게시판</h3>
	<table border='1'>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
			BoardDao dao = new BoardDao();
			List<BoardVo> list = dao.list();
			for (BoardVo brd : list) {
			%>
			<tr>
				<td><%=brd.getNumber()%></td>
				<td><a href = "detail.jsp?no=<%=brd.getNumber()%>"><%= brd.getTitle()%></a></td>
				<td><%=brd.getWriter()%></td>
				<td><%=brd.getCount()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>