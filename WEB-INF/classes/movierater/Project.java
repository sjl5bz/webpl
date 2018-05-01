package movierater;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class Project extends HttpServlet 
{	
   // Location of servlet. 
   // static String url = "http://labunix03.cs.virginia.edu:8080/up3f/examples.servletFormhandler2";   // labunix	
   static String url = "http://localhost:8080/movierater/project";
   // note: domain="localhost:8080", path="/cs4640s18/", servlet="examples.servletFormhandler2"
   
   // note: this servletFormHandler2 servlet is in examples.servlet package
   // to deploy, the servlet .class file must be put in examples/servlet/ directories 
   // (labunix03) 
   //    put servletFormhandler2.class in /opt/tomcat/webapps/your-username/WEB-INF/classes/examples/servlet/ 
   // (local) 
   //    put servletFormhandler2.class in /tomcat/webapps/your-username/WEB-INF/classes/examples/servlet/
   // if you create a servlet and have different file structure, remember to update the paths
	   
   // to access the servlet
   // (local) 
   //    http://localhost:8080/cs4640s18/examples.servletFormhandler2
   // (labunix03) 
   //    http://labunix03:8080/up3f/examples.servletFormhandler2  
	
   // Important note: labunix does not support servlet annotation and thus using @WebServlet does not work
   // You need to manually do servlet mapping using web.xml file
   
   String msg = "";
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
               throws ServletException, IOException 
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
     out.print("<!DOCTYPE html>\n" + 
     		"<head>\n" + 
     		"	<meta author=\"Rice Tyler : rht6nf\">\n" + 
     		"	<meta charset=\"utf-8\">\n" + 
     		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
     		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
     		"\n" + 
     		"	<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
     		"\n" + 
     		"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" + 
     		"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
     		"\n" + 
     		"	\n" + 
     		"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
     		"	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" + 
     		"	<style>\n" + 
     		"\n" + 
     		"</style>\n" + 
     		"</head>\n" + 
     		"\n" + 
     		"<body>\n" + 
     		"	<!-- <nav class=\"navbar navbar-dark\" id=\"bootstrap\" >\n" + 
     		"		<div class=\"container-fluid\" style=\"background-color: black\">\n" + 
     		"			<div class=\"row\">\n" + 
     		"				<div class=\"navbar-header\">\n" + 
     		"					<div class=\"navbar-brand\"> <a href=\"movierater/homepage\" style=\"color:gold; text-decoration:none;\">The Movie Rater</a></div>\n" + 
     		"				</div>\n" + 
     		"				<ul class=\"nav navbar-nav\">\n" + 
     		"					<li><a href=\"homepage.php\">Home</a></li>\n" + 
     		"					<li><a href=\"Template.html\">Search</a></li>\n" + 
     		"				</ul>\n" + 
     		"			</div>\n" + 
     		"		</div>\n" + 
     		"	</nav> -->\n" + 
     		"\n" + 
     		"	<nav class=\"navbar navbar-expand-lg\">\n" + 
     		"		<a class=\"navbar-brand\" href=\"#\"><strong>The Movie Rater</strong></a>\n" + 
     		"		<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" + 
     		"			<span class=\"navbar-toggler-icon\"></span>\n" + 
     		"		</button>\n" + 
     		"		<div class=\"collapse navbar-collapse\" id=\"navbarText\">\n" + 
     		"			<ul class=\"navbar-nav mr-auto\">\n" + 
     		"				<li class=\"nav-item active\">\n" + 
     		"					<a class=\"nav-link\" href=\"#\">Home</a>\n" + 
     		"				</li>\n" + 
     		"				<li class=\"nav-item\">\n" + 
     		"					<a class=\"nav-link\" href=\"#\">Browse</a>\n" + 
     		"				</li>\n" + 
     		"				<li class=\"nav-item\">\n" + 
     		"					<a class=\"nav-link\" href=\"#\">Reviews</a>\n" + 
     		"				</li>\n" + 
     		"			</ul>\n" + 
     		"			<form class=\"form-inline\">\n" + 
     		"				<input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\n" + 
     		"				<button class=\"btn btn-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" + 
     		"			</form> \n" + 
     		"		</div>\n" + 
     		"	</nav>\n" + 
     		"	\n" + 
     		"	<div class=\"card card-outline-primary mb-3 text-center\">\n" + 
     		"		<div class=\"card-block\">\n" + 
     		"			<div class=\"row\">\n" + 
     		"				<div class=\"col-lg-4\">\n" + 
     		"					<img class=\"img-responsive rounded float-center\" src=\"Poster.jpg\" style=\"width: 75%\">\n" + 
     		"				</div>\n" + 
     		"				<div class=\"col-lg-8 text-left\">\n" + 
     		"					<h2>MOVIE TITLE GOES HERE</h2>\n" + 
     		"					<p><strong> DIRECTOR: </strong><a href=\"#\"> BIG SHOT HOLLYWOODMAN</a></p>\n" + 
     		"					<p><strong> WRITER(S): </strong> FANSTASTIC WRITER</p>\n" + 
     		"					<p><strong>GENRE:</strong> MYSTERY</p>\n" + 
     		"					<p><strong> RELEASE DATE: </strong> 07/23/1996 </p>\n" + 
     		"					<p><strong> PlLOT SUMMARY: </strong></p>\n" + 
     		"					<p><strong> <a href=\"review.php\">Write a Review</a> </strong></p>\n" + 
     		"					<blockquote>blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah</blockquote>\n" + 
     		"				</div>\n" + 
     		"			</div>\n" + 
     		"		</div>\n" + 
     		"	</div>\n" + 
     		"	<div class=\"card card-outline-primary mb-3 text-center\">\n" + 
     		"		<div class=\"card-block\">\n" + 
     		"			<div id=\"mycarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" + 
     		"				<ol class=\"carousel-indicators\">\n" + 
     		"					<li data-target=\"#mycarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" + 
     		"					<li data-target=\"#mycarousel\" data-slide-to=\"1\"></li>\n" + 
     		"					<li data-target=\"#mycarousel\" data-slide-to=\"2\"></li>\n" + 
     		"				</ol>\n" + 
     		"				<div class=\"carousel-inner\" role=\"listbox\">\n" + 
     		"					<div class=\"carousel-item active\">\n" + 
     		"						<img class=\"img-fluid center-block\" id=\"carousel-image\" src=\"Actor1.jfif\" alt=\"Slide 1\">\n" + 
     		"						<div class=\"carousel-caption\">\n" + 
     		"							<strong><h3>Actor1</h3></strong>\n" + 
     		"						</div>\n" + 
     		"					</div>\n" + 
     		"\n" + 
     		"					<div class=\"carousel-item\">\n" + 
     		"						<img class=\"img-fluid center-block\" id=\"carousel-image\" src=\"Actor2.jfif\" alt=\"Slide 2\">\n" + 
     		"						<div class=\"carousel-caption\">\n" + 
     		"							<h3>Actor2</h3>\n" + 
     		"						</div>\n" + 
     		"					</div>\n" + 
     		"\n" + 
     		"					<div class=\"carousel-item\">\n" + 
     		"						<img class=\"img-fluid center-block\" id=\"carousel-image\" src=\"Actor3.jpg\" alt=\"Slide 3\">\n" + 
     		"						<div class=\"carousel-caption\">\n" + 
     		"							<h3>Actor3</h3>\n" + 
     		"						</div>\n" + 
     		"					</div>\n" + 
     		"				</div>\n" + 
     		"\n" + 
     		"				<a class=\"carousel-control-prev\" href=\"#mycarousel\" role=\"button\" data-slide=\"prev\" id=\"carousel-control\">\n" + 
     		"					<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n" + 
     		"					<span class=\"sr-only\">Previous</span>\n" + 
     		"				</a>\n" + 
     		"				<a class=\"carousel-control-next\" href=\"#mycarousel\" role=\"button\" data-slide=\"next\" id=\"carousel-control\">\n" + 
     		"					<span class=\"carousel-control-next-icon\" aria-hidden=\"true\" ></span>\n" + 
     		"					<span class=\"sr-only\">Next</span>\n" + 
     		"				</a>\n" + 
     		"			</div>\n" + 
     		"			<script type=\"text/javascript\">\n" + 
     		"				$('.carousel').carousel()\n" + 
     		"			</script>\n" + 
     		"		</div>\n" + 
     		"	</div>\n" + 
     		"	<div class=\" card-outline-primary mb-3\" style=\"border-color: gold\">\n" + 
     		"		<div class=\"card-block\">\n" + 
     		"			<div class=\"card card-outline-primary mb-3 text-center\">\n" + 
     		"				<div class=\"card-block\" id=\"review\">\n" + 
     		"					<div class=\"row\">\n" + 
     		"						<div class=\"col-lg-2\">\n" + 
     		"							<img class=\"img-responsive float-center\" src=\"Poster.jpg\" id=\"review-img\">\n" + 
     		"							<p>Reviewer</p>\n" + 
     		"						</div>\n" + 
     		"						<div class=\"col-lg-10 text-left\">\n" + 
     		"							<h3>Review Title</h3>\n" + 
     		"							<blockquote>blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah</blockquote>\n" + 
     		"						</div>\n" + 
     		"					</div>\n" + 
     		"				</div>\n" + 
     		"			</div>\n" + 
     		"			<div class=\"card card-outline-primary mb-3 text-center\">\n" + 
     		"				<div class=\"card-block\" id=\"review\">\n" + 
     		"					<div class=\"row\">\n" + 
     		"						<div class=\"col-lg-2\">\n" + 
     		"							<img class=\"img-responsive float-center\" src=\"Poster.jpg\" id=\"review-img\">\n" + 
     		"							<p>Reviewer</p>\n" + 
     		"						</div>\n" + 
     		"						<div class=\"col-lg-10 text-left\">\n" + 
     		"							<h3>Review Title</h3>\n" + 
     		"							<blockquote>blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah</blockquote>\n" + 
     		"						</div>\n" + 
     		"					</div>\n" + 
     		"				</div>\n" + 
     		"			</div>\n" + 
     		"		</div>\n" + 
     		"	</div>\n" + 
     		"\n" + 
     		"\n" + 
     		"</body>");
      
      out.println("<html>");
      out.println("<head>"); 
      out.println("<title></title>");
      out.println("<style> input { color: gold; }</style>");
      out.println("</head>");  
      out.println("<body style='color:gold'>");
      out.println("<div class=\"card card-outline-primary mb-3 text-center\">\r\n" + 
      		"				  <div class=\"card-block\" id=\"review\">");
      out.println("    <h1 >Submit Review</h1>");

      // 3. url rewriting (maintain state, share data)
      // uncomment these two statements and comment out step 1 to see how it works
//      out.println("    <a href=\"" + url + 
//        "?username=someone&emailaddr=someone@uva.edu&comment=let's see how url rewriting works\"" + ">send request</a>");
//      doPost(request, response);

//  don't do this, you are redirecting to yourself -- causing infinite loop      
//      response.sendRedirect("\"" + url + 
//          "?username=someone&emailaddr=someone@uva.edu&comment=let's see how url rewriting works\"");
                		    	
      
      // 1. form submission
      if (msg.length() > 0)
          out.println("<br/>" + "<span class='msg'>" + msg + "</span> <br/><br/>");           
	    	             
      out.println("<form action='" + url + "' method='post' >");
      out.println("      <label>Name: </label>");
      out.println("      <input type='text' id='user' name='username'/> <br/>");        
      out.println("      <label>Title: </label>");
      out.println("      <input type='text' id='email' name='emailaddr'  /> <br/>");
      out.println("      <span id='email-msg' class='msg'></span>");
      out.println("      <label>Review: </label>");
      out.println("      <textarea rows='5' cols='40' id='comment' name='comment'></textarea> <br/>");
      out.println("      <span id='comment-msg' class='msg'></span>");
      out.println("      <input type='submit' value='Submit comment' />");
      out.println("    </form>");
      out.println("  </div>");
      out.println("  </div>");
      out.println("</body>");
      out.println("</html>");
      
      String username = request.getParameter("username");
      String email = request.getParameter("emailaddr");
      String comment = request.getParameter("comment"); 
      
      
      if (username.length() > 0 && email.length() > 0 && comment.length() > 0)
      {    	 	 
         printReview(username, comment, email, out);
      }
      
      
      out.close();
      msg = "";
      
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) 
               throws ServletException, IOException 
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      // doPost() handles post request
      
      // access form data (using the input's name attribute)
      String username = request.getParameter("username");
      String email = request.getParameter("emailaddr");
      String comment = request.getParameter("comment"); 

      // 4. not call doGet here (we're now trying url rewriting which result in get request)
      //    in the doGet(), we call doPost()
      //    here (in doPost()), if we call doGet() -- we are circling
      // unncomment these and comment out step 2 to see how it works     
//      if (username != null && email != null && comment != null)   // notice we check for null here
//         printConfirmation(username, comment, email, out);
     
      
      // 2. handle form submission from step 1
      if (username.length() > 0 && email.length() > 0 && comment.length() > 0)
      {    	 	 
         doGet(request, response);       // submit more comment?
         printReview(username, comment, email, out);
      }
      else
      {
         msg = "Please enter your information";
         doGet(request, response);
      }
      
      out.close();
   }


//  Instead of mixing html in java (refer to out.println() in doGet()), 
//  some developers prefer to separate them as much as possible. 
//  You may comment the out.println() in doGet() and have doGet() call other java functions
//  to do create the html document (for example, call printHTML() below)
//    
//   private void printHTML(PrintWriter out)
//   {
//      String str_head = 
//         "<html>" +
//         "<head>" + 
//         "  <title>Servlet example</title>" +
//         "  <link rel=stylesheet href='styles/example-style.css' type='text/css'>" +
//         "</head>"; 
//      
//      String str_body = 
//         "<body>" +
//         "  <div>" +
//         "    <h1>Servlet example</h1>";
//	    	      
//         if (msg.length() > 0)
//            str_body = str_body + "<br/>" + "<span class='msg'>" + msg + "</span> <br/><br/>";           
//	    	      
//         str_body += 
//            "    <form action='" + url + "' method='post' onsubmit='return (validateInput())' >" +
//            "      <label>Name: </label>" +
//            "      <input type='text' id='user' name='username' autofocus /> <br/>" +         
//            "      <label>Email: </label>" +
//            "      <input type='text' id='email' name='emailaddr'  /> <br/>" +
//            "      <label>Comment: </label>" +
//            "      <textarea rows='5' cols='40' id='comment' name='comment'></textarea> <br/>" +
//            "      <input type='submit' value='Submit comment' />" +
//            "    </form>" +
//            "  </div>" +
//            "</body>" + 
//            "</html>";     
//         
//      String str_html = str_head + "<br/>" + str_body;
//      out.println(str_html);      
//   }
//   
   
   private void printReview(String username, String review, String title, PrintWriter out)
   {
	   
      out.println("<div class=\"card card-outline-primary mb-3 text-center\">");
      out.println("<div class=\"card-block\" id=\"review\">");
      out.println("<div class=\"row\">");
      out.println("<div class=\"col-lg-2\">");
      out.println("<img class=\"img-responsive float-center\" src=\"Poster.jpg\" id=\"review-img\">");
      out.println("<p>" + username + "</p>");
      out.println("</div>");
      out.println("<div class=\"col-lg-10 text-left\">");
      out.println("<h3>" + title + "</h3>");
      out.println("<blockquote>"+ review + "</blockquote>");
      out.println("</div>");
      out.println("</div>");
      out.println("</div>");
      out.println("</div>");
   }

}



