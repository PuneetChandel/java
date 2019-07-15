package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class findPeakElement {
      public static void main(String args[])
    {
        int[] nums = {1, 2, 5, 3};
        
        if(nums.length==1)
            System.out.print(nums[0]);
        
        int peak = nums[0];
        int peakidx=0;
        int i=1;
        for(;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
            {
                if(nums[i]>peak)
                {
                    peak=nums[i];
                    peakidx=i;
                }
            }
        }
        
        if(peak<nums[nums.length-1])
        {
            peak=nums[nums.length-1];
                    peakidx=nums.length-1;
        }
        
          System.out.print("Peak : " + peak + " Index : "+ peakidx);
        
        
        
    }
    
}
