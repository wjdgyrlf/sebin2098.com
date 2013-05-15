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

public class _shipment_0list__jsp extends com.caucho.jsp.JavaPage
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

int iRet = 0;
Connection connScm = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String outS = "";
String sql = "";

String ag_month = request.getParameter("ag_month");
String ag_year = request.getParameter("ag_year");
String ag_invoice_no = request.getParameter("ag_invoice_no");
String ag_po_no = request.getParameter("ag_po_no");
if (ag_month == null) ag_month = "";
if (ag_year == null) ag_year = "";
if (ag_invoice_no == null) ag_invoice_no = "";
if (ag_po_no == null) ag_po_no = "";

if (ag_month.equals("") || ag_year.equals("")) {
  ag_month = DateUtil.getToday("MM");
  ag_year = DateUtil.getToday("yyyy");
}

// set sql
sql = " select  h.confirm_status, to_char(h.confirm_date, 'dd/mm/yyyy'), to_char(h.issue_date, 'dd/mm/yyyy'), "
    + "         h.invoice_no, c2.code_name, c1.code_name, to_char(h.handover_date, 'dd/mm/yyyy'), "
    + "         c4.code_name, c3.code_name, h.shipping_type, h.bl_filename, h.iv_filename, h.pl_filename "
    + " from    shipment_01t h "
    + "         left outer join vg_common_code c1 "
    + "           on h.shipping_port = c1.code "
    + "           and c1.type = 'SHIPPING_PORT' "
    + "         left outer join vg_common_code c2 "
    + "           on c1.related_code = c2.code "
    + "           and c2.type = 'COUNTRY_CODE' "
    + "         left outer join vg_common_code c3 "
    + "           on h.nominated_forwarder = c3.code "
    + "           and c3.type = 'FORWARDER' "
    + "         left outer join vg_common_code c4 "
    + "           on c3.related_code = c4.code "
    + "           and c4.type = 'COUNTRY_CODE' "
    + " where   supplier_id = '" + scmid + "' ";

if (!ag_invoice_no.equals("") || !ag_po_no.equals("")) {
  if (!ag_invoice_no.equals("")) {
    sql += " and     h.invoice_no = '" + ag_invoice_no + "' ";
  }

  if (!ag_po_no.equals("")) {
    sql += " and     (h.invoice_no, h.supplier_id) in ( "
         + "           select  invoice_no, supplier_id "
         + "           from    shipment_02t "
         + "           where   po_no = '" + ag_po_no + "' "
         + "         ) ";
  }
} else {
  sql += " and     issue_date between to_date('" + ag_year + ag_month + "01', 'yyyymmdd') "
       + "                            and last_day(to_date('" + ag_year + ag_month + "01', 'yyyymmdd')) ";
}

sql += " order by h.issue_date, h.invoice_no ";
//out.println(sql);

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);

} catch (Exception e) {
  System.out.println("Exception shipment_list : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

for (int i = 0; i < iRet; i++) {
  int j = 0;
  String confirmStatus = matrix.getRowData(i).getData(j++);
  String confirmDate = matrix.getRowData(i).getData(j++);
  String issueDate = matrix.getRowData(i).getData(j++);
  String invoiceNo = matrix.getRowData(i).getData(j++);
  String portCountryName = matrix.getRowData(i).getData(j++);
  String shippingPortName = matrix.getRowData(i).getData(j++);
  String handoverDate = matrix.getRowData(i).getData(j++);
  String forwarderCountryName = matrix.getRowData(i).getData(j++);
  String forwarderName = matrix.getRowData(i).getData(j++);
  String shippingType = matrix.getRowData(i).getData(j++);
  String blFilename = matrix.getRowData(i).getData(j++);
  String ivFilename = matrix.getRowData(i).getData(j++);
  String plFilename = matrix.getRowData(i).getData(j++);

  outS += "<tr align=center bgcolor='" + (i%2 == 0 ? "#FFFFF0" : "#EEEEE0") + "'>" +
          "<td>" + (i+1) + "</td>" +
          "<td>" + confirmStatus + "</td>" +
          "<td>" + confirmDate + "</td>" +
          "<td>" + issueDate + "</td>" +
          "<td><a href=\"javascript:fnView('" + invoiceNo + "')\">" + invoiceNo + "</a></td>" +
          "<td>" + portCountryName + " - " + shippingPortName + "</td>" +
          "<td>" + handoverDate + "</td>" +
          "<td>" + forwarderCountryName + " - " + forwarderName + "</td>" +
          "<td>" + shippingType + "</td>" +
          "<td><a href=\"javascript:fnDownload('" + blFilename + "');\">" + blFilename + "</a></td>" +
          "<td><a href=\"javascript:fnDownload('" + ivFilename + "');\">" + ivFilename + "</a></td>" +
          "<td><a href=\"javascript:fnDownload('" + plFilename + "');\">" + plFilename + "</a></td>" +
          "</tr>";
}

// create year and month options
String optionYears = "";
String optionMonths = "";
int thisYear = Integer.parseInt(DateUtil.getToday("yyyy"));

for (int i = thisYear - 4; i <= thisYear; i++) {
  optionYears += "<option value='" + i + "' " + (ag_year.equals(i + "") ? "selected" : "") +">" + i + "</option>";
}

for (int i = 1; i <= 12; i++) {
  optionMonths += "<option value='" + (i < 10 ? "0" : "") + i + "' "
                + (i == Integer.parseInt(ag_month) ? "selected" : "") + ">"
                + (i < 10 ? "0" : "") + i + "</option>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( scmid ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( optionMonths ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( optionYears ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_invoice_no ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( outS ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( _shipmentFileUrl ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      
out.println(CopyRightLogo());

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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/shipment_list.jsp"), -4744430575102231084L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string5;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string3;
  private final static char []_jsp_string9;
  private final static char []_jsp_string4;
  private final static char []_jsp_string0;
  private final static char []_jsp_string7;
  private final static char []_jsp_string10;
  static {
    _jsp_string5 = "</SELECT></TD>\n  <TD width='12%' class='table_header_center'>Invoice No.</TD>\n  <TD width='20%' class='table_bg_bright'><input type='text' name='ag_invoice_no' value='".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnSearch(frm)\n{\n  frm.ag_invoice_no.value = jf_AllTrim(frm.ag_invoice_no.value);\n  frm.ag_po_no.value = jf_AllTrim(frm.ag_po_no.value);\n  frm.action = './shipment_list.jsp'\n  frm.submit();\n}\n\nfunction fnView(invoice_no) {\n  frmMain.invoice_no.value = invoice_no;\n  frmMain.action = \"./shipment_view.jsp\";\n  frmMain.submit();\n}\n\nfunction fnDownload(file) {\n  with (document.form2) {\n    attachFile.value = file;\n    attachRealFile.value = file;\n    action = '/common/download.jsp';\n    target = 'hiddenFrm';\n    submit();\n  }\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Shipment List</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\">\n<TR>\n  <td><font color=blue>* Please contact our SCM PIC(prerna.j@ffb.net.au) regarding any shipment creation issues.</font></td>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\" class=\"table_bg\">\n<FORM NAME='frmMain' METHOD='POST'>\n<input type='hidden' name='invoice_no'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string6 = "' size='20' maxlength='20'></TD>\n  <TD width='12%' class='table_header_center'>Po No.</TD>\n  <TD width='12%' class='table_bg_bright'><input type='text' name='ag_po_no' value='".toCharArray();
    _jsp_string8 = "\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</FORM>\n<form name='form2' method='post'>\n<input type='hidden' name='attachPath' value='".toCharArray();
    _jsp_string3 = "'>\n<TR>\n  <TD width='12%' class='table_header_center'>Issue Date</TD>\n  <TD width='20%' class='table_bg_bright'><SELECT NAME='ag_month'>".toCharArray();
    _jsp_string9 = "'>\n<input type='hidden' name='attachFile'>\n<input type='hidden' name='attachRealFile'>\n</form>\n</table>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n".toCharArray();
    _jsp_string4 = "</SELECT>\n    <SELECT NAME='ag_year'>".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string7 = "' size='10' maxlength='10'></TD>\n  <td width='12%' class='table_bg_bright_center'><INPUT TYPE='BUTTON' VALUE=\"Search\" ONCLICK='fnSearch(this.form)'></TD>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1400\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\"><tr><td>\n<TABLE width='99%' border=0 CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<TR class='table_header_center'>\n  <TD width='2%'>No.</TD>\n  <TD width='4%'>Confirm<br>Y/N</TD>\n  <TD width='5%'>Confirm<br>Date</TD>\n  <TD width='5%'>Issue<br>Date</TD>\n  <TD width='9%'>Invoice No.</TD>\n  <TD width='12%'>Shipping Port</TD>\n  <TD width='5%'>Handover<br>Date</TD>\n  <TD width='12%'>Nominated Forwarder</TD>\n  <TD width='4%'>Shipping<br>Type</TD>\n  <TD width='14%'>B/L or AWB File</TD>\n  <TD width='14%'>Invoice File</TD>\n  <TD width='14%'>Packing List File</TD>\n</TR>\n".toCharArray();
    _jsp_string10 = "\n</td></tr></table>\n<iframe name='hiddenFrm' src='' width='0' height='0' frameborder='0'></iframe>\n</BODY>\n</HTML>\n".toCharArray();
  }
}
