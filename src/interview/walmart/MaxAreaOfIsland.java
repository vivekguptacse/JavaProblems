package interview.walmart;

/**
 * Max Area of Island
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the island
 * must be connected 4-directionally. 
 * 
 * Example 2:
 * [[0,0,0,0,0,0,0,0]] 
 * Given the above grid, return 0. 
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 * 
 * @author Vivek
 *
 */
public class MaxAreaOfIsland
{
	public int maxAreaOfIsland(int[][] grid)
	{
		int result = 0;
		for(int i = 0 ; i< grid.length ; i++)
		{
			for(int j = 0; j < grid[i].length ; j++)
			{
				if(grid[i][j] == 1)
				{
					result = Math.max(result, dfs(grid,i,j));
				}
			}
		}
		return result;
	}

	private int dfs(int[][] grid, int start, int end)
	{
		if(start < 0 || start >= grid.length || end < 0 || end >= grid[start].length || grid[start][end] == 0)
		{
			return 0;
		}
		
		grid[start][end] = 0;
		int maxArea = 1;
		maxArea += dfs(grid,start + 1, end);
		maxArea += dfs(grid,start - 1, end);
		maxArea += dfs(grid,start, end + 1);
		maxArea += dfs(grid,start, end - 1);
			
		
		return maxArea;
	}

	public static void main(String[] args)
	{
		MaxAreaOfIsland max= new MaxAreaOfIsland();
		System.out.println(max.maxAreaOfIsland(new int[][] {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}			
		}));
	}

}
