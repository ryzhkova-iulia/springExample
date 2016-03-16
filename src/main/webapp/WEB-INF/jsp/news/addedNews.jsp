<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<title>Add news</title>
</head>

<body>

   <p>You have added a new news at <%= new java.util.Date() %></p>

   <c:url var="mainUrl" value="/" />
   <p>Return to <a href="${mainUrl}">Main List</a></p>
</body>

</html>
