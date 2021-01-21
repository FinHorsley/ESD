<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="beans.InvoiceBean"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
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
            .middle {
                display: table-cell;
                vertical-align: middle;
            }
        </style>

        <meta charset="utf-8">
        <title>View Invoice CPanel - SmartCare</title>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }
            if ((!UserBean.role.equals("client")) && (!UserBean.role.equals("admin"))) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }


        %> 


        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Invoice Centre</h1>
            <h2>Please select which invoice you would like to view</h2>
            <br><br>
        </div>
    <center>
        <div style= "background-color:beige;width:500px;height:75px;border:25px solid #F5F5DC;"><u><b>Invoice Selection</b></u>
                <%!
                    public class Invoice {

                        Connection con = null;
                        PreparedStatement selectInvoice = null;
                        ResultSet resultSet = null;

                        public Invoice() {
                            try {
                                con = DBConnection.createConnection();

                                selectInvoice = con.prepareStatement("SELECT * FROM invoice");

                            } catch (SQLException e) {
                            }
                        }

                        public ResultSet getInvoice() {
                            try {
                                resultSet = selectInvoice.executeQuery();
                            } catch (SQLException e) {
                            }
                            return resultSet;
                        }
                    }
                %>
                <%                    
                    Invoice invoice = new Invoice();
                    ResultSet Invoices = invoice.getInvoice();

                    // if (request.getParameter("submit") != null) {
                    // }
                %>

            <form name="Clients" action="viewinvoice" method="POST">
                <table align="center" border="0">
                    <tbody>
                        <tr>
                            <td>Select Invoice ID: </td>

                            <td><select name="InvoiceChoice">
                                    <%while (Invoices.next()) {%>
                                    <option value="<%= Invoices.getString("iid")%>"><%= Invoices.getString("iid")%></option>
                                    <%}%>
                                </select></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="View Invoice" name="submit" />
            </form>
        </div>    
    </center>                
</body> 
</html>


