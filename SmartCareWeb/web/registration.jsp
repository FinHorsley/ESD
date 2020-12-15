<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
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
        <script>
            function validate()
            {
                var email = document.form.email.value;
                var username = document.form.uname.value;
                var passwd = document.form.passwd.value;
                var conpasswd = document.form.conpasswd.value;


                if (email === null || email === "")
                {
                    alert("Email can't be blank");
                    return false;
                } else if (uname === null || username === "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (passwd.length < 6)
                {
                    alert("Password must be at least 6 characters long.");
                    return false;
                } else if (passwd != conpasswd)
                {
                    alert("Confirm Password should match with the Password");
                    return false;
                }
            }
        </script> 
    </head>
    <body>
        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <a class="right" href="index.jsp">Home</a>
        </div>
    <center><h2>Registration </h2></center>
    <form name="form" action="Register" method="post" onsubmit="return validate()">
        <table align="center">
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="uname" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="passwd" /></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" name="conpasswd" /></td>
            </tr>
            <tr>
                    <td><%=(request.getAttribute("errMessage") == null) ? ""
                            : request.getAttribute("errMessage")%></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register"></input><input
                        type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</body>
</html>