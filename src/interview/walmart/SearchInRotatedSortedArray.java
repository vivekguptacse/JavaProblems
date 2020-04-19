package interview.walmart;

import java.util.Arrays;

/**
 * Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1: * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 
 * Output: 4 
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3 
 * Output: -1
 * 
 * @author Vivek
 *
 */
public class SearchInRotatedSortedArray
{
	public int search(int[] nums, int target)
	{
		int minIndex = 0; 
		int startIndex = 0; 
		int endIndex = nums.length - 1;
		int maxEndIndex = minIndex - 1;
		
		for(int i = 0 ; i < endIndex ; i++)
		{
			if(nums[i] > nums[ i+1])
			{
				maxEndIndex = i;
				minIndex = i+1;
				break;
			}
		}

		int binarySearch = Arrays.binarySearch(nums, minIndex, endIndex + 1, target);
		
		if(binarySearch < 0)
		{
			int result = Arrays.binarySearch(nums, startIndex, maxEndIndex + 1, target);
			
			 return result < 0 ? -1 : result;
		}
		else
		{
			return binarySearch;
		}

	}
	
	public static void main(String[] args)
	{
		SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
		System.out.println(searchInRotatedSortedArray.search(new int[] {1,2,3}, 8));
	}

}
