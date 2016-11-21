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
<title>Add Educational background</title>
</head>
<body background="/gapp/img/new.jpg">
<div class="container" align="center">
		<div class="page-header">
            <h1 style="color:Yellow">
			<b>Add Educational Background</b>
		</h1>
        </div>

<div class="row">
			<div class=" col-md-offset-3 col-md-6 ">
				<div class="panel panel-primary">
						<div class="page-header" style="color: Red"><b>Add Educational Background</b> </div>
						
					<form:form class="form-horizontal" modelAttribute="education">
						<table class="table table-primary">
							<tr>
								<td>University Name:</td>
								<td><form:input class="form-control" path="univName" /></td>
							</tr>

							<tr>
								<td>Degree Earned:</td>
								<td><form:input class="form-control" path="degreeEarned" />
							</tr>

							<tr>
								<td>Degree Major:</td>
								<td><form:input class="form-control" path="degreeMajor" />
								</td>
							</tr>

							<tr>
								<td>GPA:</td>
								<td><form:input class="form-control" path="gpa" /></td>
							</tr>


								<tr>
								<td>Time Attended To:</td>
								<td><form:input class="form-control" path="timeAttendedTo" /></td>
							</tr>
								
								
								<tr>
								<td>Time Attended From:</td>
								<td><form:input class="form-control" path="timeAttendedFrom" /></td>
							</tr>
								
							<tr>
								
								<td><input type="submit" class="btn btn-info" value="Add"  />
								</td>
							</tr>
						</table>
					</form:form>
						</div>
						</div>
						</div>
						</div>
</body>
</html>