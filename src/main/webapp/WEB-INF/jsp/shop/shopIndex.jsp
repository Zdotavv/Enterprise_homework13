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
        <a href="${pageContext.request.contextPath}/shop/create">Create new shop (only for admin)</a><br>
        <a href="${pageContext.request.contextPath}/shop/all">View all shops</a><br>
        <a href="${pageContext.request.contextPath}/shop/get">View shop by ID (only for admin)</a><br>
        <a href="${pageContext.request.contextPath}/shop/delete">Delete shop (only for admin)</a><br>

    </nav>

</div>
</body>
</html>