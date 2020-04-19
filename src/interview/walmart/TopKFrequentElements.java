package interview.walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Top K Frequent Elements
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2 
 * Output: [1,2] 
 * 
 * Example 2:
 * Input: nums = [1], k = 1 
 * Output: [1] 
 * 
 * Note:
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
 * 2. Your algorithm's time complexity must be better than O(n log n), where n is the
 * array's size.
 * 
 * 
 * @author Vivek
 *
 */
public class TopKFrequentElements
{
	public List<Integer> topKFrequent(int[] nums, int k)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		if(null == nums || nums.length == 0)
		{
			return result;
		}
		
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		
		for(int num : nums)
		{
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));
		
		for(int num : frequencyMap.keySet())
		{
			priorityQueue.offer(num);
			if(priorityQueue.size() > k)
			{
				priorityQueue.poll();
			}
		}
		
		while(!priorityQueue.isEmpty())
		{
			result.add(priorityQueue.poll());
		}
		
		return result;

	}
	
	public static void main(String[] args)
	{
		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
		System.out.println(topKFrequentElements.topKFrequent(new int [] {1,1,1,1,2,2,2,3,3,4,4,4,4,4,4,4},2));
	}
}
