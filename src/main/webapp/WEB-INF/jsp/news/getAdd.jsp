<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Add news</title>
</head>
<body>
   <h1>Create New News</h1>
   <c:url var="saveUrl" value="/add" />
   <form:form modelAttribute="addNews" method="POST" action="${saveUrl}">
    <table>
     <tr>
      <td><form:label path="name"> Name:</form:label></td>
      <td><form:input path="name"/></td>
     </tr>

     <tr>
      <td><form:label path="text">Text:</form:label></td>
      <td><form:input path="text"/></td>
     </tr>
     <input type="submit" value="Save" />
     </form:form>
</body>
</html>