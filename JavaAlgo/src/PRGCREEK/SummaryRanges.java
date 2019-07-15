package PRGCREEK;

/**
 *
 * @author pune7087
 */

import java.util.ArrayList;



public class SummaryRanges {
    
       public static void main(String args[])
    {
       for(String s: summaryRange(new int[]{0,2,3,4,6,7,9}))
       {
           System.out.println(s);
       }
       
    }
 
    public static ArrayList<String> summaryRange(int[] nums)
    {
        if(nums.length == 0 || nums==null)
            return null;
        
        ArrayList<String> result = new ArrayList();
        if(nums.length==1)
            result.add(nums[0]+ "");
       
        
        for(int i=1,j=0; i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1]+1)
            {
                if(j==i-1)
                 result.add(nums[j]+"");
                else
                  result.add(nums[j]+ "->" +nums[i-1]);
                
                j=i;
            }
            if(i==nums.length-1)
            {
               if(j==i)
                 result.add(nums[j]+"" );
                else
                result.add(nums[j]+ "->" +nums[i]);
            }
           }
        
       return result;
        
    }
    
}
