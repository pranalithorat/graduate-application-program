<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>

<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
		<div class="jumbotron">
			<h1>
				<b style="color: blue">Add New Program</b>
			</h1>
		</div>
	</div>
	<div class="row">
		
				<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Add New Program</strong>
					</div>
					<div class="panel-body">

					<form:form modelAttribute="program" class="form-horizontal"
							role="form" >

						
						<label class="col-sm-3" style="color: red">Program Name:</label>
							<div class="col-sm-6">

						
							<form:input path="programName" />
							
						</div>
						<div class="form-group centre">
								<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm" value="Add" >
										Add</button>
										</div>
										</div>
						
					</form:form>
					</div>
				
			</div>
		</div>
	</div>
	
</body>
</html>