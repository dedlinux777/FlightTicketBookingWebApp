<%--
  Created by IntelliJ IDEA.
  User: Harshavardhan N
  Date: 03-02-2026
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Passenger Registration</title>
    <style>
        body { font-family: Arial; margin: 50px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; }
    </style>
</head>
<body>
<h2>Flight Passenger Registration</h2>
<hr>
<form:form action="add-passenger" method="POST" modelAttribute="passenger">
    <div class="form-group">
        <label>Full Name:</label>
        <form:input path="name" required="true" />
    </div>
    <div class="form-group">
        <label>Passport Number:</label>
        <form:input path="passport_no" required="true" />
    </div>
    <div class="form-group">
        <label>Arrival Destination:</label>
        <form:input path="arrival" required="true" />
    </div>
    <div class="form-group">
        <label>Date of Journey:</label>
        <form:input path="dateOfJourney" type="date" required="true" />
    </div>
    <button type="submit">Register Passenger</button>
</form:form>
</body>
</html>
