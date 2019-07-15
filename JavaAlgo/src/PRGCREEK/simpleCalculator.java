package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.Stack;

public class simpleCalculator {
    
    public static void main(String args[])
    {
        Stack<Character> stack = new Stack();
        
        String str="(1-(4-5))";
        
        for(int i=0; i<str.length(); i++ )
            stack.push(str.charAt(i));
        int result=0;

        while(!stack.isEmpty())
        {
            Character c= stack.pop();
            
            if(c.toString().matches("[0-9]"))
            {
               result=Character.getNumericValue(c);
            }
            else if(c == '+')
            {
            
                int temp=Character.getNumericValue(stack.pop());
                
                if(stack.peek()=='-')
                {
                    if(temp>result)
                        result=temp-result;
                    else
                    {
                       stack.pop();
                       stack.push('+');
                       result=result-temp;
                    }
                }
                else
                    result=result+temp;
            }
            else if(c == '-')
            {
                int temp=Character.getNumericValue(stack.pop());
                
                if(stack.peek()=='-')
                     result=temp+result;
                else
                    result=temp-result;
            }
            
            else if(c=='(')
            {
                stack.push((char)result);
            }
            
        }
        
        System.out.print(result);
        
        
    }
    
}
