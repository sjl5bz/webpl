package movierater;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class homepage
 */
@WebServlet("/homepage")
public class homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

   // database name = web4640
   //   Note: Looking in the wrong database and/or wrong table may results in either 
   //         cannot connect to the database, not find table, or no result set. 
   //         Thus, make sure specify the correct database name
   // default mysql port in XAMPP is 3306
   // if you change the port number, be sure to change the localhost:port
   // for example, if you set mysql port to 3308, the following DB_URl will be 
   // jdbc:mysql://localhost:3308/web4640 (where web4640 is database name)
      
// If you have not completed the DB-prep extra credit, you need to create an account (to access the database) 
//   
// Create a new user account (for example, "web4640") -- don't touch the "root" account
// Edit privileges, change password tab, assign password to the user ("pwd4640"),
// be sure to refresh under title phpmyadmin at top-left corner.      
// Note: in reality, you would need proper authentication and authorization. 
//     However, for class activity, please don't update the root or require password. 
//     If you eventually need to reverse any setting or forget the newly created user/password combination, 
//     you'll be able to access the database with the root account and update the information or setting as needed)

// Be sure to start the database server before running this servlet
// Note: if the database server (MySQL) does not start, open terminal, type (to kill all mysqld processes)
//            sudo killall mysqld    
//       you may open terminal, type (to see all processes currently running on your computer) 
//            top 
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType ("text/html");
	    PrintWriter out = response.getWriter ();  
	    HttpSession session = request.getSession();
	    String email = (String)session.getAttribute("email");
	    // String email = (String)request.getSession().getAttribute("email");
	    
	    //if you are not logged in then redirect to login
	    // if(email == null) {
	    // 	response.sendRedirect("/movierater/login");
	    // }
	      		

	      out.close ();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType ("text/html");
	    PrintWriter out = response.getWriter (); 
		HttpSession session = request.getSession(); //sets session variable
		String email = request.getParameter("email").toString(); //retrieves email name from input
		request.getSession().setAttribute("email", email); //sets session attribute
		session.setAttribute("email", email); 
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
		doGet(request, response);
	}

	

}
