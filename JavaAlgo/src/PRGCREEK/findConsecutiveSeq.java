package PRGCREEK;

/**
 *
 * @author pune7087
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. 
* Its length is 4.
 */
import java.util.Set;
import java.util.HashSet;
public class findConsecutiveSeq {
    
    public static void main(String args[])
    {
        int a[]= {100,4,200,1,3,2};
        System.out.println(findseq(a));
    }
    
    public static int findseq(int []num)
    {
        Set <Integer>set = new HashSet();  
        int max =1;
       
        
        if (num.length == 0) {
		return 0;
	}
        
        
        // add all to set
        for(int x : num)
            set.add(x);
        
        // loop array and check in set
        for(int x : num)
        {
            int left = x-1;
            int right = x+1;
            int count=1;
            
            while(set.contains(left))
            {
                count++;
                set.remove(left);
                left--;
                
            }
            
            while(set.contains(right))
            {
                count++;
                set.remove(right);
                right++;
            }
            max= Math.max(count, max);
            set.remove(x);
        }
        
        return max;
    }
    
    
}
