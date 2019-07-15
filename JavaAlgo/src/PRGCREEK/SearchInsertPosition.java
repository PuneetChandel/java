package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class SearchInsertPosition {
  
    public static void main(String args[])
    {
        int a[] ={1,3,5,6,9};
        System.out.println(binarySearch2(a,6,0,a.length-1));

    }
    
    public static int binarySearch(int[] a, int k, int low, int high )
    {
       if(low<=high)
       {
           int mid = (high+low)/2;

           if(a[mid]>k)
               return binarySearch(a,k,low,mid-1);
           else if(a[mid]<k)
               return binarySearch(a,k,mid+1,high);
           else
               return mid;
       } 
       return -1;
    }
    
    public static int binarySearch2(int[] a, int k, int low, int high )
    {
        
        int mid = 0;
        
        while(low<=high)
        {
            mid = (high+low)/2;
            
            if(a[mid]==k)
                return mid;
          /*  else if(a[mid]>k && a[mid-1]<k)
                return mid;
            else if(a[mid]<k && a[mid+1]>k)
                return mid+1;*/
            else if(a[mid]>k)
                high=mid-1;
            else
                low = mid+1;
                
        }
  
        return low;
                    
    }
    
  
     
}
