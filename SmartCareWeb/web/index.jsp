<%-- 
    Document   : index
    Created on : 08-Dec-2020, 16:17:22
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
<%
UserBean user = null;
user = new UserBean(); //setting the user to no user to apply filters
user.setRole("NoUser");
%>
        <div class="topnav">
            <a class="title left">SmartCare</a>
            <a class="right" href="login.jsp">Login</a>
            <a class="right" href="registration.jsp">Register</a>
            <a class="right" href="registration.employee.jsp">Register Employee</a> <%-- navigation menu --%>
        </div>
        <div style="padding-left:16px">
            <h2>Top Navigation Example</h2> <%-- display text --%>
            <p>Some content..</p>
        </div>
    </body>
</html>
