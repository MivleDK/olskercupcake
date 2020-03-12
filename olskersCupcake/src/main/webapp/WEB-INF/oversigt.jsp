<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amazingh0rse
  Date: 04-03-2020
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            width: 60%;
        }
        td, th {
            border: 1px solid #dddddd;
            tetxt-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="logout">
    <input type="submit" value="Logout">
</form>
<table>
    <thead>
    <tr>
    <th>Id.</th>
    <th>email</th>
    <th>Telefon nummer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="element" items = "${requestScope.oversigt}">
        <tr>
        <td>${element.id}</td>
        <td>${element.email}</td>
        <td>${element.phone}</td>
        </tr>

    </c:forEach>
    <h2>Antal kunder: ${fn:length(requestScope.oversigt)}</h2>
    </tbody>
</table>

<br>



<table>
<thead>
<tr>
    <th>Tilføj</th>
    <th>Opdater</th>
    <th>Nulstil password</th>
    <th>Slet bruger</th>
</tr>
</thead>
    <tr>
        <td>
            <form name="Tilfoej" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="Tilfoej">
                Email:<br>
                <input type="text" name="email">
                <br>
                Password:<br>
                <input type="text" name="password">
                <br>
                Telefon nummer:<br>
                <input type="text" name="phone">
                <br>
                <input type="submit" value="Tilfoej">
            </form>
        </td>
        <td>
            <form name="Opdater" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="Opdater">
                Email:<br>
                <input type="text" name="email">
                <br>
                Telefon nummer:<br>
                <input type="text" name="phone">
                <br>
                Password:<br>
                <input type="text" name="password">
                <br>
                <input type="submit" value="Opdater ">

            </form>
        </td>
        <td>
            <form name="Nulstil" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="Nulstil">
                Email:<br>
                <input type="text" name="email">
                <br>
                <input type="submit" value="Nulstil ">
            </form>
        </td>
        <td>
            <form name="Slet" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="Slet">
                Email:<br>
                <input type="text" name="email">
                <br>

                <input type="submit" value="Slet ">
            </form>
        </td>

    </tr>
</table>
<form name="adminpage" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="adminpage">
    <input type="submit" value="adminpage">
</form>

</body>
</html>
