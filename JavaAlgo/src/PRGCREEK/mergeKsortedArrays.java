package PRGCREEK;

/**
 *
 * @author pune7087
 */



import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
public class mergeKsortedArrays {
    
    public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = mergeArrays(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
    
    
    public static int[] mergeArrays(int[][] a)
    {
       
        
        PriorityQueue<queueArray> pq = new PriorityQueue(new Comparator<queueArray>(){
            public int compare(queueArray q1, queueArray q2)
            {
            return q1.ar[q1.index] - q2.ar[q2.index];
            }
        });
        
        int size=0; // size of final array
        
        // add initial arrays to PQ 
        for(int i=0; i<a.length; i++)
        {
            pq.add  (new queueArray(a[i],0));
            // size of result array
            size+=a[i].length;
        }
        int[] result = new int[size];
        int i=0;
        
        while(!pq.isEmpty())
        {
            // the polled ar will have the smallest element at that index
            queueArray temp=pq.poll();
            result[i]=temp.ar[temp.index];
            i++;
            
            // add that array again with next index
            if(temp.index<temp.ar.length-1)
            pq.add(new queueArray(temp.ar,temp.index+1) );
        }
         
         
        return result;
    }
    
}


class queueArray //implements Comparable<queueArray>
{
    int[] ar;
    int index;
    
    queueArray(int[] ar, int index)
    {
        this.ar=ar;
        this.index=index;
    }
    
   /* public int compareTo(queueArray qb)
    {
        return (this.ar[index] - qb.ar[qb.index]);
    }*/
} 