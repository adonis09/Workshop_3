<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>programming school homepage</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<table border="1px solid black">
    <tr>
        <th>Exercise title</th>
        <th>Solution author</th>
        <th>Submission date and time</th>
        <th>...</th>
    </tr>

    <c:forEach var="oneSolution" items="${solutions}">
        <tr>
            <td>${oneSolution.exerciseId}</td>
            <td>${oneSolution.userId}</td>
            <td>${oneSolution.updated}</td>
            <td>
                Details
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>