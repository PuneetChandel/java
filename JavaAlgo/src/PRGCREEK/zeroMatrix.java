package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class zeroMatrix {
    
    public static void main(String args[])
    {
        
        int matrix[][] = new int[4][4];
        
    }
    
    public static void zeroMatrix(int[][] matrix)
    {
        boolean firstRowzero=false;
        boolean firstColzero=false;
        
        for(int i=0; i<matrix[0].length;i++)
        {
            if (matrix[0][i]==0)
            {
                firstRowzero=true;
                break;
             }
        }
        
        for(int i=0; i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
                firstColzero=true;
            break;
        }
        
        for(int row=1; row<matrix.length; row++)
        {
            for(int col=1; col<matrix[0].length;col++)
            {
                if(matrix[row][col]==0)
                {
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }
        
        //nullify row 
        for(int row=1; row<matrix.length;row++)
        {
            if(matrix[row][0]==0)
                zeroRow(matrix,row);
        }
        
        //col
        for(int col=1; col<matrix[0].length;col++)
        {
            if(matrix[0][col]==0)
                zeroCol(matrix,col);
        }
        
        if(firstRowzero)
            zeroRow(matrix,0);
        if(firstColzero)
            zeroCol(matrix, 0);
        
    }
    
    public static void zeroRow(int matrix[][], int row)
    {
        for(int  i=0; i<matrix[0].length; i++)
        {
          matrix[row][i]=0;
        }
    }
    
    public static void zeroCol(int matrix[][], int col)
    {
        for(int  i=0; i<matrix.length; i++)
        {
          matrix[i][col]=0;
        }
    }
     
}
