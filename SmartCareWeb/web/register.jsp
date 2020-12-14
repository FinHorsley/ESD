<%-- 
    Document   : register
    Created on : 14-Dec-2020, 20:46:13
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta charset="utf-8">
        <title>SmartCare Website</title>
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
            }

            .right {
                float: right;
            }
            .topnav a:hover {
                background-color: #D2D1C4;
                color: black;
            }

            .topnav a.title {
                background-color: #DFDED2;
                color: black;
                font-size: 20px;
            }
        </style>
    </head>   
    <body>  

        <div class="topnav">
            <a class="title left">SmartCare Web Page</a>
        </div>    
        <div style="text-align: center">
        <h1>Registration</h1>
        <form action="register" method="post">  

            Name:<input type="text" name="userName"/><br/><br/>  
            Password:<input type="password" name="userPass"/><br/><br/>  
            Email:<input type="text" name="userEmail"/><br/><br/>  
            Country:<input type="text" name="userAddress"/><br/><br/> 

            <br/><br/>  
            <input type="submit" value="register"/>  

        </form> 
        </div>
    </body>  
</html>  
