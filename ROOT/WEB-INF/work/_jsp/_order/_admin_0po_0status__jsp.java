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
import common.util.*;
import dbconn.*;

public class _admin_0po_0status__jsp extends com.caucho.jsp.JavaPage
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
      
String ag_supplier = request.getParameter("ag_supplier");
String ag_apess_only = request.getParameter("ag_apess_only");
String ag_from_date = request.getParameter("ag_from_date");
String ag_to_date = request.getParameter("ag_to_date");
String ag_status = request.getParameter("ag_status");
String ag_orderby = request.getParameter("ag_orderby");
String ag_brand = request.getParameter("ag_brand");
String ag_po_no = request.getParameter("ag_po_no");
String ag_style_no = request.getParameter("ag_style_no");
if (ag_supplier == null) ag_supplier = "";
if (ag_apess_only == null) ag_apess_only = "";
if (ag_from_date == null || ag_to_date == null) {
  ag_from_date = ag_to_date = DateUtil.getToday("dd/MM/yyyy");
}
if (ag_status == null) ag_status = "";
if (ag_orderby == null) ag_orderby = "1";
if (ag_brand == null) ag_brand = "1";
if (ag_po_no == null) ag_po_no = "";
if (ag_style_no == null) ag_style_no = "";

Connection connPronto = null;
Connection connScm = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";
String sql2 = "";
int iRet = 0;
int iRet2 = 0;
String outS = "";

// query for po list
sql = " select  g.cr_shortname, "
    + "         to_char(c.xpoa_ts_created+10/24, 'dd/mm/yyyy'), "
    + "         to_char(d.xpoa_ts_created+10/24, 'dd/mm/yyyy'), "
    + "         a.po_order_no, "
    + "         b.xspo_style, "
    + "         case "
    + "           when a.po_order_status = '25' then 'Firm planned' "
    + "           when a.po_order_status between '40' and '80' then 'On order' "
    + "           when a.po_order_status = '90' then 'Completed' "
    + "           when a.po_order_status = '99' then 'Cancelled' "
    + "           else a.po_order_status "
    + "         end, "
    + "         to_char(a.po_order_date, 'dd/mm/yyyy'), "
    + "         decode(to_char(b.ex_factory_date, 'yyyy'), '1900', '', to_char(b.ex_factory_date, 'dd/mm/yyyy')), "
    + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
    + "         f.sys_description, "
    + "         h.inspector, "
    + "         to_char(h.inspect_date, 'dd/mm/yyyy'), "
    + "         i.name, "
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
    + "         left outer join xpoaudt0 d "
    + "           on a.po_order_no = d.xpoa_po_order_no "
    + "           and a.backorder_flag = c.backorder_flag "
    + "           and d.xpoa_change_type = 'STAT' "
    + "           and d.xpoa_status = '25' "
    + "           and d.xpoa_old_value = '25' "
    + "           and d.xpoa_new_value = '40' "
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
    + "         inner join cre5mfi g "
    + "           on a.cre_accountcode = g.cre_accountcode "
    + "         left outer join po_style_etc@scm h "
    + "           on a.po_order_no = h.po_no "
    + "         left outer join vg_inspector@scm i "
    + "           on h.inspector = i.code "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, z.sht_category, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) j "
    + "           on b.xspo_stock_group = j.stock_group "
    + "         left outer join nad5mfa k "
    + "           on g.cre_accountcode = k.accountcode "
    + "           and k.na_type = 'C' "
    + " where   a.backorder_flag = ' ' "
    + " and     ( a.po_order_status between '25' and '90' "
    + "           or (a.po_order_status = '99' and c.xpoa_ts_created is not null) ) ";

if (ag_po_no.length() > 0 || ag_style_no.length() > 0) {
  if (ag_po_no.length() > 0) {
    sql += " and    a.po_order_no like '" + ag_po_no + "%' " ;
  }

  if (ag_style_no.length() > 0) {
    sql += " and    b.xspo_style like '" + ag_style_no + "%' " ;
  }
} else {
  if (ag_apess_only.equals("Y")) {
    sql += " and     k.na_country_code in "
         + "         ( "
         + "           select  supplier_class "
         + "           from    user_supplier_02t@scm "
         + "           where   user_type like 'C%' "
         + "         ) ";
  } else {
    if (!ag_supplier.equals("")) {
      sql += " and    a.cre_accountcode = '" + ag_supplier + "' ";
    }
  }

  sql += " and    a.po_order_date between to_date('" + ag_from_date + "', 'dd/mm/yyyy') and to_date('" + ag_to_date + "', 'dd/mm/yyyy') ";

  if (!ag_status.equals("")) {
    if (ag_status.equals("40")) {
      sql += " and    a.po_order_status between '40' and '80' ";
    } else {
      sql += " and    a.po_order_status = '" + ag_status + "' ";
    }
  }

  if (!ag_brand.equals("")) {
    sql += " and    j.sht_category = '" + ag_brand + "' ";
  }

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
else if ( ag_orderby.equals("5"))  {
   sql += " order by b.ex_factory_date ";
}
//out.println(sql);

// query for supplier list
sql2 = " select id, name from login_01t order by name ";

try {

  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  matrix2 = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();

  // po list
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  connPronto.commit();

  // supplier list
  connScm = dbPool.getConnection("intranet");
  iRet2 = dataProcess.RetrieveData(sql2, matrix2, connScm);

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in admin_po_status : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }

  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

// print po list
for (int i = 0; i < iRet; i++) {
  int j = 0;
  String supplier_name = matrix.getRowData(i).getData(j++);
  String pr_date = matrix.getRowData(i).getData(j++);
  String sc_confirmed_date = matrix.getRowData(i).getData(j++);
  String po_no = matrix.getRowData(i).getData(j++);
  String style_no = matrix.getRowData(i).getData(j++);
  String po_status = matrix.getRowData(i).getData(j++);
  String po_order_date = matrix.getRowData(i).getData(j++);
  String ex_factory_date = matrix.getRowData(i).getData(j++);
  String delivery_date = matrix.getRowData(i).getData(j++);
  String buyer = matrix.getRowData(i).getData(j++);
  String inspector = matrix.getRowData(i).getData(j++);
  String inspect_date = matrix.getRowData(i).getData(j++);
  String inspector_name = matrix.getRowData(i).getData(j++);
  String spec_date = matrix.getRowData(i).getData(j++);

  String colour_code = "";
  if (i%2 == 0) {
    colour_code = "#FFFFF0";
  } else {
    colour_code = "#EEEEE0";
  }

  if (!spec_date.equals("")) {
    spec_date = "<a href=\"javascript:fnView('" + po_no + "');\">" 
              + spec_date.substring(6) + "/" + spec_date.substring(4, 6) + "/" + spec_date.substring(0, 4) + "</a>";
  }

  outS += "<tr align='center' bgcolor='" + colour_code + "'>"
        + " <td>" + (i+1) + "</td>"
        + " <td>" + supplier_name + "</td>"
        + " <td>" + pr_date + "</td>"
        + " <td>" + sc_confirmed_date + "</td>"
        + " <td><a href=\"javascript:fnView('" + po_no + "')\">" + po_no + "</td>"
        + " <td>" + style_no + "</td>"
        + " <td>" + po_status + "</td>"
        + " <td>" + po_order_date + "</td>"
        + " <td>" + ex_factory_date + "</td>"
        + " <td>" + delivery_date + "</td>"
        + " <td>" + buyer + "</td>"
        + " <td>" + inspector + (inspector_name.equals("") ? "" : "-") + inspector_name + "</td>"
        + " <td>" + inspect_date + "</td>"
        + " <td>" + spec_date + "</td>"
        + "</tr>";
}

// print supplier list
String supplierList = "<option value=''>All</option>";

for (int i = 0; i < iRet2; i++) {
  int j = 0;
  String supplier_id = matrix2.getRowData(i).getData(j++);
  String supplier_name = matrix2.getRowData(i).getData(j++);

  supplierList += "<option value='"+ supplier_id + "'" 
                + (ag_supplier.equals(supplier_id) ? " selected" : "") + ">" 
                + supplier_id + "-" + supplier_name + "</option>";
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( supplierList ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_apess_only.equals("Y") ? "checked" : "" ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_from_date ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_to_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
       if(ag_status.equals("")) out.print("SELECTED"); 
      out.write(_jsp_string8, 0, _jsp_string8.length);
       if(ag_status.equals("25")) out.print("SELECTED"); 
      out.write(_jsp_string9, 0, _jsp_string9.length);
       if(ag_status.equals("40")) out.print("SELECTED"); 
      out.write(_jsp_string10, 0, _jsp_string10.length);
       if(ag_status.equals("90")) out.print("SELECTED"); 
      out.write(_jsp_string11, 0, _jsp_string11.length);
       if(ag_status.equals("99")) out.print("SELECTED"); 
      out.write(_jsp_string12, 0, _jsp_string12.length);
       if(ag_orderby.equals("1")) out.print("SELECTED"); 
      out.write(_jsp_string13, 0, _jsp_string13.length);
       if(ag_orderby.equals("2")) out.print("SELECTED"); 
      out.write(_jsp_string14, 0, _jsp_string14.length);
       if(ag_orderby.equals("3")) out.print("SELECTED"); 
      out.write(_jsp_string15, 0, _jsp_string15.length);
       if(ag_orderby.equals("4")) out.print("SELECTED"); 
      out.write(_jsp_string16, 0, _jsp_string16.length);
       if(ag_orderby.equals("5")) out.print("SELECTED"); 
      out.write(_jsp_string17, 0, _jsp_string17.length);
       if(ag_brand.equals("1")) out.print("SELECTED"); 
      out.write(_jsp_string18, 0, _jsp_string18.length);
       if(ag_brand.equals("2")) out.print("SELECTED"); 
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( ag_style_no ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( outS ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string23, 0, _jsp_string23.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/admin_po_status.jsp"), 1142370654545927036L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/calendar/calendar.htm"), 2970746783289767368L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string12;
  private final static char []_jsp_string14;
  private final static char []_jsp_string4;
  private final static char []_jsp_string5;
  private final static char []_jsp_string7;
  private final static char []_jsp_string21;
  private final static char []_jsp_string1;
  private final static char []_jsp_string8;
  private final static char []_jsp_string2;
  private final static char []_jsp_string23;
  private final static char []_jsp_string6;
  private final static char []_jsp_string9;
  private final static char []_jsp_string10;
  private final static char []_jsp_string19;
  private final static char []_jsp_string3;
  private final static char []_jsp_string18;
  private final static char []_jsp_string0;
  private final static char []_jsp_string13;
  private final static char []_jsp_string20;
  private final static char []_jsp_string22;
  private final static char []_jsp_string11;
  private final static char []_jsp_string16;
  private final static char []_jsp_string15;
  private final static char []_jsp_string17;
  static {
    _jsp_string12 = "> Cancelled </OPTION>\n    </SELECT>\n  </td>\n  <TD width='10%'class='table_header_center'>Order by</TD>\n  <TD width='20%' class='table_bg_bright'>\n    <SELECT NAME='ag_orderby'>\n    <OPTION value=\"1\" ".toCharArray();
    _jsp_string14 = "> Buyer </OPTION>\n    <OPTION value=\"3\" ".toCharArray();
    _jsp_string4 = "\n    </SELECT>\n    (* APESS Only <input type=checkbox name='ag_apess_only' value='Y' ".toCharArray();
    _jsp_string5 = ">)\n  </td>\n  <TD width='30%' class='table_bg_bright_center' colspan='2'><INPUT TYPE=BUTTON VALUE=\"Search\" ONCLICK='fnSubmit(this.form)'></td>\n</TR>\n<TR>\n  <td width='10%' class='table_header_center'>PO DATE</td>\n  <td width='30%' class='table_bg_bright'>\n    <input type=\"text\" name=\"ag_from_date\" size=\"10\" value=\"".toCharArray();
    _jsp_string7 = "\" readonly>\n    <img src=\"/img/calendar.gif\" style=\"cursor:hand\" align=\"absmiddle\" onclick=\"javascript:popFrame.fPopCalendar(this, document.frmMain.ag_to_date, document.all['popCal'], 'RIGHT', event);\">\n  </td>\n  <TD width='10%'class='table_header_center'>PO Status</TD>\n  <TD width='20%' class='table_bg_bright'>\n    <SELECT NAME='ag_status'>\n    <OPTION value=\"\" ".toCharArray();
    _jsp_string21 = "' size='10' maxlength='6'></TD>\n</TR>\n</FORM>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1090\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n<TABLE width='99%' border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<TR class='table_header_center'>\n  <TD>No</TD>\n  <TD>Supplier</TD>\n  <TD>PR Date</TD>\n  <TD>Confirmed</TD>\n  <TD>PO No.</TD>\n  <TD>Item No.</TD>\n  <TD>PO Status</TD>\n  <TD>PO Date</TD>\n  <TD>Ship Date</TD>\n  <TD>Delivery</TD>\n  <TD>Buyer</TD>\n  <TD>Inspector</TD>\n  <TD>Insp. Date</TD>\n  <TD>Spec Sheet</TD>\n</TR>\n".toCharArray();
    _jsp_string1 = "\n\n\n\n".toCharArray();
    _jsp_string8 = "> All </OPTION>\n    <OPTION value=\"25\" ".toCharArray();
    _jsp_string2 = "\n<Div id='popCal' style='POSITION:absolute;visibility:hidden;border:1px ridge;width:10'>\n  <iframe name=\"popFrame\" src=\"/common/calendar/popcjs.htm\" frameborder=\"0\" style=\"border:1 solid #EBF6FD\"  frameborder=\"0\" scrolling=\"no\" width=176 height=215>\n  </iframe>\n</DIV>\n<!--SCRIPT event=onclick() for=document>document.all['popCal'].style.visibility = \"hidden\";</SCRIPT-->\n<script language='javascript'>\nfunction setVisibility() {\n  document.all['popCal'].style.visibility = 'hidden';\n}\n\ndocument.onclick = setVisibility;\n</script>\n".toCharArray();
    _jsp_string23 = "\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string6 = "\" readonly>\n    <img src=\"/img/calendar.gif\" style=\"cursor:hand\" align=\"absmiddle\" onclick=\"javascript:popFrame.fPopCalendar(this, document.frmMain.ag_from_date, document.all['popCal'], 'RIGHT', event);\">\n    ~\n    <input type=\"text\" name=\"ag_to_date\" size=\"10\" value=\"".toCharArray();
    _jsp_string9 = "> Firm planned </OPTION>\n    <OPTION value=\"40\" ".toCharArray();
    _jsp_string10 = "> On order </OPTION>\n    <OPTION value=\"90\" ".toCharArray();
    _jsp_string19 = "> TEMT </OPTION>\n    </SELECT></TD>\n  <TD class='table_header_center'>PO#</TD>\n  <TD class='table_bg_bright'><input type=text name='ag_po_no' value='".toCharArray();
    _jsp_string3 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnSubmit(frm)\n{\n  frm.ag_po_no.value = jf_AllTrim(frm.ag_po_no.value);\n  frm.ag_style_no.value = jf_AllTrim(frm.ag_style_no.value);\n  frm.submit();\n}\n\nfunction fnView(po_no_selected) {\n  frmMain.po_no_selected.value = po_no_selected;\n  frmMain.action = \"./po_detail.jsp\";\n  frmMain.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">[ADMIN]Purchase Order History</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<TABLE WIDTH=99% border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM name='frmMain' ACTION=\"admin_po_status.jsp\" METHOD=POST>\n<input type='hidden' name='po_no_selected'>\n<TR>\n  <TD width='10%' class='table_header_center'>Supplier</TD>\n  <TD width='60%' class='table_bg_bright' colspan='3'>\n    <SELECT NAME='ag_supplier'>\n      ".toCharArray();
    _jsp_string18 = "> Valleygirl </OPTION>\n    <OPTION value=\"2\" ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string13 = "> PR Date </OPTION>\n    <OPTION value=\"2\" ".toCharArray();
    _jsp_string20 = "' size='10' maxlength='6'></TD>\n  <TD class='table_header_center'>Style#</TD>\n  <TD class='table_bg_bright'><input type=text name='ag_style_no' value='".toCharArray();
    _jsp_string22 = "\n</TABLE>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n".toCharArray();
    _jsp_string11 = "> Completed </OPTION>\n    <OPTION value=\"99\" ".toCharArray();
    _jsp_string16 = "> Delivery Date </OPTION>\n    <OPTION value=\"5\" ".toCharArray();
    _jsp_string15 = "> PO No. </OPTION>\n    <OPTION value=\"4\" ".toCharArray();
    _jsp_string17 = "> Ex. Date </OPTION>\n    </SELECT></TD>\n</tr>\n<TR>\n  <TD class='table_header_center'>Brand</TD>\n  <TD class='table_bg_bright'><SELECT NAME='ag_brand'>\n    <OPTION value=\"1\" ".toCharArray();
  }
}