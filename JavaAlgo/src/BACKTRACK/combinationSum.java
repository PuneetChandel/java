package BACKTRACK;

/**
 *
 * @author pune7087
 * https://leetcode.com/problems/combination-sum/
 * 
 */

import java.util.List;
import java.util.ArrayList;


public class combinationSum {
    
       public static void main(String args[])
       {
           int[] nums= {2,3,6,7};
           int target = 7;
                     
           combinationSum obj = new combinationSum();
           
           List<List<Integer>> result=obj.combinationSumAr(nums,target);
           System.out.print(result);

           
       }
       
       public List<List<Integer>> combinationSumAr(int[] nums, int k)
       {
           List<List<Integer>> result = new ArrayList<>();
           ArrayList<Integer> cur = new ArrayList();
           //result.add(cur);

           combinationSumUtil(result,cur,nums,0,k);
           
           return result;
       }
       
       public void combinationSumUtil(List<List<Integer>> result,List<Integer> cur, int[] nums, int idx, int k)
       {
           if(k<0)
               return;
           else if(k==0)
               result.add(new ArrayList<Integer>(cur));
           else
           {
               for(int i=idx; i<nums.length; i++)
               {
                   cur.add(nums[i]);
                   combinationSumUtil(result,cur,nums,i, k-nums[i]); 
                   // keep reducing the target, we dont change idx as same number can be used
                   cur.remove(cur.size()-1);
               }
           }
           
       }
       
}
