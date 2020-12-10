<%-- 
    Document   : logout
    Created on : 09-Dec-2020, 11:47:26
    Author     : harry
--%>


<%
session.invalidate();
response.sendRedirect("index.jsp");
%>