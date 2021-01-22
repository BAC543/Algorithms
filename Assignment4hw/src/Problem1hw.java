
public class Problem1hw 
{
	public static int count(double[] A, double x)
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
			//resets the start and decreases the search size
			else
				start = mid+1;			
		}//while
	
		return lastX - firstX + 1;
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
		
		
	}
}//Problem1 hw
