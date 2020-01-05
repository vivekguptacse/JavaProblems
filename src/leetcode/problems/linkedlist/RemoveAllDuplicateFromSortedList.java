package leetcode.problems.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Duplicates from Sorted List II Given a sorted linked list, delete all
 * nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * 
 * Example 1:
 * Input: 1->2->3->3->4->4->5 
 * Output: 1->2->5 
 * 
 * Example 2:
 * Input: 1->1->1->2->3 
 * Output: 2->3
 * 
 * @author Vivek
 *
 */
public class RemoveAllDuplicateFromSortedList
{

	public ListNode deleteDuplicates(ListNode head)
	{
		if(null == head || null == head.next)
		{
			return head;
		}
		ListNode curr = head;
		
		Set<Integer> dupNums = new HashSet<>();
		
		while(curr.next != null)
		{
			if(curr.val == curr.next.val)
			{
				dupNums.add(curr.val);
				curr.next = curr.next.next;
				continue;
			}
			curr = curr.next;
		}
		
		while(head != null && dupNums.contains(head.val))
		{
			head = head.next;	
		}
		
		if(head == null || head.next == null)
		{
			return head;
		}
		
		curr = head;
		while(curr.next != null)
		{
			if(curr.next != null && dupNums.contains(curr.next.val))
			{
				curr.next = curr.next.next;
				continue;
			}
			curr = curr.next;
		}
		
		return head;
	}
	
	
	public static void main(String[] args)
	{

		RemoveAllDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveAllDuplicateFromSortedList();
		ListNode list= createLinkedList();
		System.out.println(removeDuplicateFromSortedList.deleteDuplicates(list));
		
		
		
		
	}


	private static ListNode createLinkedList()
	{
		ListNode listNode = new ListNode(1);
		ListNode head = listNode;
		listNode.next = new ListNode(1);
		listNode = listNode.next;
		listNode.next = new ListNode(2);
		listNode = listNode.next;
		listNode.next = new ListNode(3);
		listNode = listNode.next;
		listNode.next = new ListNode(4);
		listNode = listNode.next;
		listNode.next = new ListNode(4);
		listNode = listNode.next;
		listNode.next = new ListNode(5);
		listNode = listNode.next;
		listNode.next = new ListNode(6);
		listNode = listNode.next;
		listNode.next = new ListNode(6);
		
		
		
		
		return head;
	}

}

