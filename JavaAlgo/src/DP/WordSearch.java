package DP;

/**
 *
 * @author pune7087
 */
public class WordSearch {
   
    public boolean exist(char[][] board, String word) {
    
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]== word.charAt(0))
                {
                    if(checkNeighbor(board,i,j,word,0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean checkNeighbor(char[][] board, int i, int j, String word, int k)
    {
        if(k==word.length())
            return true;
        
        if(i<0|| i>=board.length || j<0|| j >= board[0].length)
            return false;
        
        if(board[i][j]!=word.charAt(k))
            return false;
        
        char temp = board[i][j]; 
        board[i][j] = '#';
        
        if(checkNeighbor(board,i-1,j,word,k+1) 
           || checkNeighbor(board,i+1,j,word,k+1) 
           || checkNeighbor(board,i,j+1,word,k+1) 
           || checkNeighbor(board,i,j-1,word,k+1) 
                )
            return true;
        
        board[i][j]=temp;
        
        return false;
    }
}

