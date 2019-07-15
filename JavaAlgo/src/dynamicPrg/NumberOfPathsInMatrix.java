/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NumberOfPathsInMxNMatrix.java
 * @author pune7087
 * 
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * go from 1 - 16 , ie left most to right most
 * 
 * You can only traverse down or right 
 * Number of ways for each point from top leftmost can be calculated as:
 * 
 * 
 * 1 1 1 1      
 * 1 2 3 4
 * 1 3 6 10 -> we add number of paths to previous points from where you can reach to current point
 * 1
 * 
 * so formula will be 
 * to reach m[row][col] = m[row-1][col] + m[row][col-1]
 */
import java.util.ArrayList;
public class NumberOfPathsInMatrix {
    static int[][]mem;
    
    public static void main(String[] args)
    {
        int m =4;
        int n =4;
        mem=new int[m][n];
        System.out.println(" result : " + totalpathsMem(m, n));           
    }
    
    public static int totalpaths(int row, int col)
    {
        if(row==1 || col ==1)
            return 1;
        else
            return totalpaths(row-1,col)+ totalpaths(row,col-1);
    }
    
    public static int totalpathsMem(int row, int col)
    {
        int result =0;
        
        if (mem[row-1][col-1] !=0)
            return mem[row-1][col-1];
        
        if(row==1 || col ==1)
            result=1;
        else
            result=totalpathsMem(row-1,col)+ totalpathsMem(row,col-1);
        
        mem[row-1][col-1]=result;
        return result;
    }
    
    
    // find path for robot, but there are few cells that are off limit
    public static ArrayList pathforRobot()
    {
        int m=4; int n =4;
        boolean maze[][]= new boolean[m][n];
        //some cells can be set with value false to mention off limit
        ArrayList path = new ArrayList();
        
        if(getPathRobot(maze,maze.length,maze[0].length,path))
            return path;
        
        return null;
            
    }
    
    public static boolean getPathRobot(boolean [][]maze, int r, int c,ArrayList path)
    {
      
        // if not available or out of bound
        if(!maze[r][c] || r < 0 || c <0 )
            return false;

           // if there is path to previos point or its origin
        if(getPathRobot(maze,r-1,c,path) || getPathRobot(maze,r,c-1,path) || (r==0 && c==0))
        {
            path.add(new Point(r,c));
            return true;
        }
        
        return false;
    }
    
        public static boolean getPathRobotMem(boolean [][]maze, int r, int c,ArrayList path)
    {
      
        // if not available or out of bound
        if(!maze[r][c] || r < 0 || c <0 )
            return false;

           // if there is path to previos point or its origin
        if(getPathRobotMem(maze,r-1,c,path) || getPathRobotMem(maze,r,c-1,path) || (r==0 && c==0))
        {
            path.add(new Point(r,c));
            return true;
        }
        
        return false;
    }
    
        
}

class Point{
    int r;
    int c;
    
    public Point(int r, int c)
    {
        this.r=r;
        this.c=c;
    }
}