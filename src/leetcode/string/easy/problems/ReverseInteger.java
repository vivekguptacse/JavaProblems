package leetcode.string.easy.problems;

/**
 * Reverse Integer
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 
 * Output: 321 
 * 
 * Example 2:
 * Input: -123 
 * Output: -321 
 * 
 * Example 3:
 * Input: 120 
 * Output: 21 
 * 
 * Note: Assume we are dealing with an environment which
 * could only store integers within the 32-bit signed integer range: [−231, 231
 * − 1]. For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 * 
 * @author Vivek
 *
 */
public class ReverseInteger
{

	public int reverse(int x)
	{
		boolean isNegative = x < 0 ? true:false;
		
		x = Math.abs(x);
		
		String number = ""+x;
		
		char[] charArray = number.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char ch : charArray)
		{
			sb.append(ch);
		}
		
		String recerseNum = sb.reverse().toString();
		int parsedNumber = 0;
		try
		{
			parsedNumber = Integer.parseInt(recerseNum);
			if(isNegative)
			{
				parsedNumber = parsedNumber * -1;
			}
		}
		catch(NumberFormatException e)
		{
			// Do nothing
		}
		
		return parsedNumber;
		
	}

	
	public static void main(String[] args)
	{
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(1534236469));
	}
}
