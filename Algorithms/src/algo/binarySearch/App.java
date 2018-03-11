package algo.binarySearch;

public class App {

	
	public static void main(String[] args) {
		
		int  a[] = new int[]{1,2,4,7,8,9,10,11,23};
		int x = 10;
		System.out.println("Find value "+ binarySearch(a,x));
		System.out.println("Find value "+ binarySearchRecursive(a,x,0,a.length-1));
		
	}
	
	public static int binarySearch(int[] a, int x)
	{
		// p q r
		int p=0; // start
		int r= a.length -1; // end	
		
		int q =0; //mid point
		
		while(p <= r) // while start is less then end 
		{
			q = (p+r)/2; // fetch the mid
			
			if (a[q]==x) // found match
				return q;
			else if(a[q]<x) 
				p=q+1; // shift start
			else  
				r=q-1; // shift end
		}
		
		return -1;
		
	}
	
	public static int binarySearchRecursive(int[] a, int x, int p, int r)
	{
		int q =0; //mid point
		
		if (p <= r) // while start is less then end 
		{
			q = (p+r)/2; // fetch the mid
			
			if (a[q]==x) // found match
				return q;
			else if(a[q]<x) 
				return binarySearchRecursive(a,x,p=q+1,r); // shift start
			else  
				return binarySearchRecursive(a,x,p,q-1); 
		}
		
		return -1;
		
	}
	
	
	
}
