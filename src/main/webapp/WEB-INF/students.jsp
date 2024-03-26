<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resourses/css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <script type="text/javascript" src = "../resourses/js/functions.js?v=2323"></script>
    <title>student</title>
</head>
<body>
<aside class="navigation">
    <a href="#" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью

    </h1>

    <div class="student-btns">
        <div class="student-btns1">
            <input onclick="studentProgress()" type="submit" class="student-btn" value=" посмотреть успеваемость студента"/>
            <input onclick="studentModify()" type="submit" class="student-btn" value=" модифицировать выбранного студента"/>
        </div>
        <div class="student-btns1">
            <form action="/student-create" method="get">
            <input type="submit" class="student-btn" value="создать студента"/>
            </form>
            <input onclick="studentDelete()" type="submit" class="student-btn" value=" удалить выбраных студентов"/>
        </div>
    </div>
    <h2 class="heading-secondary">
        список студентов
    </h2>
    <table class="student-table" border="1">
        <tr>
            <th>&nbsp</th>
            <th>фамилия</th>
            <th>имя</th>
            <th>группа</th>
            <th>дата поступления</th>
        </tr>

    <c:forEach items="${students}" var="st">
        <tr>
            <td> <input class="checkbox" type="checkbox" id="" value="${st.id}">
            </td>
            <td>${st.surname}</td>
            <td>${st.name}</td>
            <td>${st.group}</td>
            <td><fmt:formatDate value="${st.date}" pattern="dd/MM/yyyy"/></td>
        </tr>
    </c:forEach>
    </table>

</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>

</aside>

<form action="/student-modify" method="get" id = "formToModify">
    <input type="hidden" name="hiddenModifyId" id = "hiddenToModify">
</form>

<form action="/student-delete" method="get" id = "formToDelete">
    <input type="hidden" name="hiddenIdsToDelete" id = "hiddenIdsToDelete">
</form>

<form action="/student-progress" method="get" id = "formToProgress">
    <input type="hidden" name="hiddenIdToProgress" id = "hiddenIdToProgress">
</form>

</body>
</html>
