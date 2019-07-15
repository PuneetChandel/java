/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 *
 * @author pune7087
 * randomly sort an array using rand and floor
 */
public class RandomSort {
    public static void main(String[] args) {
        System.out.println(" "+ Math.floor(Math.random() * 4));
        
        int [] a = {2,3,1,0,9,6};
        int pick=0;
        int temp=0;
        // start with last element and randomly choose an index to swap.
        // based on idx need to generate random value
        // so for index 4, need to generate random value between 0-3 so multiply rand with 3
        for(int i=a.length-1; i>0;i--)
        {
            pick = (int)Math.floor(Math.random() * (i-1)); 
            temp=a[pick];
            a[pick]=a[i];
            a[i]=temp;
        }
        
        for(int x:a)
            System.out.print(x + " ");
    }
}
