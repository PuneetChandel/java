package algo.binarySearch;

public class App {

	
	public static void main(String[] args) {
		
		int  a[] ={1,3,5,6,9,22};
		int x = 9;
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
	
        
          public static int binarySearch(int[] a, int k, int low, int high )
    {
       if(low<=high)
       {
           int mid = (high+low)/2;

           if(a[mid]>k)
               return binarySearch(a,k,low,mid-1);
           else if(a[mid]<k)
               return binarySearch(a,k,mid+1,high);
           else
               return mid;
       } 
       return -1;
    }
          
	
	
}
