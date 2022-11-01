<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP</title>
	<style>
		/* CSS 주석 */
	</style>
</head>
<body>
	<!-- HTML/XML 주석 -->
	<script>
	/* JavaScript 블록 주석 */
	// JavaScript 인라인 주석
	
	<%-- JSP 주석 --%>
	<%-- Servlet/JSP 동작 방식
	Servlet: Server + Applet 합성어. (웹 서버에서 실행되는, 요처을 처리하는 작은 프로그램).
	  - 웹 서버가 클라이언트로부터 요청을 받았을 때, 동적으로 HTML 문서를 생성하기 위한 기술.
	  - Java class로 작성.
	  - Servlet의 생성과, servlet 객체의 메서드 호출은 WAS가 담당.
	  - 최초 요청 -> Servlet 객체 생성 -> doGet/doPost 메서드를 호출 -> 응답
	  - 요청 -> 생성된 Servlet 객체의 doGet/doPost 메서드를 호출 -> 응답
	
	--%>
	
	</script>
	<% /* Java 블록 주석 */
	System.out.println("01_intro.jsp"); // Java 인라인 주석
	%>
	<h1>첫번째 JSP(Java Server Page)</h1>
	
	<% LocalDateTime now = LocalDateTime.now(); %>
	<h2>서버 시간: <%= now.toString() %></h2>
	
	
	
</body>
</html>