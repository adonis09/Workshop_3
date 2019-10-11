<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>groups</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>All groups</h3>

<table border="1px solid black">
    <tr>
        <th>Group name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="oneGroup" items="${groups}">
        <tr>
            <td>${oneGroup.name}</td>
            <td>
                <a href='<c:url value="/groupDetails?id=${oneGroup.id}"/>'>details</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>
