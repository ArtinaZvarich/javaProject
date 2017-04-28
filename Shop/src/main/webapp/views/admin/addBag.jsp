<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/addBag.css">


	<form:form action="./saveBag?${_csrf.parameterName}=${_csrf.token}"
			   method="post" enctype="multipart/form-data">
		<br>	   
		<div 
			class = "forma"><select name="name" id="inputEmail" class="form-control"  required autofocus >
			<option disabled>Choose brand</option>
    		<option value="Gucci">Gucci</option>
    		<option value="Dior">Dior</option>
    		<option value="Louis Vuitton">Louis Vuitton</option>
    		<option value="Versace">Versace</option>
    		<option value="Chanel">Chanel</option>
    		<option value="Prada">Prada</option>
    		<option value="Hermes">Hermes</option>
			</select>
		</div>
		<br>
		<div 
			class = "forma"><select name="fabric" id="inputEmail" class="form-control"  required >
			<option disabled>Choose fabric</option>
    		<option value="suede">suede</option>
    		<option value="leather">leather</option>
    		<option value="imitation leather">imitation leather</option>
    		<option value="eco leather">eco leather</option>
			</select>
		</div>
		<br>
		<div 
			class = "forma"><select name="color" id="inputEmail" class="form-control"  required >
			<option disabled>Choose color</option>
    		<option value="red">red</option>
    		<option value="orange">orange</option>
    		<option value="yellow">yellow</option>
    		<option value="green">green</option>
    		<option value="blue">blue</option>
    		<option value="purple">purple</option>
    		<option value="pink">pink</option>
    		<option value="black">black</option>
    		<option value="white">white</option>
    		<option value="grey">grey</option>
    		<option value="brown">brown</option>
			</select>
		</div>
		<br>
		<div 
			class = "forma"><input name="element" placeholder="name" id="inputEmail" class="form-control"  required  />
		</div>
		<br>
		<div 
			class = "forma"><input name="size" placeholder="size" id="inputEmail" class="form-control"  required />		
		</div>
		<br>
		<div 
			class = "forma"><input name="collection" placeholder="collection" id="inputEmail" class="form-control"  required />		
		</div>
		<br>
		<div 
			class = "forma"><input name="price" placeholder="price" id="inputEmail" class="form-control"  required />
		</div>
		<br>
		<input type="file" name="image">

		<button>save bag</button>
	</form:form>