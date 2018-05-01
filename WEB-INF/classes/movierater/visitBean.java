package movierater;

// all bean must be in package

public class visitBean 
{
   private int counter;    // property of the bean
   private int step;       // property of the bean
   
   // default constuctor initializes counter to 0 and step to 1
   public visitBean()
   {    	   	 
      counter = 0;
      step = 1;
   }   
   
   public int getCounter() 
   {
      counter += step;
      return counter;
   }

   public void setCounter()
   {
      this.counter = 0; 
   }
   
   
/*
 * let's say, we want to set counter in jsp
 *   <jsp:setProperty name="pageCounter" property="counter" value="99" />
 * thus, need the setter that takes int 
 */  
   public void setCounter(int c)
   {
      this.counter = c;
   }
   

}