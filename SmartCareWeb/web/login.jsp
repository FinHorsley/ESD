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
        <title>SmartCare Website</title> <%-- display title --%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="topnav">
            <a class="title left">Login</a>
            <a class="right" href="index.jsp">Home</a> <%-- navigation menu --%>
        </div>

        <div style="text-align: center">
            <h1>Login</h1> <%-- display login label --%>

            <form action="login" method="post">
                <table align="center">
                    <tr>
                        <td>Username:</td> <%-- creating the username box --%>
                        <td><input type="text" name="uname" size="30" placeholder="Enter UserName" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td> <%-- creating the password box --%>
                        <td><input type="password" name="passwd" size="30" placeholder="Enter Password" /></td>
                    </tr>
                </table>
                ${message}
                <br><br>           
                <button type="submit">Login</button> <%-- submit button to log in --%>
                <br>
            </form>
        </div>
    </body>
</html>
