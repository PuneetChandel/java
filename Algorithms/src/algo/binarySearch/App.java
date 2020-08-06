package algo.binarySearch;

public class App {

	
	public static void main(String[] args) {
		
		int  a[] = new int[]{1,2,4,7,8,9,10,11,23};
		int x = 10;
		System.out.println("Find value "+ binSrch(a,x));
		System.out.println("Find value "+ binSrchrec(a,x,0,a.length-1));
		
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
		if (p <= r) // while start is less then end 
		{
			int q = (p+r)/2; // fetch the mid
			
			if (a[q]==x) // found match
				return q;
			else if(a[q]<x) 
				return binarySearchRecursive(a,x,p=q+1,r); // shift start
			else  
				return binarySearchRecursive(a,x,p,q-1); 
		}
		
		return -1;
	}
	
	public static int binSrch(int[] num, int x)
	{
		int start = 0;
		int end = num.length-1;


		while(start<=end)
		{
			int mid = (start+end)/2;
			if(num[mid]==x)
				return mid;
			else if(num[mid]<x)
				start=mid+1;
			else
				end=mid-1;
		}

		return -1;
	}

	public static int binSrchrec(int[] num, int x, int start, int end)
	{
		if(start>end) return -1;

		int mid = (start+end)/2;
		if(num[mid]==x)  return mid;

			if(num[mid]<x)
				return binSrchrec(num,  x,  mid+1, end);
			else
				return binSrchrec(num,  x,  start	, mid-1);

	}

	
}
