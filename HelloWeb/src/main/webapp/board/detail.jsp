<%@page import="com.yedam.board.BoardVo"%>
<%@page import="com.yedam.common.Ydbrd"%>
<%@page import="com.yedam.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/detail.jsp</title>
</head>
<body>
	<! -- 글번호 한건 조회 / 조회한 정보 페이지 작성 --> 
	<%
 		String bid = request.getParameter("no");
 		int bno = Integer.parseInt(bid);
 		BoardDao dao = new BoardDao();
 		BoardVo brd = dao.search(bno);//단건 조회
 		
 		
 		//null인지 체크하고
 	%>
	<table border="1">
		<tr>
			<th>글번호</th>
			<td><%=brd.getNumber() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=brd.getTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=brd.getWriter() %></td>
		</tr>
		<tr>
			<td colspan="2"><textarea readonly rows="3" cols="30">
					<%=brd.getContent() %></textarea>
				
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button onclick ="location.href = 'modify.jsp?no=<%=brd.getNumber() %>'" >수정</button>
				<button onclick ="location.href = 'delete.jsp?no=<%=brd.getNumber() %>'">삭제</button>
			</td>
		</tr>
	</table>
	<br>
	<a href ="blist.jsp">목록으로</a>
</body>
</html>