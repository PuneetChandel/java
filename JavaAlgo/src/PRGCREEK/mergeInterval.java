package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
public class mergeInterval {
    
    public static void main(String args[])
    {
        ArrayList<Intrval> in = new ArrayList();

        in.add(new Intrval(2,6));
        in.add(new Intrval(15,18));
        in.add(new Intrval(8,10));
        in.add(new Intrval(1,3));
        in.add(new Intrval(3,9));
        
        mergeIntrvalsArrayList(in);
       
    }
    
    public static void mergeIntrvals(ArrayList<Intrval> in)
    {
         Stack<Intrval> results = new Stack();
      
         Collections.sort(in, new Comparator<Intrval>(){
            public int compare(Intrval i1, Intrval i2)
            {
                return i1.start - i2.start;
            }
        });
        
        
         results.push(in.get(0));
         
        
        for(int i=1;i<in.size();i++)
        {
            
            Intrval res= results.peek();
            Intrval sec = in.get(i);
            
            
            if(res.end>=sec.start)
            {   //results.pop();
                res.end=Math.max(res.end,sec.end);
                //results.add(new Intrval(res.start, Math.max(res.end,sec.end)));
            }
             else
                results.add(sec);
        }
        
        
        while(!results.empty())
        {
            System.out.println(results.peek().start + " : " + results.peek().end);
            results.pop();
        }
    }
    
    public static void mergeIntrvalsArrayList(ArrayList<Intrval> in)
    {
         ArrayList<Intrval> results = new ArrayList();
      
         Collections.sort(in, new Comparator<Intrval>(){
            public int compare(Intrval i1, Intrval i2)
            {
                return i1.start - i2.start;
            }
        });
        
         
        int j=0; 
        results.add(in.get(0));
        
        for(int i=1;i<in.size();i++)
        {
            Intrval res=  results.get(j);
            Intrval sec = in.get(i);
               
            if(res.end>=sec.start)
               res.end=Math.max(res.end,sec.end);
            else
            {
                results.add(sec);
                j++;
            }
        }
        
        
        for(Intrval i : results)
        {
            System.out.println(i.start + " : " + i.end);
        }
    }
    
    
    public static ArrayList insertIntrval(ArrayList<Intrval> in, Intrval newInt)
    {
         ArrayList<Intrval> results = new ArrayList();
         
         if(in.size()==0)
         {
             results.add(newInt);
             return results;
         }
         
         for(Intrval x : in)
         {
             if(x.end < newInt.start)
                 results.add(x);
             else if(x.start>x.end)
             {
                 results.add(newInt);
                 newInt=x;
             }
             else if(x.end>=newInt.start || x.start<=newInt.end)
                 newInt=new Intrval(Math.min(x.start, newInt.start), Math.max(newInt.end, x.end));
         }
         results.add(newInt);
         return results;
    }
}




class Intrval
{
    int start,end;
    Intrval(int start, int end) 
    { 
        this.start=start; 
        this.end=end; 
    } 
    
}