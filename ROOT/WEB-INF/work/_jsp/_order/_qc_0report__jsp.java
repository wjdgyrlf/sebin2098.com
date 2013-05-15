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

public class _qc_0report__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, "/order/../error.jsp", session, 8192, true, false);
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

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
Connection connPronto = null;
Connection connScm = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";
int iRet = 0;
String outS = "";

if (_adminid != null) scmid = "60171";

String ag_from_date = request.getParameter("ag_from_date");
String ag_to_date = request.getParameter("ag_to_date");
String ag_brand = request.getParameter("ag_brand");

if (ag_from_date == null || ag_to_date == null) {
  ag_from_date = "01/" + DateUtil.getToday("MM/yyyy");
  ag_to_date = DateUtil.getToday("dd/MM/yyyy");
}
if (ag_brand == null) ag_brand = "";

sql = " select  to_char(c.xpoa_ts_created+10/24, 'dd/mm/yyyy'), "
    + "         a.po_order_no, "
    + "         b.xspo_style, "
    + "         f.shm_description, "
    + "         to_char(a.po_order_date, 'dd/mm/yyyy'), "
    + "         to_char(b.ex_factory_date, 'iyyy')||to_char(b.ex_factory_date, 'iw'), "
    + "         to_char(b.ex_factory_date, 'dd/mm/yyyy'), "
    + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
    + "         b.xspo_trans_type, "
    + "         nvl(g.sys_description, a.po_user_name), "
    + "         to_char(d.xpoa_ts_created+10/24, 'dd/mm/yyyy'), "
    + "         e.cr_shortname, "
    + "         h.inspector, "
    + "         i.name, "
    + "         to_char(h.inspect_date, 'dd/mm/yyyy'), "
    + "         case "
    + "           when j.final_decision = 1 then 'P' "
    + "           when j.final_decision = 2 then 'H' "
    + "           when j.final_decision in (3,4,5,6,7) then 'F' "
    + "           else '' "
    + "         end "
    + " from    por5mf4 a "
    + "         inner join xstpu22 b "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         left outer join xpoaudt0 c "
    + "           on a.po_order_no = c.xpoa_po_order_no "
    + "           and a.backorder_flag = c.backorder_flag "
    + "           and c.xpoa_change_type = 'STAT' "
    + "           and c.xpoa_status = '00' "
    + "           and c.xpoa_old_value = '00' "
    + "           and c.xpoa_new_value = '25' "
    + "         left outer join xpoaudt0 d "
    + "           on a.po_order_no = d.xpoa_po_order_no "
    + "           and a.backorder_flag = d.backorder_flag "
    + "           and d.xpoa_change_type = 'STAT' "
    + "           and d.xpoa_status = '25' "
    + "           and d.xpoa_old_value = '25' "
    + "           and d.xpoa_new_value = '40' "
    + "         inner join cre5mfi e "
    + "           on a.cre_accountcode = e.cre_accountcode "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, z.sht_category, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) f "
    + "           on b.xspo_stock_group = f.stock_group "
    + "         left outer join sys5tbl5 g "
    + "           on a.po_user_name = g.sys_tbl_code "
    + "           and g.sys_tbl_type = 'RR' "
    + "         left outer join po_style_etc@scm h "
    + "           on a.po_order_no = h.po_no "
    + "         left outer join vg_inspector@scm i "
    + "           on h.inspector = i.code "
    + "         left outer join buying.vg_qc_master@aps j "
    + "           on b.xspo_po_order_no = j.po_no "
    + "           and b.xspo_style = ltrim(j.style_no, '0') "
    + "         inner join nad5mfa k "
    + "           on e.cre_accountcode = k.accountcode "
    + " where   a.backorder_flag = ' ' "
    + " and     a.po_order_status between '40' and '90' "
    + " and     b.ex_factory_date between to_date('" + ag_from_date + "', 'dd/mm/yyyy') and to_date('" + ag_to_date + "', 'dd/mm/yyyy') "
    + " and     k.na_type = 'C' "
    + " and     k.na_country_code in "
    + "         ( "
    + "           select  supplier_class "
    + "           from    user_supplier_02t@scm "
    + "           where   user_type = '" + usertype + "' "
    + "           and     order_control_yn = 'Y' "
    + "         ) ";

if (!ag_brand.equals("")) {
  sql += " and    f.sht_category = '" + ag_brand + "' ";
}

sql += "  order by f.shm_description desc, e.cr_shortname, b.ex_factory_date, a.po_order_no ";
//out.println(sql);

try {

  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  
  // read po list
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  connPronto.commit();

  // read user brand code info
  sql = " select  code, code_name "
      + " from    vg_common_code "
      + " where   type = 'USER_BRAND' "
      + " and     nvl(related_code, ' ') <> 'Z' "
      + " and     use_yn = 'Y' "
      + " order by sort_order ";

  connScm = dbPool.getConnection("intranet");
  matrix2 = new dbconn.MatrixDataSet();
  dataProcess.RetrieveData(sql, matrix2, connScm);

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in qc_report : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dataProcess = new DataProcess();
    dataProcess.ManipulateData("alter session close database link aps", connPronto);
    dbPool.freeConnection("pronto", connPronto);
  }

  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

// print po list
int tmpSupplierCnt = 0;
String tmpSupplier = "";
String color_code = "#FFFFF0";
String comment ="";

// read first supplier
if (iRet > 0) {
  tmpSupplier = matrix.getRowData(0).getData(11);
  
  for (int i = 0; i < iRet; i++) {
    int j = 0;
    String pr_date   = matrix.getRowData(i).getData(j++);
    String po_no     = matrix.getRowData(i).getData(j++);
    String style_no  = matrix.getRowData(i).getData(j++);
    String brand_nm  = matrix.getRowData(i).getData(j++);
    String order_date = matrix.getRowData(i).getData(j++);
    String ex_factory_week = matrix.getRowData(i).getData(j++);
    String ex_factory_date = matrix.getRowData(i).getData(j++);
    String delivery  = matrix.getRowData(i).getData(j++);
    String trans_type = matrix.getRowData(i).getData(j++);
    String buyer     = matrix.getRowData(i).getData(j++);
    String sc_date   = matrix.getRowData(i).getData(j++);
    String supplier  = matrix.getRowData(i).getData(j++);
    String inspector = matrix.getRowData(i).getData(j++);
    String inspector_nm = matrix.getRowData(i).getData(j++);
    String inspect_date = matrix.getRowData(i).getData(j++);
    String inspect_status = matrix.getRowData(i).getData(j++);

    // print item count of each suppliers
    if (!tmpSupplier.equals(supplier)) {
      outS += "<tr align=center bgcolor='" + color_code + "'>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td><b>" + tmpSupplierCnt + "</b></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td align='left'><b>" + tmpSupplier + "</b></td>" +
              "<td></td>" +
              "<td></td>" +
              "<td></td>" +
              "</tr>" ;
  
      tmpSupplierCnt = 0;
      tmpSupplier = supplier;

      if (color_code.equals("#EEEEE0")) {
        color_code = "#FFFFF0";
      } else {
        color_code = "#EEEEE0";
      }
    }
  
    tmpSupplierCnt++;
    String po_link = "";
  
    if ( po_no.equals("0")) {
      po_no = "N/A";
      po_link =  "<td align=center> " + po_no + " </td>" ;
    } else {
      po_link =  "<td align=center><a href=\"javascript:fnView('" + po_no + "');\">" + po_no + "</a></td>";
    }
  
    outS += "<tr align=center bgcolor='" + color_code + "'>" +
            "<td> " + (i+1) + " </td>" +
            "<td nowrap> " + pr_date + " </td>" +
            "<td nowrap> " + sc_date + " </td>" +
            po_link +
            "<td> " + style_no + "</td>" +
            "<td> " + brand_nm + " </td>" +
            "<td nowrap> " + order_date + " </td>" +
            "<td> " + ex_factory_week + " </td>" +
            "<td nowrap> " + ex_factory_date + " </td>" +
            "<td nowrap> " + delivery + " </td>" +
            "<td> " + trans_type + " </td>" +
            "<td align='left'> " + buyer + " </td>" +
            "<td align='left'> " + supplier + " </td>" +
            "<td align='left' nowrap>" + inspector + (inspector_nm.equals("") ? "" : "-") + inspector_nm + "</td>" +
            "<td nowrap> " + inspect_date + " </td>" +
            "<td> " + inspect_status + " </td>" +
            "</tr>" ;
  }

  // for last line
  outS += "<tr align=center bgcolor=" + color_code + ">" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td><b>" + tmpSupplierCnt + "</b></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td align='left'><b>" + tmpSupplier + "</b></td>" +
          "<td></td>" +
          "<td></td>" +
          "<td></td>" +
          "</tr>" ;
}

// print user brand options
String userBrandOptions = "<option value='' " + (ag_brand.equals("") ? "selected" : "") + ">All</option>";

for (int i = 0; i < matrix2.getRowCount(); i++) {
  int j = 0;
  String code = matrix2.getRowData(i).getData(j++);
  String codeName = matrix2.getRowData(i).getData(j++);

  userBrandOptions += "<option value='" + code + "'"
                    + (ag_brand.equals(code) ? " selected" : "") + ">" + codeName + "</option>";
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ag_from_date ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_to_date ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( userBrandOptions ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print((ag_brand));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((ag_from_date));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((ag_to_date));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( outS ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string11, 0, _jsp_string11.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/qc_report.jsp"), -3981876016985109151L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/calendar/calendar.htm"), 2970746783289767368L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string8;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string5;
  private final static char []_jsp_string3;
  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  private final static char []_jsp_string6;
  private final static char []_jsp_string7;
  private final static char []_jsp_string9;
  private final static char []_jsp_string11;
  private final static char []_jsp_string10;
  static {
    _jsp_string8 = "'>\n<input type=hidden name=ag_to_date    value='".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n".toCharArray();
    _jsp_string2 = "\n<Div id='popCal' style='POSITION:absolute;visibility:hidden;border:1px ridge;width:10'>\n  <iframe name=\"popFrame\" src=\"/common/calendar/popcjs.htm\" frameborder=\"0\" style=\"border:1 solid #EBF6FD\"  frameborder=\"0\" scrolling=\"no\" width=176 height=215>\n  </iframe>\n</DIV>\n<!--SCRIPT event=onclick() for=document>document.all['popCal'].style.visibility = \"hidden\";</SCRIPT-->\n<script language='javascript'>\nfunction setVisibility() {\n  document.all['popCal'].style.visibility = 'hidden';\n}\n\ndocument.onclick = setVisibility;\n</script>\n".toCharArray();
    _jsp_string5 = "' style='cursor:hand' readonly onclick=\"javascript:popFrame.fPopCalendar(this, this, document.all['popCal'], 'RIGHT', event);\"></td>\n  <td width=\"15%\" class=\"table_header_center\">Brand</td>\n  <td width=\"25%\" class=\"table_bg_bright\"><SELECT NAME=ag_brand>".toCharArray();
    _jsp_string3 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\nfunction submit(frm)\n{\n  frm.submit();\n}\n\nfunction fnView(po_no_selected) {\n  frmMain.po_no_selected.value = po_no_selected;\n  frmMain.action = \"./po_detail.jsp\";\n  frmMain.submit();\n}\n\nfunction fnExcel(frm) {\n  if (confirm(\"Do you want to download the data as an excel file?\"))\n  {\n    frm.action=\"./qc_report_excel.jsp\";\n    frm.target = document.hidenFrame.name;\n    frm.submit();\n  }\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Q.C Roster</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM name='frmMain' ACTION=\"qc_report.jsp\" METHOD=POST>\n<input type='hidden' name='po_no_selected'>\n<tr>\n  <td width=\"15%\" class=\"table_header_center\">Ship Date</td>\n  <td width=\"25%\" class=\"table_bg_bright\"><input type='text' name='ag_from_date' size='10' value='".toCharArray();
    _jsp_string4 = "' style='cursor:hand' readonly onclick=\"javascript:popFrame.fPopCalendar(this, this, document.all['popCal'], 'RIGHT', event);\">\n    ~ <input type='text' name='ag_to_date' size='10' value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string6 = "</SELECT></td>\n  <td width=\"20%\" class=\"table_bg_bright_center\"><INPUT TYPE=BUTTON VALUE=\"Search\" ONCLICK='submit(this.form);'>\n    <input type='button' value='Excel' onclick='fnExcel(document.form2);'></td>\n</tr>\n</form>\n</table>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n<TABLE border=0 width=100% CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<form name='form2' method='post'>\n<input type=hidden name=ag_brand      value='".toCharArray();
    _jsp_string7 = "'>\n<input type=hidden name=ag_from_date    value='".toCharArray();
    _jsp_string9 = "'>\n</form>\n<TR class=\"table_header_center\">\n  <TD>No</TD>\n  <TD>PR Date</TD>\n  <TD>SC Date</TD>\n  <TD>PO No.</TD>\n  <TD>Item No.</TD>\n  <TD>Brand</TD>\n  <TD>PO Date</TD>\n  <TD>Ship.Week</TD>\n  <TD>Ship.Date</TD>\n  <TD>Delivery</TD>\n  <TD>Trans.Type</TD>\n  <TD>Buyer</TD>\n  <TD>Supplier</TD>\n  <TD>Inspector</TD>\n  <TD>Inspect Date</TD>\n  <TD>FI P/F</TD>\n</TR>\n".toCharArray();
    _jsp_string11 = "\n</td></tr></table>\n<iframe width=\"0\" height=\"0\" name=\"hidenFrame\"></iframe>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string10 = "\n</TABLE>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n".toCharArray();
  }
}