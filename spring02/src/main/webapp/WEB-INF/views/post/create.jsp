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
				<%-- 로그인 정보가 있으면 로그아웃 페이지 추가 
				<c:if test="${ not empty signInUser }">
					<li>
						<span>${ signInUser }</span>
						<c:url var="signOutPage" value="/user/signout"></c:url>
						<a href="${ singOutPage }">로그아웃</a> 
					</li>
				</c:if>--%>
				<li>
					<c:url var="mainPage" value="/"></c:url>
					<a href="${ mainPage }">메인 페이지</a>
				</li>
				<li>
					<c:url var="postList" value="/post/list"></c:url>
					<a href=" ${ postList }">목록 페이지</a>
				</li>
			</ul>
		</nav>
		
		<main>
			<c:url var="postCreate" value="/postCreate" />
			<form action="${ postCreate }" method="post">
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