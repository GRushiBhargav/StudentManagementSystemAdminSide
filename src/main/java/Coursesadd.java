

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
 * Servlet implementation class Coursesadd
 */
@WebServlet("/Coursesadd")
public class Coursesadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coursesadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession s = request.getSession(false);
		if(s!=null) {
		Long sid= Long.parseLong(request.getParameter("sid"));
		Long cid= Long.parseLong(request.getParameter("cid"));
		String cname = request.getParameter("cname");
		String Sub = request.getParameter("sub");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
			PreparedStatement pst = con.prepareStatement("insert into courses values(?,?,?,?)");
			
			pst.setLong(1, cid);
			pst.setString(2,cname);
			pst.setString(3, Sub);
			pst.setLong(4,sid);
			
int i = pst.executeUpdate();
			
			if(i==1) {
				pw.print("<h1>insert sucessful</h1>");
				RequestDispatcher rd= request.getRequestDispatcher("Course.jsp");
				rd.include(request, response);
				}
			else {
				pw.print("Details not Entered please try again Again");
				RequestDispatcher rd= request.getRequestDispatcher("Course.jsp");
				rd.include(request, response);
			}
	}catch (Exception e) {
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
