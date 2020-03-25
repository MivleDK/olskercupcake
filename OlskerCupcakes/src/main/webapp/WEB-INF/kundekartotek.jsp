<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    ${requestScope.besked}
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4 tagline">Kundekartotek</h1>
    </div>
</div>


<table class="table table-striped-2nth text-center">
    <thead>
    <tr>
        <th scope="col">Kunde ID</th>
        <th scope="col">Email</th>
        <th scope="col">Telefonnummer</th>
        <th scope="col">Kontobeløb</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="element" items="${requestScope.kundekartotek}">
    <tr>
        <td>${element.id}</td>
        <td>${element.email}</td>
        <td>${element.phone}</td>
        <td>${element.credit}</td>
        <td>
            <button class="btn btn-success btn-sm" type="button" data-toggle="collapse" data-target="#collapse_${element.id}" aria-expanded="false" aria-controls="collapseExample">
                Indsæt
            </button>

        </td>
        <td>
            <form action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="resetcode">
                <input type="hidden" name="id" value="${element.id}">
                <input type="hidden" name="email" value="${element.email}">
                <input type="submit" class="btn btn-warning btn-sm" onclick="return confirm('Er du sikker på at du vil nulstille kode?')" value="Nulstil" />
            </form>

        </td>
        <td>
            <form name="sletKunde" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteUser">
                <input type="hidden" name="email" value="${element.email}">
                <input type="submit" class="btn btn-danger btn-sm" value="Slet" onclick="return confirm('Er du sikker på at du vil slette?')"/>
            </form>
        </td>
    </tr>
    <tr class="collapse" style="background-color: #ffffff" id="collapse_${element.id}">
        <form name="indsaetPenge" action="FrontController" method="POST" style="margin-bottom: 0px;">
            <td colspan="7">
                <div class="row">
                    <div class="col-7">&nbsp;</div>
                    <div class="col-3">
                        <input type="hidden" name="target" value="addCredit">
                        <input type="hidden" name="email" value="${element.email}">
                        <input type="text" class="form-control mt-1" placeholder="Beløb" name="credit">
                    </div>
                    <div class="col-1"><input type="submit" class="btn btn-primary btn-sm mt-1" value="Ok" /></div>
                    <div class="col-1">&nbsp;</div>
                </div>
            </td>
        </form>
    </tr>
    </c:forEach>

    </tbody>
</table>

<%@include file="../includes/footer.inc" %>
