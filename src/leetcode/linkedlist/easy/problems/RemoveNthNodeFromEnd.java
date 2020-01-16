package leetcode.linkedlist.easy.problems;

/**
 * Remove Nth Node From End of List
 * 
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example: 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. 
 * 
 * Note:
 * 1. Given n will always be valid.
 * 
 * @author Vivek
 *
 */
public class RemoveNthNodeFromEnd
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		// If n == 1 and only one element is there return null;
		if(n == 1 && head.next == null)
		{
			return null;
			
		}
		
		// Create 2 pointer. 
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		// Skip the dat pointer to the number of times we need to delete the element from last.
		int i = 0 ;
		while(i < n && fastPointer.next != null)
		{
			fastPointer = fastPointer.next;
			i++;
		}
		// Check if i < n that means fast pointer reached null , so we have to remove head of the list. 
		if(i < n)
		{
			return head = head.next;
		}
		
		// Move both the pointer will fast poiner reaches end. 
		while(fastPointer.next != null)
		{
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		
		// if SlowPointer next is not null the delete the element
		if(slowPointer.next != null)
		{
			slowPointer.next = slowPointer.next.next;
			
		}
		
		return head;
	}

	public static void main(String[] args)
	{
		ListNode createLinkedList = ListNode.createLinkedList(5);
		RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
		System.out.println(removeNthNodeFromEnd.removeNthFromEnd(createLinkedList, 2));
	}

}
