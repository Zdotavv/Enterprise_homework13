<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View person by ID</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<div align="center">
    <h2>View person by Username</h2>
    <%--@elvariable username="personByUsername" type="com.zdotavv.enterprise_homework13.dto.PersonDto"--%>
    <form:form action="getByUsername" method="post" modelAttribute="personByUsername">
        <form:label path="username">Username:</form:label>
        <form:input required="required" path="username"/><br/>
        <form:button>Get</form:button>
    </form:form>
</div>
</body>
</html>