<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        

        <h1>Hello Supreme Leader! </h1>



        You are now logged in as ${sessionScope.email} of our Glorious site.

        <br>
        <br>
        <br>
        <form name="oversigt" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="oversigt">
            <input type="submit" value="Oversigt">
        </form>
        <br>
        <form action="FrontController" method="post">
        <input type="hidden" name="taget" value="logout">
        <input type="submit" value="Logout">
        </form>
    </body>
</html>
