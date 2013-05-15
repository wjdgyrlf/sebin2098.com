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

public class _packing_0form__jsp extends com.caucho.jsp.JavaPage
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
String DATE_FORMAT = "yyyyMMdd";

String po_no_selected = request.getParameter("po_no_selected");
if (po_no_selected == null) po_no_selected = "";

String packing_date = DateUtil.getFmtDateString(new java.util.Date(), DATE_FORMAT);
String item_class = "";
String item_group = "";
String supplier_id = "";
String supplier_name = "";
String brand = "";
String style_no = "";
String buyer = "";
String supplier_item = "";
String season = "";
String order_type = "";
String trans_type = "";
String order_date = "";
String ex_factory_date = "";
String delivery_date = "";
String shipping_method = "";
String fabric = "";
String receipt_text = "";
String item_text = "";
String ratio_group_desc = "";
String po_notes = "";
String[] size_label = null;
String size_labels = "";
String lines = "";
String colourOptions = "";
String orderControlYn = "";

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
int iRet4 = 0;
String outS = "";

// po detail query
sql = " select  b.xspo_stock_group, "
    + "         a.cre_accountcode, "
    + "         c.cr_shortname, "
    + "         d.shm_description, "
    + "         b.xspo_style, "
    + "         nvl(e.sys_description, a.po_user_name), "
    + "         trim(b.sup_stock_code), "
    + "         b.season_and_seq, "
    + "         b.xspo_order_type, "
    + "         b.xspo_trans_type, "
    + "         to_char(a.po_order_date, 'dd/mm/yyyy'), "
    + "         decode(to_char(b.ex_factory_date, 'yyyy'), '1900', '', to_char(b.ex_factory_date, 'dd/mm/yyyy')), "
    + "         to_char(a.po_arrival_date, 'dd/mm/yyyy'), "
    + "         c.cr_supplier_grp, "
    + "         trim(nvl(f.sys_description, b.xspo_fabric)), "
    + "         b.receipt_text, "
    + "         b.xspo_item_text||b.xspo_item_text_2, "
    + "         nvl(i.srg_desc, b.ratio_group_code), "
    + "         k.order_control_yn "
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
    + "         left outer join scsratiogroup0 i "
    + "           on b.ratio_group_code = i.sgsr_group_code "
    + "         inner join nad5mfa j "
    + "           on c.cre_accountcode = j.accountcode "
    + "         left outer join user_supplier_02t@scm k "
    + "           on j.na_country_code = k.supplier_class "
    + " where   a.po_order_no = " + po_no_selected
    + " and     a.backorder_flag = ' ' "
    + " and     j.na_type = 'C' "
    + " and     ( "
    + "           a.cre_accountcode = '" + scmid + "' ";

if (usertype.startsWith("C")) {
  sql += "        or j.na_country_code in "
       + "        ( "
       + "          select  supplier_class "
       + "          from    user_supplier_02t@scm "
       + "          where   user_type = '" + usertype + "' "
       + "          and     order_control_yn = 'Y' "
       + "        ) ";
}

sql += "        ) ";

// po notes
sql2 =  " select  xsn_note_text "
      + " from    xsstnot0 "
      + " where   xsn_po_order_no = " + po_no_selected
      + " and     backorder_flag = ' ' "
      + " and     xsn_note_type = 'SN' "
      + " order by xsn_note_seq ";

// po lines
sql3 =  " select  trim(a.supplier_colour), "
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

// temp packing info
sql4 =  " select  pack_seq, "
      + "         packing_date, "
      + "         ctn_from, "
      + "         ctn_to, "
      + "         colour, "
      + "         pack_qty, "
      + "         ttl_pqty, "
      + "         ttl_qty, "
      + "         ttl_ctn "
      + " from    packing_t "
      + " where   po_no   =  '" + po_no_selected + "' "
      + " and     ( "
      + "           sup_id = '" + scmid + "' ";

if (usertype.startsWith("C")) {
  sql4 += "         or sup_id in "
        + "         ( "
        + "           select  id "
        + "           from    login_01t "
        + "           where   supplier_class in "
        + "                   ( "
        + "                     select  supplier_class "
        + "                     from    user_supplier_02t "
        + "                     where   user_type = '" + usertype + "' "
        + "                     and     order_control_yn = 'Y' "
        + "                   ) "
        + "         ) ";
}

sql4 += "         ) "
      + " order by pack_seq ";

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
    iRet2 = dataProcess.RetrieveData(sql2, matrix2, connPronto);
    iRet3 = dataProcess.RetrieveData(sql3, matrix3, connPronto);
  }

  connPronto.commit();

  // temp packing info
  connScm = dbPool.getConnection("intranet");
  matrix4 = new dbconn.MatrixDataSet();
  iRet4 = dataProcess.RetrieveData(sql4, matrix4, connScm);

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in packing_form : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }

  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

// set po details
if (iRet > 0) {
  int j = 0;
  item_group = matrix.getRowData(0).getData(j++);
  supplier_id = matrix.getRowData(0).getData(j++);
  supplier_name = matrix.getRowData(0).getData(j++);
  brand = matrix.getRowData(0).getData(j++);
  style_no = matrix.getRowData(0).getData(j++);
  buyer = matrix.getRowData(0).getData(j++);
  supplier_item = matrix.getRowData(0).getData(j++);
  season = matrix.getRowData(0).getData(j++);
  order_type = matrix.getRowData(0).getData(j++);
  trans_type = matrix.getRowData(0).getData(j++);
  order_date = matrix.getRowData(0).getData(j++);
  ex_factory_date = matrix.getRowData(0).getData(j++);
  delivery_date = matrix.getRowData(0).getData(j++);
  shipping_method = matrix.getRowData(0).getData(j++);
  fabric = matrix.getRowData(0).getData(j++);
  receipt_text = matrix.getRowData(0).getData(j++);
  item_text = matrix.getRowData(0).getData(j++);
  ratio_group_desc = matrix.getRowData(0).getData(j++);
  orderControlYn = matrix.getRowData(0).getData(j++);

  item_class = item_group.substring(0, 1);

  // set po size labels
  size_label = ratio_group_desc.split(":");

  for (int i = 0; i < size_label.length; i++) {
    size_labels += "<td width='7%'>" + size_label[i] + "</td>";
  }

  for (int i = size_label.length; i < 6; i++) {
    size_labels += "<td width='7%'>&nbsp;</td>";
  }

  // set po notes
  for (int i = 0; i < iRet2; i++) {
    po_notes += matrix2.getRowData(i).getData(0);
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

    colourOptions += "<option value='" + ffb_colour + "^" + pack_size + "'>" + ffb_colour + " " + ratio_desc + "</option>";

    lines += "<tr align='right' class='table_list'>"
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
  lines += "<tr align='right' class='table_header'>"
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

// print packing info
for (int i = 0; i < iRet4; i++) {
  int j = 0;
  String pack_seq = matrix4.getRowData(i).getData(j++);
  packing_date = matrix4.getRowData(i).getData(j++);
  String ctn_from = matrix4.getRowData(i).getData(j++);
  String ctn_to = matrix4.getRowData(i).getData(j++);
  String colour = matrix4.getRowData(i).getData(j++);
  String pack_qty = matrix4.getRowData(i).getData(j++);
  String ttl_pqty = matrix4.getRowData(i).getData(j++);
  String ttl_qty = matrix4.getRowData(i).getData(j++);
  String ttl_ctn = matrix4.getRowData(i).getData(j++);

  String colour_code = "";
  if (i%2 == 0) {
    colour_code = "#FFFFF0";
  } else {
    colour_code = "#EEEEE0";
  }

  outS += "<tr align='right' bgcolor='" + colour_code + "'>"
        + " <td align='center'><input type='checkbox' name='pack_seq' value='" + pack_seq + "'></td>"
        + " <td>" + pack_seq + "</td>"
        + " <td>" + ctn_from + "</td>"
        + " <td>" + ctn_to + "</td>"
        + " <td align='center'>" + colour + "</td>"
        + " <td>" + pack_qty + "</td>"
        + " <td>" + ttl_pqty + "</td>"
        + " <td>" + ttl_qty + "</td>"
        + " <td>" + ttl_ctn + "</td>"
        + "</tr>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( po_no_selected ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( brand ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( style_no ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( supplier_name ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      
if (orderControlYn.equals("Y")) {

      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( item_class ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( item_group ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      
} else {

      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( item_class ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( item_group ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      
}

      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( buyer ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( supplier_item.equals("") ? "&nbsp;" : supplier_item ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( season ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( order_type ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( trans_type ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( order_date ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ex_factory_date.equals("") ? "&nbsp;" : ex_factory_date ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( delivery_date ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( shipping_method ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( fabric.equals("") ? "&nbsp;" : fabric ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( receipt_text ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( item_text ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( po_notes ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( size_labels ));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( lines ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( po_no_selected ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( packing_date ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( supplier_id ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print(( colourOptions ));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print(( po_no_selected ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( supplier_id ));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print(( packing_date ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/packing_form.jsp"), 2423252957436885776L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string21;
  private final static char []_jsp_string18;
  private final static char []_jsp_string10;
  private final static char []_jsp_string4;
  private final static char []_jsp_string14;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  private final static char []_jsp_string12;
  private final static char []_jsp_string16;
  private final static char []_jsp_string13;
  private final static char []_jsp_string24;
  private final static char []_jsp_string23;
  private final static char []_jsp_string7;
  private final static char []_jsp_string8;
  private final static char []_jsp_string5;
  private final static char []_jsp_string22;
  private final static char []_jsp_string15;
  private final static char []_jsp_string11;
  private final static char []_jsp_string6;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string19;
  private final static char []_jsp_string25;
  private final static char []_jsp_string17;
  private final static char []_jsp_string9;
  private final static char []_jsp_string20;
  private final static char []_jsp_string26;
  static {
    _jsp_string21 = "'>\n<tr class=\"table_header_center\">\n  <td width=\"10%\"><b>Group</b></td>\n  <td width=\"12%\"><b>Carton # [From]</b></td>\n  <td width=\"12%\"><b>Carton # [To]</b></td>\n  <td width=\"*\"><b>Colour</b></td>\n  <td width=\"11%\"><b>Pack QTY(per carton)</b></td>\n  <td width=\"11%\"><b>Tot Pack QTY</b></td>\n  <td width=\"11%\"><b>Tot QTY(pcs)</b></td>\n  <td width=\"11%\"><b>Tot CTN QTY</b></td>\n</tr>\n<tr class='table_list' align='center'>\n  <td><input type='text' name='pack_seq' size='4' maxlength='2' onkeypress=\"return jf_EventNumberCheck();\" onblur=\"if(!jf_IsNumeric(this.value)) this.value='';\"></td>\n  <td><input type='text' name='ctn_from' size='4' maxlength='4' value='0' onkeypress=\"return jf_EventNumberCheck();\" onblur='fnCalcQty(this);'></td>\n  <td><input type='text' name='ctn_to' size='4' maxlength='4' value='0' onkeypress=\"return jf_EventNumberCheck();\" onblur='fnCalcQty(this);'></td>\n  <td><select name='colour' onchange='fnCalcQty(this);'>".toCharArray();
    _jsp_string18 = "\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%'><hr width=\"99%\" align=\"center\"></td>\n</tr>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n</table>\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%'><b>B. Packing Template</b></td>\n</tr>\n<tr>\n  <td width='100%'>Note: Group means which have a same details such as color, pack q/ty without carton#. (It should start from 1)</td>\n</tr>\n</table>\n<table width='650' border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<form name='form1' action=\"./packing_add.jsp\" method='post'>\n<input type='hidden' name='po_no_selected' value='".toCharArray();
    _jsp_string10 = "\n<tr class='table_header_center'>\n  <td>BUYER</td>\n  <td>SUPPLIER ITEM</td>\n  <td>SEASON</td>\n  <td>ORDER TYPE</td>\n  <td>TRANS. TYPE</td>\n</tr>\n<tr class='table_bg_bright_center'>\n  <td>".toCharArray();
    _jsp_string4 = "</td>\n  <td colspan='2'>".toCharArray();
    _jsp_string14 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>ITEM TEXT</td>\n  <td colspan='4' class='table_bg_bright'>".toCharArray();
    _jsp_string3 = "</td>\n  <td>".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string12 = "</td>\n  <td>&nbsp;</td>\n</tr>\n<tr>\n  <td class='table_header_center'>FABRIC</td>\n  <td colspan='4' class='table_bg_bright'>".toCharArray();
    _jsp_string16 = "</td>\n</tr>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n</table>\n<table width='650' border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<tr class='table_header_center'>\n  <td width='34%' colspan='2'>COLOUR</td>\n  <td width='8%' rowspan='2'>RATIO</td>\n  <td width='42%' colspan='6'>SIZE</td>\n  <td width='16%' colspan='2'>QTY</td>\n</tr>\n<tr class='table_header_center'>\n  <td width='17%'>SP COLOUR</td>\n  <td width='17%'>COLOUR</td>\n  ".toCharArray();
    _jsp_string13 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>RECEIPT TEXT</td>\n  <td colspan='4' class='table_bg_bright'>".toCharArray();
    _jsp_string24 = "' size='8' maxlength=8' readonly onfocus='this.blur();'></td>\n</tr>\n</table>\n<table width='650' border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<tr class=\"table_header_center\">\n  <td width=\"2%\"><input type='checkbox' checked disabled></td>\n  <td width=\"10%\"><b>Group</b></td>\n  <td width=\"12%\"><b>Carton # [From]</b></td>\n  <td width=\"12%\"><b>Carton # [To]</b></td>\n  <td width=\"*\"><b>Colour</b></td>\n  <td width=\"12%\"><b>Pack QTY(per carton)</b></td>\n  <td width=\"12%\"><b>Tot Pack QTY</b></td>\n  <td width=\"12%\"><b>Tot QTY(pcs)</b></td>\n  <td width=\"12%\"><b>Tot CTN QTY</b></td>\n</tr>\n".toCharArray();
    _jsp_string23 = "'>\n<tr>\n  <td width='40%'><b>C. Packing Template List</b></td>\n  <td width='60%' align='right'>Created Date(yyyymmdd): <input type='text' name='packing_date' value='".toCharArray();
    _jsp_string7 = "</td>\n    <td>".toCharArray();
    _jsp_string8 = "</td>\n    <td>&nbsp;</td>\n    <td>&nbsp;</td>\n    <td>&nbsp;</td>\n  </tr>\n".toCharArray();
    _jsp_string5 = "</td>\n</tr>\n".toCharArray();
    _jsp_string22 = "</select></td>\n  <td><input type='text' name='pack_qty' size='5' maxlength='5' value='0' onkeypress=\"return jf_EventNumberCheck();\" onblur='fnCalcQty(this);'></td>\n  <td class='table_list_dark'><input type='text' name='ttl_pqty' value='0' size='5' maxlength='5' readonly onfocus='this.blur();'></td>\n  <td class='table_list_dark'><input type='text' name='ttl_qty' value='0' size='5' maxlength='5' readonly onfocus='this.blur();'></td>\n  <td class='table_list_dark'><input type='text' name='ttl_ctn' value='1' size='5' maxlength='5' readonly onfocus='this.blur();'></td>\n</tr>\n</table>\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%' align='right'><input type='button' value=\"Add\" onclick='fnAdd(this.form)'></td>\n</tr>\n</form>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%'><hr width=\"99%\" align=\"center\"></td>\n</tr>\n</table>\n<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n</table>\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<form name='form2' method='post'>\n<input type='hidden' name='po_no_selected' value='".toCharArray();
    _jsp_string15 = "</td>\n</tr>\n<tr>\n  <td colspan='5' class='table_bg_bright' valign='top'>".toCharArray();
    _jsp_string11 = "</td>\n</tr>\n<tr class='table_header_center'>\n  <td>ORDER DATE</td>\n  <td>SHIP DATE</td>\n  <td>*DELIVERY DATE</td>\n  <td>SHIPPING METHOD</td>\n  <td>AIR COST</td>\n</tr>\n<tr class='table_bg_bright_center'>\n  <td>".toCharArray();
    _jsp_string6 = "\n  <tr class='table_header_center'>\n    <td>ITEM CLASS</td>\n    <td>ITEM GROUP</td>\n    <td>APESS PRICE</td>\n    <td width='20%'>EX-FACTORY PRICE</td>\n    <td width='20%'>EX-D/C PRICE</td>\n  </tr>\n  <tr class='table_bg_bright_center'>\n    <td>".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string2 = "\n<html>\n<head>\n<title></title>\n<link href='/common/css/style.css' rel='stylesheet' type='text/css'>\n<script language=\"javaScript\" src=\"/common/js/util.js\"></script>\n<script language=\"javascript\">\nfunction fnCalcQty(obj) {\n  if(obj.type == 'text' && !jf_IsNumeric(obj.value)) {\n    obj.value = 0;\n  }\n\n  var iPackSize = parseInt(obj.form.colour.value.substr(obj.form.colour.value.indexOf(\"^\")+1));\n  var iCartonFrom = parseInt(obj.form.ctn_from.value);\n  var iCartonTo = parseInt(obj.form.ctn_to.value);\n  var iPackQty = parseInt(obj.form.pack_qty.value);\n  var iTtlCtn = iCartonTo - iCartonFrom + 1;\n\n  if (iTtlCtn < 0) {\n    iTtlCtn = 0;\n  }\n\n  obj.form.ttl_pqty.value = iPackQty*iTtlCtn;\n  obj.form.ttl_qty.value = iPackQty*iPackSize*iTtlCtn;\n  obj.form.ttl_ctn.value = iTtlCtn;\n}\n\nfunction fnAdd(frm) {\n  if (!frm.pack_seq.value || parseInt(frm.pack_seq.value) < 1) {\n    alert('Group number must be greater than zero.');\n    frm.pack_seq.select();\n    return;\n  }\n  \n  if (parseInt(frm.ctn_from.value) < 1) {\n    alert('Carton(From) number must be greater than zero.');\n    frm.ctn_from.select();\n    return;\n  }\n  \n  if (parseInt(frm.ctn_to.value) < 1) {\n    alert('Carton(To) number must be greater than zero.');\n    frm.ctn_to.select();\n    return;\n  }\n  \n  if (parseInt(frm.ctn_from.value) > parseInt(frm.ctn_to.value)) {\n    alert('Carton(To) number must be equal to or greater than Carton(From).');\n    frm.ctn_to.select();\n    return;\n  }\n  \n  if (parseInt(frm.pack_qty.value) < 1) {\n    alert('Pack QTY(per carton) must be greater than zero.');\n    frm.pack_qty.select();\n    return;\n  }\n\n  if (confirm('Do you want to add record to packing template list?')) {\n    frm.action = './packing_add.jsp';\n    frm.submit();\n  }\n}\n\nfunction fnDelete(frm) {\n  if (!frm.pack_seq || !jf_ChkRadioOrCheckBox(frm.pack_seq)) {\n    alert(\"Selected Record Not found! Please tick records you want to delete.\");\n    return;\n  }\n\n  if (confirm(\"Do you want to delete the selected records?\")) {\n    frm.action=\"./packing_delete.jsp\";\n    frm.submit();\n  }\n}\n\nfunction fnAutoCreate(frm) {\n  if (confirm('Do you want to proceed with Packing Form Creation?')) {\n    frm.action = './packing_made.jsp';\n    frm.submit();\n  }\n}\n</script>\n</head>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Packing Form Creation</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%'><b>A. Purchase Order Detail</b></td>\n</tr>\n</table>\n<table width='650' border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<tr class='table_header_center'>\n  <td width='20%'>PO NO</td>\n  <td width='20%'>BRAND</td>\n  <td width='20%'>STYLE(GROUP) NO</td>\n  <td width='40%' colspan='2'>SUPPLIER</td>\n</tr>\n<tr class='table_bg_bright_center'>\n  <td>".toCharArray();
    _jsp_string19 = "'>\n<input type='hidden' name='packing_date' value='".toCharArray();
    _jsp_string25 = "\n</table>\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%' align='right'><input type='button' value=\"Delete\" onclick='fnDelete(this.form)'>\n    <input type='button' value=\"Create\" onclick='fnAutoCreate(this.form)'></td></td>\n</tr>\n</form>\n</table>\n<table width='650' border='0' cellspacing='0' cellpadding='0' align='center'>\n<tr>\n  <td width='100%' height='10'></td>\n</tr>\n<tr>\n  <td width='100%'><font color='blue'>Note: To make modifications to packing template list, delete details in 'C', input new values in 'B' and click on 'Create' to update.</font></td>\n</tr>\n<tr>\n  <td width='100%'><font color='red'>Important: \"Create\" button must be clicked after modifying or adding new record.</font></td>\n</tr>\n</table>\n".toCharArray();
    _jsp_string17 = "\n  <td width='8%'>PACK</td>\n  <td width='8%'>TOTAL</td>\n</tr>\n".toCharArray();
    _jsp_string9 = "\n  <tr class='table_header_center'>\n    <td>ITEM CLASS</td>\n    <td>ITEM GROUP</td>\n    <td>UNIT PRICE</td>\n    <td width='20%'>DISCOUNT PRICE</td>\n    <td width='20%'>&nbsp;</td>\n  </tr>\n  <tr class='table_bg_bright_center'>\n    <td>".toCharArray();
    _jsp_string20 = "'>\n<input type='hidden' name='supplier_id' value='".toCharArray();
    _jsp_string26 = "\n</td></tr></table>\n<iframe name='hiddenFrm' src='' width='0' height='0' frameborder='0'></iframe>\n</body>\n</html>\n".toCharArray();
  }
}
