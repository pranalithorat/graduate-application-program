<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Additional Fields</title>

</head>
<body background="/gapp/img/new.jpg">

 <div class="container" align="center">
 <div class="page-header" style= color:Yellow>
<h2><b>Add Additional Fields</b></h2>
</div>
   <div class="row">
    <div class="col-md-offset-3 col-sm-6">
        <div class="jumbotron text-left">
<form:form modelAttribute="additionalFields">
<div class="form-group">
<b>Field Name: </b><form:input path="fieldName"/>
</div>
<div class="form-group">
<b>Field Type:</b> <form:input path="fieldType"/></div>
<div class="form-group">
<b>Required:</b> <form:radiobutton path="isRequired" value="true"/>&nbsp
<b>Optional:</b> <form:radiobutton path="isRequired" value="false"/>
</div>
<div class="form-group">
<input type="submit" name="add" value="Add" class="btn btn-primary btn-sm" role="button" /> <br />
</div>
</form:form>
   </div>  
    </div>    
  </div>
  </div>
</div>

</body>
</html>
