package PRGCREEK;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author pune7087
 */
public class LargestNumber {
    
    public static void main(String args[])
    {
        int a[]={3, 30, 34, 5, 9};
        String[] numar= new String[a.length];
        
        for(int i=0; i < a.length;i++)
        {
            numar[i]= String.valueOf(a[i]);
        }
        
        Arrays.sort(numar, new Comparator<String>(){
            public int compare(String a, String b)
            {
                return (b+a).compareTo(a+b); // as we need in descending from 9-5-34...
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s : numar)
        {
            sb.append(s);
        }
        
        System.out.println(sb.toString());
        
    }
    
}
