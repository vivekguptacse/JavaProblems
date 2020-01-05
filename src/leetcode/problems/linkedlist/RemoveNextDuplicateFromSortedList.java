package leetcode.problems.linkedlist;

/**
 * Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1: 
 * Input: 1->1->2 
 * Output: 1->2 
 * 
 * Example 2:
 * Input: 1->1->2->3->3 
 * Output: 1->2->3
 * 
 * @author Vivek
 *
 */
public class RemoveNextDuplicateFromSortedList
{

	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode curr = head;
		
		while(curr.next != null)
		{
			if(curr.val == curr.next.val)
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

		RemoveNextDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveNextDuplicateFromSortedList();
		ListNode list= createLinkedList();
		System.out.println(removeDuplicateFromSortedList.deleteDuplicates(list));
		
		
		
		
	}


	private static ListNode createLinkedList()
	{
		ListNode listNode = new ListNode(1);
		ListNode head = listNode;
		listNode.next = new ListNode(1);
		listNode = listNode.next;
		listNode.next = new ListNode(1);
		listNode = listNode.next;
		listNode.next = new ListNode(1);
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
