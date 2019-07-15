package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.Stack;
import java.util.HashMap;

public class ValidPaarnthesis {
    
      public static void main(String args[])
    {
       
        Stack<Character> st = new Stack();
        
        String paran = "[({}})]";
        
        HashMap<Character,Character> mp = new HashMap();
        mp.put('(', ')');
        mp.put('{', '}');
        mp.put('[', ']');
        
        for(int i =0; i<paran.length();i++)
        {
            if(mp.containsKey(paran.charAt(i)))
                st.push(paran.charAt(i));
            
            if(mp.containsValue(paran.charAt(i)))
            {
                char c = st.pop();
                if(mp.get(c)!=paran.charAt(i))
                {
                    System.out.println("Invalid" );
                    break;
                }
            }
                    
                
        }
        
        
        System.out.println("Valid " );
        
        
        
    }
    
}
