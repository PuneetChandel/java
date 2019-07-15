package algo.quickSort;

/**
 *
 * @author pune7087
 */
public class QSTry {
    
    
    public void quickSort(int[] a, int start, int end)
    {
        
        if(start<end)
        {
            int p = partition(a,start,end);
            quickSort(a,start, p-1);
            quickSort(a,p+1,end);
        }
    }
    
    
    public int partition(int []a, int start, int end)
    {
        int pvt = a[end];
        
        int k =start-1;
        
        while(start<end)
        {
            if(a[start]<=pvt)
            {
                k++;
                int temp = a[start];
                a[start]= a[k];
                a[k]= temp;
     
            }
            start++;
        }
        // swap pivot
        
        k++;
        a[end]=a[k];
        a[k]=pvt;
        
        
        return k;
    }
    
     public void swap(int[] arr, int idx, int idx2)
    {
        int temp=arr[idx];
        arr[idx]= arr[idx2];
        arr[idx2]=temp;
    }
    
}
