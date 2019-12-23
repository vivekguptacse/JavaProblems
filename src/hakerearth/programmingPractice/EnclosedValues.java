package hakerearth.programmingPractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Vivek
 *
 */
public class EnclosedValues
{
	// TODO -- Not yet solved .. Dont remember problem statement 
	public static void main(String[] args) throws IOException
	{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter wr = new PrintWriter(System.out);
//		String[] inp = br.readLine().split(" ");
//		int n = Integer.parseInt(inp[0]);
//		int m = Integer.parseInt(inp[1]);
//		int q = Integer.parseInt(inp[2]);
//		int[][] arr = new int[n][m];
//		// String[] arr_arr = new String [] {"2","3","4","5"};
//		for (int i_arr = 0; i_arr < n; i_arr++)
//		{
//			String[] arr_arr = br.readLine().split(" ");
//			for (int j_arr = 0; j_arr < arr_arr.length; j_arr++)
//			{
//				arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
//			}
//		}
//		for (int i = 0; i < q; i++)
//		{
//
//			String[] query_inp = br.readLine().split(" ");
//
//			int x1 = Integer.parseInt(query_inp[0]);
//			int y1 = Integer.parseInt(query_inp[1]);
//			int x2 = Integer.parseInt(query_inp[2]);
//			int y2 = Integer.parseInt(query_inp[3]);
//			int fac = Integer.parseInt(query_inp[4]);
//
//			long out_ = EnclosedValue(arr, y2, x2, y1, fac, x1);
//			System.out.println(out_);
//		}

	}

	static long EnclosedValue(int[][] arr, int y2, int x2, int y1, int fac, int x1)
	{
		
		long result = 0;
		for(int i=x1-1 ; i <= x2-1 ; i++)
		{
			for(int j = y1-1 ; j <= y2-1; j++)
			{
				Integer[] primeFactors = primeFactors(arr[i][j]);
				for(Integer val:primeFactors)
				{
					result+=val;
				}
				
			}
			
		}
		
		
		return result;

	}
	
	static Integer[] getAllPrimeNumbers(int num)
	{
		int [] primes = new int [num +1];
		
		for(int i = 2 ; i < num ; i++)
		{
			// lets make all number prime
			primes[i] = 1;
		}
		
		for(int i = 2; i < num ; i++)
		{
			for(int j = 2 ; i*j < num ; j++)
			{
				primes[i*j] = 0;
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < num ; i++)
		{
			if(primes[i] != 0)
			{
				list.add(i);
			}
		}
		
		return list.toArray(new Integer[list.size()]);
	}
	
	static Integer[] primeFactors(int num)
	{
		Set<Integer> set = new HashSet<>();
		Integer[] allPrimeNumbers = getAllPrimeNumbers(num);
		for(int i = 0; i< Math.sqrt(num) ; i++)
		{
			while(num % allPrimeNumbers[i] == 0)
			{
				set.add(allPrimeNumbers[i]);
				num = num / allPrimeNumbers[i];
			}
		}
		if(set.isEmpty())
		{
			set.add(num);
		}
		
		return set.toArray(new Integer[set.size()]);
	}

}
