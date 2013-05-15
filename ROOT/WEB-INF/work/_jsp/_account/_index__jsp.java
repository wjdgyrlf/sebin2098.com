/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._account;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import dbconn.*;
import java.text.*;

public class _index__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;


  //-------------------------------------------
  // CopyRightLogo
  //
  //-------------------------------------------
  String CopyRightLogo()
  {
    String str;
    str = "<table width='99%' border='0' cellspacing='0' cellpadding='0' align='center'>";
    str += "<tr><td width='100%' height='2' align='center'>";
    str += "<HR width=100% size=2></td></tr>";
    str += "<tr><td width='100%' align='center'>";
    str += "<FONT size=2 >&copy;Copyright 2010 </font>";
    str += "<FONT size=2 color=green>Fast Future Brands Pty Ltd. All Rights Reserved.</FONT><BR>";
    str += "<FONT size=2> For more information,please contact</font> <FONT size=2 color=blue><A href='mailto:scm@ffb.net.au'>scm@ffb.net.au</A></FONT>";
    str += "</td></tr></table>";

    return (String)str;
  }

  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, "/account/../error.jsp", session, 8192, true, false);
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

String scmid = "";
String scmnm = "";
String usertype = "";
String usergroup = "";
//String scmsubids = "";
String _adminid = "";
String _adminname = "";
String _admingroup = "";
String _apessid = "";
String _apessname = "";

try{
  scmid = (String) session.getAttribute("scmid");
  _adminid = (String) session.getAttribute("adminid");

  if( (scmid == null || scmid.length() == 0 || scmid.equals("null"))
      && (_adminid == null || _adminid.length() == 0 || _adminid.equals("null")) ) {
    response.sendRedirect("/login_first.html");
    return;
  }

  _adminname = (String) session.getAttribute("adminname");

  _apessid = (String) session.getAttribute("apessid");
  _apessname = (String) session.getAttribute("apessname");

  scmnm = (String) session.getAttribute("scmnm");

  usertype = (String) session.getAttribute("usertype");
  if (usertype == null) usertype = "";

  usergroup = (String) session.getAttribute("usergroup");
  if (usergroup == null) usergroup = "";

  //scmsubids = (String) session.getAttribute("scmsubids");
  //session.setMaxInactiveInterval(60*60);

}catch( Exception e ) {
  response.sendRedirect("/login_first.html");
  return;
}

      out.write('\n');
      
SimpleDateFormat dd = new SimpleDateFormat("yyyyMMdd");
String sdate = dd.format(new java.util.Date());
String id      = "";
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

int iRet = 0;
String outS = "";
String sql = "";
dbconn.DBConnManager dbPool = null;
Connection conn = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");

  // Read profile info
  sql = "select id," +
        "       passwd," +
        "       trim(name),"+
        "       email,"+
        "       phone1,"+
        "       phone2,"+
        "       fax,"+
        "       contact,"+
        "       addr1,"+
        "       addr2,"+
        "       postcode,"+
        "       surburb,"+
        "       state"+
        "  from login_01t " +
        " where id = '" + scmid + "'" ;

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

} catch (Exception e) {
  System.out.println("Exception /account/index : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) { dbPool.freeConnection("intranet", conn); }
}

if (iRet > 0) {
  int j = 0;
  id      = matrix.getRowData(0).getData(j++);
  pw      = matrix.getRowData(0).getData(j++);
  name    = matrix.getRowData(0).getData(j++);
  email   = matrix.getRowData(0).getData(j++);
  phone1  = matrix.getRowData(0).getData(j++);
  phone2  = matrix.getRowData(0).getData(j++);
  fax     = matrix.getRowData(0).getData(j++);
  contact = matrix.getRowData(0).getData(j++);
  addr1   = matrix.getRowData(0).getData(j++);
  addr2   = matrix.getRowData(0).getData(j++);
  postcode= matrix.getRowData(0).getData(j++);
  surburb = matrix.getRowData(0).getData(j++);
  state   = matrix.getRowData(0).getData(j++);
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print((id));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print((name));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print((email));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print((phone1));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print((phone2));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print((fax));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((contact));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((addr1));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((addr2));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((postcode));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print((surburb));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((state));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string14, 0, _jsp_string14.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("account/index.jsp"), -7173759976633624292L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string14;
  private final static char []_jsp_string12;
  private final static char []_jsp_string10;
  private final static char []_jsp_string0;
  private final static char []_jsp_string8;
  private final static char []_jsp_string2;
  private final static char []_jsp_string11;
  private final static char []_jsp_string5;
  private final static char []_jsp_string9;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  private final static char []_jsp_string4;
  private final static char []_jsp_string7;
  private final static char []_jsp_string13;
  private final static char []_jsp_string6;
  static {
    _jsp_string14 = "\n\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string12 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">State</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><input type=text NAME=state value=".toCharArray();
    _jsp_string10 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Post Code</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=postcode  rows=1 cols=30>".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n".toCharArray();
    _jsp_string8 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Address1</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=addr1   rows=1 cols=30>".toCharArray();
    _jsp_string2 = " > </TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=#ccccff>Supplier name</TD>\n    <TD ALIGN=left class=\"table_bg_bright\"><textarea readonly style=\"overflow:hidden\" NAME=name rows=1 cols=40>".toCharArray();
    _jsp_string11 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Surburb</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=surburb  rows=1 cols=30 >".toCharArray();
    _jsp_string5 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Mobile Phone</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=phone2 rows=1 cols=30>".toCharArray();
    _jsp_string9 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Address2</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=addr2   rows=1 cols=30 >".toCharArray();
    _jsp_string3 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Email</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\"  NAME=email rows=1 cols=30>".toCharArray();
    _jsp_string1 = "\n<HTML>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=JavaScript>\nfunction Submit()\n{\n  var yn\n  yn = confirm(\" Save your profile ?  \");\n  \n  if ( yn == true ) {\n    frmMain.method = \"POST\";\n    frmMain.action = \"profile_update.jsp\";\n    frmMain.submit();\n  }\n}\n\nfunction pwchange()\n{\n  frmMain.action = \"../initpass.jsp\";\n  frmMain.submit();\n}\n\nfunction Back()\n{\n  history.back();\n}\n</script>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Supplier Profile</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<TR>\n  <td width=100%><font color=red>**Notice : Suppier ID, Name can not modify in your profile. **</font></td>\n</TR>\n</table>\n\n<TABLE cellSpacing=1 cellPadding=2 width=\"90%\" border=0 align='center' class=\"table_bg\">\n<FORM NAME=\"frmMain\" METHOD=\"POST\" ACTION=\"profile_update.jsp\">\n<TBODY>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=#ccccff>Supplier ID</TD>\n    <TD ALIGN=left class=\"table_bg_bright\"><input readonly type=text name=id value=".toCharArray();
    _jsp_string4 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Phone</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=phone1 rows=1 cols=30 >".toCharArray();
    _jsp_string7 = "</textarea></TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Contact</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=contact  rows=1 cols=30>".toCharArray();
    _jsp_string13 = "></TD>\n  </TR>\n</TABLE>\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"15\">\n    <INPUT TYPE=BUTTON VALUE=\"Submit\" ONCLICK=\"Submit()\">\n    <INPUT TYPE=BUTTON VALUE=\"PW Change\" ONCLICK=\"pwchange()\">\n    <INPUT TYPE=BUTTON VALUE=\"Back\" ONCLICK=\"Back()\">\n  </td>\n</tr>\n</FORM>\n</table>\n\n".toCharArray();
    _jsp_string6 = "</textarea> </TD>\n  </TR>\n  <TR>\n    <TD ALIGN=CENTER bgcolor=\"#F4F2AE\">Fax</TD>\n    <TD ALIGN=LEFT class=\"table_bg_bright\"><textarea  style=\"overflow:hidden\" NAME=fax rows=1 cols=30 >".toCharArray();
  }
}