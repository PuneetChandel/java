package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;


public class SlindingWindowMax {
    
    
      public static void main(String args[])
      {
          int[] nums={1,3,-1,-3,5,3,6,7};
          int k =3;
          ArrayList<Integer> result = new ArrayList();
          
          PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
          public int compare(Integer i1, Integer i2)
                {
                  return i2-i1;
                }
          });
          
          for(int i=0; i<nums.length;i++)
          {
            pq.offer(nums[i]);
            
            if(pq.size()>k)
                result.add(pq.poll());
            
          }
            
          System.out.print(result);
          
      }
}
