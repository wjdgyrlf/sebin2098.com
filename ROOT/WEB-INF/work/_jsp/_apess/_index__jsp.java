/*
 * JSP generated by Resin-3.1.9 (built Mon, 13 Apr 2009 11:09:12 PDT)
 */

package _jsp._apess;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.net.*;

public class _index__jsp extends com.caucho.jsp.JavaPage
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("apess/index.jsp"), -2036832390516219876L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("bottom_line.jsp"), 5941552803368297242L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\n\n\n\n<HTML>\n<link href=\"/common/css/style.css\" rel=\"stylesheet\" type=\"text/css\">		\n<SCRIPT for=\"document\" event=\"onkeypress\">\nif (window.event.keyCode==13)\n{\n        Login()\n}\n</SCRIPT>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\nfunction setCookie (name, value, expires) {\n      document.cookie = name + \"=\" + escape (value) + \"; path=/; expires=\" + expires.toGMTString();\n  }\n\n    function getCookie(Name) {\n      var search = Name + \"=\"\n        if (document.cookie.length > 0) {\n          offset = document.cookie.indexOf(search)\n          if (offset != -1) {\n            offset += search.length\n\n            end = document.cookie.indexOf(\";\", offset)\n\n            if (end == -1)\n              end = document.cookie.length\n            return unescape(document.cookie.substring(offset, end))\n         }\n      }\n      return \"\";\n   }\n\n function saveid(form) {\n      var expdate = new Date();\n\n        if (form.checksaveid.checked  )\n          expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 60);\n        else\n          expdate.setTime(expdate.getTime() - 1);\n          setCookie(\"saveid\", form.id.value, expdate);\n   }\n function getid(form) {\n     form.checksaveid.checked = ((form.id.value = getCookie(\"saveid\")) != \"\");\n  }\nfunction init()\n{\n	frmMain.id.focus();\n}\n\nfunction Login() {\n	id = frmMain.id.value;\n	passwd = frmMain.passwd.value;\n	if( id.length > 0 )\n		if( passwd.length > 0 )\n			frmMain.submit();\n		else {\n			frmMain.passwd.focus();\n			alert('Input password!');\n		}\n	else {\n		frmMain.id.focus();\n		alert('Input Your id and password!');\n	}\n}\n\nfunction bookmark() {\n    var now = new Date(), x;\n    now.setTime(now.getTime() + 365 * 24 * 60 * 60 * 1000);\n    now = now.toGMTString();\n\n    x = document.cookie.toLowerCase().indexOf(\"bookmark\");\n    if(x == -1){\n        document.cookie = 'bookmark = Fast Future Brands Supply Chain Management For APESS;expires=' + now + ';';\n        window.external.AddFavorite(\"http://scm.fastfuturebrands.com.au/apess\", document.title);\n    init();\n    }\n}\n</SCRIPT>\n<HEAD>\n<link rel=\"shortcut icon\" type=\"image/ico\" href=\"../img/FFB2.ico\" />	\n<TITLE>APESS - Supply Chain Management : Fast Future Brands Fashions Pty. Ltd.</TITLE>\n</HEAD>\n<BODY onLoad=\"getid(document.frmMain)\"  text=#000000 background=\"/img/bgimage.gif\" leftMargin=0 topMargin=0 marginheight=\"0\" marginwidth=\"0\">\n<center>\n<center>\n<div align=\"center\">\n   <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"width: 869; height=\"20\" >\n\n      <tr >\n          <td width=\"137\" height=\"50\"></td>\n          	\n      </tr>\n      </table>\n	\n<TABLE WIDTH=794 HEIGHT=50>\n<TR><TD><a href=\"http://www.fastfuturebrands.com.au\" target=\"_new\"><img border=\"0\" src=\"../img/ffblogoblack.gif\" ></a></td>\n<td><font SIZE=4 color=\"#FF8000\" face=\"Century Gothic\" ><B>Welcome to Supply Chain Management For APESS</B></font></tr>\n</TABLE>\n<TABLE WIDTH=794 HEIGHT=260>	\n<TR>		\n<TD WIDTH=390><img border=\"0\" src=\"/img/scmnewlogo2.jpg\" ></TD>\n<TD WIDTH=404 ALIGN=CENTER>\n<FORM ACTION=\"login.jsp\" NAME=frmMain METHOD=POST>\n<TABLE border=0>\n<TR><TD ALIGN=RIGHT><font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" >ID</font></TD>\n<TD><INPUT TYPE=TEXT NAME=id SIZE=10 MAXLENGTH=10 style=\"width: 85px;border:1px solid #5BA3C1;font-size:9pt;\"></TD>\n</TR><TR>\n<TD ALIGN=RIGHT><font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" >Password</font></TD>\n<TD><INPUT TYPE=PASSWORD NAME=passwd SIZE=10 MAXLENGTH=10 style=\"width: 85px;border:1px solid #5BA3C1;font-size:9pt;\"></TD>\n</TR><TD width=50></TD><TD ALIGN=Center><FONT SIZE=2><INPUT TYPE=BUTTON VALUE=\"Login\" ONCLICK=\"JavaScript:Login()\"></TD><TR>\n<TR><TD COLSPAN=2 ALIGN=Center><font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" >Remember Me</font> <input type=\"checkbox\" name=\"checksaveid\" onClick=\"saveid(this.form)\"></TD><br>\n<TR><TD COLSPAN=2><font face=\"Century Gothic\" size=1 color=\"red\" >Forgotten your password?</font><font size=1 color=white>click&nbsp;<a href=\"mailto:scm@ffb.net.au?subject=SCM Request for lost user password\">here</a>&nbsp;to request</font></td></TR>\n<TR><TD COLSPAN=2 ALIGN=left><font face=\"Century Gothic\" size=1 color=\"Yellow\" ><a href=\"JavaScript:bookmark()\">Add</a>&nbsp;to my favorite sites</font></TD></TR>\n</TABLE>\n</FORM>\n\n</TD></TR>\n</TABLE>\n</center>\n<TABLE WIDTH=794 HEIGHT=50>\n	  <tr><TD>\n    <font size=\"1\"><br>\n      <font face=\"Century Gothic\" color=\"#FFFFFF\" >\n      Supply Chain Management (SCM) System allows you to improve communications, while simultaneously\n      forming tighter&nbsp; relationships with upstream vendors. We are now using workflow automation, performance management, advanced planning engines and order management to improve\n      order fulfillment processes across the supply chain. As a result, many of the unnecessary and lengthy delays prevalent in today's\n      fulfillment process are virtually eliminated. It is now possible to efficiently promise, plan, source and fulfill purchase order at a time across your entire supply chain.</font></font></td>\n   </TD>\n  </tr>\n  <br>\n</table>\n<br><br>\n<!--p>\n<font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" > This website is best viewed with a screen resolution setting of 1024 x 768 pixels.</font>\n<p-->\n<table width='99%' border='0' cellspacing='0' cellpadding='0' align='center'>\n <tr><td width='100%' height='2' align='center'>\n  <HR color=\"#5BA3C1\" width=100% size=1></td></tr>\n  <tr><td width='100%' align='center'>\n  <font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" >&copy;Copyright 2010 </font>\n  <font face=\"Century Gothic\" size=2 color=green>Fast Future Brands Pty Ltd. All Rights Reserved.</FONT><BR>\n  <font face=\"Century Gothic\" size=2 color=\"#FFFFFF\" > For more information,please contact &nbsp;&nbsp;<A href='mailto:scm@ffb.net.au'>scm@ffb.net.au</A></FONT>\n  </td></tr></table>\n</div>\n</BODY>\n</HTML>\n".toCharArray();
  }
}