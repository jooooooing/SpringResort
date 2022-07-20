<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>게시판 목록</h1>
		<table style="width: 700px; margin: auto">
			<tr>
				<th style="width: 10%">번호</th>
				<th style="width: 50%">제목</th>
				<th style="width: 15%">작성자</th>
				<th style="width: 15%">등록일</th>
				<th style="width: 10%">조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.seq}</td>
					<td style="text-align: left"><a
						href="getBoard?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.createDate}"
							pattern="yyyy-MM-dd"></fmt:formatDate></td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="insertBoard">새글 등록</a>
	</div>
</body>
</html>