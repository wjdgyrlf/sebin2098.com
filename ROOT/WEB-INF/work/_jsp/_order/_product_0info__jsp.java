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

public class _product_0info__jsp extends com.caucho.jsp.JavaPage
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
      
String MONEY_FORMAT = "###,##0.00";
String imgUrl = "Image<br>Not Ready";

String ag_style_no = request.getParameter("ag_style_no");
if (ag_style_no == null) ag_style_no = "";

String po_no = "&nbsp;";
String item_class = "&nbsp;";
String item_group = "&nbsp;";
String supplier_name = "&nbsp;";
String brand = "&nbsp;";
String style_no = "&nbsp;";
double currency_unit_price = 0.0d;
double ex_factory_price = 0.0d;
double discount_price = 0.0d;
double ex_dc_price = 0.0d;
String currency_type = "&nbsp;";
String buyer = "&nbsp;";
String supplier_item = "&nbsp;";
String season = "&nbsp;";
String order_type = "&nbsp;";
String trans_type = "&nbsp;";
String order_date = "&nbsp;";
String ex_factory_date = "&nbsp;";
String delivery_date = "&nbsp;";
String shipping_method = "&nbsp;";
double air_cost = 0.0d;
String fabric = "&nbsp;";
String receipt_text = "&nbsp;";
String item_text = "&nbsp;";
String po_notes = "";
String spec_sheets = "";
boolean isNullExFactoryPrice = false;
double commission_rate = 0.0d;
String orderControlYn = "";

Connection connPronto = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.MatrixDataSet matrix3 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";
int iRet = 0;
int iRet2 = 0;
int iRet3 = 0;
String outS = "";

if (ag_style_no.length() > 0) {
  // po detail query
  sql = " select  a.po_order_no, "
      + "         b.xspo_stock_group, "
      + "         c.cr_shortname, "
      + "         d.shm_description, "
      + "         b.xspo_style, "
      + "         b.vendor_price, "
      + "         h.ex_factory_price, "
      + "         b.xspo_discount, "
      + "         decode(a.po_currency_code, ' ', 'AUD', a.po_currency_code), "
      + "         nvl(e.sys_description, a.po_user_name), "
      + "         trim(b.sup_stock_code), "
      + "         b.season_and_seq, "
      + "         b.xspo_order_type, "
      + "         b.xspo_trans_type, "
      + "         to_char(a.po_order_date, 'dd/mm/yyyy'), "
      + "         decode(to_char(b.ex_factory_date, 'yyyy'), '1900', '', to_char(b.ex_factory_date, 'dd/mm/yyyy')), "
      + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
      + "         c.cr_supplier_grp, "
      + "         b.xspo_air_cost, "
      + "         trim(nvl(f.sys_description, b.xspo_fabric)), "
      + "         b.receipt_text, "
      + "         b.xspo_item_text||b.xspo_item_text_2, "
      + "         nvl(k.rate, 0), "
      + "         j.order_control_yn "
      + " from    por5mf4 a "
      + "         inner join xstpu22 b "
      + "           on a.po_order_no = b.xspo_po_order_no "
      + "           and a.backorder_flag = b.backorder_flag "
      + "         inner join cre5mfi c "
      + "           on a.cre_accountcode = c.cre_accountcode "
      + "         left outer join "
      + "         ( "
      + "           select z.stock_group, y.shm_description "
      + "           from   stkhierachymst0 y "
      + "                  inner join stkhiertree3 z "
      + "                    on y.shm_code = z.sht_category "
      + "                    and y.shm_type = 3 "
      + "         ) d "
      + "           on b.xspo_stock_group = d.stock_group "
      + "         left outer join sys5tbl5 e "
      + "           on a.po_user_name = e.sys_tbl_code "
      + "           and e.sys_tbl_type = 'RR' "
      + "         left outer join sys5tbl5 f "
      + "           on b.xspo_fabric = f.sys_tbl_code "
      + "           and f.sys_tbl_type = 'SY' "
      + "         left outer join xpoaudt0 g "
      + "           on a.po_order_no = g.xpoa_po_order_no "
      + "           and a.backorder_flag = g.backorder_flag "
      + "           and g.xpoa_change_type = 'STAT' "
      + "           and g.xpoa_status = '00' "
      + "           and g.xpoa_old_value = '00' "
      + "           and g.xpoa_new_value = '25' "
      + "         left outer join po_style_etc@scm h "
      + "           on a.po_order_no = h.po_no "
      + "         left outer join nad5mfa i "
      + "           on c.cre_accountcode = i.accountcode "
      + "           and i.na_type = 'C' "
      + "         left outer join user_supplier_02t@scm j "
      + "           on i.na_country_code = j.supplier_class "
      + "         left outer join supplier_commission@scm k "
      + "           on j.supplier_class = k.supplier_class "
      + "           and a.po_order_date between k.from_date and k.to_date "
      + " where   a.backorder_flag = ' ' "
      + " and     b.xspo_style = " + ag_style_no
      + " and     ( a.po_order_status between '25' and '90' "
      + "           or (a.po_order_status = '99' and g.xpoa_ts_created is not null) ) "
      + " and     i.na_type = 'C' ";

  if (_adminid == null) {
    sql += " and     ( "
         + "           a.cre_accountcode = '" + scmid + "' ";

    if (usertype.startsWith("C")) {
      sql += "         or i.na_country_code in "
           + "         ( "
           + "           select  supplier_class "
           + "           from    user_supplier_02t@scm "
           + "           where   user_type = '" + usertype + "' "
           + "         ) ";
    }
  
    sql += "         ) ";
  }

  sql += " order by a.po_order_no desc ";
  //out.println(sql);

  try {

    dbPool = DBConnManager.getInstance();
    connPronto = dbPool.getConnection("pronto");
    matrix = new dbconn.MatrixDataSet();
    matrix2 = new dbconn.MatrixDataSet();
    matrix3 = new dbconn.MatrixDataSet();
    dataProcess = new dbconn.DataProcess();

    // po detail
    iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

    if (iRet > 0) {
      // po notes
      sql = " select  xsn_note_text "
          + " from    xsstnot0 "
          + " where   xsn_po_order_no = " + matrix.getRowData(0).getData(0)
          + " and     backorder_flag = ' ' "
          + " and     xsn_note_type = 'SN' "
          + " order by xsn_note_seq ";

      iRet2 = dataProcess.RetrieveData(sql, matrix2, connPronto);

      // po spec sheets
      //sql = " select  distinct b.ql_code, substr(b.ql_path, instr(b.ql_path, '\\', -1)+1), "
      sql = " select  distinct "
          + "         substr(b.ql_path, instr(b.ql_path, '\\', -1, 2)+1, instr(b.ql_path, '\\', -1)-instr(b.ql_path, '\\', -1, 2)-1), "
          + "         substr(b.ql_path, instr(b.ql_path, '\\', -1)+1), "
          + "         substr(substr(ql_description, instr(ql_description, ' ') + 2), 5) "
          + "         || substr(substr(b.ql_description, instr(b.ql_description, ' ') + 2), 3, 2) "
          + "         || substr(substr(b.ql_description, instr(b.ql_description, ' ') + 2), 1, 2) spec_date "
          + " from    xstpu22 a "
          + "         inner join qlinks0 b "
          + "           on a.xspo_style = substr(b.ql_description, 1, instr(b.ql_description, ' ') - 1) "
          + " where   a.xspo_po_order_no = " + matrix.getRowData(0).getData(0)
          + " and     a.backorder_flag = ' ' "
          + " and     b.ql_data_area = '" + _dataArea + "' "
          + " and     b.ql_table = 'xspo-style-purchase-order' "
          + " order by spec_date ";

      iRet3 = dataProcess.RetrieveData(sql, matrix3, connPronto);  
    }
  
    connPronto.commit();
  
  } catch (Exception e) {
    if (connPronto != null) {
      try { connPronto.rollback(); } catch (Exception ex) {}
    }
  
    System.out.println("Exception in product_info : " + e.getMessage());
    throw e;
  } finally {
    if (connPronto != null) {
      dbPool.freeConnection("pronto", connPronto);
    }
  }
}

// set po details
if (iRet > 0) {
  int j = 0;
  po_no = matrix.getRowData(0).getData(j++);
  item_group = matrix.getRowData(0).getData(j++);
  supplier_name = matrix.getRowData(0).getData(j++);
  brand = matrix.getRowData(0).getData(j++);
  style_no = matrix.getRowData(0).getData(j++);
  currency_unit_price = Double.parseDouble(matrix.getRowData(0).getData(j++));
  
  String org_ex_factory_price = matrix.getRowData(0).getData(j++);

  discount_price = Double.parseDouble(matrix.getRowData(0).getData(j++));
  currency_type = matrix.getRowData(0).getData(j++);
  buyer = matrix.getRowData(0).getData(j++);
  supplier_item = matrix.getRowData(0).getData(j++);
  season = matrix.getRowData(0).getData(j++);
  order_type = matrix.getRowData(0).getData(j++);
  trans_type = matrix.getRowData(0).getData(j++);
  order_date = matrix.getRowData(0).getData(j++);
  ex_factory_date = matrix.getRowData(0).getData(j++);
  delivery_date = matrix.getRowData(0).getData(j++);
  shipping_method = matrix.getRowData(0).getData(j++);
  air_cost = Double.parseDouble(matrix.getRowData(0).getData(j++));
  fabric = matrix.getRowData(0).getData(j++);
  receipt_text = matrix.getRowData(0).getData(j++);
  item_text = matrix.getRowData(0).getData(j++);
  commission_rate = Double.parseDouble(matrix.getRowData(0).getData(j++));
  orderControlYn = matrix.getRowData(0).getData(j++);

  item_class = item_group.substring(0, 1);

  // ex_factory_price : APESS suppplier only
  // if ex_factory_price exists use that value
  // else
  //   before 1 July ex_factory_price = unit_price
  //   from 1 July ex_factory_price = unit_price/_EXRate
  if (orderControlYn.equals("Y")) {
    if (!org_ex_factory_price.equals("")) {
      ex_factory_price = Double.parseDouble(org_ex_factory_price);
    } else {
      isNullExFactoryPrice = true;
      ex_factory_price = Math.round(currency_unit_price*100.0d/(1.0d + commission_rate))/100.0d;
    }

    // calculate ex_dc_price
    if (discount_price > 0.0d && ex_factory_price > 0.0d) {
      double tmp_rate = Math.round((currency_unit_price/ex_factory_price - 1)*100.0d)/100.0d;
      ex_dc_price = Math.round(discount_price*100.0d/(1.0d + tmp_rate))/100.0d;
    }
  }

  // set po notes
  for (int i = 0; i < iRet2; i++) {
    po_notes += matrix2.getRowData(i).getData(0);
  }
  
  // set po spec sheets
  for (int i = 0; i < iRet3; i++) {
    int k = 0;
    String spec_brand = matrix3.getRowData(i).getData(k++);
    String spec_file = matrix3.getRowData(i).getData(k++);
    if (i > 0) spec_sheets += ", ";
    spec_sheets += "<a href=\"javascript:fnDownload('" + spec_brand + "/" + spec_file + "');\">" + spec_file + "</a>";
  }
}

// set item imagae
File imgFile = new File(application.getRealPath(_styleImgURL) + File.separator + style_no + ".jpg");
if (imgFile.exists()) {
  imgUrl = "<img src='" + _styleImgURL + "/" + style_no + ".jpg' width='110' height='169'>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
if (orderControlYn.equals("Y")) {

      out.write(_jsp_string3, 0, _jsp_string3.length);
      
}

      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( orderControlYn.equals("Y") ? "oncontextmenu='return false' ondragstart='return false' onselectstart='return false'" : "" ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_style_no ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( po_no ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( brand ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( style_no ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( supplier_name ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      
if (orderControlYn.equals("Y")) {

      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( usertype.startsWith("C") ? "EX-D/C PRICE" : "DISCOUNT PRICE" ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( item_class ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( item_group ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( currency_unit_price > 0.0d ? StringUtil.formatNumber(currency_unit_price, MONEY_FORMAT) : "TBA" ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( currency_type ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( !isNullExFactoryPrice ? "style='color:blue;'" : "" ));
      out.write('>');
      out.print(( ex_factory_price > 0.0d ? StringUtil.formatNumber(ex_factory_price, MONEY_FORMAT) : "TBA" ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( currency_type ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      
  if (usertype.startsWith("C")) {

      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( ex_dc_price > 0.0d ? StringUtil.formatNumber(ex_dc_price, MONEY_FORMAT) + " (" + currency_type + ")" : "&nbsp;" ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      
} else {

      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( discount_price > 0.0d ? StringUtil.formatNumber(discount_price, MONEY_FORMAT) + " (" + currency_type + ")" : "&nbsp;" ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      
}

      out.write(_jsp_string19, 0, _jsp_string19.length);
      
} else {

      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( item_class ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( item_group ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( currency_unit_price > 0.0d ? StringUtil.formatNumber(currency_unit_price, MONEY_FORMAT) : (iRet > 0 ? "TBA" : "") ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( currency_type ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( discount_price > 0.0d ? StringUtil.formatNumber(discount_price, MONEY_FORMAT) + "(" + currency_type + ")" : "&nbsp;" ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      
}

      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print(( buyer ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( supplier_item.equals("") ? "&nbsp;" : supplier_item ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( season ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( order_type ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( trans_type ));
      out.write(_jsp_string24, 0, _jsp_string24.length);
      out.print(( order_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ex_factory_date.equals("") ? "&nbsp;" : ex_factory_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( delivery_date ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( shipping_method ));
      out.write(_jsp_string25, 0, _jsp_string25.length);
      out.print(( StringUtil.formatNumber(air_cost, MONEY_FORMAT) ));
      out.write(_jsp_string26, 0, _jsp_string26.length);
      out.print(( fabric.equals("") ? "&nbsp;" : fabric ));
      out.write(_jsp_string27, 0, _jsp_string27.length);
      out.print(( receipt_text ));
      out.write(_jsp_string28, 0, _jsp_string28.length);
      out.print(( item_text ));
      out.write(_jsp_string29, 0, _jsp_string29.length);
      out.print(( spec_sheets ));
      out.write(_jsp_string30, 0, _jsp_string30.length);
      out.print(( imgUrl ));
      out.write(_jsp_string31, 0, _jsp_string31.length);
      out.print(( po_notes ));
      out.write(_jsp_string32, 0, _jsp_string32.length);
      out.print(( _specSheetUrl ));
      out.write(_jsp_string33, 0, _jsp_string33.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string34, 0, _jsp_string34.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/product_info.jsp"), 4223351923682250804L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string33;
  private final static char []_jsp_string13;
  private final static char []_jsp_string17;
  private final static char []_jsp_string24;
  private final static char []_jsp_string6;
  private final static char []_jsp_string15;
  private final static char []_jsp_string11;
  private final static char []_jsp_string8;
  private final static char []_jsp_string19;
  private final static char []_jsp_string27;
  private final static char []_jsp_string31;
  private final static char []_jsp_string7;
  private final static char []_jsp_string29;
  private final static char []_jsp_string1;
  private final static char []_jsp_string32;
  private final static char []_jsp_string23;
  private final static char []_jsp_string4;
  private final static char []_jsp_string12;
  private final static char []_jsp_string10;
  private final static char []_jsp_string9;
  private final static char []_jsp_string3;
  private final static char []_jsp_string14;
  private final static char []_jsp_string16;
  private final static char []_jsp_string26;
  private final static char []_jsp_string21;
  private final static char []_jsp_string20;
  private final static char []_jsp_string0;
  private final static char []_jsp_string28;
  private final static char []_jsp_string22;
  private final static char []_jsp_string2;
  private final static char []_jsp_string5;
  private final static char []_jsp_string30;
  private final static char []_jsp_string18;
  private final static char []_jsp_string25;
  private final static char []_jsp_string34;
  static {
    _jsp_string33 = "'>\n<input type='hidden' name='attachFile'>\n<input type='hidden' name='attachRealFile'>\n</form>\n</table>\n".toCharArray();
    _jsp_string13 = " (".toCharArray();
    _jsp_string17 = "\n    <td>".toCharArray();
    _jsp_string24 = "</td>\n</tr>\n<tr class='table_header'>\n  <td>ORDER DATE</td>\n  <td>SHIP DATE</td>\n  <td>*DELIVERY DATE</td>\n  <td>SHIPPING METHOD</td>\n  <td>AIR COST</td>\n</tr>\n<tr class='table_list_center'>\n  <td>".toCharArray();
    _jsp_string6 = "\">\n  <INPUT TYPE='button' VALUE=\"Search\" onclick='fnSubmit(this.form);'></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</form>\n</table>\n\n<table width='650' border='1' bordercolor='black' cellspacing='0' cellpadding='0' align='center'>\n<tr class='table_header'>\n  <td width='20%'>PO NO</td>\n  <td width='20%'>BRAND</td>\n  <td width='20%'>STYLE(GROUP) NO</td>\n  <td width='40%' colspan='2'>SUPPLIER</td>\n</tr>\n<tr class='table_list_center'>\n  <td>".toCharArray();
    _jsp_string15 = "</span> (".toCharArray();
    _jsp_string11 = "</td>\n  </tr>\n  <tr class='table_list_center'>\n    <td>".toCharArray();
    _jsp_string8 = "</td>\n  <td colspan='2'>".toCharArray();
    _jsp_string19 = "\n  </tr>\n".toCharArray();
    _jsp_string27 = "</td>\n</tr>\n<tr>\n  <td class='table_header'>RECEIPT TEXT</td>\n  <td colspan='4' class='table_list'>".toCharArray();
    _jsp_string31 = "</td>\n  <td colspan='4' class='table_list_no_height' valign='top'>".toCharArray();
    _jsp_string7 = "</td>\n  <td>".toCharArray();
    _jsp_string29 = "</td>\n</tr>\n<tr>\n  <td class='table_header'>SPEC SHEET</td>\n  <td colspan='4' class='table_list'>".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string32 = "&nbsp;</td>\n</tr>\n<form name='form2' method='post'>\n<input type='hidden' name='attachPath' value='".toCharArray();
    _jsp_string23 = "\n<tr class='table_header'>\n  <td>BUYER</td>\n  <td>SUPPLIER ITEM</td>\n  <td>SEASON</td>\n  <td>ORDER TYPE</td>\n  <td>TRANS. TYPE</td>\n</tr>\n<tr class='table_list_center'>\n  <td>".toCharArray();
    _jsp_string4 = "\n<body\n  ".toCharArray();
    _jsp_string12 = "</td>\n    <td>".toCharArray();
    _jsp_string10 = "\n  <tr class='table_header'>\n    <td>ITEM CLASS</td>\n    <td>ITEM GROUP</td>\n    <td>APESS PRICE</td>\n    <td width='20%'>EX-FACTORY PRICE</td>\n    <td width='20%'>".toCharArray();
    _jsp_string9 = "</td>\n</tr>\n".toCharArray();
    _jsp_string3 = "\n<style type=\"text/css\" media=\"print\">\nBODY {display:none;visibility:hidden;}\n</style>\n".toCharArray();
    _jsp_string14 = ")</td>\n    <td><span ".toCharArray();
    _jsp_string16 = ")</td>\n".toCharArray();
    _jsp_string26 = "</td>\n</tr>\n<tr>\n  <td class='table_header'>FABRIC</td>\n  <td colspan='4' class='table_list'>".toCharArray();
    _jsp_string21 = ")</td>\n    <td>".toCharArray();
    _jsp_string20 = "\n  <tr class='table_header'>\n    <td>ITEM CLASS</td>\n    <td>ITEM GROUP</td>\n    <td>UNIT PRICE</td>\n    <td width='20%'>DISCOUNT PRICE</td>\n    <td width='20%'>&nbsp;</td>\n  </tr>\n  <tr class='table_list_center'>\n    <td>".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string28 = "</td>\n</tr>\n<tr>\n  <td class='table_header'>ITEM TEXT</td>\n  <td colspan='4' class='table_list'>".toCharArray();
    _jsp_string22 = "</td>\n    <td>&nbsp;</td>\n  </tr>\n".toCharArray();
    _jsp_string2 = "\n<html>\n<head>\n<title></title>\n<link href='style_detail.css' rel='stylesheet' type='text/css'>\n<script language='javascript' src='/common/js/util.js'></script>\n<script language=JavaScript>\nfunction fnSubmit(frm) {\n  if (!jf_IsNumeric(frm.ag_style_no.value)) {\n    alert(\"Enter Style No. Numbers are only accepted.\");\n    frm.ag_style_no.select();\n    return;\n  }\n\n  frm.submit();\n}\n\nfunction fnDownload(file) {\n  with (document.form2) {\n    attachFile.value = file;\n    attachRealFile.value = file;\n    action = '/common/download.jsp';\n    target = 'hiddenFrm';\n    submit();\n  }\n}\n</script>\n</head>\n".toCharArray();
    _jsp_string5 = "\n  leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Product Information</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table border='0' width='650' align='center'>\n<form name='frmMain' method='post' action='./product_info.jsp'>\n<tr>\n<TD align=center width=100%>Style No.\n  <input type=text name='ag_style_no' value=\"".toCharArray();
    _jsp_string30 = "&nbsp;</td>\n</tr>\n<tr height='170'>\n  <td class='table_list_no_height' align='center'>".toCharArray();
    _jsp_string18 = "</td>\n".toCharArray();
    _jsp_string25 = "</td>\n  <td>AU$ ".toCharArray();
    _jsp_string34 = "\n</td></tr></table>\n<iframe name='hiddenFrm' src='' width='0' height='0' frameborder='0'></iframe>\n</body>\n</html>\n".toCharArray();
  }
}
