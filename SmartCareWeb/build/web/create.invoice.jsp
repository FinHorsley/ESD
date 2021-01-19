<%-- 
    Document   : home
    Created on : 10-Dec-2020, 14:05:07
    Author     : harry
--%>

<%@page import="bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                padding-top: 14px;
                padding-right: 16px;
            }

            .right {
                float: right;
                padding-top: 14px;
                padding-right: 16px;
            }
            .topnav a:hover {
                background-color: #D2D1C4;
                color: black;
            }
            .topnav buttons {
                background-color: #A99E9E;
                color: black;
            }

            .topnav a.title {
                background-color: #DFDED2;
                color: black;
                font-size: 20px;
            }
            .topnav a.title2 {
                background-color: #DFDED2;
                color: black;
                font-size: 12px;
            }
            .middle {
                display: table-cell;
                vertical-align: middle;
            }
        </style>
                
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
                        
                        }
                        else if (!UserBean.role.equals("nurse")){
                            
                            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                            RequetsDispatcherObj.forward(request, response);
                        
                        }
                    
                    %> 


        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class ="title2"> Welcome ${user.uname}! (role: ${user.role})</a>
                <a href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
                <a href = "http://localhost:8080/SmartCareWeb/create.invoice.jsp">Billing Centre</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Billing Centre</h1>
            <h2>Please fill out the invoice form below</h2>
            <br><br>
        </div>
    <center>
        <div
            style= "background-color:beige;width:500px;height:180px;border:25px solid #F5F5DC;"><u><b>Invoice Form</b></u>

            <form name="form" action="invoice" method="post">
                <table align="center">
                    <tr></tr>
                    <tr>
                        <td>Enter Client Full Name: </td>
                        <td><input maxlength="22" type="text" name="clientname" placeholder="Enter Full Name" /></td>
                    </tr>
                    <tr>
                        <td>Enter Client ID: </td>
                        <td><input oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="3" type="number" name="clientid" placeholder="Enter Client ID"/></td>
                    </tr>
                    <tr>
                        <td>Enter Client Address: </td>  
                        <td><input id="my-input-searchbox" type="text" placeholder="Enter Address" name ="clientaddress">
                            <div id="map"></div>
                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBtaj_5ZLCTnn5iGxYZMh7zogDTwxlTN6Y&libraries=places&callback=initMap"></script>
                        </td>
                    </tr>
                    <tr>
                        <td>Enter Consultation Type: </td>
                        <td><select name="consultationtype" id="type">
                                <option value="NHS">NHS</option>
                                <option value="Private">Private</option>   
                            </select></td>
                    </tr>
                    <tr>
                        <td>Enter Consultation Time: </td>
                        <td><input oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength ="2" type="number" name="consultationtime" placeholder="Minutes"/></td>
                    </tr>

                    
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Generate Invoice">
                        <input type="reset" value="Reset">
                    </tr>
                </table>
            </form>
        </div>    
    </center>                
</body> 
</html>

