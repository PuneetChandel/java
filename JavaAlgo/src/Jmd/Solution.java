package Jmd;

/**
 *
 * @author pune7087
 */
import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;
import java.util.Collections;

    

public class Solution
{
        public static void main(String args[])
    {
        List<Integer> a = new ArrayList();
        a.add(1);
        a.add(2);
        
        List<Integer> a1 = new ArrayList();
       a1.add(2);
       a1.add(4);
       
               
         List<Integer> a2 = new ArrayList();
       a2.add(3);a2.add(6);
          List<Integer> b = new ArrayList();
       b.add(1); b.add(2);
       
         List<List<Integer>> f = new ArrayList<>();
         f.add(a);
         f.add(a1);
         f.add(a2);
         
         List<List<Integer>> ba = new ArrayList<>();
         ba.add(b);
         
    
       optimalUtilization(7,f,ba );
    }

    
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> optimalUtilization(
	                        int deviceCapacity, 
                            List<List<Integer>> foregroundAppList,
                            List<List<Integer>> backgroundAppList)
	{
     
     
     HashMap<Integer,List<List<Integer>>> map = new HashMap<>();
     
     for(List<Integer> fore: foregroundAppList)
     {
         for(List<Integer> back: backgroundAppList)
         {
              int time = fore.get(1) + back.get(1);
              
             if(!map.containsKey(time))
             {
             List<List<Integer>> val = new ArrayList<>();
             List<Integer> a = new ArrayList<>();
             a.add(fore.get(0));
             a.add(back.get(0));
             val.add(a);
             map.put(time,val);
             }
             else
             {
                List<List<Integer>> val = map.get(time);
                List<Integer> a = new ArrayList<>();
                a.add(fore.get(0));
                a.add(back.get(0));
                val.add(a);
                map.put(time,val);
             }
         }
         
     }
     
     int max = 0;
     
     for(Map.Entry<Integer,List<List<Integer>>> entry : map.entrySet() )
     {
         int curr = entry.getKey();
         max= Math.max(max,curr);
         
     }
     
     //result = map.get(max);
     return map.get(max);
     //return null;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS
}