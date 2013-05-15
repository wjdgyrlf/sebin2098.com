/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._admin._report;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import dbconn.*;
import common.util.*;

public class _weekly_0merchandising_0presentation__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
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

String _adminid = "";
String _adminname = "";
String _admintype = "";
String _admingroup = "";
String _brand = "";
String _adminclass = "";

try{

  _adminid = (String) session.getAttribute("adminid");

  if( _adminid == null || _adminid.length() == 0 || _adminid.equals("null") ) {
    response.sendRedirect("/admin/login_first.html");
    return;
  }

  _adminname = (String) session.getAttribute("adminname");
  _admintype = (String) session.getAttribute("admintype");
  _admingroup = (String) session.getAttribute("admingroup");
  _brand = (String) session.getAttribute("brand");
  _adminclass = (String) session.getAttribute("adminclass");
  //session.setMaxInactiveInterval(60*60);

}catch( Exception e ) {
  response.sendRedirect("/admin/login_first.html");
  return;
}

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
      
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

String MONEY_FORMAT = "###,##0.00";              // money format
String QTY_FORMAT = "###,##0";              // qty format

String searchYear = request.getParameter("searchYear");
String searchWeek = request.getParameter("searchWeek");
String searchBrand = request.getParameter("searchBrand");
String searchSeason = request.getParameter("searchSeason");
String searchClass = request.getParameter("searchClass");
String searchGroup = request.getParameter("searchGroup");
String searchBuyer = request.getParameter("searchBuyer");
String searchSupplier = request.getParameter("searchSupplier");
String searchLine = request.getParameter("searchLine");
String searchSort = request.getParameter("searchSort");
String searchPeriod = request.getParameter("searchPeriod");

if (searchBrand == null) searchBrand = (_admingroup.equals("B") ? _brand : "1");
if (searchSeason == null) searchSeason = "";
if (searchClass == null) searchClass = "";

if (searchGroup == null) searchGroup = "";
else searchGroup = searchGroup.replaceAll(" ", "");

if (searchBuyer == null) searchBuyer = "";
if (searchSupplier == null) searchSupplier = "";
if (searchLine == null) searchLine = "";
if (searchSort == null) searchSort = "Group+RRP";
if (searchPeriod == null) searchPeriod = "2";

int iRet = 0;
int iRet2 = 0;
int iRet3 = 0;
int iRet4 = 0;
int iRet5 = 0;
Connection connPronto = null;
Connection connScm = null;
DBConnManager dbPool = null;
MatrixDataSet matrix = null;
MatrixDataSet matrix2 = null;
MatrixDataSet matrix3 = null;
MatrixDataSet matrix4 = null;
MatrixDataSet matrix5 = null;
MatrixDataSet matrix6 = null;
DataProcess dataProcess = null;
boolean isSucceeded = false;
String strMsg = "";
String outS = "";
String sql = "";

String thisYearStr = "";
String thisWeekStr = "";
String fromDate = "";
String toDate = "";

try {

  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  dataProcess = new DataProcess();

  // year, week setting
  sql = " select  to_char(sysdate, 'iyyy'), to_char(sysdate, 'iw') "
      + " from    dual ";

  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

  if (iRet > 0) {
    thisYearStr = matrix.getRowData(0).getData(0);
    thisWeekStr = matrix.getRowData(0).getData(1);
  }

  // default Year, Week Setting..
  if (searchYear == null || searchWeek == null) {
    searchYear = thisYearStr;
    searchWeek = thisWeekStr;
  }

  // read FromDate of the Year, Week, ToDate of the Year, 2 weeks later (7 days later)
  sql = " select  to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1) "
      + "                 - case to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1), 'd') "
      + "                     when '1' then 6 "
      + "                     else to_number(to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1), 'd'))-2 "
      + "                   end, 'yyyymmdd'),"
      + "         to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1) "
      + "                 - case to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1), 'd') "
      + "                     when '1' then 6 "
      + "                     else to_number(to_char(to_date('" + searchYear + "'||'0104', 'yyyymmdd')+7*(" + searchWeek + "-1), 'd'))-2 "
      + "                   end + (7*" + searchPeriod + "-1), 'yyyymmdd') "
      + " from    dual ";

  //out.println(sql);
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

  if (iRet > 0) {
    fromDate = matrix.getRowData(0).getData(0);
    toDate = matrix.getRowData(0).getData(1);
  }

  // create sql
  sql = " select  b.xspo_stock_group, nvl(e.sys_description, b.xspo_line), "
      + "         b.xspo_style, b.xspo_po_type, "
      + "         to_char(a.po_arrival_date, 'iyyy'), "
      + "         to_char(a.po_arrival_date, 'iw'), "
      + "         b.xspo_rrp, substr(c.cr_shortname, 1, 10), "
      + "         sum(d.xsca_total_qty), b.xspo_trans_type, b.xspo_order_type, "
      + "         nvl(h.sys_description, b.xspo_theme), a.po_order_status "
      + " from    por5mf4 a "
      + "         inner join xstpu22 b "
      + "           on a.po_order_no = b.xspo_po_order_no "
      + "           and a.backorder_flag = b.backorder_flag "
      + "         left outer join cre5mfi c "
      + "           on a.cre_accountcode = c.cre_accountcode "
      + "         inner join xstcolal1 d "
      + "           on b.xspo_po_order_no = d.xsca_po_order_no "
      + "           and b.backorder_flag = d.backorder_flag "
      + "         left outer join sys5tbl5 e "
      + "           on b.xspo_line = e.sys_tbl_code "
      + "           and e.sys_tbl_type = 'SZ' "
      + "         left outer join stkhiertree3 f "
      + "           on b.xspo_stock_group = f.stock_group "
      + "         left outer join sys5tbl5 g "
      + "           on a.po_user_name = g.sys_tbl_code "
      + "           and g.sys_tbl_type = 'RR' "
      + "         left outer join sys5tbl5 h "
      + "           on b.xspo_theme = h.sys_tbl_code "
      + "           and h.sys_tbl_type = 'B6' "
      + " where   a.backorder_flag = ' ' "
      + " and     a.po_order_status not in  ('11', '99') "
      + " and     a.po_arrival_date between to_date('" + fromDate + "', 'yyyymmdd') and to_date('" + toDate + "', 'yyyymmdd') ";

  if (!searchBrand.equals("")) {
    sql += " and     f.sht_category = '" + searchBrand + "' ";
  }

  if (!searchClass.equals("")) {
    sql += " and     f.sht_class = '" + searchClass + "' ";
  }

  if (!searchSeason.equals("")) {
    sql += " and     b.xspo_season||xspo_season_seq = '" + searchSeason + "' ";
  }

  if (!searchGroup.equals("")) {
    String[] tmpSearchGroups = searchGroup.split(",");
    String tmpSearchGroup = "";
    for (int i = 0; i < tmpSearchGroups.length; i++) {
      if (i > 0) tmpSearchGroup += ",";
      tmpSearchGroup += "'" + tmpSearchGroups[i] + "'";
    }

    sql += " and     b.xspo_stock_group in (" + tmpSearchGroup + ") ";
  }

  if (!searchBuyer.equals("")) {
    sql += " and     a.po_user_name = '" + searchBuyer + "' ";
  }

  if (!searchSupplier.equals("")) {
    sql += " and     a.cre_accountcode = '" + searchSupplier + "' ";
  }

  if (!searchLine.equals("")) {
    sql += " and     b.xspo_line = '" + searchLine + "' ";
  }

  sql += " group by b.xspo_stock_group, nvl(e.sys_description, b.xspo_line), "
       + "         b.xspo_style, b.xspo_po_type, "
       + "         to_char(a.po_arrival_date, 'iyyy'), "
       + "         to_char(a.po_arrival_date, 'iw'), "
       + "         b.xspo_rrp, substr(c.cr_shortname, 1, 10), "
       + "         b.xspo_trans_type, b.xspo_order_type, "
       + "         nvl(h.sys_description, b.xspo_theme), b.xspo_season||b.xspo_season_seq, a.po_order_status "
       + " order by to_char(a.po_arrival_date, 'iyyy'), "
       + "         to_char(a.po_arrival_date, 'iw'), ";

  // setting sort order
  if (searchSort.equals("Group+RRP")) {
    sql += "          b.xspo_stock_group, b.xspo_rrp ";
  } else if (searchSort.equals("RRP")) {
    sql += "          b.xspo_rrp, b.xspo_stock_group ";
  } else if (searchSort.equals("Supplier")) {
    sql += "          substr(c.cr_shortname, 1, 10), b.xspo_stock_group ";
  } else if (searchSort.equals("Order Type")) {
    sql += "          b.xspo_order_type, b.xspo_rrp ";
  } else if (searchSort.equals("Trans Type")) {
    sql += "          b.xspo_trans_type, b.xspo_stock_group ";
  } else if (searchSort.equals("PO Type")) {
    sql += "          b.xspo_po_type, b.xspo_stock_group ";
  }
  //out.println(sql);

  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

  // read Item Class code
  sql = " select  distinct sys_tbl_code, sys_description "
      + " from    sys5tbl5 inner join stkhiertree3 "
      + "           on sys_tbl_code = sht_class "
      + " where   sys_tbl_type = 'OG' "
      //+ (_admingroup.equals("B") && !_brand.equals("") ? " and     sht_category = '" + _brand + "' " : "")
      + " order by sys_tbl_code ";

  matrix2 = new dbconn.MatrixDataSet();
  iRet2 = dataProcess.RetrieveData(sql, matrix2, connPronto);

  // read Buyer info
  sql = " select  sys_tbl_code, sys_description "
      + " from    sys5tbl5 "
      + " where   sys_tbl_type = 'RR' "
      + " and     sys_tbl_alpha_1 <> '0' "
      + " order by sys_description ";

  matrix3 = new dbconn.MatrixDataSet();
  iRet3 = dataProcess.RetrieveData(sql, matrix3, connPronto);

  // read Line info from pronto
  sql = " select  sys_tbl_code, sys_description "
      + " from    sys5tbl5 "
      + " where   sys_tbl_type = 'SZ' "
      + " and     sys_description not like '%NOT USE%' "
      + " order by sys_tbl_code ";

  matrix4 = new dbconn.MatrixDataSet();
  iRet4 = dataProcess.RetrieveData(sql, matrix4, connPronto);

  // read Supplier info
  sql = " select  cre_accountcode, cr_shortname "
      + " from    cre5mfi "
      + " where   cr_type = '01' "
      + " order by cr_shortname ";

  matrix5 = new dbconn.MatrixDataSet();
  iRet5 = dataProcess.RetrieveData(sql, matrix5, connPronto);

  // read user brand
  sql = " select  code, code_name "
      + " from    vg_common_code "
      + " where   type = 'USER_BRAND' "
      + " and     nvl(related_code, ' ') <> 'Z' "
      + " and     use_yn = 'Y' "
      + " order by sort_order ";

  connScm = dbPool.getConnection("intranet");
  matrix6 = new dbconn.MatrixDataSet();
  dataProcess.RetrieveData(sql, matrix6, connScm);
  
} catch (Exception e) {
  System.out.println("Exception weekly_merchandising_presentation : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }

  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

if (iRet > 0) {

  // \u00c7\u00d1 Line\u00bf\u00a1 10\u00b0\u00b3\u00c0\u00c7 \u00b5\u00a5\u00c0\u00cc\u00c5\u00b8\u00b8\u00a6 \u00c3\u00e2\u00b7\u00c2\u00c7\u00d4.
  // \u00c1\u00d6\u00b0\u00a1 \u00b4\u00de\u00b6\u00f3\u00c1\u00fa \u00b0\u00e6\u00bf\u00ec, \u00bb\u00f5\u00b7\u00ce\u00bf\u00ee Line\u00bf\u00a1 \u00c3\u00e2\u00b7\u00c2\u00c7\u00d8\u00be\u00df \u00c7\u00d4.
  // \u00c0\u00cc\u00b8\u00a6 \u00c0\u00a7\u00c7\u00d8 \u00c0\u00cc\u00c0\u00fc week \u00c1\u00a4\u00ba\u00b8\u00b8\u00a6 \u00c0\u00fa\u00c0\u00e5\u00c7\u00cf\u00b4\u00c2 beforeWeek \u00ba\u00af\u00bc\u00f6\u00b8\u00a6 \u00c3\u00df\u00b0\u00a1\u00c7\u00cf\u00b0\u00ed
  // \u00c3\u00b9 Row\u00c0\u00c7 week\u00c0\u00bb \u00b9\u00cc\u00b8\u00ae \u00c0\u00d0\u00be\u00ee\u00bf\u00c8.

  int iCnt = 0;
  String beforeWeek = matrix.getRowData(0).getData(5);

  for (int i = 0; i < iRet; i++) {
    int j = 0;
    String itemGroup  = matrix.getRowData(i).getData(j++);
    String line       = matrix.getRowData(i).getData(j++);
    String styleNo    = matrix.getRowData(i).getData(j++);
    String POType  = matrix.getRowData(i).getData(j++);
    j++;    // skip year
    String week       = matrix.getRowData(i).getData(j++);
    double rrp        = Double.parseDouble(matrix.getRowData(i).getData(j++));
    String supplier   = matrix.getRowData(i).getData(j++);
    long qty          = Long.parseLong(matrix.getRowData(i).getData(j++));
    String transType  = matrix.getRowData(i).getData(j++);
    String orderType  = matrix.getRowData(i).getData(j++);
    String theme      = matrix.getRowData(i).getData(j++);
    String orderStatus = matrix.getRowData(i).getData(j++);
    
    String fontColor = "#000000";
    if (orderStatus.compareTo("40") < 0) {
      fontColor = "#0000FF";
    }

    if (beforeWeek.equals(week)) {
      if (iCnt++ == 0) {
        outS += "<tr align='center' class='table_list'>"
              + "  <td>" + week + "</td>";
      }

      outS += "  <td valign='top'><table border='0' width='100%' cellpadding='0' cellspacing='0'>"
            + "    <tr>"
            + "      <td width='100%' colspan='2' align='center'><img src='" + _styleImgURL + "/" + styleNo + ".jpg' width='85' height='130' border='0'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>(" + itemGroup +")"+line + "</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='70%'><font color='" + fontColor + "'>" + styleNo + "</font></td>"
            + "      <td width='30%' align='right'><b><font color='" + fontColor + "'>" + POType + "</font></b></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>" + supplier + "&nbsp;</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='70%'><font color='" + fontColor + "'>" + StringUtil.formatNumber(rrp, MONEY_FORMAT) + "</font></td>"
            + "      <td width='30%' align='right'><font color='" + fontColor + "'>" + orderType + "</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='40%'><font color='" + fontColor + "'>" + StringUtil.formatNumber(qty, QTY_FORMAT) + "</font></td>"
            + "      <td width='60%' align='right'><font color='" + fontColor + "'>" + transType + "</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>" + theme + "&nbsp;</font></td>"
            + "    </tr>"
            + "  </table></td>";

      if (iCnt == 10) {
        outS += "</tr>";
        iCnt = 0;
      }
    }
    // Week\u00c0\u00cc \u00b4\u00de\u00b6\u00f3\u00c1\u00fa \u00b0\u00e6\u00bf\u00ec \u00bb\u00f5\u00b7\u00ce\u00bf\u00ee Row \u00b6\u00f3\u00c0\u00ce\u00bf\u00a1\u00bc\u00ad \u00c3\u00e2\u00b7\u00c2\u00c7\u00d4.
    else {
      // \u00c7\u00f6\u00c0\u00e7 \u00b6\u00f3\u00c0\u00ce \u00ba\u00f3\u00c4\u00ad \u00c3\u00e2\u00b7\u00c2
      if (iCnt > 0) {
        for (int k = iCnt; k < 10; k++) {
          outS += "  <td><table border='0' width='100%' cellpadding='0' cellspacing='0'>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "    <tr>"
                + "      <td width='100%' colspan='2'></td>"
                + "    </tr>"
                + "  </table></td>";
        }

        outS += "</tr>";
        iCnt = 0;
      }

      // \u00c7\u00f6\u00c0\u00e7 row\u00b8\u00a6 \u00bb\u00f5\u00b7\u00ce\u00bf\u00ee Line\u00bf\u00a1 \u00c3\u00e2\u00b7\u00c2\u00c7\u00d4.
      if (iCnt++ == 0) {
        outS += "<tr align='center' class='table_list'>"
              + "  <td>" + week + "</td>";
      }

      outS += "  <td valign='top'><table border='0' width='100%' cellpadding='0' cellspacing='0'>"
            + "    <tr>"
            + "      <td width='100%' colspan='2' align='center'><img src='" + _styleImgURL + "/" + styleNo + ".jpg' width='85' height='130' border='0'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>(" + itemGroup +")" + line + "&nbsp;</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='70%'><font color='" + fontColor + "'>" + styleNo + "</font></td>"
            + "      <td width='30%' align='right'><b><font color='" + fontColor + "'>" + POType + "</font></b></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>" + supplier + "&nbsp;</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='70%'><font color='" + fontColor + "'>" + StringUtil.formatNumber(rrp, MONEY_FORMAT) + "</font></td>"
            + "      <td width='30%' align='right'><font color='" + fontColor + "'>" + orderType + "</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='40%'><font color='" + fontColor + "'>" + StringUtil.formatNumber(qty, QTY_FORMAT) + "</font></td>"
            + "      <td width='60%' align='right'><font color='" + fontColor + "'>" + transType + "</font></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'><font color='" + fontColor + "'>" + theme + "&nbsp;</font></td>"
            + "    </tr>"
            + "  </table></td>";
    }

    // copy week to beforeWeek
    beforeWeek = week;
  }

  // \u00b8\u00b6\u00c1\u00f6\u00b8\u00b7 \u00b6\u00f3\u00c0\u00ce \u00ba\u00f3\u00c4\u00ad \u00c3\u00e2\u00b7\u00c2.
  if (iCnt > 0) {
    for (int i = iCnt; i < 10; i++) {
      outS += "  <td><table border='0' width='100%' cellpadding='0' cellspacing='0'>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "    <tr>"
            + "      <td width='100%' colspan='2'></td>"
            + "    </tr>"
            + "  </table></td>";
    }

    outS += "</tr>";
  }

}

// print item class
String itemClassOptions = "<option value=''></option>";
for (int i = 0; i < iRet2; i++) {
  int j = 0;
  String itemCode = matrix2.getRowData(i).getData(j++);
  String itemDesc = matrix2.getRowData(i).getData(j++);

  itemClassOptions += "<option value='" + itemCode + "'"
                    + (itemCode.equals(searchClass) ? " selected" : "")
                    + ">" + itemDesc + "</option>";
}

// print out Buyer info
String buyerOptions = "<option value=''></option>";
for (int i = 0; i < iRet3; i++) {
  int j = 0;
  String itemCode = matrix3.getRowData(i).getData(j++);
  String itemDesc = matrix3.getRowData(i).getData(j++);

  buyerOptions += "<option value='" + itemCode + "'"
                    + (itemCode.equals(searchBuyer) ? " selected" : "")
                    + ">" + itemCode + " " + itemDesc + "</option>";
}

// print out line info
String lineOptions = "<option value=''></option>";
for (int i = 0; i < iRet4; i++) {
  int j = 0;
  String itemCode = matrix4.getRowData(i).getData(j++);
  String itemDesc = matrix4.getRowData(i).getData(j++);

  lineOptions += "<option value='" + itemCode + "'"
                    + (itemCode.equals(searchLine) ? " selected" : "")
                    + ">" + itemCode + " " + itemDesc + "</option>";
}

// print out supplier info
String supplierOptions = "<option value=''></option>";
for (int i = 0; i < iRet5; i++) {
  int j = 0;
  String itemCode = matrix5.getRowData(i).getData(j++);
  String itemDesc = matrix5.getRowData(i).getData(j++);

  supplierOptions += "<option value='" + itemCode + "'"
                    + (itemCode.equals(searchSupplier) ? " selected" : "")
                    + ">" + itemCode + " " + itemDesc + "</option>";
}

// print out brand options
String brandOptions = "<option></option>";
for (int i = 0; i < matrix6.getRowCount(); i++) {
  int j = 0;
  String code = matrix6.getRowData(i).getData(j++);
  String codeName = matrix6.getRowData(i).getData(j++);

  brandOptions += "<option value='" + code + "'"
                + (searchBrand.equals(code) ? " selected" : "") + ">" + codeName + "</option>";
}

// Year, Week Setting
int thisYear = Integer.parseInt(DateUtil.getToday("yyyy"));
String yearOptions = "";
String weekOptions = "";
String weekStr = "";

for (int i = thisYear-4; i <= thisYear+1; i++) {
  yearOptions += "<option value='" + i + "' " + (searchYear.equals("" + i) ? "selected" : "")
              + ">" + i + "</option>";
}

for (int i = 1; i <= 53; i++) {
  weekStr = (i < 10 ? "0" + i : "" + i);
  weekOptions += "<option value='" + weekStr + "' " + (searchWeek.equals(weekStr) ? "selected" : "")
              + ">" + weekStr + "</option>";
}

// period setting
String periodOptions = "";

for (int i = 1; i <= 5; i++) {
  periodOptions += "<option value='" + i + "' " + (searchPeriod.equals("" + i) ? "selected" : "")
                 + ">" + i + "</option>";
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print(( yearOptions ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( weekOptions ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( periodOptions ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      
/*
if (_admingroup.equals("B")) {

      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( searchBrand.equals("1") ? "Valleygirl" : (searchBrand.equals("2") ? "TEMT" : searchBrand) ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( searchBrand ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      
} else {
*/

      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( brandOptions ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      
//}

      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( searchSeason ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( thisWeekStr ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( itemClassOptions ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( searchGroup ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( buyerOptions ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( supplierOptions ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( lineOptions ));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( searchSort.equals("Group+RRP") ? "selected" : "" ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( searchSort.equals("RRP") ? "selected" : "" ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( searchSort.equals("Supplier") ? "selected" : "" ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( searchSort.equals("Order Type") ? "selected" : "" ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( searchSort.equals("Trans Type") ? "selected" : "" ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print(( searchSort.equals("PO Type") ? "selected" : "" ));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print(( iRet ));
      out.write(_jsp_string24, 0, _jsp_string24.length);
      out.print(( outS ));
      out.write(_jsp_string25, 0, _jsp_string25.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string26, 0, _jsp_string26.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/report/weekly_merchandising_presentation.jsp"), -4685991532156114188L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string19;
  private final static char []_jsp_string1;
  private final static char []_jsp_string24;
  private final static char []_jsp_string6;
  private final static char []_jsp_string12;
  private final static char []_jsp_string0;
  private final static char []_jsp_string11;
  private final static char []_jsp_string26;
  private final static char []_jsp_string16;
  private final static char []_jsp_string5;
  private final static char []_jsp_string22;
  private final static char []_jsp_string18;
  private final static char []_jsp_string10;
  private final static char []_jsp_string23;
  private final static char []_jsp_string25;
  private final static char []_jsp_string21;
  private final static char []_jsp_string17;
  private final static char []_jsp_string8;
  private final static char []_jsp_string14;
  private final static char []_jsp_string20;
  private final static char []_jsp_string3;
  private final static char []_jsp_string13;
  private final static char []_jsp_string2;
  private final static char []_jsp_string15;
  private final static char []_jsp_string4;
  private final static char []_jsp_string7;
  private final static char []_jsp_string9;
  static {
    _jsp_string19 = ">RRP</option>\n    <option value='Supplier' ".toCharArray();
    _jsp_string1 = "\n<html>\n<head>\n<title></title>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<script language=\"javascript\">\nfunction fnSearch(frm) {\n  if (frm.searchSeason.value) {\n    if (!jf_IsNumeric(frm.searchSeason.value)) {\n      alert(\"Input Season as a number.\");\n      frm.searchSeason.select();\n      return;\n    }\n  }\n\n  frm.action=\"./weekly_merchandising_presentation.jsp\";\n  frm.submit();\n}\n\nfunction fnPrint() {\n  this.print();\n}\n/*\nfunction fnViewDetail(style_no) {\n  document.form1.ag_style_no.value = style_no;\n  document.form1.action = '/product_info/price_history_detail.jsp';\n  document.form1.submit();\n}\n*/\n</script>\n</head>\n<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>\n<table width='840' border='0' cellspacing='0' cellpadding='0'><tr><td>\n\n<table width='99%' border='0' cellspacing='0' cellpadding='0' align=\"center\">\n<tr>\n  <td height='15' colspan='2'></td>\n</tr>\n<tr>\n  <td width='3%'><img src='/img/title_icon.gif'></td>\n  <td width='*' class='left_title'>Weekly Merchandising Presentation</td>\n</tr>\n<tr>\n  <td width='100%' height='2' colspan='2'><hr width='100%'></td>\n</tr>\n<tr>\n  <td height='10' colspan='2'></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width='1000' border='0' cellspacing='0' cellpadding='0'><tr><td>\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<form name=\"form1\" method=\"post\">\n<input type='hidden' name='ag_style_no'>\n<tr>\n  <td width=\"8%\" class=\"table_header_center\">Year</td>\n  <td width=\"16%\" class=\"table_bg_bright\"><select name=\"searchYear\">".toCharArray();
    _jsp_string24 = "&nbsp;</td>\n</tr>\n</table>\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"center\" class=\"table_bg\">\n<tr class=\"table_header_center\">\n  <td>W</td>\n  <td>Photo1</td>\n  <td>Photo2</td>\n  <td>Photo3</td>\n  <td>Photo4</td>\n  <td>Photo5</td>\n  <td>Photo6</td>\n  <td>Photo7</td>\n  <td>Photo8</td>\n  <td>Photo9</td>\n  <td>Photo10</td>\n</tr>\n".toCharArray();
    _jsp_string6 = "\n    <input type='hidden' name='searchBrand' value='".toCharArray();
    _jsp_string12 = "</font>)\n    <br>\n    <input type=\"button\" value=\"Search\" onclick=\"fnSearch(this.form);\">\n    <input type=\"button\" value=\"Print\" onclick=\"fnPrint();\"></td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">Item Class</td>\n  <td class=\"table_bg_bright\"><select name='searchClass'>".toCharArray();
    _jsp_string0 = "\n\n\n".toCharArray();
    _jsp_string11 = "' size='4' maxlength='4'></td>\n  <td width=\"16%\" rowspan='4' class=\"table_bg_bright_center\">(<font color='blue'>* This Week : ".toCharArray();
    _jsp_string26 = "\n</td></tr></table>\n</body>\n</html>\n".toCharArray();
    _jsp_string16 = "</select></td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">Line</td>\n  <td class=\"table_bg_bright\"><select name='searchLine'>".toCharArray();
    _jsp_string5 = "\n    ".toCharArray();
    _jsp_string22 = ">Trans Type</option>\n    <option value='PO Type' ".toCharArray();
    _jsp_string18 = ">Group+RRP</option>\n    <option value='RRP' ".toCharArray();
    _jsp_string10 = "\n  </td>\n  <td width=\"8%\" class=\"table_header_center\">Season</td>\n  <td width=\"8%\" class=\"table_bg_bright\"><input type='text' name='searchSeason' value='".toCharArray();
    _jsp_string23 = ">PO Type</option>\n    </select></td>\n</tr>\n</form>\n</table>\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"10\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"50%\"></td>\n  <td width=\"*\" align=\"right\">TOTAL : ".toCharArray();
    _jsp_string25 = "\n</table>\n</td></tr></table>\n\n<table width='840' border='0' cellspacing='0' cellpadding='0'><tr><td>\n".toCharArray();
    _jsp_string21 = ">Order Type</option>\n    <option value='Trans Type' ".toCharArray();
    _jsp_string17 = "</select></td>\n  <td class=\"table_header_center\">Sort</td>\n  <td class=\"table_bg_bright\" colspan='5'><select name='searchSort'>\n    <option value='Group+RRP' ".toCharArray();
    _jsp_string8 = "\n    <select name='searchBrand'>".toCharArray();
    _jsp_string14 = "' size='50' maxlength='50'>\n    <br>Default=space(all Item Group), Multiple-choice=1010,1011,1012</td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">Buyer</td>\n  <td class=\"table_bg_bright\"><select name='searchBuyer'>".toCharArray();
    _jsp_string20 = ">Supplier</option>\n    <option value='Order Type' ".toCharArray();
    _jsp_string3 = "</select>\n    <font color='blue'>to <select name=\"searchPeriod\">".toCharArray();
    _jsp_string13 = "</select></td>\n  <td class=\"table_header_center\">Item Group</td>\n  <td class=\"table_bg_bright\" colspan='5'><input type='text' name='searchGroup' value='".toCharArray();
    _jsp_string2 = "</select></td>\n  <td width=\"8%\" class=\"table_header_center\">Week</td>\n  <td width=\"18%\" class=\"table_bg_bright\"><select name=\"searchWeek\">".toCharArray();
    _jsp_string15 = "</select></td>\n  <td class=\"table_header_center\">Supplier</td>\n  <td class=\"table_bg_bright\" colspan='5'><select name='searchSupplier'>".toCharArray();
    _jsp_string4 = "</select> weeks</font></td>\n  <td width=\"8%\" class=\"table_header_center\">Brand</td>\n  <td width=\"10%\" class=\"table_bg_bright\">\n".toCharArray();
    _jsp_string7 = "'>\n".toCharArray();
    _jsp_string9 = "</select>\n".toCharArray();
  }
}