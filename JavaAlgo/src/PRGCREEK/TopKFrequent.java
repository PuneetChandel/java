package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue; 
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class TopKFrequent {
    
    public static void main(String args[])
    {
        String s = "Here is the split";
        
  
        
        int[] nums = {1,1,1,1,2,2,3,3,3,3,3,3,4,4,5,5,7,7,7,8,8,9,9,9,9,9,9};
        int k =3;
        
        for(int x: topKFrequent(nums,5) )
        {
            System.out.print(x + " : ");
        }
            

        
    }
    
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        
        List<Integer> result = new ArrayList();
        
        HashMap<Integer,Integer> map= new HashMap();
         for(int x:nums)
        {
            if(!map.containsKey(x))
                map.put(x, 1);
            else
                map.put(x, map.get(x)+1 );
        }
         
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> m1, Map.Entry<Integer,Integer> m2)
            {
                return m1.getValue() - m2.getValue();
            }
        });
        
       
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.offer(entry);
            
            if(pq.size()>k)
                pq.poll();
        }
     
        while (pq.size() > 0) 
            result.add(pq.poll().getKey());
        
        return result;
    }
    
}
