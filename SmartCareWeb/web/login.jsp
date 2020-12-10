<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Login</h1>
            <form action="login" method="post">
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
