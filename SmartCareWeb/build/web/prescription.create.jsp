<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry & kamil
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DOA.DBConnection"%>
<%@page import="java.sql.ResultSet"%>  <%-- importing needed packages --%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <%-- linking the css style sheet --%>
        <title>Register</title> <%-- display title --%>
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title> <%-- display title --%>
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
                    alert("Client ID can't be blank"); //validate the user inputs
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
            <a class="title left">Create Prescription</a> <%-- navigation menu --%>
            <a class="right" href="home.jsp">Home</a>
        </div>
    <center><h2>Consultation Booking </h2></center> <%-- display title --%>

    <%!
        public class Client {

            Connection con6 = null;
            PreparedStatement selectClient = null; //create a connection to the database
            ResultSet resultSet2 = null;

            public Client() {
                try {
                    con6 = DBConnection.createConnection();

                    selectClient = con6.prepareStatement("SELECT * FROM clients"); //select every element from client table

                } catch (SQLException e) {
                }
            }

            public ResultSet getClient() {
                try {
                    resultSet2 = selectClient.executeQuery(); // execute a query
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return resultSet2;
            }
        }
    %>

    <%
        Client client = new Client();
        ResultSet Client = client.getClient(); //creating new instances of client bean to be accessed for data retrival
    %> 

    <form name="form" action="setp" method="post" onsubmit="return validate()">

        <table align="center">
            <tr>
                <td>Client Name: </td>
                <td><select name="ClientChoice"> <%-- choose client from drop down box --%>
                        <%while (Client.next()) {%>
                        <option value="<%= Client.getString("cid")%>"><%= Client.getString("cname")%></option>
                        <%}%>
                    </select></td>
            </tr>
            <tr>   
                <td>Enter Medicine Name: </td> <%-- box for entering the medicine name --%>
                <td><input  type="text" placeholder="Enter Medicine Name" name ="MedicineName">  </td>  
            </tr>

            <tr>  
                <td>Enter Quantity: </td> <%-- box for entering medicine quantity  --%>
                <td><input  type="number" placeholder="Enter Quantity" name ="MedicineQuantity">    </td>
            </tr>


            <tr>   
                <td>Is Recurring?: </td> <%-- drop down box to select if perscription is reocurring --%>
                <td><select name ="repeatp">
                        <option value="yes">Yes</option>
                        <option value="no">No</option>
                    </select></td>   
            </tr>  

            <tr>
                <td>Issue Date:</td> <%-- box for data input --%>
                <td><input type="date" name="pStartDate" /></td>
            </tr>
            <tr>
                <td>End of use date:</td> <%-- box for data input --%>
                <td><input type="date" name="pEndDate" /></td>
            </tr>
            <tr>
                <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td> <%-- display error messages if there are any --%>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Confirm"></input><input type="reset" value="Reset"></input></td> <%-- creating submit and reset buttons --%>
            </tr>
        </table>
    </form>
</body>
</html>