package Matrix;

/**
 *
 * @author pune7087
 */

import java.util.*;
class TicTacToe {

    char board[][] ;
    Map<Integer,Character> map = new HashMap<>();
    
    public static void main(String args[])
    {
        TicTacToe t1= new TicTacToe(3);
        t1.move(0, 0, 1);
        t1.move(0, 2, 2);
        t1.move(2, 2, 1);
        t1.move(1, 1, 2);
        t1.move(2, 0, 1);
        t1.move(1, 0, 2);
        t1.move(2, 1, 1);

        
        
    }
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        
        board= new char[n][n];
        map.put(1,'0');
        map.put(2,'X');
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        board[row][col]= map.get(player);
        if(winner(row,col))
            return player;
        else
            return 0;
    }
    
    public boolean winner(int row, int col)
    {

        for(int i=0; i<board[0].length-1; i++)
        {
            if(board[row][i] != board[row][i+1])
                return false;
        }
        
        for(int i=0; i<board.length-1; i++)
        {
            if(board[i][col] != board[i+1][col])
                return false;
        }
        
        for(int i=0 ; i<board.length-1;i++)
        {
              if(board[i][i] != board[i+1][i+1])
                return false;
        }
        
        return true;
    }
        
            
    
}