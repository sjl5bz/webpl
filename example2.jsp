 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>useBean example</title>
</head>
<body>    

  <!-- use JSP page directive to set necessary information and import necessary bean as needed -->

   <form method="post" action="jspbean-example.jsp">
      <table>
        <tr>
          <td>Please enter your name: </td> 
          <td><input type="text" name="name" ></td>
        </tr>
        <tr>
          <td>What is your email address ?</td>
          <td><input type="text" name="email" /></td>
        </tr>
        <tr>
          <td colspan="2" align="right">
             <input type="submit" name="btn" value="Submit information" />
          </td>
        </tr>
      </table>
   </form>
  
  <hr />

  <!-- create an instance of a bean and set its scope -->
  <jsp:useBean id="myFriends" class="examples.beans.friendsBean" scope="session">
     <!-- equivalent Java code 
          examples.beans.friendsBean myFriends = new friendsBean();  -->
  </jsp:useBean>
  
<%-- we can set property inside or outside the <jsp:useBean> action tag --%>    
  <jsp:setProperty name="myFriends" property="name" value='<%= request.getParameter("name") %>' />
  <jsp:setProperty name="myFriends" property="email" value='<%= request.getParameter("email") %>' /> 

 
  <!-- Use 4 instances of the visitBean, notice the difference of shared data
       open several tabs, windows of the same web browser, 
       open a different web browser (or simulated browser from eclipse) 
  -->
  <jsp:useBean id="pageCounter" class="examples.beans.visitBean" scope="page" />
  <jsp:useBean id="requestCounter" class="examples.beans.visitBean" scope="request" />  
  <!-- this jsp itself won't see the difference between page and request scopes 
       because there is only one non-bean component involved in the request.
       We need to have more than one non-bean component in the request to see the scope impact        
       -->
  
  <jsp:useBean id="sessionCounter" class="examples.beans.visitBean" scope="session" />
  <jsp:useBean id="applicationCounter" class="examples.beans.visitBean" scope="application" />
    
    
  <p>  
    Hello,    
    <font color="green"><i><jsp:getProperty name="myFriends" property="name"  /></i></font>
    <!-- equivalent Java code
             myFriends.getName(); -->
  </p>
      
  <p>       
    Your email address is 
    <font color="green"><i><jsp:getProperty name="myFriends" property="email" /></i></font>
    <!-- equivalent Java code
             myFriends.getEmail(); -->    
  </p>


 
 <%-- in case we want to set a counter to something else rather than the initialization in the bean's constructor
  <jsp:setProperty name="pageCounter" property="counter" value="99" />   
    equivalent to     pageCounter.setCounter(99);
 --%>

  <p>
    This page has been visited (page scope)
    <font color="green"><i>
      <jsp:getProperty name="pageCounter" property="counter" />
    </i></font>
    times   
  </p>	
  
  <p>
    This page has been visited (request scope)
    <font color="green"><i><jsp:getProperty name="requestCounter" property="counter" /></i></font>
    times   
  </p>	
 
  <p>
    This page has been visited (session scope)
    <font color="green"><i><jsp:getProperty name="sessionCounter" property="counter" /></i></font>
    times   
  </p>	
  
  <p>
    This page has been visited (application scope)
    <font color="green"><i><jsp:getProperty name="applicationCounter" property="counter" /></i></font>
    times   
  </p>	

  
  <hr/>
  <br/>
  To demonstrate the request scope: <br/>
  <!-- To demonstrate the request scope, 
       we need multiple non-bean components interacting with each other within the same request.
       Let's say, jspbean-example1.jsp includes jspbean-example2.jsp.
       Now, we have 2 non-bean components in the same request. 
   -->  
  <jsp:include page="jspbean-example2.jsp"></jsp:include>
  
  <!-- Alternatively, we can have a component forward a request to another component.
       As a result, there are multiple components involved in the same request. 
       Let's say, jspbean-example1.jsp forwards to jspbean-example2.jsp.
       Now, we have 2 non-bean components in the same request. 
       
       Uncomment the forward action tag below and observe the request counter 
       on jspbean-example2.jsp (targeted / forwarded component) 
   -->
  <%-- <jsp:forward page="jspbean-example2.jsp"></jsp:forward> --%>
  
  

</body>
</html>

 