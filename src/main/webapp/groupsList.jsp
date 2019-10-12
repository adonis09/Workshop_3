<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>groups list</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>All groups administration</h3>

<h4>Add new group</h4>
<c:if test="${not empty editGroup.name}">
    <form action="/editGroup" method="POST">
        Name: <input type="text" name="name" value="${editGroup.name}">
        <input type="hidden" name="editId" value="${editGroup.id}">
        <input type="submit" value="Submit">
    </form>
</c:if>
<c:if test="${empty editGroup.name}">
    <form action="/groupsList" method="POST">
        Name: <input type="text" name="name">
        <input type="submit" value="Submit">
    </form>
</c:if>
<h4>All groups</h4>
<table border="1px solid black">
    <tr>
        <th>Group name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="oneGroup" items="${groups}">
        <tr>
            <td>${oneGroup.name}</td>
            <td>
                <a href='<c:url value="/editGroup?editId=${oneGroup.id}"/>'>edit</a>
                <a href='<c:url value="/deleteGroup?deleteId=${oneGroup.id}"/>'>delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>