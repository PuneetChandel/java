/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;


/**
 *
 * @author pune7087
 * https://medium.com/@marcellamaki/finding-the-maximum-contiguous-sum-in-an-array-and-kadanes-algorithm-e303cd4eb98c
 * https://youtu.be/86CQq3pKSUw
 */
public class findSubArrayWithMaxSumKadane {
    
    public static void main(String[] args) {
        int a[] = {2,2,-5,1,2,3};
        System.out.println("kadane  : "+kadane(a));
        System.out.println("maxsum : "+maxsum(a));
    }
    
    public static int kadane(int []a)
    {
        int maxsum=0;
        int currsum=0;
        int startidx =0;
        int endidx=0;
        
        for(int i=0; i<a.length; i++)
        {
            
            //currsum=Math.max(a[i],currsum+a[i]);
            //
            // if we want to get the idx values we need to use these if not Max function
            if(a[i]>currsum+a[i])
            {   startidx=i;
                currsum=a[i];
            }
            else
                currsum=currsum+a[i];
            
            if(currsum>maxsum)
            {   
                maxsum=currsum;
                endidx=i;
            }
            
        }
        System.out.println("  startidx : "+ (startidx) + "  endidx : "+ endidx  );
        return maxsum;
    }
    
    public static int maxsum(int []a)
    {
        int maxsum=0;
        int currsum=0;
        int startidx=0;
        int endidx=0;
        for(int i=0; i<a.length; i++)
        {
            currsum=0;
            for(int j=i; j<a.length;j++)
            {
                currsum=currsum+a[j];
                if(currsum>maxsum)
                {
                    maxsum=currsum;
                    startidx=i;
                    endidx=j;
                }
            }
            
        }
        System.out.print(" { ");
        for(int k=startidx;k<=endidx;k++)
        {
            System.out.print( a[k] + " ");
        }
             System.out.print(" } ");
        return maxsum;
    }
    
}
