package employeeapplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;
@WebServlet("/rgstr")
public class AddEmployee extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String First_Name=req.getParameter("name");
		String Last_Name=req.getParameter("lastname");
		String Salary=req.getParameter("salary");
		String Department=req.getParameter("department");
		String Position=req.getParameter("position");
		String Email=req.getParameter("email");
		String Contact_No=req.getParameter("contact");
		
		String Picture=req.getParameter("picture");
		
		double sal = Double.parseDouble(Salary);
		long contact = Long.parseLong(Contact_No);
		
		
		
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
			PreparedStatement ps = con.prepareStatement("insert into employees(first_Name,Last_Name,Salary,Department,Position,Email,Contact_No,Picture)values"
					+ "(?,?,?,?,?,?,?,?)");
			ps.setString(1, First_Name);
			ps.setString(2, Last_Name);
			ps.setDouble(3, sal);
			ps.setString(4, Department);
			ps.setString(5, Position);
			ps.setString(6, Email);
			ps.setLong(7, contact);
			ps.setString(8, Picture);
			ps.execute();
			RequestDispatcher rd = req.getRequestDispatcher("/displayAllEmployee");
			rd.forward(req, resp);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
