package interview.walmart;

import java.util.Arrays;
import java.util.List;

/**
 * Word Break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note: * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"] 
 * Output: true 
 * Explanation: Return true because "leetcode" can be segmented as "leet code". 
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] 
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". 
 * 
 * Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * @author Vivek
 *
 */
public class WordBreak
{
	public boolean wordBreak(String s, List<String> wordDict)
	{
		int left = 0; 
		int right = 1;
		
		while(right <= s.length())
		{
			String temp = s.substring(left, right);
			if(wordDict.contains(temp))
			{
				left = right;
			}
			right++;
		}
		
		if(left == right -1)
		{
			return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args)
	{
		WordBreak wordBreak = new WordBreak();
		System.out.println(wordBreak.wordBreak("aaaaaaa", Arrays.asList(new String[] {"aaaa", "aaa"})));		
	}

}
