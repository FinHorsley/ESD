<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
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
        <style> <%-- creating a style sheet --%>
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
        <title>Admin CPanel - SmartCare</title> <%-- displaying title --%>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            } else if ((!UserBean.role.equals("client")) && (!UserBean.role.equals("admin"))) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

            EmployeeBean ERBean = new EmployeeBean();
            InvoiceBean IRBean = new InvoiceBean();
            ClientBean CRBean = new ClientBean(); // creating bean object to be accessed and retrive the data
            SlotBean SRBean = new SlotBean();
            PrescriptionBean PRBean = new PrescriptionBean();
        %> 


        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a> <%-- navigation menu --%>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Invoice Centre</h1> <%-- displaying text for user --%>
            <h2>Below you will find your generated invoice</h2>
            <br><br>
        </div>
    <center>
        <div style= "background-color:beige;width:1000px;height:400px;border:25px solid #F5F5DC;"> <%-- making a rectangle where all other element are stationed --%>
            <h3>Smart Care Invoice</h3> 
            <h4>Invoice Number:  <%=IRBean.getIID()%></h4>        <%-- outputting the data corresponding to the name of the collumn in the table --%>
            <h4>Patient Name:    <%=CRBean.getCname()%></h4>     
            <h4>Patient Address: <%=CRBean.getCaddress()%></h4> 
            <h4>Physician:       <%=ERBean.getEname()%></h4>     
            <br>
            <table style="width:100%">
                <tr>
                    <th>Date</th> 
                    <th>Services Performed</th>
                    <th>Medication Prescribed</th> <%-- outputting the data corresponding to the name of the collumn in the table --%>
                    <th>Amount Due</th>
                </tr>
                <tr>
                    <th><a style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /><%=SRBean.getSdate()%></a></th> 
                    <th><a style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /><%=SRBean.getSreason()%></a></th> <%-- outputting the data corresponding to the name of the collumn in the table --%>
                    <th><a style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /><%=PRBean.getMedicine()%></a></th> 
                    <th><a style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" />Not added yet</a></th> 

                </tr>
            </table>
            <h5> Total: <input style =" border: #F5F5DC; margin-right: -87px; width: 75px;" type="number" id="total" name="total" /> </h5> <%-- total amout to be payed --%>

        </div>    
    </center>                
</body> 
</html>


