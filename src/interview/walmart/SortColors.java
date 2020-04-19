package interview.walmart;

import java.util.Arrays;

/**
 * 
 * Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example: 
 * Input: [2,0,2,1,1,0] 
 * Output:[0,0,1,1,2,2] 
 * 
 * 
 * Follow up:
 * 1. A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's. 
 * 2. Could you come up with a one-pass algorithm using only constant space?
 * 
 * @author Vivek
 *
 */
public class SortColors
{
	public void sortColors(int[] nums)
	{
		int left = 0;
		int right = nums.length -1;
		int mid = 0;
		int temp = 0;
		while(mid <= right)
		{
			switch (nums[mid])
			{
			case 0:
				temp = nums[left];
				nums[left] = nums[mid];
				nums[mid] = temp;
				left++;
				mid++;

				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[mid];
				nums[mid] = nums[right];
				nums[right] = temp;
				right--;
				break;

			}
		}
	}
	
	public static void main(String[] args)
	{
		SortColors sortColors = new SortColors();
		int [] input = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortColors.sortColors(input);
		System.out.println(Arrays.toString(input));
	}

}
