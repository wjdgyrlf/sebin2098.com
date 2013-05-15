/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import dbconn.*;
import java.util.ArrayList;

public class _login__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;


  private void login_history(String scmid, String password, String ipaddress, String loginname, Connection conn ){

  	String sql = "INSERT INTO user_02t(scmid, password, ipaddress, loginname, logintime) " +
  		" VALUES('" + scmid + "', '" + password + "','" + ipaddress + "','" + loginname + "', sysdate )";

  	try{
  		Statement stmt = conn.createStatement();
  		int iRet = stmt.executeUpdate(sql);
  		stmt.close();
  	}catch( SQLException e ) {
  	}
  }

  
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
      
// Intranet DB
String _mysqlJdbcDriver = "com.mysql.jdbc.Driver";
String _urlLogin = "jdbc:mysql://10.2.1.247:3306/intranet";
String _userLogin = "intranet";
String _pwLogin = "tetris82";

// Futura DB
String _mssqlJdbcDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
String _urlFutura = "jdbc:microsoft:sqlserver://10.2.1.228:1433";
String _userFutura = "intranet";
String _pwFutura = "tetris";

// Uplod
String _uploadPath = "/var/tmp";
long _maxFileSize = 10*1024*1024;

// style image path
String _styleImgURL = "/image";

// Fault return invoice File URL
String _faultReturnInvoiceFileURL = "/image/Return";

// Memo \u00b0\u00fc\u00b7\u00c3 \u00ba\u00af\u00bc\u00f6
String _memoDataUrl = "/memo/upload";

// APESS SCM ID
String _apessID = "60171";

// Spec Sheet path
String _specSheetUrl = "/image/SPEC_SHEET";

// Spec Sheet upload path
String _specSheetUploadUrl = "/scan_spec_sheet";

// Sample Image Url
String _sampleIamgeUrl = "/image/SAMPLE_IMAGE";

// barcode file Image Url
String _barcodeFileUrl = "/image/Barcode";

// Invoice file path
String _invoiceFileUrl = "/order/inv_files";

// shipment file path
String _shipmentFileUrl = "/order/shipment_upload";

// Apess MU rate
double _MURate = 0.25;

// Ex-Factory Price Rate
double _EXRate = 0.04;


// Ex-Factory Price Rate for Apess2
double _EXRate2 = 0.04;

// Pronto DATA_AREA
//String _dataArea = "fft";
String _dataArea = "ffl";

// Pronto PIE Info
//String _pieIP = "10.2.1.226";
String _pieIP = "newffbpro.fastfuturebrands.com.au";
int _piePort = 7000;
//String _pieDataset = "apitest";
String _pieDataset = "apilive";

      out.write('\n');
      
dbconn.DBConnManager dbPool = null;
Connection conn = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
int iRet = 0;
String sql = "";
String ipaddress = request.getRemoteAddr();
String scmid = request.getParameter("scmid");
String input_pw = request.getParameter("passwd");
if (scmid == null) scmid = "";
if (input_pw == null) input_pw = "";

String scmnm = "";
String db_pw = "";
String usertype = "";
String usergroup = "";
int pw_interval = 0;

try {

  dbPool = dbconn.DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");
  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  
  // check supplier id
  // if supplier id is one of user_supplier info then forward to apess login page
  sql = " select  supplier_id "
      + " from    user_supplier_01t ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  for (int i = 0; i < iRet; i++) {
    if (scmid.equals(matrix.getRowData(0).getData(0))) {
      response.sendRedirect("/apess/");
      return;
    }
  }

  // read login info
  sql = "SELECT name, passwd, user_type, user_group, nvl(ceil(sysdate - pw_date), 91) " +
        " FROM login_01t " +
        " WHERE id = '" + scmid + "'" +
        " AND   delete_yn = 'N' ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  if( iRet == 0 ) {

    response.sendRedirect("nouser.html");

  } else {
    int j = 0;
    scmnm = matrix.getRowData(0).getData(j++);
    db_pw = matrix.getRowData(0).getData(j++);
    usertype = matrix.getRowData(0).getData(j++);
    usergroup = matrix.getRowData(0).getData(j++);
    pw_interval = Integer.parseInt(matrix.getRowData(0).getData(j++));

    if( input_pw.equals(db_pw) ) {  // Correct password.

      login_history(scmid, input_pw, ipaddress ,scmnm, conn); 
      session.setMaxInactiveInterval(4*60*60);
      session.putValue("scmid", scmid);
      session.putValue("scmnm", scmnm);
      session.putValue("usertype", usertype);
      session.putValue("usergroup", usergroup);
      
      if (db_pw.equals("1111") || pw_interval > 90) {
        response.sendRedirect("initpass2.html");
        return;
      } else {
        response.sendRedirect("index2.jsp");
        return;
      }

    } else {  // wrong password.
      session.invalidate();
      response.sendRedirect("pw_error.html");
      return;
    }

  }

} catch (Exception e) {
  System.out.println("Exception login : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) { dbPool.freeConnection("intranet", conn); }
}

      out.write('\n');
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("login.jsp"), 4589248518796439728L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\n\n\n\n\n\n\n".toCharArray();
  }
}