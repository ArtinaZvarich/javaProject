<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="css/profilestyle.css">
	<div class = "all">
	    
		<img src="${user.pathImage}" alt="" width="200px" height="200px" style="border-radius: 50%">
	        
		<div class="name">${user.name}</div>
		<br>
		E-mail: ${user.email}
		<br>
		Phone Number: ${user.phone}
		<br>
		<br>
		<div class = "update"><a href="update">Update profile</a></div>
	    
	</div>
	
	<hr>
	
	<p class = "purh">My purchase</p>
	<p class = "shop"><a href="shop">Start shopping</a></p>
	<c:forEach var="bag" items="${user.bags}">
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
		${bag.price}$
		<hr>
		
	</c:forEach>
	
	<!---<a href="deleteBagFromUser/${bag.id}">delete</a>--->
