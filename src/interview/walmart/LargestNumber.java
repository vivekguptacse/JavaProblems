package interview.walmart;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * 
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1: 
 * Input: [10,2] 
 * Output: "210" 
 * 
 * Example 2:
 * Input: [3,30,34,5,9] 
 * Output: "9534330" 
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * 
 * @author Vivek
 *
 */
public class LargestNumber
{
	public String largestNumber(int[] nums)
	{
		String [] asString = new String[nums.length];
		
		int i = 0;
		for(int num : nums)
		{
			asString[i++] = String.valueOf(num);
		}
		
		Arrays.sort(asString, new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2)
			{
				String order1 = o1 + 02; 
				String order2 = o2 + o1;
				return order2.compareTo(order1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : asString)
		{
			sb.append(str);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		LargestNumber largestNumber = new LargestNumber();
		System.out.println(largestNumber.largestNumber(new int [] {3,30,34,5,9}));
	}
}
 