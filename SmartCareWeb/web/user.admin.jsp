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
<%@page import="DOA.DBConnection"%>
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
            table, th, td {
                border: 1px solid black;

            </style>
            <meta charset="utf-8">
            <title>Admin CPanel - SmartCare</title>
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
                <a class="title left">SmartCare Web Page</a>
                <div class="right">
                    <a class ="title2"> Welcome ${user.uname}! (role: ${user.role})</a>
                    <a href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                    <a href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                </div>

            </div>

            <div style="text-align: center">
                    <h1>Welcome to SmartCare Website Admin Panel</h1>
                    <h2>Please select your role below!</h2>
                    <br><br>
                </div>


                <div>   

                </div>

                <div id="contentBox" style="margin:0px auto; width:70%">

                    <!-- columns divs, float left, no margin so there is no space between column, width=1/3 -->
                    <div id="column1" style="float:left; margin:0; width:33%;">
                    <h2>non-approved Staff accounts:</h2>
                </div>

                <div id="column2" style="float:left; margin:0;width:33%;">
                    <h2>non-approved Staff accounts:</h2>
                </div>

                <div id="column3" style="float:left; margin:0;width:33%">
                        <h2>Remove Client Account:</h2>
                        <%!
                            public class Client {

                                Connection con = null;
                                PreparedStatement selectClient = null;
                                PreparedStatement deleteClient = null;
                                ResultSet resultSet = null;

                                public Client() {
                                    try {
                                        con = DBConnection.createConnection();

                                        selectClient = con.prepareStatement("SELECT uname, passwd, role FROM users");
                                        selectClient = con.prepareStatement("DELETE FROM users WHERE uname =?");

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

                                public int deleteClient(Integer id) {
                                    int result = 0;

                                    try {
                                        deleteClient.setInt(1, id);
                                        result = deleteClient.executeUpdate();
                                    } catch (SQLException e) {
                                    }
                                    return result;
                                }
                            }
                        %>
                        <%
                            int result = 0;
                            Client client = new Client();
                            ResultSet clients = client.getClient();

                            Integer clientId = new Integer(0);

                            if (request.getParameter("submit") != null) {
                                clientId = Integer.parseInt(request.getParameter("client"));
                                result = client.deleteClient(clientId);
                            }
                        %>

                        <form name="Clients" action="user.admin.jsp" method="POST">
                            <table border="0">
                                <tbody>
                                    <tr>
                                        <td>Clients Username: </td>
                                        <%while (clients.next()) {%>
                                        <td><select name="client">
                                                <option value="<%= clients.getInt("client_id")%>"><%= clients.getString("uname")%></option>
                                                <%}%>
                                            </select></td>
                                    </tr>
                                </tbody>
                            </table>

                        </form>








                    </div>
                </div>
            </body>
        </html>
