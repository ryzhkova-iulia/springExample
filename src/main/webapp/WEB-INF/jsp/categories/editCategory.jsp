<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Category</title>
</head>
<body>

<h1>Edit Category</h1>
<c:url var="saveUrl" value="/category/edit?id=${categoryAttribute.id}" />
<form:form modelAttribute="categoryAttribute" method="POST" action="${saveUrl}">
 <table>
      <tr>
       <td><form:label path="id">Id:</form:label></td>
       <td><form:input path="id" disabled="true"/></td>
      </tr>

      <tr>
       <td><form:label path="name"> Name:</form:label></td>
       <td><form:input path="name"/></td>
      </tr>
  </table>

 <input type="submit" value="Save" />
</form:form>

</body>
</html>