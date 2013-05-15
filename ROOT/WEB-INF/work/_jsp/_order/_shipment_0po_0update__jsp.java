/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._order;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import common.*;
import dbconn.*;

public class _shipment_0po_0update__jsp extends com.caucho.jsp.JavaPage
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

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
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
      
String ag_month = request.getParameter("ag_month");
String ag_year = request.getParameter("ag_year");
String ag_invoice_no = request.getParameter("ag_invoice_no");
String invoice_no = request.getParameter("invoice_no");
String ag_po_no = request.getParameter("ag_po_no");
String supplier_id = request.getParameter("supplier_id");
String actionFlag = request.getParameter("actionFlag");
String[] po_no = request.getParameterValues("po_no");

int iCnt = 0;
int iRet = 0;
String sql = "";
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
Connection connScm = null;
PreparedStatement pstmt = null;
boolean isSucceeded = false;
String strMsg = "";

try {

  dbPool = DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");
  matrix = new MatrixDataSet();
  dataProcess = new DataProcess();

  // check shipment  
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

  // set po list
  String tmp_po_no = "";
  if (po_no != null) {
    for (int i = 0; i < po_no.length; i++) {
      if (i > 0) tmp_po_no += ",";
      tmp_po_no += "'" + po_no[i] + "'";
    }
  }

  // insert or delete pos to shipment
  int j = 0;
  connScm.setAutoCommit(false);

  if (actionFlag.equals("AP")) {
  
    // check POs whether they are already invoiced.
    sql = " select  count(*) "
        + " from    shipment_02t "
        + " where   po_no in (" + tmp_po_no + ") ";
  
    iRet = dataProcess.RetrieveData(sql, matrix, connScm);
  
    if (iRet > 0) {
      iCnt = Integer.parseInt(matrix.getRowData(0).getData(0));
    }

    if (iCnt > 0) {
      throw new UserDefinedException("One of the POs has been already included in shipment.\\nCheck your data.");
    }

    // add POs to shipment
    sql = " insert into shipment_02t "
        + " ( "
        + "   po_no, style_no, invoice_no, supplier_id, brand, "
        + "   trans_type, order_qty, packing_qty, input_date, input_id "
        + " ) "
        + " select  a.po_order_no, b.xspo_style, ?, ?, e.brand, "
        + "         b.xspo_trans_type, c.order_qty, e.packing_qty, sysdate, ? "
        + " from    por5mf4@pronto a "
        + "         inner join xstpu22@pronto b "
        + "           on a.po_order_no = b.xspo_po_order_no "
        + "           and a.backorder_flag = b.backorder_flag "
        + "         inner join "
        + "         ( "
        + "           select  xsca_po_order_no, backorder_flag, sum(xsca_total_qty) order_qty "
        + "           from    xstcolal1@pronto "
        + "           group by xsca_po_order_no, backorder_flag "
        + "         ) c "
        + "           on b.xspo_po_order_no = c.xsca_po_order_no "
        + "           and b.backorder_flag = c.backorder_flag "
        + "         inner join cre5mfi@pronto d "
        + "           on a.cre_accountcode = d.cre_accountcode "
        + "         inner join "
        + "         ( "
        + "           select  a.po_no po_no, "
        + "                   max(a.brand) brand, "
        + "                   sum(nvl(b.ttl_qty,0)) packing_qty "
        + "           from    packing_01t a "
        + "                   inner join packing_03t b "
        + "                     on a.po_no = b.po_no "
        + "                     and a.packing_date = b.packing_date "
        + "                     and a.style_no = b.style_no "
        + "           where   a.supplier_id = '" + supplier_id + "' "
        + "           and     a.po_no in (" + tmp_po_no + ") "
        + "           and     not exists ( select  1 "
        + "                                from    shipment_02t c "
        + "                                where   c.po_no = a.po_no ) "
        + "           group by a.po_no "
        + "         ) e "
        + "           on a.po_order_no = e.po_no "
        + " where   a.backorder_flag = ' ' "
        + " and     a.po_order_no in (" + tmp_po_no.replaceAll("'", "") + ") "
        + " and     a.po_order_status = '40' "
        + " and     d.cr_supplier_grp = 'FOB' "
        + " and     b.ex_factory_date >= to_date('10/12/2010', 'dd/mm/yyyy') "
        + " order by a.po_order_no ";

    pstmt = connScm.prepareStatement(sql);
    pstmt.setString(++j, invoice_no);
    pstmt.setString(++j, supplier_id);
    pstmt.setString(++j, scmid);
    pstmt.executeUpdate();
    pstmt.close();
    pstmt = null;

  } else if (actionFlag.equals("DP")) {
    
    // delete POs from delivery note
    sql = " delete  shipment_02t "
        + " where   po_no in (" + tmp_po_no + ") "
        + " and     invoice_no = ? "
        + " and     supplier_id = ? ";

    pstmt = connScm.prepareStatement(sql);
    pstmt.setString(++j, invoice_no);
    pstmt.setString(++j, supplier_id);
    pstmt.executeUpdate();
    pstmt.close();
    pstmt = null;

  } else {

    throw new UserDefinedException("The action is unknown.");

  }

  connScm.commit();
  isSucceeded = true;

} catch (UserDefinedException ue) {
  try { connScm.rollback(); } catch (Exception ex) {}

  strMsg = ue.getMessage();
} catch (Exception e) {
  try { connScm.rollback(); } catch (Exception ex) {}

  System.out.println("Exception shipment_po_update : " + e.getMessage());
  throw e;
} finally {
  if (pstmt != null) {
    try { pstmt.close(); } catch (Exception e) {}
  }
  if (connScm != null) {
    try { connScm.setAutoCommit(true); } catch (Exception e) {}

    if (actionFlag.equals("AP")) {
      dataProcess = new DataProcess();
      dataProcess.ManipulateData("alter session close database link pronto", connScm);
    }

    dbPool.freeConnection("intranet", connScm);
  }
}

// result message
String nextUrl = "./shipment_edit_form.jsp";

if (isSucceeded) {
  strMsg = "The data has been successfully processed.\\nYou must update all attached files as well.";
} else {
  strMsg = "The operation failed.\\n" + strMsg;
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( ag_month ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ag_year ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_invoice_no ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_po_no ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/shipment_po_update.jsp"), 5570156117879719230L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string10;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string9;
  private final static char []_jsp_string0;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string5;
  private final static char []_jsp_string8;
  private final static char []_jsp_string4;
  private final static char []_jsp_string7;
  static {
    _jsp_string10 = "';\nform1.submit();\n</script>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string3 = "'>\n<input type='hidden' name='ag_year' value='".toCharArray();
    _jsp_string2 = "\n<HTML>\n<head>\n</head>\n<body>\n<form name='form1' method='post'>\n<input type='hidden' name='ag_month' value='".toCharArray();
    _jsp_string9 = "\");\nform1.action = '".toCharArray();
    _jsp_string0 = "\n\n\n\n".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='invoice_no' value='".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string8 = "'>\n</form>\n<script language='javascript'>\nalert(\"".toCharArray();
    _jsp_string4 = "'>\n<input type='hidden' name='ag_invoice_no' value='".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
  }
}
