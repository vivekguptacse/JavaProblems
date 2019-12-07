package leetcode.arrays.easy.problems;

import java.util.Arrays;

/**
 * Rotate Array
 * 
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation: rotate
 * 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2 
 * Output: [3,99,-1,-100] 
 * Explanation: rotate 1
 * steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100] 
 * 
 * Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * @author Vivek
 *
 */
public class RotateArray
{

	public void rotate1(int[] nums, int k)
	{
		if(k == 0)
        {
            return;
        }
		for(int i= 0 ; i < k ; i++)
		{
			int temp = nums[nums.length - 1];
			int j = nums.length-1;
			for(; j > 0 ; j--)
			{
				nums[j] = nums[j-1];
			}
			nums[j] = temp;
		}
	}
	
	public void rotate2(int [] nums, int k)
	{
		reverse(nums,0 , nums.length -1);
		reverse(nums,0,k-1);
		reverse(nums, k, nums.length-1);
	}
	

	private void reverse(int[] nums, int start, int end)
	{
		while(start < end)
		{
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args)
	{
		RotateArray rotate = new RotateArray();
		int [] nums = new int[] {1,2,3,4,5,6,7};
		rotate.rotate2(nums, 3);
		
		System.out.println(Arrays.toString(nums));
	}

}
