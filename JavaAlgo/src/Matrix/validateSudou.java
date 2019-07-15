package Matrix;

/**
 *
 * @author pune7087
 */
public class validateSudou {
    
    
    public boolean isValidSudoku(char[][] board)
    {
        // check each col in each row
        
        
        for(int i=0; i<9; i++)
        {
            boolean c[]= new boolean[9];
            for(int j=0; j<9; j++)
            {
                if(board[i][j]!='.')
                {
                    if(c[board[i][j]-'1'])
                        return false;
                    else
                        c[board[i][j]-'1']=true;
                }
            }
        }
        
        // check each row in each col
        
        for(int j=0; j<9; j++)
        {
            boolean c[]= new boolean[9];
            for(int i=0; i<9; i++)
            {
                if(board[i][j]!='.')
                {
                    if(c[board[i][j]-'1'])
                        return false;
                    else
                        c[board[i][j]-'1']=true;
                }
            }
        }
        
        // check each block
        
          for(int block=0; block<9; block++)
        {
            boolean c[]= new boolean[9];
            
            for(int i=block/3*3; i<block/3*3+3; i++)
            {
                
                for(int j=block%3*3; j<block%3*3+3; j++)
                {
                    
                if(board[i][j]!='.')
                {
                    if(c[board[i][j]-'1'])
                        return false;
                    else
                        c[board[i][j]-'1']=true;
                }
            }
        }
        }
          
        
        
        return true;
    }
}
