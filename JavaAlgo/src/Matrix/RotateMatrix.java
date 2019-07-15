package Matrix;

/**
 *
 * @author pune7087
 */
public class RotateMatrix {
    
    
    public static void main(String[] args)
    {
        
        System.out.print(1%3);
        
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols
        
        for(int level=0; level<m/2; level++)
        {
            int first=level;
            int last=n-1-level;
            
            for(int i=level; i<last; i++  )
            {
                int offset = i-first;
                int temp = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset]=matrix[i][last];
                matrix[i][last]=temp;
                
            }
        }
    }
}
