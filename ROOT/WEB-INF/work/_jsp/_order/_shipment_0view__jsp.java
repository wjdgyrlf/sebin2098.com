/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._order;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import dbconn.*;
import common.util.*;

public class _shipment_0view__jsp extends com.caucho.jsp.JavaPage
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

String QTY_FORMAT = "###,##0";

String ag_supplier_id = request.getParameter("ag_supplier_id");
String ag_from_date = request.getParameter("ag_from_date");
String ag_to_date = request.getParameter("ag_to_date");
String ag_confirm_status = request.getParameter("ag_confirm_status");
String ag_month = request.getParameter("ag_month");
String ag_year = request.getParameter("ag_year");
String ag_invoice_no = request.getParameter("ag_invoice_no");
String invoice_no = request.getParameter("invoice_no");
String supplier_id = request.getParameter("supplier_id");
String ag_po_no = request.getParameter("ag_po_no");
if (ag_supplier_id == null) ag_supplier_id = "";
if (ag_from_date == null) ag_from_date = "";
if (ag_to_date == null) ag_to_date = "";
if (ag_confirm_status == null) ag_confirm_status = "";
if (ag_month == null) ag_month = "";
if (ag_year == null) ag_year = "";
if (ag_invoice_no == null) ag_invoice_no = "";
if (ag_po_no == null) ag_po_no = "";
if (invoice_no == null) invoice_no = "";
if (supplier_id == null) supplier_id = "";

String confirm_status = "";
String confirm_date = "";
String supplier_name = "";
String issue_date = "";
String shipping_port_name = "";
String shipping_port_country_name = "";
String handover_date = "";
String shipping_type = "";
String nominated_forwarder = "";
String nominated_forwarder_name = "";
String nominated_forwarder_country_name = "";
String bl_filename = "";
String iv_filename = "";
String pl_filename = "";

int total_order_qty = 0;
int total_packing_qty = 0;
boolean isEditable = false;

int iRet = 0;
Connection connScm = null;
MatrixDataSet matrix = null;
MatrixDataSet matrix2 = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String outS = "";
String sql = "";

try {

  matrix = new dbconn.MatrixDataSet();
  matrix2 = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  // read shipment header info
  sql = " select  s.confirm_status, to_char(s.confirm_date, 'dd/mm/yyyy'), l.name, to_char(s.issue_date, 'dd/mm/yyyy'), "
      + "         c1.code_name, c2.code_name,  to_char(s.handover_date, 'dd/mm/yyyy'), s.shipping_type, "
      + "         c3.code_name, c4.code_name, s.bl_filename, s.iv_filename, s.pl_filename "
      + " from    shipment_01t s "
      + "         left outer join login_01t l "
      + "           on s.supplier_id = l.id "
      + "         left outer join vg_common_code c1 "
      + "           on s.shipping_port = c1.code "
      + "           and c1.type = 'SHIPPING_PORT' "
      + "         left outer join vg_common_code c2 "
      + "           on c1.related_code = c2.code "
      + "           and c2.type = 'COUNTRY_CODE' "
      + "         left outer join vg_common_code c3 "
      + "           on s.nominated_forwarder = c3.code "
      + "           and c3.type = 'FORWARDER' "
      + "         left outer join vg_common_code c4 "
      + "           on c3.related_code = c4.code "
      + "           and c4.type = 'COUNTRY_CODE' "
      + " where   s.invoice_no = '" + invoice_no + "' "
      + " and     s.supplier_id = '" + supplier_id + "' ";

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);

  // read shipment details
  sql = " select  po_no, style_no, brand, trans_type, order_qty, packing_qty "
      + " from    shipment_02t "
      + " where   invoice_no = '" + invoice_no + "' "
      + " and     supplier_id = '" + supplier_id + "' "
      + " order by po_no ";

  dataProcess.RetrieveData(sql, matrix2, connScm);

} catch (Exception e) {
  System.out.println("Exception shipment_view : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

// set shipment header info
if (iRet > 0) {
  int j = 0;
  confirm_status = matrix.getRowData(0).getData(j++);
  confirm_date = matrix.getRowData(0).getData(j++);
  supplier_name = matrix.getRowData(0).getData(j++);
  issue_date = matrix.getRowData(0).getData(j++);
  shipping_port_name = matrix.getRowData(0).getData(j++);
  shipping_port_country_name = matrix.getRowData(0).getData(j++);
  handover_date = matrix.getRowData(0).getData(j++);
  shipping_type = matrix.getRowData(0).getData(j++);
  nominated_forwarder_name = matrix.getRowData(0).getData(j++);
  nominated_forwarder_country_name = matrix.getRowData(0).getData(j++);
  bl_filename = matrix.getRowData(0).getData(j++);
  iv_filename = matrix.getRowData(0).getData(j++);
  pl_filename = matrix.getRowData(0).getData(j++);

  if (!confirm_status.equals("Y")) {
    isEditable = true;
    confirm_date = "";
  }
}

// set shipment details
for (int i = 0; i < matrix2.getRowCount(); i++) {
  int j = 0;
  String po_no = matrix2.getRowData(i).getData(j++);
  String style_no = matrix2.getRowData(i).getData(j++);
  String brand = matrix2.getRowData(i).getData(j++);
  String trans_type = matrix2.getRowData(i).getData(j++);
  int order_qty = Integer.parseInt(matrix2.getRowData(i).getData(j++));
  int packing_qty = Integer.parseInt(matrix2.getRowData(i).getData(j++));

  total_order_qty += order_qty;
  total_packing_qty += packing_qty;

  outS += "<tr align='center' bgcolor='" + (i%2 == 0 ? "#FFFFF0" : "#EEEEE0") + "'>" +
          "<td>" + (i+1) + "</td>" +
          "<td>" + po_no + "</td>" +
          "<td>" + style_no + "</td>" +
          "<td>" + brand + "</td>" +
          "<td>" + trans_type + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(order_qty, QTY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(packing_qty, QTY_FORMAT) + "</td>" +
          "</tr>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
if (isEditable && scmid != null) {

      out.write(_jsp_string3, 0, _jsp_string3.length);
      
}

      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( (_adminid != null ? "admin_" : "") ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_supplier_id ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_from_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_to_date ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( ag_confirm_status ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( ag_month ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( ag_year ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( ag_invoice_no ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( invoice_no ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( supplier_id ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( supplier_name ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( supplier_id ));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( issue_date ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( invoice_no ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( shipping_port_country_name + " - " + shipping_port_name ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( handover_date ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( shipping_type ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print(( nominated_forwarder_country_name + " - " + nominated_forwarder_name ));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print(( confirm_date ));
      out.write(_jsp_string24, 0, _jsp_string24.length);
      out.print(( bl_filename ));
      out.write(_jsp_string25, 0, _jsp_string25.length);
      out.print(( bl_filename ));
      out.write(_jsp_string26, 0, _jsp_string26.length);
      out.print(( iv_filename ));
      out.write(_jsp_string25, 0, _jsp_string25.length);
      out.print(( iv_filename ));
      out.write(_jsp_string27, 0, _jsp_string27.length);
      out.print(( pl_filename ));
      out.write(_jsp_string25, 0, _jsp_string25.length);
      out.print(( pl_filename ));
      out.write(_jsp_string28, 0, _jsp_string28.length);
      out.print(( outS ));
      out.write(_jsp_string29, 0, _jsp_string29.length);
      out.print(( StringUtil.formatNumber(total_order_qty, QTY_FORMAT) ));
      out.write(_jsp_string30, 0, _jsp_string30.length);
      out.print(( StringUtil.formatNumber(total_packing_qty, QTY_FORMAT) ));
      out.write(_jsp_string31, 0, _jsp_string31.length);
      
if (isEditable && scmid != null) {

      out.write(_jsp_string32, 0, _jsp_string32.length);
      
}

      out.write(_jsp_string33, 0, _jsp_string33.length);
      out.print(( _shipmentFileUrl ));
      out.write(_jsp_string34, 0, _jsp_string34.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string35, 0, _jsp_string35.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/shipment_view.jsp"), -1400339739830549065L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string28;
  private final static char []_jsp_string31;
  private final static char []_jsp_string34;
  private final static char []_jsp_string18;
  private final static char []_jsp_string33;
  private final static char []_jsp_string8;
  private final static char []_jsp_string10;
  private final static char []_jsp_string24;
  private final static char []_jsp_string19;
  private final static char []_jsp_string26;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  private final static char []_jsp_string29;
  private final static char []_jsp_string13;
  private final static char []_jsp_string17;
  private final static char []_jsp_string20;
  private final static char []_jsp_string22;
  private final static char []_jsp_string4;
  private final static char []_jsp_string12;
  private final static char []_jsp_string16;
  private final static char []_jsp_string5;
  private final static char []_jsp_string6;
  private final static char []_jsp_string30;
  private final static char []_jsp_string3;
  private final static char []_jsp_string9;
  private final static char []_jsp_string11;
  private final static char []_jsp_string27;
  private final static char []_jsp_string25;
  private final static char []_jsp_string0;
  private final static char []_jsp_string21;
  private final static char []_jsp_string7;
  private final static char []_jsp_string23;
  private final static char []_jsp_string15;
  private final static char []_jsp_string32;
  private final static char []_jsp_string14;
  private final static char []_jsp_string35;
  static {
    _jsp_string28 = "</a></TD>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Shipment PO List</b></td>\n</tr>\n</table>\n<TABLE width='99%' border=0 CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<TR class='table_header_center'>\n  <TD width='10%'>No</TD>\n  <TD width='15%'>PO No.</TD>\n  <TD width='15%'>Style No.</TD>\n  <TD width='15%'>Brand</TD>\n  <TD width='15%'>Trans. Type</TD>\n  <TD width='15%'>Order Qty</TD>\n  <TD width='15%'>Packing Qty</TD>\n</TR>\n".toCharArray();
    _jsp_string31 = "</td>\n</tr>\n</TABLE>\n\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n<tr>\n  <td width=\"100%\">\n".toCharArray();
    _jsp_string34 = "'>\n<input type='hidden' name='attachFile'>\n<input type='hidden' name='attachRealFile'>\n</form>\n</table>\n".toCharArray();
    _jsp_string18 = "</TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>Invoice No</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string33 = "\n    <input type='button' value='Go To List' onclick='fnList(this.form);'>\n  </td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</FORM>\n<form name='form2' method='post'>\n<input type='hidden' name='attachPath' value='".toCharArray();
    _jsp_string8 = "'>\n<input type='hidden' name='ag_confirm_status' value='".toCharArray();
    _jsp_string10 = "'>\n<input type='hidden' name='ag_year' value='".toCharArray();
    _jsp_string24 = "</TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>B/L or AWB File</TD>\n  <TD class='table_bg_bright' colspan='5'><a href=\"javascript:fnDownload('".toCharArray();
    _jsp_string19 = "</TD>\n  <TD class='table_header_center'>Shipping Port</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string26 = "</a></TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>Invoice File</TD>\n  <TD class='table_bg_bright' colspan='5'><a href=\"javascript:fnDownload('".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<SCRIPT LANGUAGE=JavaScript>\n".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string29 = "\n<tr class='table_header_center'>\n  <td colspan='5'>TOTAL</td>\n  <td align='right'>".toCharArray();
    _jsp_string13 = "'>\n<input type='hidden' name='invoice_no' value='".toCharArray();
    _jsp_string17 = "</TD>\n  <TD width='15%' class='table_header_center'>Issue Date</TD>\n  <TD width='12%' class='table_bg_bright'>".toCharArray();
    _jsp_string20 = "</TD>\n  <TD class='table_header_center'>Handover Date</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string22 = "</TD>\n  <TD class='table_header_center'>Nominated Forwarder</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string4 = "\n\nfunction fnList(frm) {\n  frm.action = './".toCharArray();
    _jsp_string12 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string16 = "</TD>\n  <TD width='18%' class='table_header_center'>Supplier ID</TD>\n  <TD width='22%' class='table_bg_bright'>".toCharArray();
    _jsp_string5 = "shipment_list.jsp';\n  frm.submit();\n}\n\nfunction fnDownload(file) {\n  with (document.form2) {\n    attachFile.value = file;\n    attachRealFile.value = file;\n    action = '/common/download.jsp';\n    target = 'hiddenFrm';\n    submit();\n  }\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Shipment Details</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\">\n<TR>\n  <td><font color=blue>* Please contact our SCM PIC(prerna.j@ffb.net.au) regarding any shipment creation issues.</font></td>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</table>\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Shipment Header</b></td>\n</tr>\n</table>\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\" class=\"table_bg\">\n<FORM NAME='frmMain' METHOD='POST'>\n<input type='hidden' name='ag_supplier_id' value='".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='ag_from_date' value='".toCharArray();
    _jsp_string30 = "</td>\n  <td align='right'>".toCharArray();
    _jsp_string3 = "\nfunction fnEdit(frm)\n{\n  frm.action = './shipment_edit_form.jsp';\n  frm.submit();\n}\n\nfunction fnDelete(frm)\n{\n  if (confirm('Do you want to delete this shipment?')) {\n    frm.action = './shipment_delete.jsp';\n    frm.submit();\n  }\n}\n".toCharArray();
    _jsp_string9 = "'>\n<input type='hidden' name='ag_month' value='".toCharArray();
    _jsp_string11 = "'>\n<input type='hidden' name='ag_invoice_no' value='".toCharArray();
    _jsp_string27 = "</a></TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>Packing List File</TD>\n  <TD class='table_bg_bright' colspan='5'><a href=\"javascript:fnDownload('".toCharArray();
    _jsp_string25 = "');\">".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string21 = "</TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>Shipping Type</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='ag_to_date' value='".toCharArray();
    _jsp_string23 = "</TD>\n  <TD class='table_header_center'>Confirm Date</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string15 = "'>\n<TR>\n  <TD width='15%' class='table_header_center'>Supplier Name</TD>\n  <TD width='18%' class='table_bg_bright'>".toCharArray();
    _jsp_string32 = "\n    <input type='button' value='Edit Shipment' onclick='fnEdit(this.form);'>\n    <input type='button' value='Delete Shipment' onclick='fnDelete(this.form);'>\n".toCharArray();
    _jsp_string14 = "'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
    _jsp_string35 = "\n</td></tr></table>\n<iframe name='hiddenFrm' src='' width='0' height='0' frameborder='0'></iframe>\n</BODY>\n</HTML>\n".toCharArray();
  }
}