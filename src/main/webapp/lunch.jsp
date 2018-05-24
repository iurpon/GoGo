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
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<hr/>
<h1>Representing lunch for date ${date}</h1>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>

    <tr>

        <th>Description</th>
        <th>Restourant</th>
        <th>Price</th>
        <th>Date</th>
    </tr>
    </thead>
    <c:forEach items="${lunch}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.firstproject.to.LunchView"/>
        <tr >
 <%--           <td>
                    &lt;%&ndash;${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}&ndash;%&gt;
                    &lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;
                    &lt;%&ndash;${fn:replace(meal.dateTime, 'T', ' ')}&ndash;%&gt;
                    ${fn:formatDateTime(meal.dateTime)}
            </td>--%>
            <td>${meal.description}</td>
            <td>${meal.restaurant}</td>
            <td>${meal.price}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
