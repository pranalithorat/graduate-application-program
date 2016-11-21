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
<title>Insert title here</title>

</head>
<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
		<div class="jumbotron">
			<h1>
				<b>Hello Student</b>
			</h1>
		</div>
		<ul class="nav nav-pills">
						<li><a href="deptPrgm.html?id=${param.id}&errors=${null}" class="btn btn-info">Add
								Application</a></li> 
						<li><a href="logout.html" class="btn btn-info">Logout</a></li>
					</ul>

		<div class="row">
			<div class=" col-md-offset-2 col-md-8 ">
				<div class="panel panel-primary">
					<div class="page-header" style="color: #660033">
						<b>Application List ${user.id}</b>
					</div>
					
					<table class="table table-striped" style="color: black">

						<tr>
							<th>Date Submitted</th>
							<th>Department</th>
							<th>Program</th>
							<th>Term Applied</th>
							<th>Current Status</th>
							<th>View</th>
							<th>Edit</th>
						</tr>



						<c:forEach items="${application}" var="app">
							<tr>
								<c:set var="dept" value="${app.department}" />
								<c:set var="prgm" value="${app.program}" />
								<c:set var="status" value="${app.status}" />
								<td>${app.dateSubmitted}</td>
								<td>${dept.deptName}</td>
								<td>${prgm.programName}</td>
								<td>${app.term}</td>
								<td>${status.status}</td>
								<td><a
									href="viewDetails.html?id1=${app.appId}&id2=${param.id}">view</a></td>
								<c:choose>
									<c:when test="${empty status.status}">
										<td><a
											href="editApplication.html?appId=${app.appId}&id=${param.id}">Edit</a></td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>



					</table>



				</div>

			</div>
		</div>
	</div>
</body>
</html>