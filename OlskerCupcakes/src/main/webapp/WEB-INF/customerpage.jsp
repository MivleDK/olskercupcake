<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4">Velkommen</h1>
        <h1 class="display-4" id="tagline"></h1>
    </div>

</div>
<div class="row">
    <div class="col-lg-12 text-center">
        <h5>Her kan du bygge din egen cupcake</h5>
    </div>
</div>
<hr/>
<div class="row">
    <div class="col-lg-12 text-info">
        <p>${requestScope.besked}</p>
    </div>
</div>
<form name="shop" action="FrontController" method="POST">
<div class="row">

        <div class="col-lg-3 text-center">
            <h5 class="mb-4 mt-4">Vælg en bund</h5>

            <select class="custom-select" name="bottom" id="selectListeButtom">
                <c:forEach var="element" items="${requestScope.bottom}">
                    <option value="${element.id}">${element.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-lg-3 text-center">

            <h5 class="mb-4 mt-4">Vælg en topping</h5>
            <select class="custom-select" name="topping">
                <c:forEach var="element" items="${requestScope.topping}">
                    <option value="${element.id}">${element.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-lg-3 text-center">
            <h5 class="mb-4 mt-4">Angiv antal</h5>
            <input type="text" class="form-control" id="antal" placeholder="Antal" name="antal">
        </div>
        <div class="col-lg-3 text-center">
            <input type="hidden" name="target" value="customerpage">
            <p>&nbsp;</p>
            <input type="submit" class="btn-lg btn-success mt-4" value="Læg i kurv" onclick="getSel1()"/>

        </div>
</div>
</form>

<div class="row">
    <div class="col-lg"></div>
    <div class="col-lg-5 text-center">
        <div class="alert alert-warning mt-4" role="alert">
            Ordrer lagt samme dag bliver tildelt samme ordre ID
        </div>
    </div>
    <div class="col-lg"></div>
</div>


<%@include file="../includes/footer.inc" %>