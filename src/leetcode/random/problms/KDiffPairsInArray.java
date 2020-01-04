package leetcode.random.problms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * K-diff Pairs in an Array
 * 
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * 
 * Example 1: 
 * Input: [3, 1, 4, 1, 5], k = 2 
 * Output: 2 
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5). 
 * Although we have two 1s in the input, we should only return the number 
 * of unique pairs. 
 * 
 * Example 2: Input:[1, 2, 3, 4, 5], k = 1 
 * Output: 4 
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5). 
 * 
 * Example 3: 
 * Input: [1, 3, 1, 5, 4], k = 0 
 * Output: 1 
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * Note: 
 * 1. The pairs (i, j) and (j, i) count as the same pair. 
 * 2. The length of the array won't exceed 10,000. 
 * 3. All the integers in the given input belong to the range: [-1e7, 1e7].
 * 
 * @author Vivek
 *
 */
public class KDiffPairsInArray
{
	public int findPairs(int[] nums, int k)
	{
		Arrays.sort(nums);
		
		List<List<Integer>> pairs = new ArrayList<>();
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			for(int j = i + 1; j < nums.length ; j++)
			{
				if((nums[j] - nums[i]) ==  k )
				{
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					pairs.add(list);
					break;
				}
			}
		}
		
		Set<List<Integer>> set = new HashSet<>();
		
		for(List<Integer> list : pairs)
		{
			set.add(list);
		}
		
//		System.out.println(set);
		
		return set.size();
	}
	
	public int findPairsUsingSet(int[] nums, int k)
	{
		Set<Integer> initialVal = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			initialVal.add(nums[i]);
		}
		
		for(int i=0 ; i < nums.length ; i++)
		{
			int target = k + nums[i];
			
			if(initialVal.contains(target))
			{
				List<Integer> list = new ArrayList<>();
				list.add(nums[i]);
				list.add(target);
				result.add(list);
			}
		}
		
		Set<List<Integer>> set = new HashSet<>();
		
		for(List<Integer> list : result)
		{
			set.add(list);
		}
		
//		System.out.println(set);
		
		return set.size();
	}
	
	public static void main(String[] args)
	{
		KDiffPairsInArray array = new KDiffPairsInArray();
		System.out.println(array.findPairsUsingSet(new int[] {3, 1, 4, 1, 5}, 2));
	}
}
