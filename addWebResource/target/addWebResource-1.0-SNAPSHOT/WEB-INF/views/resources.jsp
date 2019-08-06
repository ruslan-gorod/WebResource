<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1><a href="<c:url value="/resources"/>">All resources</a></h1>

    <div style="margin-top: 50px">
        <h3><a href="<c:url value="/add-resource"/>">Add resource</a></h3>
    </div>
    <br>
    <br>
    <div>
        <table border="1">
        <tr>
            <th> № </th>
            <th> Resource name </th>
            <th> Resource url </th>
            <th> Resource status </th>
            <th> </th>
        </tr>
        <c:forEach var="r" items="${resources}" varStatus="loop">
            <tr>
                <td align="center">${loop.index + 1}</td>
                <td><c:out value="${r.name}"></c:out></td>
                <td><a href="<c:url value="${r.url}"/>"><c:out value="${r.url}"></c:out></a></td>
                <td align="center"><c:out value="${r.status}"></c:out></td>
                <td><a href="<c:url value="/delete-resource?r_id=${r.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>

        </table>
    </div>


</body>
</html>
