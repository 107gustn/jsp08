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
	
	<jsp:useBean id="dao" class="board.BoardDAO"/>
	<c:set var="dto" value="${dao.getContent(param.id) }" />
	
	<form action="modify.jsp" method="post">
		<input type="hidden" name="id" value="${dto.id }"> <!-- hidden: 값은 들어오는데 화면에 보여주지는 않음 -->
		<table border="1">
			<tr>
				<td>번호</td> <td>${dto.id }</td>
			</tr>
			<tr>
				<td>조회수</td> <td>${dto.hit }</td>
			</tr>
			<tr>
				<td>이름</td> <td><input type="text" name="name" value="${dto.name }"></td>
			</tr>
			<tr>
				<td>제목</td> <td><input type="text" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<td>내용</td> <td><textarea name="content">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<a href="list.jsp">목록이동</a>
					<a href="delete.jsp?id=${dto.id }">삭제</a>
					<a href="reply_view.jsp?id=${dto.id }">답변</a>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>