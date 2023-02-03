

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Address
 */
@WebServlet("/Address")
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		HttpSession s = request.getSession(false);
		  if(s!=null) {
		Long sid= Long.parseLong(request.getParameter("stuid"));
		String hno = request.getParameter("hno");
		String area = request.getParameter("area");
		String city =request.getParameter("city");
		String disc=request.getParameter("district");
		String state=request.getParameter("state");
		Long pin= Long.parseLong(request.getParameter("pin"));
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
			PreparedStatement pst = con.prepareStatement("insert into address values(?,?,?,?,?,?,?)");
			
			pst.setString(1,hno);
			pst.setString(2,area);
			pst.setString(3,city);
			pst.setString(4,disc);
			pst.setString(5,state);
			pst.setLong(6,pin);
			pst.setLong(7,sid);
			
			int i = pst.executeUpdate();
			
			if(i==1) {
				pw.print("<h1>insert sucessful</h1>");
				RequestDispatcher rd= request.getRequestDispatcher("Address.jsp");
				rd.include(request, response);
				}
			else {
				pw.print("Details not Entered please try again Again");
				RequestDispatcher rd= request.getRequestDispatcher("Address.jsp");
				rd.include(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		  }
		  else{
			  pw.print("login first");
			  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			  rd.include(request,response);
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
