<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
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
	<jsp:useBean id="username" class="movierater.username" scope="session"></jsp:useBean>
	<%@ include file="header.html"%>  
	<%
        if("POST".equalsIgnoreCase(request.getMethod())) {
            out.println("form was submitted");
            username.setEmail(request.getParameter("email"));
            String val = request.getParameter("email");
            out.println(username.getEmail());
        }
        if(username.getEmail() == null) {
            response.sendRedirect("/movierater/login.jsp");
        }
    %>

   <ul class="list-group" style="margin: 100px;">
    <% for (int i = 0; i < 10; i++) { %>
       <a href="#" class="list-group-item">
		<div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">hi</h5>
    </div>
       </a>
    <% } %>
    </ul>
</body>
</html>