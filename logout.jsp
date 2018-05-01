<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<%
		session.removeAttribute("username");
		response.sendRedirect("/movierater/login.jsp");
	%>
</body>
</html>