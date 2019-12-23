package hakerearth.programmingPractice;

/**
 * Fredo is assigned a new task today. He is given an array A containing N
 * integers. His task is to update all elements of array to some minimum value x
 * , that is, ; such that sum of this new array is strictly greater than the sum
 * of the initial array. Note that x should be as minimum as possible such that
 * sum of the new array is greater than the sum of the initial array.
 * 
 * Input Format: First line of input consists of an integer N denoting the
 * number of elements in the array A. Second line consists of N space separated
 * integers denoting the array elements.
 * 
 * Output Format: The only line of output consists of the value of x.
 * 
 * Input Constraints: 
 * 1 <= N <= 10^5 
 * 1 <= A[i] <= 1000
 * 
 * SAMPLE INPUT 
 * 5 
 * 1 2 3 4 5 
 * 
 * SAMPLE OUTPUT 4 
 * 
 * Explanation Initial sum of array = 1 + 2 + 3 + 4 + 5 = 15
 * When we update all elements to 4, sum of array 4 + 4 + 4 + 4 + 4 = 20 which is greater than  15 . 
 * Note that if we had updated the array elements to 3, which is not greater than .
 * So, 4 is the minimum value to which array elements need to be updated.
 * 
 * @author Vivek
 *
 */
public class ArrayUpdate
{
	public static void main(String[] args)
	{
		long result = updateArray(new int[]{1,2,3,4,5,30});
		System.out.println(result);
	}

	private static long updateArray(int[] input)
	{
		int size = input.length;
		
		long result = 0;
		for ( int num : input)
		{
			result += num;
		}
		
		return (result/size) + 1;
	}

}
