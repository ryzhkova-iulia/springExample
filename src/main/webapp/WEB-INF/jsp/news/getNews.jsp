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
   <form:form modelAttribute="item" method="POST" action="${saveUrl}">
    <table>
         <tr>
              <td><form:label path="name"> Name:</form:label></td>
              <td><form:input path="name"/></td>
         </tr>
         <tr>
              <td><form:label path="text">Text:</form:label></td>
              <td><form:input path="text"/></td>
         </tr>
        <tr>
            <td>Category:</td>
            <td>
                <select name="categoryId">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">[${category.id}] - ${category.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
     </form:form>
</body>
</html>