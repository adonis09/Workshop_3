<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exercises list</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>All exercises administration</h3>

<c:if test="${not empty editExercise}">
    <h4>Edit existing exercise</h4>
    <form action="/editExercise" method="POST">
        Title: <input type="text" name="title" value="${editExercise.title}">
        Description: <input type="text" name="description" value="${editExercise.description}">
        <input type="hidden" name="editId" value="${editExercise.id}">
        <input type="submit" value="Submit">
    </form>
</c:if>
<c:if test="${empty editExercise}">
    <h4>Add new exercise</h4>
    <form action="/exercisesList" method="POST">
        Title: <input type="text" name="title">
        Description: <input type="text" name="description">
        <input type="submit" value="Submit">
    </form>
</c:if>

<h4>All exercises</h4>

<table border="1px solid black">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach var="oneExercise" items="${exercises}">
        <tr>
            <td>
                ${oneExercise.title}
            </td>
            <td>
                ${oneExercise.description}
            </td>
            <td>
                <a href='<c:url value="/editExercise?editId=${oneExercise.id}"/>'>edit</a>
                <a href='<c:url value="/deleteExercise?deleteId=${oneExercise.id}"/>'>delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>