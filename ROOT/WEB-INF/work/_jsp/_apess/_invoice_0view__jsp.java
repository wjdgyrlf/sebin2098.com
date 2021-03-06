/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._apess;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import dbconn.*;
import common.util.*;

public class _invoice_0view__jsp extends com.caucho.jsp.JavaPage
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

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

int iRet = 0;
Connection conn = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String outS = "";
String sql = "";

String M = request.getParameter("M");
String ag_month = request.getParameter("ag_month");
String ag_year = request.getParameter("ag_year");
String ag_invoice_no = request.getParameter("ag_invoice_no");
String invoice_no = request.getParameter("invoice_no");
String supplier_id = request.getParameter("supplier_id");   // for admin

if (M == null) M = "";
if (ag_month == null) ag_month = "";
if (ag_year == null) ag_year = "";
if (ag_invoice_no == null) ag_invoice_no = "";
if (invoice_no == null) invoice_no = "";
if (supplier_id == null) supplier_id = scmid;

String invoice_date = "";
String currency = "";
String ship_via_01 = "";
String ship_via_02 = "";
String condition = "";
String origin = "";
String ship_date = "";
String terms = "";
int total_qty = 0;
int total_box_qty = 0;
double total_amount = 0.0d;
boolean isEditable = false;

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  conn = dbPool.getConnection("intranet");

  isEditable = true;

  // read invoice header
  sql = " select  to_char(invoice_date, 'dd/mm/yyyy'), currency, ship_via_01, ship_via_02, "
      + "         condition, origin, to_char(ship_date, 'dd/mm/yyyy'), terms "
      + " from    invoice_apess_01t "
      + " where   invoice_no = '" + invoice_no + "' "
      + " and     supplier_id = '" + supplier_id + "' ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  if (iRet > 0) {
    int j = 0;
    invoice_date = matrix.getRowData(0).getData(j++);
    currency = matrix.getRowData(0).getData(j++);
    ship_via_01 = matrix.getRowData(0).getData(j++);
    ship_via_02 = matrix.getRowData(0).getData(j++);
    condition = matrix.getRowData(0).getData(j++);
    origin = matrix.getRowData(0).getData(j++);
    ship_date = matrix.getRowData(0).getData(j++);
    terms = matrix.getRowData(0).getData(j++);
  }

  // read invoice details
  sql = " select  b.style_no, b.po_no, b.description, b.content, b.category, b.qty, "
      + "         b.box_qty, b.unit_price, b.add_cost, b.disc_price, b.remarks, b.brand, b.remarks2 "
      + " from    invoice_apess_01t a, invoice_apess_02t b "
      + " where   a.invoice_no = '" + invoice_no + "' "
      + " and     a.supplier_id = '" + supplier_id + "' "
      + " and     a.invoice_no = b.invoice_no "
      + " order by b.po_no ";

  //out.println(sql);
  iRet = dataProcess.RetrieveData(sql, matrix, conn);

} catch (Exception e) {
  System.out.println("Exception invoice_view : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) {
    dbPool.freeConnection("intranet", conn);
  }
}

for (int i = 0; i < iRet; i++) {
  int j = 0;
  String style_no = matrix.getRowData(i).getData(j++);
  String po_no = matrix.getRowData(i).getData(j++);
  String description = matrix.getRowData(i).getData(j++);
  String content = matrix.getRowData(i).getData(j++);
  String category = matrix.getRowData(i).getData(j++);
  int qty = Integer.parseInt(matrix.getRowData(i).getData(j++));
  int box_qty = Integer.parseInt(matrix.getRowData(i).getData(j++));
  double unit_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  double add_cost = Double.parseDouble(matrix.getRowData(i).getData(j++));
  double disc_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  String remarks = matrix.getRowData(i).getData(j++);
  String brand = matrix.getRowData(i).getData(j++);
  String remarks2 = matrix.getRowData(i).getData(j++);

  if ( (usertype.startsWith("C") && usergroup.equals("S"))
       || (usertype.startsWith("C") && usergroup.equals("A") && M.equals("Y")) ) {
    unit_price += add_cost;
  }

  double net_price = unit_price - disc_price;
  double amount = net_price*qty;

  total_qty += qty;
  total_box_qty += box_qty;
  total_amount += amount;

  outS += "<tr align=center bgcolor='" + (i%2 == 0 ? "#FFFFF0" : "#EEEEE0") + "'>" +
          "<td>" + style_no + "</td>" +
          "<td>" + po_no + "</td>" +
          "<td align='left'>" + description + "</td>" +
          "<td align='left'>" + content + "</td>" +
          "<td>" + category + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(qty, QTY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(box_qty, QTY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(unit_price, MONEY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(disc_price, MONEY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(net_price, MONEY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(amount, MONEY_FORMAT) + "</td>" +
          "<td align='left'>" + remarks + "</td>" +
          "<td>" + brand + "</td>" +
          "<td align='left'>" + remarks2 + "</td>" +
          "</tr>" ;
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
if ( isEditable && ( (usertype.startsWith("C") && usergroup.equals("S"))
                     || (usertype.startsWith("C") && usergroup.equals("A") && M.equals("Y")) ) ) {

      out.write(_jsp_string3, 0, _jsp_string3.length);
      
}

      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( (usertype.startsWith("C") && usergroup.equals("A") && M.equals("Y")) ? "+" : "" ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( M ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_month ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_year ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( ag_invoice_no ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( invoice_no ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( supplier_id ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( invoice_no ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( invoice_date ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( currency ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( ship_via_01 ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( ship_via_02 ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( condition ));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( origin ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( ship_date ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( terms ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( outS ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( StringUtil.formatNumber(total_qty, QTY_FORMAT) ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print(( StringUtil.formatNumber(total_box_qty, QTY_FORMAT) ));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print(( StringUtil.formatNumber(total_amount, MONEY_FORMAT) ));
      out.write(_jsp_string24, 0, _jsp_string24.length);
      
if ( isEditable && ( (usertype.startsWith("C") && usergroup.equals("S"))
                     || (usertype.startsWith("C") && usergroup.equals("A") && M.equals("Y")) ) ) {

      out.write(_jsp_string25, 0, _jsp_string25.length);
      
}

      out.write(_jsp_string26, 0, _jsp_string26.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string27, 0, _jsp_string27.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/invoice_view.jsp"), -6518299597495201251L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/login_check.jsp"), 3743346625025852725L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string7;
  private final static char []_jsp_string17;
  private final static char []_jsp_string2;
  private final static char []_jsp_string19;
  private final static char []_jsp_string3;
  private final static char []_jsp_string16;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string26;
  private final static char []_jsp_string9;
  private final static char []_jsp_string27;
  private final static char []_jsp_string25;
  private final static char []_jsp_string11;
  private final static char []_jsp_string21;
  private final static char []_jsp_string22;
  private final static char []_jsp_string12;
  private final static char []_jsp_string23;
  private final static char []_jsp_string24;
  private final static char []_jsp_string18;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string4;
  private final static char []_jsp_string20;
  private final static char []_jsp_string15;
  private final static char []_jsp_string0;
  private final static char []_jsp_string14;
  private final static char []_jsp_string13;
  private final static char []_jsp_string10;
  static {
    _jsp_string7 = "'>\n<input type='hidden' name='ag_year' value='".toCharArray();
    _jsp_string17 = "</TD>\n  <TD class='table_header_center'>ORIGIN</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\n".toCharArray();
    _jsp_string19 = "</TD>\n  <TD class='table_header_center'>TERMS</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string3 = "\nfunction fnEdit(frm)\n{\n  frm.target = self.name;\n  frm.action = './invoice_edit_form.jsp'\n  frm.submit();\n}\n\nfunction fnDelete(frm)\n{\n  if (confirm('Do you want to delete this invoice?')) {\n    frm.target = self.name;\n    frm.action = './invoice_delete.jsp'\n    frm.submit();\n  }\n}\n".toCharArray();
    _jsp_string16 = "</TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>CODITION</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string5 = "</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Invoice Header</b></td>\n</tr>\n</table>\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\" class=\"table_bg\">\n<FORM NAME='frmMain' METHOD='POST'>\n<input type='hidden' name='M' value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string26 = "\n    <input type='button' value=' Print ' onclick='fnPrint(this.form);'>\n    <input type='button' value='Go To List' onclick='fnList(this.form);'>\n  </td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</FORM>\n</table>\n".toCharArray();
    _jsp_string9 = "'>\n<input type='hidden' name='invoice_no' value='".toCharArray();
    _jsp_string27 = "\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string25 = "\n    <input type='button' value=' Edit ' onclick='fnEdit(this.form);'>\n    <input type='button' value=' Delete ' onclick='fnDelete(this.form);'>\n".toCharArray();
    _jsp_string11 = "'>\n<TR>\n  <TD width='10%' class='table_header_center'>INVOICE NO</TD>\n  <TD width='15%' class='table_bg_bright'>".toCharArray();
    _jsp_string21 = "\n<tr class='table_header_center'>\n  <td colspan='3'>TOTAL</td>\n  <td></td>\n  <td></td>\n  <td align='right'>".toCharArray();
    _jsp_string22 = "</td>\n  <td align='right'>".toCharArray();
    _jsp_string12 = "</TD>\n  <TD width='12%' class='table_header_center'>CREATED DATE</TD>\n  <TD width='13%' class='table_bg_bright'>".toCharArray();
    _jsp_string23 = "</td>\n  <td></td>\n  <td></td>\n  <td></td>\n  <td align='right'>".toCharArray();
    _jsp_string24 = "</td>\n  <td></td>\n  <td></td>\n  <td></td>\n</tr>\n</TABLE>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n<tr>\n  <td width=\"100%\">\n".toCharArray();
    _jsp_string18 = "</TD>\n  <TD class='table_header_center'>SHIP DATE</TD>\n  <TD class='table_bg_bright'>".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='ag_month' value='".toCharArray();
    _jsp_string8 = "'>\n<input type='hidden' name='ag_invoice_no' value='".toCharArray();
    _jsp_string4 = "\n\nfunction fnPrint(frm)\n{\n  var win_print = window.open(\"\",\"win_print\", \"toolbar=no, menubar=no, resizable=no, scrollbars=yes, width=1200, height=700\");\n\n  if (win_print) {\n    frm.target = win_print.name;\n    frm.action = './invoice_print.jsp'\n    frm.submit();\n    win_print.focus();\n  }\n}\n\nfunction fnList(frm) {\n  frm.target = self.name;\n  frm.action = './invoice_list.jsp';\n  frm.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Invoice Detail".toCharArray();
    _jsp_string20 = "</TD>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1220\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Invoice Detail List</b></td>\n</tr>\n</table>\n<TABLE width='99%' border=0 CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<TR class='table_header_center'>\n  <TD width='4%'>STYLE#</TD>\n  <TD width='4%'>PO NO.</TD>\n  <TD width='13%'>DESCRIPTION</TD>\n  <TD width='16%'>CONTENT</TD>\n  <TD width='6%'>CATEGORY</TD>\n  <TD width='5%'>QTY</TD>\n  <TD width='5%'>BOX QTY</TD>\n  <TD width='4%'>U/P</TD>\n  <TD width='4%'>D/P</TD>\n  <TD width='4%'>N/P</TD>\n  <TD width='7%'>AMOUNT</TD>\n  <TD width='12%'>SUPPLIER</TD>\n  <TD width='6%'>BRAND</TD>\n  <TD width='10%'>REMARKS</TD>\n</TR>\n".toCharArray();
    _jsp_string15 = " - ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string14 = "</TD>\n  <TD width='10%' class='table_header_center'>SHIP VIA</TD>\n  <TD width='15%' class='table_bg_bright'>".toCharArray();
    _jsp_string13 = "</TD>\n  <TD width='10%' class='table_header_center'>CURRENCY</TD>\n  <TD width='15%' class='table_bg_bright'>".toCharArray();
    _jsp_string10 = "'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
  }
}
