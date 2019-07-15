package BACKTRACK;

/**
 *
 * @author pune7087
 */
import java.util.HashSet;

public class AllPermutaionsOfString {
    
    static HashSet<String> result = new HashSet();
      
    public static void main(String args[])
    {
      String str= "abc";
      permute(str);
      System.out.println(result);
      
    }
    
    public static void permute(String str)
    { 
      permuteUtil(str,0);
    }

    public static void permuteUtil(String str, int idx )
    {
        
       if(idx==str.length()-1)
            result.add(str);
        else
        {
          for(int i=idx; i<=str.length()-1; i++)
          {
            str=swap(str,idx,i);
            permuteUtil(str,idx+1);
            //str=swap(str,l,j); // if we do in place 
           }
        }
    }
    
    public static String swap(String str , int i, int j)
    {
        char[] c = str.toCharArray();
        char temp= c[i];
        c[i]= c[j];
        c[j]= temp;
        
        return new String(c); 
    }
    
}
