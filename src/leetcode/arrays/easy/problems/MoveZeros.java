package leetcode.arrays.easy.problems;

import java.util.Arrays;

/**
 * Move Zeroes
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] 
 * Output: [1,3,12,0,0] 
 * 
 * Note:
 * 1. You must do this in-place without making a copy of the array. 
 * 2. Minimize the total number of operations.
 * 
 * @author Vivek
 *
 */
public class MoveZeros
{
	/**
	 * This is a 2 pointer approach. The fast pointer which is denoted by variable
	 * "cur" does the job of processing new elements. If the newly found element is
	 * not a 0, we record it just after the last found non-0 element. The position
	 * of last found non-0 element is denoted by the slow pointer
	 * "lastNonZeroFoundAt" variable. As we keep finding new non-0 elements, we just
	 * overwrite them at the "lastNonZeroFoundAt + 1" 'th index. This overwrite will
	 * not result in any loss of data because we already processed what was there(if
	 * it were non-0,it already is now written at it's corresponding index,or if it
	 * were 0 it will be handled later in time).
	 * 
	 * After the "cur" index reaches the end of array, we now know that all the
	 * non-0 elements have been moved to beginning of array in their original order.
	 * Now comes the time to fulfil other requirement, "Move all 0's to the end". We
	 * now simply need to fill all the indexes after the "lastNonZeroFoundAt" index
	 * with 0.
	 * 
	 * @param nums
	 */
	public void moveZeroes1(int[] nums)
	{
		int lastNonZeroIndex = 0;
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			if(nums[i] != 0)
			{
				nums[lastNonZeroIndex++] = nums[i];
			}
		}
		
		for(int i = lastNonZeroIndex ; i < nums.length ; i++)
		{
			nums[i] = 0;
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	public void moveZeroes(int[] nums)
	{
		int start = 0;
		int end = nums.length;
		
		while(start < end)
		{
			if(nums[start] == 0)
			{
				rotate(nums, start , end);
				end--;
			}
			else
			{
				start++;
			}
		}
				
		System.out.println(Arrays.toString(nums));
	}
	
	public void rotate(int [] nums , int start , int end)
	{
		int temp = nums[start];
		int i = start;
		for(; i < end - 1 ; i++)
		{
			nums[i] = nums[i+1];
		}
		nums[i] = temp;
	}


	public static void main(String[] args)
	{
		MoveZeros moveZeros = new MoveZeros();
		moveZeros.moveZeroes1(new int[] {0,1,0,3,12});
	}

}
