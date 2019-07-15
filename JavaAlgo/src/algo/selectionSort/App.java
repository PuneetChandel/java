package algo.selectionSort;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []a = new int []{4,5,8,8,1,34,2,3,88};
		
		a = selectionSort(a);
		
		for(int x : a)
		{
			System.out.print(x + " ");
		}

	}

	public static int[] selectionSort(int a[])
	{
		int temp=0;
		for (int i=0;i<a.length;i++)
		{
			int min=i; // find the smallest number
			for (int j = i+1; j<a.length;j++)
			{
				if (a[j]<a[min])
				 min=j;
			}
			// move the smallest item to start of array at each iteration
			temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			
		}
		return a;
		
	}
	
}
