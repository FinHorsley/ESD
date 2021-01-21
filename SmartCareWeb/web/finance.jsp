<%-- 
    Document   : finance
    Created on : 21-Jan-2021, 05:42:04
    Author     : kamil
--%>

<%@page import="beans.PrescriptionBean"%>
<%@page import="beans.SlotBean"%>
<%@page import="beans.ClientBean"%>
<%@page import="beans.InvoiceBean"%>
<%@page import="beans.EmployeeBean"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%> <%-- importing needed packages  --%>
<%@page import="DOA.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style> <%-- creating a style sheet for the web page in css --%>
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
            .middle {
                display: table-cell;
                vertical-align: middle;
            }
            background{
                background-image: url('Medical-Invoice-Template.jpg');
            }

            h3{

                font-size: 30px;
                text-align: left;
            }
            h4{
                font-family: ariel;
                text-align: left;
            }

            h5{
                font-size: 20px;
                font-family: ariel;
                text-align: right;
                padding-right: 170px;
            }

            h6{
                display: inline-block;
                margin-left: 100px;
                text-align: right;
                padding-top: -100px
            }

            table {
                font-family: arial;
                border-collapse: collapse;
                width: 100%;
            }

            tr, th {
                border: 1px solid #000000;
                text-align: center;
                padding: 8px;
            }

            input{
                border: #F5F5DC;
            }



        </style>


        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title> <%-- displaying title in the top left  --%>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            } else if (!UserBean.role.equals("admin")) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

            EmployeeBean ERBean = new EmployeeBean();
            InvoiceBean IRBean = new InvoiceBean();
            ClientBean CRBean = new ClientBean(); // creating new bean instances to be accessable 
            SlotBean SRBean = new SlotBean();
            PrescriptionBean PRBean = new PrescriptionBean();
        %> 


        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a> <%-- creating button in the topm navigation menu --%>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Invoice Centre</h1> <%-- displaying text --%>
            <h2>Below you will find your generated invoice</h2>
            <br><br>
        </div>
    <center>
        <div style= "background-color:beige;width:1000px;height:350px;border:25px solid #F5F5DC;"> <%-- creating a style for this perticulat set of code --%>
            <h3>Finances</h3> <%-- displaying text --%>
            <br>
            <table style="width:100%"> <%-- creating a table to display information --%>
                <tr>
                    <th>Monthly Income</th> <%-- creating collumns in table --%>
                    <th>Monthly Outcome</th>
                    <th>Monthly Total</th>
                </tr>
            </table>
            <br>
            <table style="width:100%"> <%-- creating another table to hold different values --%>
                <tr>
                    <th>Yearly Income</th> 
                    <th>Yearly Outcome</th>
                    <th>Yearly Total</th>
                </tr>
            </table>
        </div>    
    </center>                
</body> 
</html>



