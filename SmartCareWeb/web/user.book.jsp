<%-- 
    Document   : user.book
    Created on : 15-Dec-2020, 17:17:19
    Author     : kamil
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title>
        <link rel = "stylesheet" type = "text/css" href ="C:\Users\kamil\Documents\jquery-ui.min.css">
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
            }

            .right {
                float: right;
            }
            .topnav a:hover {
                background-color: #D2D1C4;
                color: black;
            }

            .topnav a.title {
                background-color: #DFDED2;
                color: black;
                font-size: 20px;
            }
            label{
                width:140px;
                display: inline-block;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <center>
        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
        </div>
        </center>
        
        <div>
            <center>
            <h1>Book Consultation</h1>
            </center>
            <center>
            <form action="Book Consultation" method="post">
                <label for="ClentID">Client ID:</label>
                <select name ="ClientID ID" id ="clientID" >
                    <option>Client ID</option>
                    <%
                        try{
                            String Query = "select * from CLIENTS";
                            Class.forName("com.mysql.jdbc.Driver");
                            String jdbcURL = "jdbc:derby://localhost:1527/SmartCare";
                            String dbUser = "Harry";
                            String dbPassword = "123";
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                            Statement stm=connection.createStatement();
                            ResultSet rs=stm.executeQuery(Query);
                            while(rs.next())
                            {
                                %>
                                <option value ="<%=rs.getInt("CID")%>"><%=rs.getInt("CID")%></option>
                                <%
                        
                            }
                            
                            
                        
                        }catch(Exception e){
                            e.printStackTrace();
                            out.println("Error "+e.getMessage());
                        }
                        
                        
                    %>
                </select>
                <br><br>
               
                <label for="ID">Professional ID:</label>
                <select name ="Professional ID" id ="employeeID" >
                    <option>Professional ID</option>
                    <%
                        try{
                            String Query = "select * from EMPLOYEE";
                            Class.forName("com.mysql.jdbc.Driver");
                            String jdbcURL = "jdbc:derby://localhost:1527/SmartCare";
                            String dbUser = "Harry";
                            String dbPassword = "123";
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                            Statement stm=connection.createStatement();
                            ResultSet rs=stm.executeQuery(Query);
                            while(rs.next())
                            {
                                %>
                                <option value ="<%=rs.getInt("EID")%>"><%=rs.getInt("EID")%></option>
                                <%
                        
                            }
                            
                            
                        
                        }catch(Exception e){
                            e.printStackTrace();
                            out.println("Error "+e.getMessage());
                        }
                        
                        
                    %>
                </select>
                <br><br>
                <label for="text">Professional Name:</label>
                <select name ="Professional ID" id ="employeeName" >
                    <option>Professional Name</option>
                    <%
                        try{
                            String Query = "select * from EMPLOYEE";
                            Class.forName("com.mysql.jdbc.Driver");
                            String jdbcURL = "jdbc:derby://localhost:1527/SmartCare";
                            String dbUser = "Harry";
                            String dbPassword = "123";
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                            Statement stm=connection.createStatement();
                            ResultSet rs=stm.executeQuery(Query);
                            while(rs.next())
                            {
                                %>
                                <option value ="<%=rs.getInt("EID")%>"><%=rs.getString("ENAME")%></option>
                                <%
                        
                            }
                            
                            
                        
                        }catch(Exception e){
                            e.printStackTrace();
                            out.println("Error "+e.getMessage());
                        }
                        
                        
                    %>
                </select>
                <br><br>
                <label for="Date">Slot Date:</label>
                <input type = "text" size ="20" id ="slotDate" />
                <br><br>
                <label for="Time">Slot Time:</label> 
                <input type="Time" id="slotTime">
                <br>${message}
                <br><br>
                <button type="submit">Book Now</button>
                <%
                    String jdbcURL = "jdbc:derby://localhost:1527/SmartCare";
                    String dbUser = "Harry";
                    String dbPassword = "123";
                    
                    String employeeID = request.getParameter("employeeID");
                    String clientID = request.getParameter("clientID");
                    String slotDate = request.getParameter("slotDate");
                    String slotTime = request.getParameter("slotTime");
                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                    Statement stm = connection.createStatement();
                    stm.executeUpdate("insert into BOOKING_SLOTS(EID,CID,SDATE,STIME)values('"+employeeID+"','"+clientID+"','"+slotDate+"','"+slotTime+"')");
                    out.println("Your consultation has been booked");
                    }catch(Exception e){
                        e.printStackTrace();
                        out.println("Error "+e.getMessage());
                    }
                
                %>
            </form>
            </center>
        </div>
        
    </body>
</html>