<%-- 
    Document   : login
    Created on : 10-Dec-2020, 13:48:41
    Author     : harry & kamil
--%>

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
            <a class="title left">SmartCare Web Page</a>
            <a class="right" href="index.jsp">Home</a>
        </div>
    <center><h2>Consultation Booking </h2></center>
    <form name="form" action="booking" method="post" onsubmit="return validate()">
        <table align="center">
            <tr>
                <td>Employee Id: </td>
                <td><input type="number" name="eid" /></td>
            </tr>
            <tr>
                <td>Client ID: </td>
                <td><input type="number" name="cid" /></td>
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