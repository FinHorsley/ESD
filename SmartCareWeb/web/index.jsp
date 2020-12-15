<%-- 
    Document   : index
    Created on : 08-Dec-2020, 16:17:22
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
    </head>
    <body>

        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <a class="right" href="login.jsp">Login</a>
            <a class="right" href="registration.jsp">Register</a>
        </div>


        <div style="padding-left:16px">
            <h2>Top Navigation Example</h2>
            <p>Some content..</p>
        </div>

    </body>
</html>
