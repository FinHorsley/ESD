package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.SQLException;
import DOA.DBConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Connection;
import beans.UserBean;

public final class view_invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        </style>\n");
      out.write("                \n");
      out.write("        ");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function initAutocomplete() {\n");
      out.write("                var map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("                    center: {\n");
      out.write("                        lat: 48,\n");
      out.write("                        lng: 4\n");
      out.write("                    },\n");
      out.write("                    zoom: 4,\n");
      out.write("                    disableDefaultUI: true\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                // Create the search box and link it to the UI element.\n");
      out.write("                var input = document.getElementById('my-input-searchbox');\n");
      out.write("                var autocomplete = new google.maps.places.Autocomplete(input);\n");
      out.write("                map.controls[google.maps.ControlPosition.TOP_CENTER].push(input);\n");
      out.write("                var marker = new google.maps.Marker({\n");
      out.write("                    map: map\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                // Bias the SearchBox results towards current map's viewport.\n");
      out.write("                autocomplete.bindTo('bounds', map);\n");
      out.write("                // Set the data fields to return when the user selects a place.\n");
      out.write("                autocomplete.setFields(\n");
      out.write("                        ['address_components', 'geometry', 'name']);\n");
      out.write("\n");
      out.write("                // Listen for the event fired when the user selects a prediction and retrieve\n");
      out.write("                // more details for that place.\n");
      out.write("                autocomplete.addListener('place_changed', function () {\n");
      out.write("                    var place = autocomplete.getPlace();\n");
      out.write("                    if (!place.geometry) {\n");
      out.write("                        console.log(\"Returned place contains no geometry\");\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                    var bounds = new google.maps.LatLngBounds();\n");
      out.write("                    marker.setPosition(place.geometry.location);\n");
      out.write("\n");
      out.write("                    if (place.geometry.viewport) {\n");
      out.write("                        // Only geocodes have viewport.\n");
      out.write("                        bounds.union(place.geometry.viewport);\n");
      out.write("                    } else {\n");
      out.write("                        bounds.extend(place.geometry.location);\n");
      out.write("                    }\n");
      out.write("                    map.fitBounds(bounds);\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            document.addEventListener(\"DOMContentLoaded\", function (event) {\n");
      out.write("                initAutocomplete();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Admin CPanel - SmartCare</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

                        
                        if (UserBean.role.equals("NoUser")) { //checks users role and depending on role redirects to their client area

                        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp"); //gives the request the peramiter of the page
                        RequetsDispatcherObj.forward(request, response);
                        
                        }
                        else if (!UserBean.role.equals("client")){
                            
                            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/home.jsp"); //gives the request the peramiter of the page
                            RequetsDispatcherObj.forward(request, response);
                        
                        }
                    
                    
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
      out.write("            <h2>Please select which invoice you would like to view</h2>\n");
      out.write("            <br><br>\n");
      out.write("        </div>\n");
      out.write("    <center>\n");
      out.write("        <div style= \"background-color:beige;width:500px;height:75px;border:25px solid #F5F5DC;\"><u><b>Invoice Selection</b></u>\n");
      out.write("            <form name=\"form\" method=\"post\">\n");
      out.write("                <table align=\"center\">\n");
      out.write("                    <tr></tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Selected Invoice: </td>  \n");
      out.write("                        <td><input id=\"my-input-searchbox\" type=\"text\" placeholder=\"Select an invoice\" name =\"iid\">\n");
      out.write("                            <div id=\"map\"></div>\n");
      out.write("                            <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBtaj_5ZLCTnn5iGxYZMh7zogDTwxlTN6Y&libraries=places&callback=initMap\"></script>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><a href = \"http://localhost:8080/SmartCareWeb/generate.invoice.jsp\">View</a>\n");
      out.write("                            \n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>    \n");
      out.write("    </center>                \n");
      out.write("</body> \n");
      out.write("</html>\n");
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
