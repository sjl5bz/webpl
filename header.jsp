<%! 
  // use JSP declaration to keep track visitors 
  
  int visitCount = 0;
  void addCount() 
  {
     visitCount++;
  }
%>
<% addCount(); %>


This page has been visited <%= visitCount %> times.
<p>(imagine putting some menu / navigation system and possibly search facility)</p>
