/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 *
 * @author pune7087
 */
public class fibonacci {
 
    static int mem[];
    public static void main(String []s)
    {
        int n=10;
        
        mem=new int[n];
        for(int i=1; i< n;i++)
        {
        System.out.println("  "+ fibMem(i) );
            // System.out.println("  "+ fib_bottom_up(i) );
        }
    }
    
    
    public static int fib(int n)
    {
        int result = 0;
        if(n==1 || n==2)
            result = 1;
        else
            result = fib(n-1) + fib(n-2);
        return result;
    }
    
    
    // with memoization , dynamic programming
    
    public static int fibMem(int n)
    {
        int result = 0;
        
        if(mem[n]!=0)
            result= mem[n];
        
        if(n==1 || n==2)
            result = 1;
        else
            result = fibMem(n-1) + fibMem(n-2);
        
        mem[n]=result;
        return result;
    }
    
    
      public static int fib_bottom_up(int n)
    {
      
        if(n<2)
            return 1;
        
        int botup[]= new int[n];
        botup[0]=1;
        botup[1]=1;
                
        for(int i=2;i<n;i++)
            botup[i]=botup[i-1]+ botup[i-2];
        
        return botup[n-1];
    }
      
      
}
