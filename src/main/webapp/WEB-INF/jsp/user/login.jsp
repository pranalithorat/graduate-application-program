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
<title>Login User</title>

</head>
<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
	<h1 style="color:white"><b>Graduate Application Program</b></h1><br><br><br><br>
		<div class="row">
			<div class="col-md-offset-4 col-md-4 ">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>LOGIN</strong>
					</div>
					<div class="panel-body">
						<form:form modelAttribute="user" class="form-horizontal"
							role="form">
							<label class="col-sm-3 control-label"> Email</label>
							<div class="col-sm-9">
								<form:input path="email" class="form-control" />
								 <form:errors path="email" /> <br />
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<form:input type="password" path="password" class="form-control" />
									<form:errors path="password" />
								</div>
							</div>
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">
										Sign in</button>
										
								&nbsp<a href="add.html"  class= "btn btn-info" role="button">Register Here</a>
									<!-- <input type="submit" class="btn btn-info" value="Submit"> <br /> -->
								</div>
			</div>
			
	
	
						</form:form>
						
	
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
