package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class rotateArrayProblems {

    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};

        reverserotate(a, 4);
        //arrayReverse(a,0,a.length-1);
        //for(int x: a)
        //System.out.println(x);

        int b[] = {2, 3, 4, 5, 1};

        //System.out.println("MIn in rotate : "+ findMinInRotatedSorted(b));
        System.out.println("find in rotate : " + SearchInRotatedSorted(b, 1));

    }

    static void rotatewithArry(int[] a, int k) {
        if (k > a.length) {
            k = k % a.length;
        }

        int b[] = new int[a.length];
        int y = 0;

        for (int i = a.length - k; y < k; i++, y++) {
            b[y] = a[i];
        }

        for (int i = 0; y < b.length; y++, i++) {
            b[y] = a[i];
        }

        System.arraycopy(b, 0, a, 0, a.length);

    }

    static void rotateinplcae(int[] a, int k) {

        if (k > a.length) {
            k = k % a.length;
        }

        for (int j = 0; j < k; j++) {

            int last = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = last;
        }
    }

    static void reverserotate(int arr[], int k) {
        if (k > arr.length) {
            k = k % arr.length;
        }

        int idx = arr.length - k;
        arrayReverse(arr, 0, idx - 1);
        arrayReverse(arr, idx, arr.length - 1);
        arrayReverse(arr, 0, arr.length - 1);

    }

    static void arrayReverse(int arr[], int left, int right) {
        if (arr == null || arr.length == 1) {
            return;
        }

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static int findMinInRotatedSorted(int a[]) {
        if (a.length == 0 || a == null) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (a[low] <= a[high]) {
                return a[low];
            }

            if (a[mid] < a[low]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

    static int SearchInRotatedSorted(int a[], int k) {
        if (a.length == 0 || a == null) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid] == k)
                return mid;
            
            if(a[low]<=a[mid])
            {
                if(k<a[mid] && k>=a[low])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                if(k> a[mid] && k <=a[high])
                    low=mid+1;
                else
                    high=mid-1;
            }

         

        }

        return -1;
    }

}
