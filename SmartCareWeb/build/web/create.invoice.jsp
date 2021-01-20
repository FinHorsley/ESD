<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DOA.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="SmartCare.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">              
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
        <meta charset="utf-8">
        <title>Admin CPanel - SmartCare</title>
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
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/create.invoice.jsp">Billing Centre</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Billing Centre</h1>
            <h2>Please fill out the invoice form below</h2>
            <br><br>
        </div>
    <center>
        <div style= "background-color:beige;width:500px;height:200px;border:25px solid #F5F5DC;"><u><b>Invoice Form</b></u>
            <table align="center">
                <tr></tr>
                <tr>
                    <td>
                        <%!
                            public class InEmployee {

                                Connection con5 = null;
                                PreparedStatement selectEmployee = null;
                                ResultSet resultSet1 = null;

                                public InEmployee() {
                                    try {
                                        con5 = DBConnection.createConnection();

                                        selectEmployee = con5.prepareStatement("SELECT * FROM employee");

                                    } catch (SQLException e) {
                                    }
                                }

                                public ResultSet getInEmployee() {
                                    try {
                                        resultSet1 = selectEmployee.executeQuery();
                                    } catch (SQLException e) {
                                    }
                                    return resultSet1;
                                }
                            }

                            

                            public class InSlot {
                                Connection con7 = null;
                                PreparedStatement selectSlot = null;
                                ResultSet resultSet3 = null;
                                public InSlot() {
                                    try {
                                        con7 = DBConnection.createConnection();

                                        selectSlot = con7.prepareStatement("SELECT * FROM booking_slots");

                                    } catch (SQLException e) {
                                    }
                                }

                                public ResultSet getInSlot() {
                                    try {
                                        resultSet3 = selectSlot.executeQuery();
                                    } catch (SQLException e) {
                                    }
                                    return resultSet3;
                                }
                            }                             

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
                            InEmployee employee = new InEmployee();
                            ResultSet Employee = employee.getInEmployee();

                            InClient client = new InClient();
                            ResultSet Client = client.getInClient();
                            

                            InSlot slot = new InSlot();
                            ResultSet Slot = slot.getInSlot();
                        %>


                        <form name="Clients" action="invoice" method="POST">
                            <table align="center" border="0">
                                <tbody>
                                    <tr>
                                        <td>Employee Name: </td>

                                        <td><select name="EmployeeChoice">
                                                <%while (Employee.next () 
                                                        ) {%>
                                                <option value="<%= Employee.getString("eid")%>"><%= Employee.getString("ename")%></option>
                                                <%}%>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td>Clients Name: </td>

                                        <td><select name="ClientChoice">
                                                <%while (Client.next () 
                                                        ) {%>
                                                <option value="<%= Client.getString("cid")%>"><%= Client.getString("cname")%></option>
                                                <%}%>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td>Slot ID: </td>

                                        <td><select name="SlotChoice">
                                                <%while (Slot.next () 
                                                        ) {%>
                                                <option value="<%= Slot.getString("sid")%>"><%= Slot.getString("sid")%></option>
                                                <%}%>
                                            </select></td>
                                    </tr>
                                    <tr>
                                            <td><%=(request.getAttribute("errMessage") == null) ? ""
                                                    : request.getAttribute("errMessage")%></td>
                                    </tr>
                                </tbody>
                            </table>


                            <input type="submit" value="Approve User" name="submit" />
                        </form>


                        </div>    
                        </center>                
                        </body> 
                        </html>

