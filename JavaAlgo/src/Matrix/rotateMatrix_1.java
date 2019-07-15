/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;


public class rotateMatrix_1 {
    
    public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first; // we need offset from the second itreation 
                                /*
                                for 4 X 4
                                a[00]= a[30]
                                
                                then second iteration
                                a[01]= a[20] so we need offset to adjust the last
                                a[02]=a[10]
                                
                                */
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = Utils.randomMatrix(3, 3, 0, 9);
		Utils.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		Utils.printMatrix(matrix);
	}


                 
    }
    

