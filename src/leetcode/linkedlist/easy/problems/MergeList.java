package leetcode.linkedlist.easy.problems;

/**
 * Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: 1->2->4, 1->3->4 
 * Output: 1->1->2->3->4->4
 * 
 * @author Vivek
 *
 */
public class MergeList
{
	/**
	 * Merge two sorted list recursively.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		// if l1 is null return l2
		if(l1 == null)
		{
			return l2;
		}
		
		// if l2 is null return l1;
		if(l2 == null)
		{
			return l1;
		}
		
		// if l1 is less then call mergeList with next pointer of l1
		if(l1.val < l2.val)
		{
			l1.next = mergeTwoLists(l1.next, l2);  // this will always give greater values then l1 current value, set the next and return
			return l1;
		}
		else  // else with the next pointer of l2
		{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
	}
	
	/**
	 * Iterative procedure to merge tow sorted linked list. 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists_UsingNewList(ListNode l1, ListNode l2)
	{
		// create new list result
		ListNode result = null; 
		//assign result with initial value.
		if(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				result = l1;
				l1 = l1.next;
			}
			else
			{
				result = l2;
				l2 = l2.next;
			}
		}
		else if(l1 != null)
		{
			return l1;
		}
		else if(l2 != null)
		{
			return l2;
		}
		ListNode resultPoiner = result;  
		
		while(l1 != null && l2 != null)
		{
			if(l1.val <= l2.val)
			{
				resultPoiner.next = l1;
				l1 = l1.next;
				resultPoiner = resultPoiner.next;
			}
			else
			{
				resultPoiner.next = l2;
				l2 = l2.next;
				resultPoiner = resultPoiner.next;
				
			}
		}
		
		if(l1 != null)
		{
			resultPoiner.next = l1;
		}
		else if(l2 != null)
		{
			resultPoiner.next = l2;
		}
		return result;
		
		
	}

	
	public static void main(String[] args)
	{
		ListNode l1 = ListNode.createLinkedList(4);
		ListNode l2 = ListNode.createLinkedList(3);
		
		MergeList merge = new MergeList();
		System.out.println(merge.mergeTwoLists(l1, l2));
		
	}
}
