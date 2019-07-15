/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author pune7087
 */
public class AllSubsetofaSet {
    
     // Driver code
    public static void main(String[] args)
    {
        char a[] = {'a', 'b', 'c'};
        int b[]={1,2,3};
        
        printSubsets(a);
        //System.out.print(1 << 1);
        
    }  
    
    static void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by one
  
        
        // since the total number of combinations are 2^n loop should go 2^n ie leftshift bit by n
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                /* (1<<j) is a number with jth bit 1
                
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                
                for  three values in a set, total combinations 2^3 
                to find which char to print out of a,b,c need to find where we have 1 in binary representation, 
                i.e if we & it with 1 we find 1 where we have 1 if & result > 0. 
                so we loop 3 times and & j(0,1,2) with i to find which bit is present.
                
                1<<j --> this returns 1,2,4 or 001, 010, 100 so we know whih bit is present 
                
                i   binary
                -------
                0-> 000 - print set() -- & three times by moving bit every time from 0-2 -> 1 at no position 
                1-> 001 - print set(0) -- & three times by moving bit every time from 0-2 -> 1 at 0 
                2-> 010 - print set(1)  -- & three times by moving bit every time from 0-2 -> 1 at 1 
                3-> 011 - print set(0,1) -- & three times by moving bit every time from 0-2 -> 1 at 0,1
                4-> 100 - print set(2) -- & three times by moving bit every time from 0-2 -> 1 at 2
                5-> 101 - print set (2,0) -- & three times by moving bit every time from 0-2 -> 1 at 2,0
                6-> 110 - print set(2,1) -- & three times by moving bit every time from 0-2 -> 1 at 2,1
                7-> 111 - print set(2,1,0) -- & three times by moving bit every time from 0-2 -> 1 at 2,1,0
                
              
*/
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
 
            System.out.println("}");
        }
    }
 
   
    static void findSubset(int a[])
    {
        List<ArrayList> subsets = new ArrayList<ArrayList>();
        ArrayList temp;
        
        for(int i=0; i<(1<<a.length);i++) // total number of combinations 2^n
        {
            temp= new ArrayList();
            for(int j=0; j<a.length;j++) // loop to length for array each time to find which char to print
            {
                if((i & (1<<j)) > 0)
                {
                    //System.out.print(a[j]);
                    temp.add(a[j]);
                }
            }
            //System.out.println("");
            subsets.add(temp);
        }
        
        for(ArrayList ar : subsets)
        {
            for(Object o : ar)
            {
               System.out.print(o); 
            }
            System.out.println(""); 
        }
        
    }
    
}
