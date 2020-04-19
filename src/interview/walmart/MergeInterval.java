package interview.walmart;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]] 
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: [[1,4],[4,5]] 
 * Output: [[1,5]] 
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
 * 
 * @author Vivek
 *
 */
public class MergeInterval
{

	public int[][] merge(int[][] intervals)
	{
		Collections.sort(Arrays.asList(intervals), new Comparator<int[]>()
		{

			@Override
			public int compare(int[] a, int[] b)
			{
				return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
			}
		});
		
		LinkedList<int []> result = new LinkedList<>();
		
		for(int [] interval : intervals)
		{
			if(result.isEmpty() || result.getLast()[1] < interval[0])
			{
				result.add(interval);
			}
			else
			{
				result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
			}
		}
		
		System.out.println( result);
		return result.toArray(new int[result.size()][]	);

	}

	
	public static void main(String[] args)
	{
		MergeInterval mergeInterval = new MergeInterval();
		
		int[][] merge = mergeInterval.merge(new int [][] {{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}});
		
		for(int i =0 ; i < merge.length ; i++ )
		{
			for(int j=0 ; j < merge[0].length ; j++)
			{
				System.out.print(merge[i][j]);
			}
			System.out.println();
		}
	}
}
