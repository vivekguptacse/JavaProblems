package interview.walmart;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * 
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 * 
 * @author Vivek
 *
 */
public class LargestRectangleInHistogram
{
	public int largestRectangleArea(int[] heights)
	{
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int i = 0; 
		int area = 0;
		for(; i < heights.length;)
		{
			if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
			{
				stack.push(i++);
			}
			else
			{
				int top = stack.pop();
				if(stack.isEmpty())
				{
					area = heights[top] * i;
				}
				else
				{
					area = heights[top] * (i - stack.peek() - 1);
				}
				
				if(area > maxArea)
				{
					maxArea = area;
				}
			}
			
		}
		
		while(!stack.isEmpty())
		{
			int top = stack.pop();
			if(stack.isEmpty())
			{
				area = heights[top] * i;
			}
			else
			{
				area = heights[top] * (i - stack.peek() - 1);
			}
			
			if(area > maxArea)
			{
				maxArea = area;
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args)
	{
		LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
		System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {2,1,5,6,2,3}));
	}

}
