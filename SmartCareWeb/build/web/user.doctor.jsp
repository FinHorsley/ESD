<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta charset="utf-8">
        <title>Doctor CPanel - SmartCare</title>
    </head>
    <body>
<%
                        
                        if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                        RequetsDispatcherObj.forward(request, response);
                        
                        }
                        else if (!UserBean.role.equals("doctor")){
                            
                            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                            RequetsDispatcherObj.forward(request, response);
                        
                        }
                    
                    %> 
        <div class="topnav">
            <a class="title left">Doctor Control Panel</a>
            <div class="right">
            <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Doctor Control Panel</h1>
            <h2>Please select your role below!</h2>
            <br><br>
        </div>
    </body>
</html>
