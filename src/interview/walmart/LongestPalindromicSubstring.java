package interview.walmart;

/**
 * Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1: 
 * Input: "babad" 
 * Output: "bab" 
 * Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" 
 * Output: "bb"
 * 
 * @author Vivek
 *
 */
public class LongestPalindromicSubstring
{
	int resultStart = 0;
	int resultlength = 0;
	public String longestPalindrome(String s)
	{
		int length = s.length();
		
		if(length < 2)
		{
			return s;
		}
		
		for(int start = 1; start < length ; start++)
		{
			expandRange(s, start, start);
			expandRange(s, start, start + 1);
		}
		
		
		return s.substring(resultStart, resultStart + resultlength ) ;
	}
	
	private void expandRange(String s, int start, int end)
	{
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
		{
			start--;
			end++;
		}
		if(resultlength < end - start -1)
		{
			resultlength = end - start - 1;
			resultStart = start + 1;
		}
	}
	
	public static void main(String[] args)
	{
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.longestPalindrome("babassssffffssss"));
	}

}
