
public class Porblem2
{
	public static Max2ndMax dcfindmax2ndmax (int[] A, int start, int end)
	{
		// Complete this method to find max and 2nd max in an array A
		// At most 3n/2-2 comparisons
		// Algorithms that make more than 3n/2-2 comparisons will be scored out of 10 points
		// Complete the code from here
		// Feel free to change method type, parameters
		int size = end - start +1;		
		int mid = (start+end)/2 ;
		
	    Max2ndMax maxes = new Max2ndMax();  
		if(size == 1)
		{
			compare(maxes, A, start, start, size);
		}
		else if(size == 2)
		{
			if(A[start] > A[end])
			{
				compare(maxes , A,  start, end, size);
			}//if
			
			else
			{
				compare(maxes , A,  end, start, size);
			}
			
		}//else
		
		else
		{
			
			Max2ndMax leftMaxes = dcfindmax2ndmax(A, start, mid);
			
			Max2ndMax rightMaxes = dcfindmax2ndmax(A, mid+1, end);
			
			if(leftMaxes.max >= rightMaxes.max && leftMaxes.max2nd >= rightMaxes.max2nd)
				maxes = leftMaxes;
			else if(leftMaxes.max < rightMaxes.max && leftMaxes.max2nd < rightMaxes.max2nd)
				maxes = rightMaxes;
			else
			{
				
				if(leftMaxes.max >= rightMaxes.max)
				{
					//get the max
					maxes.max = leftMaxes.max;
					
					//find the max2nd
					if(rightMaxes.max >= leftMaxes.max2nd )
					{
						maxes.max2nd = rightMaxes.max;
					}//if
					else
					{
						maxes.max2nd = leftMaxes.max2nd;
					}//else
				}//if
					
				else
				{
					//get the max
					maxes.max = rightMaxes.max;
					
					//find the max2nd
					if(rightMaxes.max <= leftMaxes.max2nd )
					{
						maxes.max2nd = leftMaxes.max;
					}//if
					else
					{
						maxes.max2nd = rightMaxes.max2nd;
					}//else
				}//else
					
				
				
			}//else
			
		}//else
		
		return maxes;
	}//Max2ndMax
	
	public static void compare (Max2ndMax maxs, int A [], int bIndex, int sIndex, int length)
	{
		if(length == 2)
		{
			//compares the current max to the element in the bigger index in the array
			if(maxs.max < A[bIndex])
			{
				maxs.max = A[bIndex];
			}//if 
			
			//compares the current max to the element in the smaller index in the array
			if(maxs.max2nd < A[sIndex])
			{
				maxs.max2nd = A[sIndex];
			}//else
		}//if
		
		else
		{
			if(maxs.max < A[bIndex])
			{
				maxs.max = A[bIndex];
			}//if 
			
			else if(maxs.max2nd < A[bIndex])
			{
				maxs.max2nd = A[bIndex];
			}//else
		}//else
	}//compare
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method
		int[] givenarray = {100,2,3,4,5,6,7,67,2,32};	
		
		// Test your method
		Max2ndMax pair = new Max2ndMax();
		pair = dcfindmax2ndmax(givenarray, 0, givenarray.length-1);
		
		int max2nd = pair.max2nd;
		int max = pair.max;
		System.out.println("The max and 2ndmax of the given array is "+ max + " and "+max2nd+".");
		// Your method should return 100 and 67
		
	}
}
