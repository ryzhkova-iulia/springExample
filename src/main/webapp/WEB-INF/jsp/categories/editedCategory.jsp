<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit category</title>
</head>
<body>

<p>You have edited a category with id ${id} at <%= new java.util.Date() %></p>

<c:url var="categoryUrl" value="/categories/" />
<p>Return to <a href="${categoryUrl}">Categories</a></p>

<c:url var="mainUrl" value="/" />
<p>Return to <a href="${mainUrl}">Main List</a></p>

</body>
</html>