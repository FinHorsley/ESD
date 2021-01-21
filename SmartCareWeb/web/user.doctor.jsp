<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>
<%-- Imports --%>  
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DAO.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta charset="utf-8">
        <%--  menu tittle --%>
        <title>Doctor CPanel - SmartCare</title>
    </head>
    <body>
        <%

            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            } else if (!UserBean.role.equals("doctor")) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

        %> 
        <%-- navigation menu --%>
        <div class="topnav">
            <a class="title left">Doctor Control Panel</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
            </div>

        </div>
        <%-- Viewing of the Operations in a table --%>
        <div style="text-align: center">
            <h1>Doctor Control Panel</h1>
            <h2>Operations</h2>
            <br><br>

            <table align="center" cellpadding="5" cellspacing="5" border="1">
                <tr>

                </tr>
                <tr>
                    <%-- Creating table heads --%>
                    <td><b>Operation ID</b></td>
                    <td><b>Employee ID</b></td>
                    <td><b>Client ID</b></td>
                    <td><b>Operation DATE</b></td>
                    <td><b>NSlot</b></td>
                    <td><b>Charge</b></td>
                </tr>

                <%                    try {
                        Connection con = null;
                        Statement statement = null;
                        ResultSet resultSet = null;
                        con = DBConnection.createConnection();//conecting to the database

                        statement = con.createStatement();//creating a statement based of the database
                        String sql = "SELECT * FROM operations";//select statement

                        resultSet = statement.executeQuery(sql);

                        while (resultSet.next()) {
                %>
                <tr>
                    <%-- Creating body of the table from the data collected from the database--%>
                    <td><%=resultSet.getString("oid")%></td>
                    <td><%=resultSet.getString("eid")%></td>
                    <td><%=resultSet.getString("cid")%></td>
                    <td><%=resultSet.getString("odate")%></td>
                    <td><%=resultSet.getString("nslot")%></td>
                    <td><%=resultSet.getString("charge")%></td>

                </tr>

                <%
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }//SQLExeption catch
                %>
            </table>


            <div id="contentBox" style="margin:0px auto; width:100%">


                <!-- columns divs, float left, no margin so there is no space between column, width=1/3 -->
                <div id="column1" style="float:left; margin:0; width:50%;">
                    <h2>Create Prescription:</h2>            
                    <form action="http://localhost:8080/SmartCareWeb/Operation.register.jsp">
                        <button type="submit">Create Operation</button>
                    </form>
                </div>


                <div id="column2" style="float:left; margin:0; width:50%;">
                    <h2>Complete/Cancel Operation</h2>


                    <%!
                        public class Operation {

                            Connection con = null;
                            PreparedStatement selectOperation = null;
                            ResultSet resultSet = null;

                            public Operation() {
                                try {
                                    con = DBConnection.createConnection();//connect to the database

                                    selectOperation = con.prepareStatement("SELECT * FROM operations");//get all values from the invoice table

                                } catch (SQLException e) {
                                }//SQLExeption catch
                            }

                            public ResultSet getOperation() {
                                try {
                                    resultSet = selectOperation.executeQuery();//exacute query
                                } catch (SQLException e) {
                                }//SQLExeption catch
                                return resultSet;
                            }
                        }
                    %>

                    <%
                        Operation operation = new Operation();//create a new invoice function
                        ResultSet Operations = operation.getOperation();//assign the function of result set to varible to be used within html
                        Connection con1 = null;
                        Statement stmt = null;
                        if (request.getParameter("submit") != null) {

                            String choice = request.getParameter("OperationsChoice");
                            con1 = DBConnection.createConnection();//connecting to the database

                            try {
                                stmt = con1.createStatement();//creating a statment from the database
                                String t = "DELETE FROM operations WHERE oid = " + choice + ""; //deleting the entries of selected operations
                                stmt.executeUpdate(t);//exacuting the statement
                                stmt.close();//closing the statement
                                con1.commit();//commiting the connection
                                con1.close();//closing the connection

                            } catch (SQLException e) {
                                e.printStackTrace();//SQLExeption catch
                            }

                        }
                    %>

                    <form name="Appointments" action="user.doctor.jsp" method="POST">
                        <table align="center" border="0">
                            <tbody>
                                <tr>
                                    <%-- Selecting Operation to create delete --%>  
                                    <td>Operation ID: </td>

                                    <td><select name="OperationsChoice">
                                            <%while (Operations.next()) {%>
                                            <option value="<%= Operations.getString("oid")%>"><%= Operations.getString("oid")%></option>
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
                    <%-- Displaying table of reocurring prescriptions --%>
                    <h2>Recurring Prescriptions</h2>
                    <br><br>

                    <table align="center" cellpadding="5" cellspacing="5" border="1">
                        <tr>

                        </tr>
                        <tr>
                             <%-- Creating table heads --%>  
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

                                con3 = DBConnection.createConnection();//conecting to the database
                                statement3 = con3.createStatement();//creating a statement based of the database
                                String sql3 = "SELECT * FROM prescription WHERE repeating = 'yes'";//select statement

                                resultSet3 = statement3.executeQuery(sql3);//exacuting the select statement

                                while (resultSet3.next()) {
                        %>
                        <tr>
                             <%-- Creating body of the table from the data collected from the database--%>  
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
                            }//SQLExeption catch
                        %>
                    </table>
                </div>
            </div> 

    </body>
</html>
