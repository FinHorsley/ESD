<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="DAO.DBConnection"%>
<%@page import="java.sql.*"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </style>
    <meta charset="utf-8">
    <title>Client CPanel - SmartCare</title>
</head>
<body>
    <%

        if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);

        } else if (!UserBean.role.equals("client")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);

        }

    %> 
    <div class="topnav">
        <a class="title left">Client Control Panel</a>
        <div class="right">

            <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
            <a class="right" href = "http://localhost:8080/SmartCareWeb/view.invoice.jsp">View Invoices</a>


        </div>
</body>

</div>

<div style="text-align: center">
    <h1>Client Control Panel</h1>

    <br><br>

    <a href = "http://localhost:8080/SmartCareWeb/booking.jsp">booking</a>
    <h2>Your Appointments</h2>
    <h3>(If table blank no appointments made)</h3>
</div>
<div>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>

        </tr>
        <tr>
            <td><b>Appointment ID</b></td>
            <td><b>Employee ID</b></td>
            <td><b>Client Username</b></td>
            <td><b>Appointment Date</b></td>
            <td><b>Appointment Time</b></td>
            <td><b>Appointment Reason</b></td>
        </tr>
        <%            Connection con1 = null;
            con1 = DBConnection.createConnection();
            PreparedStatement statement1 = null;
            ResultSet resultSet1 = null;

            String Username = UserBean.uname;
            try {

                String sql1 = "SELECT * FROM booking_slots WHERE cid IN (SELECT cid FROM clients WHERE uname = ?)"; //query for collecting data from the database.
                statement1 = con1.prepareStatement(sql1);
                statement1.setString(1, Username);

                resultSet1 = statement1.executeQuery();
                while (resultSet1.next()) {
        %>
        <tr>
            <td><%=resultSet1.getString("sid")%></td>
            <td><%=resultSet1.getString("eid")%></td>
            <td><%=Username%></td>
            <td><%=resultSet1.getString("sdate")%></td>
            <td><%=resultSet1.getString("stime")%></td>
            <td><%=resultSet1.getString("sreason")%></td>
        </tr>

        <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>

</div>
<div id="contentBox" style="margin:0px auto; width:100%; text-align: center">
    <div id="column1" style="float:left; margin:0; width:50%;">
        <h3>Book Appointment:</h3>
        <form action = "http://localhost:8080/SmartCareWeb/booking.jsp">
        <button type="submit">Book Appointment</button>
        </form>
    </div>
    <div id="column2" style="float:left; margin:0; width:50%;">
        <h3>Cancel Appointment:</h3>
        
        <%!
            public class Booking {

                Connection con = null;
                PreparedStatement selectBooking = null;
                ResultSet resultSet = null;
                String Username1 = UserBean.uname;

                public Booking() {
                    try {
                        con = DBConnection.createConnection();

                        selectBooking = con.prepareStatement("SELECT * FROM booking_slots WHERE cid IN (SELECT cid FROM clients WHERE uname = ?)");
                        selectBooking.setString(1, Username1);

                    } catch (SQLException e) {
                    }
                }

                public ResultSet getBooking() {
                    try {

                        resultSet = selectBooking.executeQuery();
                    } catch (SQLException e) {
                    }
                    return resultSet;
                }
            }
        %>
        <%
            Booking booking = new Booking();
            ResultSet Bookings = booking.getBooking();
            Connection con2 = null;
            Statement stmt2 = null;

            if (request.getParameter("submit1") != null) {

                String choice = request.getParameter("bookingChoice");
                con2 = DBConnection.createConnection();

                try {
                    stmt2 = con2.createStatement();
                    String g = "DELETE FROM booking_slots WHERE sid = " + choice + "";
                    stmt2.executeUpdate(g);
                    stmt2.close();
                    con2.commit();
                    con2.close();

                } catch (SQLException ex) {

                }

            }
        %>

        <form name="Bookings" action="user.client.jsp" method="POST">
            <table align="center" border="0">
                <tbody>
                    <tr>
                        <td>Appointment ID's: </td>

                        <td><select name="bookingChoice">
                                <%while (Bookings.next()) {%>
                                <option value="<%= Bookings.getInt("sid")%>">Appointment ID: (<%= Bookings.getString("sid")%>)</option>
                                <%}%>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Cancel Appointment" name="submit1" />
        </form>
          <br><br>                  
    </div>
</div>

<div id="contentBox" style="margin:0px auto; width:100%">
    <div id="column1" style="float:left; margin:0; width:100%;">
        <h2 align="center">Your Prescriptions</h2>
        <br><br>



        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr>
                <td><b>Prescription ID</b></td>
                <td><b>Booking Slot ID</b></td>
                <td><b>Medicine Name</b></td>
                <td><b>Quantity</b></td>
                <td><b>Issue Date</b></td>
                <td><b>End Date</b></td>
            </tr>

            <%                    
                
                try {
                    String Username1 = UserBean.uname;
                    Connection con3 = null;
                    PreparedStatement statement3 = null;
                    ResultSet resultSet3 = null;
                    con3 = DBConnection.createConnection();

                    
                    String sql4 = "SELECT * FROM prescription WHERE cid IN (SELECT cid FROM clients WHERE uname = ?)";
                    statement3 = con3.prepareStatement(sql4);
                    statement3.setString(1, Username1);

                    resultSet3 = statement3.executeQuery();

                    while (resultSet3.next()) {
            %>
            <tr>

                <td><%=resultSet3.getString("pid")%></td>
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
