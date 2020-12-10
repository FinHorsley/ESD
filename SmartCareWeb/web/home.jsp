<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
                overflow: hidden;
                background-color: #DFDED2;
            }

            .topnav a {
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
                color: black;
            }
            .left {
                float: left;
            }

            .right {
                float: right;
                padding-right: 16px;
            }
            .topnav a:hover {
                background-color: #D2D1C4;
                color: black;
            }

            .topnav a.title {
                background-color: #DFDED2;
                color: black;
                font-size: 20px;
            }
        </style>
        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title>
    </head>
    <body>

        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <p> ${user.uname} (${user.role})</p>  
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Website Admin Panel</h1>
            <br><br>
            <a href="/logout">Logout</a>
        </div>
    </body>
</html>
