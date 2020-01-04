package leetcode.arrays.and.string.medium.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * Group Anagrams
 * 
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example: 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Output: [["ate","eat","tea"], 
 * 			["nat","tan"], 
 * 			["bat"] ] 
 * 
 * Note:
 * 1. All inputs will be in lowercase. 
 * 2. The order of your output does not matter.
 * 
 * @author Vivek
 *
 */
public class GroupAnagram
{
	public List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs)
		{
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String newStr = new String(charArray);
			
			if(map.get(newStr) == null)
			{
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(newStr, list);
			}
			else
			{
				List<String> list = map.get(newStr);
				list.add(str);
				map.put(newStr, list);
			}
			
		}
		
		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		List<List<String>> result = new ArrayList<>();
		
		for(Entry<String, List<String>> entry : entrySet)
		{
			result.add(entry.getValue());
		}
		
		return result;
	}

	
	public static void main(String[] args)
	{
		GroupAnagram anagram = new GroupAnagram();
		List<List<String>> groupAnagrams = anagram.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		
		System.out.println(groupAnagrams);
	}
}
