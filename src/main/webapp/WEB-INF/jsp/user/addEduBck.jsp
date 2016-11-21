<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div class="page-header">
			<h1 style="color: Yellow">
				<b>Add Educational Background</b>
			</h1>
		</div>

		<div class="row">
			<div class=" col-md-offset-2 col-md-8 ">
				<div class="panel panel-primary">
					<div class="page-header" style="color: Red">Add Degree</div>
					<form:form   modelAttribute="application">
					<table class="table table-striped">
					<thead>
						<tr>
							<th>University Name</th>
							<th>Degree earned</th>
							<th>Degree Major</th>
							<th>GPA</th>
							<th>Time Attended To</th>
							<th>Time Attended From</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${eduBacks}" var="eduBack">
							<tr>
								<td>${eduBack.univName}</td>
								<td>${eduBack.degreeEarned}</td>
								<td>${eduBack.degreeMajor}</td>
								<td>${eduBack.gpa}</td>
								<td>${eduBack.timeAttendedTo}</td>
								<td>${eduBack.timeAttendedFrom}</td>
							
								<td><a href="deleteEdu.html?eduId=${eduBack.edBckId}&appId=${eduBack.applicationId.appId}&add=1">Remove</a></td>
							</tr></c:forEach>
							<tr>
				<td><a href="addMoreEdu.html?appId=${appId}&add=1"
					class="btn btn-primary btn-sm" role="button">Add Educational Background</a>&nbsp</td>
					
				</tr>
						
					</tbody>
				</table>
				
				
				
					
					<input type="submit" name="action" value="Save" class="btn btn-primary btn-sm" role="button" />
				<input type="submit" name="action" value="Submit" class="btn btn-primary btn-sm" role="button" />
				</form:form>
					</div>
				</div>
			</div>
		</div>
	

</body>
</html>