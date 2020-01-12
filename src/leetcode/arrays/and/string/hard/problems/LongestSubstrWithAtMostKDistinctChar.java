package leetcode.arrays.and.string.hard.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most K Distinct Characters
 * 
 * Given a string you need to print longest possible substring that has exactly
 * M unique characters. If there are more than one substring of longest possible
 * length, then print any one of them. 
 * 
 * Examples:
 * Input 1 : "aabbcc", k = 1 
 * Output: Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * Input 2 : "aabbcc", k = 2 
 * Output : Max substring can be any one from {"aabb" , "bbcc"}.
 * 
 * Input 3 : "aabbcc", k = 3 
 * Output : There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } Max is "aabbcc" with length 6.
 * 
 * INput 4: "aaabbb", k = 3 
 * output : There are only two unique characters, thus show error message.
 * 
 * @author Vivek
 *
 */
public class LongestSubstrWithAtMostKDistinctChar
{

	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		Map<Character, Integer> map = new HashMap<>();
		int result = 0;
		int start = 0;
		
		for(int i = 0 ; i < s.length() ; i++)
		{
			char c = s.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
			
			if(map.size() <= k)
			{
				result = Math.max(result, i-start + 1);
			}
			else
			{
				while(map.size() > k)
				{
					char ch = s.charAt(start);
					Integer counter = map.get(ch);
					
					if(counter == 1)
					{
						map.remove(ch);
					}
					else
					{
						map.put(ch, counter-1);
					}
					start++;
				}
			}
		}
		if(map.size() < k)
		{
			System.out.println("There are only " +map.size() + " unique characters, thus returning 0.");
			return 0;
		}

		return result;
	}
	
	public static void main(String[] args)
	{
		LongestSubstrWithAtMostKDistinctChar longestestSbstring  = new LongestSubstrWithAtMostKDistinctChar();
		System.out.println(longestestSbstring.lengthOfLongestSubstringKDistinct("aabbcc", 4));
	}
}
