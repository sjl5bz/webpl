package movierater;

//all beans must be in package

public class username 
{
   private String email;
   private String query;
 
   public username()
   {    	   
   }

   // property "email"
   public String getEmail()
   {
      return email;
   }
 
   public void setEmail(String em)
   {
      this.email = em;
   }

   public String getQuery()
   {
      return query;
   }
 
   public void setQuery(String qu)
   {
      this.query = qu;
   }
}