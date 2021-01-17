<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta charset="utf-8">
        <title>SmartCare Website</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <a class="right" href="index.jsp">Home</a>
        </div>

        <div style="text-align: center">
            <h1>Login</h1>

            <form action="login" method="post">
                <table align="center">
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="uname" size="30" placeholder="Enter UserName" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="passwd" size="30" placeholder="Enter Password" /></td>
                    </tr>
                </table>
                ${message}
                <br><br>           
                <button type="submit">Login</button>
                <br>
            </form>
        </div>
    </body>
</html>
