package ap;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rdao {
public Connection con;
public Connection getcon() throws ClassNotFoundException,SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","ajay");	
}
public int addStudent(Student s) throws ClassNotFoundException, SQLException
{
	 con=getcon();
	 String qr="insert into Student values(?,?,?,?,?)";
	 PreparedStatement ps=con.prepareStatement(qr);
	 ps.setInt(1, s.getSid());
	 ps.setString(2, s.getName());
	 ps.setInt(3, s.getFees());
	 ps.setString(4, s.getSubject());
	 ps.setString(5, s.getAddress());
	 int i=ps.executeUpdate();
	 con.close();
	 return i;	 
}

public int updateStudent(Student s) throws ClassNotFoundException, SQLException
{
	con=getcon();
	String qr="update Student set name=?,fees=?,subject=?,address=? where sid=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setInt(5, s.getSid());
	ps.setString(1, s.getName());
	ps.setInt(2, s.getFees());
	ps.setString(3,s.getSubject());
	ps.setString(4, s.getAddress());
	int i=ps.executeUpdate();
	con.close();
	return i;
}
public int deleteStudent(Student s) throws  ClassNotFoundException, SQLException
  {
	con=getcon();
	String qr="delete from Student where sid=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setInt(1, s.getSid());
	int i=ps.executeUpdate();
	con.close();
	return i;
  }
public List<Student> show() throws  ClassNotFoundException, SQLException
{

	con=getcon();
	String qr="select * from Student";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qr);
	List<Student> al= new  ArrayList<Student>();
	while(rs.next())
	{
		Student s=new Student();
		s.setSid(rs.getInt("sid"));
		s.setName(rs.getString("name"));
		s.setFees(rs.getInt("fees"));
		s.setSubject(rs.getString("subject"));
		s.setAddress(rs.getString("address"));
		al.add(s);	
	}
	con.close();
	return al;
} 
public List<Student> showByPage(int a,int b) throws ClassNotFoundException, SQLException
{
	con=getcon();
	String qr="select * from Student limit"+a+","+b;
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qr);
	List<Student> al=new ArrayList<Student>();
	while(rs.next())
	{
		Student s=new Student();
		s.setSid(rs.getInt("sid"));
		s.setName(rs.getString("name"));
		s.setFees(rs.getInt("fees"));
		s.setSubject(rs.getString("subject"));
		s.setAddress(rs.getString("address"));
		al.add(s);
	 }
	con.close();
	return al;
}
	}


