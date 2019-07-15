package PRGCREEK;

/**
 *
 * @author pune7087
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
     public static void main(String args[])
    {
        int a[]= {-1,2,1,-4,3,2};
        System.out.println(closestSum(a,3));
    } 
     
     public static int closestSum(int[] a , int target)
     {
         Arrays.sort(a);
         
         int start=0, end=0;
         int sum=0, result=0;
         // so that the first run is always less than this
         int min = Integer.MAX_VALUE;
         
         for(int i=0; i< a.length; i++)
         {
             start= i+1;
             end = a.length-1;
             
             while(start<end)
             {
                 sum= a[i]+a[start]+a[end];
                 
                 
                 if(Math.abs(sum-target)==0)
                     return sum;
                 
                 if(Math.abs(sum-target)<min)
                 {
                     min=Math.abs(sum-target);
                     result=sum;
                 }
                 
                 
                 if(sum>target)
                     end--;
                 else
                     start++;
                 
             }
             
         }
         
         return result;
     }
}
