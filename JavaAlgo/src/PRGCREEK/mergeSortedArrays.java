package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class mergeSortedArrays {
    
       public static void main(String args[])
    {
        int[] inp1={2,4,8,0,0,0};
        int [] inp2={1,5,6};
                           
        int[] res= mergeIntoFirst(inp1,3,inp2,3);
        
        for(int a :res)
            System.out.print(a + " : ");
    }
       
       //You may assume that A has enough space to hold additional elements from B. 
       //The number of elements initialized in A and B are m and n respectively.
    public static int[] mergeIntoFirst(int []a,int m, int[]b, int n)
    {
        
        while(m>0 && n>0)
        {
            if(a[m-1]>b[n-1])
            {
                a[m+n-1]=a[m-1];
                m--;
            }
            else
            {
                a[m+n-1]=b[n-1];
                n--;
                
            }

        }
            
        // This is case when B has elemenst smaller than all elemenst in A
        // 

            while(n>0)
            {
                a[m+n-1]=b[n-1];
                n--;
            }
        
        
        
        return a;
    }
    public static int[] mergeArray(int[] a, int[] b)
    {
        int[] result = new int[a.length+b.length];
        
        int i =a.length-1;
        int j = b.length-1;
        int k = result.length-1;
        
        while(i>=0 && j>=0)
        {
            if(a[i]>=b[j])
            {
                result[k]=a[i];
                i--;
                k--;
            }
            else if(a[i]<=b[j])
            {
                result[k]=b[j];
                j--;
                k--;
            }
        }
        
        while(i>=0)
        {
            result[k]=a[i];
            k--;i--;
        }
        while(j>=0)
        {
            result[k]=b[j];
            k--;j--;
        }
        
        return result;
    }
}
