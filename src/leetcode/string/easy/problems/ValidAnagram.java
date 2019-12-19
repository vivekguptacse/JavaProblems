package leetcode.string.easy.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Valid Anagram
 * 
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram" 
 * Output: true 
 * 
 * Example 2:
 * Input: s = "rat", t = "car" 
 * Output: false 
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @author Vivek
 *
 */
public class ValidAnagram
{

	public boolean isAnagram(String s, String t)
	{
		List<Character> charList = new ArrayList<>();
		
		if(s.length() != t.length())
		{
			return false;
		}
		
		char[] sCharArray = s.toCharArray();
		
		for(char ch : sCharArray)
		{
			charList.add(ch);
		}
		
		char[] tCharArray = t.toCharArray();
		
		for(char ch : tCharArray)
		{
			charList.remove((Character)ch);
		}
		
		return charList.isEmpty();
	}
	
	public static void main(String[] args)
	{
		ValidAnagram validAnagram = new ValidAnagram();
		
		System.out.println(validAnagram.isAnagram("a","ab"));
	}

}
