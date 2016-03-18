<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>News</title>
</head>
<body>
   <c:url var="addUrl" value="/category/add" />

   <button><a href="${addUrl}">Add Category</a></button>

   <c:forEach items="${items}" var="item">
        <c:url var="deleteUrl" value="/category/delete?id=${item.id}" />
        <c:url var="editUrl" value="/category/edit?id=${item.id}" />
    <p>
       <h3 style="margin: 0;">${item.name}</h3>
       <div>Created date <fmt:formatDate pattern="dd-MM-YYYY HH:mm" value="${item.date}" /></div>
       <button><a href="${editUrl}">Edit</a></button>
       <button><a href="${deleteUrl}">Delete</a></button><br>
    </p>
   </c:forEach>
   <c:url var="mainUrl" value="/" />
   <p>Return to <a href="${mainUrl}">Main List</a></p>
</body>
</html>