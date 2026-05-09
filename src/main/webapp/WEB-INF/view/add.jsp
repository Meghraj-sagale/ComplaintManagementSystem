<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Complaint</title>
    <link rel="stylesheet" type="text/css" href="css/add.css?v=1">
</head>

<body>

<div class="container">

<h2>Add Complaint</h2>

<c:if test="${not empty msg}">
    <div class="msg ${type}">
        ${msg}
    </div>
</c:if>

<form action="/save" method="post">

    <label>User</label>
    <input name="user" required placeholder="Enter your name">

    <label>Description</label>
    <textarea name="description" required placeholder="Write your complaint here..."></textarea>

    <button type="submit">Submit Complaint</button>

</form>

<a href="/view">View Complaints</a>

</div>

</body>
</html>