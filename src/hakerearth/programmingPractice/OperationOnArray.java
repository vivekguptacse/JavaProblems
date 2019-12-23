package hakerearth.programmingPractice;

/**
 * Problem statement dont remeber , as was not allowed to copy. 
 * 
 * @author Vivek
 *
 */
public class OperationOnArray
{

	public static void main(String[] args)
	{
		System.out.println(winCount(new int[] {4,8,6,7,7,4,2}, new int[] {2,8,10,5,5,8,9}));
	}

	static int winCount(int[] A, int[] B)
	{
		int D1 = 0;
		int D2 = 0;
		int count = 0;
		
		for(int i = 0 ; i < A.length ; i++)
		{
			if(A[i] > B[i])
			{
				if((A[i] ^ D1) > (B[i] ^ D2))
				{
					count++;
					if(D2 < B[i])
					{
						D2 = B[i];
					}
				}
			}
			else if((A[i] ^ D1) < (B[i] ^ D2))
			{
				if(D1 < A[i])
				{
					D1= A[i];
				}
			}
		}
		return count;
	}

}
