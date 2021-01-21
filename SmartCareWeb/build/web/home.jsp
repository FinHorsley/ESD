<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title> <%-- display title--%>
    </head>
    <body>

        <div class="topnav">
            <a class="title left">SmartCare Home Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a> <%-- navigation menu --%>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/role">Client Area</a>           
                
            </div>

        </div>

        <div style="text-align: center">
            <h1>SmartCare Home Page</h1> <%-- display text --%>
            <h2>Welcome ${user.uname}</h2> <%-- display welcome message with user name --%>
            <br><br>
        </div>
    </body>
</html>
