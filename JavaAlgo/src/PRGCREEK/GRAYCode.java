package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.*;
public class GRAYCode {
    
    public static void main(String args[])
    {
        
         int count = (int)Math.pow(2,3);
        List<Integer> res = new ArrayList<>();
            for(int i = 0; i < count; i++){
                System.out.print(i + ">> 1 = " + (i >> 1));
                System.out.println("");
                //res.add((i) ^ (i >> 1));
                System.out.print(i+ " ^ " + i +">> 1 : " + ((i) ^ (i >> 1)));
                System.out.println("");
                        
            }
          
            
    
    }
    
}
