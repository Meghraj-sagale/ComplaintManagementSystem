<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Complaints</title>
    <link rel="stylesheet" href="css/view.css?v=1">
</head>

<body>

<div class="container">

<h2>Complaint List</h2>

<c:if test="${not empty msg}">
    <div class="msg ${type}">
        ${msg}
    </div>
</c:if>

<a href="/addForm" class="add-btn">+ Add Complaint</a>

<table>

    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach var="c" items="${list}">
        <tr>
            <td>${c.id}</td>
            <td>${c.user}</td>
            <td>${c.description}</td>

            <!-- STATUS BADGE -->
            <td>
                <c:choose>
                    <c:when test="${c.status == 'Resolved'}">
                        <span class="status resolved">Resolved</span>
                    </c:when>
                    <c:otherwise>
                        <span class="status pending">Pending</span>
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <a href="/edit/${c.id}" class="edit">Update</a>
                <a href="/delete/${c.id}" class="delete">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</div>

</body>
</html>