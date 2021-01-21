<%-- 
    Document   : register
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry
--%>

<%@page import="DAO.DBConnection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css"> 
        <meta charset="utf-8">
        <title>SmartCare Website</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script>
            function validate()
            {
                var name = document.form.name.value;
                var username = document.form.uname.value;
                var address = document.form.address.value;
                var type = document.form.type.value;
                var passwd = document.form.passwd.value;
                var conpasswd = document.form.conpasswd.value;


                if (name === null || name === "")
                {
                    alert("Name can't be blank");
                    return false;
                } else if (uname === null || username === "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (address === null || address === "")
                {
                    alert("Type can't be blank");
                    return false;
                } else if (type === null || type === "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (passwd === null || passwd === "")
                {
                    alert("Password can't be blank");
                    return false;
                } else if (passwd.length < 6)
                {
                    alert("Password must be at least 6 characters long.");
                    return false;
                } else if (passwd != conpasswd)
                {
                    alert("Confirm Password should match with the Password");
                    return false;
                }
            }
        </script> 
        <%-- 
            code Segment   : Start of google map Api import
        --%>
        <script>
            function initAutocomplete() {
                var map = new google.maps.Map(document.getElementById('map'), {
                    center: {
                        lat: 48,
                        lng: 4
                    },
                    zoom: 4,
                    disableDefaultUI: true
                });

                // Create the search box and link it to the UI element.
                var input = document.getElementById('my-input-searchbox');
                var autocomplete = new google.maps.places.Autocomplete(input);
                map.controls[google.maps.ControlPosition.TOP_CENTER].push(input);
                var marker = new google.maps.Marker({
                    map: map
                });

                // Bias the SearchBox results towards current map's viewport.
                autocomplete.bindTo('bounds', map);
                // Set the data fields to return when the user selects a place.
                autocomplete.setFields(
                        ['address_components', 'geometry', 'name']);

                // Listen for the event fired when the user selects a prediction and retrieve
                // more details for that place.
                autocomplete.addListener('place_changed', function () {
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        console.log("Returned place contains no geometry");
                        return;
                    }
                    var bounds = new google.maps.LatLngBounds();
                    marker.setPosition(place.geometry.location);

                    if (place.geometry.viewport) {
                        // Only geocodes have viewport.
                        bounds.union(place.geometry.viewport);
                    } else {
                        bounds.extend(place.geometry.location);
                    }
                    map.fitBounds(bounds);
                });
            }
            document.addEventListener("DOMContentLoaded", function (event) {
                initAutocomplete();
            });
        </script>
        <%-- 
            code Segment   : End of google map api places import
        --%>        
    </head>
    <body>
        <div class="topnav">
            <a class="title left">Employee Registration</a>
            <a class="right" href="index.jsp">Home</a>
        </div>
    <center><h2>Create Operation </h2></center>

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

            public ResultSet getEmployee() {
                try {
                    resultSet2 = selectEmployee.executeQuery();
                } catch (SQLException e) {
                }
                return resultSet2;
            }
        }

        public class Client {

            Connection con7 = null;
            PreparedStatement selectClient = null;
            ResultSet resultSet3 = null;

            public Client() {
                try {
                    con7 = DBConnection.createConnection();

                    selectClient = con7.prepareStatement("SELECT * FROM clients");

                } catch (SQLException e) {
                }
            }

            public ResultSet getClient() {
                try {
                    resultSet3 = selectClient.executeQuery();
                } catch (SQLException e) {
                }
                return resultSet3;
            }
        }
    %>

    <%
        Client client = new Client();
        ResultSet Clients = client.getClient();

        Employee employee = new Employee();
        ResultSet Employee = employee.getEmployee();
    %> 

    <form name="form" action="OperationCreation" method="post" onsubmit="return validate()">

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
                <td>Client Id: </td>
                <td><select name="ClientChoice">
                        <%while (Clients.next()) {%>
                        <option value="<%= Clients.getString("cid")%>"><%= Clients.getString("cname")%></option>
                        <%}%>
                    </select></td>
            </tr>
            <tr>
                <td>Operation Date</td>
                <td><input type="date" name="odate" /></td>
            </tr>
            <tr>
                <td>Operation Time:</td>
                <td><input type="time" name="otime" /></td>
            </tr>
            <tr>
                <td>NSlot: </td>
                <td><input type="number" name="nslot" /></td>
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