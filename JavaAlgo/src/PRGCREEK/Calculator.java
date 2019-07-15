package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.*;
public class Calculator {
    
    public static void main(String args[])
    {
        System.out.print(calculate(" (1+2+2) "));
    }
    
      public static int calculate(String s) {
        
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!=' ')
            stack.push(String.valueOf(s.charAt(i)));
        }
        
        int result=0;
        
        Stack<String> tempstack = new Stack<>();
        
        
        while(!stack.isEmpty())
        {  
         
            String c = stack.pop();
            
            if(c.equals(")"))
            {
                while(stack.peek()!="(")
                   tempstack.push(stack.pop()); 
            }
            else if(c.equals("("))
            {
                int tempsum=0;
                while(!tempstack.isEmpty())
                {
                    String t = tempstack.pop();
                    
              
                    if(t.equals("+")){
                        int val = Integer.valueOf(tempstack.pop());
                        
                        if(tempstack.isEmpty())
                            tempsum= tempsum + val;
                        else if(!tempstack.isEmpty() && !tempstack.peek().equals("-"))
                           tempsum= tempsum + val;
                        else
                        {
                            tempstack.pop();
                            tempsum = tempsum - val ; 
                        }
                    }
                    else if(t.equals("-"))
                        tempsum= tempsum - Integer.valueOf(tempstack.pop());
                    else
                        tempsum=tempsum+Integer.valueOf(t);
                    
                }
                
                stack.push(String.valueOf(tempsum));
                
            }
            else
            {
                //" 2-1 + 2 "
                  if(c.equals("+")){
                        int val = Integer.valueOf(stack.pop());
                        
                        if(stack.isEmpty())
                            result= result + val;
                        else if(!stack.isEmpty() && !stack.peek().equals("-"))
                             result= result + val;
                        else
                        {
                            stack.pop();
                            result = result - val ; 
                        }
                              
                    }
                  else  if(c.equals("-"))
                        result= result - Integer.valueOf(stack.pop());
                  
                  else
                        result=result+Integer.valueOf(c);
                    
            }
        }
        return result;
    }
}
