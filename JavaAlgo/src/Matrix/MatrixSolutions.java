package Matrix;

/**
 *
 * @author pune7087
 */
public class MatrixSolutions {
 
     public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) 
                return true;
 
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 
        return false;
    }
     
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][]dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        // initialize first row in dp
        for(int i=1; i<n ; i++)
            dp[0][i]=dp[0][i-1]+ grid[0][i];
        
        // initialze first col
        for(int i=1; i<m ; i++)
            dp[i][0]=dp[i-1][0]+ grid[i][0];
        
        
        // fill rest with the min value from the neighbour and value of the cell
        for(int i=1; i< m ; i++)
        {
            for(int j=0; j<n ; j++)
            {
                if(dp[i-1][j]> dp[i][j-1])
                    dp[i][j]=dp[i][j-1] + grid[i][j];
                else
                    dp[i][j]=dp[i-1][j] + grid[i][j];  
            }
        }
        
        return dp[m-1][n-1];
    }
    
      public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i< n;i++)
            dp[0][i]=1;
        
        for(int i=0; i< m;i++)
            dp[i][0]=1;
        
        for(int i=1;i<m ; i++)
        {
            for(int j=1; j<n; j++)
            {
                dp[i][j] = dp[i-1][j]+ dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
      
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
            return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0]=1;
            
        for(int i=1; i< n;i++)
        {   if(obstacleGrid[0][i]!=1)
               dp[0][i]=dp[0][i-1];
            else
            
               dp[0][i]=0;
            
        }
        
        for(int i=1; i< m;i++)
        {
             if(obstacleGrid[i][0]!=1)
               dp[i][0]=dp[i-1][0];
            else
           
               dp[i][0]=0;
           
        }
        
        for(int i=1;i<m ; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(obstacleGrid[i][j]!=1)
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1];
                else
                    dp[i][j]=0;  
                
            }
        }
        
            return dp[m-1][n-1];
    }
    
      
       
    public int numIslands(char[][] grid) {
    
        if(grid==null || grid.length==0||grid[0].length==0)
            return 0;
        
        int result=0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i< m; i++)
        {
            for(int j=0; j< n ; j++)
            {
                if(grid[i][j]=='1')
                {
                    result++; // we will only get another if with previpus merge call not all get merged.
                              // so that count is no of islands
                    merge(grid,i,j);
                }
            }
        }
        
        return result;
        
    }
    
    public static void merge(char[][] grid, int i , int j)
    {
      
        if(i<0 || j<0 || i>=grid.length-1 || j>=grid[0].length-1)
            return;
        
          if(grid[i][j]!='1')
            return;
        
          
        grid[i][j]='X'; // This is to mark all 1's with X so its not counted again
        
        // mark all neighbors as X if they are all 1 which is checked at first setp
       
        merge(grid,i-1,j);
        merge(grid,i+1,j);
       
        merge(grid,i,j-1);
        merge(grid,i,j+1);
        
    }
         
      
}
