<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make It Clean!!</title>
	<script type="text/javascript" src="resources/JS/makeItClean.js"></script>
	<style type="text/css">
		div{
			margin-left: 40%;
			margin-right: 40%;
		}
	</style>
</head>

<body>
	<div>
		<h1>Make It Clean!!</h1>
		<p>Make all checkboxes unchecked</p>
		<p>Press 'reset' button to start</p>
		<%
			for(int i=0; i < 9; i++){
				if(i % 3 == 0){
					out.print("<br>");
					out.print("<input type='checkbox' onclick='clicked("+(i+1)+")' id='"+(i+1)+"'>");
				} else {
					out.print("<input type='checkbox' onclick='clicked("+(i+1)+")' id='"+(i+1)+"'>");
				}
			}
		%>
		<br>
		<input type="button" value="Reset" onclick="initialize()">
		<input type="button" value="Done" onclick="isClean()"><br>
		<p>made by moon</p>
	</div>
</body>
</html>