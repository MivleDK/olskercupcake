<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>


<div class="row">
    <div class="col-lg-6 text-left">
        <!--<a href="FrontController?target=redirect&destination=customerpage">Gå til Shop</a> |
        <a href="FrontController?target=redirect&destination=kurv">Gå til kurv</a> |
        <a href="FrontController?target=redirect&destination=tidligereordre">Gå til tidligere ordre</a>-->
        <form action="FrontController" method="post">
            <input type="hidden" name="target" id="target" value="customerpage">
            <button type="submit" class="btn btn-link" value="customerpage" >Gå til Shop</button>|
            <button type="submit" class="btn btn-link" value="kurv" onclick="change(this.value)">Gå til kurv</button>|
            <button type="submit" class="btn btn-link" value="tidligereordre" onclick="change(this.value)">Gå til tidligere ordre</button>
        </form>
    </div>
    <div class="col-lg-6 text-right">
        <p id="loginInf">Du er logget ind som ${sessionScope.email}</p>
    </div>
</div>



<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4">Velkommen</h1><h1 class="display-4" id="tagline"></h1>
    </div>

</div>
<div class="row">
    <div class="col-lg-12 text-center">
        <h5>Her kan du bygge din egen cupcake</h5>
    </div>
</div>
<hr />

<div class="row">
    <div class="col-lg-3 text-center">
        <h5 class="mb-4 mt-4">Vælg en bund</h5>
        <select class="custom-select" name="bund">
            <option> </option>
            <option>database her</option>
            <option>database her</option>
            <option>database her</option>
            <option>database her</option>
        </select>
    </div>
    <div class="col-lg-3 text-center">
        <h5 class="mb-4 mt-4">Vælg en topping</h5>
        <select class="custom-select" name="topping">
            <option> </option>
            <option>database her</option>
            <option>database her</option>
            <option>database her</option>
            <option>database her</option>
        </select>
    </div>
    <div class="col-lg-3 text-center">
        <h5 class="mb-4 mt-4">Angiv antal</h5>
        <input type="text" class="form-control" id="antal" placeholder="Antal" name="antal">
    </div>
    <div class="col-lg-3 text-center">
        <h5 class="mb-4 mt-4">samlet pris: (jstl)</h5>
        <p>JSTL TAG</p>
    </div>
</div>


<div class="row">
    <div class="col-lg-12 text-center">
        <div class="form-group">
            <form name="shop" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="bestil">
                <input type="submit" class="btn-lg btn-success mt-4" value="Læg i kurv" />
            </form>
        </div>
    </div>
</div>

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
