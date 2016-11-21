<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title></title>

<c:url var="findProg" value="/user/programs.html" />
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#department.deptId').change(
						function() {
							$.getJSON('${findProg}', {
								deptId : $(this).val(),
								ajax : 'true'
							}, function(data) {
								alert(data);
								var html = '<option value=""></option>';
								var len = data.length;
								for (var i = 0; i < len; i++) {
									html += '<option value="' + data[i] + '">'
											+ data[i] + '</option>';
								}
								html += '</option>';
								$('#program').html(html);
							});
						});
			})
</script>
</head>
<body background="/gapp/img/new.jpg">
<div class="container" align="center">
		<div class="jumbotron">
			<h1>
				<b style="color: blue">select Department and Program</b>
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
					<form:form modelAttribute="application"  >

						
						<table class="table table-primary">
						 <tr>
								<td>Department</td>
								<td><form:select class="form-control" path="department.deptId">

										<c:forEach items="${deptList}" var="dept">
											<form:option value="${dept.deptId}">${dept.deptName}</form:option>
										</c:forEach>

									</form:select></td>
							</tr> 
						<tr>
								<td>Program</td>
								<td><form:select class="form-control" path="program.programName">
										<form:option value=""></form:option>
									</form:select></td>
							</tr>
							
							<tr><td> <input type="submit" name="submit" value="Next"/></td></tr>
							</table>
							</form:form>
							</div>
							</div>
							</div>
							</div>
							
					
</body>
</html>