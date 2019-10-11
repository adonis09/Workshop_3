<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>solution details</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>Details of the solution submitted by user:</h3>

Name: ${pickedUser.userName}
<br>
Email: ${pickedUser.email}
<br>
<br>

<table border="1px solid black">
    <tr>
        <th>Exercise title</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>${pickedExercise.title}</td>
        <td>${pickedExercise.description}</td>
    </tr>
</table>

<br>

<table border="1px solid black">
    <tr>
        <th>Solution id</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Content</th>
        <th>Mark</th>
        <th>Commentary</th>
    </tr>
    <tr>
        <td>${pickedSolution.id}</td>
        <td>${pickedSolution.created}</td>
        <td>${pickedSolution.updated}</td>
        <td>${pickedSolution.description}</td>
        <td>
            <c:if test="${pickedSolution.mark !=0}">
                ${pickedSolution.mark}
            </c:if>
        </td>
        <td>
            <c:if test="${not empty pickedSolution.commentary}">
                ${pickedSolution.commentary}
            </c:if>
        </td>
    </tr>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>
