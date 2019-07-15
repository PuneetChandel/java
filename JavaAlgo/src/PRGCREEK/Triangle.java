package PRGCREEK;

/**
 *
 * @author pune7087
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    
    public static void main(String args[])
    {
        int a[][]= {
            {2}, {3,4},{6,5,7},{4,1,8,3}
        
    };
        int sum=a[0][0];
        
        for(int i=1; i<a.length;i++)
        {
            int rowmin=Integer.MAX_VALUE;
            for(int j=0;j<a[i].length;j++)
            {
                if(a[i][j]<rowmin)
                    rowmin=a[i][j];
            }
            
            sum=sum+rowmin;
        }
        
        System.out.println(sum);
    }
}
