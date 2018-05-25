<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.05.2018
  Time: 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose luch you want</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<hr/>
<h1>Representing lunch for date ${date}</h1>
<h1>${choise}</h1>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>

    <tr>

        <th>Description</th>
        <th>Restaurant</th>
        <th>Price</th>
        <th>Vote</th>
    </tr>
    </thead>
    <c:forEach items="${lunch}" var="lunchView">
        <jsp:useBean id="lunchView" scope="page" type="ru.firstproject.to.LunchView"/>
        <tr votedData = "${lunchView.restaurant.equals(restaurantName)}">

            <td>${lunchView.description}</td>
            <td>${lunchView.restaurant}</td>
            <td>${lunchView.price}</td>
            <td><a href="lunch?vote=${lunchView.restaurant}">Vote</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
