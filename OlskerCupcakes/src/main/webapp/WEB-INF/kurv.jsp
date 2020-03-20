<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <button type="submit" class="btn btn-link" value="kurv" onclick="change(this.value)">Gå til kurv <span class="badge badge-pill badge-danger">${fn:length(sessionScope.basket)}</span></button>
                |
                <button type="submit" class="btn btn-link" value="tidligereordre" onclick="change(this.value)">Gå til
                    tidligere ordre
                </button>
                |
                <button type="submit" class="btn btn-link" id="logUdKnap" value="LogUd" onclick="change(this.value)">Log
                    ud
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
    <c:set var="sumTotal" value="${0}" />
<c:forEach var="e" items="${sessionScope.basket}">
    <c:set var="sumTotal" value="${sumTotal + e.totalPrice}" />
    <tr>
        <td>${e.bottom}</td>
        <td>${e.topping}</td>
        <td>${e.amount}</td>
        <td>${e.totalPrice} kr</td>

        <td>
            <form action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteOrderline">
                <input type="hidden" name="unikId" value="${e.lineId}">
                <button type="submit" class="btn btn-link" >Fjern</button>
            </form>
        </td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="3">&nbsp;</td>
        <td>${sumTotal} kr</td>
        <td>&nbsp;</td>
    </tr>
    </tbody>
</table>

<c:if test="${empty sessionScope.basket}">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h5>Din kurv er tom</h5>
        </div>
    </div>
</c:if>


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
