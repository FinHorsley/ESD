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
            <a class="title left">Create Prescription</a>
            <a class="right" href="home.jsp">Home</a>
        </div>
    <center><h2>Consultation Booking </h2></center>

    <%!
        public class Client {

            Connection con6 = null;
            PreparedStatement selectClient = null;
            ResultSet resultSet2 = null;

            public Client() {
                try {
                    con6 = DBConnection.createConnection();

                    selectClient = con6.prepareStatement("SELECT * FROM clients");

                } catch (SQLException e) {
                }
            }

            public ResultSet getClient() {
                try {
                    resultSet2 = selectClient.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return resultSet2;
            }
        }
    %>

    <%
        Client client = new Client();
        ResultSet Client = client.getClient();
    %> 

    <form name="form" action="setp" method="post" onsubmit="return validate()">

        <table align="center">
            <tr>
                <td>Client Name: </td>
                <td><select name="ClientChoice">
                        <%while (Client.next()) {%>
                        <option value="<%= Client.getString("cid")%>"><%= Client.getString("cname")%></option>
                        <%}%>
                    </select></td>
            </tr>
            <tr>   
                <td>Enter Medicine Name: </td>
                <td><input  type="text" placeholder="Enter Medicine Name" name ="MedicineName">  </td>  
            </tr>

            <tr>  
                <td>Enter Quantity: </td>
                <td><input  type="number" placeholder="Enter Quantity" name ="MedicineQuantity">    </td>
            </tr>


            <tr>   
                <td>Is Recurring?: </td>
                <td><select name ="repeatp">
                        <option value="yes">Yes</option>
                        <option value="no">No</option>
                    </select></td>   
            </tr>  

            <tr>
                <td>Issue Date:</td>
                <td><input type="date" name="pStartDate" /></td>
            </tr>
            <tr>
                <td>End of use date:</td>
                <td><input type="date" name="pEndDate" /></td>
            </tr>
            <tr>
                <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Confirm"></input><input type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</body>
</html>