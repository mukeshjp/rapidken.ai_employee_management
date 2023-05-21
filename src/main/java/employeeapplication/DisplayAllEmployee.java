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

import com.mysql.cj.xdevapi.Statement;
@WebServlet("/displayAllEmployee")
public class DisplayAllEmployee extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
		PreparedStatement ps = con.prepareStatement("select * from employees");
		ResultSet rs = ps.executeQuery();
		HttpSession hs = req.getSession();
		hs.setAttribute("emplist", rs);
		
       RequestDispatcher rd = req.getRequestDispatcher("ViewEmployee.jsp");
	   rd.forward(req, resp);
		
	
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		
	
		
	}


