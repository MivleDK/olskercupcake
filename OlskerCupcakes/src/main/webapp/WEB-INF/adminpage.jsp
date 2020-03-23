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
            <input type="submit" class="btn btn-link" value="Ordreoversigt"/>
            |
            <input type="submit" value="kundekartotek" onclick="change(this.value)" class="btn btn-link"
                   value="Kundekartotek"/>
            |
            <button type="submit" class="btn btn-link" id="logUdKnap" value="logout" name="logout"
                    onclick="change(this.value)">Log ud
            </button>
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


<table class="table table-striped-2nth text-center">
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

    <c:forEach var="order" items="${requestScope.allOrders}">

    <tr>

        <td>${order.ordersId}</td>
        <td>${order.ordersDate}</td>
        <td>
            <select class="custom-select" name="ordrestatus">
                <option>${order.status}</option>
                <option>Bestilt</option>
                <option>Behandler</option>
                <option>Afsluttet</option>
            </select>
        </td>
        <td>${order.email}</td>
        <td>${order.quantity}</td>
        <td>${order.total} kr</td>
        <td>
            <form name="opdaterOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="opdater">
                <input type="hidden" name="opdaterOrdre" value="">
                <input type="submit" class="btn btn-success btn-sm" value="Opdater"/>
            </form>
        </td>
        <td>

            <button class="btn btn-success btn-sm" type="button" data-toggle="collapse" data-target="#collapse_${order.ordersId}" aria-expanded="false" aria-controls="collapseExample">
                Vis ordre
            </button>


<!--
            <div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Din ordre</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">-->

                        <!--</div>
                    </div>
                </div>
            </div>-->


        </td>
        <td>
            <form name="sletOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                <input type="hidden" name="target" value="deleteOrder">
                <input type="hidden" name="orderId" value="">
                <input type="submit" class="btn btn-danger btn-sm" value="Slet"
                       onclick="return confirm('Er du sikker på at du vil slette?')"/>
            </form>
        </td>
    </tr>
        <tr class="collapse" style="background-color: #ffffff"  id="collapse_${order.ordersId}">
            <td colspan="9">
                <table class="table">
                    <thead>
                    <tr style="background-color: #ffffff">
                        <th scope="col">Bund</th>
                        <th scope="col">Top</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Pris</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr style="background-color: #ffffff">
                        <td>Chokolade</td>
                        <td>Vanilje</td>
                        <td>3</td>
                        <td>75 kr</td>
                    </tr>
                    <tr style="background-color: #ffffff">
                        <td>Chokolade</td>
                        <td>Vanilje</td>
                        <td>3</td>
                        <td>75 kr</td>
                    </tr>
                    <tr style="background-color: #ffffff">
                        <td>Chokolade</td>
                        <td>Vanilje</td>
                        <td>3</td>
                        <td>75 kr</td>
                    </tr>

                    </tbody>
                </table>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%@include file="../includes/footer.inc" %>
