<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h2>${message}</h2>
   <c:forEach items="${items}" var="item">
    <p>
        <h2>${item.name}</h2>
        <div>${item.text}</div>
    </p>
   </c:forEach>
</body>
</html>