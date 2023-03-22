import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class Delete extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	   String e=req.getParameter("email");
	   int id=Integer.parseInt(req.getParameter("id")) ;//non primitive to primitive datatype using wrapper class
	   System.out.println(id);
	   System.out.println(e);	
	   
	   PrintWriter pw=resp.getWriter();
	   pw.write("<h1>Hello User</h1>");
	   pw.write("<head> <style> table, th , td {border:1px solid black;}"+
			   		"</style></head><body>"+
			   		"<table> <tr><th> email </th><th>id </th></tr>"
			   		+"<tr><td>" +e+ "</td> <td>"+id+ "</td> </tr>"
			   		+"</table>");
	   //
	/*try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Driver loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
		System.out.println("connection success");
		PreparedStatement pstm=con.prepareStatement("delete from webuser where email=?");
		pstm.setString(1,e);
		int i=pstm.executeUpdate();
		//PrintWriter pw=resp.getWriter();
		if(i!=0)
		{
			System.out.println("Record deleted");
			//pw.write("<h1>record deleted </h1>");
			resp.sendRedirect("Register.html");
		}
		else
		{
			System.out.println("error");
		//	pw.write("<h1>error</h1>")
			resp.sendRedirect("Deleteuser.html");;
		}
		con.close();
		
		
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}*/
	
	
		
	}
	
}
