/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-03-14 13:50:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin.board.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>?????? ???????????? ????????? ?????? ????????? ?????? ?????????</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>??????????????????</title>\n");
      out.write("\n");
      out.write("    <link href=\"/css/customer/layout.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("    <style>\n");
      out.write("        #visual .content-container {\n");
      out.write("            height: inherit;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("\n");
      out.write("            background: url(\"/images/mypage/visual.png\") no-repeat center;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- header ?????? -->\n");
      out.write("\n");
      out.write("    <header id=\"header\">\n");
      out.write("\n");
      out.write("        <div class=\"content-container\">\n");
      out.write("            <!-- ---------------------------<header>--------------------------------------- -->\n");
      out.write("\n");
      out.write("            <h1 id=\"logo\">\n");
      out.write("                <a href=\"/index.html\">\n");
      out.write("                    <img src=\"/images/logo.png\" alt=\"????????? ?????????\" />\n");
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </h1>\n");
      out.write("\n");
      out.write("            <section>\n");
      out.write("                <h1 class=\"hidden\">??????</h1>\n");
      out.write("\n");
      out.write("                <nav id=\"main-menu\">\n");
      out.write("                    <h1>????????????</h1>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/guide\">???????????????</a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"/course\">????????????</a></li>\n");
      out.write("                        <li><a href=\"/answeris/index\">AnswerIs</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <div class=\"sub-menu\">\n");
      out.write("\n");
      out.write("                    <section id=\"search-form\">\n");
      out.write("                        <h1>???????????? ???</h1>\n");
      out.write("                        <form action=\"/course\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <legend>??????????????????</legend>\n");
      out.write("                                <label>????????????</label>\n");
      out.write("                                <input type=\"text\" name=\"q\" value=\"\" />\n");
      out.write("                                <input type=\"submit\" value=\"??????\" />\n");
      out.write("                            </fieldset>\n");
      out.write("                        </form>\n");
      out.write("                    </section>\n");
      out.write("\n");
      out.write("                    <nav id=\"acount-menu\">\n");
      out.write("                        <h1 class=\"hidden\">????????????</h1>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"/index.html\">HOME</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <form action=\"/logout\" method=\"post\">\n");
      out.write("                                    <input type=\"hidden\" name=\"\" value=\"\" />\n");
      out.write("                                    <input type=\"submit\" value=\"????????????\"\n");
      out.write("                                        style=\"border:none;background: none;vertical-align: middle;font-size: 10px;color:#979797;font-weight: bold;\" />\n");
      out.write("\n");
      out.write("                                </form>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                            <li><a href=\"/member/agree\">????????????</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <nav id=\"member-menu\" class=\"linear-layout\">\n");
      out.write("                        <h1 class=\"hidden\">????????????</h1>\n");
      out.write("                        <ul class=\"linear-layout\">\n");
      out.write("                            <li><a href=\"/member/home\"><img src=\"/images/txt-mypage.png\" alt=\"???????????????\" /></a></li>\n");
      out.write("                            <li><a href=\"/notice/list.html\"><img src=\"/images/txt-customer.png\" alt=\"????????????\" /></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <!-- --------------------------- <visual> --------------------------------------- -->\n");
      out.write("    <!-- visual ?????? -->\n");
      out.write("\n");
      out.write("    <div id=\"visual\">\n");
      out.write("        <div class=\"content-container\"></div>\n");
      out.write("    </div>\n");
      out.write("    <!-- --------------------------- <body> --------------------------------------- -->\n");
      out.write("    <div id=\"body\">\n");
      out.write("        <div class=\"content-container clearfix\">\n");
      out.write("\n");
      out.write("            <!-- --------------------------- aside --------------------------------------- -->\n");
      out.write("            <!-- aside ?????? -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <aside class=\"aside\">\n");
      out.write("                <h1>ADMIN PAGE</h1>\n");
      out.write("\n");
      out.write("                <nav class=\"menu text-menu first margin-top\">\n");
      out.write("                    <h1>???????????????</h1>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/admin/index.html\">????????????</a></li>\n");
      out.write("                        <li><a href=\"/teacher/index.html\">??????????????????</a></li>\n");
      out.write("                        <li><a href=\"/student/index.html\">??????????????????</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <nav class=\"menu text-menu\">\n");
      out.write("                    <h1>????????????</h1>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/admin/board/notice/list.html\">????????????</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("            </aside>\n");
      out.write("            <!-- --------------------------- main --------------------------------------- -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <main>\n");
      out.write("                <h2 class=\"main title\">???????????? ??????</h2>\n");
      out.write("\n");
      out.write("                <div class=\"breadcrumb\">\n");
      out.write("                    <h3 class=\"hidden\">breadlet</h3>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>home</li>\n");
      out.write("                        <li>????????? ??????</li>\n");
      out.write("                        <li>????????????</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <form method=\"post\" action=\"reg\">\n");
      out.write("                    <div class=\"margin-top first\">\n");
      out.write("                        <h3 class=\"hidden\">???????????? ??????</h3>\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>??????</th>\n");
      out.write("                                    <td class=\"text-align-left text-indent text-strong text-orange\" colspan=\"3\">\n");
      out.write("                                        <input type=\"text\" name=\"title\" />\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>????????????</th>\n");
      out.write("                                    <td colspan=\"3\" class=\"text-align-left text-indent\"><input type=\"file\"\n");
      out.write("                                            name=\"file\" /> </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr class=\"content\">\n");
      out.write("                                    <td colspan=\"4\"><textarea class=\"content\" name=\"content\"></textarea></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"4\" class=\"text-align-right\"><input class=\"vertical-align\" type=\"checkbox\" id=\"open\" name=\"open\" value=\"true\"><label for=\"open\" class=\"margin-left\">????????????</label> </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"margin-top text-align-center\">\n");
      out.write("                        <input class=\"btn-text btn-default\" type=\"submit\" value=\"??????\" />\n");
      out.write("                        <a class=\"btn-text btn-cancel\" href=\"list.html\">??????</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- ------------------- <footer> --------------------------------------- -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <footer id=\"footer\">\n");
      out.write("        <div class=\"content-container\">\n");
      out.write("            <h2 id=\"footer-logo\"><img src=\"/images/logo-footer.png\" alt=\"????????????\"></h2>\n");
      out.write("\n");
      out.write("            <div id=\"company-info\">\n");
      out.write("                <dl>\n");
      out.write("                    <dt>??????:</dt>\n");
      out.write("                    <dd>??????????????? </dd>\n");
      out.write("                    <dt>???????????????:</dt>\n");
      out.write("                    <dd>admin@newlecture.com</dd>\n");
      out.write("                </dl>\n");
      out.write("                <dl>\n");
      out.write("                    <dt>????????? ????????????:</dt>\n");
      out.write("                    <dd>111-11-11111</dd>\n");
      out.write("                    <dt>?????? ?????????:</dt>\n");
      out.write("                    <dd>????????? 1111 ???</dd>\n");
      out.write("                </dl>\n");
      out.write("                <dl>\n");
      out.write("                    <dt>??????:</dt>\n");
      out.write("                    <dd>?????????</dd>\n");
      out.write("                    <dt>??????:</dt>\n");
      out.write("                    <dd>?????????</dd>\n");
      out.write("                    <dt>????????????:</dt>\n");
      out.write("                    <dd>111-1111-1111</dd>\n");
      out.write("                </dl>\n");
      out.write("                <div id=\"copyright\" class=\"margin-top\">Copyright ??? newlecture.com 2012-2014 All Right Reserved.\n");
      out.write("                    Contact admin@newlecture.com for more information</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
