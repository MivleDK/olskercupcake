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
            <button type="submit" class="btn btn-link" id="logUdKnap" value="logout" name="logout" onclick="change(this.value)">Log
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
        <h1 class="display-4" id="tagline">Tidligere ordrer</h1>
    </div>
</div>

<hr/>

<c:forEach var="e" items="${requestScope.orders}">
<table class="table table-striped mt-5 mb-5">
    <thead>
    <tr>
        <th scope="col">Ordre ID:</th>
        <th scope="col">${e.ordersId}</th>
        <th scope="col">Dato:</th>
        <th scope="col">${e.ordersDate}</th>
    </tr>
    <tr>
        <th scope="col">Bund</th>
        <th scope="col">Top</th>
        <th scope="col">Antal</th>
        <th scope="col">Pris</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="sumTotal" value="${0}" />
    <c:forEach var="list" items="${requestScope.previousOrders}">
        <c:choose>
            <c:when test="${e.ordersId == list.ordersId}">
                <c:set var="sumTotal" value="${sumTotal + list.sum}" />
                <tr>
                    <td>${list.bottom}</td>
                    <td>${list.topping}</td>
                    <td>${list.quantity}</td>
                    <td>${list.sum} kr</td>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>

    <tr>
        <td></td>
        <td></td>
        <td>Total:</td>
        <td>${sumTotal} kr</td>
    </tr>
    </tbody>
</table>
<div class="spacer"></div>
</c:forEach>


<%@include file="../includes/footer.inc" %>
