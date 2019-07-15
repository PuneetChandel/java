package PRGCREEK;

/**
 *
 * @author pune7087
 */

import java.util.HashMap;
public class TwoSum {
    
    public static void main(String args[])
    {
        int[] num = {8,6,2,4,7,1};
        int[] res = findTwoSumVM(num,9);
        
        System.out.println("idx : " + res[0] + " - "+ res[1]);
        
        //int[] num1 = {2,5,7,8,9,11};
        //int[] res = findTwoSortedArray(num1, 14);
        
        //System.out.println("idx : " + res[0] + " - "+ res[1]);
        
        
        
    }
    
    public static int[] findTwoSumVM(int[] num, int sum)
    {
        HashMap<Integer,Integer> map= new HashMap();
        int[] result= new int[2];
        boolean flagFound=false;
        System.out.println(result[0]);
        
        for(int i=0; i<num.length;i++)
        {
            int diff= sum-num[i];
            
            if(!map.containsKey(diff))
                map.put(num[i], i);
            
            else
            {
               int idx = map.get(diff);
               if(!flagFound || result[0]>idx)
               {
                result[0]=idx;
                result[1]=i;
               }
               // to stop iterating complete loop if we found match with 0
               if(idx==0)
                   break;
               flagFound=true;
            }
        }
        
        return result;
    }
    
    public static int[] findTwoSum(int[] num, int sum)
    {
        HashMap<Integer,Integer> res = new HashMap();
        
        int i=0;
        for(; i<num.length; i++)
        {
            int diff=sum-num[i];
          if(res.get(diff)!=null)
          {
             return new int[]{diff,i};
          }
          res.put(num[i],i);
        }
        
       return new int[]{0,0}; 
    }
    
    public static int[] findTwoSortedArray(int[] num, int sum)
    {
       int low=0;
       int high = num.length-1;
       
       while(low<high)
       {
           if(num[low]+ num[high]>sum)
               high--;
           else if (num[low]+ num[high]<sum)
               low++;
           else
               return new int[]{low,high};
       }
       return new int[]{0,0};
    }
    
    
}
