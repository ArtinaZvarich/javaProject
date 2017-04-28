<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<link rel="stylesheet" href="css/login.css">


 
<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="https://static1.squarespace.com/static/5362dd95e4b0bbc27dca9eee/537f7529e4b07bbe6485d6d5/537f7751e4b02723c19ba59a/1400862577825/cartman___the_coon___vector_by_v3nus4urlolauri.png?format=1500w" />
            <p id="profile-name" class="profile-name-card"></p>
            <form action="loginprocesing" method="post" class="form-signin">
            	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
              	 <center><font size="2" color="silver" face="Arial">Login</font></center>
                <input name="username" type="text" id="inputEmail" class="form-control"  required autofocus />
              	 <center><font size="2" color="silver" face="Arial">Password</font></center>
                <input name="password" type="password" id="inputPassword" class="form-control"  required>
                
                <div id="button">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                </div>
            </form>
        </div>
</div>
	
	


</body>
</html>