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

public class _note_0detail__jsp extends com.caucho.jsp.JavaPage
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
      
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

String QTY_FORMAT = "###,##0";
String MONEY_FORMAT = "###,##0.00";

String outS = "";
String outS2 = "";
int iRet = 0;
int iRet2 = 0;
dbconn.DBConnManager dbPool = null;
dbconn.MatrixDataSet matrix = null;
dbconn.MatrixDataSet matrix2 = null;
dbconn.DataProcess dataProcess = null;
Connection connScm = null;
String sql = "";
String sql2 = "";

String ag_supplier = request.getParameter("ag_supplier");
String ag_year = request.getParameter("ag_year");
String ag_po_no = request.getParameter("ag_po_no");
String ag_inv_no = request.getParameter("ag_inv_no");
String ag_style_no = request.getParameter("ag_style_no");
String ag_orderby = request.getParameter("ag_orderby");
String inv_no_selected   = request.getParameter("inv_no_selected");
if (ag_supplier == null) ag_supplier = "";
if (ag_year == null) ag_year = "";
if (ag_po_no == null) ag_po_no = "";
if (ag_inv_no == null) ag_inv_no = "";
if (ag_style_no == null) ag_style_no = "";
if (ag_orderby == null) ag_orderby = "";
if (inv_no_selected == null) inv_no_selected = "";

String  inv_date   = "";
String  supplier   = "";
String  type       = "";
String  inv_no     = "";
String  pic        = "";
String  po_inv_no  = "";
String  style_no   = "";
String  po_no      = "";
String  item_text  = "";
int qty = 0;
double price = 0.0d;
double total = 0.0d;
String  reason     = "";
String del_type = "";

String  type1      = "";
String  type2      = "";
String  type3      = "";


int   total_qty = 0;
double total_amt  = 0.0d;

// set query
//sql = " select  substr(a.inv_date, 7)||'/'||substr(a.inv_date, 5, 2)||'/'||substr(a.inv_date, 1, 4), "
sql = " select  to_char(a.inv_date, 'dd/mm/yyyy'), "
    + "         a.supplier, "
    + "         a.inv_type, "
    + "         a.inv_no, "
    + "         a.pic, "
    + "         a.po_inv_no, "
    + "         a.del_type "
    + " from    fmsd.vg_cr_mast@apsdb a "
    + " where   a.inv_no = '" + inv_no_selected + "' ";
//out.println(sql);

sql2 =   " select   b.style_no, "
      + "           b.po_no, "
      + "           b.item_text, "
      + "           nvl(b.qty, 0), "
      + "           nvl(b.price, 0), "
      + "           nvl(b.qty * b.price, 0), "
      + "           b.reason "
      + " from      fmsd.vg_cr_detail@apsdb b "
      + " where     b.inv_no = '" + inv_no_selected + "' "
      + " order by b.seq ";

try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  dbPool = DBConnManager.getInstance();
  connScm = dbPool.getConnection("intranet");

  iRet = dataProcess.RetrieveData(sql, matrix, connScm);
  
  if (iRet > 0) {
    matrix2 = new dbconn.MatrixDataSet();
    iRet2 = dataProcess.RetrieveData(sql2, matrix2, connScm);
  }
  
  connScm.commit();

} catch (Exception e) {
  if (connScm != null) {
    try { connScm.rollback(); } catch (Exception ex) {}
  }

  System.out.println("Exception in note_detail : " + e.getMessage());
  throw e;
} finally {
  if (connScm != null) {
    dataProcess = new DataProcess();
    dataProcess.ManipulateData("alter session close database link apsdb", connScm);
    dbPool.freeConnection("intranet", connScm);
  }
}


if (iRet > 0) {
  int j = 0;
  
  inv_date = matrix.getRowData(0).getData(j++);
  supplier = matrix.getRowData(0).getData(j++);
  type = matrix.getRowData(0).getData(j++);
  inv_no = matrix.getRowData(0).getData(j++);
  pic = matrix.getRowData(0).getData(j++);
  po_inv_no = matrix.getRowData(0).getData(j++);
  del_type = matrix.getRowData(0).getData(j++);

  if (type.equals("C")) {
    type1 = "Return Invoice" ;
    type2 = "Credit Invoice No." ;
    type3 = "&nbsp" ;
  }
  else {
    type1 = "Return Tax Invoice" ;
    type2 = "Debit note." ;
    type3 = "We will pay this amount in next payment." ;
  }
  
  if (inv_no.equals("")) inv_no = "&nbsp;";
  if (po_inv_no.equals("")) po_inv_no = "&nbsp;";
}

// print out
for (int i = 0; i < iRet2; i++) {
  int j = 0;

  style_no = matrix2.getRowData(i).getData(j++);
  po_no = matrix2.getRowData(i).getData(j++);
  item_text = matrix2.getRowData(i).getData(j++);
  qty = Integer.parseInt(matrix2.getRowData(i).getData(j++));
  price = Double.parseDouble(matrix2.getRowData(i).getData(j++));
  total = Double.parseDouble(matrix2.getRowData(i).getData(j++));
  reason = matrix2.getRowData(i).getData(j++);

  total_qty += qty;
  total_amt += total;

  outS += "<tr align=center>" +
          "<td><font size=2>" + po_inv_no + "</font></td>" +
          "<td><font size=2>" + style_no  + "</font></td>" +
          "<td><font size=2>" + po_no     + "</font></td>" +
          "<td><font size=2>" + item_text + "</font></td>" +
          "<td><font size=2>" + StringUtil.formatNumber(qty, QTY_FORMAT) + "</font></td>" +
          "<td><font size=2>" + StringUtil.formatNumber(price, MONEY_FORMAT) + "</font></td>" +
          "<td><font size=2>" + StringUtil.formatNumber(total, MONEY_FORMAT) + "</font></td>" +
          "</tr>";

  outS2 += "<tr>" +
           "<TD colspan=2><font size=2> &nbsp; </font></TD>" +
           "<td colspan=1><font size=2>" + po_no     + "</font></td>" +
           "<td colspan=1><font size=2>" + reason + "</font></td>" +
           "<TD colspan=3><font size=2> &nbsp; </font></TD>" +
           "</tr>";
}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      out.print(( request.getHeader("Referer") ));
      out.write(_jsp_string3, 0, _jsp_string3.length);
      out.print(( inv_no_selected ));
      out.write(_jsp_string4, 0, _jsp_string4.length);
      out.print(( ag_supplier ));
      out.write(_jsp_string5, 0, _jsp_string5.length);
      out.print(( ag_year ));
      out.write(_jsp_string6, 0, _jsp_string6.length);
      out.print(( ag_po_no ));
      out.write(_jsp_string7, 0, _jsp_string7.length);
      out.print(( ag_inv_no ));
      out.write(_jsp_string8, 0, _jsp_string8.length);
      out.print(( ag_style_no ));
      out.write(_jsp_string9, 0, _jsp_string9.length);
      out.print(( ag_orderby ));
      out.write(_jsp_string10, 0, _jsp_string10.length);
      out.print(( type1 ));
      out.write(_jsp_string11, 0, _jsp_string11.length);
      out.print((inv_date));
      out.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((supplier));
      out.write(_jsp_string13, 0, _jsp_string13.length);
      out.print((type2));
      out.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((inv_no));
      out.write(_jsp_string15, 0, _jsp_string15.length);
      out.print((pic));
      out.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((outS));
      out.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((outS2));
      out.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((type3));
      out.write(_jsp_string19, 0, _jsp_string19.length);
      out.print((pic));
      out.write(_jsp_string20, 0, _jsp_string20.length);
      out.print((StringUtil.formatNumber(total_qty, QTY_FORMAT)));
      out.write(_jsp_string21, 0, _jsp_string21.length);
      out.print((StringUtil.formatNumber(total_amt, MONEY_FORMAT)));
      out.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((StringUtil.formatNumber(total_amt*(del_type.equals("FOB") ? 0.0 : 0.1), MONEY_FORMAT)));
      out.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((StringUtil.formatNumber(total_amt*(del_type.equals("FOB") ? 1.0 : 1.1), MONEY_FORMAT)));
      out.write(_jsp_string24, 0, _jsp_string24.length);
      out.print((inv_no_selected));
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("order/note_detail.jsp"), -5969653330424942299L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("login_check.jsp"), 5313538553479869376L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string23;
  private final static char []_jsp_string5;
  private final static char []_jsp_string15;
  private final static char []_jsp_string2;
  private final static char []_jsp_string21;
  private final static char []_jsp_string25;
  private final static char []_jsp_string18;
  private final static char []_jsp_string4;
  private final static char []_jsp_string24;
  private final static char []_jsp_string8;
  private final static char []_jsp_string11;
  private final static char []_jsp_string10;
  private final static char []_jsp_string1;
  private final static char []_jsp_string14;
  private final static char []_jsp_string20;
  private final static char []_jsp_string26;
  private final static char []_jsp_string6;
  private final static char []_jsp_string7;
  private final static char []_jsp_string16;
  private final static char []_jsp_string3;
  private final static char []_jsp_string19;
  private final static char []_jsp_string22;
  private final static char []_jsp_string13;
  private final static char []_jsp_string0;
  private final static char []_jsp_string12;
  private final static char []_jsp_string17;
  private final static char []_jsp_string9;
  static {
    _jsp_string23 = " </font></td>\n        </tr>\n        <tr>\n          <td width=\"50%\" align=\"center\"> <font size=2> G.Total </font></td>\n          <td width=\"50%\" align=\"right\" > <font size=2> ".toCharArray();
    _jsp_string5 = "'>\n<input type='hidden' name='ag_year' value='".toCharArray();
    _jsp_string15 = "</b>  </font></TD>\n<TD align = center > <font size=3 > From  </font></TD>\n<TD align = center colspan = 2> <font size=3 > ".toCharArray();
    _jsp_string2 = "\n<HTML>\n<HEAD>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT LANGUAGE=JavaScript>\nfunction fnBack(frm)\n{\n  frm.action = \"".toCharArray();
    _jsp_string21 = " </font></td>\n        </tr>\n        <tr>\n          <td width=\"50%\" align=\"center\"> <font size=2> Amount </font></td>\n          <td width=\"50%\" align=\"right\" > <font size=2> ".toCharArray();
    _jsp_string25 = "\")>\n    <input type=button value=\"Back\"    onclick=\"fnBack(this.form)\">\n  </td>\n</tr>\n</table>\n".toCharArray();
    _jsp_string18 = "\n<TR height=10>\n<TD>&nbsp;</TD>\n</TR>\n<TR>\n<TD align=right  colspan=3> <font size=2> &nbsp; &nbsp; <font></TD>\n<TD align=center colspan=1> <font size=2> ".toCharArray();
    _jsp_string4 = "'>\n<input type='hidden' name='ag_supplier' value='".toCharArray();
    _jsp_string24 = " </font></td>\n        </tr>\n      </table>\n    </td>\n  </tr>\n</table>\n<table width='650' border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n<tr>\n  <td width=\"100%\" height=\"15\">\n    <input type=button value=\"Print\"   onclick=fnPrint(\"".toCharArray();
    _jsp_string8 = "'>\n<input type='hidden' name='ag_style_no' value='".toCharArray();
    _jsp_string11 = " </b> </font></TD>\n</TR>\n<TR height=5>\n<TD align = center colspan=3> <font size=2 >   &nbsp;   </font></TD>\n</TR>\n</TABLE>\n\n<TABLE  border=1 width=650 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR>\n<TD align = center > <font size=3 > Date  </font></TD>\n<TD align = center > <font size=3 > ".toCharArray();
    _jsp_string10 = "'>\n<TABLE border=0 width=650 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR>\n<TD align=center colspan=3 style='line-height:30px;'> <font size=5 color=\"#008000\"> <b> Fast Future Brands Pty. Ltd. </b></font></TD>\n</TR>\n<TR height=10>\n<TD align = center colspan=3> <font size=2 >   &nbsp;   </font></TD>\n</TR>\n<TR>\n<TD align = center colspan=3> <font size=2 color=\"#FF0000\">     ABN 88 075 128 460  </font></TD>\n</TR>\n<TR height=5>\n<TD align = center colspan=3> <font size=2 >   &nbsp;   </font></TD>\n</TR>\n<TR>\n<TD align=left><font size=2 >91 Mars Road, Lane Cove West, NSW 2066</font></TD>\n<TD align=center> <font size=2 >   &nbsp;   </font></TD>\n<TD align=right> <font size=2 >   Tel:(02) 8458 6200 Fax:(02) 8458 6390 </font></TD>\n</TR>\n\n<TR height=5>\n<TD align = center colspan=3> <font size=2 >   &nbsp;   </font></TD>\n</TR>\n<TR>\n<TD align = center colspan=3> <font size=4 ><b> ".toCharArray();
    _jsp_string1 = "\n\n\n".toCharArray();
    _jsp_string14 = "</b>  </font></TD>\n<TD align = center > <font size=3 ><b> ".toCharArray();
    _jsp_string20 = "<font></TD>\n<TD align=left   colspan=3> <font size=2> &nbsp; </font></TD>\n</TR>\n</TABLE>\n\n<table  border=\"0\" width=\"650\" cellspacing=\"0\" cellpadding=\"0\" align='center'>\n  <tr>\n    <td width=\"80%\"></td>\n    <td width=\"20%\"></td>\n  </tr>\n  <tr>\n    <td width=\"80%\"></td>\n    <td width=\"20%\">\n      <table border=\"1\" width=\"100%\" cellspacing=0 cellpadding=0>\n        <tr>\n          <td width=\"100%\" colspan=\"2\">\n            <p align=\"center\"> <font size=2> Total </font></td>\n        </tr>\n        <tr>\n          <td width=\"50%\" align=\"center\"> <font size=2> Qty </font></td>\n          <td width=\"50%\" align=\"right\" > <font size=2> ".toCharArray();
    _jsp_string26 = "\n</form>\n\n</td></tr></table>\n</BODY>\n</HTML>\n".toCharArray();
    _jsp_string6 = "'>\n<input type='hidden' name='ag_po_no' value='".toCharArray();
    _jsp_string7 = "'>\n<input type='hidden' name='ag_inv_no' value='".toCharArray();
    _jsp_string16 = "  </font></TD>\n</TR>\n</TABLE>\n\n<TABLE  border=0 width=650 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR height=1>\n</TR>\n</TABLE>\n\n<TABLE  border=1 width=650 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR>\n<TD align= center > <font size=3> Inv.No </font></TD>\n<TD align= center > <font size=3> Style.No </font></TD>\n<TD align= center > <font size=3> PO.No </font></TD>\n<TD align= center > <font size=3> Description </font></TD>\n<TD align= center > <font size=3> Qty </font></TD>\n<TD align= center > <font size=3> Net Price </font></TD>\n<TD align= center > <font size=3> Total</font></TD>\n</TR>\n<BR>\n</BR>\n".toCharArray();
    _jsp_string3 = "\";\n  frm.submit();\n}\n\nfunction fnPrint(inv_no_selected)\n{\n  url = \"./note_print.jsp?inv_no_selected=\" + inv_no_selected;\n  window.open(url,\"none\", \"toolbar=no, menubar=no, resizable=no, scrollbars=yes, width=800, height=700\");\n}\n</SCRIPT>\n</HEAD>\n<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n<table width=\"840\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr><td>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n<tr>\n  <td width=\"100%\" height=\"15\" colspan=\"2\"></td>\n</tr>\n<tr>\n  <td width=\"3%\"><img src=\"/img/title_icon.gif\"></td>\n  <td width=\"*\" class=\"left_title\">Credit/Debit Note</td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"2\" colspan=\"2\"><hr width=\"100%\"></td>\n</tr>\n<tr>\n  <td width=\"100%\" height=\"10\" colspan=\"2\"></td>\n</tr>\n</table>\n\n<FORM name=frmMain ACTION=\"note_confirm_search.jsp\" METHOD=POST>\n<input type='hidden' name='inv_no_selected' value='".toCharArray();
    _jsp_string19 = " </font></TD>\n<TD align=right  colspan=3> <font size=2> &nbsp; &nbsp; <font></TD>\n</TR>\n<TR>\n<TD align=right  colspan=3> <font size=2> &nbsp; &nbsp; <font></TD>\n<TD align=center colspan=1> <font size=2> Please confirm Return Invoice with &nbsp; ".toCharArray();
    _jsp_string22 = " </font></td>\n        </tr>\n        <tr>\n          <td width=\"50%\" align=\"center\"> <font size=2> GST </font></td>\n          <td width=\"50%\" align=\"right\" > <font size=2> ".toCharArray();
    _jsp_string13 = "  </font></TD>\n<TD align = center > <font size=3 > Fax  </font></TD>\n<TD align = center > <font size=3 > &nbsp;  </font></TD>\n</TR>\n<TR>\n<TD align = center colspan = 3> <font size=3 ><b> ".toCharArray();
    _jsp_string0 = "\n\n\n\n\n\n".toCharArray();
    _jsp_string12 = "  </font></TD>\n<TD align = center > <font size=3 > To  </font></TD>\n<TD align = center width=200> <font size=3 > ".toCharArray();
    _jsp_string17 = "\n</TABLE>\n<BR>\n</BR>\n<TABLE  border=0 width=650 CELLPADDING=0 CELLSPACING=0 align='center'>\n<TR>\n<TD align= left   colspan=2> <font size=2> Reason for Request : </font></TD>\n<TD align= center colspan=5> <font size=3> &nbsp; </font></TD>\n</TR>\n".toCharArray();
    _jsp_string9 = "'>\n<input type='hidden' name='ag_orderby' value='".toCharArray();
  }
}