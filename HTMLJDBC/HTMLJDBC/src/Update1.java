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

@WebServlet("/Update1Servlet")
public class Update1 extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	String n=req.getParameter("name");
	String e=req.getParameter("email");
	System.out.println(n+" "+e);
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
		System.out.println("Connection success");
		
		PreparedStatement pstm=con.prepareStatement("update webuser set name=? where email=?");
		
		pstm.setString(1,n);
		pstm.setString(2, e);
		
		int i=pstm.executeUpdate();
		PrintWriter pw=resp.getWriter();
		if(i!=0)
		{
			System.out.println("updated");
			pw.write("Record Updated");
		}
		else
		{
			System.out.println("error");
			pw.write("error");
		}
		con.close();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
}
