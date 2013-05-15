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

public class _invoice_0issue_0form__jsp extends com.caucho.jsp.JavaPage
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

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
String MONEY_FORMAT = "###,##0.00";
String MONEY_FORMAT2 = "#####0.00";
String today = DateUtil.getToday("dd/MM/yyyy");

int iRet = 0;
Connection connScm = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;
String outS = "";
String sql = "";

String ag_brand = request.getParameter("ag_brand");
String ag_pono = request.getParameter("ag_pono");
String ag_orderby = request.getParameter("ag_orderby");
String[] po_no = request.getParameterValues("po_no");

int total_qty = 0;
int total_box_qty = 0;
double total_amount = 0.0d;

// set sql
String tmp_po_no2 = "";
for (int i = 0; i < po_no.length; i++) {
  if (i > 0) {
    tmp_po_no2 += ",";
  }

  tmp_po_no2 += "'" + po_no[i] + "'";
}

// read data
sql = " select  b.xspo_style, a.po_order_no, b.vendor_price, "
    + "         case "
    + "           when to_char(a.po_order_date, 'yyyymmdd') between '20090101' and '20090630' "
    + "             then round(b.vendor_price*" + _MURate + ", 2) "
    + "           else 0 "
    + "         end, "
    + "         b.xspo_discount, "
    + "         c.cr_shortname, d.shm_description, "
    + "         nvl(e.qty, 0), nvl(e.box_qty, 0) "
    + " from    por5mf4@pronto a "
    + "         inner join xstpu22@pronto b "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         inner join cre5mfi@pronto c "
    + "           on a.cre_accountcode = c.cre_accountcode "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, y.shm_description "
    + "           from   stkhierachymst0@pronto y "
    + "                  inner join stkhiertree3@pronto z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) d "
    + "           on b.xspo_stock_group = d.stock_group "
    + "         inner join "
    + "         ( "
    + "           select  po_no, sum(ttl_qty) qty, sum(to_number(ctn_qty)) box_qty "
    + "           from    packing_03t "
    + "           where   po_no in (" + tmp_po_no2 + ") "
    + "           group by po_no "
    + "         ) e "
    + "           on a.po_order_no = e.po_no "
    + "         inner join nad5mfa@pronto f "
    + "           on c.cre_accountcode = f.accountcode "
    + " where   a.backorder_flag = ' ' "
    + " and     a.po_order_status between '40' and '42' "
    + " and     not exists ( "
    + "           select  1 "
    + "           from    invoice_apess_02t i "
    + "           where   i.po_no = a.po_order_no ) "
    + " and     f.na_type = 'C' "
    + " and     f.na_country_code in "
    + "         ( "
    + "           select  supplier_class "
    + "           from    user_supplier_02t "
    + "           where   user_type = '" + usertype + "' "
    + "           and     invoice_issue_yn = 'Y' "
    + "         ) "
    + " order by 2 ";
//out.println(sql);


try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  // read data
  iRet = dataProcess.RetrieveData(sql, matrix, connScm);
  connScm.commit();

} catch (Exception e) {
  if (connScm != null) {
    try { connScm.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception invoice_issue_form : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dataProcess = new DataProcess();
    dataProcess.ManipulateData("alter session close database link pronto", connScm);
    dbPool.freeConnection("intranet", connScm);
  }
}

for (int i = 0; i < iRet; i++) {
  int j = 0;
  String style_no = matrix.getRowData(i).getData(j++);
  String tmp_po_no = matrix.getRowData(i).getData(j++);
  double currency_unit_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  double currency_add_cost2 = Double.parseDouble(matrix.getRowData(i).getData(j++));
  double disc_price = Double.parseDouble(matrix.getRowData(i).getData(j++));
  String supplier = matrix.getRowData(i).getData(j++);
  String origin = matrix.getRowData(i).getData(j++);
  int qty = Integer.parseInt(matrix.getRowData(i).getData(j++));
  int box_qty = Integer.parseInt(matrix.getRowData(i).getData(j++));

  double unit_price = currency_unit_price + currency_add_cost2;
  double net_price = unit_price - disc_price;
  double amount = net_price*qty;
  total_qty += qty;
  total_box_qty += box_qty;
  total_amount += amount;

  String categoryOptions = "<select name='category'>"
    + "<option></option>"
    + "<option value='KNIT'>KNIT</option>"
    + "<option value='WOVEN'>WOVEN</option>"
    + "</select>";

  outS += "<tr align=center bgcolor='" + (i%2 == 0 ? "#FFFFF0" : "#EEEEE0") + "'>" +
          "<td>" + style_no + "<input type='hidden' name='style_no' value='" + style_no + "'></td>" +
          "<td>" + tmp_po_no + "<input type='hidden' name='po_no' value='" + tmp_po_no + "'></td>" +
          "<td><input type='text' id='description" + i + "' name='description' size='24' maxlength='50' onclick='fnAutoComplete(this);'></td>" +
          "<td><input type='text' name='content' size='30' maxlength='100'></td>" +
          "<td>" + categoryOptions + "</td>" +
          "<td><input type='text' name='qty' value='" + qty + "' size='6' maxlength='6' style='text-align:right;' onkeypress='return jf_EventNumberCheck();' onblur='fnQtyChange(this);'></td>" +
          "<td><input type='text' name='box_qty' value='" + box_qty + "' size='6' maxlength='4' style='text-align:right;' onkeypress='return jf_EventNumberCheck();' onblur='fnBoxQtyChange(this);'></td>" +
          "<td align='right'>" + StringUtil.formatNumber(unit_price, MONEY_FORMAT) +
          "<input type='hidden' name='unit_price' value='" + currency_unit_price + "'>" +
          "<input type='hidden' name='add_cost' value='" + currency_add_cost2 + "'>" +
          "<input type='hidden' name='disc_price' value='" + disc_price + "'></td>" +
          "<td align='right'>" + StringUtil.formatNumber(disc_price, MONEY_FORMAT) + "</td>" +
          "<td align='right'>" + StringUtil.formatNumber(net_price, MONEY_FORMAT) + "</td>" +
          "<td><input type='text' name='amount' value='" + StringUtil.formatNumber(amount, MONEY_FORMAT2) + "' size='10' maxlength='10' readonly style='background-color:#e8e8e8;text-align:right;'></td>" +
          "<td align='left'>" + supplier + "<input type='hidden' name='remarks' value=\"" + supplier + "\"></td>" +
          "<td>" + origin + "<input type='hidden' name='brand' value='" + origin + "'></td>" +
          "<td><input type='text' name='remarks2' size='18' maxlength='100'></td>" +
          "</tr>" ;
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ag_brand ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_pono ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_orderby ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( today ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( outS ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( total_qty ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( total_box_qty ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( StringUtil.formatNumber(total_amount, MONEY_FORMAT2) ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( ag_brand ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_pono ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_orderby ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string13, 0, _jsp_string13.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/invoice_issue_form.jsp"), -1928332913378629903L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/login_check.jsp"), 3743346625025852725L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/calendar/calendar.htm"), 2970746783289767368L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string12;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string8;
  private final static char []_jsp_string1;
  private final static char []_jsp_string13;
  private final static char []_jsp_string11;
  private final static char []_jsp_string7;
  private final static char []_jsp_string6;
  private final static char []_jsp_string9;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string10;
  private final static char []_jsp_string5;
  static {
    _jsp_string12 = "'>\n</form>\n</table>\n".toCharArray();
    _jsp_string3 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<script type=\"text/javascript\" src=\"/common/js/bsn.AutoSuggest_2.1.3.js\" charset=\"utf-8\"></script>\n<link rel=\"stylesheet\" href=\"/common/css/autosuggest_inquisitor.css\" type=\"text/css\" media=\"screen\" charset=\"utf-8\" />\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnAutoComplete(obj) {\n  var options = {\n    script:\"./invoice_description_list.jsp?\",\n    shownoresults:false,\n    maxresults:100\n  };\n\n  var as = new bsn.AutoSuggest(obj.id, options);\n}\n\nfunction fnQtyChange(obj) {\n  if (!fnCheckNum(obj)) {\n    return;\n  }\n\n  if (obj.form.po_no.length) {\n    // set amount\n    var idx = 0;\n    var unitPrice = 0;\n    var tmpAmount = 0;\n    \n    for (i = 0; i < obj.form.po_no.length; i++) {\n      if (obj.form.qty[i] == obj) {\n        idx = i;\n        break;\n      }\n    }\n\n    // to avoid floating problem\n    unitPrice = Math.round((parseFloat(obj.form.unit_price[idx].value)\n                  + parseFloat(obj.form.add_cost[idx].value)\n                  - parseFloat(obj.form.disc_price[idx].value))*100);\n    tmpAmount = parseInt(obj.value)*unitPrice;\n    obj.form.amount[idx].value = parseInt(tmpAmount/100 + \"\") + \".\"\n                                 + (tmpAmount%100 >= 10 ? \"\" + tmpAmount%100 : \"0\" + tmpAmount%100);\n\n    // set total qty and amount\n    var totalQty = 0;\n    var totalAmount = 0;\n    \n    for (i = 0; i < obj.form.po_no.length; i++) {\n      totalQty += parseInt(obj.form.qty[i].value);\n      totalAmount += Math.round(parseFloat(obj.form.amount[i].value)*100);\n    }\n\n    obj.form.total_qty.value = totalQty;\n    obj.form.total_amount.value = parseInt(totalAmount/100 + \"\") + \".\"\n                                  + (totalAmount%100 >= 10 ? \"\" + totalAmount%100 : \"0\" + totalAmount%100);\n  } else {\n    // set amount\n    var unitPrice = 0;\n    var tmpAmount = 0;\n\n    // to avoid floating problem\n    unitPrice = Math.round((parseFloat(obj.form.unit_price.value)\n                  + parseFloat(obj.form.add_cost.value)\n                  - parseFloat(obj.form.disc_price.value))*100);\n    tmpAmount = parseInt(obj.value)*unitPrice;\n    obj.form.amount.value = parseInt(tmpAmount/100 + \"\") + \".\"\n                                 + (tmpAmount%100 >= 10 ? \"\" + tmpAmount%100 : \"0\" + tmpAmount%100);\n\n    // set total qty and amount\n    obj.form.total_qty.value = obj.form.qty.value;\n    obj.form.total_amount.value = obj.form.amount.value;\n  }\n}\n\nfunction fnBoxQtyChange(obj) {\n  if (!fnCheckNum(obj)) {\n    return;\n  }\n\n  // set total box qty\n  if (obj.form.po_no.length) {\n    var totalBoxQty = 0;\n    \n    for (i = 0; i < obj.form.po_no.length; i++) {\n      totalBoxQty += parseInt(obj.form.box_qty[i].value);\n    }\n\n    obj.form.total_box_qty.value = totalBoxQty;\n  } else {\n    obj.form.total_box_qty.value = obj.form.box_qty.value;\n  }\n}\n\nfunction fnCheckNum(obj) {\n  if (!jf_IsNumeric(obj.value)) {\n    alert(\"The input data is not valid.\\nThe input data should be numbers. Check your data.\");\n    obj.select();\n    return false;\n  }\n\n  return true;\n}\n\nfunction fnSave(frm)\n{\n  // validata header\n  if (frm.ship_via_01.selectedIndex == 0) {\n    alert('Input SHIP VIA.');\n    frm.ship_via_01.focus();\n    return;\n  }\n\n  if (frm.ship_via_02.selectedIndex == 0) {\n    alert('Input SHIP VIA.');\n    frm.ship_via_02.focus();\n    return;\n  }\n\n  if (!frm.ship_date.value) {\n    alert('Input SHIP DATE.');\n    return;\n  }\n\n  // validate detail list\n  if (frm.po_no.length) {\n    for (var i = 0; i < frm.po_no.length; i++) {\n      frm.content[i].value = frm.content[i].value.replace(/^\\s*/, \"\").replace(/\\s*$/, \"\");\n\n      if (!frm.description[i].value) {\n        alert('Input DESCRIPTION.');\n        frm.description[i].focus();\n        return;\n      }\n\n      if (!frm.content[i].value) {\n        alert('Input CONTENT.');\n        frm.content[i].focus();\n        return;\n      }\n\n      if (frm.category[i].selectedIndex == 0) {\n        alert('Input CATEGORY.');\n        frm.category[i].focus();\n        return;\n      }\n\n      if (frm.qty[i].value == \"0\") {\n        alert('Input QTY.');\n        frm.qty[i].select();\n        return;\n      }\n\n      if (frm.box_qty[i].value == \"0\") {\n        alert('Input BOX QTY.');\n        frm.box_qty[i].select();\n        return;\n      }\n    }\n  } else {\n    frm.content.value = frm.content.value.replace(/^\\s*/, \"\").replace(/\\s*$/, \"\");\n\n    if (!frm.description.value) {\n      alert('Input DESCRIPTION.');\n      frm.description.focus();\n      return;\n    }\n\n    if (!frm.content.value) {\n      alert('Input CONTENT.');\n      frm.content.focus();\n      return;\n    }\n\n    if (frm.category.selectedIndex == 0) {\n      alert('Input CATEGORY.');\n      frm.category.focus();\n      return;\n    }\n\n    if (frm.qty.value == \"0\") {\n      alert('Input QTY.');\n      frm.qty.select();\n      return;\n    }\n\n    if (frm.box_qty.value == \"0\") {\n      alert('Input BOX QTY.');\n      frm.box_qty.select();\n      return;\n    }\n  }\n\n  if (confirm('Do you want to save this invoice?')) {\n    frm.action = './invoice_issue_save.jsp'\n    frm.submit();\n  }\n}\n\nfunction fnBack(frm) {\n  frm.action = './invoice_issue_list.jsp';\n  frm.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Invoice Creation</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Invoice Header</b></td>\n</tr>\n</table>\n<TABLE WIDTH='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\" class=\"table_bg\">\n<FORM NAME='frmMain' METHOD='POST'>\n<input type='hidden' name='ag_brand' value='".toCharArray();
    _jsp_string2 = "\n<Div id='popCal' style='POSITION:absolute;visibility:hidden;border:1px ridge;width:10'>\n  <iframe name=\"popFrame\" src=\"/common/calendar/popcjs.htm\" frameborder=\"0\" style=\"border:1 solid #EBF6FD\"  frameborder=\"0\" scrolling=\"no\" width=176 height=215>\n  </iframe>\n</DIV>\n<!--SCRIPT event=onclick() for=document>document.all['popCal'].style.visibility = \"hidden\";</SCRIPT-->\n<script language='javascript'>\nfunction setVisibility() {\n  document.all['popCal'].style.visibility = 'hidden';\n}\n\ndocument.onclick = setVisibility;\n</script>\n".toCharArray();
    _jsp_string8 = "\n<tr class='table_header_center'>\n  <td colspan='3'>TOTAL</td>\n  <td></td>\n  <td></td>\n  <td><input type='text' name='total_qty' value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string13 = "\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string11 = "' size='10' readonly style='background-color:#e8e8e8;text-align:right;'></td>\n  <td></td>\n  <td></td>\n  <td></td>\n</tr>\n</TABLE>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n<tr>\n  <td width=\"100%\">\n    <input type='button' value='Save' onclick='fnSave(this.form);'>\n    <input type='button' value='Back' onclick='fnBack(document.form2);'>\n  </td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</FORM>\n<form name='form2' method='post'>\n<input type='hidden' name='ag_brand' value='".toCharArray();
    _jsp_string7 = "' size='10' readonly style='background-color:#e8e8e8'></TD>\n  <TD width='10%' class='table_header_center'>CURRENCY</TD>\n  <TD width='15%' class='table_bg_bright'><input type='text' name='currency' value='USD' size='10' readonly style='background-color:#e8e8e8'></TD>\n  <TD width='10%' class='table_header_center'>SHIP VIA</TD>\n  <TD width='15%' class='table_bg_bright'><select name='ship_via_01'>\n    <option></option>\n    <option value='AIR'>AIR</option>\n    <option value='SEA'>SEA</option>\n    </select> -\n    <select name='ship_via_02'>\n    <option></option>\n    <option value='CC'>CC</option>\n    <option value='DP'>DP</option>\n    </select></TD>\n</TR>\n<TR>\n  <TD class='table_header_center'>CODITION</TD>\n  <TD class='table_bg_bright'><input type='text' name='condition' value='FOB' size='10' readonly style='background-color:#e8e8e8'></TD>\n  <TD class='table_header_center'>ORIGIN</TD>\n  <TD class='table_bg_bright'><input type='text' name='origin' value='CHINA' size='10' readonly style='background-color:#e8e8e8'></TD>\n  <TD class='table_header_center'>SHIP DATE</TD>\n  <TD class='table_bg_bright'><input type='text' name='ship_date' size='10' value='' style='cursor:hand'\n    readonly onclick=\"javascript:popFrame.fPopCalendar(this, this, document.all['popCal'], 'RIGHT', event);\"></TD>\n  <TD class='table_header_center'>TERMS</TD>\n  <TD class='table_bg_bright'><input type='text' name='terms' value='TT' size='10' readonly style='background-color:#e8e8e8'></TD>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1220\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\"><b>Invoice Detail List</b></td>\n</tr>\n</table>\n<TABLE width='99%' border=0 CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<TR class='table_header_center'>\n  <TD width='4%'>STYLE#</TD>\n  <TD width='4%'>PO NO.</TD>\n  <TD width='13%'>DESCRIPTION</TD>\n  <TD width='16%'>CONTENT</TD>\n  <TD width='6%'>CATEGORY</TD>\n  <TD width='5%'>QTY</TD>\n  <TD width='5%'>BOX QTY</TD>\n  <TD width='4%'>U/P</TD>\n  <TD width='4%'>D/P</TD>\n  <TD width='4%'>N/P</TD>\n  <TD width='7%'>AMOUNT</TD>\n  <TD width='12%'>SUPPLIER</TD>\n  <TD width='6%'>BRAND</TD>\n  <TD width='10%'>REMARKS</TD>\n</TR>\n".toCharArray();
    _jsp_string6 = "'>\n<TR>\n  <TD width='10%' class='table_header_center'>INVOICE NO</TD>\n  <TD width='15%' class='table_bg_bright'><input type='text' name='invoice_no' size='15' readonly style='background-color:#e8e8e8'></TD>\n  <TD width='12%' class='table_header_center'>CREATED DATE</TD>\n  <TD width='13%' class='table_bg_bright'><input type='text' name='invoice_date' value='".toCharArray();
    _jsp_string9 = "' size='6' readonly style='background-color:#e8e8e8;text-align:right;'></td>\n  <td><input type='text' name='total_box_qty' value='".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string4 = "'>\n<input type='hidden' name='ag_pono' value='".toCharArray();
    _jsp_string10 = "' size='6' readonly style='background-color:#e8e8e8;text-align:right;'></td>\n  <td></td>\n  <td></td>\n  <td></td>\n  <td><input type='text' name='total_amount' value='".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='ag_orderby' value='".toCharArray();
  }
}
