<%--
  Created by IntelliJ IDEA.
  User: Harshavardhan N
  Date: 03-02-2026
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket Search</title>
</head>
<body>
<h2>View Ticket Details</h2>
<hr>
<form action="view-ticket" method="POST">
    <label>Enter Ticket Number:</label>
    <input type="number" name="ticketNumber" required="true" />
    <button type="submit">Search</button>
</form>
</body>
</html>
