<%-- 
    Document   : loginRequestHandler
    Created on : 09-Dec-2020, 11:45:13
    Author     : harry
--%>
<%@page import="net.LoginDAO"%>
<jsp:useBean id="loginBean" class="net.LoginBean" scope="session"/>
<jsp:setProperty name="loginBean" property="*"/>

<%
    String result = LoginDAO.loginCheck(loginBean);

    if (result.equals("true")) {
        session.setAttribute("uname", loginBean.getuname());
        response.sendRedirect("home.jsp");
    }

    if (result.equals("false")) {
        response.sendRedirect("index.jsp?status=false");
    }

    if (result.equals("error")) {
        response.sendRedirect("index.jsp?status=error");
    }

%>