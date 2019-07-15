package PRGCREEK;

import java.util.Stack;
/**
 *
 * @author pune7087
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  * 
 */
public class EvaluateFormula {
   
    public static void main(String args[])
    {
        String[] str={"2", "5", "+", "5", "-", "10","*"};
        
        Stack<String> st = new Stack<>();    
        int arg1=0;
        int arg2=0;
        String opr="+-/*";
        String val="";
        for(String a : str)
        {
            val=a;
            if(opr.contains(a))
            {
                  arg1=Integer.valueOf(st.pop());
                  arg2=Integer.valueOf(st.pop());
                  
               if(a=="+")
                         val=String.valueOf(arg2+arg1);
               else if(a=="-")
                         val=String.valueOf(arg2-arg1);
                   
               else if(a=="*")
                         val=String.valueOf(arg2*arg1);
               else if(a=="/")
                         val=String.valueOf(arg2/arg1);
                   
            }
            
            st.push(val);
        }
        
        System.out.println(st.pop());
        
    }
    
}
