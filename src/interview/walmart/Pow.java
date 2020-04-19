package interview.walmart;


/**
 * Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Example 1:
 * Input: 2.00000, 10 
 * Output: 1024.00000 
 * 
 * Example 2:
 * Input: 2.10000, 3 
 * Output: 9.26100 
 * 
 * Example 3:
 * Input: 2.00000, -2 
 * Output: 0.25000 
 * 
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25 
 * 
 * Note: 
 * 1. -100.0 < x < 100.0 
 * 2. n is a 32-bit signed integer, within the range [−231, 231 − 1]
 * 
 * 
 * @author Vivek
 *
 */
public class Pow
{
	public double myPow(double x, int n)
	{
		double result = 1;
		boolean isPositive = n >=0 ? true : false;
		n= Math.abs(n);
		for(int i = 0; i < n; i++)
		{
			result = result * x;
		}
		
		if(!isPositive)
		{
			result = 1/result;
		}

		return result;
	}
	
	public double myPowRecursive(double x , int n)
	{
		double result = 1;
		boolean isPositive = n >=0 ? true : false;
		n= Math.abs(n);
		
		result = powerRecursively(x,n);
		
		if(!isPositive)
		{
			result = 1/result;
		}
		
		return result;
	}

	private double powerRecursively(double x, int n)
	{
		if(n == 0)
		{
			return 1; 
		}
		else if(n % 2 == 0)
		{
			double intermediate = powerRecursively(x, n/2);
			return intermediate * intermediate;
		}
		else
		{
			return x * powerRecursively(x, n-1);
		}
	}

	public static void main(String[] args)
	{
		Pow pow = new Pow();
		System.out.println(pow.powerRecursively(1.0000, -2147483648));
		
		System.out.println(pow.myPow(2.1000, 3));
		
		System.out.println(pow.myPow(2.0000, -2));
	}
}
