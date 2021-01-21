<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>
<%-- Imports --%>  
<%@page import="beans.InvoiceBean"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DAO.DBConnection"%>
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
        <%--  menu tittle --%>
        <title>View Invoice CPanel - SmartCare</title>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }
            if ((!UserBean.role.equals("client")) && (!UserBean.role.equals("admin"))) {//checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }


        %> 

        <%-- navigation menu --%>
        <div class="topnav">
            <a class="title left">SmartCare Web Page</a> <%-- page title in navigation bar menu --%>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a> <%-- home button back to main menu --%>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a> <%-- logout button log out of system --%>
            </div>
        </div>

         <%-- Viewing of the invoices --%>   
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
                                con = DBConnection.createConnection();//connect to the database

                                selectInvoice = con.prepareStatement("SELECT * FROM invoice"); //get all values from the invoice table

                            } catch (SQLException e) {
                            }//SQLExeption catch
                        }

                        public ResultSet getInvoice() {
                            try {
                                resultSet = selectInvoice.executeQuery(); //exacute query
                            } catch (SQLException e) {
                            }//SQLExeption catch
                            return resultSet;
                        }
                    }
                %>
                <%                    
                    Invoice invoice = new Invoice(); //create a new invoice function
                    ResultSet Invoices = invoice.getInvoice();//assign the function of result set to varible to be used within html
                %>
            
            <%-- form for selecting the invoice to view based off of invoice id --%>  
            <form name="Clients" action="viewinvoice" method="POST">
                <table align="center" border="0">
                    <tbody>
                        <tr>
                            //SQLExeption catch
                            <td>Select Invoice ID: </td>
                            <%-- Select dropdown box --%>  
                            <td><select name="InvoiceChoice">
                                    <%while (Invoices.next()) {%>
                                    <option value="<%= Invoices.getString("iid")%>"><%= Invoices.getString("iid")%></option>
                                    <%}%>
                                </select></td>
                        </tr>
                    </tbody>
                </table>
                  <%-- Submit button --%>                
                <input type="submit" value="View Invoice" name="submit" />
            </form>
        </div>    
    </center>                
</body> 
</html>


