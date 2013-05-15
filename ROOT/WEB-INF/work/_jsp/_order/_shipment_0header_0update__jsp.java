/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._order;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import common.*;
import common.util.*;
import dbconn.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public class _shipment_0header_0update__jsp extends com.caucho.jsp.JavaPage
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

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

// variables
boolean isSucceeded = false;
String strMsg = "";
String invoice_no =  "";
String supplier_id =  "";

int iCnt = 0;
int iRet = 0;
String sql = "";
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
Connection connScm = null;
PreparedStatement pstmt = null;

HashMap params = new HashMap();               // for parameter
String savePath = application.getRealPath(_shipmentFileUrl) + File.separator;   // file path

// Jakarta Commons Project FileUpload
// -> http://jakarta.apache.org/commons/fileupload/
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setRepository(new File(_uploadPath));                 // Set factory constraints
ServletFileUpload upload = new ServletFileUpload(factory);    // Create a new file upload handler
upload.setSizeMax(_maxFileSize);                              // Set overall request size constraint
List items = upload.parseRequest(request);                    // Parse the request

try {

  // Read items
  Iterator iter = items.iterator();

  while (iter.hasNext()) {
    FileItem item = (FileItem) iter.next();

    if (item.isFormField()) {
      // Process a regular form field
      String name = item.getFieldName();
      params.put(name, item.getString());
    }
  }

  // database process
  dbPool = DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");
  matrix = new MatrixDataSet();
  dataProcess = new DataProcess();
  
  // check shipment  
  invoice_no = (String) params.get("invoice_no");
  supplier_id = (String) params.get("supplier_id");

  sql = " select  confirm_status "
      + " from    shipment_01t "
      + " where   invoice_no = '" + invoice_no + "' "
      + " and     supplier_id = '" + supplier_id + "' ";

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);

  if (iRet < 1) {
    throw new UserDefinedException("Cannot find this shipment. Check your data.");
  }
  
  String confirmStatus = matrix.getRowData(0).getData(0);

  if (confirmStatus.equals("Y")) {
    throw new UserDefinedException("Cannot update this shipment. This shipment has been already confirmed. Check your data.");
  }

  // process attached files
  iter = items.iterator();

  while (iter.hasNext()) {
    FileItem item = (FileItem) iter.next();

    if (!item.isFormField()) {
      // process attached files
      String fieldName = item.getFieldName();
      String fileName = item.getName();

      // if filename is empty then skip
      if (fileName == null || fileName.equals("")) {
        continue;
      }

      int pos = fileName.lastIndexOf("\\");
      if (pos < 0) fileName.lastIndexOf("/");

      String attachFileName = fileName.substring(pos+1);

      // check File Size
      if (item.getSize() == 0) {
        throw new UserDefinedException("Cannot process your file(" + attachFileName + "). The file size is zero. Check your file.");
      }

      String ext = "";
      pos = attachFileName.lastIndexOf(".");

      if (pos >= 0) {
        ext = attachFileName.substring(pos);
      }

      String fileType = fieldName.substring(0, 2).toUpperCase();
      String realFileName = scmid + "_" + fileType + "_" + invoice_no + ext;
      File writeFile = new File(savePath + realFileName);

      if (writeFile.exists()) {
        writeFile.delete();
      }

      item.write(writeFile);
      params.put(fieldName, realFileName);
    }
  }

  // update shipment header info
  sql = " update  shipment_01t "
      + " set     shipping_port = ?, "
      + "         handover_date = to_date(?, 'dd/mm/yyyy'), "
      + "         shipping_type = ?, "
      + "         nominated_forwarder = ?, "
      + (params.get("bl_filename") != null ? " bl_filename = ?, " : "")
      + (params.get("iv_filename") != null ? " iv_filename = ?, " : "")
      + (params.get("pl_filename") != null ? " pl_filename = ?, " : "")
      + "         update_date = sysdate "
      + " where   invoice_no = ? "
      + " and     supplier_id = ? ";

  int j = 0;
  connScm.setAutoCommit(false);
  pstmt = connScm.prepareStatement(sql);
  pstmt.setString(++j, (String) params.get("shipping_port"));
  pstmt.setString(++j, (String) params.get("handover_date"));
  pstmt.setString(++j, (String) params.get("shipping_type"));
  pstmt.setString(++j, (String) params.get("nominated_forwarder"));

  if(params.get("bl_filename") != null) {
    pstmt.setString(++j, (String) params.get("bl_filename"));
  }
  if(params.get("iv_filename") != null) {
    pstmt.setString(++j, (String) params.get("iv_filename"));
  }
  if(params.get("pl_filename") != null) {
    pstmt.setString(++j, (String) params.get("pl_filename"));
  }

  pstmt.setString(++j, invoice_no);
  pstmt.setString(++j, supplier_id);

  iCnt = pstmt.executeUpdate();
  pstmt.close();
  pstmt = null;

  if (iCnt != 1) {
    throw new UserDefinedException("Cannot update this shipment. Check your data.");
  }

  connScm.commit();
  isSucceeded = true;

} catch (UserDefinedException ue) {
  try { connScm.rollback(); } catch (Exception ex) {}

  isSucceeded = false;
  strMsg = ue.getMessage();
  System.out.println("Exception shipment_header_update : " + ue.getMessage());
} catch (Exception e) {
  try { connScm.rollback(); } catch (Exception ex) {}

  isSucceeded = false;
  System.out.println("Exception shipment_header_update : " + e.getMessage());
  throw e;
} finally {
  if (pstmt != null) {
    try { pstmt.close(); } catch (Exception e) {}
  }

  if (connScm != null) {
    try { connScm.setAutoCommit(true); } catch (Exception e) {}
    dbPool.freeConnection("intranet", connScm);
  }
}

// result message
String nextUrl = "./shipment_edit_form.jsp";

if (isSucceeded) {
  strMsg = "The data has been successfully processed.";
} else {
  strMsg = "The operation failed.\\n" + strMsg;
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( (String) params.get("ag_month") ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( (String) params.get("ag_year") ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( (String) params.get("ag_invoice_no") ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( (String) params.get("ag_po_no") ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( invoice_no ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( supplier_id ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( strMsg ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( nextUrl ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/shipment_header_update.jsp"), -4063518439383055686L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string10;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string0;
  private final static char []_jsp_string9;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string5;
  private final static char []_jsp_string8;
  private final static char []_jsp_string4;
  private final static char []_jsp_string7;
  static {
    _jsp_string10 = "';\nform1.submit();\n</script>\n</body>\n</html>\n".toCharArray();
    _jsp_string3 = "'>\n<input type='hidden' name='ag_year' value='".toCharArray();
    _jsp_string2 = "\n<html>\n<head>\n</head>\n<body>\n<form name='form1' method='post'>\n<input type='hidden' name='ag_month' value='".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n\n\n\n".toCharArray();
    _jsp_string9 = "\");\nform1.action = '".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='invoice_no' value='".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string8 = "'>\n</form>\n<script language='javascript'>\nalert(\"".toCharArray();
    _jsp_string4 = "'>\n<input type='hidden' name='ag_invoice_no' value='".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
  }
}