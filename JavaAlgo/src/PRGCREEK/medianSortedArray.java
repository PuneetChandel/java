package PRGCREEK;

/**
 *
 * @author pune7087
 */

//https://youtu.be/LPFhl65R7ww
public class medianSortedArray {
    
    public static void main(String args[])
    {
        int[] inp1={2,4,8,11};
        int [] inp2={5,6,9,10,22};
        
        System.out.println(findMedian(inp1,inp2));
    }
    
    // assuming length of input1 < input 2 and thats where we will do binary search to find rigth partition
    public static double findMedian(int[] input1, int[] input2)
    {
       
        // limits for Binary 
        int low =0;
        int high = input1.length;
        
        while(low<high)
        {
            // make 2 partitions 
            int partx = (low+high)/2;
            int party = (input1.length+input2.length+1)/2 - partx; // partition should be in a way to have 2 equal halves
            
            // find Min and max for each partition to compare
            int maxLeftX= partx ==0? Integer.MIN_VALUE : input1[partx-1];
            int minRightX = partx ==0? Integer.MAX_VALUE: input1[partx];
            
            int maxLeftY= party ==0? Integer.MIN_VALUE : input2[party-1];
            int minRightY = party ==0? Integer.MAX_VALUE: input2[party];
           
            if(maxLeftX <= minRightY && maxLeftY <=minRightX)
            {
                if((input1.length+input2.length)%2 ==0) // if even length average of middle two values
                    return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightY, minRightX))/2;
                else
                    return Math.max(maxLeftX, maxLeftY);
            }
            else if(maxLeftX>minRightY)
            {
                //move left in X and look in left half
                high=partx-1;
            }
            else
            {
                // move right in X
                low=partx+1;
            }
                
        }
        
        throw new IllegalArgumentException();
    }
    
}
