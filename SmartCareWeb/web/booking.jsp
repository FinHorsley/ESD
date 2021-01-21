<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry & kamil
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DOA.DBConnection"%>
<%@page import="java.sql.ResultSet"%>           <%-- importing packages --%>
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
                    alert("Client ID can't be blank");      <%-- validating fiels which are inputed by the user --%>
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
            <a class="title left">Book an Appointment</a> <%-- displaying text --%>
            <a class="right" href="home.jsp">Home</a> <%-- creating a button on top right of page --%>
        </div>
    <center><h2>Consultation Booking </h2></center> <%-- displaying text --%>

    <%!
        public class Employee {

            Connection con6 = null;
            PreparedStatement selectEmployee = null; //creating a connection to database
            ResultSet resultSet2 = null;

            public Employee() {
                try {
                    con6 = DBConnection.createConnection();

                    selectEmployee = con6.prepareStatement("SELECT * FROM employee"); //selecting everything from employee table

                } catch (SQLException e) {
                }
            }

            public ResultSet getInClient() {
                try {
                    resultSet2 = selectEmployee.executeQuery(); //exacuting quary
                } catch (SQLException e) {
                }
                return resultSet2;
            }
        }
    %>

    <%
        Employee employee = new Employee(); //make new employee class
        ResultSet Employee = employee.getInClient(); //get the information about the client by calling this method
    %> 

    <form name="form" action="booking" method="post" onsubmit="return validate()">
        <table align="center"> <%-- creating a table and centering it --%>
            <tr>
                <td>Employee Id: </td> <%-- displaying label --%>
                <td><select name="EmployeeChoice">
                        <%while (Employee.next()) {%>
                        <option value="<%= Employee.getString("eid")%>"><%= Employee.getString("ename")%></option>
                        <%}%>   <%-- making a drop down manu with populated fields from the database --%>
                    </select></td>
            </tr>
            <tr>
                <td>Slot Date:</td>
                <td><input type="date" name="sdate" /></td> <%-- displaying label and making input box  --%>
            </tr>
            <tr>
                <td>Slot Time:</td>
                <td><input type="time" name="stime" /></td> <%-- displaying label and making input box  --%>
            </tr>
            <tr>
                <td>Appointment Reason</td> <%-- displaying label and making input box  --%>
                <td><select name ="sreason">
                        <option value ="Prescription"> Prescription</option><%-- making a drop down menu with appointment options to choose from --%>
                        <option value ="Consoltation"> Consultation</option>
                    </select></td>
            </tr>
            <tr>
                    <td><%=(request.getAttribute("errMessage") == null) ? "" //displaying error massages if there are any
                        : request.getAttribute("errMessage")%></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Confirm"></input><input <%-- creating confirm and reset buttons  --%>
                        type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</body>
</html>