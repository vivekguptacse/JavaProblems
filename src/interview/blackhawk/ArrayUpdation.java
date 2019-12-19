package interview.blackhawk;

import java.util.Arrays;

/**
 * 
 * A is array , Q is array of queries to be performed , I(0 based) index query. 
 *  query perform like this :
 *  
 * 		for j = I +1 to N
 * 		if A[j] < A[I]
 * 	 	   A[j] = 0
 * 
 * Input : Array = [4,3,4,3,2] , Query = [3,2] 
 * Output - [4,3,4,0,0]
 * 
 * Input : Array = [4,3,4,3,2,4,2,8,6,4] , Query = [3,2,6,4,8]
 * Output - [4,3,4,0,0,4,0,8,6,0]
 * 
 * 
 * 
 * @author Vivek
 *
 */

public class ArrayUpdation
{
	
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(findArray(new int [] {4,3,4,3,2,4,2,8,6,4} , new int [] {3,2,6,4,8})));
		System.out.println(Arrays.toString(findArray1(new int [] {4,3,4,3,2,4,2,8,6,4} , new int [] {3,2,6,4,8})));
		
	}

	private static int [] findArray(int[] array, int[] query)
	{
//		int n = array.length;
		int q = query.length;
		
		Arrays.sort(query);
		for(int i = q -1 ; i >= 0 ; i--)
		{
			int j = query[i] + 1;
			
			if(i - 1 > 0)
			{
				while(j > query[i-1])
				{
					if(array[j] < array[query[i]])
					{
						array[j] = 0; 
					}
					j--;
				}
			}
			else
			{
				j = query[i] + 1;
				while(j > query[0])
				{
					if(array[j] < array[query[i]])
					{
						array[j] = 0; 
					}
					j--;
				}
			}
		}
		
		return array;
	}
	
	/**
	 * Correct answer .. but unoptimized  -- need to optimized -- Hint : use Advanced sorting algorithm. 
	 * @param array
	 * @param query
	 * @return
	 */
	private static int [] findArray1(int[] array, int[] query)
	{
		int n = array.length;
		int q = query.length;

		for (int i = 0; i < q; i++)
		{
			int j = query[i] + 1;

			while (j < n)
			{
				if (array[j] < array[query[i]])
				{
					array[j] = 0;
				}
				j++;
			}
		}

		return array;
	}


}
