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
<title>Edit Department</title>
</head>
<body background="/gapp/img/new.jpg">

	<div class="container" align="center">
		<div class="jumbotron">
			<h1>
				<b style="font-family:verdana;color: blue">Edit Department</b>
			</h1>

		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-6 ">
				<div class="panel panel-primary">
					<div class="well well-lg">
						<form:form modelAttribute="dept">

<b>Department Name:</b> <form:input path="deptName" />

<br><br>

							<div class="row">
								<div class="col-md-offset-2 col-md-8 ">
									<div class="panel panel-primary">
										<div class="page-header" style="color: red">
											<b>Basic Information</b>
										</div>
										<table class="table table-striped" cellpadding="10">
											<thead>
												<tr>
													<th>Program Name</th>
													<th>Remove</th>

												</tr>
											</thead>
											<tbody>
											
												<c:forEach items="${programs}" var="prgm">
													<tr>
														<td>${prgm.programName}</td>
														
														<td><a href="deletePrograms.html?prgmId=${prgm.prgmId}&deptId=${prgm.dept.deptId}">Remove</a></td>
													</tr>
													</c:forEach>
										
												

											</tbody>
										</table>
										
										<a href="addPrograms.html?deptId=${deptId}&add=1"
											class="btn btn-primary btn-sm" role="button">Add Program</a>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-offset-2 col-md-8 ">
									<div class="panel panel-primary">
										<div class="page-header" style="color:Red">
											<b>Additional Fields Information</b>
										</div>
										<table class="table table-striped">
											<thead>
												<tr>
													<th>Additional Fields</th>
													<th>Remove</th>
												</tr>
											</thead>
											<tbody>
												
												<c:forEach items="${addFields}" var="addF">
														<tr>
														<td>${addF.fieldName}<td>
													
														<td><a href="deleteAdditionalFields.html?addFieldId=${addF.addFieldId}&deptId=${addF.dept.deptId}">Remove</a></td>
													</tr>
												</c:forEach>
											

											</tbody>
										</table>
										<a href="addAdditionalFields.html?deptId=${deptId}&add=1" class="btn btn-primary btn-sm" role="button">Add
											Additional Fields</a><br>
											</div>
											</div>
											
									</div>
									<input type="submit" name="save" value="Save"
										class="btn btn-info" role="button" /><br />
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
