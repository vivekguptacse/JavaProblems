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
		
		return head;
	}
	
	public static ListNode createPallindromicList(int n)
	{
		ListNode head = null;
		ListNode temp = head;
		int i = 1;
		for(; i <= n  ; i++)
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
		i--;
		while(i > 0)
		{
			ListNode node = new ListNode(i);
			
			temp.next = node;
			temp = temp.next;
			i--;
		}
		
		return head;
		
	}
	
	public static ListNode createCustomList(int [] nums)
	{
		ListNode head = new ListNode(nums[0]);
		ListNode temp = head;
		
		for(int i = 1; i < nums.length ; i++)
		{
			ListNode node = new ListNode(nums[i]);
			
			temp.next = node;
			temp = temp.next;
		}
		
		return head;
	}

}
