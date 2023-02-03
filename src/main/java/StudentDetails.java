

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
 * Servlet implementation class StudentDetails
 */
@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		HttpSession s= request.getSession();
		if(s!=null) {
		int sid= Integer.parseInt(request.getParameter("sid"));
		String sna = request.getParameter("sn");
		String gen = request.getParameter("gen");
		String dob = request.getParameter("dob");
		long age= Integer.parseInt(request.getParameter("age"));
		String mail = request.getParameter("eid");
		String fn = request.getParameter("fn");
		String mn = request.getParameter("mn");
		long mob= Long.parseLong(request.getParameter("tel"));
		String blood =request.getParameter("bg");
		long aan= Long.parseLong(request.getParameter("aan"));
		String pcn = request.getParameter("pen");
		String doj = request.getParameter("doj");
		
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
				PreparedStatement pst = con.prepareStatement("insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setLong(1,sid);
				pst.setString(2, sna);
				pst.setString(3, gen);
				pst.setString(4, dob);
				pst.setLong(5,age);
				pst.setString(6, mail);
				pst.setString(7, fn);
				pst.setString(8, mn);
				pst.setLong(9,mob);
				pst.setString(10, blood);
				pst.setLong(11,aan);
				pst.setString(12,pcn);
				pst.setString(13, doj);
					
				int i = pst.executeUpdate();
				
				if(i==1) {
					String m = "Data inserted";
					pw.print("Data inserted");
					RequestDispatcher rd= request.getRequestDispatcher("StudentDetails.jsp");
					rd.include(request, response);
				}
				else {
					pw.print("Details not Entered please try again Again");
					RequestDispatcher rd= request.getRequestDispatcher("StudentDetails.jsp");
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
