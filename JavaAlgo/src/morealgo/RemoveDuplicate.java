/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morealgo;
import java.util.HashMap;

public class RemoveDuplicate {
    
    public static void main(String args[])
    {
        int a[] = {1,2,3,2,3,4,5,8};
        HashMap<Integer,Integer> map= new HashMap();
        
        for(int x :a)
        {
            if(! map.containsKey(x))
            {
                map.put(x, x);
                System.out.println(x + " ");
            }
            
        }
    }
    
}
