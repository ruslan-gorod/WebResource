<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add resource</title>
</head>
<body>
<h2>Add new resource</h2>

<spring:form modelAttribute="resource" action="/add-resource" method="post">
    <label for="name">Name</label>
    <spring:input path="name" id="name"/>
    <label for="url">Description</label>
    <spring:input path="url" id="url"/>
    <button type="submit">Submit</button>
</spring:form>
</body>
</html>
