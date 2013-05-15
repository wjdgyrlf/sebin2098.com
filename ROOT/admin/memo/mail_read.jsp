<%@page import="java.net.*" %>
<%@page import="java.sql.*" %>
<%@page import="dbconn.*" %>
<%@ page errorPage="../../error.jsp" %>

<%@ include file="../../login_check.jsp" %>

<%

DBConnManager dbPool = null;
boolean connState = false;
int iRet = 0;

String replyid ="";
String replyname ="";
String sentdate ="";
String receive_time ="";
String title ="";
String content ="";
String temp ="";

dbPool = DBConnManager.getInstance();
Connection conn = dbPool.getConnection("intranet");
if( conn == null ) {
	connState = false;
} else {
	connState = true;
}

String seqno = request.getParameter("seqno");

String sql = "SELECT s_seqno, sender_id, sender_name, title, sentdate, " +
		" read_flag, receive, content " +
		" FROM mail_02t " +
		" WHERE userid = '" + userid + "' AND seqno = " + seqno;

String outS = "";

if( connState ) {
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if( rs.next() ) {

		temp = rs.getString(1);
		replyid = rs.getString(2);
		replyname = rs.getString(3);
		title = rs.getString(4);
		sentdate = rs.getString(5);
		receive_time = rs.getString(7);
		if( receive_time == null ) {
			receive_time = "Now";
		}
		content = rs.getString(8);

		outS += "<tr><td width=15>&nbsp;</td>" +
			"<td width=100><img src='img/read_from.gif'>" +
			"</TD>\n<TD width=200><font size=2><input type=text value=\"" +
			replyname + "\" onfocus=blur(this)>" +
			"</td><td width=100><img src='img/read_sent.gif'>" +
			"</TD>\n<TD width=220><font size=2><input type=text value=\"" +
			sentdate + "\" onfocus=blur(this)>" +
			"</td></tr>\n" +
			"<tr><td width=15>&nbsp;</td>" +
			"<td width=100><img src='img/mail_to.jpg'>" +
			"</TD>\n<TD><font size=2>" +
			firstname + " " + lastname +
			"</td><td ><font face=\"Arial\" size=2 color=#808080><B>" +
			"&nbsp; &nbsp; Read</B></font>" +
			"</TD>\n<TD><font size=2>" +
			receive_time + "</td></tr>\n" +
			"<tr><td></td><td><img src='img/read_subject.gif'>" +
			"</TD>\n<TD colspan=3><font size=2><input type=text value=\"" +
			title + "\" onfocus=blur(this) size=65>" +
			"</td></tr><tr height=250 valign=top>" +
			"<td></td><td colspan=4 bgcolor=#eeeeee><font size=2>" +
			content +
			"</td></tr>";

		String first = rs.getString(6);
		rs.close();
		stmt.close();

		if( first != null &&  first.equals("1") ) {
		}else {
			sql = "UPDATE mail_01t SET read_flag = '1', receive = sysdate() " +
				" WHERE userid = '" + replyid + 
				"' AND seqno = " + temp;

			// System.out.println("SQL : " + sql);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();

			sql = "UPDATE mail_02t SET read_flag = '1', receive = sysdate() " +
				" WHERE userid = '" + userid +
				"' AND seqno = " + seqno;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}
	}
	dbPool.freeConnection("intranet", conn);
	connState = false;
}

%>

<HTML>
<HEAD>
<SCRIPT LANGUAGE="JavaScript">
function List(form)
{
	form.action = "mail_inbox.jsp";
	form.submit();
}
function Reply( form )
{
    // form.action = "mail_reply.jsp";
    // form.submit();
	alert("This function is not available any more. Please use outlook.");
}
function Forward( form )
{
    // form.action = "mail_forward.jsp";
    // form.submit();
	alert("This function is not available any more. Please use outlook.");
}
function Delete( form )
{
    result = confirm("Are you sure?");
    if( result == true )
	{
            form.action = "read_delete.jsp";
            form.submit();
    }
}
</SCRIPT>
</HEAD>
<BODY topmargin=0 leftmargin=3>
<%@ include file="main_head.html" %>

<TABLE BORDER=0 CELLSPACING=1 CELLPADDING=0>
<TR>
<TD width="164" align="right">
<a href="mail_comp.jsp">
<IMG src="img/mail_s_compose.jpg" border=0 onmouseover="this.src='img/mail_s_compose_over.jpg'" onmouseout="this.src='img/mail_s_compose.jpg'"></a></TD>
<TD><IMG src="img/mail_s_inbox_over.jpg" border=0></TD>
<TD><a href="mail_sent.jsp">
<IMG src="img/mail_s_sent.jpg" border=0 onmouseover="this.src='img/mail_s_sent_over.jpg'" onmouseout="this.src='img/mail_s_sent.jpg'"></a></TD>
<TD><a href="mail_trash.jsp">
<IMG src="img/mail_s_trash.jpg" border=0 onmouseover="this.src='img/mail_s_trash_over.jpg'" onmouseout="this.src='img/mail_s_trash.jpg'"></a></TD>
</TR>
</TABLE>
<BR>

<TABLE border=0 width="635" cellpadding=0>
<%=outS%>
</TABLE>

<FORM NAME="frmMain" METHOD=POST>
<INPUT TYPE=HIDDEN NAME="checkid" VALUE="<%=seqno%>">
<INPUT TYPE=HIDDEN NAME="replyid" VALUE="<%=replyid%>">
<INPUT TYPE=HIDDEN NAME="replyname" VALUE="<%=replyname%>">
<INPUT TYPE=HIDDEN NAME="replydate" VALUE="<%=sentdate%>">
<INPUT TYPE=HIDDEN NAME="replytitle" VALUE="<%=title%>">
&nbsp;
<a href="javascript:Reply(document.frmMain)"><IMG
SRC="img/read_reply.gif" border=0 onmouseover="this.src='img/read_reply_over.gif'"
 onmouseout="this.src='img/read_reply.gif'" ></a><a href="javascript:Forward(document.frmMain)"><IMG 
SRC="img/read_forward.gif" border=0 onmouseover="this.src='img/read_forward_over.gif'" 
onmouseout="this.src='img/read_forward.gif'" ></a><a href="javascript:Delete(document.frmMain)"><IMG 
SRC="img/read_delete.gif" border=0 onmouseover="this.src='img/read_delete_over.gif'" 
onmouseout="this.src='img/read_delete.gif'" ></a><a href="javascript:List(document.frmMain)"><IMG 
SRC="img/read_list.gif" border=0 onmouseover="this.src='img/read_list_over.gif'" 
onmouseout="this.src='img/read_list.gif'" ></a>
</FORM>
</BODY>
</HTML>
