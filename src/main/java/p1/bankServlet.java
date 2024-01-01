package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class bankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public bankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=	DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_details_29","root","Aman@1998");
		Statement stmnt=c.createStatement();
		ResultSet result = stmnt.executeQuery("select * from bankDetails");
		
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>");
		out.print("Name");
		out.print("</th>");
		out.print("<th>");
		out.print("Father Name");
		out.print("</th>");
		out.print("<th>");
		out.print("Account No.");
		out.print("</th>");
		out.print("<th>");
		out.print("Mobile No.");
		out.print("</th>");
		out.print("<th>");
		out.print("Branch Name");
		out.print("</th>");
		out.print("</tr>");
		
		while(result.next()) {
			out.print("<tr>");
			out.print("<td>");
			out.print(result.getString(1));
			out.print("<td>");
			out.print("<td>");
			out.print(result.getString(2));
			out.print("<td>");
			out.print("<td>");
			out.print(result.getString(3));
			out.print("<td>");
			out.print("<td>");
			out.print(result.getString(4));
			out.print("<td>");
			out.print("<td>");
			out.print(result.getString(5));
			out.print("<td>");
			out.print("</tr>");
			
		}
		
		out.print("</table>");
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
