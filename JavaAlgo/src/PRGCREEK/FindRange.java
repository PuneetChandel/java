package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class FindRange {
    
    public static void main(String[] args)
    {
        int[] nums = {2,2};
        
        for(int a : searchRange(nums,2))
        {
            System.out.print(a + " : ");
        }
    }
    
    public static int[] searchRange(int[] nums, int target) {
        
        int high=nums.length-1;
        int low=0;
        int mid =0;
        int result[]= new int[2];
        
        int first =-1;
        int last =-1;
        while(low<=high)
        {
            mid=(high+low)/2;
            
            if((mid==0 || nums[mid-1]<target) && nums[mid]==target )
            {
                first=mid;
                break;
            }
            if(nums[mid]<target)
                low=mid+1;
            else 
                high=mid-1;
        }
        
        high=nums.length-1;
        low=0;
        
        while(low<=high)
        {
            mid=(high+low)/2;
            
            if((mid==nums.length-1 || nums[mid+1]>target) && nums[mid]==target)
            {
                last=mid;
                break;
            }
            if(nums[mid]>target)
                high=mid-1;
            else 
                low=mid+1;
        }
        
         result[0]=first;
         result[1]=last;
        return result;
        
    }
}

