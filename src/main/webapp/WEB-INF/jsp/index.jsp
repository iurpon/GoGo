<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting</title>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<ul>
    <hr>
    <form method="post" action="users">
        <b>Meals of&nbsp;</b>
        <select name="userId">
            <option value="100010">User1</option>
            <option value="100011">User2</option>
            <option value="100012">User3</option>
            <option value="100013">User4</option>
            <option value="100014">User5</option>
            <option value="100015">Admin</option>
        </select>
        <button type="submit">Select</button>
    </form>


</ul>
</body>
</html>