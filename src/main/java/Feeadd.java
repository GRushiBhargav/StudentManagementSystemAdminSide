

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
 * Servlet implementation class Feeadd
 */
@WebServlet("/Feeadd")
public class Feeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feeadd() {
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
				Long fid= Long.parseLong(request.getParameter("fee"));
				Long Ta= Long.parseLong(request.getParameter("amount"));
				Long ap= Long.parseLong(request.getParameter("paid"));
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
					PreparedStatement pst = con.prepareStatement("insert into fee values(?,?,?,?)");
					pst.setLong(1,fid);
					pst.setLong(2,Ta);
					pst.setLong(3,ap);
					pst.setLong(4,sid);
					
					int i = pst.executeUpdate();
					if(i==1) {
						pw.print("<h1>insert sucessful</h1>");
						RequestDispatcher rd= request.getRequestDispatcher("Fee.jsp");
						rd.include(request, response);
						}
					else {
						pw.print("Details not Entered please try again Again");
						RequestDispatcher rd= request.getRequestDispatcher("Fee.jsp");
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
