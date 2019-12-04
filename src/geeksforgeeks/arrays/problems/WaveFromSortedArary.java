package geeksforgeeks.arrays.problems;

import java.util.Arrays;

/**
 * We have to create a wave from a sorted array, 
 * Input : 1,2,4,7,9,11,18,22
 * Output: 22,1,18,2,11,4,9,7
 * 
 * @author Vivek.g
 *
 */
public class WaveFromSortedArary
{
	public void createwave(int [] input)
	{
		 int start = 0;
		 int end = input.length - 1;
		 
		 while(start < end)
		 {
			 rotate(input,start, end);
			 start+=2;
		 }
		 
		    System.out.println(Arrays.toString(input));
	}
	
	private static int[] rotate(int[] input, int start, int end)
	{
			int temp = input[end];
			int j = end;
			for( ; j > start ; j--)
			{
				input[j] = input[j-1];
			}
			input[j] = temp;
		
		return input;
		
	}
	
	public static void main(String[] args)
	{
		WaveFromSortedArary wave = new WaveFromSortedArary();
		wave.createwave(new int[]{1,2,4,7,11,18,22});
	}


}
