<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="includes/style.css" />

    <title>Olser Cupcakes</title>
  </head>
  <body>
    <!--
    ########################
        NAVBAR STARTER
    ########################
    -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="brand-bar">
      <div class="container" id="navbar-top">
        <img  href="index.jsp" src="img/logo.png" height="150px" />
      </div>
    </nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="menu" style="width: 100%;">
  <a class="navbar-brand" href="index.jsp">Olsker Cupcakes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="menu">
      <a class="navbar-brand" href="index.jsp">Olsker Cupcakes</a>


      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <c:choose>
          <c:when test="${sessionScope.user.role == 'admin'}">
            <form action="FrontController" method="post" style="width: 100%; margin-bottom: 0px">
              <input type="hidden" name="target" id="target" value="adminpage">
              <input type="submit" class="btn btn-link" value="Ordreoversigt" />
              |
              <input type="submit" value="kundekartotek" onclick="change(this.value)" class="btn btn-link" value="Kundekartotek" />
              |
              <button type="submit" class="btn btn-link" id="logUdKnap" value="logout" name="logout" onclick="change(this.value)">Log ud
              </button>
              |
              <p id="loginInf" style="float:right; margin-top:5px;margin-bottom:5px;line-height: 1em;">Du er logget ind som ${sessionScope.email}</p>
            </form>
          </c:when>

          <c:when test="${sessionScope.user.role == 'customer'}">

            <form action="FrontController" method="post" style="width: 100%; margin-bottom: 0px">
              <input type="hidden" name="target" id="target" value="customerpage">
              <button type="submit" class="btn btn-link" value="customerpage">Shop</button>
              |
              <button type="submit" class="btn btn-link" value="kurv" onclick="change(this.value)">Indk&oslash;bskurv <span class="badge badge-pill badge-danger">${fn:length(sessionScope.basket)}</span></button>
              |
              <button type="submit" class="btn btn-link" value="tidligereordre" onclick="change(this.value)">Tidligere ordre
              </button>
              |
              <button type="submit" class="btn btn-link" id="logUdKnap" value="logout" name="logout" onclick="change(this.value)">Log
                ud
              </button>
              |
              <p id="loginInf" style="float:right; margin-top:5px;margin-bottom:5px;line-height: 1em;">Du er logget ind som ${sessionScope.email}</p>
            </form>
          </c:when>
          <c:otherwise>
            Mums filibaba!
          </c:otherwise>
        </c:choose>
      </div>
  </div>
</nav>

<!--
########################
    NAVBAR SLUTTER
########################
-->

<div class="container" id="main-container">
