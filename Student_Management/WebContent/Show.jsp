
<%@page import="ap.Student"%>
<%@page import="java.util.List"%>
<jsp:useBean id="rd" class="ap.Rdao"></jsp:useBean>
<table align="center" border="1px">
<tr>
<th> Id</th>
<th> Name</th>
<th> Fees</th>
<th> Subject</th>
<th> Address</th>
<th> Update</th>
<th> Delete</th>
</tr>
<%
   List<Student> al=rd.show();
   for(Student s:al)
   {
	  %>
	  <tr>
	  <form action="Update.jsp">
	  <td><%=s.getSid() %><input type="hidden" name="sid" value="<%=s.getSid()%>"/></td>
	  <td><input type="text" name="name" value="<%=s.getName()%>"/></td>
	  <td><input type="number" name="fees" value="<%=s.getFees()%>"/></td>
	  <td><input type="text" name="subject" value="<%=s.getSubject()%>"/></td>
	  <td><input type="text" name="address" value="<%=s.getAddress()%>"/></td>
	  <td><input type="submit" value= Update /></td>
	  </form>
	  <td><a href="Delete.jsp?sid=<%=s.getSid() %>">Delete</a></td> 
	  </tr> 
	  <%
  }
%>



</table>