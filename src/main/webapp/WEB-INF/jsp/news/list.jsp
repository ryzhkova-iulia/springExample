<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>News</title>
</head>
<body>
   <h2>${message}</h2>
   <c:url var="addUrl" value="/add" />
   <c:url var="addUrlCategory" value="/category/add" />

   <a href="${addUrl}">Add News</a>&nbsp;
   <a href="${addUrlCategory}">Add Category</a>

   <c:forEach items="${items}" var="item">
        <c:url var="deleteUrl" value="/delete?id=${item.id}" />
        <c:url var="editUrl" value="/edit?id=${item.id}" />
    <p>
        <h3 style="margin: 0;">${item.name}</h3>
        <div>Created date <fmt:formatDate pattern="dd-MM-YYYY HH:mm" value="${item.date}" /></div>
        <c:if test="${not empty item.category}">
            <div>Category: ${item.category.name}</div>
        </c:if>
        <div>${item.text}</div>

        <button><a href="${editUrl}">Edit</a></button>
        <button><a href="${deleteUrl}">Delete</a></button><br>
    </p>
   </c:forEach>
</body>
</html>