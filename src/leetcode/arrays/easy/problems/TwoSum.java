package leetcode.arrays.easy.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Vivek
 *
 */
public class TwoSum
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < nums.length ; i++)
		{
			List<Integer> list = new ArrayList<>();
//			if(nums[i] < target)
//			{
				if(map.containsKey(nums[i]))
				{
					list = map.get(nums[i]);
				}

				list.add(i);
				map.put(nums[i], list);
//			}
		}
		
		Arrays.sort(nums);
		
		int start = 0; 
		int end = nums.length-1;
		
		int []result = new int[2];
		while(start < end)
		{
			if(nums[start] + nums[end] == target)
			{
				if(nums[start] == nums[end])
				{
					result[0] = map.get(nums[start]).get(0);
					result[1] = map.get(nums[end]).get(1);
				}
				else
				{
					result[0] = map.get(nums[start]).get(0);
					result[1] = map.get(nums[end]).get(0);
				}
				break;
			}
			else if(nums[start] + nums[end] < target)
			{
				start++;
			}
			else
			{
				end--;
			}
		}
		
		return result;
	}
	
	/**
	 * we can do it in one-pass. While we iterate and inserting elements into the
	 * table, we also look back to check if current element's complement already
	 * exists in the table. If it exists, we have found a solution and return
	 * immediately.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i< nums.length ; i++)
		{
			int compliment = target - nums[i];
			if(map.containsKey(compliment))
			{
				return new int[] {map.get(compliment),i};
			}
			
			map.put(nums[i], i);
		}
		
		
		return null;
	}
	
	public static void main(String[] args)
	{
		TwoSum sum = new TwoSum();
		int[] twoSum = sum.twoSum1(new int[] {2, 7, 11, 15}, 9);
		
		System.out.println(Arrays.toString(twoSum));
	}
}
