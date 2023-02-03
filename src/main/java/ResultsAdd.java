

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
 * Servlet implementation class ResultsAdd
 */
@WebServlet("/ResultsAdd")
public class ResultsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession s = request.getSession(false);
		PrintWriter pw= response.getWriter();
		if(s!=null) {
		Long sid= Long.parseLong(request.getParameter("sid"));
		Long sem= Long.parseLong(request.getParameter("sem"));
		Float sgpa= Float.parseFloat(request.getParameter("sgpa"));
		Float cgpa= Float.parseFloat(request.getParameter("cgpa"));
		String sub =request.getParameter("sub");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
			PreparedStatement pst = con.prepareStatement("insert into RESULTS values(?,?,?,?,?)");
			pst.setLong(1,sid);
			pst.setLong(2,sem);
			pst.setFloat(3,sgpa);
			pst.setFloat(4,cgpa);
			pst.setString(5, sub);
			
			int i = pst.executeUpdate();
			if(i==1) {
				pw.print("<h1>insert sucessful</h1>");
				RequestDispatcher rd= request.getRequestDispatcher("Result.jsp");
				rd.include(request, response);
				}
			else {
				pw.print("Details not Entered please try again Again");
				RequestDispatcher rd= request.getRequestDispatcher("Result.jsp");
				rd.include(request, response);
			}
		}
		catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
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
