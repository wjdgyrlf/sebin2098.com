/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._account;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import dbconn.*;

public class _supplier_0excel__jsp extends com.caucho.jsp.JavaPage
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

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
response.setHeader("Content-Disposition", "attachment; filename=Supplier.xls;");
response.setHeader("Content-Description", "JSP Generated Data");

int iRet = 0;
Connection connScm = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String outS = "";
String sql = "";

String ag_supplier = request.getParameter("ag_supplier");
String id      = "";
String ag_id   = "";
String ag_id2   = request.getParameter("ag_id2");
String ag_pwd  = "";
String pw      = "";
String name    = "";
String email   = "";
String phone1  = "";
String phone2  = "";
String fax     = "";
String contact = "";
String addr1   = "";
String addr2   = "";
String postcode= "";
String surburb = "";
String state   = "";
int    i = 0;

sql = "select id," +
      "       passwd," +
      "       name,"+
      "       email,"+
      "       phone1,"+
      "       phone2,"+
      "       fax,"+
      "       contact,"+
      "       addr1,"+
      "       addr2,"+
      "       postcode,"+
      "       surburb,"+
      "       state, "+
      "       decode(user_group, 'D', 'DDP', 'F', 'FOB', user_group), " +
      "       supplier_class " +
      "  from login_01t " +
      " where delete_yn = 'N' ";

if ( !(ag_supplier == null || ag_supplier.length() < 1))  {
  ag_supplier = ag_supplier.toUpperCase();
  sql +=  " and upper(name) like  '%" + ag_supplier + "%'" ;
}
if ( !(ag_id2 == null || ag_id2.length() < 1))  {
  sql += " and id = '" + ag_id2 + "'" ;
}

sql += " order by name asc " ;

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);

} catch (Exception e) {
  System.out.println("Exception supplier : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

if (iRet > 0 ) {
  int no = 0;
  
  for (i=0; i < iRet; i++) {
    id      = matrix.getRowData(i).getData(0);
    pw      = matrix.getRowData(i).getData(1);
    name    = matrix.getRowData(i).getData(2);
    email   = matrix.getRowData(i).getData(3);
    phone1  = matrix.getRowData(i).getData(4);
    phone2  = matrix.getRowData(i).getData(5);
    fax     = matrix.getRowData(i).getData(6);
    contact = matrix.getRowData(i).getData(7);
    addr1   = matrix.getRowData(i).getData(8);
    addr2   = matrix.getRowData(i).getData(9);
    postcode= matrix.getRowData(i).getData(10);
    surburb = matrix.getRowData(i).getData(11);
    state   = matrix.getRowData(i).getData(12);
    String supplier_type = matrix.getRowData(i).getData(13);
    String supplier_class = matrix.getRowData(i).getData(14);
    
    outS += "<tr align='center'>" +
            "<td>" + id   + "</td>" +
            "<td align='left'>" + name + "</td>" +
            "<td>" + supplier_type + "</td>" +
            "<td>" + supplier_class + "</td>" +
            "<td align='left'>" + email + "</td>" +
            "<td>" + phone1 + "&nbsp;</td>" +
            "</tr>";
  } //end of for
} //end of if

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( outS ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("account/supplier_excel.jsp"), 4360201039292688599L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  private final static char []_jsp_string2;
  static {
    _jsp_string0 = "\n\n\n\n".toCharArray();
    _jsp_string3 = "\n</table>\n</body>\n</html>\n".toCharArray();
    _jsp_string1 = "\n\n".toCharArray();
    _jsp_string2 = "\n<html>\n<head>\n</head>\n<body>\n<table width=\"1200\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n<tr align='center'>\n  <TD>ID</TD>\n  <TD>NAME</TD>\n  <TD>Type</TD>\n  <TD>Class</TD>\n  <TD>E-Mail</TD>\n  <TD>Phone1</TD>\n</tr>\n".toCharArray();
  }
}