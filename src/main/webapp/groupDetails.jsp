<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>All users from group ${param.name}</h3>

<table border="1px solid black">
    <tr>
        <th>User name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="oneUser" items="${users}">
        <tr>
            <td>${oneUser.userName}</td>
            <td>
                <a href='<c:url value="/userDetails?id=${oneUser.id}"/>'>details</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>
