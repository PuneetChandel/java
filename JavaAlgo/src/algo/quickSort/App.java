package algo.quickSort;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[]{9,1,7,4,3,6,8,2,22,33,5,2,77,2};
		
                //int a[] = {3,1,2};
		
                
               // QuickSort qs= new QuickSort();
	
		//qs.quicksort(a, 0, a.length-1);
	
             //QSV1 qsv = new QSV1();
             //qsv.qs(0, a.length-1,a);
                
           //  for(int x : a)
            //		System.out.println(x);
             
                 QSTry qst= new QSTry();
                 qst.quickSort(a, 0, a.length-1);
                       for(int x : a)
			System.out.println(x);
	}

}
