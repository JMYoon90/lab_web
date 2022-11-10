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
		<h1>회원정보 수정 페이지</h1>
		
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
					<c:url var="userModifyPage" value="/users/detail">
						<c:param name="id" value="${ user.id }"></c:param>
					</c:url>
					<a href=" ${ userModifyPage }">회원 상세정보</a>
				</li>
			</ul>
		</nav>
		
		<main>
			<form id="userForm">
				<div>
					<label for="id">번호</label>
					<input id="id" type="text" name="id" value="${ user.id }" readonly />
				</div>
				<div>
					<label for="username">사용자 아이디</label>
					<input id="username" type="text" name="username" value="${ user.username }" readonly />
				</div>
				<div>
					<label for="password1">비밀번호 변경</label>
					<input id="password1" type="password" name="password1" required />
				</div>
				<div>
					<label for="password2">비밀번호 변경 확인</label>
					<input id="password2" type="password" name="password2" required />
				</div>
				<div>
					<label for="email")>이메일</label>
					<input id="email" type="email" name="email" value="${ user.email }" required />
				</div>
				<div>
					<button id="btnDelete">삭제</button>
					<button id="btnUpdate">수정완료</button>
				</div>
			</form>
		</main>
	</div>
	
	
	<c:url var="userDeletePage" value="/users/delete"></c:url>
	<c:url var="userUpdatePage" value="/users/modify"></c:url>
	
	<script>
		const form = document.querySelector('#userForm');
		
		const btnDelete = document.querySelector('#btnDelete');
		
		btnDelete.addEventListener('click', function(event) {
			event.preventDefault(); 
			
			const check = confirm('삭제하시겠습니까?');
			if (check) {
				form.action = '${ userDeletePage }';
				form.method = 'post';
				form.submit();
			}
		});
		
		const btnUpdate = document.querySelector('#btnUpdate');
		
		btnUpdate.addEventListener('click', function(event){
			event.preventDefault();
			
			const password1 = document.querySelector('#password1').value;
			const password2 = document.querySelector('#password2').value;
			const email = document.querySelector('#email').value;
			if(password1 !== password2) {
				alert('비밀번호를 확인해 주세요.');
				return;
			} else if (password1 == '' || password2 == '' || email == '') {
				alert('정보 수정시 비밀번호와 이메일을 작성해주세요.')
				return;
			}
			const check = confirm('수정하시겠습니까?');
			if (check) {
				form.action = '${ userUpdatePage }'
				form.method = 'post';
				form.submit();
			}
		});
	
	</script>

</body>
</html>