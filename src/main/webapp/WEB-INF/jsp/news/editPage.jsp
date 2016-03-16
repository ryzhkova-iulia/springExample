<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit News</h1>
<c:url var="saveUrl" value="/edit?id=${newsAttribute.id}" />
<form:form modelAttribute="newsAttribute" method="POST" action="${saveUrl}">
 <table>
  <tr>
   <td><form:label path="id">Id:</form:label></td>
   <td><form:input path="id" disabled="true"/></td>
  </tr>

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