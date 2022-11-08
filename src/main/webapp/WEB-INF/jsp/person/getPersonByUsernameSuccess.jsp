<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View person By Username</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">View person By Username</h1>
<div align="center">
    <%--@elvariable username="personByUsername" type="com.zdotavv.enterprise_homework10.dto.PersonDto"--%>
    <table>
        <tr>
            <td>ID: </td>
            <td>${personByUsername.idPerson}</td>
        <tr>
        <td>Username: </td>
        <td>${personByUsername.username}</td>
        <tr>
            <td>First name: </td>
            <td>${personByUsername.firstName}</td>
        <tr>
            <td>Last name: </td>
            <td>${personByUsername.lastName}</td>
        <tr>
            <td>Email: </td>
            <td>${personByUsername.email}</td>
    </table>

</div>
    <br>
    <a href="${pageContext.request.contextPath}/person">&#8592 Back to person control page </a>
</body>
</html>