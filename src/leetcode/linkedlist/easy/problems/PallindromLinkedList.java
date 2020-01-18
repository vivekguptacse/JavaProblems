package leetcode.linkedlist.easy.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Palindrome Linked List
 * 
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * Input: 1->2 
 * Output: false 
 * 
 * Example 2:
 * Input: 1->2->2->1 
 * Output: true
 * 
 * @author Vivek
 *
 */
public class PallindromLinkedList
{
	public boolean isPalindrome(ListNode head)
	{
		ListNode original = head;
		List<Integer> reversed = reverseList(head);
		int i = 0;
		while(original != null)
		{
			if(original.val != reversed.get(i++))
			{
				return false;
			}
			
			original = original.next;
		}
		return true;
	}
	
	
	private List<Integer> reverseList(ListNode head)
	{
		List<Integer> list = new ArrayList<Integer>();
				
		ListNode current = head; 
		
		while(current != null)
		{
			list.add(current.val);
			current = current.next;
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public static void main(String[] args)
	{
		PallindromLinkedList pallindromLinkedList = new PallindromLinkedList();
//		ListNode head= ListNode.createPallindromicList(3);
//		ListNode head = ListNode.createLinkedList(5);
		ListNode head = ListNode.createCustomList(new int[] {1,1,2,1});
		System.out.println(pallindromLinkedList.isPalindrome(head));
	}


}
