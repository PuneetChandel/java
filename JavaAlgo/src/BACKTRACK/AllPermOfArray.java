package BACKTRACK;

/**
 *
 * @author pune7087
 */

import java.util.List;
import java.util.ArrayList;

public class AllPermOfArray {
    
         public static void main(String args[])
       {
           int[] a= {1,2,3};
           AllPermOfArray ar = new AllPermOfArray();
           List<List<Integer>> result=ar.permutationArray(a);
           System.out.println("");
           System.out.println(result.size());
           System.out.println(result);

       }
       
    
    public List<List<Integer>> permutationArray(int[] nums) {        
        List<List<Integer>> result = new ArrayList();
        result=permuteArrayUtil(result,nums, 0);
        return result;
    }
    
    public List<List<Integer>> permuteArrayUtil(List<List<Integer>> result, int[] nums, int idx )
    {
        
        if(idx==nums.length-1)
        {
             ArrayList<Integer> list = new ArrayList<>();
                for(int num: nums)
                    list.add(num);
                 
            result.add(list);
            return result;
        }
        
        for(int i=idx; i<nums.length ; i++)
        {
            swap(nums,i,idx);
            permuteArrayUtil(result,nums,idx+1);
            swap(nums,i,idx);// This is needed as we modified array in place
        }
        return result;
    }
    
    public void swap(int nums[], int i, int j)
    {
        int x= nums[i];
        nums[i]= nums[j];
        nums[j]=x;        
    }
}
