/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 *
 * @author pune7087
 * 
 * Given a 2d array which is sorted, find the total negative numbers
 * 
 * -2 -1 1 2
 * -3 -2 -1 0
 * 1 2 3 4
 * 
 * answer : 5
 */
public class findNonNegativeinSortMatrix {
    
    public static void main(String[] args) {
        
        int[][] a= {
                {-2,-1,1,2},
                {-3,-2,-1,0},
                {1,2,3,4}
    };
        
        System.out.println(getneg(a));
        
    }
    
    public static int getneg(int [][]a)
    {
        int count =0;
        int resu=0;
        for(int i=0; i<a.length;i++)
        {
            count=0;
            for(int j=a[i].length-1; j>=0;j--)
            {
                if(a[i][j]>=0)
                    count++;
                else
                    break;
            }
            resu=resu+(a[i].length-count);
        }
        return resu;
    }
    
}
