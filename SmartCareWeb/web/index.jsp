<%-- 
    Document   : index
    Created on : 08-Dec-2020, 16:17:22
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

            //redirect user to home page if already logged in
            if (uname != null) {
                response.sendRedirect("home.jsp");
            }

            String status = request.getParameter("status");

            if (status != null) {
                if (status.equals("false")) {
                    out.print("Incorrect login details!");
                } else {
                    out.print("Some error occurred!");
                }
            }
        %>

        <form action="loginRequestHandler.jsp">
            <table cellpadding="5">
                <tr>
                    <td><b>Username</b></td>
                    <td><input type="text" name="uname" required/></td>
                </tr>

                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" name="passwd" required/></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login"/></td>
                </tr>

            </table>
        </form>

    </body>
</html>
