<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Current Date and Time</title>
</head>
<body>
    <h2>Current Date and Time</h2>
    <%
        java.util.Date currentDate = new java.util.Date();
        out.println("<p>Current Date: " + currentDate.toString() + "</p>");
    %>
</body>
</html>
