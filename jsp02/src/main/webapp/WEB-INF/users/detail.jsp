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
	<div>
		<h1>회원 상세 정보</h1>
		
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
				<li>
					<c:url var="userModifyPage" value="/users/modify">
						<c:param name="id" value="${ user.id }"></c:param>
					</c:url>
					<a href="${ userModifyPage }">포스트 수정</a>
				</li>
			</ul>
		</nav>
		<main>
			<form>
				<div>
					<label for="id">번호</label>
					<input id="id" type="text" value="${ user.id }" readonly />
				</div>
				<div>
					<label for="username">사용자 아이디</label>
					<input id="username" type="text" value="${ user.username }" readonly />
				</div>
				<div>
					<label for="email">이메일</label>
					<input id="email" type="email" value= "${ user.email }" readonly />
				</div>
			
			</form>
		</main>
		
		
		
	</div>
</body>
</html>