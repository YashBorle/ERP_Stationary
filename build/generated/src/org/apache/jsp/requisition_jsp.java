package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class requisition_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("     <style>\n");
      out.write("         body{\n");
      out.write("             padding: 10px;\n");
      out.write("         }\n");
      out.write("         \n");
      out.write("         #addbtn{\n");
      out.write("             margin-bottom: 5px;\n");
      out.write("         }\n");
      out.write("     \n");
      out.write("     </style>\n");
      out.write("     \n");
      out.write("     <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("  \n");
      out.write(" </head>\n");
      out.write("\n");
      out.write(" \n");
      out.write("     <h4 class=\"jumbotron\">Requisition Page</h4>\n");
      out.write("    <h6>Requirements:</h6>\n");
      out.write("\t<table>\n");
      out.write("    <tr><th><label for='drop'>Select the item</label></th>\n");
      out.write("    <th><select id=\"drop\">\n");
      out.write("    <option value=\"pen\">Pen</option><br />\n");
      out.write("    <option value=\"pencil\">Pencil</option><br />\n");
      out.write("    <option value=\"eraser\">Eraser</option><br />\n");
      out.write("    <option value=\"bmarker\">Board Markers</option><br />\n");
      out.write("    <option value=\"highlighter\">Highlighters</option><br />\n");
      out.write("    <option value=\"shrpener\">Sharpener</option><br />\n");
      out.write("    <option value=\"stapler\">Stapler</option></th> </tr>\n");
      out.write("\n");
      out.write("    <tr><th><label for=\"quantity\">Quantity</label></th>\n");
      out.write("        <th><input type=\"number\" id=\"quantity\" placeholder=\"Quantity Required\"></th>\n");
      out.write("   \n");
      out.write("<tr><th><button type=\"button\" id=\"addbtn\" class=\"btn btn-success\" onClick=\"add()\" >Add</button></th></tr>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("        <form method=\"get\">\n");
      out.write("                <table class=\"table table-primary\">\n");
      out.write("                    <tr class=\"bg-info\">\n");
      out.write("                        <th>Serial No.</th>\n");
      out.write("                        <th>Item</th>\n");
      out.write("                        <th>Quantity</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tbody id=\"myTable\"></tbody>\n");
      out.write("                </table>\n");
      out.write("                \n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary\" id=\"submit\" value=\"Submit\"/>\n");
      out.write("                <div>Items:  <p id=\"itemQuan\" name=\"itemQuan\"></p></div>\n");
      out.write("        </form>\n");
      out.write("      <div id=\"message\"></div>\n");
      out.write("\n");
      out.write("      \n");
      out.write("<!--      \n");
      out.write("                   <script type=\"text/javascript\">\n");
      out.write("                    $(document).ready(function(){\n");
      out.write("                     $(\"#message\").html(\"Hello World\");\n");
      out.write("                    });\n");
      out.write("-->                    </script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("     var items2 = document.getElementsByName(\"item\");\n");
      out.write("     var itemarr = jQuery.makeArray(items2.value);\n");
      out.write("\n");
      out.write("    $(document).ready(function(){\n");
      out.write("     $(\"#submit\").click(function(){\n");
      out.write("         var t = $('input[name=\"item\"]').val();\n");
      out.write("         $(\"#message\").html(t);\n");
      out.write("     });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    \n");
      out.write("    var i=0;\n");
      out.write("    var n = i+1;\n");
      out.write("    var item=[n];\n");
      out.write("    var quant=[n];\n");
      out.write("    \n");
      out.write("    function add(){\n");
      out.write("        var added = document.getElementById(\"itemQuan\");\n");
      out.write("        var table = document.getElementById(\"myTable\");\n");
      out.write("        var quanity = document.getElementById(\"quantity\");\n");
      out.write("        var drop = document.getElementById(\"drop\");\n");
      out.write("        ival=drop.value;\n");
      out.write("        qval=quanity.value;\n");
      out.write("        \n");
      out.write("        var row=getDynamicTable(i,ival,qval);\n");
      out.write("        \n");
      out.write("        itemQuan.innerHTML=i+1;\n");
      out.write("        table.innerHTML += row;\n");
      out.write("        i++;\n");
      out.write("        \n");
      out.write("        quanity.value=0;\n");
      out.write("        drop.selectedIndex++;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function getDynamicTable(i,ival,qval){\n");
      out.write("        return `\n");
      out.write("                    <tr>\n");
      out.write("                    <td>`+(i+1)+`</td>\n");
      out.write("                    <div><input type=\"text\" name=\"item\" value=`+ival+`></div>&nbsp\n");
      out.write("                    <div><input type=\"text\" name=\"quantity\" value=`+qval+`></div>\n");
      out.write("                    </tr>\n");
      out.write("                    `\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    </script>\n");
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
