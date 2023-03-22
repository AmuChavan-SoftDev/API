import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class Login extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String e=req.getParameter("email");
		String p=req.getParameter("pass");
		
		System.out.println(e+" "+p);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
			System.out.println("connection success");
			
			PreparedStatement pstm=con.prepareStatement("select * from webuser where email=?");
			pstm.setString(1, e);
			
			ResultSet rs=pstm.executeQuery();
			String name=null;
			String email=null;
			String pass=null;
			while(rs.next())
			{
				name=rs.getString("name");
				email=rs.getString("email");
				pass=rs.getString("password");
				
			}
			//PrintWriter pw=resp.getWriter();
			if(e.equals(email) && p.equals(pass))
			{
				System.out.println("Welcome user:"+name);
				//pw.write("Welcome user"+name);
				resp.sendRedirect("Updateuser.html");
			}
			else
			{
				System.out.println("Error");
				//pw.write("Error");
				resp.sendRedirect("loginuser.html");
			}
			con.close();
		} 
		
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
