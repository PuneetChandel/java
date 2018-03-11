package algo.linearSearch;

public class App {

	public static void main(String[] args) {
		int[] a ={1,2,3,4,5};
		
		System.out.println(" simple search : "+ linearSearch(a, 5) );
		
		System.out.println(" recursive search: "+ linearSearchRecursive(a,0,5) );
	}
	
	
	public static int linearSearch(int[] a,int x)
	{	
		
		for(int i=0; i<a.length;i++)
		{
			if (a[i]==x)
				return i;
		}

		return -1;
	}
	
	public static int linearSearchRecursive(int [] a ,int i, int x)
	{
		if (i < a.length)
		{
			if(a[i] == x)
				return i;
	
			return linearSearchRecursive(a,i+1,x);
		}
		
		return -1;
	}
	
}

// O(n) = n 