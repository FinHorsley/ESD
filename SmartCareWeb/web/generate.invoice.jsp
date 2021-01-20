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
            background{
                background-image: url('Medical-Invoice-Template.jpg');
            }

            h3{

                font-size: 30px;
                text-align: left;
            }
            h4{
                font-family: ariel;
                text-align: left;
            }

            h5{
                font-size: 20px;
                font-family: ariel;
                text-align: right;
                padding-right: 170px;
            }

            h6{
                display: inline-block;
                margin-left: 100px;
                text-align: right;
                padding-top: -100px
            }

            table {
                font-family: arial;
                border-collapse: collapse;
                width: 100%;
            }

            tr, th {
                border: 1px solid #000000;
                text-align: center;
                padding: 8px;
            }
            
            input{
                border: #F5F5DC;
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

            } else if (!UserBean.role.equals("client")) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

        %> 


        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
            <div class="right">
                <a class="right" href = "http://localhost:8080/SmartCareWeb/home.jsp">Home</a>
                <a class="right" href = "http://localhost:8080/SmartCareWeb/logout">Logout</a>
            </div>

        </div>

        <div style="text-align: center">
            <h1>Welcome to SmartCare Invoice Centre</h1>
            <h2>Below you will find your generated invoice</h2>
            <br><br>
        </div>
    <center>
        <div style= "background-color:beige;width:1000px;height:600px;border:25px solid #F5F5DC;">
            <h3>Smart Care Invoice</h3> 
            <h4>Invoice Number:  <input style="background-color:beige;margin-right: 700px;display: inline-block;text-align: left;float: right;" type="number" id="iid" name="iid" /></h4>        
            <h4>Patient Name:    <input style="background-color:beige;margin-right: 700px;display: inline-block;text-align: left;float: right;" type="text" id="cname" name="cname" /></h4>     
            <h4>Patient Address: <input style="background-color:beige;margin-right: 700px;display: inline-block;text-align: left;float: right;" type="text" id="address" name="address" /></h4> 
            <h4>Physician:       <input style="background-color:beige;margin-right: 700px;display: inline-block;text-align: left;float: right;" type="text" id="ename" name="ename" /></h4>     
            <br>
            <table style="width:100%">
                <tr>
                    <th>Date</th> 
                    <th>Services Performed</th>
                    <th>Medication Prescribed</th>
                    <th>Amount Due</th>
                </tr>
                <tr>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th> 
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                </tr>
                <tr>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th> 
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                </tr>
                <tr>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th> 
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                </tr>
                <tr>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th> 
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                </tr>
                <tr>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th> 
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                    <th><input style="background-color:beige; width: 150px;" type="text" id="iid" name="iid" /></th>
                </tr>
            </table>
            <h5> Total: <input style =" border: #F5F5DC; margin-right: -87px; width: 75px;" type="number" id="total" name="total" /> </h5>

        </div>    
    </center>                
</body> 
</html>


