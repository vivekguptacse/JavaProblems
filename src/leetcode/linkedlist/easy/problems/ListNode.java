package leetcode.linkedlist.easy.problems;

/**
 * List Node --- Its node for Linked List
 * 
 * @author Vivek
 *
 */
public class ListNode
{
	@Override
	public String toString()
	{
		return "ListNode [val=" + val + ", next=" + next + "]" ;
	}

	int val;
	
	ListNode next;
	
	public ListNode(int val)
	{
		this.val = val;
	}
	
	/**
	 * Utility method to create a linked list
	 * @return
	 */
	public static ListNode createLinkedList(int n)
	{
		// 1->2->3->4->5
		ListNode head = null;
		ListNode temp = head;
		for(int i = 1; i <= n  ; i++)
		{
			ListNode node = new ListNode(i);
			if(head == null)
			{
				head = node;
				temp = head;
			}
			
			
			temp.next = node;
			temp = temp.next;
		}
//		ListNode newNode = new ListNode(2);
//		head.next = newNode;
////		ListNode node = new ListNode(3);
////		newNode.next = node;
		
		
		return head;
	}

}
