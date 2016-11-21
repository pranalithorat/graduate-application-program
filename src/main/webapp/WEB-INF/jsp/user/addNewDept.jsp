<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add New department</title>

</head>
<body background="/gapp/img/new.jpg">	
		<div class="container" align="center">
		<div>
			<h1>
				<b style="color: Yellow">Add Additional Fields</b>
			</h1>
			
			<a href="logout.html" class="btn btn-info" role="button" >Logout</a>
		</div><br><br>
		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong style="color: blue">Add New Department</strong>
					</div>
					<div class="panel-body">


						<form:form modelAttribute="department" class="form-horizontal" role="form">
							<label class="col-sm-3 ">Department Name:</label>
							<div class="col-sm-6">

								<form:input path="deptName" />
								<b><form:errors path="deptName" /></b>

							</div>

							<div class="form-group centre">
								<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm" value="Add" >
										Add</button>
						
								</div>
							</div>
							
					<!-- 		File: <input type="file" name="file" id="file" /> <br /> -->

						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>