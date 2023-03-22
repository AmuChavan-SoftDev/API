<%@page import="java.sql.ResultSet"%>
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
		String e=request.getParameter("email");
		String p=request.getParameter("pass");
		
		System.out.println("Login User="+e+" "+p);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
			System.out.println("Connection Success");
			
			PreparedStatement pstm=con.prepareStatement("select * from jspuser where email=?");
			pstm.setString(1,e);
			ResultSet rs=pstm.executeQuery();
			
			String fname=null;
			String lname=null;
			String email=null;
			String pass=null;
			
			while(rs.next())
			{
				fname=rs.getString("fname");
				lname=rs.getString("lname");
				email=rs.getString("email");
				pass=rs.getString("password");
			}
			if(e.equals(email) && p.equals(pass))
			{
				System.out.println("welcome="+fname+" "+lname);
				response.sendRedirect("UpdateUser.jsp");				
				
				
			}
			else
			{
				out.println("Error");
				response.sendRedirect("Error.jsp");
			}
				
			
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		
		%>

</body>
</html>