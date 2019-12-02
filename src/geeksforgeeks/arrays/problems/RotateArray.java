package geeksforgeeks.arrays.problems;

import java.util.Arrays;

public class RotateArray
{
	
	public int [] rotateArray(int [] array , int n)
	{
		for(int i = 0 ; i < n ; i++)
		{
			int temp = array[0];
			int j = 0;
			for( ; j < array.length - 1 ; j++)
			{
				array[j] = array[j+1];
			}
			array[j] = temp;
		}
		
		return array;
	}
	
	public static void main(String[] args)
	{
		RotateArray rotateArray = new RotateArray();
		
		int[] rotateArray2 = rotateArray.rotateArray(new int[] {1,2,3,4,5,6}, 4);
		System.out.println(Arrays.toString(rotateArray2));
				
	}

}
