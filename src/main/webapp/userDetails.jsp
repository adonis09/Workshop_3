<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user details</title>
</head>
<body>

<jsp:include page="WEB-INF/header.jsp"/>

<h3>Detailed information on user ${user.userName}</h3>

Name: ${user.userName}
Email: ${user.email}

<h4>Solutions submitted by user:</h4>

<table border="1px solid black">
    <tr>
        <th>Exercise title</th>
        <th>Submission date and time</th>
        <th>Action</th>
    </tr>

    <c:forEach var="oneSolution" items="${solutions}">
        <c:if test="${not empty oneSolution.updated}">
            <tr>
                <td>
                    <c:forEach var="oneExercise" items="${exercises}">
                        <c:if test="${oneSolution.exerciseId == oneExercise.id}">
                            ${oneExercise.title}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${oneSolution.updated}</td>
                <td>
                    <a href='<c:url value="/details?id=${oneSolution.id}"/>'>details</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>

</body>
</html>
