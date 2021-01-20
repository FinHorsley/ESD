<%-- 
    Document   : login
    Author     : FinHorsley
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DOA.DBConnection"%>
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
                var clientId = document.form.clientid.value;
                var medicine = document.form.medicine.value;
                var quantity = document.form.quantity.value;
                var repeating = document.form.repeating.value;
                var issueDate = document.form.issueDate.value;
                var endDate = document.form.endDate.value;
                
                if (medicine === null || medicine === "")
                {
                    alert("Medicine cannot be blank");
                    return false;
                    
                } else if (quantity === null || quantity === "")
                {
                    alert("Quantity cannot be blank");
                    return false;
                    
                } else if (repeating === null || repeating === "")
                {
                    alert("Repeating can't be blank");
                    return false;

                } else if (issueDate === null || issueDate === "")
                {
                    alert("Issue Date can't be blank");
                    return false;
                } else if (endDate === null || endDate === "")
                {
                    alert("End Date can't be blank");
                    return false;
                }
            }
        </script> 
    </head>
    <body>
        <div class="topnav">
            <a class="title left">Create a prescription</a>
            <a class="right" href="home.jsp">Home</a>
        </div>
    <center><h2>Create Prescription </h2></center>
    
        <%!
            public class InClient {
                            Connection con6 = null;
                            PreparedStatement selectClient = null;
                                ResultSet resultSet2 = null;
                                public InClient() {
                                    try {
                                        con6 = DBConnection.createConnection();
                                        selectClient = con6.prepareStatement("SELECT * FROM clients");
                                    } catch (SQLException e) {
                                    }
                                }
                                public ResultSet getInClient() {
                                    try {
                                        resultSet2 = selectClient.executeQuery();
                                    } catch (SQLException e) {
                                    }
                                    return resultSet2;
                                }
                            }
        %>

        <%
            InClient client = new InClient();
            ResultSet Client = client.getInClient();
        %> 
        
    <form name="form" action="prescription" method="post" onsubmit="return validate()">

        <table align="center">
            <tr>
                <td>Clients Name: </td>
                    <td><select name="cId">
                        <%while (Client.next () 
                                ) {%>
                            <option value="<%= Client.getString("cid")%>"><%= Client.getString("cname")%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
            <tr>
                <td>Medicine:</td>
                <td><input type="date" name="medicine" /></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="time" name="quantity" /></td>
            </tr>
            <tr>
                <td>Repeating</td>
                <td><input type="text" name="repeating" /></td>
            </tr>
            <tr>
                <td>Issue Date</td>
                <td><input type="text" name="issueDate" /></td>
            </tr>
            <tr>
                <td>End Date</td>
                <td><input type="text" name="endDate" /></td>
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