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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
   // JDBC driver name and database URL
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
    public login() {
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
	    
	      out.print ("<!doctype html>\n" + 
	      		"<html>\n" + 
	      		"<head>\n" + 
	      		"	<meta author=\"Sallie : sjl5bz\">\n" + 
	      		"	<meta charset=\"UTF-8\">\n" + 
	      		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
	      		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
	      		"	<title>The Movie Rater - Login</title>\n" + 
	      		"	<!-- <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">\n" + 
	      		"	<script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" + 
	      		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script> -->\n" + 
	      		"\n" + 
	      		"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" + 
	      		"\n" + 
	      		"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
	      		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
	      		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
	      		"	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" + 
	      		"</head>\n" + 
	      		"<body>\n" + 
	      		"	<!-- <nav class=\"navbar navbar-dark bg-dark\">\n" + 
	      		"		<div class=\"container-fluid\">\n" + 
	      		"			<div class=\"row\">\n" + 
	      		"				<div class=\"navbar-header\">\n" + 
	      		"					<div class=\"login-navbar-brand\">The Movie Rater</div>\n" + 
	      		"				</div>\n" + 
	      		"			</div>\n" + 
	      		"		</div>\n" + 
	      		"	</nav> -->\n" + 
	      		"  <nav class=\"navbar navbar-expand-lg\">\n" + 
	      		"		<a class=\"navbar-brand\" href=\"#\"><strong>The Movie Rater</strong></a>\n" + 
	      		"	</nav>\n" + 
	      		"	<div class=\"wrapper\"> \n" + 
	      		"		<form class=\"form-signin\" method=\"post\" action=\"http://localhost:8100/CS4640_Porject/login.php\">\n" + 
	      		"			<h2 class=\"form-signin-heading\">Login </h2>\n" + 
	      		"			<input type=\"text\" name=\"email\" class=\"form-control\" placeholder=\"Email Address\" id=\"email\">\n" + 
	      		"			<p id=\"para1\">Invalid email address</p>\n" + 
	      		"			<!-- <span class=\"error\"><?php echo $emailErr;?></span> -->\n" + 
	      		"			<input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Password\" id=\"password\">\n" + 
	      		"			<p id=\"passwordReq\">Password required</p>\n" + 
	      		"			<!-- <span class=\"error\"><?php echo $passwordErr;?></span> -->\n" + 
	      		"			<label class=\"checkbox\">\n" + 
	      		"				<input type=\"checkbox\" value=\"remember-me\" id=\"rememberMe\" name=\"rememberMe\"> Remember me\n" + 
	      		"			</label>\n" + 
	      		"			<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" onclick=\"return validate()\" id=\"loginbutton\">Login</button>  \n" + 
	      		"			<br/>\n" + 
	      		"			<a id=\"createAccount\" href=\"http://localhost:8100/CS4640_Porject/signup.php\">Create account</a>\n" + 
	      		"		</form>\n" + 
	      		"	</div>\n" + 
	      		"	<script>\n" + 
	      		"		//points cursor to email input when page is loaded\n" + 
	      		"		document.addEventListener('DOMContentLoaded', function() {\n" + 
	      		"			document.getElementById(\"email\").focus();\n" + 
	      		"		});\n" + 
	      		"\n" + 
	      		"		//performs client-side input validation\n" + 
	      		"		function validate() {\n" + 
	      		"			bool = true;\n" + 
	      		"			//if email address is not valid\n" + 
	      		"			if(document.getElementById(\"email\").value.indexOf(\"@\") < 0 || document.getElementById(\"email\").value.indexOf(\".\") < 0) {\n" + 
	      		"				document.getElementById(\"para1\").style.display = \"block\";\n" + 
	      		"				bool = false;\n" + 
	      		"			}\n" + 
	      		"			//if password input is empty\n" + 
	      		"			if(document.getElementById(\"password\").value === \"\") {\n" + 
	      		"				document.getElementById(\"passwordReq\").style.display = \"block\";\n" + 
	      		"				bool = false;\n" + 
	      		"			} else {\n" + 
	      		"				document.getElementById(\"passwordReq\").style.display = \"none\";\n" + 
	      		"			}\n" + 
	      		"			//if email or password input is empty\n" + 
	      		"			if(document.getElementById(\"email\").value === \"\" || document.getElementById(\"password\").value === \"\") {\n" + 
	      		"				bool = false;\n" + 
	      		"			} \n" + 
	      		"			return bool;\n" + 
	      		"\n" + 
	      		"		}\n" + 
	      		"	</script>\n" + 
	      		"</body>\n" + 
	      		"</html>");
		// out.print("<p style=color: white;> " + email + " </p>");
	      out.close ();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType ("text/html");
	 //    PrintWriter out = response.getWriter (); 
		// HttpSession session = request.getSession();
		// String email = request.getParameter("email").toString();
		// request.getSession().setAttribute("email", email);
		// session.setAttribute("email", email); 
		// out.println(email);
		// String output = (String)request.getAttribute("email");
		// System.out.println(output);
		doGet(request, response);
	}
   

}
