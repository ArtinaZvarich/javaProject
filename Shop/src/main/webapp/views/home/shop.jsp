<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<link rel="stylesheet" href="css/shop.css">

<h1>Bags</h1>
<div class = "content">
	<c:forEach var="bag" items="${bags}">
	<sec:authorize access="!isAuthenticated()">
	<a href="index">Login or register to make a purchase!</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="buyBag/${bag.id}"><font size="4" color="red" face="fantasy"><b>BUY NOW</b></font></a>
	</sec:authorize>
		<br>
		<br>
		<img src="${bag.bagImage}" alt="chota ne tak" width="250px" height="250px">
		<br>
		<p><font size="6" color="black" face="gabriola"><b>${bag.name}</b></font></p>
		
		<p><font size="4" color="black" face="impact">${bag.element}</font></p>
		
		Fabric: <b>${bag.fabric}</b>
		<br>
		Color: <b>${bag.color}</b>
		<br>
		Measurements: <b>${bag.size}</b>
		<br>
		Collection: <b>${bag.collection}</b>
		<br>
		Price: <b>${bag.price}$</b>
		<hr>
	
	


	</c:forEach>
	
</div>

<!-- ------------------------------------------------------------------------------------------------------- -->	