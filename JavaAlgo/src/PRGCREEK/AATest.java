package PRGCREEK;

/**
 *
 * @author pune7087
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.*;

public class AATest {
    
  public static void main(String args[])
  {
        
      //mostCommonWord("L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'",
      //        new String[]{"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"});
        
     // System.out.print(compress(new char[]{'a','a','b','b','c','c','c'}));
      
      System.out.println( "  " + 10%2);
      
      System.out.println( "  " +  4 % 999999998);
      
      int a[] = new int[]{1,2,3,4};
      
      System.out.println(Arrays.toString(a));

      String version1 = "7.5.2.4";
         
      String[] s1= version1.split("\\.");
         
         
      compareVersion("1.0.1","1");
  }
  
    public static int compareVersion(String version1, String version2) {
        
            String[] s1= version1.split("\\.");
            String[] s2= version2.split("\\.");
            
            int i=0; int j=0;
        
            while(i < s1.length && j<s2.length && s1[i].equals(s2[j]))
            {
                j++;i++;
            }

            if(i==s1.length && j==s2.length)
                return 0;
            else if(i==s1.length )
            {
                if(s2[j].equals("0"))
                    return 0;
                else
                    return -1;
            }
            else if(j==s2.length )
            {
                if(s1[i].equals("0"))
                    return 0;
                else
                    return 1;
            }
            else if(Integer.valueOf(s1[i]) == Integer.valueOf(s2[j]))
                return 0;
            else if(Integer.valueOf(s1[i]) > Integer.valueOf(s2[j]))
                return 1;
            else if(Integer.valueOf(s1[i]) < Integer.valueOf(s2[j]))
                return -1;


        return 0;
        }
    
  
  public static int compress(char[] chars) {
     
        String s = new String(chars);
        StringBuilder sb = new StringBuilder();
        
        int i=0; 
        while(i<s.length())
        {
            int j=i+1;
            int count=1;
            while(j<s.length() && s.charAt(i)==s.charAt(j))
            {
                count++;
                j++;
            }
            
            if(count>1)
             sb.append(Character.toString(s.charAt(i))).append(String.valueOf(count));
            else
              sb.append(Character.toString(s.charAt(i)));  
            i=j;
        }
        
        chars = (sb.toString()).toCharArray();
        return chars.length;
        
    }
  
     
     public static String mostCommonWord(String paragraph, String[] banned) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        HashSet<String> ban = new HashSet(Arrays.asList(banned));
     
        
         String[] strs = paragraph.toLowerCase().split("[ !?',;.]+");
        
        for(String key : strs)
        {
            
            if(map.containsKey(key))
            {
                map.put(key, map.get(key)+1);
            }
            else
            {
                if(!ban.contains(key))
                   map.put(key,1);
            }
        }
        
        String result="";
        int max =0;
                                             
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue()>max)
            {
                max=entry.getValue();
                result=entry.getKey();
            }                                    
      }
       return result;        
        
    }

}
