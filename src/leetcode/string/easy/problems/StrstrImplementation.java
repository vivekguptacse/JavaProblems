package leetcode.string.easy.problems;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1: * 
 * Input: haystack = "hello", needle = "ll" 
 * Output: 2 
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba" 
 * Output: -1 
 * 
 * Clarification:
 * -- What should we return when needle is an empty string? This is a great
 *    question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author Vivek
 *
 */
public class StrstrImplementation
{

	public int strStr(String haystack, String needle)
	{
		if(needle.isEmpty())
		{
			return 0;
		}
		
		char[] hayStackCharArray = haystack.toCharArray();
		char[] needleCharArray = needle.toCharArray();
		
		for(int i = 0, j=0 ; i < hayStackCharArray.length; i++)
		{
			if(hayStackCharArray[i] == needleCharArray[j])
			{
				int k = i ;
				int l = j ;
				boolean notMatch = false;
				while(k < hayStackCharArray.length && l < needleCharArray.length)
				{
					if(hayStackCharArray[k++] != needleCharArray[l++])
					{
						notMatch = true;
						break;
					}
				}
				if(!notMatch)
				{
					if(k <= hayStackCharArray.length && l == needleCharArray.length)
					{
						return i;
					}
				}
			}
		}
		
		return -1;
	}
	
	public int alternativeImpl_strstr(String haystack, String needle)
	{
		if(needle.isEmpty())
		{
			return 0;
		}
		
		if(needle.length() > haystack.length())
		{
			return -1;
		}
		
		int needlelength = needle.length();
		
		for(int i = 0 ; i < haystack.length() + needlelength ; i++)
		{
			if(haystack.substring(i, i+needlelength).equals(needle))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		StrstrImplementation strstr = new StrstrImplementation();
//		System.out.println(strstr.strStr("hello", "ll"));
		System.out.println(strstr.alternativeImpl_strstr("a	", "a"));
	}

}
