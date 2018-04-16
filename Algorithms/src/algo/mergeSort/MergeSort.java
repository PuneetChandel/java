package algo.mergeSort;

public class MergeSort {

	
	public void mergesort(int a[])
	{
		sort(a,0,a.length-1);	
	}
	
	
	public void sort(int a[], int start, int end)
	{
		if(end<=start)
			return;
		int mid= (start+end)/2;
		sort(a,start,mid);
		sort(a,mid+1,end);
		merge(a,start,end,mid);
	}
	
	public  void  merge(int a[], int start , int end, int mid)
	{
		int temp[] = new int[end-start+1];
		
		int k=0;
		int leftidx=start;
		int rightidx=mid+1;
		
		while(leftidx <=mid && rightidx<=end)
		{
			if(a[leftidx] < a[rightidx])
			{
				temp[k]=a[leftidx];
				leftidx++;
			}
			else
			{
				temp[k]=a[rightidx];
				rightidx++;		
			}
			k++;
		}
		
		if (leftidx<=mid)
		{
			while(leftidx<=mid)
			{
			temp[k]=a[leftidx];
			k++;
			leftidx++;
			}
		}
		
		if(rightidx<=end)
		{
			while(rightidx<=end)
			{
			temp[k]=a[rightidx];
			k++;
			rightidx++;
			}
		}
		
		for (int i=0; i<temp.length;i++)
		{
			a[start+i]=temp[i];
		}
		
		
	}
	
}
