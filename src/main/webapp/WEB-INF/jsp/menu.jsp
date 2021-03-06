
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


<pre>${votingMsgResult}</pre>
<div>${msg}</div>
<div>${notReadyMsg}</div>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>

    <tr>

        <th>Description</th>
        <th>Restaurant</th>
        <th>Price</th>
        <th>Vote</th>
    </tr>
    </thead>
    <c:forEach items="${menus}" var="menu">
        <jsp:useBean id="menu" scope="page" type="ru.firstproject.model.Menu"/>
        <tr  equalsName = "${menu.restaurant.name.equals(restaurantName)}" >

            <td>${menu.description}</td>
            <td>${menu.restaurant.name}</td>
            <td>${menu.price}</td>
            <td><a href="restaurant/${menu.restaurant.id}/${menu.restaurant.name}">Vote</a></td>

        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
