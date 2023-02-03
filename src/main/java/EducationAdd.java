

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
 * Servlet implementation class EducationAdd
 */
@WebServlet("/EducationAdd")
public class EducationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		HttpSession s= request.getSession(false);
		if(s!=null){
		Long sid= Long.parseLong(request.getParameter("sid"));
		String tensch =request.getParameter("schten");
		String tenyoc =request.getParameter("comten");
		String tenbord =request.getParameter("tenbord");
		String tensub =request.getParameter("subten");
		String twesch =request.getParameter("twesch");
		String tweyoc =request.getParameter("comptwe");
		String twebord =request.getParameter("bordtwe");
		String twesub =request.getParameter("subtwe");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
		PreparedStatement pst = con.prepareStatement("insert into EDUCATION values(?,?,?,?,?,?,?,?,?)");
		pst.setLong(9,sid);
		pst.setString(1,tensch);
		pst.setString(2,tenyoc);
		pst.setString(3,tenbord);
		pst.setString(4,tensub);
		pst.setString(5,twesch);
		pst.setString(6,tweyoc);
		pst.setString(7,twebord);
		pst.setString(8,twesub);
		int i = pst.executeUpdate();
		if(i==1) {
			pw.print("<h1>insert sucessful</h1>");
			RequestDispatcher rd= request.getRequestDispatcher("Education.jsp");
			rd.include(request, response);
			}
		else {
			pw.print("Details not Entered please try again Again");
			RequestDispatcher rd= request.getRequestDispatcher("Education.jsp");
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
