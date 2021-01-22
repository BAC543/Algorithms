import java.util.Arrays;

public class Problem3
{

	
	public static void threeway(int[] a)
	{
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and //elements=pivot are placed in the middle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
		int pivot = a[0];
		int i = 1;
		int left = 0;
		int j = a.length-1;
		int temp;
		
		while(i <= j)
		{
			while( a[i] < pivot)
			{
				if(a[i] < pivot)
				{
					temp = a[i];
					a[i] = a[left];
					a[left] = temp;
					
					left++;
				}//if
				i++;
			}//while
			while(a[j] >= pivot && i < j)
			{
				if(a[j] == pivot)
				{
					//swap a[midp] with a[endp]
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					
					i++;
					
				}//if
					
				j--;
			}//while
			
			if(i < j )
			{
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}

		}//while
	
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		// Test your method
		threeway(testarray);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 6, 7, 2, 2, 2, 8, 3}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right
		
		
		
	}
}