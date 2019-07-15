/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
import java.util.HashSet;

/**
 *
 * @author pune7087
 * [2,4,6,7,8,9,10] sum =16
 * answer 
 * 10+6
 * 7+9
 * 
 * 
 */
public class findPairsAddtoANum {
 
    public static void main(String[] args) {
        int a[]= {2,4,6,10,12,14};
        System.out.println("dynamicPrg.findcombAddtoANum.main()"+ findcomb(a, 16));
    }
 
    
    
    public static int findcomb(int a[], int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>(); 
        int temp=0;
        int cnt=0;
        for(int i=0;i<a.length;i++)
        {
            temp=sum-a[i]; // we need to find if this value exist in Map
         
            if(s.contains(temp) && temp>0)
            {cnt++;
                System.out.println("dynamicPrg.findcombAddtoANum.findcomb()"+ a[i] + " :  " + temp);
            }
            
            s.add(a[i]);
        }
        return cnt;
    }
    
}
