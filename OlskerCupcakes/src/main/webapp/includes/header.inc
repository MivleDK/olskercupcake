<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="OlskerCupcakes/src/main/webapp/includes/style.css" />

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

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="menu">
      <a class="navbar-brand" href="index.jsp">Olsker Cupcakes</a>
      <c:choose>
          <c:when test="${sessionScope.user.role == 'admin'}">
              your nav bar for admin
          </c:when>
          <c:when test="${sessionScope.user.role == 'customer'}">
              your nav bar for customer
          </c:when>
          <c:otherwise>
              your nav bar for indexpage
          </c:otherwise>
      </c:choose>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      </div>
    </nav>
<!--
########################
    NAVBAR SLUTTER
########################
-->

<div class="container" id="main-container">
