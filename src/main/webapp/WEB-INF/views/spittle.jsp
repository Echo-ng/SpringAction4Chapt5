<%--
  Created by IntelliJ IDEA.
  User: Echo
  Date: 2019/1/14
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
    <div>
        <div><c:out value="${spittle.message}" /></div>
        <div>
            <span><c:out value="${spittle.time}" /></span>
        </div>
    </div>
</body>
</html>
