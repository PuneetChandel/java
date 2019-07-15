/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;
import java.util.ArrayList;

/**
 *
 * @author pune7087
 */
//https://www.youtube.com/watch?v=5o-kdjv7FD0
// you can take one step or two steps at a time {1,2}

// variation steps {1,3,5}
public class NoOfSteps {
    
     static int mem[];
     static int membt[];
     static ArrayList<Integer> alist = new ArrayList<Integer>();
    public static void main(String[] args) {
        int n=5;
        mem=new int[n+1];
        membt=new int[n+1];
        System.out.println("getSteps"+getsteps(n));

        System.out.println("getSteps mem"+getsteps(n,mem));

        System.out.println("getSteps mem"+getstepsbtmUp(n));
        
        
        
        alist.add(1);alist.add(2);//alist.add(5);
        membt=new int[n+1];
        
        System.out.println("getSteps X"+getstepsX(n));
        
         System.out.println("getSteps X"+getstepsXbtmUp(n));
    }
    
    public static int  getsteps(int n)
    {
        if (n<=1)
            return 1;
        else
            return getsteps(n-1)+ getsteps(n-2);
        
    }
    /// For any given options of step
     public static int  getstepsX(int n)
    {
        int total=0;
        if (n==1 || n==0)
            total=  1;
     
        else
        {
            for(Integer a : alist)
            {
                if(n-a>=0)
                    total+=getsteps(n-a);
            }   
        }
        return total;
    }
     
         /// For any given options of step
     public static int  getstepsXbtmUp(int n)
    {
        int total=0;
        if (n==0)
            return 1;
     
        membt[0]=1;
        
        for(int i =1;i<=n;i++)
        {  total=0;
          for(Integer a : alist)
            {
                if(i-a>=0)
                    total+=membt[i-a];
            }
          membt[i]=total;
        }
        return membt[n];
    }
     
     
     
    
   public static int  getsteps(int n, int[] mem)
    {
        int result=0;
        
        if(mem[n]!=0)
            return mem[n];
        
        if (n<=1)
            result= 1;
        else
            result = getsteps(n-1)+ getsteps(n-2);
        
        mem[n]=result;
        return result;
    }
   
    public static int  getstepsbtmUp(int n)
    {
        
        if(n<=1)
            return 1;
        
        membt[0]=1;
        membt[1]=1;
        
        for(int i=2; i<=n;i++)
        {
            membt[i]= membt[i-1]+ membt[i-2];
        }
        
        return membt[n];
    }
    
        
}
