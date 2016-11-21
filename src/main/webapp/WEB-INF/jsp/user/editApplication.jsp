<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		<div class="page-header">
            <h1 style="color:Yellow">
			<b>Edit Application</b>
		</h1>
        </div>
        <div class="row">
			<div class=" col-md-offset-3 col-md-6 ">
				<div class="panel panel-primary">
						<div class="page-header" style="color: Red"><b>Edit Application</b> </div>
						<form:form modelAttribute="application" method="post" enctype="multipart/form-data">

									<table class = "table table-primary">
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
								<td>Citizenship:</td>
								<td><form:input class="form-control" path="citizenship" />
								</td>
							</tr>
							
							<tr>
								<td>Department:</td>
								<td><input  value='<c:out value="${application.department.deptName}"></c:out>' readonly="readonly" class="form-control">
								</td>
							</tr>
							
							
							<tr>
								<td>Program</td>
								<td><form:select class="form-control" id="programName" path="program.programName">
										
										<c:forEach items="${prgmList}" var="prgm">
											<c:choose>
            									<c:when test="${program.programName}.equals(${prgm})">
                									<option value="${prgm.programName}" selected>${prgm.programName}</option>
            									</c:when>
            									<c:otherwise>
               										 <option value="${prgm.programName}">${prgm.programName}</option>
            									</c:otherwise>
       										 </c:choose>
										</c:forEach>
									</form:select></td>
							</tr>
 

							 <tr>
								<td>File: ${filename} <input type="file" name="file" id="file" />&nbsp &nbsp
								</td>
							</tr> 
							

										
									</table>
								
					<input type="submit" name="submit" value="Add/Remove Educational Background" />
					</form:form>
								
								</div>
								</div></div></div>

</body>
</html>