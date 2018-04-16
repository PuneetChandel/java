package algo.insertionSort;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= new int[]{5,2,3,10,22,1, 3,44,54,1,2,7,0};
		
		a= insertionSort(a);
		
		displaylist(a);

	}

	
	public static int[] insertionSort(int a[])
	{
		// j-> sorted side | i-> unsorted side. Move elements from unsorted to sorted
		int ele=0;
		int temp=0;
		for(int i=1; i<a.length;i++)
		{
			ele=a[i]; // element to compare
			
		    for(int j=i-1 ;j>=0;j--) // from last element in sorted to --> 0
		    {
		    	if (ele< a[j]) // if element is less than element in sorted side, shift elements
		    	{
		    		temp=a[j]; 
		    		a[j]=a[j+1]; // shift 
		    		a[j+1]=temp;
		    		
		    	}
		    }
		}
		
		return a;
	}
	
	public static void displaylist(int []a)
	{
		for (int x :a)
			System.out.println(x + " " );
	}
}
