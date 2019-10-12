<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>administration panel</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>Administration panel</h3>

<a href='<c:url value="/exercisesList"/>'>exercises</a>
<a href='<c:url value="/groupsList"/>'>groups</a>
<a href='<c:url value="/usersList"/>'>users</a>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>
