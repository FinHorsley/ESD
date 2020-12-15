package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\n");
      out.write("        <title>My Geocode App</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2 id=\"text-center\">Enter Location: </h2>\n");
      out.write("            <form id=\"location-form\">\n");
      out.write("                <input type=\"text\" id=\"location-input\" class=\"form-control form-control-lg\">\n");
      out.write("                <br>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary btn-block\">Submit</button>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"card-block\" id=\"formatted-address\"></div>\n");
      out.write("            <div class=\"card-block\" id=\"address-components\"></div>\n");
      out.write("            <div class=\"card-block\" id=\"geometry\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Call Geocode\n");
      out.write("            //geocode();\n");
      out.write("\n");
      out.write("            // Get location form\n");
      out.write("            var locationForm = document.getElementById('location-form');\n");
      out.write("\n");
      out.write("            // Listen for submiot\n");
      out.write("            locationForm.addEventListener('submit', geocode);\n");
      out.write("\n");
      out.write("            function geocode(e) {\n");
      out.write("                // Prevent actual submit\n");
      out.write("                e.preventDefault();\n");
      out.write("\n");
      out.write("                var location = document.getElementById('location-input').value;\n");
      out.write("\n");
      out.write("                axios.get('https://maps.googleapis.com/maps/api/geocode/json', {\n");
      out.write("                    params: {\n");
      out.write("                        address: location,\n");
      out.write("                        key: 'AIzaSyCctNwObZsRap7-QF3A7Kiiya6qSweD1vk'\n");
      out.write("                    }\n");
      out.write("                })\n");
      out.write("                        .then(function (response) {\n");
      out.write("                            // Log full response\n");
      out.write("                            console.log(response);\n");
      out.write("\n");
      out.write("                            // Formatted Address\n");
      out.write("                            var formattedAddress = response.data.results[0].formatted_address;\n");
      out.write("                            var formattedAddressOutput = `\n");
      out.write("                <ul class=\"list-group\">\n");
      out.write("                  <li class=\"list-group-item\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${formattedAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                </ul>\n");
      out.write("              `;\n");
      out.write("\n");
      out.write("                            // Address Components\n");
      out.write("                            var addressComponents = response.data.results[0].address_components;\n");
      out.write("                            var addressComponentsOutput = '<ul class=\"list-group\">';\n");
      out.write("                            for (var i = 0; i < addressComponents.length; i++) {\n");
      out.write("                                addressComponentsOutput += `\n");
      out.write("                  <li class=\"list-group-item\"><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${addressComponents[i].types[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${addressComponents[i].long_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                `;\n");
      out.write("                            }\n");
      out.write("                            addressComponentsOutput += '</ul>';\n");
      out.write("\n");
      out.write("                            // Geometry\n");
      out.write("                            var lat = response.data.results[0].geometry.location.lat;\n");
      out.write("                            var lng = response.data.results[0].geometry.location.lng;\n");
      out.write("                            var geometryOutput = `\n");
      out.write("                <ul class=\"list-group\">\n");
      out.write("                  <li class=\"list-group-item\"><strong>Latitude</strong>: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                  <li class=\"list-group-item\"><strong>Longitude</strong>: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lng}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                </ul>\n");
      out.write("              `;\n");
      out.write("\n");
      out.write("                            // Output to app\n");
      out.write("                            document.getElementById('formatted-address').innerHTML = formattedAddressOutput;\n");
      out.write("                            document.getElementById('address-components').innerHTML = addressComponentsOutput;\n");
      out.write("                            document.getElementById('geometry').innerHTML = geometryOutput;\n");
      out.write("                        })\n");
      out.write("                        .catch(function (error) {\n");
      out.write("                            console.log(error);\n");
      out.write("                        });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
