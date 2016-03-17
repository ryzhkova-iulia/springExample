<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<html>
<head>
<title>News</title>
</head>
<body>
   <h2>${message}</h2>
   <c:url var="addUrl" value="/category/add" />

   <button><a href="${addUrl}">Add Category</a></button>

   <select name="category">
       <c:forEach items="${items}" var="itemCategory">
            <option value="${itemCategory.id}">${itemCategory.name}
       </c:forEach>
   </select>

   <c:forEach items="${items}" var="item">
        <c:url var="deleteUrl" value="/category/delete?id=${item.id}" />
        <c:url var="editUrl" value="/category/edit?id=${item.id}" />
    <p>
        <h2>${item.name}</h2>

        <button><a href="${editUrl}">Edit</a></button>
        <button><a href="${deleteUrl}">Delete</a></button><br>
        <p>Created date <%= new java.util.Date() %></p>
    </p>
   </c:forEach>
   <c:url var="mainUrl" value="/" />
   <p>Return to <a href="${mainUrl}">Main List</a></p>
</body>
</html>