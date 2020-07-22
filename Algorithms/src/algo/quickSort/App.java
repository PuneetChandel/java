package algo.quickSort;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2};
		//QuickSort qs= new QuickSort();
	
		//qs.quicksort(a, 0, a.length-1);
		qs(a, 0, a.length-1);
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
		j++;
		swap(a,pvt,j);

		return j;
	}

	private static void swap(int a[], int i, int j)
	{
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
