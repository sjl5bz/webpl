
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>The Movie Rater - Home Page</title>
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css"> -->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<!-- <nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="row">
				<div class="navbar-header">
					<div class="navbar-brand"> <a href="homepage.php" style="color:gold; text-decoration:none;">The Movie Rater</a></div>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="homepage.php">Home</a></li>
					<li><a href="Template.html">Search</a></li>
				</ul>
			</div>
		</div>
	</nav> -->

<nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-default">
        <a class="navbar-brand" href="#"><strong>The Movie Rater</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Browse</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Reviews</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto mr-5">
              <li class="nav-item">
                <form method="post" action="http://localhost:8080/movierater/homepage">
                  <button type="submit" name="submit_param" class="btn btn-link">
                    Logout
                  </button>
                </form>
              </li>
            </ul>
           <!--  <form class="form-inline mr-5">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
            </form>  -->
        </div>
    </nav>
<div class="container" style="margin-top: 20%;">
    <h1>Welcome!!!</h1>
        <form action="results.html" method="get">
        <div class="col-sm-6 col-sm-offset-3">
            <div id="imaginary_container"> 
                <div class="input-group stylish-input-group">
                    <input type="text" class="form-control" name=search id=search placeholder="Search" >
                    <span class="input-group-addon">
                        <button type="submit" onclick="return validate()">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>  
                    </span>
                </div>
            </div>
        </div>
        </form>
</div>

<script>
    function validate() {
        if(document.getElementById("search").value === "") {
            return false;
        } 
    }
</script>
    
</body>
</html>