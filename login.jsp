
<!doctype html>
<html>
<head>
	<meta author="Sallie : sjl5bz">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>The Movie Rater - Login</title>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@ page language="java" %>
	<%@ page import="movierater.*" %>
	<!-- <nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="row">
				<div class="navbar-header">
					<div class="login-navbar-brand">The Movie Rater</div>
				</div>
			</div>
		</div>
	</nav> -->
  <nav class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="#"><strong>The Movie Rater</strong></a>
	</nav>
	<div class="wrapper"> 
		<form class="form-signin" method="post" action="homepage.jsp">
			<h2 class="form-signin-heading">Login </h2>
			<input type="text" name="email" class="form-control" placeholder="Email Address" id="email">
			<p id="para1">Invalid email address</p>
			<!-- <span class="error"><?php echo $emailErr;?></span> -->
			<input type="password" name="password" class="form-control" placeholder="Password" id="password">
			<p id="passwordReq">Password required</p>
			<!-- <span class="error"><?php echo $passwordErr;?></span> -->
			<label class="checkbox">
				<input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validate()" id="loginbutton">Login</button>  
			<br/>
			<a id="createAccount" href="signup.php">Create account</a>
		</form>
		<jsp:useBean id="username" class="movierater.username" scope="session"></jsp:useBean>
		<!-- scriptlet -->
		<%
			String silo = null;
			String objSilo1 = username.getEmail(); // Note change
            if(username.getEmail() != null) {
            response.sendRedirect("/movierater/homepage.jsp");
        	}
		 %>
	</div>
	<script>
		//points cursor to email input when page is loaded
		document.addEventListener('DOMContentLoaded', function() {
			document.getElementById("email").focus();
		});

		//performs client-side input validation
		function validate() {
			bool = true;
			//if email address is not valid
			if(document.getElementById("email").value.indexOf("@") < 0 || document.getElementById("email").value.indexOf(".") < 0) {
				document.getElementById("para1").style.display = "block";
				bool = false;
			}
			//if password input is empty
			if(document.getElementById("password").value === "") {
				document.getElementById("passwordReq").style.display = "block";
				bool = false;
			} else {
				document.getElementById("passwordReq").style.display = "none";
			}
			//if email or password input is empty
			if(document.getElementById("email").value === "" || document.getElementById("password").value === "") {
				bool = false;
			} 
			return bool;

		}
	</script>
</body>
</html>