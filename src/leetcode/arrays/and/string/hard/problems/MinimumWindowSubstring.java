package leetcode.arrays.and.string.hard.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example: 
 * Input: S = "ADOBECODEBANC", T = "ABC" 
 * Output: "BANC" 
 * 
 * Note: 
 * 1. If there is no such window in S that covers all characters in T, return the
 * empty string "". 
 * 2. If there is such window, you are guaranteed that there will always be only 
 * one unique minimum window in S.
 * 
 * @author Vivek
 *
 */
public class MinimumWindowSubstring
{
	public String minWindow(String s, String t)
	{
		Map<Character, Integer> tmap = new HashMap<>();
		for(int i = 0 ; i < t.length(); i++)
		{
			Character c = t.charAt(i);
			Integer count = tmap.getOrDefault(c, 0);
			tmap.put(c, count+1);
		}
		
		if(s.equals(t))
		{
			return s;
		}
		
		int found = 0;
		int required = t.length();
		
		int [] ans = {-1,0,0};
		
		int left=0, right =0;
		
		Map<Character, Integer> sMap = new HashMap<>();
		
		while(right < s.length())
		{
			Character ch = s.charAt(right);
			Integer count = sMap.getOrDefault(ch, 0);
			sMap.put(ch, count+1);
			
			if(tmap.containsKey(ch) && sMap.get(ch).intValue() == tmap.get(ch).intValue())
			{
				found++;
			}
			
			while(left <= right && found == required)
			{
				Character val = s.charAt(left);
				
				if(ans[0] == -1 || right-left + 1 < ans[0])
				{
					ans[0] = right-left+1;
					ans[1] = left;
					ans[2] = right;
				}
				
				sMap.put(val, sMap.get(val) - 1);
				
				if(tmap.containsKey(val) && sMap.get(val).intValue() < tmap.get(val).intValue())
				{
					found--;
				}
			
				left++;
			}
			right++;
		}
		
		
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
	}
	
	public static void main(String[] args)
	{
		MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
		System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
	}

}
