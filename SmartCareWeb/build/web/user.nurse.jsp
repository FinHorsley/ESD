<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="bean.UserBean"%>
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
                padding-top: 14px;
                padding-right: 16px;
            }

            .right {
                float: right;
                padding-top: 14px;
                padding-right: 16px;
            }
            .topnav a:hover {
                background-color: #D2D1C4;
                color: black;
            }
            .topnav buttons {
                background-color: #A99E9E;
                color: black;
            }

            .topnav a.title {
                background-color: #DFDED2;
                color: black;
                font-size: 20px;
            }
            .topnav a.title2 {
                background-color: #DFDED2;
                color: black;
                font-size: 12px;
            }
        </style>
        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title>
    </head>
    <body>
<%
                        
                        if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                        RequetsDispatcherObj.forward(request, response);
                        
                        }
                        else if (!UserBean.role.equals("nurse")){
                            
                            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                            RequetsDispatcherObj.forward(request, response);
                        
                        }
                    
                    %> 
        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class ="title2"> Welcome ${user.uname}! (role: ${user.role})</a>
                <a href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                <a href = "http://localhost:8080/SmartCareWeb/create.invoice.jsp">Billing Centre</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Website Nurse Panel</h1>
            <h2>Please select your role below!</h2>
            <br><br>
        </div>
    </body>
</html>
