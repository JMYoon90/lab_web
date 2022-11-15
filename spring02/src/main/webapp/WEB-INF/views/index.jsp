<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring 2</title>
</head>
<body>

	<h1>메인 페이지</h1>


	<ul>
		<li>
			<c:url var="postlist" value="/post/list"></c:url>
			<a href="${ postlist }">포스트 목록</a>
		</li>
	</ul>
</body>
</html>