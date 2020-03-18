<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    <div class="col-lg-6 text-left">
        <%--        <a href="FrontController?target=redirect&destination=customerpage">Gå til Shop</a> |--%>
        <%--        <a href="FrontController?target=redirect&destination=kurv">Gå til kurv</a> |--%>
        <%--        <a href="FrontController?target=redirect&destination=tidligereordre">Gå til tidligere ordre</a>--%>

        <form action="FrontController" method="post">
            <input type="hidden" name="target" id="target" value="customerpage">
            <button type="submit" class="btn btn-link" value="customerpage">Gå til Shop</button>
            |
            <button type="submit" class="btn btn-link" value="kurv" onclick="change(this.value)">Gå til kurv</button>
            |
            <button type="submit" class="btn btn-link" value="tidligereordre" onclick="change(this.value)">Gå til
                tidligere ordre
            </button>
        </form>
    </div>
    <div class="col-lg-6 text-right">
        <p id="loginInf">Du er logget ind som ${sessionScope.email}</p>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4" id="tagline">Indkøbskurv</h1>
    </div>
</div>

<hr/>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Bund</th>
        <th scope="col">Top</th>
        <th scope="col">Antal</th>
        <th scope="col">Samlet pris</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td>Chokolade</td>
        <td>Blueberry</td>
        <td>12</td>
        <td>75,00 kr</td>
        <td><a href="#" class="danger">Fjern</a></td>
    </tr>
    <tr>
        <td><p class="font-weight-bold">Samlet pris: </p></td>
        <td></td>
        <td></td>
        <td></td>
        <td>525,00 kr</td>
    </tr>
    </tbody>
</table>


<div class="row">
    <div class="col-lg-12 text-center">
        <div class="form-group">
            <form name="shop" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="bestil">
                <input type="submit" class="btn-lg btn-success mt-4" value="Afgiv ordre"/>
            </form>
        </div>
    </div>
</div>

<%@include file="../includes/footer.inc" %>
