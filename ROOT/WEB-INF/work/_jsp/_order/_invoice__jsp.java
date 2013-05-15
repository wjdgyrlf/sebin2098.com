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
import java.util.*;
import dbconn.*;
import common.util.*;

public class _invoice__jsp extends com.caucho.jsp.JavaPage
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
      
String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

//for go back list
String ag_brand = request.getParameter("ag_brand");
String ag_po_no = request.getParameter("ag_po_no");
String ag_orderby = request.getParameter("ag_orderby");

String po_no[] = request.getParameterValues("po_no");
String inv_no = request.getParameter("inv_no");
String sdate = DateUtil.getToday("ddMMyyyy");

String po_nos = "";
if (po_no != null) {
  for (int i = 0; i < po_no.length; i++) {
    if (i > 0) po_nos += ",";
    po_nos += "'" + po_no[i] + "'";
  }
}

int tot_qty = 0;
double tot_price_amt = 0.0d;
double tot_air_price_amt = 0.0d;
double tot_amt = 0.0d;

Statement stmt = null;
ResultSet rs   = null;
Connection connScm = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String sql  = "";
int iRet = 0;
String outS = "";

// set sql
sql = " select  a.po_order_no, b.xspo_style, b.vendor_price, b.xspo_air_cost, "
    + "         b.xspo_trans_type, b.xspo_discount, d.total_qty "
    + " from    por5mf4@pronto a "
    + "         inner join xstpu22@pronto b "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         inner join cre5mfi@pronto c "
    + "           on a.cre_accountcode = c.cre_accountcode "
    + "         inner join "
    + "         ( "
    + "           select  a.po_no, sum(b.rec_ttl_qty) total_qty "
    + "           from    packing_01t a, packing_04t b, packing_03t c "
    + "           where   a.po_no in (" + po_nos + ") "
    + "           and     not exists ( select  /*+ PUSH_SUBQ */ 1 "
    + "                                from    invoice_02t g "
    + "                                where   g.po_no = a.po_no "
    + "                                and     g.sup_id = a.supplier_id ) "
    + "           and     a.po_no = b.po_no "
    + "           and     b.po_no = c.po_no "
    + "           and     b.packing_date = c.packing_date "
    + "           and     b.style_no = c.style_no "
    + "           and     b.ctn_no = c.ctn_no "
    + "           and     b.colour = c.colour "
    + "           group by a.po_no "
    + "         ) d "
    + "           on a.po_order_no = d.po_no "
    + " where   a.backorder_flag = ' ' "
    + " and     a.po_order_no in (" + po_nos + ") "
    + " and     a.cre_accountcode = '" + scmid + "' "
    //+ " and     a.po_order_status = '70' "
    + " and     a.po_order_status between '70' and '90' "
    + " and     c.cr_supplier_grp = 'DDP' "
    + " order by a.po_order_no ";
//out.println(sql);

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);
  connScm.commit();

} catch (Exception e) {
  if (connScm != null) {
    try { connScm.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception invoice : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dataProcess.ManipulateData("alter session close database link pronto", connScm);
    dbPool.freeConnection("intranet", connScm);
  }
}

// print out
for (int i = 0; i < iRet; i++) {
  int j = 0;
  String check_pono = matrix.getRowData(i).getData(j++);
  String style_no = matrix.getRowData(i).getData(j++);
  double vendor_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  double air_cost = Double.parseDouble(matrix.getRowData(i).getData(j++));
  String trans_type = matrix.getRowData(i).getData(j++);
  double disc_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  int total_qty = Integer.parseInt(matrix.getRowData(i).getData(j++));

  double net_price = vendor_price - disc_price;
  double net_price_sum = net_price*total_qty;
  double air_price_sum = air_cost*total_qty;
  double amount_sum = (net_price_sum + air_price_sum)*1.1;

  tot_qty += total_qty;
  tot_price_amt += net_price_sum;
  tot_air_price_amt += air_price_sum;
  tot_amt += amount_sum;

  outS += "<tr>"
        + " <td align=center><font size=2><INPUT readonly TYPE=TEXT SIZE=2 NAME=seq VALUE=' "+ (i+1) +"' ></font></td>"
        + " <td align=center><font size=2><INPUT readonly TYPE=TEXT SIZE=6 NAME=check_pono VALUE='" + check_pono + "'></font></td>"
        + " <td align=center><font size=2><input readonly TYPE=TEXT SIZE=6 NAME=a_style_no VALUE='" + style_no + "'></font></td>"
        + " <td align=center><font size=2><INPUT readonly TYPE=TEXT SIZE=5 NAME=a_qty VALUE='" + total_qty + "'></font></td>"
        + " <td align=right ><font size=2><INPUT readonly TYPE=TEXT SIZE=8 NAME=a_price VALUE='" + StringUtil.formatNumber(vendor_price, MONEY_FORMAT) + "'></font></td>"
        + " <td align=right ><font size=2><INPUT readonly TYPE=TEXT SIZE=8 NAME=a_air_price VALUE='" + StringUtil.formatNumber(air_cost, MONEY_FORMAT) + "'></font></td>"
        + " <td align=right ><font size=2><INPUT readonly TYPE=TEXT SIZE=8 NAME=disc_price VALUE='" + StringUtil.formatNumber(disc_price, MONEY_FORMAT) + "'></font></td>"
        + " <td align=right ><font size=2><INPUT readonly TYPE=TEXT SIZE=8 NAME=net_price VALUE='" + StringUtil.formatNumber(net_price, MONEY_FORMAT) + "'></font></td>"
        + " <td align=center><font size=2><INPUT readonly TYPE=TEXT SIZE=2 NAME=trans_type VALUE='"+trans_type+"'></font></td>"
        + " <td align=right ><font size=2>" + StringUtil.formatNumber(net_price_sum, MONEY_FORMAT) + "</font></td>"
        + " <td align=right ><font size=2>" + StringUtil.formatNumber(air_price_sum, MONEY_FORMAT) + "</font></td>"
        + " <td align=right ><font size=2>"+"$" + StringUtil.formatNumber(amount_sum, MONEY_FORMAT) + "</font></td>"
        + "</tr>";
}

outS += "<tr> " +
        "<td bgcolor=e6e6fa align=center > <font size=2>Total </font></td>" +
        "<td bgcolor=e6e6fa align=center >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=center >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=center > <font size=2>" + StringUtil.formatNumber(tot_qty, QTY_FORMAT)   + "</font></td>" +
        "<td bgcolor=e6e6fa align=right  >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=right  >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=right  >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=right  >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=right  >&nbsp;</td>" +
        "<td bgcolor=e6e6fa align=right  ><font size=2>"+"$" + StringUtil.formatNumber(tot_price_amt, MONEY_FORMAT) + "</font></td>" +
        "<td bgcolor=e6e6fa align=right  ><font size=2>"+"$" + StringUtil.formatNumber(tot_air_price_amt, MONEY_FORMAT) + "</font></td>" +
        "<td bgcolor=e6e6fa align=right  ><font size=2>"+"$" + StringUtil.formatNumber(tot_amt, MONEY_FORMAT) + "</font></td>" +
        "</tr>";

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print((sdate));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print((outS));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_brand ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_orderby ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/invoice.jsp"), -279342660909174834L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string8;
  private final static char []_jsp_string2;
  private final static char []_jsp_string0;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string4;
  private final static char []_jsp_string3;
  private final static char []_jsp_string7;
  static {
    _jsp_string8 = "'>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\nfunction Save(form)\n{\n  if (!form.invoice_no.value) {\n    alert('Input Invoice No.');\n    form.invoice_no.focus();\n    return;\n  }\n\n  if (!form.filename.value) {\n    alert('Input valid Attached Invoice File.');\n    return;\n  }\n\n  var idx;\n  var fName = form.filename.value;\n\n  idx = fName.lastIndexOf(\"\\\\\");\n  if (idx < 0) idx = fName.lastIndexOf(\"/\");\n\n  fName = fName.substr(idx+1);\n  idx = fName.lastIndexOf(\".\");\n  if (idx >= 0) fName = fName.substring(0, idx);\n\n  if (form.invoice_no.value != fName) {\n    alert('The attached invoice file name should be same as the invoice no.\\nCheck the Attached Invoice File.');\n    return;\n  }\n\n  if (confirm('Do you want to save this invoice?')) {\n    form.action = 'invoice_update.jsp';\n    form.submit();\n  }\n}\n\nfunction ValidateCharacters(Value)\n{\n  bRetVal=true;\n\n  for (i=0; i<Value.length; i++)\n  {\n    if ('1234567890.'.lastIndexOf(Value.substr(i,1))==-1)\n    {\n      bRetVal=false;\n    }\n  }\n\n  return bRetVal;\n}\n\nfunction Back(form)\n{\n  form.action  = \"invoice_confirm_search.jsp\";\n  form.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Sending invoices</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"95%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<FORM NAME=frmMain METHOD=POST enctype=\"multipart/form-data\">\n<tr>\n  <td width=\"100%\"><font color=red>* Please ensure that the 'Attached Invoice File' name is the same as the invoice number\n    <br>eg. Invoice Number &quot;00018201&quot; - File name &quot;00018201.pdf&quot;.\n    <br>* Invoice date will be based on the date recorded in the SCM system unless a later date is indicated on the invoice.</font><br></td>\n</tr>\n</table>\n\n<TABLE width=95% border=1 align='center'>\n<tr>\n<TD width='21%' align=center><FONT size=2>Invoice No </FONT></TD>\n<td width='29%'><font color=#0000FF size=2 ><INPUT TYPE=TEXT size=15 maxlength='10' NAME='invoice_no' VALUE=''></font>\n  <font color='red'>(Max Length : 10)</font></td>\n<TD width='25%' align=center><FONT size=2>Issue Date(ddmmyyyy)</FONT></TD>\n<td width='25%'><font color=#0000FF size=2 ><INPUT TYPE=TEXT size=10 readonly NAME=invoice_date VALUE='".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n".toCharArray();
    _jsp_string5 = "\n</td></tr></table>\n<form name='form1' method='post'>\n<input type='hidden' name='ag_brand' value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string4 = "\n<tr> <td colspan=12 align=center>\n<INPUT TYPE=BUTTON VALUE=Save   ONCLICK=JavaScript:Save(document.frmMain)>\n<INPUT TYPE=BUTTON VALUE=Back   ONCLICK=JavaScript:Back(document.form1)>\n</td></tr>\n</TABLE>\n</FORM>\n".toCharArray();
    _jsp_string3 = "'></font></td>\n</tr>\n<tr>\n<td align=center> <font size=2 > Attached Invoice File </font></td>\n<td colspan=\"3\"> <font size=2><INPUT TYPE=FILE  NAME=filename SIZE=60></font> </td>\n</tr>\n</TABLE>\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</table>\n<table width=\"95%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><B>Invoice Detail List</B></td>\n</tr>\n</table>\n<TABLE width=95% border=1 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR>\n<TD align=center bgcolor='#d3d3d3'>Seq</TD>\n<TD align=center bgcolor='#d3d3d3'>PO#</TD>\n<TD align=center bgcolor='#d3d3d3'>Item#</TD>\n<TD align=center bgcolor='#d3d3d3'>Qty</TD>\n<TD align=center bgcolor='#d3d3d3'> Unit Price </TD>\n<TD align=center bgcolor='#d3d3d3'> Air Price </TD>\n<TD align=center bgcolor='#d3d3d3'> D/C Price </TD>\n<TD align=center bgcolor='#d3d3d3'> Net Price </TD>\n<TD align=center bgcolor='#d3d3d3'>Shipping Type</TD>\n<TD align=center bgcolor='#d3d3d3'> Unit Price SUM </TD>\n<TD align=center bgcolor='#d3d3d3'> Air Price SUM </TD>\n<TD align=center bgcolor='#d3d3d3'> Amount (GST Inc) </TD>\n</TR>\n".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='ag_orderby' value='".toCharArray();
  }
}
