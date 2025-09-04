<!-- product.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
	<!-- 
		ProductVO product = (ProductVO)request.getAttribute("product")
		product.getNum();	// getter method를 이용해서 필드에 저장된 값 호출
	 -->
	 
	<h2>${product.num}</h2>
	<h2>${product.name}</h2>
	<h2>${product.price}</h2>
	<hr>
	<h3>productVO</h3>
	<h2>${product.num}</h2>
	<h2>${product.name}</h2>
	<h2>${product.price}</h2>
	
	<a href="main.home">home</a>
	
	<br>
	
	redirect home : <a href="redirect">home</a>
	
</body>
</html>



























