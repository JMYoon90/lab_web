<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring 2</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
		crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
	
		<header class="my-2 p-4 text-center text-bg-secondary">
			<h1>Spring MVC &amp; MyBatis</h1>
			<h2>회원 목록 페이지</h2>
		</header>
		
		<nav>
			<ul class="nav bg-light">
				<li class="nav-item">
					<c:url var="mainpage" value="/" />
					<a class="nav-link active" href="${ mainpage }">메인 페이지</a>
				</li>
				<li class="nav-item">
					<c:url var="createUser" value="/users/create" />
					<a class="nav-link active" href="${ createUser }">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link disabled" href="#">LINK 3</a>
				</li>
			</ul>
		</nav>
		
		<main>
			<div class="card my-2">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>사용자아이디</th>
							<th>이메일주소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${ userlist }" >
							<tr>
								<td>${ user.id }</td>
								<td>
								<c:url var="userDetail" value="/users/detail">
									<c:param name="id" value="${ user.id }"></c:param>
								</c:url>
								<a href="${ userDetail }">${ user.username }</a>
								</td>
								
								<td>${ user.email }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
</body>
</html>