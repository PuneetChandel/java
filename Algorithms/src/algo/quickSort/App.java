package algo.quickSort;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2,-1};
		//QuickSort qs= new QuickSort();
	
		//qs.quicksort(a, 0, a.length-1);
		qs2(a, 0, a.length-1);
		for(int x : a)
			System.out.println(x);
	}

	private static void qs(int a[], int low, int high)
	{
		if(low<high)
		{
			int pvt = partition(a,low,high);
			qs(a,low,pvt-1);
			qs(a,pvt+1,high);

		}
	}

	private static int partition(int a[], int low, int high)
	{
		int pvt=high;
		int j=low-1;
		while(low<high)
		{
			if(a[low]<=a[pvt])
			{
				j++;
				swap(a,j,low);
			}
			low++;
		}
		// swap last position with pivot
		swap(a,pvt,++j);

		return j;
	}

	private static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	private static void qs2(int nums[], int start, int end)
	{

		if(start<end)
		{
			int partition = partition2(nums,start,end);
			qs(nums,start, partition-1);
			qs(nums,partition+1, end);

		}
	}

	private static int partition2(int nums[], int start, int end)
	{
		int k=start-1;
		int pvt=end;

		while(start<=end)
		{
			if(nums[start] <= nums[pvt])
				swap2(nums,++k,start);
			start++;
		}

		swap2(nums,++k,pvt);

		return k;

	}

	private static void swap2(int nums[], int i, int j)
	{
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;

	}
}
