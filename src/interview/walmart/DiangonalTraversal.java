package interview.walmart;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]


 * @author Vivek
 *
 */
public class DiangonalTraversal
{
	public int[] findDiagonalOrder(int[][] matrix) 
	{
		if(null == matrix || matrix.length == 0)
		{
			return new int[0];
		}
		
		int N = matrix.length;
		int M = matrix[0].length;
		
		int [] result = new int[N * M];
		
		int direction = 1; 
		int row = 0 , column = 0;
		int count = 0;
		
		while(row < N && column < M)
		{
			result[count++] = matrix[row][column];
			
			int newRow = row + (direction == 1 ? -1 : 1);
			int newColumn = column + (direction == 1 ? 1 : -1);
			
			if(newRow < 0 || newRow == N || newColumn < 0 || newColumn == M)
			{
				if(direction == 1)
				{
					row += (column == M-1 ? 1 :0);
					column += (column < M-1 ? 1: 0);
				}
				else
				{
					column += (row == N-1 ? 1 : 0);
					row += (row < N-1 ? 1 : 0);
				}
				
				direction = 1 - direction;
			}
			else
			{
				row = newRow;
				column = newColumn;
			}
			
		}
		
		
		return result;
        
    }
	
	
	
	
	public static void main(String[] args)
	{
		DiangonalTraversal diangonalTraversal = new DiangonalTraversal();
		
		int[] findDiagonalOrder = diangonalTraversal.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		
		System.out.println(Arrays.toString(findDiagonalOrder));
	}

}
