package PRGCREEK;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Iterator;

/**
 *
 * @author pune7087
 */
public class KthLargestElement {
    
      public static void main(String args[])
     {
         
         int[] a = {3,2,1,5,6,4};
         System.out.println(" Get kth largest "+ usingqs(a,2) );
         
         

                 Arrays.sort(a);
           for(int x :a)
            System.out.print(" " + x + " : " );
         
     }
    
   
   
    
        public static void swap(int[] arr, int idx, int idx2)
    {
        int temp=arr[idx];
        arr[idx]= arr[idx2];
        arr[idx2]=temp;
    }
      
    public static int usingHeap(int[] a, int k)
      {
          PriorityQueue pq= new PriorityQueue(2);
          
          for(int x:a)
          {
              // keep adding
              pq.offer(x);
              
              // remove the head/smallest if size >k
              if(pq.size()>k)
                  pq.poll();
          }

          int result = (int) pq.peek();
          while(!pq.isEmpty())
              System.out.print(" " + pq.poll() + " : " );
          
          return result;
      }
      
      
    public static int usingSort(int[] a, int k)
    {
        Arrays.sort(a);
        return a[a.length-k];
       
    }
    
    
    public static int usingqs(int a[], int k)
    {
      int start =0; int end = a.length-1;
      int pvt=0;
   
       while(start<=end)
        {
            pvt=qspartition(start, end, a);
      
            // pvt a.length-k
        if(pvt<a.length-k)
           start = pvt+1;
        if(pvt>a.length-k)
            end = pvt-1;
        if(pvt==a.length-k)
            return a[pvt];
        
        pvt=qspartition(start, end, a);
        
        }
        return -1;
    }
    
     public static int qspartition(int start, int end, int[] arr)
    {
        int pivot = arr[end];
        int pos = start-1;
        
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
    
  
    
    
}
