/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.quickSort;

/**
 *
 * @author pune7087
 */
public class QuickSort2 {
    public static void main(String[] args) {
		
                int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2};
		quicksort(a, 0, a.length-1);
		for(int x : a)
			System.out.println(x);
	}
    
    
    public static void quicksort(int []a,int p, int r)
    {
        if(p<r)
        {
            int q = partition(a,p,r);
            quicksort(a, p, q-1);
            quicksort(a, q+1, r);
            
        }
    }
    
    public  static int partition(int a[], int p , int r)
    {
        int pvt=a[r];
        int i = p-1;
        int temp=0;
        
        for (int j=p; j< r;j++)
        {
            if(a[j]<=pvt)
            {
                i++;
                temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }

        }
                    
            a[r]=a[i+1];
            a[i+1]=pvt;
          return i+1;
        
    }
    
}
