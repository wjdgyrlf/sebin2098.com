/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._pnl;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import common.util.*;
import dbconn.*;

public class _delivery_0status_0gi_0list__jsp extends com.caucho.jsp.JavaPage
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

String _otherid = "";
String _othername = "";

try {
  _otherid = (String) session.getAttribute("otherid");

  if (_otherid == null || _otherid.length() == 0) {
    response.sendRedirect("/pnl/login_first.html");
    return;
  }

  _othername = (String) session.getAttribute("othername");
} catch( Exception e ) {
  response.sendRedirect("/pnl/login_first.html");
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
      
String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

String ag_supplier = request.getParameter("ag_supplier");
String ag_brand = request.getParameter("ag_brand");
String ag_date_type = request.getParameter("ag_date_type");
String ag_from_date = request.getParameter("ag_from_date");
String ag_to_date = request.getParameter("ag_to_date");
String ag_po_no = request.getParameter("ag_po_no");
String ag_style_no = request.getParameter("ag_style_no");
String ag_orderby = request.getParameter("ag_orderby");
String ag_buyer = request.getParameter("ag_buyer");
if (ag_supplier == null) ag_supplier = "";
if (ag_brand == null) ag_brand = "";
if (ag_date_type == null) ag_date_type = "SH";
if (ag_from_date == null || ag_to_date == null) {
  ag_from_date = DateUtil.getRelativeDateString(new java.util.Date(), 0, 0, -6, "dd/MM/yyyy");
  ag_to_date = DateUtil.getToday("dd/MM/yyyy");
}
if (ag_po_no == null) ag_po_no = "";
if (ag_style_no == null) ag_style_no = "";
if (ag_orderby == null) ag_orderby = "6";
if (ag_buyer == null) ag_buyer = "";

Connection connPronto = null;
Connection connScm = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.MatrixDataSet matrix3 = null;
dbconn.MatrixDataSet matrix4 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";
String sql2 = "";
String sql3 = "";
String sql4 = "";
int iRet = 0;
int iRet2 = 0;
int iRet3 = 0;
String outS = "";

// query for po list
sql = " select  k.shm_description, "
    + "         g.cr_shortname, "
    + "         a.po_order_no, "
    + "         b.xspo_style, "
    + "         f.sys_description, "
    + "         decode(to_char(b.ex_factory_date, 'yyyy'), '1900', '', to_char(b.ex_factory_date, 'dd/mm/yyyy')), "
    + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
    + "         a.po_order_status, "
    + "         j.code_name, "
    + "         i.code_name, "
    + "         to_char(h.handover_date, 'dd/mm/yyyy'), "
    + "         h.handover_yn, "
    + "         to_char(h.cutoff_date, 'dd/mm/yyyy'), "
    + "         h.cutoff_yn, "
    + "         to_char(h.departure_date, 'dd/mm/yyyy'), "
    + "         h.departure_yn, "
    + "         to_char(h.arrival_date, 'dd/mm/yyyy'), "
    + "         h.arrival_yn, "
    + "         to_char(h.collecting_date, 'dd/mm/yyyy'), "
    + "         h.collecting_yn, "
    + "         to_char(h.delivery_date, 'dd/mm/yyyy'), "
    + "         h.delivery_yn "
    + " from    por5mf4 a "
    + "         inner join xstpu22 b "
    + "           on a.po_order_no = b.xspo_po_order_no "
    + "           and a.backorder_flag = b.backorder_flag "
    + "         left outer join sys5tbl5 f "
    + "           on a.po_user_name = f.sys_tbl_code "
    + "           and f.sys_tbl_type = 'RR' "
    + "         inner join cre5mfi g "
    + "           on a.cre_accountcode = g.cre_accountcode "
    + "         inner join delivery_status_01t@scm h "
    + "           on a.po_order_no = h.po_no "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, z.sht_category, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) k "
    + "           on b.xspo_stock_group = k.stock_group "
    + "         left outer join nad5mfa l "
    + "           on g.cre_accountcode = l.accountcode "
    + "           and l.na_type = 'C' "
    + "         left outer join shipment_02t@scm m "
    + "           on h.po_no = m.po_no "
    + "         left outer join shipment_01t@scm n "
    + "           on m.invoice_no = n.invoice_no "
    + "           and m.supplier_id = n.supplier_id "
    + "         left outer join vg_common_code@scm i "
    + "           on n.shipping_port = i.code "
    + "           and i.type = 'SHIPPING_PORT' "
    + "         left outer join vg_common_code@scm j "
    + "           on i.related_code = j.code "
    + "           and j.type = 'COUNTRY_CODE' "
    + " where   a.backorder_flag = ' ' "
    + " and     a.po_order_status between '70' and '90' "
    + " and     g.cr_supplier_grp = 'FOB' "
    + " and     not exists "
    + "         ( "
    + "           select  1 "
    + "           from    user_supplier_02t@scm z "
    + "           where   z.user_type like 'C%' "
    + "           and     z.supplier_class = l.na_country_code "
    + "         ) ";

if (ag_po_no.length() > 0 || ag_style_no.length() > 0) {
  if (ag_po_no.length() > 0) {
    String sql_po_no = "'" + ag_po_no.replaceAll(",", "','") + "'";
    sql += " and    a.po_order_no in (" + sql_po_no + ") " ;
  }

  if (ag_style_no.length() > 0) {
    sql += " and    b.xspo_style like '" + ag_style_no + "%' " ;
  }
} else {
  if (!ag_supplier.equals("")) {
    sql += " and    a.cre_accountcode = '" + ag_supplier + "' ";
  }

  if (!ag_brand.equals("")) {
    sql += " and    k.sht_category = '" + ag_brand + "' ";
  }

  if (!ag_buyer.equals("")) {
    sql += " and    a.po_user_name = '" + ag_buyer + "' ";
  }
  
  String tmpDate = "";
  if (ag_date_type.equals("SH")) {
    tmpDate = "b.ex_factory_date";
  } else if (ag_date_type.equals("DE")) {
    tmpDate = "a.po_arrival_date";
  }

  sql += " and " + tmpDate + " >= to_date('" + ag_from_date + "', 'dd/mm/yyyy') "
       + " and " + tmpDate + " < to_date('" + ag_to_date + "', 'dd/mm/yyyy')+1 ";
}

sql += " order by ";

if ( ag_orderby.equals("1"))  {
  sql += " a.po_order_no ";
}
else if ( ag_orderby.equals("2"))  {
  sql += " g.cr_shortname, a.po_order_no ";
}
else if ( ag_orderby.equals("3"))  {
  sql += " f.sys_description, a.po_order_no ";
}
else if ( ag_orderby.equals("4"))  {
  sql += " b.ex_factory_date, a.po_order_no " ;
}
else if ( ag_orderby.equals("5"))  {
  sql += " a.po_arrival_date, a.po_order_no " ;
}
else if ( ag_orderby.equals("6"))  {
  sql += " a.po_arrival_date, g.cr_shortname, a.po_order_no " ;
}
//out.println(sql);

// query for apess supplier list
sql2 =  " select  id, name "
      + " from    login_01t a "
      + " where   user_group = 'F' "
      + " and     not exists "
      + "         ( "
      + "           select  1 "
      + "           from    user_supplier_02t z "
      + "           where   z.user_type like 'C%' "
      + "           and     z.supplier_class = a.supplier_class "
      + "         ) "
      + " order by name ";

// query for buyer list
sql3 =  " select  distinct a.po_user_name, b.sys_description "
      + " from    por5mf4 a "
      + "         inner join sys5tbl5 b "
      + "           on a.po_user_name = b.sys_tbl_code "
      + "           and b.sys_tbl_type = 'RR' "
      + "         inner join cre5mfi c "
      + "           on a.cre_accountcode = c.cre_accountcode "
      + "         inner join xstpu22 d "
      + "           on a.po_order_no = d.xspo_po_order_no "
      + "         left outer join nad5mfa f "
      + "           on c.cre_accountcode = f.accountcode "
      + "           and f.na_type = 'C' "
      + " where   a.backorder_flag = ' ' "
      + " and     a.po_order_status between '40' and '90' "
      + " and     trim(a.po_user_name) is not null "
      + " and     c.cr_supplier_grp = 'FOB' "
      + " and     not exists "
      + "         ( "
      + "           select  1 "
      + "           from    user_supplier_02t@scm z "
      + "           where   z.user_type like 'C%' "
      + "           and     z.supplier_class = f.na_country_code "
      + "         ) "
      + " order by b.sys_description ";

// read user brand code info
sql4 = " select  code, code_name "
     + " from    vg_common_code "
     + " where   type = 'USER_BRAND' "
     + " and     nvl(related_code, ' ') <> 'Z' "
     + " and     use_yn = 'Y' "
     + " order by sort_order ";

try {

  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");
  matrix = new dbconn.MatrixDataSet();
  matrix2 = new dbconn.MatrixDataSet();
  matrix3 = new dbconn.MatrixDataSet();
  matrix4 = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();

  // po list
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  connPronto.commit();

  // supplier list
  connScm = dbPool.getConnection("intranet");
  iRet2 = dataProcess.RetrieveData(sql2, matrix2, connScm);

  // buyer list
  iRet3 = dataProcess.RetrieveData(sql3, matrix3, connPronto);

  // brand list
  dataProcess.RetrieveData(sql4, matrix4, connScm);

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in delivery_status_gi_list : " + e.getMessage());
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
int editableCnt = 0;

for (int i = 0; i < iRet; i++) {
  int j = 0;
  String brandName = matrix.getRowData(i).getData(j++);
  String supplier_name = matrix.getRowData(i).getData(j++);
  String po_no = matrix.getRowData(i).getData(j++);
  String style_no = matrix.getRowData(i).getData(j++);
  String buyer = matrix.getRowData(i).getData(j++);
  String ex_factory_date = matrix.getRowData(i).getData(j++);
  String delivery_date = matrix.getRowData(i).getData(j++);
  String po_status = matrix.getRowData(i).getData(j++);
  String shipping_country_name = matrix.getRowData(i).getData(j++);
  String shipping_port_name = matrix.getRowData(i).getData(j++);
  String cus_handover_date = matrix.getRowData(i).getData(j++);
  String cus_handover_yn = matrix.getRowData(i).getData(j++);
  String cus_cutoff_date = matrix.getRowData(i).getData(j++);
  String cus_cutoff_yn = matrix.getRowData(i).getData(j++);
  String cus_departure_date = matrix.getRowData(i).getData(j++);
  String cus_departure_yn = matrix.getRowData(i).getData(j++);
  String cus_arrival_date = matrix.getRowData(i).getData(j++);
  String cus_arrival_yn = matrix.getRowData(i).getData(j++);
  String cus_collecting_date = matrix.getRowData(i).getData(j++);
  String cus_collecting_yn = matrix.getRowData(i).getData(j++);
  String cus_delivery_date = matrix.getRowData(i).getData(j++);
  String cus_delivery_yn = matrix.getRowData(i).getData(j++);

  String colour_code = "#FFFFF0";

  if (cus_delivery_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_delivery_yn.equals("N")) {
    colour_code = "#ADD8E6";
  } else if (cus_collecting_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_collecting_yn.equals("N")) {
    colour_code = "#ADD8E6";
  } else if (cus_arrival_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_arrival_yn.equals("N")) {
    colour_code = "#ADD8E6";
  } else if (cus_departure_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_departure_yn.equals("N")) {
    colour_code = "#ADD8E6";
  } else if (cus_cutoff_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_cutoff_yn.equals("N")) {
    colour_code = "#ADD8E6";
  } else if (cus_handover_yn.equals("Y")) {
    colour_code = "#FF0000";
  } else if (cus_handover_yn.equals("N")) {
    colour_code = "#ADD8E6";
  }

  outS += "<tr align='center' bgcolor='" + colour_code + "'>"
        + " <td>" + (i+1) + "</td>"
        + " <td>" + brandName + "</td>"
        + " <td>" + supplier_name + "</td>"
        + " <td>" + po_no + "</td>"
        + " <td>" + style_no + "</td>"
        + " <td>" + buyer + "</td>"
        + " <td>" + ex_factory_date + "</td>"
        + " <td>" + delivery_date + "</td>"
        + " <td nowrap>" + (shipping_port_name.equals("") ? "" : shipping_country_name + " - " + shipping_port_name) + "</td>"
        + " <td nowrap>" + cus_handover_date + "</td>"
        + " <td>" + (cus_handover_yn.equals("") ? "" : (cus_handover_yn.equals("Y") ? "Yes" : "No")) + "</td>"
        + " <td nowrap>" + cus_cutoff_date + "</td>"
        + " <td>" + (cus_cutoff_yn.equals("") ? "" : (cus_cutoff_yn.equals("Y") ? "Yes" : "No")) + "</td>"
        + " <td nowrap>" + cus_departure_date + "</td>"
        + " <td>" + (cus_departure_yn.equals("") ? "" : (cus_departure_yn.equals("Y") ? "Yes" : "No")) + "</td>"
        + " <td nowrap>" + cus_arrival_date + "</td>"
        + " <td>" + (cus_arrival_yn.equals("") ? "" : (cus_arrival_yn.equals("Y") ? "Yes" : "No")) + "</td>"
        + " <td nowrap>" + cus_collecting_date + "</td>"
        + " <td>" + (cus_collecting_yn.equals("") ? "" : (cus_collecting_yn.equals("Y") ? "Yes" : "No")) + "</td>"
        + " <td nowrap>" + cus_delivery_date + "</td>"
        + " <td>" + (cus_delivery_yn.equals("") ? "" : (cus_delivery_yn.equals("Y") ? "Yes" : "No")) + "</td>"
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

// print buyer list
String buyerList = "<option value=''>All</option>";
for (int i = 0; i < iRet3; i++) {
  int j = 0;
  String buyer_id = matrix3.getRowData(i).getData(j++);
  String buyer_name = matrix3.getRowData(i).getData(j++);

  buyerList += "<option value='"+ buyer_id + "'" 
             + (ag_buyer.equals(buyer_id) ? " selected" : "") + ">" 
             + buyer_name + "</option>";
}

// print user brand options
String userBrandOptions = "<option value='' " + (ag_brand.equals("") ? "selected" : "") + ">All</option>";

for (int i = 0; i < matrix4.getRowCount(); i++) {
  int j = 0;
  String code = matrix4.getRowData(i).getData(j++);
  String codeName = matrix4.getRowData(i).getData(j++);

  userBrandOptions += "<option value='" + code + "'"
                    + (ag_brand.equals(code) ? " selected" : "") + ">" + codeName + "</option>";
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( supplierList ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( userBrandOptions ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_date_type.equals("SH") ? "selected" : "" ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_date_type.equals("DE") ? "selected" : "" ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_from_date ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( ag_to_date ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( buyerList ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( ag_style_no ));
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
       if(ag_orderby.equals("6")) out.print("SELECTED"); 
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( outS ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string20, 0, _jsp_string20.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("pnl/delivery_status_gi_list.jsp"), -8467447558227585481L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("pnl/login_check.jsp"), 1301888329285731440L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/calendar/calendar.htm"), 2970746783289767368L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string7;
  private final static char []_jsp_string13;
  private final static char []_jsp_string3;
  private final static char []_jsp_string17;
  private final static char []_jsp_string10;
  private final static char []_jsp_string5;
  private final static char []_jsp_string18;
  private final static char []_jsp_string1;
  private final static char []_jsp_string2;
  private final static char []_jsp_string4;
  private final static char []_jsp_string12;
  private final static char []_jsp_string20;
  private final static char []_jsp_string15;
  private final static char []_jsp_string16;
  private final static char []_jsp_string6;
  private final static char []_jsp_string14;
  private final static char []_jsp_string0;
  private final static char []_jsp_string11;
  private final static char []_jsp_string9;
  private final static char []_jsp_string19;
  private final static char []_jsp_string8;
  static {
    _jsp_string7 = ">DE Date</option>\n    </select>\n    <input type='text' name='ag_from_date' size='10' value='".toCharArray();
    _jsp_string13 = ">PO No.</OPTION>\n    <OPTION value=\"2\" ".toCharArray();
    _jsp_string3 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnSubmit(frm)\n{\n  frm.ag_po_no.value = jf_AllTrim(frm.ag_po_no.value);\n  frm.ag_style_no.value = jf_AllTrim(frm.ag_style_no.value);\n  frm.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Delivery Status(After Goods-In)</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM name='frmMain' ACTION=\"delivery_status_gi_list.jsp\" METHOD=POST>\n<tr>\n  <td width=\"10%\" class=\"table_header_center\">Supplier</td>\n  <td width=\"32%\" class=\"table_bg_bright\"><SELECT NAME='ag_supplier'>".toCharArray();
    _jsp_string17 = ">Del. Date</OPTION>\n    <OPTION value=\"6\" ".toCharArray();
    _jsp_string10 = "</SELECT></td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">PO#</td>\n  <td class=\"table_bg_bright\"><input type=text name='ag_po_no' value='".toCharArray();
    _jsp_string5 = "</SELECT></td>\n  <td width=\"28%\" class=\"table_bg_bright_center\" colspan='2' rowspan='2'><INPUT TYPE='BUTTON' VALUE=\"Search\" ONCLICK='fnSubmit(this.form)'></td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">Date</td>\n  <td class=\"table_bg_bright\"><select name='ag_date_type'>\n    <option value='SH' ".toCharArray();
    _jsp_string18 = ">Del. Date+Supplier</OPTION>\n    </SELECT></td>\n</tr>\n</form>\n</table>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n</td></tr></table>\n\n<table width=\"1700\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\"><tr><td>\n<TABLE border=0 width=99% CELLPADDING=0 CELLSPACING=1 class=\"table_bg\">\n<tr class='table_header_center'>\n  <td colspan='8'>PO Details</td>\n  <td colspan='13'>Delivery Status</td>\n</tr>\n<TR class=\"table_header_center\">\n  <TD>No</TD>\n  <TD>Brand</TD>\n  <TD>Supplier</TD>\n  <TD>PO No.</TD>\n  <TD>Style No.</TD>\n  <TD>Buyer</TD>\n  <TD>Ship Date</TD>\n  <TD>Delivery Date</TD>\n  <TD>Shipping Port</TD>\n  <TD>Handover Date</TD>\n  <TD>Fixed</TD>\n  <TD>Cut Off Date</TD>\n  <TD>Fixed</TD>\n  <TD>Departure Date</TD>\n  <TD>Fixed</TD>\n  <TD>Arrival Date</TD>\n  <TD>Fixed</TD>\n  <TD>Collecting Date</TD>\n  <TD>Fixed</TD>\n  <TD>Delivery Date</TD>\n  <TD>Fixed</TD>\n</TR>\n".toCharArray();
    _jsp_string1 = "\n\n\n\n".toCharArray();
    _jsp_string2 = "\n<Div id='popCal' style='POSITION:absolute;visibility:hidden;border:1px ridge;width:10'>\n  <iframe name=\"popFrame\" src=\"/common/calendar/popcjs.htm\" frameborder=\"0\" style=\"border:1 solid #EBF6FD\"  frameborder=\"0\" scrolling=\"no\" width=176 height=215>\n  </iframe>\n</DIV>\n<!--SCRIPT event=onclick() for=document>document.all['popCal'].style.visibility = \"hidden\";</SCRIPT-->\n<script language='javascript'>\nfunction setVisibility() {\n  document.all['popCal'].style.visibility = 'hidden';\n}\n\ndocument.onclick = setVisibility;\n</script>\n".toCharArray();
    _jsp_string4 = "</SELECT></td>\n  <td width=\"10%\" class=\"table_header_center\">Brand</td>\n  <td width=\"20%\" class=\"table_bg_bright\"><SELECT NAME='ag_brand'>".toCharArray();
    _jsp_string12 = "' size='10' maxlength='6'></td>\n  <td width=\"10%\" class=\"table_header_center\">Order by</td>\n  <td width=\"18%\" class=\"table_bg_bright\"><SELECT NAME='ag_orderby'>\n    <OPTION value=\"1\" ".toCharArray();
    _jsp_string20 = "\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string15 = ">Buyer</OPTION>\n    <OPTION value=\"4\" ".toCharArray();
    _jsp_string16 = ">Ship Date</OPTION>\n    <OPTION value=\"5\" ".toCharArray();
    _jsp_string6 = ">SH Date</option>\n    <option value='DE' ".toCharArray();
    _jsp_string14 = ">Supplier</OPTION>\n    <OPTION value=\"3\" ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string11 = "' size='40' maxlength='200'></td>\n  <td class=\"table_header_center\">Style#</td>\n  <td class=\"table_bg_bright\"><input type=text name='ag_style_no' value='".toCharArray();
    _jsp_string9 = "' style='cursor:hand' readonly\n    onclick=\"javascript:popFrame.fPopCalendar(this, this, document.all['popCal'], 'RIGHT', event);\">\n    </td>\n  <td class=\"table_header_center\">Buyer</td>\n  <td class=\"table_bg_bright\"><SELECT NAME='ag_buyer'>".toCharArray();
    _jsp_string19 = "\n</TABLE>\n</td></tr></table>\n\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>\n".toCharArray();
    _jsp_string8 = "' style='cursor:hand' readonly\n    onclick=\"javascript:popFrame.fPopCalendar(this, this, document.all['popCal'], 'RIGHT', event);\">\n    ~\n    <input type='text' name='ag_to_date' size='10' value='".toCharArray();
  }
}
