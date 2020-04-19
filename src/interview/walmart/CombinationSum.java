package interview.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note: 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. 
 * 
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7, 
 * A solution set is: [ 
 * 						[7], 
 * 						[2,2,3]
 * 					  ] 
 * 
 * Example 2:
 * Input: candidates = [2,3,5], target = 8, 
 * A solution set is: [ 
 * 						[2,2,2,2],
 * 						[2,3,3], 
 * 						[3,5] 
 * 					  ]
 * 
 * @author Vivek
 *
 */
public class CombinationSum
{

	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		
		findCombination(candidates, 0, target, new ArrayList<>(),result);
		
		return result;

	}

	private void findCombination(int[] candidates, int index, int target, ArrayList<Integer> current, List<List<Integer>> result)
	{
		if(target == 0)
		{
			result.add(new ArrayList<>(current));
			return; 
		}
		
		if(target <= 0)
		{
			return;
		}
		
		for(int i = index ; i < candidates.length ; i++)
		{
			current.add(candidates[i]);
			findCombination(candidates, i, target - candidates[i], current, result);
			current.remove(current.size() - 1);

		}
	}
	
	public static void main(String[] args)
	{
		CombinationSum sum = new CombinationSum();
		System.out.println(sum.combinationSum(new int [] {10,1,2,7,6,1,5}, 8));
	}

}
