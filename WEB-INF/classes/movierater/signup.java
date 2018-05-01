package movierater;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
	    out.println("<!doctype html>\n" + 
	    		"<html>\n" + 
	    		"<head>\n" + 
	    		"	<meta author=\"Sallie : sjl5bz\">\n" + 
	    		"	<meta charset=\"UTF-8\">\n" + 
	    		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
	    		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
	    		"	<title>The Movie Rater - Sign up</title>\n" + 
	    		"	<!-- <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">\n" + 
	    		"	<script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n" + 
	    		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script> -->\n" + 
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
	    		"	<nav class=\"navbar navbar-expand-lg\">\n" + 
	    		"		<a class=\"navbar-brand\" href=\"#\"><strong>The Movie Rater</strong></a>\n" + 
	    		"	</nav>\n" + 
	    		"	<div class=\"wrapper\"> \n" + 
	    		"		<form class=\"form-signin\" method=\"post\" action=\"http://localhost:8080/movierater/homepage\">\n" + 
	    		"			<h2 class=\"form-signin-heading\">Sign up</h2>\n" + 
	    		"			<input type=\"text\" name=\"email\" class=\"form-control\" placeholder=\"Email Address\" id=\"email\">\n" + 
	    		"			<p id=\"incorrectEmail\">Invalid Email Address</p>\n" + 
	    		"			<!-- <span> <?php echo $emailErr; ?></span> -->\n" + 
	    		"			<input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Username\" id=\"username\">\n" + 
	    		"			<!-- <span> <?php echo $usernameErr; ?></span> -->\n" + 
	    		"			<input type=\"password\" name=\"Password\" class=\"form-control\" placeholder=\"Password\" id=\"password\">\n" + 
	    		"			<input type=\"password\" name=\"PasswordValidate\" class=\"form-control\" placeholder=\"Enter Password Again\" id=\"passwordValidate\">\n" + 
	    		"			<p id=\"incorrectPassword\">Passwords don't match</p>\n" + 
	    		"			<p id=\"emptyFields\" style=\"display: none\">Please fill in all fields</p>\n" + 
	    		"			<!-- <span> <?php echo $passwordErr; ?></span> -->\n" + 
	    		"			<label class=\"checkbox\">\n" + 
	    		"				<input type=\"checkbox\" value=\"remember-me\" id=\"rememberMe\" name=\"rememberMe\"> Remember me\n" + 
	    		"			</label>\n" + 
	    		"			<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" onclick=\"return validate()\" id=\"loginbutton\">Submit</button>  \n" + 
	    		"			<br/>\n" + 
	    		"			<a id=\"createAccount\" href=\"http://localhost:8080/movierater/login\">Have an account? Login</a>\n" + 
	    		"		</form>\n" + 
	    		"	</div>\n" + 
	    		"	<script>\n" + 
	    		"		//points cursor to email input when page is loaded\n" + 
	    		"		document.addEventListener('DOMContentLoaded', function() {\n" + 
	    		"			document.getElementById(\"email\").focus();\n" + 
	    		"		});\n" + 
	    		"\n" + 
	    		"    //performs client-side input validation\n" + 
	    		"    function validate() {\n" + 
	    		"    	var bool = true;\n" + 
	    		"    	//if any of the inputs are empty then return false\n" + 
	    		"    	if(document.getElementById(\"email\").value === \"\" || document.getElementById(\"password\").value === \"\" || document.getElementById(\"username\").value === \"\" || \n" + 
	    		"    		document.getElementById(\"passwordValidate\").value === \"\") {\n" + 
	    		"    		document.getElementById(\"emptyFields\").style.display = \"block\";\n" + 
	    		"    		return false;\n" + 
	    		"    	} else {\n" + 
	    		"    		document.getElementById(\"emptyFields\").style.display = \"none\";\n" + 
	    		"    	}\n" + 
	    		"    	//if passwords don't match\n" + 
	    		"    	if(document.getElementById(\"password\").value !== document.getElementById(\"passwordValidate\").value) {\n" + 
	    		"    		document.getElementById(\"incorrectPassword\").style.display = \"block\";\n" + 
	    		"    		bool = false;\n" + 
	    		"    	} else {\n" + 
	    		"    		document.getElementById(\"incorrectPassword\").style.display = \"none\";\n" + 
	    		"    	}\n" + 
	    		"    	//if email address is not valid (does not contain '@' or '.')\n" + 
	    		"    	if(document.getElementById(\"email\").value.indexOf(\"@\") < 0 || document.getElementById(\"email\").value.indexOf(\".\") < 0) {\n" + 
	    		"    		document.getElementById(\"incorrectEmail\").style.display = \"block\";\n" + 
	    		"    		bool = false;\n" + 
	    		"    	} else {\n" + 
	    		"    		document.getElementById(\"incorrectEmail\").style.display = \"none\";\n" + 
	    		"    	}\n" + 
	    		"\n" + 
	    		"    	return bool;\n" + 
	    		"		}	\n" + 
	    		"</script>\n" + 
	    		"</body>\n" + 
	    		"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
