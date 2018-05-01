<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>Results</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

   <!-- 1. JSP directives .. info sent to the container  -->
   <!-- page directive -->
   <%@ page language="java" %>
   <%@ page import="java.util.Date"%>
   
      
   <!-- include directive (static include) -->   
   <%@ include file="static-include-example.html" %>   
   
   <br/><br/>
   
   <!-- include directive (dynamic include) -->
   <%@ include file="date.jsp" %>


   <br/>
   <hr/>
   <br/>   


   <!-- 2. JSP scripts -->
   <!--    there are 3 kinds of scripting elements -->
   <!--    reminder: it's Java, we need to follow Java syntax for declaration and scriptlets -->
   <!-- 2.1 declaration .. declare variables or functions -->
   <%! int count = 0; %>


   <!-- 2.2 scriptlet .. block of Java code
        this is where we can access servlet implicit objects (must use these names/spelling)
        - request (HttpServletRequest object)
        - response (HttpServletResponse object)
        - out (PrintWriter, for producing HTML document)  
   -->
   <%
      for (int i = 0; i < 10; i++)
      {
         count = count+1;
   %>
         <br />
         <!-- 2.3 expression .. evaluated and replaced with string value -->
         The counter value is: <%= count %>
   <% } %>
   <br/>
      
   <!-- more scripting examples -->
   <%! String welcome_msg = "Hello World !!"; %>
   <br/>
   I'm am saying <%= welcome_msg %>
   <br/>    
   <%  
      out.println(" ---> Request method : " + request.getMethod() );
   %>
   

   <br/>
   <hr/>
   <br/>      
   
   
   <!-- 3. JSP actions .. tags to change behavior of web app -->
   <!--    dynamically create content
           has the form of a markup element
             - opening tag and possibly including attributes
             - action body (content)
             - closing tag
           represent program code that gernerate markup
        **no space in the JSP action tag name               
   -->
   
   
   <!-- forward action without parameter passing -->   
   <!-- JSP forward action tag
        Simply forward the control of execution to another web component, no return, 
        browser isn't aware the control has been transferred to somewhere else.
        The target component must be on the same server 
   -->     
   <!-- Important note: 
        Forward control connection requires that both target component and current component 
        must be on the same server. Therefore, if the target component is on different server, 
        use redirect control connection instead (refer to HttpServletResponse.sendRedirect()).
        - try forwarding from your jsp to http://www.cs.virginia.edu/ 
          and observe the error message.   
             <%-- <jsp:forward page="http://www.cs.virginia.edu/" /> --%>     
        - change it to   
             <%-- <%
                response.sendRedirect("http://www.cs.virginia.edu/");
             %> --%>     
        (note: <%-- ..... --%> to comment JSP scriptlets)  -->                  
    
   <%-- 
   <jsp:forward page="confirm.jsp"  /> 
   --%>
     
   
   
   <!-- forward action with parameter passing -->     
   <!-- information can be passed to the (forwarded) target component -->       
   <%-- 
   <jsp:forward page="confirm.jsp" >
      <jsp:param name="msg" value="forward with param from jsp-elements.jsp to confirm.jsp" />
   </jsp:forward> 
   --%>   

   <!-- scriptlet to redirect without parameter passing, 
        use sendRedirect() of the servlet response object -->
   <%-- 
   <% response.sendRedirect("confirm.jsp"); %> 
   --%>

   <!-- scriptlet to redirect with parameter passing, 
        use sendRedirect() of the servlet response object -->
   <%--  
   <%
      response.sendRedirect("confirm.jsp?msg=redirect with param from jsp-elements.jsp to confirm.jsp");
   %> 
   --%>
      
      
      
      
   <!-- include action (dynamic) without parameter passing -->
   <!-- imagine including header (and navigation) to the page -->
   <jsp:include page="header.jsp" />
      
   
   
   <br/><br/>
   <div align="middle">
   <h1>Title of the Page</h1>
   <p>Content of your page</p>
   </div>
   <br/><br/>

   
   
   <!-- include action (dynamic) with parameter passing -->
   <jsp:include page="footer.jsp">
      <jsp:param name="msg" value="passing parameter with jsp include action tag, from jsp-elements.jsp to footer.jsp" />
   </jsp:include> 
   
   
   
   <br/><br/>    
   <!-- static include action with parameter passing -->   
   <jsp:include page="copyright.html" />
   
   
   
   
<!-- (dynamic) include directive vs. (dynamic) include action
        - both produce the same html output
    include directive
        - include content at translation time (when converting jsp to java)
        - thus, load the content once
        - if the included file is changed, the change does not reflect the main jsp page
          (because the included jsp is already translated, loaded, and put into the main jsp)        
    include action   
        - include content at runtime
        - thus, load the content everytime the main jsp is run
        - if the included file is changed, the change reflects the main jsp page
          (because the included get loaded everyime the main jsp is run)
   -->
   
<!-- observe page source, notice that we won't see jsp or java code -->

</body>
</html>