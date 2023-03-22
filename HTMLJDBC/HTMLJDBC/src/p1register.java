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


@WebServlet("/p1registerServlet")
public class p1register extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nm=req.getParameter("name");
		String e=req.getParameter("email");
		String pass=req.getParameter("pass");
		 System.out.println(nm+" "+e+" "+pass);
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
		   Connection con=DriverManager.getConnection("mysql:jdbc://localhost:3306/practice","root","root");
			System.out.println("connection success");
			
			PreparedStatement pstm=con.prepareStatement("insert into prc(name,email,pass) values(?,?,?)");
			int i=pstm.executeUpdate();//for insert use executeupdate
			PrintWriter pw=resp.getWriter();
			if(i!=0)
			{
				System.out.println("Record inserted");
				pw.write("Record inserted");
			}
			else
			{
				System.out.println("error");
				pw.write("write");
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
