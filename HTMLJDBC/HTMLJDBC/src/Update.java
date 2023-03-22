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

@WebServlet("/UpdateServlet")
public class Update extends HttpServlet


{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nm=req.getParameter("name");
		String e=req.getParameter("email");
		
		System.out.println(nm+" "+e);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","root");
			System.out.println("Connection success");
			
			PreparedStatement pstm=con.prepareStatement("update webuser set name=? where email=?");
			pstm.setString(1,nm);
			pstm.setString(2,e);
			
			int i=pstm.executeUpdate();
			//PrintWriter pw=resp.getWriter();
			if(i!=0)
			{
				System.out.println("Record Updated");
				//pw.write("Record update");
				resp.sendRedirect("Deleteuser.html");
				
			}
			else
			{
				System.out.println("Error");
				//pw.write("Error");
				resp.sendRedirect("Updateuser");
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
