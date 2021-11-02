<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="products">Products menu</a>

<h2>Orders</h2>
<table>
    <tr>
        <th>Order ID</th>
        <th>User ID</th>
        <th>Status</th>
        <th>Created Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>


<c:forEach var="order" items="${orders}">
    <tr>
        <th>${order.getId()}</th>
        <th>${order.getUserId()}</th>
        <th>${order.getStatus()}</th>
        <th>${order.getCreatedAt()}</th>
        <th><a href="order?id=${order.getId()}">edit</a> </th>
        <th>X</th>
    </tr>
</c:forEach>
</table>

</body>
</html>