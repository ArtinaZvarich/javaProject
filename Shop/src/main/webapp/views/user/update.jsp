<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form action="update" method="post">
    <input type="text" name="phone" value="${user.phone}">
    <button>save updates</button>
</form:form>
<br>
update only image
<br>
<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <button>save image</button>
</form:form>
<br>