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
		
		System.out.println ("Welcome="+fn+" "+ln+" "+e);
		
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
		System.out.println("Connection success");
		
		PreparedStatement pstm=con.prepareStatement(" update jspuser set fname=? where email=?");
		
		pstm.setString(1,fn);
		pstm.setString(2,e);
		
		int i=pstm.executeUpdate();
		if(i!=0)
		{
			
			System.out.println("Record Update");
			response.sendRedirect("DeleteUser.jsp");
			
		}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			response.sendRedirect("Error.jsp");
		}	
	%>

</body>
</html>