<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>포스트 등록 페이지</h1>
	<form method="post">
		<div>
		<input type="number" name="id" placeholder="글번호" required autofocus /> 
		<!-- autofocus: 화면넘어오면 첫커서가 자동으로 가는곳. required: 반드시 입력받게 하는 옵션 -->
		</div>
		<div>
		<input type="text" name="title" placeholder="글 제목" required />
		</div>
		<div>
		<textarea name="content" placeholder="내용을 입력하세요" rows="10" required></textarea>
		</div>
		<div>
		<input type="datetime-local" name = "createTime" required />
		</div>
		<div>
		<input type="submit" value="등록" />
		</div>
	</form>

</body>
</html>