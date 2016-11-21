<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Register User</title>

</head>
<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
		<div class="page-header">
            <h1 style="color:Yellow">
			<b>GAPP</b>
		</h1>
        </div>
			
		<div class="row">
			<div class=" col-md-offset-3 col-md-6 ">
				<div class="panel panel-primary">
						<div class="page-header" style="color: Red"><b>Register User</b> </div>
							
								<form:form modelAttribute="user">

									<table class = "table table-primary">
										<tr>
										<td>First Name:</td>
										<td><form:input class="form-control" path="fname" />
										<form:errors path="fname" /></td>
										</tr>

										<tr>
										<td>Last Name:</td>
										<td><form:input class="form-control" path="lname" />
										<form:errors path="lname" /></td>
										</tr>

										<tr>
										<td>Email:</td>
										<td><form:input class="form-control" path="email" />
										<form:errors path="email" /></td>
										</tr>
										
										<tr>
										<td>Password:</td>
										<td><form:input type ="password" class="form-control" path="password" />
										<form:errors path="password" /></td>
										</tr>

										<tr>
										<td><input type="submit" class="btn btn-info" value="Add"></td>
										</tr>
									</table>
								</form:form>
								
							</div>
						</div>
					</div>

				</div>
			
</body>



</html>
