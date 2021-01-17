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
        <title>Admin CPanel - SmartCare</title>
    </head>
    <body>

        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class ="title2"> Welcome ${user.uname}! (role: ${user.role})</a>
                <a href = "http://localhost:8080/SmartCareWeb/role">Client Area</a>
                <a href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Home Page</h1>
            <h2>Please select your role below!</h2>
            <br><br>
        </div>
    </body>
</html>
