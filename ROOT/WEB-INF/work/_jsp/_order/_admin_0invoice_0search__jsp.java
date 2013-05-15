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

public class _admin_0invoice_0search__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;


  public String getSupplierNameOptions(String selectedItem, boolean includeAll, String valueStr) {
    String retStr = "";
    int iRet = 0;
    String sql = "";
    DBConnManager dbPool = null;
    Connection conn = null;
    MatrixDataSet matrix = null;
    DataProcess dataProcess = null;

    try {
      sql = " select id, name from login_01t order by name ";

      dbPool = DBConnManager.getInstance();
      conn = dbPool.getConnection("intranet");
      matrix = new MatrixDataSet();
      dataProcess = new DataProcess();

      iRet = dataProcess.RetrieveData(sql, matrix, conn);

      if (includeAll) retStr += "<option value=''>All</option>";

      for (int i = 0; i < iRet; i++) {
        String id = matrix.getRowData(i).getData(0);
        String name = matrix.getRowData(i).getData(1);
        String value = "";

        if (valueStr.equals("id")) value = id;
        else if (valueStr.equals("name")) value = name;

        retStr += "<option value='" + value + "'"
                + (selectedItem.equals(value) ? " selected" : "")
                + ">" + id + "-" + name + "</option>";
      }
    } catch (Exception e) {
      retStr = "";
    } finally {
      if (conn != null) dbPool.freeConnection("intranet", conn);
    }

    return retStr;
  }



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
      
Connection connScm = null;
MatrixDataSet matrix = null;
DataProcess dataProcess = null;
DBConnManager dbPool = null;

String supplier_id = "";
String supplier_name = "";
String supplier_type = "";
String po_no="";
String invoice_no="";
String style_no="";
String invoice_date="";
String tot_amount ="";
String qty ="";
String price="";
String seqno = "";
String outS = "";
int    iRet = 0;
int    iRet2 = 0;
int    i = 0;
int    rcnt = 0;
String sql = "";
String sql2 ="";
String update1 ="";
String update2 ="";
String file_name="";
String file_name2="";
String color_code ="";
int color_count = 0;

String ag_supplier = request.getParameter("ag_supplier");
String ag_supplier_type = request.getParameter("ag_supplier_type");
String ag_search_inv_no = request.getParameter("ag_search_inv_no");
String ag_year = request.getParameter("ag_year");
String ag_month = request.getParameter("ag_month");
if (ag_supplier == null) ag_supplier = "";
if (ag_supplier_type == null) ag_supplier_type = "D";
if (ag_search_inv_no == null) ag_search_inv_no = "";
if (ag_year == null) ag_year = "";
if (ag_month == null) ag_month = "";
if (ag_month.equals("") || ag_year.equals("")) {
  ag_month = DateUtil.getToday("MM");
  ag_year = DateUtil.getToday("yyyy");
}

String today =  ag_month + ag_year.substring(2,4) ;

sql = " select  " +
      "       a.invoice_no, " +
      "       substr(a.invoice_date,1,2)||'/'|| substr(a.invoice_date,3,2)||'/'||substr(a.invoice_date,5,4) invoice_date, " +
      "       a.sup_id, " +
      "       a.file_name, " +
      "       to_char(a.updated,'dd/mm/yyyy'), " +
      "       b.name, " +
      "       b.user_group " +
      "  from invoice_01t a, login_01t b " +
      "  where a.sup_id  = b.id  "  ;

if ( !(ag_search_inv_no == null || ag_search_inv_no.length() < 1))  {
  sql += " and invoice_no  like '" + ag_search_inv_no + "%'  " ;
}else {
  sql += "  and substr(invoice_date,3,2)||substr(invoice_date,7,2) = '" + today + "'"
       + "  and gp_status = 'N' ";
      /*
       + " and  not exists ( "
       + "        select  x.po_no "
       + "        from    invoice_02t x "
       + "                inner join por5mf4@pronto y "
       + "                  on x.po_no = y.po_order_no "
       + "        where   y.po_order_status between decode(b.user_group, 'F', '50', '90') and '90' "
       + "        and     x.invoice_no = a.invoice_no "
       + "        and     x.sup_id = a.sup_id "
       + "      ) ";
      */

  if (ag_supplier.length() > 0) sql += "  and a.sup_id = '" + ag_supplier + "' ";
  if (ag_supplier_type.length() > 0) sql += " and b.user_group = '" + ag_supplier_type + "' ";
}
sql += " order by substr(a.invoice_date,5,4)||'/'|| substr(a.invoice_date,3,2)||'/'||substr(a.invoice_date,1,2), invoice_no desc " ;
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

  System.out.println("Exception admin_invoice_search : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dataProcess = new DataProcess();
    dataProcess.ManipulateData("alter session close database link pronto", connScm);
    dbPool.freeConnection("intranet", connScm);
  }
}


if (iRet > 0 ) {
  for (i=0; i < iRet; i++) {
    invoice_no = matrix.getRowData(i).getData(0);
    invoice_date = matrix.getRowData(i).getData(1);
    supplier_id  = matrix.getRowData(i).getData(2);
    file_name2  = matrix.getRowData(i).getData(3);
    update1     = matrix.getRowData(i).getData(4);
    supplier_name = matrix.getRowData(i).getData(5);
    supplier_type = matrix.getRowData(i).getData(6);

    String supplier_type_name = supplier_type;
    if (supplier_type.equals("F")) {
      supplier_type_name = "FOB";
    } else if (supplier_type.equals("D")) {
      supplier_type_name = "DDP";
    }

    if( color_count > 0 ) {
      color_code = "#EEEEE0";
      color_count = 0;
    }else {
      color_code = "#FFFFF0";
      color_count = 1;
    }

    outS += "<tr bgcolor=" + color_code + ">" +
            "<td align=center > <font size=2>" + (i+1) + "</font></td>" +
            "<td align=center > <font size=2>" + invoice_date + " </font></td>" +
            "<td align=center > <font size=2>" + supplier_id + " </font></td>" +
            "<td align=center > <font size=2>" + supplier_name + " </font></td>" +
            "<td align=center > <font size=2>" + supplier_type_name + " </font></td>" +
            "<td align=center > <font size=2> <a href=\"javascript:fnView('" + invoice_no + "', '" 
              + supplier_id + "', '" + supplier_type + "')\">" + invoice_no + "</font></td>" +
            "<td align=center > <font size=2> <a href=\"javascript:fnDownload('" + file_name2 + "');\">" + file_name2 + "</a></font></td> " +
             "<td align=center > <font size=2>" + update1                  + "</font></td>" +
            "</tr>";
  } //end of for
} //end of if

// create ag_year optiones
String optionYears = "";
int thisYear = Integer.parseInt(DateUtil.getToday("yyyy"));
for (int k = thisYear - 4; k <= thisYear; k++) {
  optionYears += "<option value='" + k + "' " + (ag_year.equals(k + "") ? "selected" : "") +">" + k + "</option>";
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( getSupplierNameOptions(ag_supplier, true, "id") ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_supplier_type.equals("") ? "selected" : "" ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_supplier_type.equals("D") ? "selected" : "" ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_supplier_type.equals("F") ? "selected" : "" ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
       if(ag_month.equals("01")) out.print("SELECTED"); 
      out.write(_jsp_string8, 0, _jsp_string8.length);
       if(ag_month.equals("02")) out.print("SELECTED"); 
      out.write(_jsp_string9, 0, _jsp_string9.length);
       if(ag_month.equals("03")) out.print("SELECTED"); 
      out.write(_jsp_string10, 0, _jsp_string10.length);
       if(ag_month.equals("04")) out.print("SELECTED"); 
      out.write(_jsp_string11, 0, _jsp_string11.length);
       if(ag_month.equals("05")) out.print("SELECTED"); 
      out.write(_jsp_string12, 0, _jsp_string12.length);
       if(ag_month.equals("06")) out.print("SELECTED"); 
      out.write(_jsp_string13, 0, _jsp_string13.length);
       if(ag_month.equals("07")) out.print("SELECTED"); 
      out.write(_jsp_string14, 0, _jsp_string14.length);
       if(ag_month.equals("08")) out.print("SELECTED"); 
      out.write(_jsp_string15, 0, _jsp_string15.length);
       if(ag_month.equals("09")) out.print("SELECTED"); 
      out.write(_jsp_string16, 0, _jsp_string16.length);
       if(ag_month.equals("10")) out.print("SELECTED"); 
      out.write(_jsp_string17, 0, _jsp_string17.length);
       if(ag_month.equals("11")) out.print("SELECTED"); 
      out.write(_jsp_string18, 0, _jsp_string18.length);
       if(ag_month.equals("12")) out.print("SELECTED"); 
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print(( optionYears ));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print(( ag_search_inv_no ));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print((outS));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print(( _invoiceFileUrl ));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/admin_invoice_search.jsp"), -1763734687322821031L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/login_check.jsp"), 6768457171426488389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/getSupplierNameOptions.jsp"), -5604839093945239777L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string8;
  private final static char []_jsp_string12;
  private final static char []_jsp_string5;
  private final static char []_jsp_string16;
  private final static char []_jsp_string0;
  private final static char []_jsp_string11;
  private final static char []_jsp_string15;
  private final static char []_jsp_string18;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string19;
  private final static char []_jsp_string24;
  private final static char []_jsp_string7;
  private final static char []_jsp_string10;
  private final static char []_jsp_string14;
  private final static char []_jsp_string17;
  private final static char []_jsp_string1;
  private final static char []_jsp_string20;
  private final static char []_jsp_string22;
  private final static char []_jsp_string21;
  private final static char []_jsp_string9;
  private final static char []_jsp_string13;
  private final static char []_jsp_string6;
  private final static char []_jsp_string23;
  private final static char []_jsp_string4;
  static {
    _jsp_string8 = ">01</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string12 = ">05</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string5 = ">All</option>\n    <option value='D' ".toCharArray();
    _jsp_string16 = ">09</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n\n".toCharArray();
    _jsp_string11 = ">04</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string15 = ">08</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string18 = ">11</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string3 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnDownload(file) {\n  with (document.form2) {\n    attachFile.value = file;\n    attachRealFile.value = file;\n    action = '/common/download.jsp';\n    //target = 'hiddenFrm';\n    submit();\n  }\n}\n\nfunction fnView(inv_no, sup_id, supplier_type) {\n  document.frmMain.inv_no.value = inv_no;\n  document.frmMain.sup_id.value = sup_id;\n  document.frmMain.action = (supplier_type == \"F\" ? \"fob_\" : \"\" ) + \"invoice_edit_form.jsp\";\n  document.frmMain.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Invoice List</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<TABLE width=750 border='0' align='center'>\n<FORM NAME=frmMain action=\"admin_invoice_search.jsp\" METHOD=POST >\n<input type='hidden' name='inv_no'>\n<input type='hidden' name='sup_id'>\n<TR>\n  <td><font color=blue size=2 >\n  NOTE: Please contact our Finance Department (02 8458 6200 or accounts@ffb.net.au) regarding any invoice issues.\n  </font></td>\n</TR>\n<tr>\n  <td height='15'></td>\n</tr>\n</table>\n\n<TABLE WIDTH=750 border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class='table_bg'>\n<tr>\n  <td width='20%' class='table_header_center'>Supplier</td>\n  <td width='*' colspan='3' class='table_bg_bright'><select name='ag_supplier'>".toCharArray();
    _jsp_string2 = "\n\n\n".toCharArray();
    _jsp_string19 = ">12</OPTION>\n  </SELECT>\n  <SELECT NAME=ag_year>".toCharArray();
    _jsp_string24 = "\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string7 = ">FOB</option>\n    </select></td>\n  <TD width='20%' rowspan='2' class='table_bg_bright_center'>\n    <INPUT TYPE=BUTTON VALUE=\"Search\" ONCLICK=submit()>\n  </TD>\n</tr>\n<TR>\n  <TD width='20%' class='table_header_center'>Issue Date</TD>\n  <TD width='20%' class='table_bg_bright'>\n  <SELECT NAME=ag_month>\n  <OPTION ".toCharArray();
    _jsp_string10 = ">03</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string14 = ">07</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string17 = ">10</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string1 = "\n\n".toCharArray();
    _jsp_string20 = "</SELECT>\n  <TD width='20%' class='table_header_center'>Invoice No.</TD>\n  <TD width='20%' class='table_bg_bright'><input type=text name=ag_search_inv_no value='".toCharArray();
    _jsp_string22 = "\n</FORM>\n<form name='form2' method='post'>\n<input type='hidden' name='attachPath' value='".toCharArray();
    _jsp_string21 = "'>\n  </TD>\n</TR>\n</TABLE>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</table>\n\n<TABLE width='99%' border=0 cellpadding=0 cellspacing=1 align='center' class='table_bg'>\n<tr class='table_header_center'>\n<TD><FONT size=2>No </FONT></TD>\n<TD><FONT size=2>Issue Date </FONT></TD>\n<TD><FONT size=2>Suppler ID </FONT></TD>\n<TD><FONT size=2>Suppler Name</FONT></TD>\n<TD><FONT size=2>Suppler Type</FONT></TD>\n<TD><FONT size=2>Invoice No. </FONT></TD>\n<TD><FONT size=2>Filename </FONT></TD>\n<TD><FONT size=2>Updated  </FONT></TD>\n</tr>\n".toCharArray();
    _jsp_string9 = ">02</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string13 = ">06</OPTION>\n  <OPTION ".toCharArray();
    _jsp_string6 = ">DDP</option>\n    <option value='F' ".toCharArray();
    _jsp_string23 = "'>\n<input type='hidden' name='attachFile'>\n<input type='hidden' name='attachRealFile'>\n</form>\n</TABLE>\n".toCharArray();
    _jsp_string4 = "</select>\n    <select name='ag_supplier_type'>\n    <option value='' ".toCharArray();
  }
}
