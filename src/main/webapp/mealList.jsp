<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 08.06.2016
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Meal List</title>
</head>
<body>
    <h2>Meal List</h2>
    <table border="2">
    <c:forEach items="${list}" var="ml">
       <tr <c:if test="${ml.exceed}">style="color: green"</c:if><c:if test="${!ml.exceed}">style="color: red"</c:if>>
           <td>${ml.dateTime}</td>
           <td>${ml.description}</td>
           <td>${ml.calories}</td>
           <td>${ml.exceed}</td>
       </tr>


    </c:forEach>
    </table>
</body>
</html>
