<%@page import="board.BoardDAO"%>
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
		BoardDAO dao = new BoardDAO();
		dao.delete(request.getParameter("id"));
		response.sendRedirect("list.jsp");
	%>
	
</body>
</html>