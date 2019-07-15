package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.Map;
import java.util.HashMap;
public class ContainsDuplicate {
    
    public static void main(String x[])
    {
        int a[]= {2,3,4,3,51,1};
        System.out.println(findDup2(a,1));
    }
    
    public static boolean findDup(int []a)
    {
        if(a==null || a.length==0)
            return false;
        
        Map <Integer,Integer>map= new HashMap();
        
        for(int x: a)
        {
            if(map.containsKey(x))
                return true;
            map.put(x, 1);
        }
        return false;
    }
    
    public static boolean findDup2(int []a, int k)
    {
        if(a==null || a.length==0)
            return false;
        
        Map <Integer,Integer>map= new HashMap();
        
        for(int i=0; i<a.length;i++)
        {
            if(map.containsKey(a[i]))
            {
                if(Math.abs(map.get(a[i])-i)<=k)
                    return true;
            }
            map.put(a[i], i);
        }
        return false;
    }
    
}
