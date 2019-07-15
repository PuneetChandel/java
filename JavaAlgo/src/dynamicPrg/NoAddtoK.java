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
 

 */
public class NoAddtoK {

    public static void main(String[] args) {
        
        int a[]= {1, 2, 3, 4};
       // System.out.println(checkSum(a,22));
        
         getmultArray(a);
        
        
    }
    
    /** Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
*/
    public static boolean checkSum(int[] a, int k)
    {
        HashSet h = new HashSet();
        int sum=0;
        for(int x : a)
        {   sum = k-x;
            if(h.contains(sum))
                return true;
            h.add(x);
        }
        return false;
    }
    
    
    /*
    Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
    */
    
    public static void getmultArray(int a[])
    {
        int mul=1;
        
        for(int x : a)
            mul=mul*x;
        
        System.out.println(mul);
    /*    for(int i=0;i<a.length;i++)
        {
            a[i]=mul/a[i];
        }
        
      */  
    
    // if cant use divide
        int q =0;
        int mul1 = mul;
        for(int i=0;i<a.length;i++)
        {   mul1=mul;
            q=0;
            while(mul1>0)
            {
                mul1=mul1-a[i];
                q++;
            }
            a[i]=q;
        }
        
        
        
        //print
        for(int x : a)
        {
            System.out.println(x);
        }
    }
    
}
