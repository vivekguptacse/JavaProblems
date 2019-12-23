package leetcode.string.easy.problems;

/**
 * Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1: 
 * Input: ["flower","flow","flight"] 
 * Output: "fl" 
 * 
 * Example 2:
 * Input: ["dog","racecar","car"] 
 * Output: "" 
 * Explanation: There is no common prefix among the input strings. 
 * 
 * Note: All given inputs are in lowercase letters a-z.
 * 
 * @author Vivek
 *
 */
public class LongestCommonPrefix
{
	public String longestCommonPrefix(String[] strs)
	{
		return commonPrefix(strs, 0, strs.length - 1);
	}
	
	private String commonPrefix(String [] arr , int low , int high)
	{
		if(low == high)
		{
			return arr[low];
		}
		
		if(high > low)
		{
			int mid = (low + high)/2;
			
			String str1 = commonPrefix(arr, low, mid);
			String str2 = commonPrefix(arr, mid + 1, high);
			
			return commonPrefix(str1, str2);
		}
		return null;
	}

	private String commonPrefix(String str1, String str2)
	{
		String result = "";
		int n1 = str1.length();
		int n2 = str2.length();
		
		for(int i = 0 , j = 0; i < n1 && j < n2 ; i++,j++)
		{
			if(str1.charAt(i) != str2.charAt(j))
			{
				break;
			}
			result += str1.charAt(i);
		}
		return result;
	}
	
	/** Horizontal scaling
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix1(String[] strs)
	{
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0)
			{
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}
	
	
	/**
	 * Vertical scaling
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs)
	{
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++)
		{
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++)
			{
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args)
	{
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String longestCommonPrefix2 = longestCommonPrefix.longestCommonPrefix2(new String [] {"geeksforgeeks", "geeks", "geek", "geezer"});
		System.out.println(longestCommonPrefix2);
	}
}
