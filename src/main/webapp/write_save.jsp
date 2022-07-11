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
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		dao.insert(
				request.getParameter("name"),
				request.getParameter("title"),
				request.getParameter("content")
				);
		response.sendRedirect("list.jsp");
	%>
</body>
</html>