package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    
    public static void main(String args[])
    {
        int a[]= {-1,0,1,2,-1,-4};
        List<List<Integer>> result=get3sum(a,0);
        
        for(List l : result)
        {
            for(Object x : l)
            {
                System.out.print((int)x + " ");
            }
            
             System.out.println( " ");
        }
    }
    
    public static List<List<Integer>> get3sum(int []a, int sum)
    {
        Arrays.sort(a);
        
        List<List<Integer>> result= new ArrayList();
        
        int end = 0, start=0;   
        
        for(int i=0; i< a.length; i++)
        {
            start = i+1;
            end = a.length-1;
            
            
            // skip duplicate from start as the triplet should be unique
            // // This is to skip the start if its same to already checked one
            if(i> 0 && a[i]==a[i-1])
                continue;
              
            while(start<end)
            {
                // skip duplicate from end as the triplet should be unique
                // This is to skip the end if its same to already checked one
                if(end<a.length-1 && a[end]== a[end+1])
                {   
                    end--;
                    continue;
                }
                
                
                if(a[i]+a[start]+ a[end]<sum) // move start if sum is less
                    start++;
                else if(a[i]+a[start]+ a[end]>sum) // move end if sum is more
                    end--;
                else
                {   
                    List<Integer> ar = new ArrayList();
                    ar.add(a[i]);
                    ar.add(a[start]);
                    ar.add(a[end]);
                    result.add(ar);
                    start++;
                    end--;
                }   
            }
        }
        
        return result;
    }
}
