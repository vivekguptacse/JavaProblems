package leetcode.arrays.and.string.medium.problems;

/**
 * Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1: 
 * Input: "babad" 
 * Output: "bab" 
 * Note: "aba" is also a valid answer. 
 * 
 * Example 2:
 * Input: "cbbbbd" 
 * Output: "bb"
 * 
 * @author Vivek
 *
 */
public class LongestPalindromicSubstring
{

	public String longestPalindrome(String s)
	{
		char[] charArray = s.toCharArray();

		int max = 0;
		String result = "";

		boolean isodd = true;
		for (int i = 0; i < charArray.length ; i++)
		{
			int count = 1;
			if (isodd)
			{
				if (i - 1 >= 0 && i + 1 < charArray.length)
				{
					int low = i - 1;
					int high = i + 1;

					while (low >= 0 && high < charArray.length)
					{
						if (charArray[low--] == charArray[high++])
						{
							count += 2;
							if (count > max)
							{
								max = count;
								result = s.substring(low + 1, high);
							}
						} else
						{
							break;
						}
					}
				} else
				{
					if (max < 1)
					{
						max = 1;
						result = "" + s.charAt(i);
					}
				}
				isodd = false;
			} else
			{
				if (charArray[i] == charArray[i - 1])
				{
					count = 2;
					if (i - 2 >= 0 && i + 1 < charArray.length)
					{
						int low = i - 2;
						int high = i + 1;

						while (low >= 0 && high < charArray.length)
						{
							if (charArray[low--] == charArray[high++])
							{
								count += 2;
								if (count > max)
								{
									max = count;
									result = s.substring(low + 1, high);
								}
							} else
							{
								break;
							}
						}
					}
					if (max < 2)
					{
						max = 2;
						result = s.substring(i - 1, i + 1);
					}
				}

				i--;
				isodd = true;

			}

		}

		return result;

	}
	
	public static void main(String[] args)
	{
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		
		String longestPalindrome = longestPalindromicSubstring.longestPalindrome("cbbbbd");
		
		System.out.println(longestPalindrome);
	}

}
