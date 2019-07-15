package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.Comparator;

import java.util.PriorityQueue;


public class KClosest {
    
    public static void main(String args[])
    {
        int[][] a = {{1,3}, {-2,2}, {4,1}};
        
        int[][]b = kClosest(a,2);
        
        
    }
    
       public static int[][] kClosest(int[][] points, int K) {
        
        int[][] result = new int[K][];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                double a1= Math.sqrt((a[0]*a[0]) + (a[1]*a[1]));
                double a2= Math.sqrt((b[0]*b[0]) + (b[1]*b[1]));
                
                if(a2>a1)
                    return 1;
                else if(a1==a2)
                    return 0;
                else
                    return -1;
            }
            
        });
            
        for(int[] point: points)
        {
            
            pq.offer(point);
            
            if(pq.size()>K)
                pq.poll();
        }
        
        int i=0;
        while(pq.size()>0)
        {
            result[i]= pq.poll();
            i++;
        }   
            
        return result;
    }
        
}
