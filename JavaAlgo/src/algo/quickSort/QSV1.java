package algo.quickSort;

/**
 *
 * @author pune7087
 */
public class QSV1 {
 
    public static void qs(int start, int end, int[] arr)
    {
        if(start<end)
        {
            int q = qspartition(start,end,arr);
            qs(start,q-1,arr);
            qs(q+1,end,arr);
        }
    }
    
    public static int qspartition(int start, int end, int[] arr)
    {
        int pivot = arr[end];
        int pos = start-1;
        // pos is the place before which all elements are smaller than Pvt
        while(start<end)
        {
            if(arr[start]<=pivot)
            {   pos++;
                swap(arr,pos,start);
            }
            
            start++;
        }
        pos++;
        swap(arr,pos,end);
        return pos;
        
    }
    
    public static void swap(int[] arr, int idx, int idx2)
    {
        int temp=arr[idx];
        arr[idx]= arr[idx2];
        arr[idx2]=temp;
    }
    
}
