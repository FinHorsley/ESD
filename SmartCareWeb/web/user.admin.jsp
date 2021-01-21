<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DAO.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.UserBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css">  
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title> <%-- display title --%>
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

        %>  
        <div class="topnav">
            <a class="title left">Admin Control Panel</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/create.invoice.jsp">Billing Centre</a>
                        <a class="right" href = "http://localhost:8080/SmartCareWeb/view.invoice.jsp">View Invoices</a>

        </div>

        <div style="text-align: center">
            <h1>Admin Control Panel</h1>

            <br><br> <%-- display text --%>


            <div id="contentBox" style="margin:0px auto; width:100%">

                <!-- columns divs, float left, no margin so there is no space between column, width=1/3 -->
                <div id="column1" style="float:left; margin:0; width:50%;">
                    <h2>List of NHS Members:</h2>
                    <table align="center" cellpadding="5" cellspacing="5" border="1">
                        <tr>
                        </tr>
                        <tr>
                            <td><b>Clients Name</b></td>
                            <td><b>Clients UserName</b></td>
                            <td><b>Clients ID</b></td> <%-- displaying client information --%>
                            <td><b>Clients Address</b></td>
                            <td><b>Clients Type</b></td>
                        </tr>
                        <%    try {
                                Connection con = null;
                                Statement statement = null;//creating a connection to the database
                                ResultSet resultSet = null;
                                con = DBConnection.createConnection();

                                statement = con.createStatement();
                                String sql = "SELECT * FROM clients WHERE ctype = 'NHS'"; //selecting everything from client that is NHS

                                resultSet = statement.executeQuery(sql); //executing query
                                while (resultSet.next()) {
                        %>
                        <tr>
                            <td><%=resultSet.getString("cname")%></td>
                            <td><%=resultSet.getString("uname")%></td>
                            <td><%=resultSet.getString("cid")%></td> <%-- outputting the query results --%>
                            <td><%=resultSet.getString("caddress")%></td>
                            <td><%=resultSet.getString("ctype")%></td>
                        </tr>
                        <%
                                }

                            } catch (Exception e) {
                                e.printStackTrace(); //printing the sql error messages
                            }
                        %>
                    </table>
                </div>
                <div id="column2" style="float:left; margin:0; width:50%;">
                    <h2>List of Private Members:</h2> <%-- displaying text --%>

                    <table align="center" cellpadding="5" cellspacing="5" border="1">
                        <tr>

                        </tr>
                        <tr>
                            <td><b>Clients Name</b></td>
                            <td><b>Clients UserName</b></td>
                            <td><b>Clients ID</b></td> <%--  displaying text --%>
                            <td><b>Clients Address</b></td>
                            <td><b>Clients Type</b></td>
                        </tr>
                        <%    try {
                                Connection con = null;
                                Statement statement = null; //creatig connection to database
                                ResultSet resultSet = null;
                                con = DBConnection.createConnection();

                                statement = con.createStatement();
                                String sql = "SELECT * FROM clients WHERE ctype = 'private'";//selecting everything from database that is private

                                resultSet = statement.executeQuery(sql); //execure query
                                while (resultSet.next()) {
                        %>
                        <tr>
                            <td><%=resultSet.getString("cname")%></td>
                            <td><%=resultSet.getString("uname")%></td>
                            <td><%=resultSet.getString("cid")%></td> <%-- output the data from database --%>
                            <td><%=resultSet.getString("caddress")%></td>
                            <td><%=resultSet.getString("ctype")%></td>
                        </tr>
                        <%
                                }

                            } catch (Exception e) {
                                e.printStackTrace(); //pring sql error messages
                            }
                        %>
                    </table>
                </div>
            </div>
            <div id="contentBox" style="margin:0px auto; width:100%">
                <div id="column1" style="float:left; margin:0; width:100%;">
                    <h2>Modifiy User Infomation</h2> <%-- displaying text --%>
                    <br><br>
                </div>
            </div>
            <div id="contentBox" style="margin:0px auto; width:100%">

                <!-- columns divs, float left, no margin so there is no space between column, width=1/3 -->
                <div id="column1" style="float:left; margin:0; width:50%;">
                    <h3>non-approved Staff accounts</h3> <%-- displaying text --%>
                    <%!
                        public class Employee {

                            Connection con5 = null;
                            PreparedStatement selectEmployee = null;
                            PreparedStatement deleteEmployee = null; //creating a connection to the database
                            ResultSet resultSet1 = null;

                            public Employee() {
                                try {
                                    con5 = DBConnection.createConnection();
                                                                                //selecting the data to be outputted
                                    selectEmployee = con5.prepareStatement("SELECT uname, passwd, role FROM users WHERE role ='Not Approved: doctor' or role ='Not Approved: nurse' ");
                                    

                                } catch (SQLException e) {
                                }
                            }

                            public ResultSet getEmployee() {
                                try {
                                    resultSet1 = selectEmployee.executeQuery(); //execute query
                                } catch (SQLException e) {
                                }
                                return resultSet1;
                            }
                        }
                    %>
                    <%
                        Employee employee = new Employee();
                        ResultSet Employee = employee.getEmployee();
                        Connection con4 = null;
                        Statement stmt4 = null; //making new instances of objects 
                        Connection con5 = null;
                        Statement stmt5 = null;
                        if (request.getParameter("submit1") != null) {

                            con4 = DBConnection.createConnection(); //connecting to database
                            con5 = DBConnection.createConnection();

                            try {
                                stmt4 = con4.createStatement();
                                String b = "UPDATE users SET role = 'doctor' WHERE role = 'Not Approved: doctor'"; //selecting data from database
                                stmt4.executeUpdate(b);
                                stmt4.close();
                                con4.commit();
                                con4.close();

                                stmt5 = con5.createStatement();
                                String k = "UPDATE users SET role = 'nurse' WHERE role = 'Not Approved: nurse'"; //selecting data from databse
                                stmt5.executeUpdate(k);
                                stmt5.close();
                                con5.commit();
                                con5.close();

                            } catch (SQLException ex) {

                            }

                        }
                    %>

                    <form name="Clients" action="user.admin.jsp" method="POST">
                        <table align="center" border="0">
                            <tbody>
                                <tr>
                                    <td>Clients Username: </td> <%-- display text --%>

                                    <td><select name="EmployeeChoice">
                                            <%while (Employee.next()) {%> <%-- display the correct data from the databse --%>
                                            <option value="<%= Employee.getString("role")%>"><%= Employee.getString("uname")%>: (<%= Employee.getString("role")%>)</option>
                                            <%}%>
                                        </select></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="submit" value="Approve User" name="submit1" /> <%-- creating the submit and reset buttons --%>
                    </form>
                </div>
                <div id="column2" style="float:left; margin:0; width:50%;">
                    <h3>Remove User Account:</h3> <%-- display text --%>
                    <%!
                        public class Client {

                            Connection con = null;
                            PreparedStatement selectClient = null;
                            PreparedStatement deleteClient = null; //creating a connection to the database
                            ResultSet resultSet = null;

                            public Client() {
                                try {
                                    con = DBConnection.createConnection();

                                    selectClient = con.prepareStatement("SELECT uname, passwd, role FROM users");
                                    deleteClient = con.prepareStatement("DELETE FROM users WHERE uname =?"); //selecting elements from database

                                } catch (SQLException e) {
                                }
                            }

                            public ResultSet getClient() {
                                try {
                                    resultSet = selectClient.executeQuery();
                                } catch (SQLException e) {
                                }
                                return resultSet;
                            }
                        }
                    %>
                    <%                    Client client = new Client();
                        ResultSet Clients = client.getClient();
                        Connection con1 = null;
                        Statement stmt = null;
                        Connection con2 = null; // creating new object elements 
                        Statement stmt1 = null;
                        Connection con3 = null;
                        Statement stmt2 = null;
                        if (request.getParameter("submit") != null) {

                            String choice = request.getParameter("clientChoice");
                            con1 = DBConnection.createConnection();
                            con2 = DBConnection.createConnection(); //setting up the connection to the database
                            con3 = DBConnection.createConnection();

                            try {
                                stmt = con1.createStatement();
                                String t = "DELETE FROM users WHERE uname = '" + choice + "'"; //selecting elements from database
                                stmt.executeUpdate(t);
                                stmt.close();
                                con1.commit();
                                con1.close();

                                stmt1 = con2.createStatement();
                                String h = "DELETE FROM clients WHERE uname = '" + choice + "'";//selecting elements from database
                                stmt1.executeUpdate(h);
                                stmt1.close();
                                con2.commit();
                                con2.close();

                                stmt2 = con3.createStatement();
                                String i = "DELETE FROM employee WHERE uname = '" + choice + "'";//selecting elements from database
                                stmt2.executeUpdate(i);
                                stmt2.close();
                                con3.commit();
                                con3.close();

                            } catch (SQLException ex) {

                            }

                        }
                    %>
                    <form name="Clients" action="user.admin.jsp" method="POST">
                        <table align="center" border="0">
                            <tbody>
                                <tr>
                                    <td>Clients Username: </td> <%-- display text --%>

                                    <td><select name="clientChoice"> <%-- display corresponding data from database --%>
                                            <%while (Clients.next()) {%>
                                            <option value="<%= Clients.getString("uname")%>"><%= Clients.getString("uname")%>: (<%= Clients.getString("role")%>)</option>
                                            <%}%>
                                        </select></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="submit" value="Delete User" name="submit" /> <%-- creating a submit and reset buttons --%>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
