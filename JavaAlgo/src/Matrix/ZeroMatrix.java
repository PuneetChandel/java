/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;


public class ZeroMatrix {
    
    public static void main(String args[])
    {
        	int[][] matrix = Utils.randomMatrix(3, 4, 0, 7);
		Utils.printMatrix(matrix);
                ZeroMatrix.zeroArray(matrix);
    }
    
    private static void zeroArray(int a[][])
    {
        
        // first we need to check firts row and col and treat them separately. If we start from 1row we will mark them zero
        // and while nullifying we will make row1 null because of nullifying some other value
        // that will result in complete array to be null. Same for col
        // example if a[0][0] is zero we would want only 1 row and col as zero, but if we start from 1st we will mark first row and col to be zero
        // and will nullify them. when we chck what rows to null it will give all of them 0,1,2,3 as we have nullify all
        // This is becuse we dont want to alter our placeholders for rows and col to null. Treat them like separate arrays
        
        	boolean rowHasZero = false;
		boolean colHasZero = false;		
		
		// Check if first row has a zero
		for (int j = 0; j < a[0].length; j++) {
			if (a[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}		
		
		// Check if first column has a zero
		for (int i = 0; i < a.length; i++) {
			if (a[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}		
                
        for(int i=1; i<a.length; i++)
        {
            for(int j=1; j< a[0].length; j++)
            {
                if(a[i][j]==0)
                {
                    a[i][0]=0; // first col in matrix will tell which row to nullify
                    a[0][j]=0; // first row in matrix will tell which col to nullify
                }
            }
        }
        
       System.out.println("--------------");
        
      // Nullify rows based on values in first column
      for(int i=1; i < a.length;i++)
       {
          if(a[i][0]==0)
              nullifyRow(a,i);
       }
      
      
    // Nullify columns based on values in first row
       for(int k=1; k < a[0].length;k++)
       {
          if(a[0][k]==0)
              nullifyColumn(a,k);
       }
      
       if (rowHasZero) {
			nullifyRow(a, 0);
		}
		
		// Nullify first column
		if (colHasZero) {
			nullifyColumn(a, 0);
		}
                
    
      System.out.println("--------------");
       
              Utils.printMatrix(a);

                        
    }
  
    
    public static void nullifyColumn(int[][] matrix, int col) {
		for(int i=0; i<matrix.length; i++)
                    matrix[i][col]=0;
                
	}	
    
    public static void nullifyRow(int[][] matrix, int row) {
		for(int i=0; i<matrix[0].length; i++)
                    matrix[row][i]=0;
                
	}	
    
}
