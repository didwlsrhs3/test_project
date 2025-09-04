<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello Home! - ${sessionScope.test}</h1>
	<a href="doA">doA GET</a> <br> <br>
	<form action="doA" method="post">
		<button>doA POST</button>
	</form>
	<hr>
	
	<h3>GET 방식으로 doB 요청</h3>
	<a href="doB">doB</a> <br>
	
	<h3>GET 방식으로 doC 요청</h3>
	<a href="doC">doC</a>
	
	<h3>GET 방식으로 doD 요청 - msg 파라미터 전달</h3>
	<a href="doD?msg=doDgetRequest">doD</a>
	
	<h3>POST 방식으로 doD 요청</h3>
	<form action="doD" method="post">
		상품이름 : <input type="text" name="name" required> <br>
		상품가격 : <input type="text" name="price" required> <br>
		<button type="submit">전송</button>
	</form>
	
	<h3>POST 방식으로 doE 요청</h3>
	<form action="doE" method="post">
		상품이름 : <input type="text" name="name" required> <br>
		상품가격 : <input type="text" name="price" required> <br>
		<button type="submit">전송</button>
	</form>
	
	<h3>POST 방식으로 doF 요청</h3>
	<form action="doF" method="post">
		상품이름 : <input type="text" name="name" required> <br>
		상품가격 : <input type="text" name="price" required> <br>
		<button type="submit">전송</button>
	</form>
	
	<h3>POST 방식으로 doG 요청</h3>
	<form action="doG" method="post">
		상품이름 : <input type="text" name="name" required> <br>
		상품가격 : <input type="text" name="price" required> <br>
		<button type="submit">전송</button>
	</form>
	
	
</body>
</html>
