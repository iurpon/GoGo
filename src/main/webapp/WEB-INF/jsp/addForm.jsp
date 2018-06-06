<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Meal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h3><a href="${pageContext.request.contextPath}">Home</a></h3>
    <hr>
    <h2>Adding menu for restaurant : ${restaurantName}</h2>
    <form method="post" action="/voting/admin/addMenu">
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
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>