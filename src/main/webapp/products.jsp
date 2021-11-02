<%--
  Created by IntelliJ IDEA.
  User: valerii
  Date: 01.11.2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<a href="<c:url value="/" />">Back to home page</a>


<hr>


<form action="products" method="post">
    <label for="name">Product Name:</label>
    <input type="text" name="name" id="name">
    <label for="status">Product Status</label>
    <select name="status" id="status">
        <c:forEach var="ps" items="${productsStatuses}">
            <option>${ps}</option>
        </c:forEach>
    </select>
    <label for="price">Price</label>
    <input type="text" name="price" id="price"/>
    <input type="submit" value="+"/>
</form>

<hr>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>STATUS</th>
        <th>PRICE</th>
        <th>CREATED AT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <th>${product.getId()}</th>
            <th>${product.getName()}</th>
            <th>${product.getStatus()}</th>
            <th>${product.getPrice()}</th>
            <th>${product.getCreatedAt()}</th>
                <%--            <th><a href="delete-products?id=${product.getId()}">X</a></th>--%>
            <th><a href="products?del=${product.getId()}">X</a></th>
        </tr>
    </c:forEach>

</table>


</body>
</html>
