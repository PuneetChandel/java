package Jmd;

/**
 *
 * @author pune7087
 */
import java.util.HashMap;
public class SubArraySumDiv {

    public static void main(String[] args)
    {
        subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
    }
    
    public static int subarraysDivByK(int[] A, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0, sum = 0;
        
        for(int a : A) {
        
            sum = (sum + a) % K;
            
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            
            
            if(map.containsKey(sum))
            {
               count = count + map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else
                map.put(sum, 1);
      
        
        }
        
        return count;
    
    }
}