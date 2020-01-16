package leetcode.linkedlist.easy.problems;

/**
 * Reverse Linked List
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * Input: 1->2->3->4->5->NULL 
 * Output: 5->4->3->2->1->NULL
 * 
 * @author Vivek
 *
 */
public class ReverseLinkedList
{
	public ListNode reverseList(ListNode head)
	{
		// If head is null or it contains only 1 element then return head. 
		if(head == null || head.next == null)
		{
			return head;
		}
		
		// Create 3 pointer 
		// For storing current pointer
		ListNode currentNdoe = head; 
		// For previous node 
		ListNode prevNode = null;
		// For temp node
		ListNode tempnode = null;
		
		// While current node is not null
		while(currentNdoe != null)
		{
			tempnode = currentNdoe.next;  // Assign current node to temp node.
			currentNdoe.next = prevNode;  // Assign previous node to current's next node.
			prevNode = currentNdoe;  // Assign current node to previous node
			currentNdoe = tempnode; // Assign temp Node back to current node
		}
		
		// return the new head that is previous Node.
		return prevNode;
	}
	
	
	public ListNode reverseRecursuively(ListNode node)
	{
		return reverse(node);
	}

	/**
	 * Reverse Recursivily
	 * 
	 * 
	 * @param node
	 * @return
	 */
	private ListNode reverse(ListNode node)
	{
		if (null == node || node.next == null)
		{
			return node;
		}

		ListNode list = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return list;
	}


	public static void main(String[] args)
	{
		ListNode createLinkedList = ListNode.createLinkedList(5);
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		System.out.println(reverseLinkedList.reverseList(createLinkedList));
		createLinkedList = ListNode.createLinkedList(5);
		System.out.println(reverseLinkedList.reverseRecursuively(createLinkedList));
	}
}
