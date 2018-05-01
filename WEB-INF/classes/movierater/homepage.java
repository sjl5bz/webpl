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
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  

   // database name = web4640
   //   Note: Looking in the wrong database and/or wrong table may results in either 
   //         cannot connect to the database, not find table, or no result set. 
   //         Thus, make sure specify the correct database name
   // default mysql port in XAMPP is 3306
   // if you change the port number, be sure to change the localhost:port
   // for example, if you set mysql port to 3308, the following DB_URl will be 
   // jdbc:mysql://localhost:3308/web4640 (where web4640 is database name)
   final static String DB_URL = "jdbc:mysql://localhost:3308/hospital";    
   
   //  Database credentials
   final static String USER = "root";
   final static String PWD = "root";
      
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
	    
	     out.println("msg");
	     String msg = "";      // feedback indicating whether the query is successful
      	 try {
        Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
        out.println("Where is your MySQL JDBC Driver?");
        e.printStackTrace();
        return;
    }

    out.println("MySQL JDBC Driver Registered!");
    Connection connection = null;

    try {
        connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/","sjl5bz", "password");

    } catch (SQLException e) {
        out.println("Connection Failed! Check output console");
        e.printStackTrace();
        out.println(e);
        return;
    }

    if (connection != null) {
        out.println("You made it, take control your database now!");
    } else {
        out.println("Failed to make connection!");
    }
	      		

	      out.close ();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType ("text/html");
		String msg = retrieveData(response);
	    PrintWriter out = response.getWriter (); 
		HttpSession session = request.getSession(); //sets session variable
		String email = request.getParameter("email").toString(); //retrieves email name from input
		request.getSession().setAttribute("email", email); //sets session attribute
		session.setAttribute("email", email); 
		doGet(request, response);
	}

	
	private String retrieveData(HttpServletResponse response) throws ServletException, IOException {	  
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      ResultSet rs = null;
      Statement stmt = null;
      Connection conn = null;
      
      String msg = "";      // feedback indicating whether the query is successful
      
      try 
      {
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // System.out.println("MySQL JDBC Driver Registered");
	          
         // Open a connection
         conn = DriverManager.getConnection(DB_URL, USER, PWD);
         // System.out.println("Connection established");
	   
         // Execute SQL query
         stmt = conn.createStatement();
         String query = "SELECT * FROM users";
         rs = stmt.executeQuery(query);                    
        		
         // Extract data from result set
         while (rs.next())
         {
            // Retrieve by column name
            String id  = rs.getString("UserID");
  
            // Display values on screen
            // out.println("test_id : " + id + ", test_desc : " + desc + " <br />");            
            msg = msg + "<br /> test_id : " + id + " <br />";
         }	   
                 
         // Clean-up environment
         if (rs != null)
            rs.close();         
         stmt.close();
         conn.close();
         // System.out.println("close database");
                
         Driver driver = null;
         java.sql.DriverManager.deregisterDriver(driver);         
         // System.out.println("deregister driver");
         msg = query;
      } catch (SQLException se) {
         se.printStackTrace();       // handle errors for JDBC
      } catch (Exception e) {            
         e.printStackTrace();        // handle errors for Class.forName
      } finally {
          // finally block used to close resources
          try {
             if (stmt != null)
                stmt.close();

             Driver driver = null;
             java.sql.DriverManager.deregisterDriver(driver);

          } catch (SQLException se2) {
     	 // nothing we can do
         	 
          }             
          try
          {
             if (conn != null)
                conn.close();

             Driver driver = null;
             java.sql.DriverManager.deregisterDriver(driver);

          } catch (SQLException se) {
             se.printStackTrace();
          } // end finally try   
          
       } // end try

      return msg;
   }

}
