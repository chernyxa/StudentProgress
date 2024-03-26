<%--
  Created by IntelliJ IDEA.
  User: cmp1
  Date: 19.06.2021
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resoures/css/discipline-modify.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    <script type="text/javascript" src="../../resoures/js/function.js?v=2" charset="UTF-8"></script>

    <title>Студенты</title>
</head>
<body>
<section class="sheme_students"></section>
<div class="container">
    <div class="sheme_input">
        <ul class="nav nav-pills navbar">
            <li class="nav-item ">
                <a class="nav-link active home" aria-current="page" href="../index.jsp">На главную</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link active exit" aria-current="page" href="#">Выход</a>
            </li>

        </ul>


    </div>
    <h1>Система управления студентами и их успеваемостью</h1>

    <div class="form_student">
        <div class="row">
            <div class="col-md-6">
                <p>Для того что бы модифицировать дисциплину заполните все поля и нажмите кнопку "Применить"</p>

                <div class="input-group mb-3 form_disc">
                    <form action="/discipline-modify" method="post">
                        <input name="id" type="hidden" value="${disc.id}">
                        <span class="input-group-text">Название</span>
                        <input name="disc" type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default" value="${disc.discipline}">
                        <input class="btn btn-primary apply1" type="submit" value="Применить">
                    </form>
                    <c:if test="${message eq 'error'}">
                        <div class="alert alert-primary d-flex align-items-center" role="alert">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                                <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                            </svg>
                            <div>
                                Поля не должны быть пустыми
                            </div>
                        </div>
                    </c:if>
                </div>


            </div>
        </div>
    </div>

</div>
</section>

</body>
