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

public class _po_0confirm_0search__jsp extends com.caucho.jsp.JavaPage
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
      
String ag_orderby = request.getParameter("ag_orderby");
String ag_brand = request.getParameter("ag_brand");
String ag_buyer = request.getParameter("ag_buyer");
if ( ag_orderby == null ) ag_orderby = "1";
if ( ag_brand == null ) ag_brand = "";
if (ag_buyer == null) ag_buyer = "";

Connection connScm = null;
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

// query for po confirm
sql = " select  to_char(c.xpoa_ts_created+10/24, 'dd/mm/yyyy'), "
    + "         a.po_order_no, "
    + "         b.xspo_style, "
    + "         to_char(h.scm_pr_date, 'dd/mm/yyyy'), "
    + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
    + "         f.sys_description, "
    + "         to_char(d.xpoa_ts_created+10/24, 'dd/mm/yyyy hh24:mi'), "
    + "         g.cr_shortname, "
    + "         e.spec_date "
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
    + "         left outer join "
    + "         ( "
    + "           select  y.xpoa_po_order_no, y.backorder_flag, max(y.xpoa_ts_created+10/24) xpoa_ts_created "
    + "           from    xpoaudt0 y "
    + "           where   exists ( "
    + "                     select  1 "
    + "                     from    por5mf4 z "
    + "                     where   z.po_order_no = y.xpoa_po_order_no "
    + "                     and     z.backorder_flag = y.backorder_flag "
    + "                     and     z.po_order_status = '25' "
    + "                   ) "
    + "           and     y.xpoa_status = '25' "
    + "           group by y.xpoa_po_order_no, y.backorder_flag "
    + "         ) d "
    + "           on a.po_order_no = d.xpoa_po_order_no "
    + "           and a.backorder_flag = d.backorder_flag "
    + "         left outer join  "
    + "         ( "
    + "           select  substr(e.ql_description, 1, instr(e.ql_description, ' ') - 1) style_no, "
    + "                   max(substr(substr(e.ql_description, instr(e.ql_description, ' ') + 1), 5) "
    + "                   || substr(substr(e.ql_description, instr(e.ql_description, ' ') + 1), 3, 2) "
    + "                   || substr(substr(e.ql_description, instr(e.ql_description, ' ') + 1), 1, 2)) spec_date "
    + "           from    qlinks0 e "
    + "           where   e.ql_data_area = '" + _dataArea + "' "
    + "           and     e.ql_table = 'xspo-style-purchase-order' "
    + "           and     substr(e.ql_description, 1, instr(e.ql_description, ' ') - 1) is not null "
    + "           group by substr(e.ql_description, 1, instr(e.ql_description, ' ') - 1) "
    + "         ) e "
    + "           on to_char(b.xspo_style) = e.style_no "
    + "         left outer join sys5tbl5 f "
    + "           on a.po_user_name = f.sys_tbl_code "
    + "           and f.sys_tbl_type = 'RR' "
    + "         left outer join cre5mfi g "
    + "           on a.cre_accountcode = g.cre_accountcode "
    + "         left outer join po_style_etc@scm h "
    + "           on a.po_order_no = h.po_no "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, z.sht_category, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) i "
    + "           on b.xspo_stock_group = i.stock_group "
    + " where   a.backorder_flag = ' ' "
    + " and     a.cre_accountcode = '" + scmid + "' "
    + " and     a.po_order_status = '25' ";

if (!ag_brand.equals("")) {
  sql += " and     i.sht_category = '" + ag_brand + "' ";
}

if (!ag_buyer.equals("")) {
  sql += " and     a.po_user_name = '" + ag_buyer + "' ";
}

if ( ag_orderby.equals("1"))  {
   sql += " order by c.xpoa_ts_created ";
} 
else if ( ag_orderby.equals("2"))  {
   sql += " order by f.sys_description ";
}
else if ( ag_orderby.equals("3"))  {
   sql += " order by a.po_order_no ";
}
else if ( ag_orderby.equals("4"))  {
   sql += " order by a.po_arrival_date ";
}
//out.println(sql); if (true) return;

// query for buyer list
sql2 =  " select  sys_tbl_code, sys_description "
      + " from    sys5tbl5 "
      + " where   sys_tbl_type = 'RR' "
      + " order by sys_description ";

// read user brand code info
sql3 = " select  code, code_name "
     + " from    vg_common_code "
     + " where   type = 'USER_BRAND' "
     + " and     nvl(related_code, ' ') <> 'Z' "
     + " and     use_yn = 'Y' "
     + " order by sort_order ";

try {

  dbPool = DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  matrix2 = new dbconn.MatrixDataSet();
  matrix3 = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();

  // po confirm list
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  
  // buyer list
  iRet2 = dataProcess.RetrieveData(sql2, matrix2, connPronto);
  
  // brand list
  iRet3 = dataProcess.RetrieveData(sql3, matrix3, connScm);

  connPronto.commit();

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in po_confirm_search : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }

  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }
}

// print po confirmation list
for (int i = 0; i < iRet; i++) {
  int j = 0;
  String pr_date  = matrix.getRowData(i).getData(j++);
  String po_no    = matrix.getRowData(i).getData(j++);
  String style_no = matrix.getRowData(i).getData(j++);
  String scm_pr_date = matrix.getRowData(i).getData(j++);
  String delivery_date = matrix.getRowData(i).getData(j++);
  String buyer_name = matrix.getRowData(i).getData(j++);
  String modified_date = matrix.getRowData(i).getData(j++);
  String supplier_name = matrix.getRowData(i).getData(j++);
  String spec_date = matrix.getRowData(i).getData(j++);

  String colour_code = "";
  if (i%2 == 0) {
    colour_code = "#FFFFF0";
  } else {
    colour_code = "#EEEEE0";
  }

  String colour_font = "";
  if (!modified_date.equals("")) {
    colour_font = "#FF0000";
  } else {
    colour_font = "#000000";
  }

  if (!spec_date.equals("")) {
    spec_date = "<a href=\"javascript:fnView('" + po_no + "');\">" 
              + spec_date.substring(6) + "/" + spec_date.substring(4, 6) + "/" + spec_date.substring(0, 4) + "</a>";
  }

  outS += "<tr align='center' bgcolor='" + colour_code + "'>"
        + " <td><input type='checkbox' name='po_no' value='" + po_no + "'></td>"
        + " <td style='color:" + colour_font + "'>" + (i+1) + "</td>"
        + " <td style='color:" + colour_font + "'>" + pr_date + "</td>"
        + " <td style='color:" + colour_font + "'><a href=\"javascript:fnView('" + po_no + "')\">" + po_no + "</td>"
        + " <td style='color:" + colour_font + "'>" + style_no + "</td>"
        + " <td style='color:" + colour_font + "'>" + delivery_date + "</td>"
        + " <td style='color:" + colour_font + "'>" + buyer_name + "</td>"
        + " <td style='color:" + colour_font + "'>" + modified_date + "</td>"
        + " <td style='color:" + colour_font + "'>" + scm_pr_date + "</td>"
        + " <td style='color:" + colour_font + "'>" + supplier_name + "</td>"
        + " <td style='color:" + colour_font + "'>" + spec_date + "</td>"
        + "</tr>";
}

// buyer list
String buyerList = "<option value=''>All</option>";

for (int i = 0; i < iRet2; i++) {
  int j = 0;
  String buyer_code = matrix2.getRowData(i).getData(j++);
  String buyer_name = matrix2.getRowData(i).getData(j++);

  buyerList += "<option value='"+ buyer_code + "'" 
            + (ag_buyer.equals(buyer_code) ? " selected" : "") + ">" + buyer_name + "</option>";
}

// print user brand options
String userBrandOptions = "<option value=''>All</option>";

for (int i = 0; i < matrix3.getRowCount(); i++) {
  int j = 0;
  String code = matrix3.getRowData(i).getData(j++);
  String codeName = matrix3.getRowData(i).getData(j++);

  userBrandOptions += "<option value='" + code + "'"
                    + (ag_brand.equals(code) ? " selected" : "") + ">" + codeName + "</option>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( userBrandOptions ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( buyerList ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
       if(ag_orderby.equals("1")) out.print("SELECTED"); 
      out.write(_jsp_string5, 0, _jsp_string5.length);
       if(ag_orderby.equals("2")) out.print("SELECTED"); 
      out.write(_jsp_string6, 0, _jsp_string6.length);
       if(ag_orderby.equals("3")) out.print("SELECTED"); 
      out.write(_jsp_string7, 0, _jsp_string7.length);
       if(ag_orderby.equals("4")) out.print("SELECTED"); 
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( ag_brand ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( ag_buyer ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( ag_orderby ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( outS ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/po_confirm_search.jsp"), 2373155709646036279L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string2;
  private final static char []_jsp_string5;
  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  private final static char []_jsp_string12;
  private final static char []_jsp_string13;
  private final static char []_jsp_string11;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  private final static char []_jsp_string7;
  private final static char []_jsp_string0;
  private final static char []_jsp_string9;
  private final static char []_jsp_string3;
  private final static char []_jsp_string10;
  static {
    _jsp_string2 = "\n<HTML>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<HEAD>\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnConfirm(frm)\n{\n  if (!jf_ChkRadioOrCheckBox(frm.po_no)) {\n    alert('Select POs you want to confirm.');\n    return;\n  }\n\n  if (confirm(\"Are you sure to confirm?\")) {\n    frm.action = './po_confirm.jsp';\n    frm.submit();\n  }\n}\n\nfunction fnSubmit(frm)\n{\n   frm.submit();\n}\n\nfunction fnView(po_no_selected) {\n  frmMain.po_no_selected.value = po_no_selected;\n  frmMain.action = \"./po_detail.jsp\";\n  frmMain.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Purchase Order Confirmation</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM NAME='frmMain' ACTION=\"po_confirm_search.jsp\" METHOD=POST>\n<input type='hidden' name='po_no_selected'>\n<tr>\n  <td width=\"12%\" class=\"table_header_center\">Brand</td>\n  <td width=\"16%\" class=\"table_bg_bright\"><SELECT NAME='ag_brand'>".toCharArray();
    _jsp_string5 = ">PR Date</OPTION>\n    <OPTION value=\"2\" ".toCharArray();
    _jsp_string4 = "</SELECT></td>\n  <td width=\"12%\" class=\"table_header_center\">Order by</td>\n  <td width=\"16%\" class=\"table_bg_bright\"><SELECT NAME='ag_orderby'>\n    <OPTION value=\"1\" ".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string12 = "\n<TR class=\"table_list\">\n<TD COLSPAN=11 ALIGN=CENTER>\n<INPUT TYPE=BUTTON VALUE=\"Confirm\" ONCLICK=\"fnConfirm(this.form)\">\n</TD>\n</TR>\n</FORM>\n</TABLE>\n\n".toCharArray();
    _jsp_string13 = "\n\n</td></tr></table>\n</BODY>\n</HTML>".toCharArray();
    _jsp_string11 = "'>\n<TR class=\"table_header_center\">\n<TD>&nbsp;</TD>\n<TD>No</TD>\n<TD>PR Date</TD>\n<TD>PO No.</TD>\n<TD>Style No.</TD>\n<TD>Delivery Date</TD>\n<TD>Buyer</TD>\n<TD>Revised on</TD>\n<TD>Printed on</TD>\n<TD>Supplier</TD>\n<TD>Spec Sheet</TD>\n</TR>\n".toCharArray();
    _jsp_string6 = ">Buyer</OPTION>\n    <OPTION value=\"3\" ".toCharArray();
    _jsp_string8 = ">Delivery Date</OPTION>\n    </SELECT></td>\n  <td width=\"10%\" class=\"table_bg_bright_center\"><INPUT TYPE='BUTTON' VALUE=\"Search\" ONCLICK='fnSubmit(this.form)'></td>\n</tr>\n</form>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n<TR>\n  <td width=100%><font color=red>* Revised orders marked in RED.</font></td>\n</TR>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM method='post'>\n<input type='hidden' name='ag_brand' value='".toCharArray();
    _jsp_string7 = ">PO No.</OPTION>\n    <OPTION value=\"4\" ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string9 = "'>\n<input type='hidden' name='ag_buyer' value='".toCharArray();
    _jsp_string3 = "</SELECT></td>\n  <td width=\"12%\" class=\"table_header_center\">Buyer</td>\n  <td width=\"22%\" class=\"table_bg_bright\"><SELECT NAME='ag_buyer'>".toCharArray();
    _jsp_string10 = "'>\n<input type='hidden' name='ag_orderby' value='".toCharArray();
  }
}