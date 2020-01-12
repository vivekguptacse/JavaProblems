package leetcode.arrays.and.string.hard.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Sliding Window Maximum
 * 
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * 
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 
 * Output: [3,3,5,5,6,7]
 * 
 * Explanation:
 * 
 * Window position 			Max 
 * --------------- 			----- 
 * [1 3 -1] -3 5 3 6 7 		3 
 * 1 [3 -1 -3] 5 3 6 7 		3 
 * 1 3 [-1 -3 5] 3 6 7 		5 
 * 1 3 -1 [-3 5 3] 6 7 		5 
 * 1 3 -1 -3 [5 3 6] 7 		6 
 * 1 3 -1 -3 5 [3 6 7] 		7 
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * @author Vivek
 *
 */
public class SlidingWindowMaximum
{
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		if(k <= 1)
		{
			return nums;
		}
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2.compareTo(o1);
			}
		});
		
		int [] result = null;
		if(nums.length < k)
		{
			result = new int[k-1]; 
		}
		else
		{
			result = new int[nums.length - k + 1];
		}
		
		for(int i = 0 ; i < k ; i++)
		{
			priorityQueue.add(nums[i]);
		}
		
		result[0] = priorityQueue.peek();
		
		for(int i = k,j=1 ; i < nums.length ; i++,j++)
		{
			if(priorityQueue.size() >= k)
			{
				priorityQueue.remove(nums[i-k]);
			}
//			if(priorityQueue.contains(nums[i]))
//			{
//				priorityQueue.remove(nums[i-k]);
//			}
//			else
//			{
				priorityQueue.add(nums[i]);
//			}
			result[j] = priorityQueue.peek();
		}
		return result;
	}

	
	public static void main(String[] args)
	{
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int [] {-7,-8,7,5,7,1,6,0}, 4)));
	}
}
