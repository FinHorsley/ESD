<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="java.sql.*"%>
<%@page import="DOA.DBConnection"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css">  
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
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
        <div class="topnav">
            <a class="title left">Nurse Control Panel</a>
            <div class="right">

                <a class ="title2"> Welcome ${user.uname}! (role: ${user.role})</a>
                <a href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                <a href = "http://localhost:8080/SmartCareWeb/create.invoice.jsp">Billing Centre</a>

            <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>

            </div>

        </div>

        <div style="text-align: center">
            <h1>Nurse Control Panel</h1>
            <h2>Please select your role below!</h2>
            <br><br>

            <table align="center" cellpadding="5" cellspacing="5" border="1">
                <tr>

                </tr>
                <tr>
                    <td><b>SID</b></td>
                    <td><b>EID</b></td>
                    <td><b>CID</b></td>
                    <td><b>SDATE</b></td>
                    <td><b>STIME</b></td>
                </tr>
                <%    try {
                        Connection con = null;
                        Statement statement = null;
                        ResultSet resultSet = null;
                        con = DBConnection.createConnection();

                        statement = con.createStatement();
                        String sql = "SELECT * FROM booking_slots";

                        resultSet = statement.executeQuery(sql);
                        while (resultSet.next()) {
                %>
                <tr>

                    <td><%=resultSet.getString("sid")%></td>
                    <td><%=resultSet.getString("eid")%></td>
                    <td><%=resultSet.getString("cid")%></td>
                    <td><%=resultSet.getString("sdate")%></td>
                    <td><%=resultSet.getString("stime")%></td>

                </tr>

                <%
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </table>








        </div>
    </body>
</html>
