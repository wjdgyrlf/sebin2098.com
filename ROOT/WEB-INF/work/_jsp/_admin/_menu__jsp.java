/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import dbconn.*;

public class _menu__jsp extends com.caucho.jsp.JavaPage
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
      
String menus = "";

int iRet = 0;
dbconn.DBConnManager dbPool = null;
Connection conn = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
String sql = "";

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");

  // Read Menu List
  sql = " SELECT  M.PARENT_NO, M.MENUNAME, M.MENUURL, NVL(MC.CHILD_CNT, 0) "
      + " FROM    ( "
      + "           SELECT SEQNO, PARENT_NO, MENUNAME, MENUURL, SORT_NO "
      + "           FROM   MENU_T "
      + "           WHERE  MENU_TYPE = '" + _admintype + "' "
      + "           AND    USER_GROUP = '" + _admingroup + "' "
      + "           ORDER BY SORT_NO "
      + "         ) M, "
      + "         ( "
      + "           SELECT M1.SEQNO, COUNT(M2.SEQNO) CHILD_CNT "
      + "           FROM   MENU_T M1, MENU_T M2 "
      + "           WHERE  M1.MENU_TYPE = '" + _admintype + "' "
      + "           AND    M1.USER_GROUP = '" + _admingroup + "' "
      + "           AND    M1.PARENT_NO = 1 "
      + "           AND    M1.SEQNO = M2.PARENT_NO(+) "
      + "           GROUP BY M1.SEQNO "
      + "         ) MC "
      + " WHERE   M.SEQNO = MC.SEQNO(+) "
      + " ORDER BY M.SORT_NO ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  for (int i = 0; i < iRet; i++) {
    int j = 0;

    String parentNo   = matrix.getRowData(i).getData(j++);
    String menuName   = matrix.getRowData(i).getData(j++);
    String menuUrl    = matrix.getRowData(i).getData(j++);
    int childCnt      = Integer.parseInt(matrix.getRowData(i).getData(j++));

    if (parentNo.equals("1")) {

      // Parent Menu\u00ec\u009d\u00b8 \u00ea\u00b2\u00bd\u00ec\u009a\u00b0
      if (childCnt > 0) {
        menus += "aux1 = insFolder(rootTree, genFolder(\"" + menuName + "\", \"" + menuUrl + "\"));\n";
      } else {
        menus += "insItem(rootTree, genItemIcon(\"tree_page.gif\", \"" + menuName + "\", \"" + menuUrl + "\"));\n";
      }

    } else {

      // Child Menu
      menus += "insItem(aux1, genItemIcon(\"tree_page.gif\", \"" + menuName + "\", \"" + menuUrl + "\"));\n";

    }

  }
  /////////////////////////////////////////////////////////////////////////

} catch (Exception e) {
  System.out.println("Exception menu : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) { dbPool.freeConnection("intranet", conn); }
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print(( _admingroup.equals("Z") ? "'/order/admin_po_status.jsp'" : "'/notice/admin_list.jsp?table_name=notice'" ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( menus ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/menu.jsp"), 2956285324351759462L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  static {
    _jsp_string3 = "\ninitializeDocument(rootTree);\n</script>\n<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\">\n<tr>\n  <td align=\"center\" height=\"10\"></td>\n</tr>\n<tr>\n  <td align=\"center\"><a href=\"http://www.fastfuturebrands.com.au\" target=\"_blank\"><!--img src=\"/img/getacro.gif\"--><img src=\"/img/ffb_newlogo.jpg\"></a></td>\n</tr>\n<tr>\n  <td align=\"center\" class=\"font_small\"><font color=\"#0770FF\" siz=2>www.fastfuturebrands.com.au</font></td>\n</tr>\n \n<tr>\n  <td align=\"center\"><a href=\"http://get.adobe.com/reader/\" target=\"_blank\"><img src=\"/img/adobe_reader.png\"></a></td>\n\n</tr>\n<tr>\n  <td align=\"center\" class=\"font_small\"><font color=\"#0770FF\" siz=2>Get Adobe Reader</font></td>\n\n</tr>\n\n</table>\n</body>\n</html>".toCharArray();
    _jsp_string0 = "\n\n\n".toCharArray();
    _jsp_string2 = ");\n".toCharArray();
    _jsp_string1 = "\n<html>\n<head>\n<title></title>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">	\n<style type=\"text/css\">\na:link {text-decoration: none ; color: #020468;}\na:visited {text-decoration: none ; color: #666666;}\na:active {text-decoration: underline ; color: #0770FF;}\na:hover {text-decoration: underline ; color: #0770FF;}\n</style>\n<script language=javascript src=\"/common/js/tree_win.js\"></script>\n<script language=\"javascript\">\nfunction LoadLeave()\n{\n    clearTimeout(Time_ID);\n    location.href = \"./menu.jsp\";\n}\nfunction delay()\n{\n    Time_ID = setTimeout(\"LoadLeave()\",( 10 * 60 * 1000 ));\n}\n</script>\n</head>\n\n<body leftmargin=\"2\" topmargin=\"10\" marginwidth=\"0\" marginheight=\"0\" bgcolor=\"#F7F7F7\" onload=\"delay()\">\n<script language=javascript>\nrootTree = genFolderRoot(\"<img src='/img/tree_base.gif' border='0'> <b>HOME</b>\", ".toCharArray();
  }
}
