package interview.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * All Paths From Source to Target
 * 
 * Given a directed, acyclic graph of N nodes. Find all possible paths from node
 * 0 to node N-1, and return them in any order.
 * 
 * The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1.
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * 
 * Example: Input: [[1,2], [3], [3], []] 
 * 
 * Output: [[0,1,3],[0,2,3]] 
 * 
 * Explanation:
 * The graph looks like this: 0--->1 
 * 							  |    | 
 * 							  v    v 
 * 							  2--->3 
 *  
 *  There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * 
 * @author Vivek
 *
 */
public class AllPathsFromSourcetoTarget
{

	public List<List<Integer>> allPathsSourceTarget(int[][] graph)
	{
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(Arrays.asList(0));
		
		int goalNode = graph.length -1 ;
		
		while(!queue.isEmpty())
		{
			List<Integer> path = queue.poll();
			int lastnode = path.get(path.size() - 1);
		
			if(goalNode == lastnode)
			{
				result.add(path);
			}
			else
			{
				int [] nodes = graph[lastnode];
				for(int node : nodes)
				{
					List<Integer> list = new ArrayList<>(path);
					list.add(node);
					queue.offer(list);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		AllPathsFromSourcetoTarget allPathsFromSourcetoTarget = new AllPathsFromSourcetoTarget();
		
		System.out.println(allPathsFromSourcetoTarget.allPathsSourceTarget(new int [][] {{1,2},{3},{1,3},{}}));
		
	}

}
