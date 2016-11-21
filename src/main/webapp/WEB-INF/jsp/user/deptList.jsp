<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Register User</title>

</head>
<body background="/gapp/img/new.jpg">
	<div class="container" align="center">
		<div class = "jumbotron">
			<h1>
			<b>GAPP</b>
		</h1>
		<a href="admin.html" class="btn btn-info" role="button" align="left">Admin Home</a>
		</div>
		<div class="row">
			<div class=" col-md-offset-3 col-md-6 ">
				<div class="panel panel-primary">
						<div class="page-header" style="color: Red"><h3><strong>List</strong></h3> </div>
						
  <table class="table table-striped">
  <thead>
<tr>
  <th>Department Name</th>
  <th>Program Count</th>
  <th>View</th>
  <th>Edit</th>
</tr>
</thead>
 <tbody>
<c:forEach items="${deptList}" var="department">

<tr>
  <c:forEach items="${department.value}" var="dept">
  <td>${dept.key}</td>
  <td>${dept.value}</td>
  </c:forEach>
  <td>
  
  <a href="viewDept.html?deptId=${department.key}">view</a></td>
  <td>
  
  <a href="editDepartment.html?deptId=${department.key}" >Edit</a></td>
</tr>
</c:forEach>
 <tbody>
</table>

</div>
</div>
</div>
</div>
</body>
</html>
