/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._order;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import dbconn.*;
import common.util.*;

public class _po_0amend_0detail__jsp extends com.caucho.jsp.JavaPage
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
      
String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

String po_no_selected = request.getParameter("po_no_selected");
String date_selected = request.getParameter("date_selected");
String ag_supplier = request.getParameter("ag_supplier");
String ag_po_no = request.getParameter("ag_po_no");
String ag_style_no = request.getParameter("ag_style_no");
String ag_from_date = request.getParameter("ag_from_date");
String ag_to_date = request.getParameter("ag_to_date");

if (po_no_selected == null) po_no_selected = "";
if (date_selected == null) date_selected = "";
if (ag_supplier == null) ag_supplier = "";
if (ag_po_no == null) ag_po_no = "";
if (ag_style_no == null) ag_style_no = "";
if (ag_from_date == null) ag_from_date = "";
if (ag_to_date == null) ag_to_date = "";

Connection connPronto = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.MatrixDataSet matrix3 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";
String sql2 = "";
String sql3 = "";
int iRet = 0;
int iRet2 = 0;
int iRet3 = 0;
String outS = "";
String outS2 = "";
String outS3 = "";

// declare variables
String po_no = "";
String style_no = "";
String buyer = "";
String order_type = "";
String supplier_name = "";
String currency_type = "";
String ratio_group_desc = "";
String po_no_cancell = "";
int colour_qty_cnt = 0;
int others_cnt = 0;

String[] size_label = null;
String size_labels = "";

// query for cancel, colour or qty, others
sql = " select  a.po_order_no, "
    + "         b.xspo_style, "
    + "         nvl(f.sys_description, a.po_user_name), "
    + "         b.xspo_order_type, "
    + "         e.cr_shortname, "
    + "         decode(a.po_currency_code, ' ', 'AUD', a.po_currency_code), "
    + "         nvl(g.srg_desc, b.ratio_group_code), "
    + "         c.po_order_no, "
    + "         nvl(d.colour_qty_cnt, 0), "
    + "         nvl(d.others_cnt, 0) "
    + " from    por5mf4 a "
    + "         inner join xstpu22 b "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         left outer join  "
    + "         ( "
    + "           select  po_order_no, "
    + "                   backorder_flag "
    + "           from    por5log7 "
    + "           where   po_order_no = " + po_no_selected
    + "           and     backorder_flag = ' '  "
    + "           and     ordlog_type = 5  "
    + "           and     ordlog_old_info = '40'  "
    + "           and     order_log_date = to_date('" + date_selected + "', 'dd/mm/yyyy') "
    + "         ) c "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         left outer join "
    + "         ( "
    + "           select  xpoa_po_order_no, "
    + "                   backorder_flag, "
    + "                   count( "
    + "                     case "
    + "                       when xpoa_change_type in ('ZERCL', 'ADDCL', 'DELCL', 'QTYCL', 'RATIO') then xpoa_change_type "
    + "                     end "
    + "                   ) colour_qty_cnt, "
    + "                   count( "
    + "                     case "
    + "                       when xpoa_change_type in ('TRANS', 'POTYP', 'VENPR', 'AIRCS', 'DUEDT', 'GROUP', 'FABRC', "
    + "                            'RATGR', 'LENTH', 'RCPTX', 'ITEXT', 'ITEX2', 'RRP') then xpoa_change_type "
    + "                     end "
    + "                   ) others_cnt "
    + "           from    xpoaudt0 "
    + "           where   xpoa_po_order_no = " + po_no_selected
    + "           and     backorder_flag = ' ' "
    + "           and     xpoa_status = '40' "
    + "           and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
    + "           group by xpoa_po_order_no, backorder_flag "
    + "         ) d "
    + "           on a.po_order_no = d.xpoa_po_order_no "
    + "           and a.backorder_flag = d.backorder_flag "
    + "         left outer join cre5mfi e "
    + "           on a.cre_accountcode = e.cre_accountcode "
    + "         left outer join sys5tbl5 f "
    + "           on a.po_user_name = f.sys_tbl_code "
    + "           and f.sys_tbl_type = 'RR' "
    + "         left outer join scsratiogroup0 g "
    + "           on b.ratio_group_code = g.sgsr_group_code "
    + " where   a.po_order_no = " + po_no_selected
    + " and     a.backorder_flag = ' ' ";

// query for others
sql2 = " select  xpoa_change_type, "
     + "         to_char(xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         xpoa_old_value old_value, "
     + "         xpoa_new_value new_value, "
     + "         xpoa_ts_created "
     + " from    xpoaudt0 "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type in ('TRANS', 'VENPR', 'AIRCS', 'DUEDT', 'RCPTX', 'RRP') "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " union "
     + " select  'ITEXT', "
     + "         to_char(xpoa_ts_created, 'hh:mi AM') changed_time, "
     + "         '', "
     + "         xspo_item_text||xspo_item_text_2, "
     + "         xpoa_ts_created "
     + " from    xstpu22 a "
     + "         inner join "
     + "         ( "
     + "           select  xpoa_po_order_no, "
     + "                   backorder_flag, "
     + "                   max(xpoa_ts_created+10/24) xpoa_ts_created "
     + "           from    xpoaudt0 "
     + "           where   xpoa_po_order_no = " + po_no_selected
     + "           and     backorder_flag = ' ' "
     + "           and     xpoa_status = '40' "
     + "           and     xpoa_change_type in ('ITEXT', 'ITEX2') "
     + "           and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + "           group by xpoa_po_order_no, backorder_flag "
     + "         ) b "
     + "           on a.xspo_po_order_no = b.xpoa_po_order_no "
     + "           and a.backorder_flag = b.backorder_flag "
     + " where   a.xspo_po_order_no = " + po_no_selected
     + " and     a.backorder_flag = ' ' "
     + " union "
     + " select  a.xpoa_change_type, "
     + "         to_char(a.xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         nvl(b.sys_description, a.xpoa_old_value) old_value, "
     + "         nvl(c.sys_description, a.xpoa_new_value) new_value, "
     + "         a.xpoa_ts_created "
     + " from    xpoaudt0 a "
     + "         left outer join sys5tbl5 b "
     + "           on a.xpoa_old_value = b.sys_tbl_code "
     + "           and b.sys_tbl_type = 'XS' "
     + "         left outer join sys5tbl5 c "
     + "           on a.xpoa_new_value = c.sys_tbl_code "
     + "           and c.sys_tbl_type = 'XS' "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type = 'POTYP' "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " union "
     + " select  a.xpoa_change_type, "
     + "         to_char(a.xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         nvl(b.sys_description, a.xpoa_old_value) old_value, "
     + "         nvl(c.sys_description, a.xpoa_new_value) new_value, "
     + "         a.xpoa_ts_created "
     + " from    xpoaudt0 a "
     + "         left outer join sys5tbl5 b "
     + "           on a.xpoa_old_value = b.sys_tbl_code "
     + "           and b.sys_tbl_type = 'PG' "
     + "         left outer join sys5tbl5 c "
     + "           on a.xpoa_new_value = c.sys_tbl_code "
     + "           and c.sys_tbl_type = 'PG' "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type = 'GROUP' "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " union "
     + " select  a.xpoa_change_type, "
     + "         to_char(a.xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         nvl(b.sys_description, a.xpoa_old_value) old_value, "
     + "         nvl(c.sys_description, a.xpoa_new_value) new_value, "
     + "         a.xpoa_ts_created "
     + " from    xpoaudt0 a "
     + "         left outer join sys5tbl5 b "
     + "           on a.xpoa_old_value = b.sys_tbl_code "
     + "           and b.sys_tbl_type = 'SY' "
     + "         left outer join sys5tbl5 c "
     + "           on a.xpoa_new_value = c.sys_tbl_code "
     + "           and c.sys_tbl_type = 'SY' "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type = 'FABRC' "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " union "
     + " select  a.xpoa_change_type, "
     + "         to_char(a.xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         nvl(b.sys_description, a.xpoa_old_value) old_value, "
     + "         nvl(c.sys_description, a.xpoa_new_value) new_value, "
     + "         a.xpoa_ts_created "
     + " from    xpoaudt0 a "
     + "         left outer join sys5tbl5 b "
     + "           on a.xpoa_old_value = b.sys_tbl_code "
     + "           and b.sys_tbl_type = 'SS' "
     + "         left outer join sys5tbl5 c "
     + "           on a.xpoa_new_value = c.sys_tbl_code "
     + "           and c.sys_tbl_type = 'SS' "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type = 'LENTH' "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " union "
     + " select  a.xpoa_change_type, "
     + "         to_char(a.xpoa_ts_created+10/24, 'hh:mi AM') changed_time, "
     + "         nvl(b.srg_desc, a.xpoa_old_value) old_value, "
     + "         nvl(c.srg_desc, a.xpoa_new_value) new_value, "
     + "         a.xpoa_ts_created "
     + " from    xpoaudt0 a "
     + "         left outer join scsratiogroup0 b "
     + "           on a.xpoa_old_value = b.sgsr_group_code "
     + "         left outer join scsratiogroup0 c "
     + "           on a.xpoa_new_value = c.sgsr_group_code "
     + " where   xpoa_po_order_no = " + po_no_selected
     + " and     backorder_flag = ' ' "
     + " and     xpoa_status = '40' "
     + " and     xpoa_change_type = 'RATGR' "
     + " and     trunc(xpoa_ts_created+10/24) = to_date('" + date_selected + "', 'dd/mm/yyyy') "
     + " order by xpoa_ts_created ";

// query for colour and qty
sql3 = " select  trim(a.supplier_colour), "
     + "         nvl(b.sys_description, a.xsca_colour), "
     + "         fnGetRatioLabel(c.ratio_group_code, a.xsca_ratio), "
     + "         a.xsca_total_qty, "
     + "         a.xsca_sqty_1, "
     + "         a.xsca_sqty_2, "
     + "         a.xsca_sqty_3, "
     + "         a.xsca_sqty_4, "
     + "         a.xsca_sqty_5, "
     + "         a.xsca_sqty_6 "
     + " from    xstcolal1 a "
     + "         left outer join sys5tbl5 b "
     + "           on a.xsca_colour = b.sys_tbl_code "
     + "           and b.sys_tbl_type = 'CO' "
     + "         inner join xstpu22 c "
     + "           on a.xsca_po_order_no = c.xspo_po_order_no "
     + "           and a.backorder_flag = c.backorder_flag "
     + " where   a.xsca_po_order_no = " + po_no_selected
     + " and     a.backorder_flag = ' ' ";


try {

  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  matrix2 = new dbconn.MatrixDataSet();
  matrix3 = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();

  // po admendment info
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

  if (iRet > 0) {
    int j = 0;
    
    po_no = matrix.getRowData(0).getData(j++);
    style_no = matrix.getRowData(0).getData(j++);
    buyer = matrix.getRowData(0).getData(j++);
    order_type = matrix.getRowData(0).getData(j++);
    supplier_name = matrix.getRowData(0).getData(j++);
    currency_type = matrix.getRowData(0).getData(j++);
    ratio_group_desc = matrix.getRowData(0).getData(j++);
    //ratio_desc = matrix.getRowData(0).getData(j++);
    po_no_cancell = matrix.getRowData(0).getData(j++);
    colour_qty_cnt = Integer.parseInt(matrix.getRowData(0).getData(j++));
    others_cnt = Integer.parseInt(matrix.getRowData(0).getData(j++));

    // if not cancelled
    if (po_no_cancell.equals("")) {
      // read others
      if (others_cnt > 0) {
        iRet2 = dataProcess.RetrieveData(sql2, matrix2, connPronto);
      }

      // read colour or qty
      if (colour_qty_cnt > 0) {
        iRet3 = dataProcess.RetrieveData(sql3, matrix3, connPronto);
      }
    }
  }

  connPronto.commit();

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in po_amend_detail : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }
}

// print others list
for (int i = 0; i < iRet2; i++) {
  int j = 0;
  String change_type = matrix2.getRowData(i).getData(j++);
  String changed_time = matrix2.getRowData(i).getData(j++);
  String old_value = matrix2.getRowData(i).getData(j++);
  String new_value = matrix2.getRowData(i).getData(j++);

  String change_type_desc = "";
  if (change_type.equals("TRANS")) {
    change_type_desc = "TRANS. TYPE";
  } else if (change_type.equals("POTYP")) {
    change_type_desc = "ORDER TYPE";
  } else if (change_type.equals("VENPR")) {
    change_type_desc = "UNIT PRICE";
  } else if (change_type.equals("AIRCS")) {
    change_type_desc = "AIR COST";
  } else if (change_type.equals("DUEDT")) {
    change_type_desc = "DELIVERY DATE";
  } else if (change_type.equals("GROUP")) {
    change_type_desc = "ITEM GROUP";
  } else if (change_type.equals("FABRC")) {
    change_type_desc = "FABRIC";
  } else if (change_type.equals("RATGR")) {
    change_type_desc = "SIZE LABEL";
  } else if (change_type.equals("LENTH")) {
    change_type_desc = "LENGTH TYPE";
  } else if (change_type.equals("RCPTX")) {
    change_type_desc = "RECEIPT TEXT";
  } else if (change_type.equals("ITEXT")) {
    change_type_desc = "ITEM TEXT";
  } else if (change_type.equals("RRP")) {
    change_type_desc = "RETAIL PRICE";
  }

  // formatting..
  if (change_type.equals("VENPR") || change_type.equals("AIRCS") || change_type.equals("RRP")) {
    old_value = StringUtil.formatNumber(Double.parseDouble(old_value), MONEY_FORMAT);
    new_value = StringUtil.formatNumber(Double.parseDouble(new_value), MONEY_FORMAT);
    
    if (change_type.equals("VENPR")) {
      new_value += "(" + currency_type + ")";
    }
  } else if (change_type.equals("DUEDT")) {
    old_value = old_value.substring(8)+"/"+old_value.substring(5,7)+"/"+old_value.substring(0,4);
    new_value = new_value.substring(8)+"/"+new_value.substring(5,7)+"/"+new_value.substring(0,4);
  }

  outS2 += "<tr>"
         + " <td align='center'><b>" + (i+1) + "</b></td>"
         + " <td><b>" + change_type_desc + " :</b></td>"
         + " <td><u>" + old_value + "</u>&nbsp;</td>"
         + " <td><u>" + new_value + "</u>&nbsp;</td>"
         + " <td><u>" + changed_time + "</u></td>"
         + "</tr>";
}

// print colour and sizes
if (iRet3 > 0) {
  // set po size labels
  size_label = ratio_group_desc.split(":");

  for (int i = 0; i < size_label.length; i++) {
    size_labels += "<td width='7%'>" + size_label[i] + "</td>";
  }

  for (int i = size_label.length; i < 6; i++) {
    size_labels += "<td width='7%'>&nbsp;</td>";
  }

  // set po lines
  int total_size_1 = 0;
  int total_size_2 = 0;
  int total_size_3 = 0;
  int total_size_4 = 0;
  int total_size_5 = 0;
  int total_size_6 = 0;
  int total_pack = 0;
  int grand_total = 0;

  for (int i = 0; i < iRet3; i++) {
    int k = 0;
    String sp_colour = matrix3.getRowData(i).getData(k++);
    String ffb_colour = matrix3.getRowData(i).getData(k++);
    String ratio_desc = matrix3.getRowData(i).getData(k++);
    int total_qty = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_1 = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_2 = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_3 = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_4 = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_5 = Integer.parseInt(matrix3.getRowData(i).getData(k++));
    int size_6 = Integer.parseInt(matrix3.getRowData(i).getData(k++));

    // set po ratio labels and pack size
    String[] ratio_label = null;
    int pack_size = 0;
    ratio_label = ratio_desc.split(":");

    for (int n = 0; n < ratio_label.length; n++) {
      pack_size += Integer.parseInt(ratio_label[n]);
    }

    int pack_qty = 0;
    if (pack_size != 0) {
      pack_qty = total_qty/pack_size;
    }

    total_size_1 += size_1;
    total_size_2 += size_2;
    total_size_3 += size_3;
    total_size_4 += size_4;
    total_size_5 += size_5;
    total_size_6 += size_6;
    total_pack += pack_qty;
    grand_total += total_qty;

    outS3 += "<tr align='right'>"
           + "  <td align='left'>" + (sp_colour.equals("") ? "&nbsp;" : sp_colour) + "</td>"
           + "  <td align='left'>" + ffb_colour + "</td>"
          + "  <td align='center'>" + ratio_desc + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_1, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_2, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_3, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_4, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_5, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(size_6, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(pack_qty, QTY_FORMAT) + "</td>"
           + "  <td>" + StringUtil.formatNumber(total_qty, QTY_FORMAT) + "</td>"
           + "</tr>";
  }

  // print total qty
  outS3 += "<tr align='right' class='table_tail'>"
         + "  <td align='center' colspan='3'>GRAND TOTAL</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_1, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_2, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_3, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_4, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_5, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_size_6, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(total_pack, QTY_FORMAT) + "</td>"
         + "  <td>" + StringUtil.formatNumber(grand_total, QTY_FORMAT) + "</td>"
         + "</tr>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( request.getHeader("Referer") ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ag_supplier ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_style_no ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_from_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_to_date ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( buyer ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( date_selected ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( supplier_name ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( po_no ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( style_no ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( order_type ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      
if (iRet2 > 0) {

      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( outS2 ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      
} else {

      out.write(_jsp_string17, 0, _jsp_string17.length);
      
}

      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( iRet3 > 0 ? "checked" : "" ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      
if (iRet3 > 0) {

      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( size_labels ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( outS3 ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      
}

      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( !po_no_cancell.equals("") ? "checked" : "" ));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string24, 0, _jsp_string24.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/po_amend_detail.jsp"), 5779277197855471446L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string18;
  private final static char []_jsp_string10;
  private final static char []_jsp_string12;
  private final static char []_jsp_string14;
  private final static char []_jsp_string8;
  private final static char []_jsp_string2;
  private final static char []_jsp_string20;
  private final static char []_jsp_string24;
  private final static char []_jsp_string5;
  private final static char []_jsp_string9;
  private final static char []_jsp_string16;
  private final static char []_jsp_string1;
  private final static char []_jsp_string17;
  private final static char []_jsp_string21;
  private final static char []_jsp_string4;
  private final static char []_jsp_string3;
  private final static char []_jsp_string6;
  private final static char []_jsp_string0;
  private final static char []_jsp_string13;
  private final static char []_jsp_string22;
  private final static char []_jsp_string7;
  private final static char []_jsp_string19;
  private final static char []_jsp_string15;
  private final static char []_jsp_string23;
  private final static char []_jsp_string11;
  static {
    _jsp_string18 = "\n<table width=\"649\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"2\" bgcolor=\"gray\"></td>\n</tr>\n</table>\n<br>\n<TABLE cellSpacing='0' cellPadding='2' width='649' border='0'>\n<tr>\n  <td><input type='checkbox' disabled ".toCharArray();
    _jsp_string10 = "</u></td>\n        <td width='15%' align='right'><b>SUPPLIER :</b></td>\n        <td width='21%'><u>".toCharArray();
    _jsp_string12 = "</u></td>\n        <td align='right'><b>STYLE NO :</b></td>\n        <td><u>".toCharArray();
    _jsp_string14 = "</u></td>\n      </tr>\n  </table></td>\n</tr>\n</table>\n<br>\n\n<TABLE cellSpacing='0' cellPadding='2' width='649' border='0'>\n<tr>\n  <td><b>AMMENDMENTS</b></td>\n</tr>\n</table>\n<table width=\"649\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"2\" bgcolor=\"gray\"></td>\n</tr>\n</table>\n".toCharArray();
    _jsp_string8 = "'>\n<TABLE cellSpacing='0' cellPadding='2' width='649' border='1' bordercolor='gray'>\n<TR>\n  <TD><table width='99%' border='0' cellspacing='0' cellpadding='2' align='center'>\n      <tr>\n        <td width='17%' align='right'><b>REQUESTED BY :</b></td>\n        <td width='17%'><u>".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href='style_detail.css' rel='stylesheet' type='text/css'>\n<script language=JavaScript>\nfunction fnBack(form)\n{\n  form.action = '".toCharArray();
    _jsp_string20 = "\n  <table width='649' border='1' cellspacing='0' cellpadding='0'>\n  <tr class='table_header'>\n    <td width='34%' colspan='2'>COLOUR</td>\n    <td width='8%' rowspan='2'>RATIO</td>\n    <td width='42%' colspan='6'>SIZE</td>\n    <td width='16%' colspan='2'>QTY</td>\n  </tr>\n  <tr class='table_header'>\n    <td width='17%'>SP COLOUR</td>\n    <td width='17%'>COLOUR</td>\n    ".toCharArray();
    _jsp_string24 = "\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='ag_style_no' value='".toCharArray();
    _jsp_string9 = "</u></td>\n        <td width='15%' align='right'><b>DATE :</b></td>\n        <td width='15%'><u>".toCharArray();
    _jsp_string16 = "\n  </table>\n".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string17 = "\n  <br>\n".toCharArray();
    _jsp_string21 = "\n    <td width='8%'>PACK</td>\n    <td width='8%'>TOTAL</td>\n  </tr>\n  ".toCharArray();
    _jsp_string4 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string3 = "';\n  form.submit();\n}\n</script>\n</HEAD>\n<BODY leftmargin=\"5\" topmargin=\"10\">\n<TABLE cellSpacing=0 cellPadding=0 width=649 border=0>\n<TR> <TD align=center><font color=black size=4 style='line-height:30px;'><b><u>Order Amendment Form</u></b></font></TD></TR>\n</TABLE>\n<form name=frmMain method=post action=\"po_amend.jsp\">\n<input type='hidden' name='ag_supplier' value='".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='ag_from_date' value='".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string13 = "</u></td>\n        <td align='right'><b>ORDER TYPE :</b></td>\n        <td><u>".toCharArray();
    _jsp_string22 = "\n  </table>\n  <table width=\"649\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n  <tr>\n    <td width=\"100%\" height=\"2\"></td>\n  </tr>\n  </table>\n".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='ag_to_date' value='".toCharArray();
    _jsp_string19 = "><b>CHANGE IN COLOUR OR RATIO/QUANTITY</b></td>\n</tr>\n</table>\n".toCharArray();
    _jsp_string15 = "\n  <TABLE cellSpacing='0' cellPadding='2' width='630' border='0'>\n  <tr>\n    <td width='10%' align='center'><b>SEQ</b></td>\n    <td width='20%'><b>AMENDMENT</b></td>\n    <td width='25%'><b>FROM</b></td>\n    <td width='25%'><b>TO</b></td>\n    <td width='20%'><b>TIME</b></td>\n  </tr>\n  ".toCharArray();
    _jsp_string23 = "><b>CANCEL ORDER</b></td>\n</tr>\n</table>\n<table width=\"649\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"2\" bgcolor=\"gray\"></td>\n</tr>\n</table>\n<br>\n<table width =649 border=0 cellpadding=0 cellspacing=0>\n<input type=button value=\"Vew List\" onclick=\"fnBack(form)\">\n<input type=button value=\"Print Form\" onclick='print()'>\n</table>\n</form>\n".toCharArray();
    _jsp_string11 = "</u></td>\n      </tr>\n      <tr>\n        <td align='right'><b>PO NO :</b></td>\n        <td><u>".toCharArray();
  }
}
