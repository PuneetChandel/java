package PRGCREEK;

/**
 *
 * @author pune7087
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

  For example, given the array [2,3,1,2,4,3] and s = 7, 
* the subarray [4,3] has the minimal length of 2 under the problem constraint.
 */
public class MinSizeSubArraySum {
    
    
    public static void main(String args[])
    {
        
        int a[]= {2,7,1,2,4,3};
        System.out.println(getminArrayLength(a,7));
        
    }
    
    public static int getminArrayLength(int []a, int sum)
    {
        if(a==null||a.length==0)
            return 0;

        int start=0;
        int i =0;
        int result =Integer.MAX_VALUE;
        int tempSum=0;

        while(i<a.length)
        {
            if(tempSum < sum)
            {
                 tempSum +=a[i];
                 i++;
            }
            else
            {
                tempSum= tempSum - a[start];
                result = Math.min(result, i-start);
                start++;
            }
       

        }
        
        // as its possible that we reach end of array with large sum and still can remove few
        // so start removing from start till tempsum is > target sum
        while(tempSum>=sum)
        {
             tempSum= tempSum - a[start];
             result = Math.min(result, i-start);
             start++;
        }
        
        return result;
    }
}
