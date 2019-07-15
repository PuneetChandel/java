package PRGCREEK;

import java.util.HashMap;
/**
 *
 * @author pune7087
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * eggxb and abbyy are not
 */
public class IsoMorphicString {
   
     public static void main(String args[])
     {
         System.out.print(" Check :: " + checkIsoMorphic( "eggxg", "addyt"));
     }
    public static boolean checkIsoMorphic(String s1,String s2 )
    {

        
        HashMap<Character, Character> map1= new HashMap<>();
        HashMap<Character, Character> map2= new HashMap<>();
    
        if(s1.length() != s2.length())
            return false;
        
        for(int i =0; i<s1.length(); i++)
        {
            char x = s1.charAt(i);
            char y = s2.charAt(i);
            
            if(map1.containsKey(x))
            {
                if(y!=map1.get(x))
                    return false;
                
            }
            if(map2.containsKey(y))
            {
                if(x!=map2.get(y))
                    return false;
                
            }
                  
            
            map1.put(x, y);
            map2.put(y, x);
        }
        return true;
    
    }
    
}
