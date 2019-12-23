package leetcode.string.easy.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" 
 * return 0.
 * 
 * s = "loveleetcode", 
 * return 2. 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author Vivek
 *
 */
public class FirstUniqueCharacter
{
	public int firstUniqChar(String s)
	{
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		
		char[] charArray = s.toCharArray();
		int count = 0;
		for(char ch: charArray)
		{
			if(charMap.containsKey(ch))
			{
				charMap.put(ch, -1);
			}
			else
			{
				charMap.put(ch, count);
			}
			count++;
		}
		
		Set<Entry<Character,Integer>> entrySet = charMap.entrySet();
		
		for(Entry<Character,Integer> entry : entrySet)
		{
			if(entry.getValue() != -1)
			{
				return entry.getValue();
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		FirstUniqueCharacter uniqueChar = new FirstUniqueCharacter();
		System.out.println(uniqueChar.firstUniqChar("aabbddrrccee"));
	}
}
