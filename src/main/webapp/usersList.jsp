<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users list</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>All users administration</h3>

<h4>Add new user</h4>
<c:if test="${not empty editUser.userName}">
    <form action="/editUser" method="POST">
        Name: <input type="text" name="name" value="${editUser.userName}">
        Email: <input type="email" name="email" value="${editUser.email}">
        Password: <input type="password" name="password" value="${editUser.password}">
        <input type="hidden" name="editId" value="${editUser.id}">
        <input type="submit" value="Submit">
    </form>
</c:if>
<c:if test="${empty editUser.userName}">
    <form action="/usersList" method="POST">
        Name: <input type="text" name="name">
        Email: <input type="email" name="email">
        Password: <input type="password" name="password">
        Group: <select name="group">
            <c:forEach var="oneGroup" items="${groups}">
                <option value="${oneGroup.id}">${oneGroup.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Submit">
    </form>
</c:if>
<h4>All users</h4>
<table border="1px solid black">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="oneUser" items="${users}">
        <tr>
            <td>${oneUser.userName}</td>
            <td>${oneUser.email}</td>
            <td>
                <a href='<c:url value="/editUser?editId=${oneUser.id}"/>'>edit</a>
                <a href='<c:url value="/deleteUser?deleteId=${oneUser.id}"/>'>delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>