package PRGCREEK;

/**
 *
 * @author pune7087
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.

For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 */
public class RemoveDupSortedAraay {
    
    // idea is to move all unique values to the front
    
    public static void main(String args[])
    {
        int a[]= {2,2,3,3,3,4,5,5,6};
        
        int length=removeElement(a,3);
        
          System.out.println(length + " ");
          
        for(int x:a)
            System.out.print(x + " ");
        
          
        
    }
    
    public static int removeDupInPlace(int a[])
    {
        int k=0;
        for(int i=1;i<a.length;i++)
        {
            // only when we get a diff value move increment k and replace with the current unique value
            
             if(a[i]!=a[k])
            {
                k++;
                a[k]=a[i];
            }
    
        }
        return k+1;
    }
    
      public static int removeElement(int a[], int ele)
    {
        int i=0;
        int k=-1;
        
        for(i=0;i<a.length;i++)
        {
            // only when we get a diff value move increment k and replace with the current unique value
            
             if(a[i]!=ele)
            {
                k++;
                a[k]=a[i];
            }
    
        }
        return k+1;
    }
      
      
}
