package employeeapplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/updateemployee")
public class UpdateEmployee extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String First_Name=req.getParameter("name");
		String Last_Name=req.getParameter("lastname");
		String salary=req.getParameter("salary");
		String Department= req.getParameter("department");
		String Position=req.getParameter("position");
		String email=req.getParameter("email");
		String Contact = req.getParameter("contact");
		String Picture = req.getParameter("picture");
		
		HttpSession hs=req.getSession();
		ResultSet rs=(ResultSet)hs.getAttribute("emp");
		
		int id1=0;
		try {
			 id1=rs.getInt(9);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		double salary1= Double.parseDouble(salary);
		long contact1= Long.parseLong(Contact);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
			PreparedStatement ps = con.prepareStatement("update employees set first_Name=?,Last_Name=?,Salary=?,Department=?,Position=?,Email=?,Contact_No=?,Picture=? where Id=?");
			ps.setString(1, First_Name);
			ps.setString(2, Last_Name);
			ps.setDouble(3, salary1);
			ps.setString(4, Department);
			ps.setString(5, Position);
			ps.setString(6, email);
			ps.setLong(7, contact1);
			ps.setString(8, Picture);
			ps.setInt(9, id1);
			ps.execute();
			
			RequestDispatcher rd= req.getRequestDispatcher("displayAllEmployee");
			rd.forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
