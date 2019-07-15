package BACKTRACK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pune7087
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * 
 */
public class AllBackTracking {
    
    
    
    
    public static List<ArrayList<Integer>> allSubsets(int a[])
       {
           
           List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
               Arrays.sort(a);// Needed for dups
           result.add(new ArrayList<Integer>());
           allSubsetUtil(a,0,result,new ArrayList<Integer>());
           return result;
           
       }
    
       public static void allSubsetUtil(int a[],int idx,List<ArrayList<Integer>> result, ArrayList<Integer> cur )
       {
           
         	if (idx == a.length)
			return;
                
		for (int j = idx; j < a.length; j++) {
                        cur.add(a[j]);
                        result.add(new ArrayList<Integer>(cur));
                        allSubsetUtil(a,j+1,result,cur);
                        cur.remove(cur.size()-1);
                        
                       // ArrayList<Integer> temp = new ArrayList<Integer>(cur);
                       // temp.add(a[j]);
			
                        //result.add(new ArrayList<Integer>(temp));
			//allSubsetUtil(a,j+1,result,temp);
 
                }
       }

        
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);// Needed for dups
    
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}

    
}
