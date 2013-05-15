/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import dbconn.*;
import common.util.*;

public class _pda2__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
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

String outS = "";
int iRet = 0;
int iRet2 = 0;
int iRet3 = 0;
Connection connPronto = null;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.MatrixDataSet matrix3 = null;
dbconn.DataProcess dataProcess = null;
String sql = "";

String searchBarcode = request.getParameter("searchBarcode");
if (searchBarcode == null) searchBarcode = "";
else searchBarcode = searchBarcode.trim();

String today = DateUtil.getToday("dd/MM/yyyy");
String itemGroup = "";
String itemClass = "";
String season = "";
String style_no = "";
String itemText = "";
String price = "";
String receiptText = "";
String classDesc = "";
String supplierId = "";
String supplierName = "";
String size = "";
String color = "";
String po_no = "";
String inspectorName = "";
String recDate = "";
String brandName = "";
String buyerComments = "";
String buyerInspectStatus = "";
boolean isEditable = false;
boolean isConfirmed = false;
String inspectorOptions = "";

// set query
sql = " select  a.stock_group, "
    + "         b.sht_class, "
    + "         substr(a.stock_code, 7, 4), "
    + "         substr(a.stock_code, 1, 6), "
    + "         a.stk_desc_line_2, "
    + "         round(c.wholesale_price*1.1, 2), "
    + "         a.stk_description, "
    + "         b.shm_description, "
    + "         d.cre_accountcode, "
    + "         e.cr_shortname, "
    + "         f.sys_description, "
    + "         g.sys_description, "
    + "         ( "
    + "           select  max(xspo_po_order_no) "
    + "           from    xstpu22 "
    + "           where   backorder_flag = ' ' "
    + "           and     xspo_style = substr(a.stock_code, 1, 6) "
    + "           and     season_and_seq = substr(a.stock_code, 7, 4) "
    + "         ), "
    + "         g.shm_description "
    + " from    stk5mf1 a "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, z.sht_class, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_class "
    + "                    and y.shm_type = 4 "
    + "         ) b "
    + "           on a.stock_group = b.stock_group "
    + "         left outer join stk5prc c "
    + "           on a.stock_code = c.stock_code "
    + "         left outer join stk5supt d "
    + "           on a.stock_code = d.stock_code "
    + "         left outer join cre5mfi e "
    + "           on d.cre_accountcode = e.cre_accountcode "
    + "         left outer join sys5tbl5 f "
    + "           on substr(a.stock_code, 14) = f.sys_tbl_code "
    + "           and f.sys_tbl_type = 'CF' "
    + "         left outer join sys5tbl5 g "
    + "           on substr(a.stock_code, 11, 3) = g.sys_tbl_code "
    + "           and g.sys_tbl_type = 'CO' "
    + "         left outer join "
    + "         ( "
    + "           select z.stock_group, y.shm_description "
    + "           from   stkhierachymst0 y "
    + "                  inner join stkhiertree3 z "
    + "                    on y.shm_code = z.sht_category "
    + "                    and y.shm_type = 3 "
    + "         ) g "
    + "           on a.stock_group = g.stock_group "
    + " where   a.stk_apn_number = '" + searchBarcode + "' ";
//out.println(sql);

// Data query ..
if (searchBarcode.length() > 0) {
  try {
  
    matrix = new dbconn.MatrixDataSet();
    dataProcess = new dbconn.DataProcess();
    dbPool = DBConnManager.getInstance();
    connPronto = dbPool.getConnection("pronto");
  
    iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
    
    // read item info
    if (iRet > 0) {
      int j = 0;
      isEditable = true;
      itemGroup = matrix.getRowData(0).getData(j++);
      itemClass = matrix.getRowData(0).getData(j++);
      season = matrix.getRowData(0).getData(j++);
      style_no = matrix.getRowData(0).getData(j++);
      itemText = matrix.getRowData(0).getData(j++);
      price = matrix.getRowData(0).getData(j++);
      receiptText = matrix.getRowData(0).getData(j++);
      classDesc = matrix.getRowData(0).getData(j++);
      supplierId = matrix.getRowData(0).getData(j++);
      supplierName = matrix.getRowData(0).getData(j++);
      size = matrix.getRowData(0).getData(j++);
      color = matrix.getRowData(0).getData(j++);
      po_no = matrix.getRowData(0).getData(j++);
      brandName = matrix.getRowData(0).getData(j++);

      // read buyer comments
      sql = " select  decode(buyer_inspect_status, '0', 'A', '1', 'P', '2', 'R', '3', 'H', '4', 'N', buyer_inspect_status), "
          + "         buyer_comments "
          + " from    po_style_etc@scm "
          + " where   po_no = '" + po_no + "' ";

      iRet = dataProcess.RetrieveData(sql, matrix, connPronto);

      if (iRet > 0) {
        j = 0;
        buyerInspectStatus = matrix.getRowData(0).getData(j++);
        buyerComments = matrix.getRowData(0).getData(j++);
      }

      // read qc master info from aps
      sql = " select  a.rec_date, nvl(b.code_desc, a.ffb_inspector) "
          + " from    buying.vg_qc_master@aps a "
          + "         left outer join buying.vg_qc_code@aps b "
          + "           on a.ffb_inspector = b.code "
          + "           and b.div = 'IP' "
          + " where   a.po_no = '" + po_no + "' "
          + " and     a.final_decision is not null ";
  
      matrix2 = new dbconn.MatrixDataSet();
      iRet2 = dataProcess.RetrieveData(sql, matrix2, connPronto);

      // set qc info
      if (iRet2 > 0) {
        j = 0;
        isConfirmed = true;
        recDate = matrix2.getRowData(0).getData(j++);
        inspectorName = matrix2.getRowData(0).getData(j++);

        if (recDate.length() > 0) {
          recDate = recDate.substring(6) + "/" + recDate.substring(4, 6) + "/" + recDate.substring(0, 4);
        }
      }

      if (!isConfirmed) {
        // read inspector list from aps
        sql = " select  code, code_desc "
            + " from    buying.vg_qc_code@aps "
            + " where   div = 'IP' "
            + " and     on_duty = 'Y' "
            + " order by code_desc ";
    
        matrix3 = new dbconn.MatrixDataSet();
        iRet3 = dataProcess.RetrieveData(sql, matrix3, connPronto);

        // set inspector options
        inspectorOptions = "<select name='ffb_inspector'><option></option>";

        for (int i = 0; i < iRet3; i++) {
          j = 0;
          String code = matrix3.getRowData(i).getData(j++);
          String codeDesc = matrix3.getRowData(i).getData(j++);
        
          inspectorOptions += "<option value='" + code + "'>" + codeDesc + "</option>";
        }
        
        inspectorOptions += "</select>";
      }
    }

  } catch (Exception e) {
    System.out.println("Exception in pda : " + e.getMessage());
    throw e;
  } finally {
    if (connPronto != null) {
      try { connPronto.commit(); } catch (Exception ex) {}
      DataProcess tmpDataProcess = new dbconn.DataProcess();
      tmpDataProcess.ManipulateData("alter session close database link aps", connPronto);
      dbPool.freeConnection("pronto", connPronto);
    }
  }
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
if (isEditable && !isConfirmed) {

      out.write(_jsp_string2, 0, _jsp_string2.length);
      
}

      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( searchBarcode ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( searchBarcode ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( po_no ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( isEditable ? (isConfirmed ? inspectorName : inspectorOptions) : "" ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( isEditable ? "<br>" + (isConfirmed ? "<b>Already confirmed</b>" : "<input type='button' value='Confirm' onclick='fnConfirm(this.form);'>") : "" ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( brandName ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( buyerInspectStatus ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( buyerComments ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print(( supplierId ));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print(( supplierName ));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print(( season ));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print(( style_no ));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print(( po_no ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( style_no ));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print(( color ));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print(( size ));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print(( price ));
      out.write(_jsp_string19, 0, _jsp_string19.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("pda2.jsp"), 157996095163771587L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string8;
  private final static char []_jsp_string2;
  private final static char []_jsp_string18;
  private final static char []_jsp_string14;
  private final static char []_jsp_string19;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string6;
  private final static char []_jsp_string12;
  private final static char []_jsp_string10;
  private final static char []_jsp_string7;
  private final static char []_jsp_string15;
  private final static char []_jsp_string17;
  private final static char []_jsp_string3;
  private final static char []_jsp_string11;
  private final static char []_jsp_string13;
  private final static char []_jsp_string1;
  private final static char []_jsp_string16;
  private final static char []_jsp_string5;
  private final static char []_jsp_string9;
  static {
    _jsp_string8 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>Brand</td>\n  <td class='table_bg_bright' colspan='2'>".toCharArray();
    _jsp_string2 = "\nfunction fnConfirm(frm) {\n  if (!frm.po_no.value) {\n    alert('There is no correct item information. Search item using barcode.');\n    frm.searchBarcode.focus();\n    return;\n  }\n\n  if (!frm.ffb_inspector.value) {\n    alert('Choose inspector.');\n    frm.ffb_inspector.focus();\n    return;\n  }\n  \n  if (confirm('Do you want to confirm this information?')) {\n    frm.action = './pda2_save.jsp';\n    frm.submit();\n  }\n}\n".toCharArray();
    _jsp_string18 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>RRP</td>\n  <td class='table_bg_bright'>".toCharArray();
    _jsp_string14 = "</td>\n  <td width='40%' class='table_bg_bright' rowspan='4'><img src='/image/".toCharArray();
    _jsp_string19 = "</td>\n</tr>\n</form>\n</table>\n\n</body>\n</html>".toCharArray();
    _jsp_string0 = "\n\n\n\n".toCharArray();
    _jsp_string4 = "\n    <input type='text' name='searchBarcode' size='8' maxlength='8'>\n    <input type='button' value='Search' onclick='fnSearch(this.form);'></td>\n</tr>\n</form>\n<form name='form2' method='post'>\n<input type='hidden' name='barcode' value='".toCharArray();
    _jsp_string6 = "'>\n<tr>\n  <td class='table_header_center'>Inspector</td>\n  <td class='table_bg_bright' colspan='2'>".toCharArray();
    _jsp_string12 = "&nbsp;".toCharArray();
    _jsp_string10 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>Buyer Comments</td>\n  <td class='table_bg_bright' colspan='2'>".toCharArray();
    _jsp_string7 = "\n    ".toCharArray();
    _jsp_string15 = ".jpg' width='82' height='102' border=0></td>\n</tr>\n<tr>\n  <td width='20%' class='table_header_center'>PO/Style</td>\n  <td width='40%' class='table_bg_bright' colspan=''>".toCharArray();
    _jsp_string17 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>Color/Size</td>\n  <td class='table_bg_bright'>".toCharArray();
    _jsp_string3 = "\n</script>\n</head>\n<body leftmargin='2' topmargin='2' marginwidth='0' marginheight='0' onload='document.form1.searchBarcode.focus();'>\n<table width='100%' border='0' cellspacing='1' cellpadding='0' align='center' class='table_bg'>\n<form name='form1' method='post'>\n<tr>\n  <td width='20%' class='table_header_center'>Barcode</td>\n  <td width='80%' colspan='2' class='table_bg_bright'>".toCharArray();
    _jsp_string11 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>Supplier</td>\n  <td class='table_bg_bright' colspan='2'>".toCharArray();
    _jsp_string13 = "</td>\n</tr>\n<tr>\n  <td width='20%' class='table_header_center'>Season</td>\n  <td width='40%' class='table_bg_bright'>".toCharArray();
    _jsp_string1 = "\n<html>\n<head>\n<style type='text/css'>\nbody, td, p, br\n{font-family: \"Verdana\", \"Arial\", \"Helvetica\"; font-size: 10px; color: #000000; line-height:18px;}\ninput, select, textarea, form, option\n{font-family: \"Verdana\", \"Arial\", \"Helvetica\"; font-size: 10px; color: #000000;}\nbody {\n  background-color : #F5F5F5;\n	scrollbar-face-color: #F8F8F8;\n	scrollbar-shadow-color:#B3B3B3;\n	scrollbar-highlight-color:#B3B3B3;\n	scrollbar-3dlight-color: #FFFFFF;\n	scrollbar-darkshadow-color: #FFFFFF;\n	scrollbar-track-color: #DDDDDD;\n	scrollbar-arrow-color: #8B9EA6;\n}\n\nimg {border:none;}\n\na:link {text-decoration: underline ; color: #363891;}\na:visited {text-decoration: underline ; color: #7E49AF;}\na:active {text-decoration: underline ; color: #5A92E4;}\na:hover {text-decoration: underline ; color: #5A92E4;}\n\n.table_bg {	background-color: #C0C0C0;}\n.table_bg_bright { background-color: #F4F5F0;}\n.table_bg_bright_center { background-color: #F4F5F0;text-align: center;}\n.table_header { height: 20px; background-color: #E6E6FA;}\n.table_header_right { height: 20px; background-color: #E6E6FA; text-align: right;}\n.table_header_center { height: 20px; background-color: #E6E6FA;	text-align: center;}\n</style>\n<script language='javascript'>\nfunction fnSearch(frm) {\n  if (!frm.searchBarcode.value) {\n    alert('Input Barcode.');\n    frm.searchBarcode.focus();\n    return;\n  }\n\n  frm.action = './pda2.jsp';\n  frm.submit();\n}\n\n".toCharArray();
    _jsp_string16 = " / ".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='po_no' value='".toCharArray();
    _jsp_string9 = "</td>\n</tr>\n<tr>\n  <td class='table_header_center'>Status</td>\n  <td class='table_bg_bright' colspan='2'>".toCharArray();
  }
}
