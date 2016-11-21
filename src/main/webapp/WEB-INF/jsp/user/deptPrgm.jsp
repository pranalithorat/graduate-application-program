<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>
Add application material</title>
<c:url var="findProg" value="/user/programs.html" />
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#departmentId').change(
						function() {
							$.getJSON('${findProg}', {
								deptId : $(this).val(),
								ajax : 'true'
							}, function(data) {
								var html = '<option value=""></option>';
								var len = data.length;
								for (var i = 0; i < len; i++) {
									html += '<option value="' + data[i] + '">'
											+ data[i] + '</option>';
								}
								html += '</option>';
								$('#programName').html(html);
							});
						});
			})
</script>


</head>
<body background="/gapp/img/new.jpg">



	<div class="container" align="center">
		<div class="page-header">
			<h1 face="verdana" ;color="yellow">
				<b>Add new Application</b>
			</h1>
		</div>

		<div class="row">
			<div class=" col-md-offset-3 col-md-6 ">
				<div class="panel panel-primary">
					<div class="page-header" style="color: Red">
						<b>Add new Application</b>
					</div>

					<form:form   modelAttribute="application" enctype="multipart/form-data">

						 <table class="table table-primary">
						<tr>
								<td>First Name:</td>
								<td><form:input class="form-control" path="fname" /></td>
							</tr>

						 		<tr>
								<td>Last Name:</td>
								<td><form:input class="form-control" path="lname" /></td>
							</tr>

							<tr>
								<td>Email:</td>
								<td><form:input class="form-control" path="email" /></td>
							</tr>

							<tr>
								<td>CIN:</td>
								<td><form:input class="form-control" path="cin" /></td>
							</tr>

							<tr>
								<td>Gender:</td>
								<td><form:input class="form-control" path="gender" /></td>
							</tr>

							<tr>
								<td>Date of Birth:</td>
								<td><form:input type="date" class="form-control" path="dob" /></td>
							</tr>
							
							
							<tr>
								<td>Term Applied:</td>
								<td><form:input type="date" class="form-control" path="term" /></td>
							</tr>
							
							

							<tr>
								<td>Citizenship:</td>
								<td><form:input class="form-control" path="citizenship" />
								</td>
							</tr>
							
							
							
							 <tr>
								<td><strong>Department*</strong></td>
								<td><form:select class="form-control" id="departmentId" path="department.deptId">
											<form:option value="" ></form:option>
										<c:forEach items="${deptList}" var="dept">
											<form:option id="deptId" value="${dept.deptId}">${dept.deptName}</form:option>
										</c:forEach>

									</form:select></td>
							</tr> 
							<tr>
								<td><strong>Program*</strong></td>
								<td><form:select class="form-control" id="programName" path="program.programName">
										<form:option  value=""></form:option>
									</form:select></td>
							</tr>
 

							 <tr>
								<td>File: <input type="file" name="file" id="file" />&nbsp &nbsp
								</td>
							</tr> 
							
							
						<tr><td> <input type="submit" class="btn btn-info" name="submit" value="Add/Remove Educational Background" /></td></tr>
					
						
							</table>
					</form:form>
					<c:if test="${not empty errors}">
						<p style="color: Red"> Required fields are empty.</p>
					</c:if>
					<p>* Required fields</p>

				</div>
			</div>
		</div>

	</div>



</body>
</html>