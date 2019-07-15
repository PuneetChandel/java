package BACKTRACK;

/**
 *
 * @author pune7087
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class AllSubsetsOfArray {
    
       public static void main(String args[])
       {
           int[] a= {1,2,3};
           
           AllSubsetsOfArray obj = new AllSubsetsOfArray();
           
           List<ArrayList<Integer>> result=obj.allSubsets(a);
            System.out.println("");
           System.out.println(result.size());
           System.out.println(result);
           
       }
       
       public  List<ArrayList<Integer>> allSubsets(int a[])
       {
           List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
           ArrayList<Integer> curr = new ArrayList();
              // Arrays.sort(nums);// Needed for dups
           result.add(curr);
           allSubsetUtil(result,curr,a,0);
           return result;
           
       }
    
       public void allSubsetUtil(List<ArrayList<Integer>> result, ArrayList<Integer> cur,int a[],int idx)
       {
           
         	if (idx == a.length)
			return;
                
		for (int i = idx; i < a.length; i++) {
                        /// for duplicate if(j>idx && a[j]==a[j-1]) continue;
                        cur.add(a[i]);
                        result.add(new ArrayList<Integer>(cur));
                        allSubsetUtil(result,cur,a,i+1);
                        cur.remove(cur.size()-1);
                }
       }


     public static List<ArrayList<Integer>> allSubsetsItr(int a[])
       {
           List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
           
           result.add(new ArrayList<Integer>());
           
           for(int x: a)
           {
            int size = result.size();
            
            for(int i=0; i< size; i++)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
                temp.add(x);
                result.add(temp);
            }
            
           }
           return result;
           
       }
     

       
}
