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
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well. For example, the input [3, 4, -1, 1] should give 2.
 * The input [1, 2, 0] should give 3.
 *
 */
public class firstMissingPositiveNumber {

    public static void main(String[] args) {
        int a[] = {-1,-2,1,1,2,3, 0,2,3,5,6,4};
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            int min = i; // find the smallest number
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // move the smallest item to start of array at each iteration
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        
      
        int i = 0;
        
        while (i < a.length) {
       
            if(i==a.length-1)
            {
                System.out.println(a[i]+1);
                break;
            }
            else if (a[i] == a[i + 1]) {
                i++;
            }
            else if (a[i] >= 0 && (a[i] + 1 != a[i + 1])) {
                System.out.println(a[i]+1);
                break;
            }
            else
            i++;
        }
    }
}
