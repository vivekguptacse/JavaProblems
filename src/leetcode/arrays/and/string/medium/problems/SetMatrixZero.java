package leetcode.arrays.and.string.medium.problems;

import java.util.Arrays;

/**
 * Set Matrix Zeroes
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 * 
 * Example 1: 
 * Input: [ 
 * 			[1,1,1], 
 * 			[1,0,1], 
 * 			[1,1,1] ] 
 * Output: [ 
 * 			[1,0,1], 
 * 			[0,0,0], 
 * 			[1,0,1] ]
 * 
 * Example 2:
 * Input: [ 
 * 			[0,1,2,0], 
 * 			[3,4,5,2], 
 * 			[1,3,1,5] ] 
 * Output: [ 
 * 			[0,0,0,0], 
 * 			[0,4,5,0],
 * 			[0,3,1,0] ]
 * 
 * @author Vivek
 *
 */
public class SetMatrixZero
{
	
	public void setZeroes(int[][] matrix)
	{
		
		int uniqueNumber = Integer.MIN_VALUE + "vivek".hashCode();
		
		int row = matrix.length;
		int colum = matrix[0].length;
//		for(int i = 0 ; i < row ; i++)
//		{
//			System.out.println(Arrays.toString(matrix[i]));
//		}
		
//		System.out.println();
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < colum ; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[i][j] = uniqueNumber;
				}
			}
		}
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < colum ; j++)
			{
				
				if(matrix[i][j] == uniqueNumber)
				{
					for(int k = 0 ; k < colum ; k++)
					{
						if(matrix[i][k] != uniqueNumber)
						{
							matrix[i][k] = 0;
						}
					}
					for(int l = 0 ; l < row ; l++)
					{
						if(matrix[l][j] != uniqueNumber)
						{
						  matrix[l][j] = 0;
						}
					}
				}
			}
		}
		
		for(int i = 0 ; i < row ; i++)
		{
			for(int j = 0 ; j < colum ; j++)
			{
				if(matrix[i][j] == uniqueNumber)
				{
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 0 ; i < row ; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	public static void main(String[] args)
	{
		SetMatrixZero setMatrixZero = new SetMatrixZero();
		setMatrixZero.setZeroes(new int[][] {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}});
	}

}
