package geeksforgeeks.array.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import geeksforgeeks.arrays.problems.RotateArray;

public class RotateArrayTest
{
	@Test	
	public void testRotateArray1()
	{
		RotateArray rotateArray = new RotateArray();
		
		assertArrayEquals(rotateArray.rotateArray(new int[] {1,2,3,4,5,6}, 1), new int[] {2, 3, 4, 5, 6, 1});
	}
	
	@Test	
	public void testRotateArray2()
	{
		RotateArray rotateArray = new RotateArray();
		
		assertArrayEquals(rotateArray.rotateArray(new int[] {1,2,3,4,5,6}, 4), new int[] {5, 6, 1, 2, 3, 4});
	}


}
