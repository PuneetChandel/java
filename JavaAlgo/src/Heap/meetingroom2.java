package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author pune7087
 * Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
 */
public class meetingroom2 {
    
    public void mergeIntervals(int[][] intv)
    {
        
        Arrays.sort(intv, new Comparator<int[]>(){
        public int compare(int[] a , int[] b)
        {
            return a[0]-b[0];
        }
        });
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int i=0;
        for(int[] itv : intv )
        {
            if(i==0)
               list.add(itv);
            else
            {
                int[] al= list.get(i-1);
                if(al[1]>=itv[0])
                    al[1]=Math.max(al[1],itv[1]);
                else
                {
                    list.add(itv);
                }
            }
            i++;
        }
        
      
    }
}
