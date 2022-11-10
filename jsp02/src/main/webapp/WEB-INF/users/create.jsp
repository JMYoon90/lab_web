<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 02</title>
</head>
<body>
	<div>
		<h1>회원가입 페이지</h1>
		
		<nav>
			<ul>
				<li>
					<c:url var="mainPage" value="/"></c:url>
					<a href="${ mainPage }">메인 페이지</a>
				</li>
				<li>
					<c:url var="userList" value="/users"></c:url>
					<a href="${ userList }">회원 목록</a>
				</li>
			</ul>
		</nav>
		<main>
			<form method="post">
				<div>
					<input type="text" name="username" placeholder="회원이름" required autofocus />
				</div>
				<div>
					<input type="password" name="password" placeholder="비밀번호" required />
				</div>
				<div>
					<input type="email" name="email" placeholder="E-메일" required />
				</div>
				<div>
					<input type="submit" value="작성완료" />
				</div>			
			</form>
		</main>
	</div>

</body>
</html>