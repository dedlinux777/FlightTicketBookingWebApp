<%--
  Created by IntelliJ IDEA.
  User: Harshavardhan N
  Date: 03-02-2026
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket Details</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2>Full Ticket Information</h2>
<hr>
<c:if test="${not empty ticket}">
    <table>
        <tr><th>Ticket Number</th><td>${ticket.ticketNumber}</td></tr>
        <tr><th>Passenger Name</th><td>${ticket.name}</td></tr>
        <tr><th>Status</th><td><strong>${ticket.status}</strong></td></tr>
        <tr><th>Price</th><td>$${ticket.ticketPrice}</td></tr>
        <tr><th>Departure</th><td>${ticket.departure}</td></tr>
        <tr><th>Arrival</th><td>${ticket.arrival}</td></tr>
        <tr><th>Date of Journey</th><td>${ticket.dateOfJourney}</td></tr>
    </table>
</c:if>
<c:if test="${empty ticket}">
    <p style="color: red;">No ticket found for the provided number.</p>
</c:if>
<br>
<a href="passenger-form">Book Another Ticket</a>
</body>
</html>
