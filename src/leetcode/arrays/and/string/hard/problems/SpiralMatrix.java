package leetcode.arrays.and.string.hard.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1: 
 * Input: [ [ 1, 2, 3 ], 
 * 			[ 4, 5, 6 ], 
 * 			[ 7, 8, 9 ] ] 
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * Input: [ [1, 2, 3, 4], 
 * 			[5, 6, 7, 8], 
 * 			[9,10,11,12] ] 
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Vivek
 *
 */
public class SpiralMatrix
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> result = new ArrayList<>();
		int left = 0;
		int bottom = matrix.length -1 ;
		if(bottom < 0)
        {
            return result;
        }
		int top = 0;
		int right = matrix[0].length -1;
		
		int direction = 0;
		
		for(int i = 0 ; i < (matrix.length * matrix[0].length) ; )
		{
			if(direction == 0)
			{
				for(int j = left ; j <= right ; j++)
				{
					result.add(matrix[top][j]);
					i++;
				}
				top++;
			}
			else if(direction == 1)
			{
				for(int j = top ; j <= bottom  ; j++)
				{
					result.add(matrix[j][right]);
					i++;
				}
				right--;
			}
			else if(direction == 2)
			{
				for(int j = right ; j >= left ; j--)
				{
					result.add(matrix[bottom][j]);
					i++;
				}
				bottom--;
			}
			else if(direction == 3)
			{
				for(int j = bottom ; j >= top ; j--)
				{
					result.add(matrix[j][left]);
					i++;
				}
				left++;
			}
			
			direction = (direction +1) % 4;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		SpiralMatrix spiralMatrix = new SpiralMatrix();

//		List<Integer> spiralOrder = spiralMatrix.spiralOrder(new int[][]
//		{
//				{ 1, 2, 3 , 4 , 5, 6},
//				{ 7, 8, 9 ,10 ,11,12},
//				{13,14,15 ,16 ,17,18},
//				{ 27, 58, 39 ,410 ,211,612},
//				{ 37, 58, 59 ,310 ,411,412},
//				{ 47, 48, 69 ,210 ,511,112},
//				{ 67, 38, 79 ,110 ,611,212},
//				});
		
		List<Integer> spiralOrder = spiralMatrix.spiralOrder(new int[][]
				{
						{ 7},
						{ 9},
						{6},
						});


		System.out.println(spiralOrder);
	}

}
