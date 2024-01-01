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

@WebServlet("/save")
public class bankdetails_29 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public bankdetails_29() {
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
		String f_name = request.getParameter("father_name");
		String acc_no = request.getParameter("account_no");
		String mobile_no = request.getParameter("mobile_no");
		String b_name = request.getParameter("branch_name");
		
//		System.out.println(name);
//		System.out.println(f_name);
//		System.out.println(acc_no);
//		System.out.println(mobile_no);
//		System.out.println(b_name);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_29","root","Aman@1998");
			Statement stmnt=con.createStatement();
			stmnt.executeUpdate("insert into bankDetails values('"+name+"','"+f_name+"','"+acc_no+"','"+mobile_no+"','"+b_name+"')");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
