<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Persons control page</title>
</head>
<body>
<a href="http://localhost:8080">&#8592 Back to start page menu</a>
<div align="center">
    <h1>${message}</h1>

    <nav class="menu">
        <h2 align="center">Menu:</h2>
        <a href="${pageContext.request.contextPath}/person/create">Create new person (only for admin)</a><br>
        <a href="${pageContext.request.contextPath}/person/all">View all persons (only for admin)</a><br>
        <a href="${pageContext.request.contextPath}/person/get">View person by ID</a><br>
        <a href="${pageContext.request.contextPath}/person/getByUsername">View person by Username</a><br>
        <a href="${pageContext.request.contextPath}/person/update">Update person (only for admin)</a><br>
        <a href="${pageContext.request.contextPath}/person/delete">Delete person (only for admin)</a><br>

    </nav>

</div>
</body>
</html>