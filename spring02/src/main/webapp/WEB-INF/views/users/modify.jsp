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
			<h2>회원 정보 수정 페이지</h2>
		</header>
		
		<nav>
			<ul class="nav bg-light">
				<li class="nav-item">
					<c:url var="mainPage" value="/" />
					<a class="nav-link active" href="${ mainPage }">메인 페이지</a>
				</li>
				<li class="nav-item">
					<c:url var="userListPage" value="/users/list" />
					<a class="nav-link active" href="${ userListPage }">목록 페이지</a>
				</li>
				<li class="nav-item">
					<c:url var="userModifyPage" value="/users/modify">
						<c:param name="id" value="${ user.id }"></c:param>
					</c:url>
					<a class="nav-link disabled" href="${ userModifyPage }">수정 페이지</a>
				</li>
			</ul>
		</nav>
		
		<main class="my-4">
			<div class="card">
				<div class="card-header"></div>
				<div class="card-body">
					<form id="formModify">
						<div class="my-2">
							<label for="id" class="form-label">번호</label>
							<input id="id" class="form-control"
								type="text" name="id" value="${ user.id }" readonly />
						</div>
						<div class="my-2">
							<label for="username" class="form-label">사용자 아이디</label>
							<input id="username"  class="form-control"
								type="text" name="username" value="${ user.username }" readonly />
						</div>
						<div class="my-2">
							<label for="password" class="form-label">비밀번호</label>
							<input id="password"  class="form-control"
								type="password" name="password" value="" required />
						</div>
						<div class="my-2">
							<label for="passwordconfirm" class="form-label">비밀번호확인</label>
							<input id="passwordconfirm"  class="form-control"
								type="password" name="passwordconfirm" value="" required />
						</div>
						<div class="my-2">
							<label for="email" class="form-label">email</label>
							<input id="email"  class="form-control"
								type="email" name="email" value="${ user.email }" required />
						</div>
						<div class="my-2">
							<button id="btnDelete" class="btn btn-danger">삭제</button>
							<button id="btnUpdate" class="btn btn-success">업데이트</button>
						</div>
					</form>
				</div>
			</div>
		
		</main>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<c:url var="userDeletePage" value="/users/delete" />
	<c:url var="userUpdatePage" value="/users/update" />
	<script>
	// HTML 문서 로딩이 모두 끝난 이후에 function을 실행.
		const form = document.querySelector('#formModify')
		
		const btnDelete = document.querySelector('#btnDelete');
	
		btnDelete.addEventListener('click', function (event) {
			event.preventDefault(); // 버튼의 이벤트 처리 기본 동작(폼 제출)을 막음.
			const result = confirm("삭제하시겠습니까?");
			if (result) {
				form.action = '${ userDeletePage }'; // EL
				form.method = 'post';
				form.submit(); // 폼 제출
			}
		}); 
	
		const btnUpdate = document.querySelector('#btnUpdate');
		btnUpdate.addEventListener('click', function (event) {
			event.preventDefault(); // 폼 버튼의 기본 동작(submit)을 막음.
			const result = confirm("수정하시겠습니까?");
			const password = document.querySelector('#password').value;
			const passwordconfirm = document.querySelector('#passwordconfirm').value;
			
			if (password == '' || passwordconfirm == '') {
				alert('비밀번호를 작성해 주세요.');
				return; // 이벤트 리스너 종료
			}
			if (password != passwordconfirm) {
				alert('비밀번호를 확인해 주세요.');
				return; // 이벤트 리스너 종료
			}
			if(result){
				form.action = '${ postUpdatePage }'; // submit (update)요청을 보낼 주소
				form.method = 'post'; // submit 요청 방식
				form.submit();
			}
		})
	</script>
</body>
</html>