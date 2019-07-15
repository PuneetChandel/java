package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.HashMap;
public class majorityNumber {

    public static void main(String args[]) {
        
        int a[] = {3,2,3,4,1,3,2,3,3};
        
        System.out.print(majorityNumber2(a));

    }
    
   static int majorityNumber(int a[])
   {
        HashMap<Integer,Integer> map= new HashMap();
        int k=-1;
       
        for(int x: a)
        {
           if(map.containsKey(x))
           {
               if(map.get(x)+1>=a.length/2)
               {
                   k=x;
                   break;
               }
               map.put(x, map.get(x)+1);
           }
           else
             map.put(x, 1);  
        }
        return k;
    }
   
   static int majorityNumber2(int a[])
   {
       int result =0;
       int count =0;
       
       for(int x : a)
       {
           if(count==0)
           {
               result = x;
               count=1;
           }
           else if(x==result)
               count++;
           else
               count --;
           
                      
       }
       
       return result;
   }

}
