<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="dbconn.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ include file="/admin/login_check.jsp" %>
<%@ page contentType = "text/html; charset=euc-kr" %>
<%
int iRet = 0;

Connection conn = null;
dbconn.MatrixDataSet matrix = null;
dbconn.DataProcess dataProcess = null;
String sql = "";

String adminTypeName = "";
String adminGroupName = "";
String adminClassName = "";
String user_level="";
if (_adminclass.equals("1") ) user_level = "User access Level-1";
if (_adminclass.equals("2") ) user_level = "User access Level-2";
  
try {

  matrix = new dbconn.MatrixDataSet();
  dataProcess = new dbconn.DataProcess();
  Context ic = new InitialContext(); 
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/scm"); 		
	conn = ds.getConnection();

  // Read Menu List
  sql = " select  (select code_name from vg_common_code where code = '" + _admintype + "' and type = 'USER_TYPE'), "
      + "         (select code_name from vg_common_code where code = '" + _admingroup + "' and type = 'USER_GROUP'), "
       + "         (select code_name from vg_common_code where code = '" + _adminclass + "' and type = 'USER_CLASS') "
      + " from    dual ";

  iRet = dataProcess.RetrieveData(sql, matrix, conn);

  if (iRet > 0) {
    int j = 0;
    
    adminTypeName   = matrix.getRowData(0).getData(j++);
    adminGroupName  = matrix.getRowData(0).getData(j++);
    adminClassName  = matrix.getRowData(0).getData(j++);
  }

} catch (Exception e) {
  System.out.println("Exception menu_t : " + e.getMessage());
  throw e;
} finally {
  if (conn != null) {conn.close();}
}
%>
<html>
<head>
<title></title>
<link href="/common/css/style.css" rel="stylesheet" type="text/css">
</head>
             	
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="/img/bgimage1.gif">
<table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" bgcolor="white" >	
<!--TR bgcolor=#FAAC58-->
<TR bgcolor=#F0F388>
	<td width=77% align='left'><font size=2 face="Century Gothic" >&nbsp;&nbsp; Welcome to Administrator Site</font></td> 	
	<td width=13% height="17" align="right" class="help_top_menu"><a href="/terms.html" target="_bottom" ><font size=2 face="Century Gothic" >Terms & Condition | </font></a></font></td>
  <td width=5% height="17" align="right" class="help_top_menu"><a href="/disclaimer.html" target="_bottom"><font size=2 face="Century Gothic" >Disclamier</font></a></font>&nbsp;&nbsp;</td>
  <td width=5% height="17" align="right" class="help_top_menu"><a href="./logout.jsp" target="_top"><img src="/img/logout.gif"><font size=2 face="Century Gothic">Logout &nbsp;&nbsp;&nbsp;</a></font></td>  	
</TR> 
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <!--td valign="top" width="100%" background="/img/bgimg3.gif"-->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <!--td width="206"  height="70" rowspan="2" class="top_logo"><a href="/admin/index2.jsp" target="_top"><img src="/img/header_2.gif"></a></td-->
          <td width="452" ><font size=4 face="Century Gothic" color="Yellow"> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href='/admin/index2.jsp' style="text-decoration:none;color=yellow" target="_top">S.C.M Administration</a> </font><br>
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="white" face="Century Gothic" size=2> &copy;Copyright 2011 SEBIN TRADING ENTERPRISE CO,.LTD</font></td>
          <td valign="top">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <!--tr>
                <td height="17" align="right" class="help_top_menu"><a href="./logout.jsp" target="_top"><img src="/img/logout.gif"><font size=2 face="Century Gothic" color="White">Logout</font></a></font></td>
                <td width="10"></td>
              </tr-->
              <tr>
              	<td height="30" align="right" valign="bottom" class="help_top_menu"><font size=2 face="Century Gothic" color="White"><%= adminTypeName %> | </font><font size=2 face="Century Gothic" color="yellow"><%=adminGroupName%></font></td> 		
                <!--td height="30" align="right">
                </td-->
                <td width="10"></td>
              </tr>
              <tr>
                <td height="17" align="right" valign="bottom" class="help_top_menu"><font size=2 face="Century Gothic" color="white"><%=user_level%> | <%=adminClassName%> | <%= _adminid %> | </font> <font size=2 face="Century Gothic" color=yellow><%= _adminname %></font></td>
                <td width="10"></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="13" background="/img/line.gif"></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
