<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
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
				<b>${deptName}</b>
			</h1>
		</div>

		<div class="row">
			<div class=" col-md-offset-2 col-md-5 ">
				<div class="panel panel-primary">
					<div class="page-header">
					</div>
					<!-- <table class="table table-striped">
		<thead>
				<tr>
					<th>Programs</th>
					<th>Additional fields</th>
				</tr>
		</thead>	 -->
			
						<div class="row">
								<div class="col-md-offset-2 col-md-8 ">
									<div class="panel panel-primary">
										<div class="page-header" style="color: red">
											<b>Program</b>
										</div>
		<table class="table table-striped" align="center">
		<thead></thead>
		<tbody>
			<c:forEach items="${programs}" var="prgm">
			<tr>
			     <td>
			       <c:out value="${prgm.programName}" /></td></tr>
		    </c:forEach></tbody>
				</table>
				
				<a href="addPrograms.html?deptId=${deptId}&add=0" class="btn btn-info" role="button">Add program</a>
				</div>
				</div>
				</div>
				
				<div class="row">
								<div class="col-md-offset-2 col-md-8 ">
									<div class="panel panel-primary">
										<div class="page-header" style="color: red">
											<b>Additional fields</b>
										</div>
				
				<table class="table table-striped" align="center">
				<thead>
				</thead>
				<tbody>
			<c:forEach items="${addFields}" var="addF">
			<tr>
					<td><c:out value="${addF.fieldName}" /></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			
			<a href="addAdditionalFields.html?deptId=${deptId}&add=0" class="btn btn-info" role="button">Add additional fields</a>
			</div>
			</div>
			</div>
	
			

		

		
		
			
			</div>
			</div></div></div>
</body>
</html>