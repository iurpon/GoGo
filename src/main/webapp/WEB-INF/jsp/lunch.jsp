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
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Choose luch you want</title>
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h3><a href="${pageContext.request.contextPath}">Home</a></h3>
<h2>Meals</h2>
<hr/>
<h1>Representing lunch for date ${date}</h1>
<span>${choise}</span>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>

    <tr>

        <th>Description</th>
        <th>Restaurant</th>
        <th>Price</th>
        <th>Vote</th>
    </tr>
    </thead>
    <c:forEach items="${lunch}" var="menu">
        <jsp:useBean id="lunchView" scope="page" type="ru.firstproject.to.LunchView"/>
        <tr votedData = "${menu.restaurant.equals(restaurantName)}">

            <td>${menu.description}</td>
            <td>${menu.restaurant}</td>
            <td>${menu.price}</td>
            <td><a href="lunch?vote=${menu.restaurant}">Vote</a></td>

        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
