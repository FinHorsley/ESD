<%-- 
    Document   : register
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry
--%>

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
    <center><h2>Registration </h2></center>

    <form name="form" action="EmployeeRegister" method="post" onsubmit="return validate()">
        <table align="center">
            <tr>
                <td>Enter Full Name</td>
                <td><input  type="text" name="name" placeholder="Enter Full Name" /></td>
            </tr>
            <tr>
                <td>Enter Username</td>
                <td><input  type="text" name="uname" placeholder="Enter Username"/></td>
            </tr>
            <tr>
                <td>Enter Address</td>  
                <td><input id="my-input-searchbox" type="text" placeholder="Enter Address" name ="address">
                    <div id="map"></div>
                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBtaj_5ZLCTnn5iGxYZMh7zogDTwxlTN6Y&libraries=places&callback=initMap"></script>
                </td>
            <tr>
                <td>Enter Type</td>
                <td><select name="type">
                        <option value="doctor">Doctor</option>
                        <option value="nurse">Nurse</option>
                    </select></td>
            </tr>
            <tr>
            <tr>
                <td>Enter Password</td>
                <td><input  type="password" name="passwd" placeholder="Enter Password"/></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input  type="password" name="conpasswd" placeholder="Confirm Password"/></td>
            </tr>
            <tr>
                    <td><%=(request.getAttribute("errMessage") == null) ? ""
                        : request.getAttribute("errMessage")%></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register"></input><input
                        type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</body>
</html>