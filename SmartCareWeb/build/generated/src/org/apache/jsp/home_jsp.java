package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        </style>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Admin CPanel - SmartCare</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            //allow access only if session exists
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("cookieUser")) userName = cookie.getValue();
                    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                }
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"topnav\">\r\n");
      out.write("            <a class=\"title left\">SmartCare Web Page</a>\r\n");
      out.write("            <div class=\"right\">\r\n");
      out.write("                <a class =\"title2\"> Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.uname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("! (role: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a>\r\n");
      out.write("                <a href = \"http://localhost:8080/SmartCareWeb/role\">Client Area</a>\r\n");
      out.write("                <a href = \"http://localhost:8080/SmartCareWeb/logout\">Logout</a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div style=\"text-align: center\">\r\n");
      out.write("            <h1>Welcome to SmartCare Home Page</h1>\r\n");
      out.write("            <h2>Please select your role below!</h2>\r\n");
      out.write("            <br><br>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
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
