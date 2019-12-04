package geeksforgeeks.arrays.problems;

import java.util.Arrays;

/**
 * 
 * Find maximum value of Sum( i*arr[i]) with only rotations on given array
 * allowed
 * 
 * Given an array, only rotation operation is allowed on array. We can rotate
 * the array as many times as we want. Return the maximum possbile of summation
 * of i*arr[i].
 * 
 * Examples :
 * 
 * Input: arr[] = {1, 20, 2, 10} Output: 72 We can 72 by rotating array twice.
 * {2, 10, 1, 20} 20*3 + 1*2 + 10*1 + 2*0 = 72
 * 
 * Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}; Output: 330 We can 330 by
 * rotating array 9 times. {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 0*1 + 1*2 + 2*3 ...
 * 9*10 = 330
 * 
 * 
 * @author Vivek.g
 *
 */
public class MaxSumWithOnlyRotation
{
	public int findMaxSum(int [] array)
	{
		int maxValIndex = findMaximumValueIndex(array);
		System.out.println(maxValIndex);
		System.out.println(Arrays.toString(array));
		rotate(array, maxValIndex);
		
		int result = 0; 
		for(int i =0 ; i< array.length ; i++)
		{
			result += i * array[i];
		}
		
		return result; 
	}

	private void rotate(int[] array, int maxValIndex)
	{
		for(int i = 0 ; i <= maxValIndex ;i++)
		{
			int temp = array[0];
			int j = 0;
			for(; j < array.length- 1; j++)
			{
				array[j] = array[j+1];
			}
			array[j]= temp;
		}
		
		System.out.println(Arrays.toString(array));
	}

	private int findMaximumValueIndex(int[] array)
	{
		int index = 0;
		int max = -1;
		for(int i = 0 ; i < array.length ; i++)
		{
			if(array[i] > max)
			{
				max = array[i];
				index = i;
			}
		}
		return index;
	}
	

	public static void main(String[] args)
	{
		MaxSumWithOnlyRotation maxSum = new MaxSumWithOnlyRotation();
		System.out.println(maxSum.findMaxSum(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
	}
}
