<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<html>
<head>
<title>News</title>
</head>
<body>
   <h2>${message}</h2>
   <c:url var="addUrl" value="/add" />

   <button><a href="${addUrl}">Add News</a></button>

   <c:forEach items="${items}" var="item">
        <c:url var="deleteUrl" value="/delete?id=${item.id}" />
        <c:url var="editUrl" value="/edit?id=${item.id}" />
    <p>
        <h2>${item.name}</h2>
        <div>${item.text}</div>

        <button><a href="${editUrl}">Edit</a></button>
        <button><a href="${deleteUrl}">Delete</a></button><br>
        <p>Created date <%= new java.util.Date() %></p>
    </p>
   </c:forEach>
</body>
</html>