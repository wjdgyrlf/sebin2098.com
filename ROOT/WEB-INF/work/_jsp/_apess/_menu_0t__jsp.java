/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._apess;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import dbconn.*;

public class _menu_0t__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, "/error.jsp", session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1

String _apessid = "";
String _apessname = "";
String usertype = "";
String usergroup = "";
String scmid = "";
String scmnm = "";
//String scmsubids = "";
String _adminid = "";
String _adminname = "";

try {
  _apessid = (String) session.getAttribute("apessid");
  _adminid = (String) session.getAttribute("adminid");

  if( (_apessid == null || _apessid.length() == 0 || _apessid.equals("null"))
      && (_adminid == null || _adminid.length() == 0 || _adminid.equals("null")) ) {
    response.sendRedirect("/apess/login_first.html");
    return;
  }

  _apessname = (String) session.getAttribute("apessname");
  _adminname = (String) session.getAttribute("adminname");

  usertype = (String) session.getAttribute("usertype");
  if (usertype == null) usertype = "";

  usergroup = (String) session.getAttribute("usergroup");
  if (usergroup == null) usergroup = "";

  scmid = (String) session.getAttribute("scmid");
  scmnm = (String) session.getAttribute("scmnm");
  //scmsubids = (String) session.getAttribute("scmsubids");

} catch( Exception e ) {
  response.sendRedirect("/apess/login_first.html");
  return;
}

      out.write('\n');
      
int iRet = 0;
dbconn.DBConnManager dbPool = null;
Connection conn = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
String sql = "";

String locationName = "";

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");

  // Read location name
  sql = " select  code_name "
      + " from    vg_common_code "
      + " where   code = '" + usertype + "' "
      + " and     type = 'USER_TYPE' ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  if (iRet > 0) {
    locationName = matrix.getRowData(0).getData(0);
  }

} catch (Exception e) {
  System.out.println("Exception menu_t : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) { dbPool.freeConnection("intranet", conn); }
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print(( locationName ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( _apessname ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( _apessid ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 5783496155892875126L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/menu_t.jsp"), 3939981483898047506L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/login_check.jsp"), 3743346625025852725L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  static {
    _jsp_string1 = "\n<html>\n<head>\n<title></title>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n</head>\n\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n  <tr>\n    <td valign=\"top\" width=\"100%\" background=\"/img/bgimg2.gif\">\n	  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n        <tr>\n          <td width=\"452\" ><font size=4 face=\"Century Gothic\" color=\"Yellow\"> &nbsp;&nbsp;&nbsp;&nbsp;\n            <a href='./index2.jsp' style=\"text-decoration:none;color=yellow\" target=\"_top\">Supply Chain Management for APESS</a> </font><br>\n          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color=\"white\" face=\"Century Gothic\" size=2> &copy;Copyright 2008 FAST FUTURE BRANDS PTY LTD</font></td>\n          <td valign=\"top\">\n		    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n              <tr>\n                <td height=\"17\" align=\"right\" class=\"help_top_menu\"><a href=\"http://www.valleygirl.com.au/\" target=\"_new\"><img src=\"/img/home.gif\"><font size=2 face=\"Century Gothic\" color=\"White\">Valleygirl</font></a>\n                  | <a href=\"http://www.temt.com.au/\" target=\"_new\"><img src=\"/img/home.gif\"><font size=2 face=\"Century Gothic\" color=\"White\">TEMT</font></a>\n                  l <a href=\"./logout.jsp\" target=\"_top\"><img src=\"/img/logout.gif\"><font size=2 face=\"Century Gothic\" color=\"White\">Logout</font></a></td>\n                <td width=\"10\"></td>\n              </tr>\n              <tr>\n                <td height=\"30\" align=\"right\"></td>\n                <td width=\"10\"></td>\n              </tr>\n              <tr>\n                <td height=\"17\" align=\"right\" valign=\"bottom\" class=\"help_top_menu\"><font size=2 face=\"Century Gothic\" color=\"White\">".toCharArray();
    _jsp_string0 = "\n\n\n".toCharArray();
    _jsp_string3 = "</font></td>\n                <td width=\"10\"></td>\n              </tr>\n            </table></td>\n        </tr>\n      </table>\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n        <tr>\n          <td height=\"13\" background=\"/img/top_menu_back_01.gif\"></td>\n        </tr>\n      </table></td>\n  </tr>\n</table>\n</body>\n</html>\n".toCharArray();
    _jsp_string2 = " | ".toCharArray();
  }
}
