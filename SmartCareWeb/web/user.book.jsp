<%-- 
    Document   : user.book
    Created on : 15-Dec-2020, 16:32:12
    Author     : kamil
--%>

%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title>
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
        </div>

        <div style="text-align: center">
            <h1>Login</h1>
            <form action="book" method="post">
                <label for="uname">Username:</label>
                <input name="uname" size="30" />
                <br><br>
                <label for="passwd">Password:</label>
                <input type="password" name="passwd" size="30" />
                <br>${message}
                <br><br>           
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>

