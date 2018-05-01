
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
    <%@ page language="java" %>
    <%@ page import="movierater.*" %>
    <%@ include file="header.html"%>    <!-- using directive to include navbar static-->

<div class="container" style="margin-top: 10%;">
    <jsp:useBean id="username" class="movierater.username" scope="session"></jsp:useBean>

    <!-- scriplet that redirects to login if email is null i.e. you didn't login. Also only sets variable if POST -->
    <%
        if("POST".equalsIgnoreCase(request.getMethod())) {
        String email = (String)request.getSession().getAttribute("email"); //retrieves session object from servlet
            username.setEmail(email);
            String val = request.getParameter("email");
        }
        if(username.getEmail() == null) {
            response.sendRedirect("/movierater/login");
        }
    %>
    <!-- getProperty -->
    <h1>Welcome <font color="green"><i><jsp:getProperty name="username" property="email" /></i></font></h1>
        
</div>
    <!-- jsp include -->
    <jsp:include page="results.jsp"/>
<script>
    function validate() {
        if(document.getElementById("search").value === "") {
            return false;
        } 
    }
</script>
    
</body>
</html>