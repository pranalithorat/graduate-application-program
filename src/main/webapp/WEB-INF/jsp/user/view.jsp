<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View the User</title>
</head>
<body>
<table border="1">

  <tr><th>ID</th><td>${user.id}</td></tr>
  <tr><th>Firstame</th><td>${user.fname}</td></tr>
  <tr><th>Lastname</th><td>${user.lname}</td></tr>

</table>
</body>
</html>