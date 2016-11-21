<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>Users</title></head>
<body>
<table border="1">
<tr><th>ID</th><th>FirstName</th><th>LastName</th><th>Enabled</th></tr>
<c:forEach items="${users}" var="user">
<tr>
<th>Id</th><th>FirstName</th><th>LastName</th><th>enabled</th>
  <td>${user.id}</td>
  <td>${user.fname}</td>
  <td>${user.lname}</td>
</tr>
</c:forEach>
</table>
</body>
</html>