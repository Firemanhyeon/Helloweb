<%@page import="com.yedam.board.BoardVo"%>
<%@page import="com.yedam.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/modify.jsp</title>
</head>
<body>
<!-- 글번호 기준으로 한건 조회 > 페이지 작성 > 저장버튼생성해서 저장버튼 누르면
 변경후에 목록으로 이동 -->
	<%
	String bid = request.getParameter("no");
	int bno = Integer.parseInt(bid);
	BoardDao dao = new BoardDao();
	BoardVo brd = dao.search(bno);

	%>
	<form action="../modify">
	<table border="1">
		<tr>
			<th>글번호</th>
			<td><input name="no" type = "text" readonly value = "<%=brd.getNumber()%>"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input name = "title" type = "text" value = "<%= brd.getTitle()%>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name = "writer" type = "text" readonly value = "<%=brd.getWriter()%>"></td>
		</tr>
		<tr>
			<td colspan="2"><input name = "content" type = "text" value = "<%=brd.getContent()%>"></td>
				
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type = "submit">저장</button>
			</td>
		</tr>
	</table>
</form>




</body>
</html>