package PRGCREEK;

/**
 *
 * @author pune7087
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//https://github.com/passionatecoderraj/dsa/blob/master/raj/arrays/FindAllSubsets.java

public class AllSubsetsofAnArray {
    
    public static void main(String args[])
    {
        int a[] = { 1,2,2};
        List<List<Integer>> result = subsetsRecursive(a);
        System.out.println("result"); 
        System.out.println(result);
        System.out.println(result.size());
    }
    
    
    public static List<List<Integer>> getSubsets(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // first empty subset
        result.add(new ArrayList<Integer>());
        
        for(int n : nums)
        {
            int size=result.size();
            for(int j = 0; j<size;j++)
            {
                // fetch existing subsets from results
                 List<Integer> curr= new ArrayList<Integer>(result.get(j));
                 
                // create new subset with the existing value and new value from array
                curr.add(n);
                
                // add new subset to result
                result.add(curr);
            }
            
        }
        
        return result;
        
    }
    
    
   	public static List<List<Integer>> subsetsRecursive(int[] a) {
		//Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		subsetsRecursiveUtil(result, new ArrayList<Integer>(), a, 0);
		return result;
	}

	public static void subsetsRecursiveUtil(List<List<Integer>> result, ArrayList<Integer> cur, int[] a, int i) {
		if (i == a.length)
			return;
		for (int j = i; j < a.length; j++) {
			cur.add(a[j]);
			result.add(new ArrayList<>(cur));
			subsetsRecursiveUtil(result, cur, a, j + 1);
                        
                        // this is to remove after recursion so we can step to next eleent in array to form the sets and not reprocess it again
			cur.remove(cur.size() - 1);
		}
	}

  
}
