package interview.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
*  ]
 * 
 * @author Vivek
 *
 */
public class GenerateParentheses
{
	public List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList<>();
	
		generateParenthesis(n,n, "" , result);
		
		return result;
	}

	private void generateParenthesis(int left, int right, String current, List<String> result)
	{
		if(left < 0 || left > right)
		{
			return;
		}
		
		if(left == 0 && right == 0)
		{
			result.add(current);
			return;
		}
		
		generateParenthesis(left - 1, right , current + "(" , result);
		generateParenthesis(left, right - 1 , current + ")" , result);
		
	}
	
	public static void main(String[] args)
	{
		GenerateParentheses generateParentheses = new GenerateParentheses();
		System.out.println(generateParentheses.generateParenthesis(3));
	}

}
