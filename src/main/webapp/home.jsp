<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>programming school homepage</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>Recently submitted solutions</h3>

<table border="1px solid black">
    <tr>
        <th>Exercise title</th>
        <th>Solution author</th>
        <th>Submission date and time</th>
        <th>Details</th>
    </tr>
    <c:forEach var="oneSolution" items="${solutions}">
        <tr>
            <td>
                <c:forEach var="oneExercise" items="${exercises}">
                    <c:if test="${oneSolution.exerciseId == oneExercise.id}">
                        ${oneExercise.title}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="oneUser" items="${users}">
                    <c:if test="${oneSolution.userId == oneUser.id}">
                        ${oneUser.userName}
                    </c:if>
                </c:forEach>
            </td>
            <td>${oneSolution.updated}</td>
            <td>
                <a href='<c:url value="/details?id=${oneSolution.id}"/>'>-></a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>