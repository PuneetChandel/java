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
 * find 2 numbers from array that multiply to 20
 */
public class find2NumMultipltToN {
    
    public static void main(String[] args) {
        int []a = {1,3,2,4,6,5,10};
        HashSet<Integer> h = new HashSet<Integer>();
        
        int n=20;
        for(int i=0;i <a.length;i++)
        {
            h.add(a[i]);
            if((n%a[i])== 0 && h.contains(n/a[i]))
                System.out.println(" a[i]" + a[i] + " : " +n/a[i]);
        }
    }
}
