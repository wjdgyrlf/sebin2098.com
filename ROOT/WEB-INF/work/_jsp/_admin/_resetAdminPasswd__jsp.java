/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import common.*;
import dbconn.*;

public class _resetAdminPasswd__jsp extends com.caucho.jsp.JavaPage
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

String _adminid = "";
String _adminname = "";
String _admintype = "";
String _admingroup = "";
String _brand = "";
String _adminclass = "";

try{

  _adminid = (String) session.getAttribute("adminid");

  if( _adminid == null || _adminid.length() == 0 || _adminid.equals("null") ) {
    response.sendRedirect("/admin/login_first.html");
    return;
  }

  _adminname = (String) session.getAttribute("adminname");
  _admintype = (String) session.getAttribute("admintype");
  _admingroup = (String) session.getAttribute("admingroup");
  _brand = (String) session.getAttribute("brand");
  _adminclass = (String) session.getAttribute("adminclass");
  //session.setMaxInactiveInterval(60*60);

}catch( Exception e ) {
  response.sendRedirect("/admin/login_first.html");
  return;
}

      out.write('\n');
      
String password = request.getParameter("password");
String fromURL = request.getParameter("fromURL");
String oldPassword = "";

String sql = "";
int iCnt = 0;
boolean isSucceeded = false;
String strMsg = "";
DBConnManager dbPool = null;
Connection conn = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
PreparedStatement pstmt = null;

String targetUrl = "";

try {

  if (password.equals("1111")) {
    throw new UserDefinedException("The new password is not acceptable. Change your password.");
  }

  dbPool = DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");
  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();

  sql = " select  password "
      + " from    admin_01t "
      + " where   adminid = '" + _adminid + "' ";

  iCnt = dataProcess.RetrieveData(sql, matrix, conn);

  if (iCnt > 0) {
    oldPassword = matrix.getRowData(0).getData(0);
  } else {
    throw new UserDefinedException("Can't find User Information.");
  }

  if (password.equals(oldPassword)) {
    throw new UserDefinedException("The new password is not acceptable. Change your password.");
  }

  // update \u00c3\u00b3\u00b8\u00ae...
  int idx = 0;
  conn.setAutoCommit(false);

  sql = " update  admin_01t "
      + " set     password = ?, pw_date = sysdate "
      + " where   adminid = ? ";

  pstmt = conn.prepareStatement(sql);
  pstmt.setString(++idx, password);
  pstmt.setString(++idx, _adminid);

  iCnt = pstmt.executeUpdate();

  if (iCnt != 1) {
    throw new UserDefinedException("Password update failed.");
  }

  conn.commit();
  isSucceeded = true;

} catch (UserDefinedException ue) {
  try { conn.rollback(); } catch (Exception ex) {}

  strMsg = ue.getMessage();
} catch (Exception e) {
  try { conn.rollback(); } catch (Exception ex) {}

  System.out.println("Exception /admin/resetAdminPasswd : " + e.getMessage());
  throw e;
} finally {
  if (pstmt != null) {
    try { pstmt.close(); } catch (Exception e) {}
  }

  if (conn != null) {
    try { conn.setAutoCommit(true); } catch (Exception e) {}
    dbPool.freeConnection("intranet", conn);
  }
}

// \u00b0\u00e1\u00b0\u00fa \u00b8\u00de\u00bd\u00c3\u00c1\u00f6 \u00c3\u00b3\u00b8\u00ae
if (isSucceeded) {
  // where to go?
  if (fromURL.equals("menu")) {
    targetUrl = "";
  } else {
    targetUrl = "/admin/index2.jsp";
  }
  strMsg = "The data are successfully processed.";
} else {
  strMsg = "The operation failed.\\n" + strMsg;
  targetUrl = "/admin/resetAdminPasswdForm.jsp";
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print(( targetUrl ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( fromURL ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
       if (targetUrl.length() > 0) { 
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( strMsg ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
       } 
      out.write(_jsp_string6, 0, _jsp_string6.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/resetAdminPasswd.jsp"), 945487319384844566L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string2;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string5;
  private final static char []_jsp_string6;
  private final static char []_jsp_string1;
  private final static char []_jsp_string3;
  static {
    _jsp_string2 = "\">\n<input type='hidden' name='fromURL' value='".toCharArray();
    _jsp_string0 = "\n\n\n\n".toCharArray();
    _jsp_string4 = "\n  alert('".toCharArray();
    _jsp_string5 = "');\n  document.form1.submit();\n".toCharArray();
    _jsp_string6 = "\n</script>\n<table width='840' border='0' cellspacing='0' cellpadding='0'><tr><td>\n\n<table width='99%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td height='15' colspan='2'></td>\n</tr>\n<tr>\n  <td width='3%'><img src='/img/title_icon.gif'></td>\n  <td width='*' class='left_title'>Password Change</td>\n</tr>\n<tr>\n  <td width='100%' height='2' colspan='2'><hr width='100%'></td>\n</tr>\n<tr>\n  <td height='10' colspan='2'></td>\n</tr>\n</table>\n\n<table width='90%' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%' align='center'><img border=\"0\" src=\"/img/login.jpg\">\n    <br><br>\n    <b>Password change completed.</b></td>\n</tr>\n</table>\n\n</tr></td></table>\n</body>\n</html>".toCharArray();
    _jsp_string1 = "\n<html>\n<head>\n<title></title>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n</head>\n<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>\n<form name=\"form1\" method=\"post\" action=\"".toCharArray();
    _jsp_string3 = "'>\n</form>\n<script language=\"javascript\">\n".toCharArray();
  }
}
