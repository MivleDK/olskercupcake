<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="includes/header.inc" %>

<link href="<c:url value="includes/style.css" />" rel="stylesheet">

<div class="row">
    <div class="col-lg-12 text-center">
        <h1 class="display-1">Velkommen</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12 text-center">
        <h1 class="display-4" id="tagline">Til Olsker Cupcakes</h1>
    </div>
</div>
<hr/>


<c:if test="${requestScope.error!= null}">

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

<div class="row">
    <div class="col-lg-6 text-center">
        <h1 class="h2">Log på</h1>
        <p>Hvis du er eksisterende bruger</p>
        <br/>
        <form action="FrontController" name="login" method="POST">
            <div class="form-group">
<input type="hidden" name="target" value="login">
                <input type="email" name="email" class="form-control" id="InputEmail1" placeholder="E-mail">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" id="password1" placeholder="Adgangskode">
            </div>
            <button type="submit" value="submit" class="btn btn-success">Log på</button>
        </form>

    </div>
    <div class="col-lg-6 text-center">
        <h1 class="h2">Ny bruger</h1>
        <p>Hvis du ikke har handlet hos os før</p>
        <br/>

        <form action="FrontController" method="POST" name=""register>
            <div class="form-group">
                <input type="hidden" name="target" value="register">
                <input type="email" class="form-control" id="OpretInputEmail1" placeholder="E-mail" name="email">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="Oprettelefon" name="phone" placeholder="Telefonnummer">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password1" placeholder="Adgangskode">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password2" placeholder="Gentag adgangskode">
            </div>
            <button type="submit" value="submit" class="btn btn-success">Opret bruger</button>
        </form>
        <br/>
        <div class="alert alert-warning" role="alert">
            Bemærk:<br/>Du skal betale fysisk i butikken
        </div>

    </div>
</div>

<%@include file="includes/footer.inc" %>
