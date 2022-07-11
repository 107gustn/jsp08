<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="board.BoardDAO" />
	<table border="1">
		<tr>
			<th>번호</th> <th>이름</th> <th>제목</th> <th>날짜</th> 
			<th>조회수</th> <th>groupId</th> <th>step</th> <th>indent</th> 
		</tr>
		<c:forEach var="dto" items="${dao.list() }">
			<tr>
				<td>${dto.id }</td> <td>${dto.name }</td>
				<td>
					<c:forEach begin="1" end="${dto.indent }">-></c:forEach>
					<a href="content_view.jsp?id=${dto.id }">${dto.title }</a>
				</td>
				<td>${dto.savedate }</td>
				<td>${dto.hit }</td> <td>${dto.idgroup }</td>
				<td>${dto.step }</td> <td>${dto.indent }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<a href="write_view.jsp">글쓰기</a>
			</td>
		</tr>
	</table>
</body>
</html>