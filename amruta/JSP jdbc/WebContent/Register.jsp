<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String e=request.getParameter("email");
		String p=request.getParameter("pass");
		
		System.out.println("Welcome"+fn+" "+ln+" "+e+" "+p);
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
			PreparedStatement pstm=con.prepareStatement("insert into jspuser(fname,lname,email,password) value(?,?,?,?)");
			pstm.setString(1,fn);
			pstm.setString(2,ln);
			pstm.setString(3,e);
			pstm.setString(4,p);
			
			int i=pstm.executeUpdate();
			if(i!=0)
			{
				System.out.println("Record Inserted");
				//out.println("Record Update");
				response.sendRedirect("LoginUser.jsp");
			}
			else
			{
				System.out.println("Error");
				//out.println("Error");
				response.sendRedirect("Error.jsp");
			}
			con.close();
		
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		%>

</body>
</html>