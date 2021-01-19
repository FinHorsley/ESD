package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DOA.DBConnection;
import java.sql.*;
import beans.UserBean;

public final class user_client_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"SmartCare.css\"> \r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Admin CPanel - SmartCare</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");


        if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);

        } else if (!UserBean.role.equals("client")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);

        }

    
      out.write(" \r\n");
      out.write("    <div class=\"topnav\">\r\n");
      out.write("        <a class=\"title left\">SmartCare Web Page</a>\r\n");
      out.write("        <div class=\"right\">\r\n");
      out.write("            <a class =\"title2\"> Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.uname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("! (role: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a>\r\n");
      out.write("            <a href = \"http://localhost:8080/SmartCareWeb/home.jsp\">Home</a>\r\n");
      out.write("            <a href = \"http://localhost:8080/SmartCareWeb/logout\">Logout</a>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div style=\"text-align: center\">\r\n");
      out.write("        <h1>Welcome to SmartCare Website Client Panel</h1>\r\n");
      out.write("        <h2>Please select your role below!</h2>\r\n");
      out.write("        <br><br>\r\n");
      out.write("    </div>\r\n");
      out.write("    <a href = \"http://localhost:8080/SmartCareWeb/booking.jsp\">booking</a>\r\n");
      out.write("    <table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\r\n");
      out.write("        <tr>\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><b>Appointment ID</b></td>\r\n");
      out.write("            <td><b>Employee ID</b></td>\r\n");
      out.write("            <td><b>Client ID</b></td>\r\n");
      out.write("            <td><b>Appointment Address</b></td>\r\n");
      out.write("            <td><b>Appointment Time</b></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
            
            Connection con = null; //conection to the database
            
            con = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            
            UserBean user = new UserBean();


            String sql = "select * from clients Where uname = '" + user.uname + "'"; //query for collecting data from the database.
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            String CID = result.getString("cid");
            try {
                Connection con1 = null;
                Statement statement1 = null;
                ResultSet resultSet = null;
                con = DBConnection.createConnection();

                statement1 = con1.createStatement();
                String sql1 = "SELECT * FROM booking_slots WHERE cid = '" + CID + "'";

                resultSet = statement1.executeQuery(sql1);
                while (resultSet.next()) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print(resultSet.getString("sid"));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(resultSet.getString("eid"));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(resultSet.getString("cid"));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(resultSet.getString("sdate"));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(resultSet.getString("stime"));
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
