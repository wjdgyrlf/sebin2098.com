/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.sql.*;
import dbconn.*;

public class _menu__jsp extends com.caucho.jsp.JavaPage
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

      out.write('\n');
      
String menus = "";

int iRet = 0;
dbconn.DBConnManager dbPool = null;
Connection connScm = null;
Connection connPronto = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
String sql = "";

// for New Icon..
String OrderManagementMenu = "Order Management";
String POConformationMenu = "PO Confirmation";
String OrderAmendmentMenu = "Order Amendment";
String ServicesAndSupportMenu = "Services & Support";
String DocumentsMenu = "Documents";

int POConfirmationCnt = 0;
int OrderAmendmentCnt = 0;
int DocumentsCnt = 0;

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = dbconn.DBConnManager.getInstance();

  /////////////////////////////////////////////////////////////////////////
  // For New Icon
  // count po conformation
  sql = " select  count(*) "
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
      + " where   a.backorder_flag = ' ' "
      + " and     a.cre_accountcode = '" + scmid + "' "
      + " and     a.po_order_status = '25' "
      + " and     (c.xpoa_ts_created+10/24) > (sysdate-2) ";
  //out.println(sql+"<br>");

  connPronto = dbPool.getConnection("pronto");
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  if (iRet > 0) POConfirmationCnt = Integer.parseInt(matrix.getRowData(0).getData(0));

  // count po amendment
  sql = " select  count(*) "
      + " from    por5mf4 a "
      + "         inner join xstpu22 b "
      + "           on a.po_order_no = b.xspo_po_order_no "
      + "           and a.backorder_flag = b.backorder_flag "
      + "         inner join "
      + "         ( "
      + "           select  po_order_no, "
      + "                   backorder_flag "
      + "           from    por5log7 "
      + "           where   backorder_flag = ' ' "
      + "           and     ordlog_type = 5 "
      + "           and     ordlog_old_info = '40' "
      + "           and     order_log_date > (sysdate-2) "
      + "           union "
      + "           select  xpoa_po_order_no, "
      + "                   backorder_flag "
      + "           from    xpoaudt0 "
      + "           where   backorder_flag = ' ' "
      + "           and     xpoa_status = '40' "
      + "           and     xpoa_ts_created+10/24 > (sysdate-2) "
      + "         ) c "
      + "           on a.po_order_no = c.po_order_no "
      + "           and a.backorder_flag = c.backorder_flag "
      + " where   a.backorder_flag = ' ' "
      + " and     a.cre_accountcode = '" + scmid + "' ";
  //out.println(sql+"<br>");
  
  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  if (iRet > 0) OrderAmendmentCnt = Integer.parseInt(matrix.getRowData(0).getData(0));

  connPronto.commit();

  // Count Documents
  sql = " select  count(*) "
      + " from    notice "
      + " where   create_date > sysdate-7 ";

  connScm = dbPool.getConnection("intranet");
  iRet = dataProcess.RetrieveData(sql, matrix, connScm);
  if (iRet > 0) DocumentsCnt = Integer.parseInt(matrix.getRowData(0).getData(0));
  /////////////////////////////////////////////////////////////////////////

  /////////////////////////////////////////////////////////////////////////
  // Read Menu List
  sql = " SELECT  M.PARENT_NO, M.MENUNAME, M.MENUURL, NVL(MC.CHILD_CNT, 0) "
      + " FROM    ( "
      + "           SELECT SEQNO, PARENT_NO, MENUNAME, MENUURL, SORT_NO "
      + "           FROM   MENU_T "
      + "           WHERE  MENU_TYPE = '" + usertype + "' "
      + "           AND    USER_GROUP = '" + usergroup + "' "
      + "           ORDER BY SORT_NO "
      + "         ) M, "
      + "         ( "
      + "           SELECT M1.SEQNO, COUNT(M2.SEQNO) CHILD_CNT "
      + "           FROM   MENU_T M1, MENU_T M2 "
      + "           WHERE  M1.MENU_TYPE = '" + usertype + "' "
      + "           AND    M1.USER_GROUP = '" + usergroup + "' "
      + "           AND    M1.PARENT_NO = 1 "
      + "           AND    M1.SEQNO = M2.PARENT_NO(+) "
      + "           GROUP BY M1.SEQNO "
      + "         ) MC "
      + " WHERE   M.SEQNO = MC.SEQNO(+) "
      + " ORDER BY M.SORT_NO ";

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);

  for (int i = 0; i < iRet; i++) {
    int j = 0;
    String newIcon = "";

    String parentNo   = matrix.getRowData(i).getData(j++);
    String menuName   = matrix.getRowData(i).getData(j++);
    String menuUrl    = matrix.getRowData(i).getData(j++);
    int childCnt      = Integer.parseInt(matrix.getRowData(i).getData(j++));

    if (parentNo.equals("1")) {

      if ( (OrderManagementMenu.equals(menuName) && POConfirmationCnt + OrderAmendmentCnt > 0)
          || (ServicesAndSupportMenu.equals(menuName) && DocumentsCnt > 0) ) {
        newIcon = "<img src='/img/ico_new.gif' border='0'>";
      }

      // Parent Menu??\u00ea\u00b2\u00bd\u00ec\u009a\u00b0
      if (childCnt > 0) {
        menus += "aux1 = insFolder(rootTree, genFolder(\"" + newIcon + menuName + "\", \"" + menuUrl + "\"));\n";
      } else {
        menus += "insItem(rootTree, genItemIcon(\"tree_page.gif\", \"" + newIcon + menuName + "\", \"" + menuUrl + "\"));\n";
      }

    } else {
      if ( (POConformationMenu.equals(menuName) && POConfirmationCnt > 0)
          || (OrderAmendmentMenu.equals(menuName) && OrderAmendmentCnt > 0)
          || (DocumentsMenu.equals(menuName) && DocumentsCnt > 0) ) {
        newIcon = "<img src='/img/ico_new.gif' border='0'>";
      }
      
      menus += "insItem(aux1, genItemIcon(\"tree_page.gif\", \"" + newIcon + menuName + "\", \"" + menuUrl + "\"));\n";

    }

  }
  /////////////////////////////////////////////////////////////////////////

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in menu : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dbPool.freeConnection("pronto", connPronto);
  }

  if (connScm != null) {
    dbPool.freeConnection("intranet", connScm);
  }
}

      out.write(_jsp_string1, 0, _jsp_string1.length);
      out.print(( menus ));
      out.write(_jsp_string2, 0, _jsp_string2.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("menu.jsp"), -2470311410469398998L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("common/CommonVars.jsp"), 5055347195946766837L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  static {
    _jsp_string1 = "\n<html>\n<head>\n<title></title>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<style type=\"text/css\">\na:link {text-decoration: none ; color: #020468;}\na:visited {text-decoration: none ; color: #666666;}\na:active {text-decoration: underline ; color: #0770FF;}\na:hover {text-decoration: underline ; color: #0770FF;}\n</style>\n<script language=javascript src=\"/common/js/tree_win.js\"></script>\n<script language=\"javascript\">\nfunction LoadLeave()\n{\n    clearTimeout(Time_ID);\n    location.href = \"./menu.jsp\";\n}\nfunction delay()\n{\n    Time_ID = setTimeout(\"LoadLeave()\",( 10 * 60 * 1000 ));\n}\n</script>\n</head>\n\n<body leftmargin=\"2\" topmargin=\"10\" marginwidth=\"0\" marginheight=\"0\" bgcolor=\"#F7F7F7\" onload=\"delay()\">\n<script language=javascript>\nrootTree = genFolderRoot(\"<img src='/img/tree_base.gif' border='0'> <b>HOME</b>\", \"memo/\");\n".toCharArray();
    _jsp_string0 = "\n\n\n".toCharArray();
    _jsp_string2 = "\ninitializeDocument(rootTree);\n</script>\n<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\">\n<tr>\n  <td align=\"center\" height=\"10\"></td>\n</tr>\n<tr>\n  <td align=\"center\"><a href=\"http://www.fastfuturebrands.com.au\" target=\"_blank\"><!--img src=\"/img/getacro.gif\"--><img src=\"/img/ffb_newlogo.jpg\"></a></td>\n\n</tr>\n<tr>\n  <td align=\"center\" class=\"font_small\"><font color=\"#0770FF\" siz=2>www.fastfuturebrands.com.au</font></td>\n\n</tr>\r \n<tr>\n  <td align=\"center\"><a href=\"http://get.adobe.com/reader/\" target=\"_blank\"><img src=\"/img/adobe_reader.png\"></a></td>\n\n</tr>\n<tr>\n  <td align=\"center\" class=\"font_small\"><font color=\"#0770FF\" siz=2>Get Adobe Reader</font></td>\n\n</tr>\n \n\n</table>\n</body>\n</html>".toCharArray();
  }
}
