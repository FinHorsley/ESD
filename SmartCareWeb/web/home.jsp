<%-- 
    Document   : home
    Created on : 09-Dec-2020, 11:46:42
    Author     : harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login System</title>
    </head>

    <body>
        <%
            String uname = (String) session.getAttribute("uname");

            //redirect user to login page if not logged in
            if (uname == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <p>Welcome <%=uname%> </p>    
        <a href="logout.jsp">Logout</a>
    </body>
</html>
