package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class LargestContinuousSubArray {
    
    
        public static void main (String[] args)  
    { 
        int arr[] = { 1, 2, -3, 2, 3, 4, -6,  
                      1, 2, 3, 4, 5, -8, 5, 6 }; 
      
       getLongestSeq(arr);
       
       
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        
        largestSumSubArray(a);
        
    }
        
        static void getLongestSeq(int arr[]) 
        {
            int count =0;
        int max=0;
        int idx=0;
        int maxIdx=0;
        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                if(count==0)
                    idx=i;
                count++;
            }
           else
            {
                if(count>max)
                {
                    max=count;
                    maxIdx=idx;
                    
                }  
                count=0;
            }
        }
     
        System.out.print(max + " idx : " + maxIdx); 
        }
        
      static void largestSumSubArray(int a[])
      {
          int currsum=0;
          int maxsum=0;
          
          for(int i=0; i<a.length;i++)
          {
              currsum=0;
             
              for(int j=i+1; j<a.length;j++ )
              {                  
                currsum=currsum+ a[j];
                
                if(currsum>maxsum)
                    maxsum=currsum;
              }
             
          }
          
           System.out.print("sum "+ maxsum); 
           
      }
}
