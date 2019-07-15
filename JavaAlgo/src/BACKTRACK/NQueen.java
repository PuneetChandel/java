package BACKTRACK;

/**
 *
 * @author pune7087
 */
public class NQueen {
    
    public static void main(String args[])
    {
        QPosition[] pos=placeQueens(4);
        
        for(int i=0;i<pos.length;i++)
        {
            System.out.print(pos[i].row + ":" + pos[i].col + " | ");
        }
    }
    
    public static boolean isSafe(int row, int col,QPosition[] pos )
    {
        // check for rows before the current row
        boolean result = true;
        for(int i =0; i< row;i++)
        {
                 if(
                        (pos[i].col==col) 
                    || (pos[i].row-pos[i].col == row-col) 
                    || (pos[i].row+pos[i].col == row+col)
                    )
                
                result=false;
                break;
            
        }
        
        return result;
    }
    
    public static boolean placeQueensUtil(int n,int row,QPosition[] pos )
    {
        // All queens have placed
        if(row==n)
            return true;
        
        // check each col in the row for safe spot
        for(int col=0; col< n; col++)
        {
            // if safe add to array and call recursive for next
            if(isSafe(row,col,pos))
            {
                pos[row]=new QPosition(row,col);
                
                if(placeQueensUtil(n,row+1,pos));
                    return true; // so the call will return true only if all childs are success
                                // if False is returned the Loop will continue for that row from where left to serach next place
            }
        }
        
        return false;// if no spot found in row. It will return false;
    }
            
    public static QPosition[] placeQueens(int n)
    {
        QPosition[] pos = new QPosition[n];
        
        
        if(placeQueensUtil(n,0,pos))
            return pos;
        else
            return null;
        
    }
    
}


class QPosition
{
    int row;
    int col;
    QPosition(int row, int col)
    {
        this.row=row;
        this.col=col;
                
    }
}