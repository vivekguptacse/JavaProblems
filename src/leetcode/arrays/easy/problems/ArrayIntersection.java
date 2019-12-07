package leetcode.arrays.easy.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] 
 * Output: [2,2] 
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 
 * Output: [4,9] 
 * 
 * Note:
 * 1. Each element in the result should appear as many times as it shows in both
 * arrays. 
 * 2. The result can be in any order. 
 * 
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your
 * algorithm? 
 * 2. What if nums1's size is small compared to nums2's size? Which
 * algorithm is better? 
 * 3. What if elements of nums2 are stored on disk, and the memory is limited 
 * such that you cannot load all elements into the memory at once?
 * 
 * @author Vivek
 *
 */
public class ArrayIntersection
{
	public int[] intersect(int[] nums1, int[] nums2)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : nums1)
		{
			map.merge(num, 1, Integer::sum);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int num : nums2)
		{
			if(map.containsKey(num) && map.get(num) > 0)
			{
				list.add(num);
				map.merge(num, -1, Integer::sum);
			}
		}
		
		int [] result = new int[list.size()];
		int i=0;
		for(Integer num : list)
		{
			result[i++] = num;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		ArrayIntersection inter = new ArrayIntersection();
		int[] intersect = inter.intersect(new int[] {9,4,9,8,4}, new int[] {4,9});
		
		System.out.println(Arrays.toString(intersect));
	}
}
