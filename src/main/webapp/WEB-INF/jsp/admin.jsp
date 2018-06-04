
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Choose luch you want</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<h3><a href="/voting">Home</a></h3>
<h2>Admin</h2>
<hr/>

<%--<div>${msg}</div>
&lt;%&ndash;<div>${restaurantName}</div>&ndash;%&gt;--%>

<h1>${msgToAdmin}</h1>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>

    <tr>


        <th>Restaurant</th>
        <th>Description</th>
        <th>Price</th>
        <th>AddMenu</th>
    </tr>
    </thead>
    <c:forEach items="${lunchList}" var="lunch">
        <jsp:useBean id="lunch" scope="page" type="ru.firstproject.to.LunchView"/>
        <tr   >

            <td>${lunch.restaurantName}</td>
            <td>${lunch.description}</td>
            <td>${lunch.price}</td>
            <td><a href="addMenu/${lunch.restId}/${lunch.restaurantName}">Add</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
