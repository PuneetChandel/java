package algo.mergeSort;

public class App {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2};
		//MergeSort ms= new MergeSort();
		//ms.mergesort(a);
		mergeSort(a,0,a.length-1);
		for(int x : a)
			System.out.println(x);
		
	}

	private static void mergeSort(int a[], int low, int high)
	{
		if(low<high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid - 1);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int a[], int low, int mid, int high)
	{
		int temp[] = new int[high-low+1];

		int left=low;
		int right=mid+1;
		int i=0;
		while(left<=mid && right<=high)
		{
			if(a[left]<a[right])
			{
				temp[i] = a[left];
				left++;
			}
			else
			{
				temp[i]=a[right];
				right++;
			}
			i++;
		}

		while(left<=mid)
		{
			temp[i]=a[left]; left++; i++;
		}
		while(right<=high)
		{
			temp[i]=a[right]; right++; i++;
		}

		for(int k=0;k<temp.length;k++)
			a[low+k]=temp[k];

	}

	

}
