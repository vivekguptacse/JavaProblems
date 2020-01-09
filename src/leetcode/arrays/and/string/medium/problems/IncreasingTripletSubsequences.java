package leetcode.arrays.and.string.medium.problems;

/**
 * Increasing Triplet Subsequence
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should: * 
 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given
 * 0 ≤ i < j < k ≤ n-1 else return false. 
 * 
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Example 1: 
 * Input: [1,2,3,4,5] 
 * Output: true 
 * 
 * Example 2:
 * Input: [5,4,3,2,1] 
 * Output: false
 * 
 * 
 * @author Vivek
 *
 */
public class IncreasingTripletSubsequences
{
	public boolean increasingTriplet(int[] nums)
	{
		int small_1 = Integer.MAX_VALUE;
		int small_2 = Integer.MAX_VALUE;
		int larger = -1;
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			larger = nums[i];
			
			if(small_1 >= larger)
			{
				small_1 = larger;
			}
			else if(small_2 >= larger)
			{
				small_2 = larger;
			}
			else
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		IncreasingTripletSubsequences increasingTripletSubsequences = new IncreasingTripletSubsequences();
		System.out.println(increasingTripletSubsequences.increasingTriplet(new int[] {5,0,1,2,-1}));
	}
}
