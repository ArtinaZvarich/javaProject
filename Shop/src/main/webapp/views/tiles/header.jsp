<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<link rel="stylesheet" href="css/header.css">


<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	
</sec:authorize>

<sec:authorize access="!isAuthenticated()">

	<br>
	<a href="login">login</a>
	<br>
	<a href="registration" id="link3">registration</a>
	<br>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<br>
	<a href="base">admin</a>
	<br>
</sec:authorize>
<br>
<sec:authentication property="name" />

<sec:authorize access="hasRole('ROLE_USER')">
	
	<br>
	<a href="profile">My profile</a>
	<br>
	
</sec:authorize>


<nav id="nav-1">
	<a class="link" href="index">Home</a> 
	<a class="link" href="shop">Shop</a>
	<a class="link" href="aboutus">About us</a> 
	<a class="link" href="contact">Contact</a>
</nav>


