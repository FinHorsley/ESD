package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import DOA.DBConnection;
import java.sql.Connection;
import beans.UserBean;

public final class user_admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                            public class Client {

                                Connection con = null;
                                PreparedStatement selectClient = null;
                                PreparedStatement deleteClient = null;
                                ResultSet resultSet = null;

                                public Client() {
                                    try {
                                        con = DBConnection.createConnection();

                                        selectClient = con.prepareStatement("SELECT uname, passwd, role FROM users");
                                        selectClient = con.prepareStatement("DELETE FROM users WHERE uname =?");

                                    } catch (SQLException e) {
                                    }
                                }

                                public ResultSet getClient() {
                                    try {
                                        resultSet = selectClient.executeQuery();
                                    } catch (SQLException e) {
                                    }
                                    return resultSet;
                                }

                                public int deleteClient(Integer id) {
                                    int result = 0;

                                    try {
                                        deleteClient.setInt(1, id);
                                        result = deleteClient.executeUpdate();
                                    } catch (SQLException e) {
                                    }
                                    return result;
                                }
                            }
                        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                margin: 0;\r\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .topnav {\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                background-color: #DFDED2;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .topnav a {\r\n");
      out.write("                color: #f2f2f2;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                padding: 14px 16px;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                font-size: 17px;\r\n");
      out.write("                color: black;\r\n");
      out.write("            }\r\n");
      out.write("            .left {\r\n");
      out.write("                float: left;\r\n");
      out.write("                padding-top: 14px;\r\n");
      out.write("                padding-right: 16px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .right {\r\n");
      out.write("                float: right;\r\n");
      out.write("                padding-top: 14px;\r\n");
      out.write("                padding-right: 16px;\r\n");
      out.write("            }\r\n");
      out.write("            .topnav a:hover {\r\n");
      out.write("                background-color: #D2D1C4;\r\n");
      out.write("                color: black;\r\n");
      out.write("            }\r\n");
      out.write("            .topnav buttons {\r\n");
      out.write("                background-color: #A99E9E;\r\n");
      out.write("                color: black;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .topnav a.title {\r\n");
      out.write("                background-color: #DFDED2;\r\n");
      out.write("                color: black;\r\n");
      out.write("                font-size: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .topnav a.title2 {\r\n");
      out.write("                background-color: #DFDED2;\r\n");
      out.write("                color: black;\r\n");
      out.write("                font-size: 12px;\r\n");
      out.write("            }\r\n");
      out.write("            table, th, td {\r\n");
      out.write("                border: 1px solid black;\r\n");
      out.write("\r\n");
      out.write("            </style>\r\n");
      out.write("            <meta charset=\"utf-8\">\r\n");
      out.write("            <title>Admin CPanel - SmartCare</title>\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("            ");


                if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                    RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                    RequetsDispatcherObj.forward(request, response);

                } else if (!UserBean.role.equals("admin")) {

                    RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                    RequetsDispatcherObj.forward(request, response);

                }

            
      out.write("  \r\n");
      out.write("\r\n");
      out.write("            <div class=\"topnav\">\r\n");
      out.write("                <a class=\"title left\">SmartCare Web Page</a>\r\n");
      out.write("                <div class=\"right\">\r\n");
      out.write("                    <a class =\"title2\"> Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.uname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("! (role: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a>\r\n");
      out.write("                    <a href = \"http://localhost:8080/SmartCareWeb/home.jsp\">Home</a>\r\n");
      out.write("                    <a href = \"http://localhost:8080/SmartCareWeb/logout\">Logout</a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div style=\"text-align: center\">\r\n");
      out.write("                    <h1>Welcome to SmartCare Website Admin Panel</h1>\r\n");
      out.write("                    <h2>Please select your role below!</h2>\r\n");
      out.write("                    <br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div>   \r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"contentBox\" style=\"margin:0px auto; width:70%\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- columns divs, float left, no margin so there is no space between column, width=1/3 -->\r\n");
      out.write("                    <div id=\"column1\" style=\"float:left; margin:0; width:33%;\">\r\n");
      out.write("                    <h2>non-approved Staff accounts:</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"column2\" style=\"float:left; margin:0;width:33%;\">\r\n");
      out.write("                    <h2>non-approved Staff accounts:</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"column3\" style=\"float:left; margin:0;width:33%\">\r\n");
      out.write("                        <h2>Remove Client Account:</h2>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");

                            int result = 0;
                            Client client = new Client();
                            ResultSet clients = client.getClient();

                            Integer clientId = new Integer(0);

                            if (request.getParameter("submit") != null) {
                                clientId = Integer.parseInt(request.getParameter("client"));
                                result = client.deleteClient(clientId);
                            }
                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <form name=\"Clients\" action=\"user.admin.jsp\" method=\"POST\">\r\n");
      out.write("                            <table border=\"0\">\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Clients Username: </td>\r\n");
      out.write("                                        ");
while (clients.next()) {
      out.write("\r\n");
      out.write("                                        <td><select name=\"client\">\r\n");
      out.write("                                                <option value=\"");
      out.print( clients.getInt("client_id"));
      out.write('"');
      out.write('>');
      out.print( clients.getString("uname"));
      out.write("</option>\r\n");
      out.write("                                                ");
}
      out.write("\r\n");
      out.write("                                            </select></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </body>\r\n");
      out.write("        </html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
