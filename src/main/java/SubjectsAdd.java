

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
 * Servlet implementation class SubjectsAdd
 */
@WebServlet("/SubjectsAdd")
public class SubjectsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsAdd() {
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
		HttpSession s = request.getSession(false);
		if(s!=null) {
		Long sid= Long.parseLong(request.getParameter("sid"));
		Long subid= Long.parseLong(request.getParameter("sub"));
		String Subname = request.getParameter("subname");
		String Facultyname = request.getParameter("Fname");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rushi","rushi123");
			PreparedStatement pst = con.prepareStatement("insert into SUBJECTS values(?,?,?,?)");
			pst.setLong(1,subid);
			pst.setString(2,Subname);
			pst.setString(3, Facultyname);
			pst.setLong(4,sid);
			
			int i = pst.executeUpdate();
			if(i==1) {
				String message = "Data inserted sucessfully";
				pw.println("Data inserted sucessfully");
				RequestDispatcher rd =request.getRequestDispatcher("Subjects.jsp");
				rd.include(request, response);
			}
			else {
				
				pw.println("Data not inserted");
				RequestDispatcher rd =request.getRequestDispatcher("Subjects.jsp");
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
