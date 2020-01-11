package leetcode.arrays.and.string.hard.problems;

/**
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * Input: [1,2,0] 
 * Output: 3 
 * 
 * Example 2:
 * Input: [3,4,-1,1] 
 * Output: 2 
 * 
 * Example 3:
 * Input: [7,8,9,11,12] 
 * Output: 1 
 * 
 * Note:Your algorithm should run in O(n) time and uses constant extra space.
 * 
 * @author Vivek
 *
 */
public class FirstMissingPositive
{
	public int firstMissingPositive(int[] nums)
	{
		if(nums.length == 0)
		{
			return 1;
		}
		
		int [] temp = new int [nums.length + 1];
		
		for(int i =0 ; i  < nums.length ; i++)
		{
			if(nums[i] > 0 && nums[i] <= nums.length)
			{
				temp[nums[i]] = Integer.MAX_VALUE;
			}
		}
		
		int i = 1 ;
		for(; i <= nums.length ; i++)
		{
			if(temp[i] != Integer.MAX_VALUE)
			{
				return i;
			}
		}
		return i;
	}
	
	public static void main(String[] args)
	{
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1}));
	}
}
