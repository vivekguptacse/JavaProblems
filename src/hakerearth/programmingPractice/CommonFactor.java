package hakerearth.programmingPractice;

/**
 * Little Shino loves maths. Today her teacher gave her two integers. Shino is
 * now wondering how many integers can divide both the numbers. She is busy with
 * her assignments. Help her to solve the problem.
 * 
 * Input: First line of the input file contains two integers, a and b.
 * 
 * Output: Print the number of common factors of a and b.
 * 
 * Constraints: 1 <= a,b <= 10^12
 * 
 * SAMPLE INPUT 10 15 SAMPLE OUTPUT 2
 * 
 * @author Vivek
 *
 */
public class CommonFactor
{
	
	public static void main(String[] args)
	{
		System.out.println(gcd(10, 15));
		System.out.println(commonFactor(10,15));
	}

	private static int commonFactor(int num1, int num2)
	{
		int gcd = gcd(num1, num2);
		int count = 0;
		
		for(int i = 1 ; i <= gcd ; i++)
		{
			if(num1 % i == 0 && num2 % i == 0)
			{
				count++;
			}
		}
		
		return count;
		
	}

	private static int gcd(int num1, int num2)
	{
		if(num2 == 0)
		{
			return num1;
		}
		return gcd(num2, num1 % num2);
	}

}
