<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title></title>
</head>
<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
	
			<div class="page-header">
			<h1 style="color: Yellow">
				<b>Add new Application</b>
			</h1>
		</div>

		
		<div class="row">
			<div class="col-offset-2 col-md-10">
				<div class="panel panel-primary">
					<div class="page-header" style="color: Red">
						<b>Basic Information</b>
					</div>
					<table class="table table-striped">
						<tr>
							<th>Last name</th>
							<th>First name</th>
							<th>Email</th>
							<th>CIN</th>
						
							<th>Gender</th>
							<th>DOB</th>
							<th>Citizenship</th>
						</tr>

						<tr>

							<td>${application.lname}</td>
							<td>${application.fname}</td>
							<td>${application.email}</td>
							<td>${application.cin}</td>
							
							<td>${application.gender}</td>
							<td>${application.dob}</td>
							<td>${application.citizenship}</td>


						</tr>
					</table>


				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-0 col-md-10">
				<div class="panel panel-primary">
					<div class="page-header" style="color: Red">
						<b>Educational Background</b>
					</div>
					<table class="table table-striped">
						<tr>

							<th>College name</th>
							<th>Time attended From</th>
							<th>Time attended To</th>
							<th>Degree earned</th>
							<th>Major</th>
							<th>GPA</th>
							
						</tr>

						<tr>
							
							<c:forEach items="${application.education}" var="edu">
								
								<td>${edu.univName}</td>
								<td>${edu.timeAttendedFrom}</td>
								<td>${edu.timeAttendedTo}</td>
								<td>${edu.degreeEarned}</td>
								<td>${edu.degreeMajor}</td>
								<td>${edu.gpa}</td>
								


							</c:forEach>
							
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-0 col-md-10">
				<div class="panel panel-primary">
					<div class="page-header" style="color: Red">
						<b>Academic Information</b>
					</div>
					<table class="table table-striped">
						<tr>

							<th>GRE</th>
							<th>TOEFL</th>
							
							<th>Transcript</th>
						</tr>
						<tr>
							<td>${application.greScore}</td>
							<td>${application.tofelScore}</td>
							
							
							<c:choose>
							<c:when test="${application.filename eq 'transcriptnull'}">
							<td></td>
							</c:when>
							<c:otherwise>
							<td>${application.filename}
							<a href="download.html?id=${application.appId}">Download</a>
							</td>
							
							</c:otherwise>
							</c:choose>
						</tr>
							
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>