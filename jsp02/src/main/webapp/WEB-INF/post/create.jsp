<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 2</title>
</head>
<body>
	<div>
		<h1>포스트 새글 작성 페이지</h1>
		
		<nav>
			<ul>
				<li>
					<c:url var="mainPage" value="/"></c:url>
					<a href="${ mainPage }">메인 페이지</a>
				</li>
				<li>
					<c:url var="postlist" value="/post/list"></c:url>
					<a href="/jsp02/post">목록 페이지</a>
				</li>
			</ul>
		</nav>
		
		<main>
			<form method="post">
				<div>
					<input type="text" name="title" placeholder="제목" required autofocus />
				</div>
				<div>
					<textarea rows="5" cols="80" name="content" placeholder="내용" required></textarea>
				</div>
				<div>
					<input type="text" name="author" placeholder="작성자" required />
				</div>
				<div>
					<input type="submit" value="작성완료" />
				</div>
			</form>
		</main>
	</div>

</body>
</html>