package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calender_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<!-- meta block -->\n");
      out.write("\t\t<title>Basic initialization - DHTMLX Calendar</title>\n");
      out.write("\t\t<meta name=\"description\" content=\"Check interactive samples of DHTMLX Calendar to explore its initialization and other details.\">\n");
      out.write("\t\t<!-- end meta block -->\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" charset=\"utf-8\">\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../../codebase/calendar.js?v=7.0.0\"></script>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../../codebase/calendar.css?v=7.0.0\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../common/index.css?v=7.0.0\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../common/calendar.css?v=7.0.0\">\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- custom sample head -->\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<header class=\"dhx_sample-header\">\n");
      out.write("\t\t\t<div class=\"dhx_sample-header__main\">\n");
      out.write("\t\t\t\t<nav class=\"dhx_sample-header__breadcrumbs\">\n");
      out.write("\t\t\t\t\t<ul class=\"dhx_sample-header-breadcrumbs\">\n");
      out.write("\t\t\t\t\t\t<li class=\"dhx_sample-header-breadcrumbs__item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"../index.html\" class=\"dhx_sample-header-breadcrumbs__link\">Calendar samples</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"dhx_sample-header-breadcrumbs__item\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"./index.html\" class=\"dhx_sample-header-breadcrumbs__link\">Initialization</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"dhx_sample-header-breadcrumbs__item\">\n");
      out.write("\t\t\t\t\t\t\t<span class=\"dhx_sample-header-breadcrumbs__link\">Basic initialization</span>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<h1 class=\"dhx_sample-header__title\">\n");
      out.write("\t\t\t\t\t<div class=\"dhx_sample-header__content\">\n");
      out.write("\t\t\t\t\t\tBasic initialization.\n");
      out.write("\t\t\t\t\t\t<div class=\"dhx_sample-docs-links\">\n");
      out.write("\t\t\t\t\t\t\tCheck documentation:\n");
      out.write("\t\t\t\t\t\t\t<a href=\"https://docs.dhtmlx.com/suite/calendar__how_to_start.html\" target=\"_blank\" class=\"dhx_sample-header-link\">Initialization</a>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("</header>\n");
      out.write("\t\t<section class=\"dhx_sample-container\">\n");
      out.write("\t\t\t<div class=\"dhx_sample-container__widget\" id=\"calendar\"></div>\n");
      out.write("\t\t</section>\n");
      out.write("\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\tvar calendar = new dhx.Calendar(\"calendar\", {css: \"dhx_widget--bordered\"});\n");
      out.write("\t\t</script>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
