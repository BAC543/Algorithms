
public class SubsetSumDP {
	
	public static boolean subsetSum(int[] A, int x) {
		
		boolean[][] sums = new boolean[A.length + 1][x + 1];
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Subset Sum Algorithm
		// Return true if there exists a subset in A with sum = x
		// Hint: Follow the pseudocode of subsetSum in the slides


		//Initializes the first row of sums to false
		for(int j = 0;  j < x + 1; j++)
			sums[0][j] = false;
		
		//Inits the first column line of sums to true  
		for(int i = 0; i< A.length + 1; i++)
			sums[i][0] = true;

			//Loops through all elements in the list
			for (int i = 1; i < A.length+ 1; i++)
			{
				//Loops through all potential sums
				for(int j = 0; j <  x + 1; j++)
				{
					//Finds possible sums
					if(A[i-1] > j)
						sums[i][j] =  sums[i- 1][j];
					else
						sums[i][j] =  sums[i- 1][j] || sums[i-1][j - A[i-1]];

				}//for
			}//for

		return sums[A.length][x];
	}

	public static void main(String[] args) {
		
		int[] A = {1,3,5,2,8};
		
		int x = 9;
		
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		// Expected output: true
	}

}
