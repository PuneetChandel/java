package algo.quickSort;

public class QuickSort {
	
		
	
	public void quicksort(int[] a, int p , int r)
	{
		// p, r
		if(p<r){
		int q=partition(a,p,r); // idx for correctly placed pivot value 
		quicksort(a,p,q-1); // left 
		quicksort(a,q+1,r); // right
		}
	}
	
	public int partition(int[] a, int p , int r)
	{
		int q = a[r]; // pivot
		
		int i = p-1; // starting point
		
		
		
		int temp=0;
		for(int j=p; j<=r-1; j++)
		{
			if( a[j] <= q)
			{
				i++;
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		
		// place the pivot at the correct slot, all elements on left of this idx is less than pivot
		temp=a[i+1];
		a[r]=temp;
		a[i+1]=q;
		
		
		return i+1;		
		
	}
	

}
