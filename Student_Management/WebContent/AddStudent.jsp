<jsp:useBean id="s" class="ap.Student"></jsp:useBean>
<jsp:useBean id="rd" class="ap.Rdao"></jsp:useBean>
<jsp:setProperty property="*" name="s"/>
<%
int i=rd.addStudent(s);
out.println(i+" record added");
%>