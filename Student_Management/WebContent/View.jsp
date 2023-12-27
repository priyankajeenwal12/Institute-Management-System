<%@page import=ap.Student"%>
<%@page import="java.util.List"%>
<jsp:useBean id="rd" class="ap.Rdao"></jsp:useBean>
<table align="center" border="1px">
<%
String pn=request.getParameter("pno");
int pno=Integer.parseInt(pn);
int t=5;
if(pno==1)
{
	pno=0;
}
else
{
	pno=pno-1;
	pno=pno*t;
}
List<Student> al=rd.showByPage(pno, t);
for(Student s:al)
{
	%>
	<tr>
	<td><%=s.getSid() %></td>
	<td><%=s.getName() %></td>
	<td><%=s.getFees() %></td>
	<td><%=s.getSubject() %></td>
	<td><%=s.getAddress() %></td>
	</tr>
	<%
}
%>
</table>
<%
int l=rd.show().size();
int c=1;
for(int i=1;i<=l;i=i+5)
{
	%>
	<a href="View.jsp?pno=<%= c %>"><%= c %></a>
	<%
	c++;
}
%>