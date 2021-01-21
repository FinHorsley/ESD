package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.PrescriptionBean;
import beans.SlotBean;
import beans.ClientBean;
import beans.InvoiceBean;
import beans.EmployeeBean;
import java.sql.Statement;
import java.sql.SQLException;
import DOA.DBConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Connection;
import beans.UserBean;

public final class finance_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav {\n");
      out.write("                overflow: hidden;\n");
      out.write("                background-color: #DFDED2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav a {\n");
      out.write("                color: #f2f2f2;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 17px;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .left {\n");
      out.write("                float: left;\n");
      out.write("                padding-top: 14px;\n");
      out.write("                padding-right: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .right {\n");
      out.write("                float: right;\n");
      out.write("                padding-top: 14px;\n");
      out.write("                padding-right: 16px;\n");
      out.write("            }\n");
      out.write("            .topnav a:hover {\n");
      out.write("                background-color: #D2D1C4;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .topnav buttons {\n");
      out.write("                background-color: #A99E9E;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav a.title {\n");
      out.write("                background-color: #DFDED2;\n");
      out.write("                color: black;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            .topnav a.title2 {\n");
      out.write("                background-color: #DFDED2;\n");
      out.write("                color: black;\n");
      out.write("                font-size: 12px;\n");
      out.write("            }\n");
      out.write("            .middle {\n");
      out.write("                display: table-cell;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            background{\n");
      out.write("                background-image: url('Medical-Invoice-Template.jpg');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h3{\n");
      out.write("\n");
      out.write("                font-size: 30px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            h4{\n");
      out.write("                font-family: ariel;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h5{\n");
      out.write("                font-size: 20px;\n");
      out.write("                font-family: ariel;\n");
      out.write("                text-align: right;\n");
      out.write("                padding-right: 170px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h6{\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-left: 100px;\n");
      out.write("                text-align: right;\n");
      out.write("                padding-top: -100px\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                font-family: arial;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr, th {\n");
      out.write("                border: 1px solid #000000;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 8px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input{\n");
      out.write("                border: #F5F5DC;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Admin CPanel - SmartCare</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");


            if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            } else if ((!UserBean.role.equals("client")) && (!UserBean.role.equals("admin"))) {

                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                RequetsDispatcherObj.forward(request, response);

            }

            EmployeeBean ERBean = new EmployeeBean();
            InvoiceBean IRBean = new InvoiceBean();
            ClientBean CRBean = new ClientBean();
            SlotBean SRBean = new SlotBean();
            PrescriptionBean PRBean = new PrescriptionBean();
        
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"topnav\">\n");
      out.write("            <a class=\"title left\">SmartCare Web Page</a>\n");
      out.write("            <div class=\"right\">\n");
      out.write("                <a class=\"right\" href = \"http://localhost:8080/SmartCareWeb/home.jsp\">Home</a>\n");
      out.write("                <a class=\"right\" href = \"http://localhost:8080/SmartCareWeb/logout\">Logout</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"text-align: center\">\n");
      out.write("            <h1>Welcome to SmartCare Invoice Centre</h1>\n");
      out.write("            <h2>Below you will find your generated invoice</h2>\n");
      out.write("            <br><br>\n");
      out.write("        </div>\n");
      out.write("    <center>\n");
      out.write("        <div style= \"background-color:beige;width:1000px;height:400px;border:25px solid #F5F5DC;\">\n");
      out.write("            <h3>Smart Care Invoice</h3> \n");
      out.write("            <h4>Invoice Number:  ");
      out.print(IRBean.getIID());
      out.write("</h4>        \n");
      out.write("            <h4>Patient Name:    ");
      out.print(CRBean.getCname());
      out.write("</h4>     \n");
      out.write("            <h4>Patient Address: ");
      out.print(CRBean.getCaddress());
      out.write("</h4> \n");
      out.write("            <h4>Physician:       ");
      out.print(ERBean.getEname());
      out.write("</h4>     \n");
      out.write("            <br>\n");
      out.write("            <table style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Date</th> \n");
      out.write("                    <th>Services Performed</th>\n");
      out.write("                    <th>Medication Prescribed</th>\n");
      out.write("                    <th>Amount Due</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th><a style=\"background-color:beige; width: 150px;\" type=\"text\" id=\"iid\" name=\"iid\" />");
      out.print(SRBean.getSdate());
      out.write("</a></th> \n");
      out.write("                    <th><a style=\"background-color:beige; width: 150px;\" type=\"text\" id=\"iid\" name=\"iid\" />");
      out.print(SRBean.getSreason());
      out.write("</a></th> \n");
      out.write("                    <th><a style=\"background-color:beige; width: 150px;\" type=\"text\" id=\"iid\" name=\"iid\" />");
      out.print(PRBean.getMedicine());
      out.write("</a></th> \n");
      out.write("                    <th><a style=\"background-color:beige; width: 150px;\" type=\"text\" id=\"iid\" name=\"iid\" />Not added yet</a></th> \n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <h5> Total: <input style =\" border: #F5F5DC; margin-right: -87px; width: 75px;\" type=\"number\" id=\"total\" name=\"total\" /> </h5>\n");
      out.write("\n");
      out.write("        </div>    \n");
      out.write("    </center>                \n");
      out.write("</body> \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
