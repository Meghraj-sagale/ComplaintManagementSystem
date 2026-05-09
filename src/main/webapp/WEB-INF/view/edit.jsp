<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Complaint</title>
    <link rel="stylesheet" href="/css/edit.css">
</head>

<body>

<div class="container">

<h2>Update Complaint</h2>

<c:if test="${not empty msg}">
    <div class="msg ${type}">
        ${msg}
    </div>
</c:if>

<form action="/save" method="post">

    <input type="hidden" name="id" value="${complaint.id}">

    <label>User Name</label>
    <input name="user" value="${complaint.user}" required>

    <label>Description</label>
    <textarea name="description" required>${complaint.description}</textarea>

    <label>Status</label>
    <select name="status" required>
        <option value="Pending"
            <c:if test="${complaint.status == 'Pending'}">selected</c:if>>
            Pending
        </option>
        <option value="Resolved"
            <c:if test="${complaint.status == 'Resolved'}">selected</c:if>>
            Resolved
        </option>
    </select>

    <button type="submit">Update Complaint</button>

</form>

<a class="back-link" href="/view">← Back to Complaints</a>

</div>

</body>
</html>