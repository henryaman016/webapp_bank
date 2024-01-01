package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update_bankDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public update_bankDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
	
		String acc_no = request.getParameter("account_no");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_29","root","Aman@1998");
			Statement stmnt=con.createStatement();
			stmnt.executeUpdate("UPDATE bankDetails SET account_no='"+acc_no+"' WHERE name='"+name+"' ");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
