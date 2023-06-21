<%@page import="com.yedam.board.BoardVo"%>
<%@page import="com.yedam.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/delete.jsp</title>
</head>
<body>
	<%
		String bid = request.getParameter("no");
		int bno = Integer.parseInt(bid);
		BoardDao dao = new BoardDao();
		boolean result = dao.delete(bno);//단건 조회

		response.sendRedirect("blist.jsp");//한건 삭제하고 다시 홈페이지로 돌아간다
		//null인지 체크하고
	%>
</body>
</html>