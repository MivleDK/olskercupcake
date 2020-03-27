<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<link href="<c:url value="/includes/style.css" />" rel="stylesheet">
<%@include file="/includes/header.inc" %>

<div class="row">
    <div class="col-lg-12 text-center mt-5">
        <h1 class="display-4" id="tagline" style="padding-bottom: 25px;">Ordreoversigt</h1>
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
                <form name="opdaterOrdre" id="opdaterOrdre_${order.ordersId}" action="FrontController" method="post"
                      style="margin-bottom: 0px;">
                    <input type="hidden" name="target" value="updateOrderStatus">
                    <input type="hidden" name="opdaterOrdreID" value="${order.ordersId}">
                    <select class="custom-select" name="ordrestatus">
                        <option>${order.status}</option>
                        <option>Bestilt</option>
                        <option>Behandler</option>
                        <option>Afsluttet</option>
                    </select>
                </form>
            </td>
            <td>${order.email}</td>
            <td>${order.quantity}</td>
            <td>${order.total} kr</td>
            <td>
                <input type="submit" form="opdaterOrdre_${order.ordersId}" class="btn btn-success btn-sm"
                       value="Opdater"/>
            </td>
            <td>

                <button class="btn btn-success btn-sm" type="button" data-toggle="collapse"
                        data-target="#collapse_${order.ordersId}" aria-expanded="false" aria-controls="collapseExample">
                    Vis ordre
                </button>

            </td>
            <td>
                <form name="sletOrdre" action="FrontController" method="post" style="margin-bottom: 0px;">
                    <input type="hidden" name="target" value="deleteOrder">
                    <input type="hidden" name="orderId" value="${order.ordersId}">
                    <input type="submit" class="btn btn-danger btn-sm" value="Slet"
                           onclick="return confirm('Er du sikker på at du vil slette?')"/>
                </form>
            </td>
        </tr>
        <tr class="collapse" style="background-color: #ffffff" id="collapse_${order.ordersId}">
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

                    <c:forEach var="orderLine" items="${requestScope.AllOrderlines}">

                        <c:choose>
                            <c:when test="${order.ordersId == orderLine.ordersId}">
                                <tr style="background-color: #ffffff">
                                    <td>${orderLine.bottom}</td>
                                    <td>${orderLine.topping}</td>
                                    <td>${orderLine.quantity}</td>
                                    <td>${orderLine.sum} kr</td>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                    </tbody>
                </table>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%@include file="../includes/footer.inc" %>
