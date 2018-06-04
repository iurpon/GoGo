<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="/voting">Home</a></h3>
    <%--<h2>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h2>--%>
    <hr>
    <%--<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>--%>
    <h2>Adding menu for restaurant : ${restaurantName}</h2>
    <form method="post" action="/voting/addMenu">
        <input type="hidden" name="id" value="${restId}">
        <dl>
            <dt>Dish 1</dt>
            <dd><input type="text"  name="dish1"></dd>
        </dl>
        <dl>
            <dt>Dish 2</dt>
            <dd><input type="text"  name="dish2"></dd>
        </dl>
        <dl>
        <dt>Dish 3</dt>
        <dd><input type="text"  name="dish3"></dd>
        </dl>
        <dl>
        <dt>Dish 4</dt>
        <dd><input type="text"  name="dish4"></dd>
        </dl>
        <dl>
            <dt>Dish 5</dt>
            <dd><input type="text"  name="dish5"></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number"  required="required" name="price"></dd>
        </dl>

        <button type="submit">Save</button>
        <%--<button onclick="window.history.back()" type="button">Cancel</button>--%>
    </form>
</section>
</body>
</html>