<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta author="Rice Tyler : rht6nf">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    
    
	<style> input { color: gold; }
		body {
			color: gold;
		}
	</style>
</head>
<%@ page import="movierater.*" %>
<jsp:useBean id='ratings' scope='session' class='movierater.Ratings' />
<jsp:useBean id='reviews' scope='session' class='movierater.Reviews' />


<body>
	<nav class="navbar navbar-dark" id="bootstrap" >
		<div class="container-fluid" style="background-color: black">
			<div class="row">
				<div class="navbar-header">
					<div class="navbar-brand"> <a href="homepage.html" style="color:gold; text-decoration:none;">The Movie Rater</a></div>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="homepage.html">Home</a></li>
					<li><a href="Template.html">Search</a></li>
				</ul>
			</div>
		</div>
	</nav>
		<div class="card card-outline-primary mb-3 text-center">
		  <div class="card-block">
		  	<div class="row">
			    <div class="col-lg-4">
			    	<img class="img-responsive rounded float-center" src="images/Poster.jpg" style="width: 75%">
			    </div>
			    <div class="col-lg-8 text-left">
			    	<h2>MOVIE TITLE GOES HERE</h2>
			    	<div id="rateYo"></div>
			    	<p><strong> DIRECTOR: </strong><a href="#"> BIG SHOT HOLLYWOODMAN</a></p>
			    	<p><strong> WRITER(S): </strong> FANSTASTIC WRITER</p>
			    	<p><strong>GENRE:</strong> MYSTERY</p>
			    	<p><strong> RELEASE DATE: </strong> 07/23/1996 </p>
			    	<p><strong> PlLOT SUMMARY: </strong></p>
			    	<blockquote>blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah</blockquote>
			    </div>
			</div>
		  </div>
		</div>
		<form action="">
    		<label>Rating: </label>
          		<input type='text' id='rating' name='rating'/> <br/>
          		<input type='submit' value='Submit Rating' />
    	</form>
		<div class="card card-outline-primary mb-3 text-center">
			<div class="card-block">
				<div id="mycarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
					    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
					    <li data-target="#mycarousel" data-slide-to="1"></li>
					    <li data-target="#mycarousel" data-slide-to="2"></li>
					 </ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="img-fluid center-block" id="carousel-image" src="images/Actor1.jfif" alt="Slide 1">
							<div class="carousel-caption">
								<strong><h3>Actor1</h3></strong>
							</div>
						</div>

						<div class="carousel-item">
							<img class="img-fluid center-block" id="carousel-image" src="images/Actor2.jfif" alt="Slide 2">
							<div class="carousel-caption">
								<h3>Actor2</h3>
							</div>
						</div>

						<div class="carousel-item">
							<img class="img-fluid center-block" id="carousel-image" src="images/Actor3.jpg" alt="Slide 3">
							<div class="carousel-caption">
								<h3>Actor3</h3>
							</div>
						</div>
					</div>

					<a class="carousel-control-prev" href="#mycarousel" role="button" data-slide="prev" id="carousel-control">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					 </a>
					 <a class="carousel-control-next" href="#mycarousel" role="button" data-slide="next" id="carousel-control">
					    <span class="carousel-control-next-icon" aria-hidden="true" ></span>
					    <span class="sr-only">Next</span>
					 </a>
				</div>
				
			</div>
	    </div>
	    <%Reviews r = (Reviews) session.getAttribute("reviews");
	     for(int x = 0; x<r.getRatings().size();x++){ %>
	    	<div class=\"card card-outline-primary mb-3 text-center\">
		 		<div class=\"card-block\" id=\"review\">
		  			<div class=\"row\">
		    			<div class=\"col-lg-2\">
		    				<img class=\"img-responsive float-left\" src=\"images/Poster.jpg\" id=\"review-img\">
		    				<p>" + username + "</p>
		    			</div>
		    		<div class=\"col-lg-10 text-left\">
		    		<h3>" + title + "</h3>
		    		<blockquote>"+ review + "</blockquote>
		    	</div>
		    </div>
		<%} %>
	    <div class="card card-outline-primary mb-3 text-center">
			<div class="card-block">
			    <form action='Review.jsp' method='post' >
		            <label>Name: </label>
		            <input type='text' id='user' name='username'/> <br/>        
		            <label>Title: </label>
		            <input type='text' id='email' name='emailaddr'  /> <br/>
		            <span id='email-msg' class='msg'></span>
		            <label>Review: </label>
		            <textarea rows='5' cols='40' id='comment' name='comment'></textarea> <br/>
		            <span id='comment-msg' class='msg'></span>
		            <input type='submit' value='Submit Review' />
		         </form>
	         </div>
         </div>


</body>

<script src="jquery.js"></script>
<script src="jquery.rateyo.js"></script>
<script type="text/javascript">
	$(function () {
		 var avg = '${ratings.avgRating}';
	  $("#rateYo").rateYo({
	    rating: avg,
	    readOnly: true,
	    starWidth: "40px",
	    normalFill: "#A0A0A0",
	    ratedFill: "gold"
	  });
	 
	});
</script>
<script type="text/javascript">
	$('.carousel').carousel()
</script>
</html>
