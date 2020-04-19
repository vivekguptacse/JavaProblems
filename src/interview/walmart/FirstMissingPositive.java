package interview.walmart;

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
	
	public int firstMissingPositiveOn(int [] nums)
	{
		int size = nums.length;
		boolean isOnePresent = false;
		
		for(int i = 0 ; i < size ; i++)
		{
			if(nums[i] == 1)
			{
				isOnePresent = true;
			}
			else if(nums[i] <= 0 || nums[i] > size)
			{
				nums[i] = 1;
			}
		}
		
		if(!isOnePresent)
		{
			return 1;
		}
		
		
		for(int i = 0; i < size ; i++)
		{
			int index = Math.abs(nums[i]) - 1;
			
			if(nums[index] > 0)
			{
				nums[index] = -1 * nums[index];
			}
		}
		
		for(int i = 0 ; i < size ; i++)
		{
			if(nums[i] > 0)
			{
				return i+1;
			}
		}
		
		return size + 1;
	}
	
	public static void main(String[] args)
	{
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		System.out.println(firstMissingPositive.firstMissingPositiveOn(new int[] {7,8,9,5,6,3,4,2,1,0}));
	}
}
