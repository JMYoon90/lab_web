<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homework</title>
</head>
<body>
	<h1> post 테이블 작성</h1>
	<form method="post">
		<input type="submit" value="리스트 확인하기" />
	</form>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${ post }">
				<tr>
					<td>${ c.id }</td>
					<td>${ c.title }</td>
					<td>${ c.content }</td>
					<td>${ c.createTime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>