
public class Problem3
{
	public static boolean majority(int[] A)
	{
		/*
		Input: an array A of n integers (positive, negative, or 0), elements sorted in ascending order.
		Output: if there exists a majority element.
		An element is a majority if it appears more than n/2 times. For example, if the input list is: 
		{0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7}
		The output should be true, as 0 appears 6 times (>n/2 = 11/2 times).
		However, if the input list is:
		{0, 0, 0, 1, 1, 2, 3, 10, 10}
		The majority element does not exist.
		Design an algorithm that solves this problem.
		*/
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters
		
		// Complete this method
		
		boolean major = false;
		//The majority element will always be in the middle if it exists
		int midEl = A[A.length/2];
		//saves the number of occurances the middle element appears in the list
		int occur = count(A, midEl);
		//Sets major to true if the num of occrances are greater than or equal to half of the list's length
		if(occur >= A.length/2)
			major = true;
		
		return major;
			
	}//majority
	
	//Used the same method from problem one to find the count
	//Because the majority element is n/2 
	//Therefore if there is a majority element then it must be in the middle element
	public static int count(int[] A, int x)
	{
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters
		
		boolean conF = false;
		boolean conL = false;
		int start = 0;
		int end = A.length;
		int mid = (start+end)/2;
		int firstX = 0;
		int lastX = 0;
		
		//finds the first occurance of x
		while(!conF)
		{
			mid = (start+end)/2;
			
			if(x == A[mid] && (mid == 0 || A[mid -1] != x))
			{
				firstX = mid;
				conF = true;
			}//if
			
			else if(x > A[mid])
			{
				start = mid+1;
			}
				
			else
			{
				end = mid-1;
			}
				
			
		}//while
		
		
		start = 0;
		end = A.length;
		
		//finds the last occurance of x
		while(!conL)
		{
			mid = (start+end)/2;
				
				
			if(x == A[mid] && (mid == 0 || A[mid + 1] != x))
			{
					
				lastX = mid;
				conL = true;
				
			}//if
			
			//resets the end and decreases the search size
			else if(x < A[mid])
				end = mid -1;
			//resets the star and decreases the search size
			else
				start = mid+1;			
		}//while
	
		return lastX - firstX + 1;
		
	}//count

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};
		
		int[] testarray2 = {0, 0, 0, 1, 1, 2, 3, 10, 10};
		
		
		System.out.println("Does there exist a majoirty element in testarray1? "+ majority(testarray1));
		// True, 0 occurs 6 times, more than half of the array 
		System.out.println("Does there exist a majoirty element in testarray2? "+ majority(testarray2));
		// False 
	}//main

}//Problem 3
