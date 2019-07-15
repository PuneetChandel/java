package morealgo;
import java.util.ArrayList;
/**
 *
 * @author pune7087
 */
// permutaions of a string with unique chars
public class permutationsOfStringUniqueChar {
    
    public static void main(String args[])
    {
        String s = "aab";
        
        ArrayList<String> perm = getPerm(s);
        
        for(String s1 : perm)
            System.out.println(s1);
        
        
    }
        

    public static ArrayList<String> getPerm(String s)
    {
        ArrayList<String> perm = new ArrayList<String>();
        if(s==null)
            return null;
        
        if(s.length()==0)
        {
            perm.add("");
            return perm;
        }
        
        String prev = s.substring(1);
        ArrayList<String> prev_perm = getPerm(prev);
        
        char curr = s.charAt(0);
        
        /// Add this first char to all previous permutation at different index
        /// for a3a2a1
        // calculate for a2a1 and then add a3 at all places
        
        for(String prev_word : prev_perm)
        {
            for(int i=0;i<=prev_word.length();i++)
            {
                String first=prev_word.substring(0,i);
                String second = prev_word.substring(i,prev_word.length());
                String res = first + curr + second;
                
                perm.add(res);
                //String res = 
            }
        }
        
        return perm;
            
    }
}
