package interview.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 
 * 
 * 				3 
 * 			   / \ 
 * 				9 20 
 * 				  / \ 15 7
 * 
 * return its level order traversal as: 
 * 		[ 
 * 			[3], 
 * 			[9,20], 
 * 			[15,7] 
 * 		]
 * 
 * @author Vivek
 *
 */
public class BinaryTreeLevelOrderTraversal
{

	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(null == root)
		{
			return result;
		}
		
		if((root.left == null && root.right == null))
		{
			result.add(new ArrayList<>(root.val));
		}
		
		traverseTreeRecursively(result, root , 0);	
		
		return result;

	}

	private void traverseTreeRecursively(List<List<Integer>> result, TreeNode root, int level)
	{
		if(root == null )
		{
			return;
		}
		
		if(level >= result.size())
		{
			result.add(new ArrayList<>());
			
		}
		
		List<Integer> list = result.get(level);
		if(list == null)
		{
			list = new ArrayList<>();
		}
		
		list.add(root.val);
		
		traverseTreeRecursively(result,root.left , level+1);
		traverseTreeRecursively(result, root.right, level + 1);
			
	}
	
	public static void main(String[] args)
	{
		BinaryTreeLevelOrderTraversal traversalOrder = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
		
		System.out.println(traversalOrder.levelOrder(root));
	}

}


