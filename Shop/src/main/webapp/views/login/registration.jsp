<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="css/registration.css">



<div class="container">

	<h2>
		Sing Up<small>(enter data)</small>
			${exception}
	</h2>

	<form:form modelAttribute="user" action="registration" method="post">
		<div class="group">
			<form:input path="name" />
			<span class="highlight"></span> <span class="bar"></span> <label>Name</label>
		</div>

		<div class="group">
			<form:input path="email" type="email"/>
			<span class="highlight"></span> <span class="bar"></span> <label>Email</label>
		</div>

		<div class="group">
			<form:input path="password" type="password" />
			<span class="highlight"></span> <span class="bar"></span> <label>Password</label>
		</div>
		
		<div class="group">
			<form:input path="phone" type="phone" />
			<span class="highlight"></span> <span class="bar"></span> <label>Phone</label>
		</div>

		<button class="action-button shadow animate green">Click</button>
	</form:form>
</div>