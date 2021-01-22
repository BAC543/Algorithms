
public class Problem3 
{
	public static boolean searchi (int[] A)
	{
		// Complete the method that given a sorted array A[]
		// Find out whether or not there is an index i such that A[i] = i
		// feel free to change the return type, parameters
		// Full credit (30 points) will be awarded for an algorithm that is O(logn). 
		// Algorithms that are slower than O(logn) will be scored out of 10 points.

			
			boolean found = false;
			int start = 0;
			int end = A.length;
			int mid = (start+end)/2;
			int size=  end - start +1;	
			
			//finds if any of the indexes are equal to their values
			while(!found && size > 1)
			{

				size =  end - start +1;	
				
				mid = (start+end)/2;
				
				if(mid == A[mid])
				{
					//Ends the loop
					found = true;
				}//if
				
				//resets the start and decreases the search size
				else if(A[mid] > A[mid])
				{
					start = mid+1;
				}
				
				//resets the end and decreases the search size
				else
				{
					end = mid-1;
				}
					
			}//while
			
			return found;
	}//searchi
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

				
		int[] testarray1 = {-4, 0, 2, 5, 10};
		// true
		
		System.out.println("There is an index i that A[i] = i in testarray1: " + searchi(testarray1));
		
		int[] testarray2 = {1, 2, 3, 4, 5};
		// false
		
		System.out.println("There is an index i that A[i] = i in testarray2: " + searchi(testarray2));
		

		// Feel free to change the test statements 
		
		
		
	}//main
}//Problem3
