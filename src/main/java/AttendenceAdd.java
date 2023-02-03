

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
 * Servlet implementation class AttendenceAdd
 */
@WebServlet("/AttendenceAdd")
public class AttendenceAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendenceAdd() {
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
		Long noc= Long.parseLong(request.getParameter("noofclassess"));
		Long Attc= Long.parseLong(request.getParameter("attclass"));
		String sta = request.getParameter("status");
		String rem =request.getParameter("remark");
		Double avg= Double.parseDouble(request.getParameter("percent"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
			PreparedStatement pst = con.prepareStatement("update Attendence set NOOFCLASSESS=?,ATTENDEDCLASSESS=?,ATTENDENCEPERCENTAGE=?,STATUS=?,REMARK=? where SID=?");
			pst.setLong(6, sid);
			pst.setLong(1,noc);
			pst.setLong(2, Attc);
			pst.setDouble(3,avg);
			pst.setString(4, sta);
			pst.setString(5, rem);
			int i = pst.executeUpdate();
			if(i==1) {
				pw.print("<h1>insert sucessful</h1>");
				RequestDispatcher rd= request.getRequestDispatcher("Attendence.jsp");
				rd.include(request, response);
				}
			else {
				pw.print("Details not Entered please try again Again");
				RequestDispatcher rd= request.getRequestDispatcher("Attendence.jsp");
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
