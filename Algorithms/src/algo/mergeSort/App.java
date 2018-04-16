package algo.mergeSort;

public class App {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2};
		MergeSort ms= new MergeSort();
		ms.mergesort(a);
		
		for(int x : a)
			System.out.println(x);
		
	}
	
	

}
