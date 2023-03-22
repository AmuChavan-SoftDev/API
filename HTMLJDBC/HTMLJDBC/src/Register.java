import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class Register extends HttpServlet
{

	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		String nm=req.getParameter("name");
		String e=req.getParameter("email");
		String p=req.getParameter("pass");
		
		
		System.out.println(nm);
		System.out.println(e);
		System.out.println(p);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1", "root","root");
			System.out.println("connection success");
			
			PreparedStatement pstm=con.prepareStatement("insert into webuser(name,email,password) values(?,?,?)");
			pstm.setString(1,nm);
			pstm.setString(2,e);
			pstm.setString(3,p);
			
			int i=pstm.executeUpdate();
		//	PrintWriter pw=resp.getWriter();
			
			if(i!=0)
			{
				System.out.println("Record inserted");
				//pw.write("record inserted");
				resp.sendRedirect("loginuser.html");
			}
			else
			{
				System.out.println("error");
				//pw.write("error");
				resp.sendRedirect("Error.html");
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

	
	

