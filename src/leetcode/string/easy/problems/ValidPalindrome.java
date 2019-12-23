package leetcode.string.easy.problems;

/**
 * Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1: 
 * Input: "A man, a plan, a canal: Panama" 
 * Output: true 
 * 
 * Example 2:
 * Input: "race a car" 
 * Output: false
 * 
 * @author Vivek
 *
 */
public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		if(s.trim().isEmpty())
		{
			return true;
		}
		
		String replaceAll = s.replaceAll("[^a-zA-Z0-9]", "");
		
		replaceAll = replaceAll.toLowerCase().trim();
		
		char[] charArray = replaceAll.toCharArray();
		
		int low = 0;
		int high = charArray.length-1;
		
		while(low <= high)
		{
			if(charArray[low++] != charArray[high--])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		ValidPalindrome validPalindrome = new ValidPalindrome();
		System.out.println(validPalindrome.isPalindrome("race a car"));
	}

}
