<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Welcome to SmartCare Website Admin Panel</h1>
            <b>${user.uname} (${user.role})</b>
            <br><br>
            <a href="/logout">Logout</a>
        </div>
    </body>
</html>
