<jsp:useBean id="s" class="ap.Student"></jsp:useBean>
<jsp:useBean id="rd" class="ap.Rdao"></jsp:useBean>
<jsp:setProperty property="sid" name="s"/>
<%
int i=rd.deleteStudent(s);
RequestDispatcher r=request.getRequestDispatcher("Show.jsp");
r.include(request, response);
out.println(i+" record deleted");
%>