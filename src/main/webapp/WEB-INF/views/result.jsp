<!-- result.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>RESULT JSP PAGE</h3>
	<h2>request message : ${requestScope.message}</h2>
	<h2>msg : ${requestScope.msg}</h2>
	<h2>상품이름 : ${name}</h2>
	<h2>상품가격 : ${price}</h2>
	<a href="main.home">home</a>
</body>
</html>