/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.mergeSort;

/**
 *
 * @author pune7087
 */
public class MergeSort2 {
    
    public void sort(int a[])
	{
		mergesort(a,0,a.length-1);	
	}
    
    public static void mergesort(int a[],int p,int r)
    {
        if(p<r)
        {
            int q = (p+r)/2;
            mergesort(a,p,q);
            mergesort(a,q+1,r);
            merge(a,p,q,r);
            
        }
        
   
    }
    
    public static void merge(int a[],int p,int q,int r)
    {
        int temp[]= new int[r-p+1];
        
        int leftidx=p;
        int rightidx=q+1;
        int k=0;
        while(leftidx <=q && rightidx<=r )
        {
            
            if(a[leftidx]< a[rightidx])
            {
                temp[k]= a[leftidx];
                leftidx++;
            }
            else
              {
                temp[k]= a[rightidx];
                rightidx++;
            }
            k++;
            
        }
        
        while(leftidx<q)
        {
           
            temp[k]=a[leftidx];
           k++;leftidx++; 
        }
        while(rightidx<r)
        {
            
            temp[k]=a[leftidx];
            k++;rightidx++;
        }
        
    }
    
}
