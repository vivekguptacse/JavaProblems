package interview.walmart;

import java.util.Arrays;

/**
 * 
 * Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * @author Vivek
 *
 */
public class TrappingRainWater
{
    public int trap(int[] height) {
        
        if(null == height || height.length == 0)
        {
            return 0;
        }
        
        int volume = 0;
		int n = height.length;
		
		int [] left = new int[n];
		int [] right = new int[n];
		
		left[0] = height[0];
		for(int i = 1 ; i < n ; i++)
		{
			left[i] = Math.max(left[i-1], height[i]);
		}
		
		right[n-1] = height[n-1];
		for(int i = n-2 ; i >=0 ; i--)
		{
			right[i] = Math.max(right[i+1], height[i]);
		}
		
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		
		for(int i = 0 ; i < n ; i++)
		{
			volume += Math.min(left[i], right[i]) - height[i];
		}
		return volume;
    }
    
    public static void main(String[] args)
	{
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		System.out.println(trappingRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
}
