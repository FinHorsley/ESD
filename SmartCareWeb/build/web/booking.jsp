<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry & kamil
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DAO.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script>
            function validate()
            {
                var eid = document.form.eid.value;
                var cid = document.form.cid.value;
                var sdate = document.form.sdate.value;
                var stime = document.form.stime.value;


                if (eid === null || eid === "")
                {
                    alert("Employee ID can't be blank");
                    return false;
                } else if (cid === null || cid === "")
                {
                    alert("Client ID can't be blank");
                    return false;
                } else if (sdate === null || sdate === "")
                {
                    alert("Slot Time can't be blank");
                    return false;
                } else if (stime === null || stime === "")
                {
                    alert("Slot Date can't be blank");
                    return false;
                }

            }
        </script> 
    </head>
    <body>
        <div class="topnav">
            <a class="title left">Book an Appointment</a>
            <a class="right" href="home.jsp">Home</a>
        </div>
    <center><h2>Consultation Booking </h2></center>

    <%!
        public class Employee {

            Connection con6 = null;
            PreparedStatement selectEmployee = null;
            ResultSet resultSet2 = null;

            public Employee() {
                try {
                    con6 = DBConnection.createConnection();

                    selectEmployee = con6.prepareStatement("SELECT * FROM employee");

                } catch (SQLException e) {
                }
            }

            public ResultSet getInClient() {
                try {
                    resultSet2 = selectEmployee.executeQuery();
                } catch (SQLException e) {
                }
                return resultSet2;
            }
        }
    %>

    <%
        Employee employee = new Employee();
        ResultSet Employee = employee.getInClient();
    %> 

    <form name="form" action="booking" method="post" onsubmit="return validate()">

        <table align="center">
            <tr>
                <td>Employee Id: </td>
                <td><select name="EmployeeChoice">
                        <%while (Employee.next()) {%>
                        <option value="<%= Employee.getString("eid")%>"><%= Employee.getString("ename")%></option>
                        <%}%>
                    </select></td>
            </tr>
            <tr>
                <td>Slot Date:</td>
                <td><input type="date" name="sdate" /></td>
            </tr>
            <tr>
                <td>Slot Time:</td>
                <td><input type="time" name="stime" /></td>
            </tr>
            <tr>
                <td>Appointment Reason</td>
                <td><select name ="sreason">
                        <option value ="Prescription"> Prescription</option>
                        <option value ="Consoltation"> Consultation</option>
                    </select></td>
            </tr>
            <tr>
                    <td><%=(request.getAttribute("errMessage") == null) ? ""
                        : request.getAttribute("errMessage")%></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Confirm"></input><input
                        type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</body>
</html>