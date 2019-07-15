package BACKTRACK;

/**
 *
 * @author pune7087
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParanthesis {
    

    
    public boolean isValid(String str)
    {
        int count =0;
        
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='(')
                count++;
           
            if(str.charAt(i)==')')
                count--;
            
            if(count<0)
                return false;
          }
        
        return count==0?true:false;
    }
}

