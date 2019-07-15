package Design;

/**
 *
 * @author pune7087
 */
import java.util.*;

public class pimco {

  public static List<List<Integer>> findMatrix(List<List<Integer>> a) {
    // Write your code here

        Object[][] matrix = new Object[a.size()][a.get(0).size()];

        for (int i = 0; i < matrix.length; i++) 
            matrix[i] = a.get(i).toArray();
        
        //Object[][] matrix = a.toArray(new Object[a.size()][a.get(0).size()]);

        int m = matrix.length;
        int n = matrix[0].length;

        Integer[][] dp = new Integer[m][n];

        dp[0][0] = (Integer) matrix[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + (Integer) matrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + (Integer) matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int sum1 = dp[i - 1][j];
                int sum2 = dp[i][j - 1];
                int dup = dp[i - 1][j - 1];
                dp[i][j] = sum1 + sum2 + (Integer) matrix[i][j] - dup;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer[] array : dp) {
            result.add(Arrays.asList(array));
        }
        return result;
    }

   
   static String[] braces(String[] values) {
        String[] result = new String[values.length];
        if(values== null || values.length==0)
          return result;

        Map<Character,Character> map = new HashMap<>();
          map.put('(' ,')');
          map.put('{' ,'}');
          map.put('[' ,']');
        
        int idx =0;
        for(String str : values)
        {
            if(checkEachString(str,map))
                result[idx]="YES";
            else
               result[idx]="NO";
            idx++;
        }

        return result;

    }

    public static boolean checkEachString(String str, Map<Character,Character> map)
    {
            Stack<Character> stack = new Stack<>();
               for(int i=0; i< str.length(); i++)
               {
                   char c = str.charAt(i);
                   if(map.containsKey(c))
                       stack.push(c);
                   else
                   {
                       if(stack.isEmpty())
                          return false;
                       char s = stack.pop();
                       if(map.get(s)!=c)
                          return false;  
                   }
               }

               return stack.isEmpty();
               
    }

}



