/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
import java.util.HashMap;
import java.util.*;

/**
 *
 * @author pune7087
 * Today
 */
        // Create Priority Queue with Comparator
        // The elements of the priority queue are ordered according to their natural ordering, 
        // or by a Comparator provided at queue construction time
        //The head of this queue is the least element with respect to the specified ordering
        // The queue retrieval operations poll, remove, peek, and element access the element at the head of the queue

 class Pair implements Comparator<Pair>{
    int num;
    int freq;
    public Pair(int num, int freq){
        this.num=num;
        this.freq=freq;
    }
    
    public int compare(Pair a , Pair b)
    {
        return a.freq - b.freq;
    }
}

public class kmostfrequentElements {
    
    public List<Pair> tokFrequency(int a[], int k){
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        for(int num : a)
        {
                 if(m.containsKey(num))
                     m.put(num,m.get(num)+1); 
                  else
                     m.put(num, 1);
        }
        
    
        // Create PQ
       PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b)
            {
                return a.freq - b.freq;
            }
        });
   
   //    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
       
        // Add values to PQ
        for(Map.Entry<Integer,Integer> entry:m.entrySet())
        {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            
            pq.offer(p);// add to PQ
            
            if(pq.size()>k) // if PQ size is more than what we need remove the head (smallest)
                pq.poll();
        }
        
        
        List<Pair> res = new ArrayList<Pair>();

        for(Pair p: pq)
            res.add(p);
       
        return res;
    }
    
   
      public static void main(String[] args) {
        int a[] = {4,4,4,2,1,3,1,1,4,5,6,7,7,5,5,6,7,9,2,3,5,2,6,7,7};
        
        kmostfrequentElements kf = new kmostfrequentElements();
        for(Pair p : kf.tokFrequency(a, 3))
           System.out.println(p.num + " : " + p.freq);
        }
    
}
