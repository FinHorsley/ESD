<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>
<%-- Imports --%>  
<%@page import="java.sql.*"%>
<%@page import="DAO.DBConnection"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css">  
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <%--  menu tittle --%>
        <title>Nurse CPanel - SmartCare</title>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            } else if (!UserBean.role.equals("nurse")) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

        %> 
        <%-- navigation menu --%>
        <div class="topnav">
            <a class="title left">Nurse Control Panel</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a><%-- home button back to main menu --%>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a><%-- logout button log out of system --%>
            </div>

        </div>

        <%-- Viewing of the Appointments in a table --%>  
        <div style="text-align: center">
            <h1>Nurse Control Panel</h1>
            <h2>View Appointment Details</h2>
            <br><br>

            <table align="center" cellpadding="5" cellspacing="5" border="1">
                <tr>

                </tr>
                <%-- Creating table heads --%>  
                <tr>
                    <td><b>Appointment ID</b></td>
                    <td><b>EID</b></td>
                    <td><b>CID</b></td>
                    <td><b>SDATE</b></td>
                    <td><b>STIME</b></td>
                    <td><b>Appointment Reason</b></td>
                </tr>

                <%                    try {
                        Connection con = null;
                        Statement statement = null;
                        ResultSet resultSet = null;
                        con = DBConnection.createConnection();//conecting to the database

                        statement = con.createStatement(); //creating a statement based of the database
                        String sql = "SELECT * FROM booking_slots";//select statement

                        resultSet = statement.executeQuery(sql);//exacuting the select statement

                        while (resultSet.next()) {
                %>
                <tr>
                    <%-- Creating body of the table from the data collected from the database--%>  
                    <td><%=resultSet.getString("sid")%></td>
                    <td><%=resultSet.getString("eid")%></td>
                    <td><%=resultSet.getString("cid")%></td>
                    <td><%=resultSet.getString("sdate")%></td>
                    <td><%=resultSet.getString("stime")%></td>
                    <td><%=resultSet.getString("sreason")%></td>

                </tr>

                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace(); //SQLExeption catch
                    }
                %>
            </table>
            <div id="contentBox" style="margin:0px auto; width:100%">
                <!-- columns divs, float left, no margin so there is no space between column, width=1/2 -->
                <div id="column1" style="float:left; margin:0; width:50%;">
                    <h2>Create Prescription:</h2>            


                    <%!
                        public class Invoice {

                            Connection con = null;
                            PreparedStatement selectInvoice = null;
                            ResultSet resultSet = null;

                            public Invoice() {
                                try {
                                    con = DBConnection.createConnection();//connect to the database

                                    selectInvoice = con.prepareStatement("SELECT * FROM booking_slots WHERE sreason = 'Prescription'");//get all values from the invoice table

                                } catch (SQLException e) {
                                }//SQLExeption catch
                            }

                            public ResultSet getInvoice() {
                                try {
                                    resultSet = selectInvoice.executeQuery();//exacute query
                                } catch (SQLException e) {
                                }//SQLExeption catch
                                return resultSet;
                            }
                        }
                    %>
                    <%
                        Invoice invoice = new Invoice();//create a new invoice function
                        ResultSet Invoices = invoice.getInvoice();//assign the function of result set to varible to be used within html

                    %>

                    <%-- Selecting appointment to create an invoice --%>  
                    <form name="Clients" action="createp" method="POST">
                        <table align="center" border="0">
                            <tbody>
                                <tr>
                                    <td>Select Appointment ID: </td>

                                    <td><select name="PChoice">
                                            <%while (Invoices.next()) {%>
                                            <option value="<%= Invoices.getString("sid")%>"><%= Invoices.getString("sid")%></option>
                                            <%}%>
                                        </select></td>
                                </tr>
                            </tbody>
                        </table>
                        <%-- Submit button --%>                  
                        <input type="submit" value="Create Prescription" name="submit" />
                    </form>
                </div>


                <div id="column1" style="float:left; margin:0; width:50%;">
                    <h2>Complete/Cancel Appointment</h2>


                    <%!
                        public class Appointment {

                            Connection con = null;
                            PreparedStatement selectAppointment = null;
                            ResultSet resultSet = null;

                            public Appointment() {
                                try {
                                    con = DBConnection.createConnection();

                                    selectAppointment = con.prepareStatement("SELECT * FROM booking_Slots");

                                } catch (SQLException e) {
                                }
                            }

                            public ResultSet getAppointment() {
                                try {
                                    resultSet = selectAppointment.executeQuery();
                                } catch (SQLException e) {
                                }
                                return resultSet;
                            }
                        }
                    %>

                    <%
                        Appointment appointment = new Appointment();
                        ResultSet Appointments = appointment.getAppointment();
                        Connection con1 = null;
                        Statement stmt = null;
                        if (request.getParameter("submit") != null) {

                            String choice = request.getParameter("ApointmentChoice");
                            con1 = DBConnection.createConnection();

                            try {
                                stmt = con1.createStatement();
                                String t = "DELETE FROM booking_slots WHERE sid = " + choice + "";
                                stmt.executeUpdate(t);
                                stmt.close();
                                con1.commit();
                                con1.close();

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    %>
                    <%-- Selecting an apointment to create invoice --%>
                    <form name="Appointments" action="user.nurse.jsp" method="POST">
                        <table align="center" border="0">
                            <tbody>
                                <tr>
                                    <td>Appointment ID: </td>

                                    <td><select name="ApointmentChoice">
                                            <%while (Appointments.next()) {%>
                                            <option value="<%= Appointments.getString("sid")%>"><%= Appointments.getString("sid")%></option>
                                            <%}%>
                                        </select></td>
                                </tr>
                            </tbody>
                        </table>
                          <%-- Submit button --%>                   
                        <input type="submit" value="Complete/Cancel" name="submit" />
                    </form>
                </div>
            </div>
            <div id="contentBox" style="margin:0px auto; width:100%">
                <div id="column1" style="float:left; margin:0; width:100%;">
                    <h2>Recurring Prescriptions</h2>
                    <br><br>

                    <table align="center" cellpadding="5" cellspacing="5" border="1">
                        <tr>

                        </tr>
                        <tr>
                            <%-- Creating head of the table --%> 
                            <td><b>Prescription ID</b></td>
                            <td><b>Client ID</b></td>
                            <td><b>Booking Slot ID</b></td>
                            <td><b>Medicine Name</b></td>
                            <td><b>Quantity</b></td>
                            <td><b>Issue Date</b></td>
                            <td><b>End Date</b></td>
                        </tr>

                        <%                    try {
                                Connection con3 = null;
                                Statement statement3 = null;
                                ResultSet resultSet3 = null;

                                con3 = DBConnection.createConnection();//conecting to databse
                                statement3 = con3.createStatement(); //creating a statement
                                String sql3 = "SELECT * FROM prescription WHERE repeating = 'yes'"; //declaring the select statement

                                resultSet3 = statement3.executeQuery(sql3); // exacuting the statement

                                while (resultSet3.next()) {
                        %>
                        <tr>
                            <%-- Creating body of the table --%> 
                            <td><%=resultSet3.getString("pid")%></td>
                            <td><%=resultSet3.getString("cid")%></td>
                            <td><%=resultSet3.getString("sid")%></td>
                            <td><%=resultSet3.getString("medicine")%></td>
                            <td><%=resultSet3.getString("quantity")%></td>
                            <td><%=resultSet3.getString("issuedate")%></td>
                            <td><%=resultSet3.getString("enddate")%></td>

                        </tr>

                        <%
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        %>
                    </table>
                </div>
            </div>
    </body>
</html>
