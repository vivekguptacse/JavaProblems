package interview.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3] 
 * Output: [ 
 * 			[1,2,3], 
 * 			[1,3,2], 
 * 			[2,1,3], 
 * 			[2,3,1], 
 * 			[3,1,2], 
 * 			[3,2,1]
 * 		   ]
 * 
 * @author Vivek
 *
 */
public class Permutations
{

	public List<List<Integer>> permute(int[] nums)
	{

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean [] used = new boolean [nums.length];
		
		generatePermutations(nums,new ArrayList<>() , used , result);

		return result;

	}

	private void generatePermutations(int[] nums, List<Integer> current, boolean [] used,List<List<Integer>> result)
	{
		if(current.size() == nums.length)
		{
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i = 0; i < nums.length ; i++)
		{
			if(used[i])
			{
				continue;
			}
			
			used[i] = true;
			current.add(nums[i]);
			generatePermutations(nums, current, used, result);
			current.remove(current.size() - 1);
			used[i] = false;
			
		}
		
	}
	
	public static void main(String[] args)
	{
		Permutations permutations = new Permutations();
		System.out.println(permutations.permute(new int[] {1,2,3,4}));
	}

}
