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
import common.util.*;

public class _note__jsp extends com.caucho.jsp.JavaPage
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
      
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

String outS = "";
int iRet = 0;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
Connection connPronto = null;
String sql = "";

String ag_year = request.getParameter("ag_year");
String ag_po_no     = request.getParameter("ag_po_no");
String ag_inv_no   = request.getParameter("ag_inv_no");
String ag_style_no = request.getParameter("ag_style_no");
String ag_orderby = request.getParameter("ag_orderby");
if (ag_year == null) ag_year = DateUtil.getToday("yyyy");
if (ag_po_no == null) ag_po_no = "";
if (ag_inv_no == null) ag_inv_no = "";
if (ag_style_no == null) ag_style_no = "";
if (ag_orderby == null) ag_orderby = "0";

// set query
sql = " select  to_char(a.inv_date, 'yyyymmdd'), "
    + "         a.inv_no, "
    + "         a.brand, "
    + "         a.pic, "
    + "         a.po_inv_no, "
    + "         a.inv_status, "
    + "         nvl(sum(b.qty*b.price), 0), "
    + "         a.del_type "
    + " from    fmsd.vg_cr_mast@aps a "
    + "         inner join fmsd.vg_cr_detail@aps b "
    + "           on a.inv_no = b.inv_no "
    + "         inner join por5mf4 c "
    + "           on b.po_no = c.po_order_no "
    + " where   nvl(a.status, ' ') <> 'D' "
    //+ " and     a.inv_status = 'P' "
    + " and     a.inv_status in ('P', 'W') "
    + " and     c.backorder_flag = ' ' "
    + " and     c.cre_accountcode = '" + scmid + "' ";

if (ag_po_no.length() > 0 || ag_inv_no.length() > 0 || ag_style_no.length() > 0) {
  if (ag_po_no.length() > 0) {
    sql += " and      b.po_no = '" + ag_po_no + "' ";
  }

  if (ag_inv_no.length() > 0) {
    sql += " and      a.inv_no like '" + ag_inv_no + "%' ";
  }

  if (ag_style_no.length() > 0) {
    sql += " and      b.style_no = '" + ag_style_no + "' ";
  }
} else {
  //sql += " and      a.inv_date between '" + ag_year + "0101' and '" + ag_year + "1231' ";
  sql += " and      a.inv_date between to_date('" + ag_year + "0101', 'yyyymmdd') and to_date('" + ag_year + "1231', 'yyyymmdd') ";
}

sql += " group by to_char(a.inv_date, 'yyyymmdd'), a.inv_no, a.brand, a.pic, a.po_inv_no, a.inv_status, a.del_type ";

if (ag_orderby.equals("0"))  {
  sql += " order by to_char(a.inv_date, 'yyyymmdd'), a.brand ";
}
else if (ag_orderby.equals("1"))  {
  sql += " order by a.po_inv_no, a.brand ";
}
else if (ag_orderby.equals("2"))  {
  sql += " order by a.inv_no, a.brand ";
}
else if (ag_orderby.equals("3"))  {
  sql += " order by a.brand, to_char(a.inv_date, 'yyyymmdd') ";
}
//out.println(sql);


try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = DBConnManager.getInstance();
  connPronto = dbPool.getConnection("pronto");

  iRet = dataProcess.RetrieveData(sql, matrix, connPronto);
  connPronto.commit();

} catch (Exception e) {
  if (connPronto != null) {
    try { connPronto.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in note : " + e.getMessage());
  throw e;
} finally {
  if (connPronto != null) {
    dataProcess = new DataProcess();
    dataProcess.ManipulateData("alter session close database link aps", connPronto);
    dbPool.freeConnection("pronto", connPronto);
  }
}

// print out
for (int i = 0; i < iRet; i++) {
  int j = 0;

  String inv_date = matrix.getRowData(i).getData(j++);
  String inv_no = matrix.getRowData(i).getData(j++);
  String brand = matrix.getRowData(i).getData(j++);
  String pic = matrix.getRowData(i).getData(j++);
  String po_inv_no = matrix.getRowData(i).getData(j++);
  String inv_status = matrix.getRowData(i).getData(j++);
  double net_amount = Double.parseDouble(matrix.getRowData(i).getData(j++));
  String del_type = matrix.getRowData(i).getData(j++);
  
  if (brand.equals("1")) brand = "VG";
  else if (brand.equals("2")) brand = "TEMT";
    
  if (inv_status.equals("W")) inv_status = "New";
  else if (inv_status.equals("P")) inv_status = "Booked";

  String bgColor = "#fffff0";
  if (i%2 > 0) bgColor = "#eeeee0";

  outS += "<tr align='center' class='table_list' style='background-color:" + bgColor + ";'>"
        + "  <td>" + inv_date.substring(6) + "/" + inv_date.substring(4, 6) + "/" + inv_date.substring(0, 4) + "</td>"
        + "  <td><a href=\"javascript:fnView('" + inv_no + "');\">" + inv_no + "</a></td>"
        + "  <td>" + brand + "</td>"
        + "  <td align='left'>" + pic + "</td>"
        + "  <td>" + po_inv_no + "</td>"
        + "  <td align='right'>" + StringUtil.formatNumber(net_amount, MONEY_FORMAT) + "</td>"
        + "  <td align='right'>" + StringUtil.formatNumber(net_amount*(del_type.equals("FOB") ? 0.0 : 0.1), MONEY_FORMAT) + "</td>"
        + "  <td align='right'>" + StringUtil.formatNumber(net_amount*(del_type.equals("FOB") ? 1.0 : 1.1), MONEY_FORMAT) + "</td>"
        + "  <td>" + inv_status + "</td>"
        + "</tr>";
}

// create ag_year optiones
String optionYears = "";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
int thisYear = Integer.parseInt(sdf.format(new java.util.Date()));
for (int i = thisYear - 4; i <= thisYear; i++) {
  optionYears += "<option value='" + i + "' " + (ag_year.equals(i + "") ? "selected" : "") +">" + i + "</option>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( optionYears ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_inv_no ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_style_no ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
       if(ag_orderby == null || ag_orderby.equals("0"))  out.print("SELECTED");  
      out.write(_jsp_string7, 0, _jsp_string7.length);
       if(ag_orderby != null && ag_orderby.equals("1")) out.print("SELECTED");  
      out.write(_jsp_string8, 0, _jsp_string8.length);
       if(ag_orderby != null && ag_orderby.equals("2")) out.print("SELECTED");  
      out.write(_jsp_string9, 0, _jsp_string9.length);
       if(ag_orderby != null && ag_orderby.equals("3")) out.print("SELECTED");  
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((outS));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      
out.println(CopyRightLogo());

      out.write(_jsp_string12, 0, _jsp_string12.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/note.jsp"), 3970138832480168389L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string12;
  private final static char []_jsp_string9;
  private final static char []_jsp_string4;
  private final static char []_jsp_string2;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string8;
  private final static char []_jsp_string3;
  private final static char []_jsp_string7;
  private final static char []_jsp_string11;
  private final static char []_jsp_string10;
  private final static char []_jsp_string0;
  private final static char []_jsp_string6;
  static {
    _jsp_string12 = "\n\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string9 = ">Inv No. </OPTION>\n    <OPTION value=\"3\"  ".toCharArray();
    _jsp_string4 = "'></td>\n  <td width=\"15%\" class=\"table_header_center\">Invoice No.</td>\n  <td width=\"19%\" class=\"table_bg_bright\"><input type=text name=ag_inv_no value='".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\nfunction search()\n{\n  frmMain.submit();\n}\n\nfunction chk_length()\n{\n  var bRet = true;\n  len1 = frmMain.ag_po_no.value;\n  len2 = frmMain.ag_inv_no.value;\n  len3 = frmMain.ag_style_no.value;\n  if ( len1.length < 1 && len2.length < 1 && len3.length < 1 ) {\n    bRet = false ;\n    alert('type search words at least one column');\n    frmMain.ag_po_no.setfocus();\n  }\n  return bRet ;\n}\n\nfunction fnView(inv_no_selected) {\n  frmMain.inv_no_selected.value = inv_no_selected;\n  frmMain.action = \"note_detail.jsp\";\n  frmMain.submit();\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Credit / Debit Note</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"2\" align=\"center\" class=\"table_bg\">\n<FORM NAME=\"frmMain\" ACTION=\"note.jsp\" METHOD=POST>\n<input type='hidden' name='inv_no_selected'>\n<tr>\n  <td width=\"15%\" class=\"table_header_center\">Issue Date</td>\n  <td width=\"18%\" class=\"table_bg_bright\"><SELECT NAME=ag_year>".toCharArray();
    _jsp_string5 = "'></td>\n</tr>\n<tr>\n  <td class=\"table_header_center\">Style No.</td>\n  <td class=\"table_bg_bright\"><input type=text name=ag_style_no value='".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string8 = ">Sup Inv no  </OPTION>\n    <OPTION value=\"2\"  ".toCharArray();
    _jsp_string3 = "</SELECT></td>\n  <td width=\"15%\" class=\"table_header_center\">PO No.</td>\n  <td width=\"18%\" class=\"table_bg_bright\"><input type=text name=ag_po_no value='".toCharArray();
    _jsp_string7 = ">Issue Date  </OPTION>\n    <OPTION value=\"1\"  ".toCharArray();
    _jsp_string11 = "\n</TABLE>\n\n".toCharArray();
    _jsp_string10 = ">Brand </OPTION>\n    </SELECT></td>\n  <td class=\"table_bg_bright_center\" colspan='2'><INPUT TYPE=BUTTON VALUE=\"Search\" ONCLICK=search()></td>\n</tr>\n</table>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr>\n  <td width=\"100%\" height=\"15\"></td>\n</tr>\n</FORM>\n</table>\n\n<TABLE border=0 width=99% CELLPADDING=0 CELLSPACING=1 align=center class=\"table_bg\">\n<TR class=\"table_header_center\">\n<TD width=95>Issue Date</TD>\n<TD>Inv No</TD>\n<TD>Brand</TD>\n<TD>Pic</TD>\n<TD>Sup. Inv No</TD>\n<TD>Net Amount</TD>\n<TD>GST</TD>\n<TD>Total Amount</TD>\n<TD>Claim Status</TD>\n</TR>\n".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string6 = "'></td>\n  <td class=\"table_header_center\">Sort by</td>\n  <td class=\"table_bg_bright\"><SELECT NAME=ag_orderby >\n    <OPTION value=\"0\"   ".toCharArray();
  }
}