<%--
  Created by IntelliJ IDEA.
  User: Echo
  Date: 2019/1/14
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${spitter.username}" /> profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <c:out value="${spitter.username}" /><br />
    <c:out value="${spitter.firstName}" /> · <c:out value="${spitter.lastName}" />
</body>
</html>
