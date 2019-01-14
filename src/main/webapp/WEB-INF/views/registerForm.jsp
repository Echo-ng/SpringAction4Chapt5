<%--
  Created by IntelliJ IDEA.
  User: Echo
  Date: 2019/1/14
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>

    <form method="POST">
        First Name: <input type="text" name="firstName" placeholder="input your first name,please" /> <br />
        Last Name: <input type="text" name="lastName" placeholder="input your last name,please" /> <br />
        Username: <input type="text" name="username" placeholder="input your username in Spittr,please" /> <br />
        Password: <input type="password" name="password" /> <br />

        <input type="submit" value="Register" />
    </form>
</body>
</html>
