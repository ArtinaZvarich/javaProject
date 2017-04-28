<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Bags</h1>

	<c:forEach var="bag" items="${bags}">
	<a href="deleteBag/${bag.id}">delete</a>
		<br>
		<img src="${bag.bagImage}" alt="chota ne tak" width="110px" height="110px">
		<br>
		${bag.name}
		<br>
		${bag.element}
		<br>
		${bag.fabric}
		<br>
		${bag.color}
		<br>
		${bag.size}
		<br>
		${bag.collection}
		<br>
		${bag.price}
		<hr>
		
	</c:forEach>