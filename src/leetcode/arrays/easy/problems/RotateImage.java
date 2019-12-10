package leetcode.arrays.easy.problems;

import java.util.Arrays;

/**
 * Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = [ [1,2,3], 
 * 						  [4,5,6], 
 * 						  [7,8,9] ],
 * 
 * rotate the input matrix in-place such that it becomes: 
 *  					[ [7,4,1], 
 *  					  [8,5,2],
 *  					  [9,6,3] ] 
 *  
 *  Example 2:
 * 
 * Given input matrix =   [	[ 5, 1, 9,11], 
 * 						  	[ 2, 4, 8,10], 
 * 							[13, 3, 6, 7],
 * 							[15,14,12,16] ],
 * 
 * rotate the input matrix in-place such that it becomes: 
 * 						 [ 	[15,13, 2, 5], 
 * 							[14, 3, 4, 1], 
 * 							[12, 6, 8, 9], 
 * 							[16, 7,10,11] ]
 * 
 * @author Vivek
 *
 */
public class RotateImage
{

	public void rotate(int[][] matrix)
	{
		int row = matrix.length-1;
		int column = matrix[0].length-1;
		
		for(int i = 0 ; i <= row/2 ; i++ )
		{
			for(int j = 0 ; j <= column ; j++)
			{
				// Swap
				int temp = matrix[i][j];
				matrix[i][j] = matrix[row-i][j];
				matrix[row-i][j] = temp;
				
			}
		}
		
		for(int i = 0 ; i <= row ; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		for(int i=0, j= 0 ; i <= row && j <= column ; i++, j++)
		{
			for(int k = j; k <= column ; k++)
			{
				int temp = matrix[i][k];
				matrix[i][k] = matrix[k][i];
				matrix[k][i] = temp;
			}
		}
		
		for(int i = 0 ; i <= row ; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}

	}
	
	
	public static void main(String[] args)
	{
		RotateImage rotateImage = new RotateImage();
		
//		int [][]matrix =new int[][]{{1,2,3}, 
//									{4,5,6}, 
//									{7,8,9} };
									
		int [][] matrix=new int[][]{{ 5, 1, 9,11},
									{ 2, 4, 8,10},
									{13, 3, 6, 7},
									{15,14,12,16}};
		rotateImage.rotate(matrix);
	}

}
