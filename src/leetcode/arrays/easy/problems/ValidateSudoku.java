package leetcode.arrays.easy.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * Example 1:
 * 
 * Input: [ ["5","3",".",".","7",".",".",".","."],
 * 			["6",".",".","1","9","5",".",".","."], 
 * 			[".","9","8",".",".",".",".","6","."],
 * 			["8",".",".",".","6",".",".",".","3"], 
 * 			["4",".",".","8",".","3",".",".","1"],
 * 			["7",".",".",".","2",".",".",".","6"],
 * 			[".","6",".",".",".",".","2","8","."],
 * 			[".",".",".","4","1","9",".",".","5"], 
 * 			[".",".",".",".","8",".",".","7","9"]] 
 * 
 * Output: true 
 * 
 * Example 2:
 * 
 * Input: [ ["8","3",".",".","7",".",".",".","."],
 * 			["6",".",".","1","9","5",".",".","."], 
 * 			[".","9","8",".",".",".",".","6","."],
 * 			["8",".",".",".","6",".",".",".","3"], 
 * 			["4",".",".","8",".","3",".",".","1"],
 * 			["7",".",".",".","2",".",".",".","6"], 
 * 			[".","6",".",".",".",".","2","8","."],
 * 			[".",".",".","4","1","9",".",".","5"], 
 * 			[".",".",".",".","8",".",".","7","9"] ]
 * Output: false \
 * 
 * Explanation: Same as Example 1, except with the 5 in the top
 * left corner being modified to 8. Since there are two 8's in the top left 3x3
 * sub-box, it is invalid. Note:
 * 
 * 1) A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. 
 * 2) Only the filled cells need to be validated according to the
 * mentioned rules. 
 * 3) The given board contain only digits 1-9 and the character '.'. 
 * 4) The given board size is always 9x9.
 * 
 * @author Vivek
 *
 */
public class ValidateSudoku
{

	public boolean isValidSudoku(char[][] board)
	{
		int row = board.length;
		int column = board[0].length; 
		for(int i = 0 ; i < row ; i++)
		{
			Set<Character> set = new HashSet<>();
			
			for(int j = 0 ; j < column ; j++)
			{
				if(board[i][j] != '.')
				{
					if(!set.add(board[i][j]))
					{
						return false;
					}
				}
			}
			
		}
		
		for(int i = 0 ; i < column ; i++)
		{
			Set<Character> set = new HashSet<>();
			
			for(int j = 0 ; j < row ; j++)
			{
				if(board[j][i] != '.')
				{
					if(!set.add(board[j][i]))
					{
						return false;
					}
				}
			}
			
		}
		
		for(int i = 0 ; i < row ; i+=3)
		{
			for(int j = 0 ; j < column ; j+=3)
			{
				Set<Character> set = new HashSet<>();
				for(int k = i; k < i + 3 ; k++)
				{
					for(int l = j ; l < j + 3 ; l++)
					{
						if(board[k][l] != '.')
						{
							if(!set.add(board[k][l]))
							{
								return false;
							}
						}
						
					}
					
				}
			}
			
		}
		
		return true;
	}
	
	
	public static void main(String[] args)
	{
		ValidateSudoku validateSudoku = new ValidateSudoku();

		char [][] board = new char [][]{{'5','3','.','.','7','.','.','.','.'},
										{'6','.','.','1','9','5','.','.','.'}, 
										{'.','9','8','.','.','.','.','6','.'},
										{'8','.','.','.','6','.','.','.','3'}, 
										{'4','.','.','8','.','3','.','.','1'},
										{'7','.','.','.','2','.','.','.','6'},
										{'.','6','.','.','.','.','2','8','.'},
										{'.','.','.','4','1','9','.','.','5'}, 
										{'.','.','.','.','8','.','.','7','9'}};
		
//		char [][] board = new char [][]{{'5','3','.','.','7','.','.','.','.'},
//										{'6','.','.','1','9','5','.','.','.'}, 
//										{'.','9','8','.','.','.','.','6','.'},
//										{'8','.','.','.','6','.','.','.','3'}, 
//										{'4','.','.','8','.','3','.','.','1'},
//										{'7','.','.','.','2','.','.','.','6'},
//										{'.','6','.','.','.','.','2','8','.'},
//										{'.','.','.','4','1','9','8','.','5'}, 
//										{'.','.','.','.','8','.','.','7','9'}};
//		
		System.out.println(validateSudoku.isValidSudoku(board));
	}

}
