<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    <div class="col-lg-6 text-left">
        <a href="FrontController?target=redirect&destination=adminpage">Ordreoversigt</a> |
        <a href="FrontController?target=redirect&destination=kundekartotek">Kundekartotek</a>
    </div>
    <div class="col-lg-6 text-right">
        <p id="loginInf">Du er logget ind som ${sessionScope.email}</p>
    </div>
</div>

<div class="row">
    ${requestScope.besked}
    <div class="col-lg-12 text-center mt-5">

        <h1 class="display-4" id="tagline">Brugeradministration</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-3 text-center mt-5">
        <h6 class="mb-5">Indsæt penge på kundekonto</h6>

        <div class="form-group">
            <form name="indsaetPenge" action="FrontController" method="POST">
                <input type="text" class="form-control" placeholder="Kunde email" name="email">
                <input type="text" class="form-control mt-4" placeholder="Beløb" name="credit">
                <input type="hidden" name="target" value="addCredit">
                <input type="submit" class="btn btn-success mt-4" value="Indsæt" />
            </form>
        </div>
    </div>

    <div class="col-lg-3 text-center mt-5">
        <h6 class="mb-5">Nulstil password</h6>
        <input type="text" class="form-control" placeholder="Kunde email" name="kundeMailPassword">
        <div class="form-group">
            <form name="nulstil" action="FrontController" method="POST">
                <input type="hidden" name="target" value="nulstil">
                <input type="submit" class="btn btn-warning mt-4" value="Nulstil" />
            </form>
        </div>
    </div>

    <div class="col-lg-3 text-center mt-5">
        <h6 class="mb-5">Slet en ordre</h6>
        <input type="text" class="form-control" placeholder="Angiv ID" name="ordreID">
        <div class="form-group">
            <form name="sletOrdre" action="FrontController" method="POST">
                <input type="hidden" name="target" value="sletOrdre">
                <input type="submit" class="btn btn-danger mt-4" value="Slet" />
            </form>
        </div>
    </div>

    <div class="col-lg-3 text-center mt-5">
        <h6 class="mb-5">Slet en kunde</h6>

        <div class="form-group">
            <form name="sletKunde" action="FrontController" method="POST">
                <input type="hidden" name="target" value="deleteUser">
                <input type="text" class="form-control" placeholder="Kunde email" name="email">
                <input type="submit" class="btn btn-danger mt-4" value="Slet" />
            </form>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4" id="tagline">Kundekartotek</h1>
    </div>
</div>


<table class="table table-striped text-center">
    <thead>
    <tr>
        <th scope="col">Kunde ID</th>
        <th scope="col">Email</th>
        <th scope="col">Telefonnummer</th>
        <th scope="col">Kontobeløb</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>ikkesteinbagger@gmail.com</td>
        <td>42447831</td>
        <td>150</td>
    </tr>
    <tr>
        <td>2</td>
        <td>bestemtikkesteinbagger@gmail.com</td>
        <td>42447831</td>
        <td>1550</td>
    </tr>
    <tr>
        <td>3</td>
        <td>steinbaggernooot@gmail.com</td>
        <td>42447831</td>
        <td>15</td>
    </tr>
    </tbody>
</table>

<%@include file="../includes/footer.inc" %>
