<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    <div class="col-lg-6 text-left">
        <!--<a href="FrontController?target=redirect&destination=adminpage">Ordreoversigt</a> |
        <a href="FrontController?target=redirect&destination=kundekartotek">Kundekartotek</a>-->
        <form action="FrontController" method="post">
            <input type="hidden" name="target" id="target" value="adminpage">
            <input type="submit" class="btn btn-link" value="Ordreoversigt" />
            |
            <input type="submit" value="kundekartotek" onclick="change(this.value)" class="btn btn-link" value="Kundekartotek" />
            |
            <button type="submit" class="btn btn-link" id="logUdKnap" value="logout" name="logout" onclick="change(this.value)">Log ud</button>
        </form>
    </div>
    <div class="col-lg-6 text-right">
        <p id="loginInf">Du er logget ind som ${sessionScope.email}</p>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4" id="tagline">Adminside</h1>
    </div>
</div>


<table class="table table-striped text-center">
    <thead>
    <tr>
        <th scope="col">Ordre ID</th>
        <th scope="col">Dato</th>
        <th scope="col">Ordrestatus</th>
        <th scope="col">Email</th>
        <th scope="col">Antal</th>
        <th scope="col">Samlet pris</th>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>3</td>
        <td>10-03-2020</td>
        <td>
            <select class="custom-select" name="ordrestatus">
                <option>Bestilt</option>
                <option>Behandler</option>
                <option>Afsluttet</option>
            </select>
        </td>
        <td>ikkeSteinBagger@gmail.com</td>
        <td>12</td>
        <td>525,00 kr</td>
        <td>
            <form name="opdaterOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
            <input type="hidden" name="target" value="opdater">
            <input type="hidden" name="opdaterOrdre" value="">
            <input type="submit" class="btn btn-success btn-sm" value="Opdater" />
            </form>
        </td>
        <td>
            <input type="button" class="btn btn-primary btn-sm" value="Vis ordre">
        </td>
        <td>
            <form name="sletOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteOrder">
                <input type="hidden" name="orderId" value="">
                <input type="submit" class="btn btn-danger btn-sm" value="Slet" onclick="return confirm('Er du sikker på at du vil slette?')"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>10-03-2020</td>
        <td>
            <select class="custom-select" name="ordrestatus">
                <option>Bestilt</option>
                <option>Behandler</option>
                <option>Afsluttet</option>
            </select>
        </td>
        <td>ikkeSteinBagger@gmail.com</td>
        <td>12</td>
        <td>525,00 kr</td>
        <td>
            <form name="opdaterOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="opdater">
                <input type="hidden" name="opdaterOrdre" value="">
                <input type="submit" class="btn btn-success btn-sm" value="Opdater" />
            </form>
        </td>
        <td>
            <input type="button" class="btn btn-primary btn-sm" value="Vis ordre">
        </td>
        <td>
            <form name="sletOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteOrder">
                <input type="hidden" name="orderId" value="">
                <input type="submit" class="btn btn-danger btn-sm" value="Slet" onclick="return confirm('Er du sikker på at du vil slette?')"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>10-03-2020</td>
        <td>
            <select class="custom-select" name="ordrestatus">
                <option>Bestilt</option>
                <option>Behandler</option>
                <option>Afsluttet</option>
            </select>
        </td>
        <td>ikkeSteinBagger@gmail.com</td>
        <td>12</td>
        <td>525,00 kr</td>
        <td>
            <form name="opdaterOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="opdater">
                <input type="hidden" name="opdaterOrdre" value="">
                <input type="submit" class="btn btn-success btn-sm" value="Opdater" />
            </form>
        </td>
        <td>
            <input type="button" class="btn btn-primary btn-sm" value="Vis ordre">
        </td>
        <td>
            <form name="sletOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteOrder">
                <input type="hidden" name="orderId" value="">
                <input type="submit" class="btn btn-danger btn-sm" value="Slet" onclick="return confirm('Er du sikker på at du vil slette?')"/>
            </form>
        </td>
    </tr>
    </tbody>
</table>

<%@include file="../includes/footer.inc" %>
