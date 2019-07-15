package Heap;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import java.util.Collections;

/**
 *
 * @author pune7087
 */
public class MeetingRoomSolutions {
 
public static void main(String args[])
{
    int[][] intervals = { { 2, 15 }, { 36, 45 }, { 9, 29 }, { 16, 23}, {4,9}};
    
    int[][] intervals1 = { { 5, 15 }, { 2, 5 }, { 16, 18 }};

    System.out.println( " ");
    System.out.println( "Min rooms : " +  minMeetingRooms(intervals));
    
    System.out.println( "person Can attend att : " +  personCanAttendAll(intervals1));
    
 
    
        Interval[] in = new Interval[5];

        in[0]= new Interval(2,6);
        in[1]= new Interval(15,18);
        in[2]= new Interval(8,10);
        in[3]=new Interval(1,3);
        in[4]=new Interval(3,9);
        
        
        System.out.println( "mergeIntervals : " );
        mergeIntervals(in);
        
        System.out.println( "mergeIntervals AL : " );
       mergeIntervalsUsingArrayList(in);

        ArrayList<Interval> in2 = new ArrayList();

        in2.add(new Interval(1,3));
        in2.add(new Interval(6,9));
        
               System.out.println( "Insert Interval : " );
               
               
       ArrayList<Interval> a = insert(in2,new Interval(2,5));
       
       for(Interval x: a)
           System.out.print(x.start + ":" + x.end + "|");
       
}

    public int[][] merge(int[][] intervals) {
        
        if(intervals==null || intervals.length==0)
            return new int[][]{};
        
        Arrays.sort(intervals, Comparator.comparing((int[] v) -> v[0] ));
        
        ArrayList<int[]> result = new ArrayList();
        result.add(new int[]{intervals[0][0], intervals[0][1]});
                
        for(int[] intv : intervals)
        {
            int[] temp= result.get(result.size()-1);
        
            if(temp[1]>=intv[0])
                    temp[1] = Math.max(temp[1], intv[1]);
            else
                result.add(new int[]{intv[0], intv[1]});
        }
        
        // This is the important part toArray(new int[][]);
        return result.toArray(new int[result.size()][]);
    }
    
    public static int minMeetingRooms(int[][] intervals)
    {
        
        // sort in ascending order based on strat Time
        Arrays.sort(intervals,Comparator.
               comparing( (int[] itv) -> itv[0] )

        );
        
        // to store end time so we know when the first meeting ends to be able to merge with second one.
        PriorityQueue<Integer> pq = new PriorityQueue();
        int roomsCount=0;
        
        for(int[] itv : intervals )
        {
            if(pq.isEmpty())
            {
                // add the end time of first interval
                pq.offer(itv[1]);
                roomsCount++;
            }
            else
            {
                //check if the startTime is >= end time of the smallest in PQ, so it can be merged
                if(itv[0] >= pq.peek())
                {
                    pq.poll();  // remove that interval
                    pq.offer(itv[1]); // insert the bigger one
                }else
                {
                   roomsCount++;
                   pq.offer(itv[1]);
                }
                
            }
        }
     
        return roomsCount;
    
    
    }
    
    
      
      
     public static boolean personCanAttendAll(int[][] intervals)
     {
         Arrays.sort(intervals, Comparator.comparing(
             (int[] intv)-> intv[0]    
         ));
         
         
         for(int i=0; i< intervals.length-1; i++)
         {
             if(intervals[i][1] > intervals[i+1][0])
                 return false;
         }
         
         return true;
     }
    
     
    public static void mergeIntervals(Interval[] intervals)
    {
        Stack<Interval> stack = new Stack();
        
            Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
        
        for(Interval a : intervals)
        {
            if(stack.isEmpty())
                stack.push(a);            
            else
            {
                Interval temp = stack.peek();
                if(temp.end>=a.start)
                {
                    stack.pop();
                    stack.push(new Interval(temp.start, a.end));
                }
                else
                   stack.push(a); 
            }

        }
    
        while(!stack.isEmpty())
        {
            Interval t =  stack.pop();
            System.out.println(" " + t.start + ":" + t.end + " |");
        }
        
    }
    
     public static void mergeIntervalsUsingArrayList(Interval[] intervals)
    {
        ArrayList<Interval> ar = new ArrayList();
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
        
        
        ar.add(intervals[0]);
        int j=0;
        
        for(int i=1; i< intervals.length; i++)
        {
           Interval temp = ar.get(j);
           
           if(temp.end >= intervals[i].start )
              temp.end= Math.max(temp.end,intervals[i].end );
            
           else
           {
               j++;
               ar.add(intervals[i]);
           }

        }
        
        for(Interval t : ar)
        {
            System.out.println(" " + t.start + ":" + t.end + " |");
        }
    
       
        
    }
     
   
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    {
        ArrayList<Interval> result = new ArrayList();
        
        for(Interval in : intervals)
        {
            if(in.end < newInterval.start) // current interval is smaller and cannot be merged
                result.add(in);
            else if(newInterval.end < in.start)
            {
                result.add(newInterval);
                newInterval=in;
             }
            else if(in.end>=newInterval.start || in.start<= newInterval.end)
            {
                newInterval= new Interval (Math.min(in.start, newInterval.start), Math.max(in.end, newInterval.end));
                //result.add(newInterval);
            }
            
        }
        result.add(newInterval); 
        return result;
        
    }

    
}
}

class Interval
{
    int start;
    int end;
    
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
    
}