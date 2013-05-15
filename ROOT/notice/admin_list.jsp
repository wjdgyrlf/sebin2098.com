<%@ page language="java" import="java.sql.*,java.io.*" %>
<!--%@ page errorPage="../error.jsp" %-->
<%@page import="java.text.*" %>
<%@page import="common.util.*" %>
<%@ include file="/admin/login_check.jsp" %>
<%@ include file="include/db_conn.jsp" %>
<%@ include file="include/include_com.jsp" %>
<%@ include file="include/include_bbs.jsp" %>
<%
//-------------------------------------------------------------
//
//-------------------------------------------------------------

String table_name = request.getParameter("table_name");
//String table_name = "notice" ;
String reqpage      = request.getParameter("page");
String oper_type    = request.getParameter("oper_type");
String qry_cond     = request.getParameter("qry_cond");
String qry_contents = ascToksc(request.getParameter("qry_contents"));

//SimpleDateFormat dd = new SimpleDateFormat("yyyyMMdd");
//String today = dd.format(new java.util.Date());
String today = DateUtil.getFmtDateString(DateUtil.getRelativeDate(new java.util.Date(), 0, 0, -7) , "yyyyMMdd");

int curpage,totpage,i,value,idx;
String url=null, addtag=null;

Connection conn =  DB_Connection();
ResultSet rs = null;

if (qry_cond == null)
	qry_cond = "subject";
if (qry_contents == null)
	qry_contents = "";

rs = SelectBBSQryCount(conn, table_name, qry_cond, qry_contents);

rs.next();
int postcount= rs.getInt("counter");
rs.close();

if (postcount == 0)
{
  url = "admin_link.jsp?table_name="+table_name;
  out.println(Redirect(url));
}
else
{
	if(reqpage == null)
		curpage = 1;
	else
		curpage = Integer.parseInt(reqpage);

	int ipp = 10; // ** The Number of Display
	int vmod = postcount % ipp;

	if(vmod == 0)
		totpage = postcount/ipp;
	else
		totpage = postcount/ipp + 1;

	int go_idx = (curpage-1)*ipp;

	rs = SelectBBSQry(conn, table_name, qry_cond, qry_contents);

	for (i=0; i<go_idx; i++)
	  rs.next();
	%>
<HTML>
<HEAD>
<TITLE>BBS View List</TITLE>
<link href="/common/css/style.css" rel="stylesheet" type="text/css">
</HEAD>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="1000" border="0" cellspacing="0" cellpadding="0">
<tr><td>

<table width="99%" border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
  <td width="100%" height="15" colspan="2"></td>
</tr>
<tr>
  <td width="3%"><img src="/img/image3.jpg"></td>
  <td width="*" class="left_title"><%= table_name.equals("notice") ? "업무 게시판" : "자료실" %></td>
</tr>
<tr>
  <td width="100%" height="2" colspan="2"><hr width="100%"></td>
</tr>
<tr>
  <td width="100%" height="10" colspan="2"></td>
</tr>
</table>

	  <TABLE border="0" width="99%" align='center'>

	    <TR>
	      <TD colspan="3">
                  <LI><FONT size="2"><IMG src='images/new.gif'>는 최근에 Update된 자료입니다.</FONT></LI>
	          <LI><FONT size="2">새로 작성을 위해서는 "Write" 버튼을 클릭하세요.</FONT></LI>
	      </TD>
	    </TR>
	    <TR>
	      <FORM name="form_1" action="admin_list.jsp" method="post">
	      <TD align=center>
	      	<SELECT name="qry_cond">
	      <%
	      //------------------------------------------------
	      //
	      //------------------------------------------------
	      	String qry_cond_value[] = { "subject", "creator", "contents" };
	      	String qry_cond_name[] = { "subject", "creater", "contens" };

	      	String[] selectBox_check = SelectBoxCheck(qry_cond, qry_cond_value);

	        for (int j=0; j < qry_cond_value.length; j++)
	        {
	        	out.println("<OPTION value='" + qry_cond_value[j] + "' " + selectBox_check[j] + ">" + qry_cond_name[j]);
	        }
	      //------------------------------------------------
	      %>
	        </SELECT>
	        <INPUT type="text" name="qry_contents" value="<%=kscToasc(qry_contents) %>" size="20" maxlength="30">
	        <INPUT type="hidden" name="table_name" value="<%=table_name %>">
	        <INPUT type="submit" value="Search">
	        <INPUT type="reset" value="Reset" name=submit1>
	      </TD>
	      </FORM>
	    </TR>

	    </TABLE>
	  <table width='99%' border='0' cellspacing='1' cellpadding='2' align='center' class='table_bg'> 
	  <!--TABLE border="1" width="99%" cellpadding="0" cellspacing="0" bordercolor="yellow" align='center'-->
	    <TR align="center" bgcolor="8a2be2">
	      <TD width="32" class='table_header_center'><FONT  size="2">번호</FONT></TD>
              <TD width="66" class='table_header_center' ><FONT size="2">자료형태</FONT></TD>
	      <TD width="83" class='table_header_center'><FONT  size="2">작성자</FONT></TD>
	      <TD width="260" class='table_header_center'><FONT  size="2">제 목(Subject)</FONT></TD>
	      <TD width="84" class='table_header_center'><FONT  size="2">일자</FONT></TD>
	    </TR>
	<%
	for(i=1;i<=ipp;i++)
	{
	  if (!rs.next()) break;
		if (curpage == (totpage))
		{
			value = postcount % ipp;
			if (i > value && value != 0)
				break;
	  }

	  int bbs_id = rs.getInt("bbs_id");

	  String subject = kscToasc(rs.getString("subject"));
	  subject = subject.replace('\b', '\'');
	  String creator = kscToasc(rs.getString("creator"));
	  String creator_email = kscToasc(rs.getString("creator_email"));
	  String creator_home = kscToasc(rs.getString("creator_home"));
	  String create_date = kscToasc(rs.getString("create_date"));
          String filename = rs.getString("filename");
          //String d2 = Integer.toString( Integer.parseInt(create_date.substring(8,10))+3 ) ;
          String d3 = create_date.substring(0,4)+create_date.substring(5,7)+create_date.substring(8,10);

          int hits = rs.getInt("hits");
	  int p_level = rs.getInt("p_level");
	%>
	    <tr align='center' style='background-color:"#fffff0"' >
	      <TD  width="32" align=right><FONT size="2">
	      <%
		if(p_level ==0)
		{
			out.println(bbs_id);
		}
		else
		{
			out.println("&nbsp;");
		}
	      %>

	      </FONT></TD>
               <%
               if (filename.equals("null") || filename.length() < 3 )
                  {
                  out.println("<TD width=66><IMG src='images/icon1.gif'></TD>");
                  }
               else
                  {
                   out.println(" <TD width=66><IMG src='images/disk.gif'></TD>");
                  }
               %>

	      <TD width="150"><FONT size="2"><%=creator %></FONT></TD>
	      <TD width="260" align='left'><FONT size="2">
	      <%
		if(p_level >0)
		{
			for(idx=1;idx <= (p_level);idx++)
				out.println("&nbsp;");
				//out.println("<IMG src='images/rep.gif'>");
				out.println("Re:&nbsp;");
		} else {
                      //if (Float.parseFloat(d3) >= Float.parseFloat(today) ) out.println("<IMG src='images/new.gif'>");
                      if (Long.parseLong(d3) >= Long.parseLong(today) ) out.println("<IMG src='images/new.gif'>");
                }

		String link_data  = "table_name="+table_name+"&bbs_id="+bbs_id;
		link_data += "&qry_cond="+qry_cond+"&qry_contents="+qry_contents+"&page="+curpage;
		out.println("<A href='admin_view.jsp?"+link_data+"'>");
		if (subject.length() > 60)
		{
			out.println(subject.substring(0,60));
			out.println("...");
		}
		else
			out.println(subject);
		out.println("</A>");

		if(hits> 20)
		{
			//out.println("<IMG src='images/hot.gif'>");
		}
	      %>
	      </FONT></TD>
	      <TD width="84"><FONT size="2"> <%=create_date.substring(0,10) %> </FONT></TD>
	    </TR>
	<%
	}
	%>
	  </TABLE>
	  <BR>
        <TABLE width="99%" border="0" align='center'>
          <tr>
             <TD><CENTER>

	<%
	//------------------------------------------------
	// page function call
	//------------------------------------------------
	url = "admin_list.jsp";
	addtag = "&table_name="+table_name+"&qry_cond="+qry_cond+"&qry_contents="+kscToasc(qry_contents);

	out.println(GetPageIndex(curpage, totpage, url, addtag));
	//------------------------------------------------
	%>
           </CENTER> </TD>
        </TR>
        </TABLE>
	  <TABLE width="99%" border="0" align='center'>
	    <TR>
	      <TD>
                <CENTER><A HREF="insert.jsp?table_name=<%=table_name %>"><IMG src="images/write.gif" border=0></A></CENTER>
	      </TD>
	    </TR>
	  </TABLE>
	  <%
	out.println(CopyRightLogo());
	%>

  </td></tr></table>
	</BODY>
	</HTML>
<%
}
DB_Disconnection(conn);
%>
