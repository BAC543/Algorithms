import java.util.Arrays;

public class Problem1 
{
	public static Pair findmaxdiff (int[] A, Pair newMaxMin, int start, int end)
	{
		// Complete the method to find the maximum difference between points in A[]
		// so that the larger value appears after the smaller value in A[]
		// feel free to change the return type, parameters
		// Full credit (30 points) will be awarded for a divide-and-conquer algorithm that is O(n). 
		// Algorithms that are NOT divide-and-conquer or slower than O(n) will be scored out of 10 points.
		
		
		int size = end - start +1;		
		int mid = (start+end)/2 ;
		
		System.out.println("Start: "+start);
		System.out.println("End:   "+end);
		System.out.println("Size:  "+size);
		

			//first base case
			//When two elements are left in the array
			if(size == 1)
			{
				System.out.println("Before 1");
				System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());
				
				compare(newMaxMin ,A, start, start);
				
				System.out.println("Base Case 1");
				System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());
							
			}//if
			
			//second base case 
			//When one element is left in the array
			else if(size == 2)
			{
				if(A[start] > A[end])
				{
					System.out.println("Before 2");
					System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());

					compare(newMaxMin ,A, start, end);
								
					System.out.println("Base Case 2");
					System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());
				}//if
				else
				{
					
					compare(newMaxMin ,A, end, start);

					System.out.println("Base Case 2");
					System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());
				}//else
			}//if
			
			//General case
			//When the array must be split into smaller pieces
			else 
			{
				
				System.out.println("Base Case 3");
				System.out.println("min: "+newMaxMin.getMin()+"  max: "+newMaxMin.getMax());

				//get the ranges from each array
				System.out.println("Jump to left array");
				System.out.println("--------");
				//leftArray
				Pair leftPair =  findmaxdiff(A, newMaxMin, start, mid);
				
				//refreshes newMaxMin
				//This allows us to save 2 separate pairs
				 newMaxMin = new Pair();
				
				System.out.println("Jump to right array");
				System.out.println("--------");
				//Right Array
				Pair rightPair = findmaxdiff(A, newMaxMin, mid+1, end); 
				
				//If this line is not executed again then rightPair will be changed when we set our new max and min
				 newMaxMin = new Pair();
				
				System.out.println("Left pair: max =  "+leftPair.getMax() +" min = "+leftPair.getMin());
				System.out.println("Right pair: max = "+rightPair.getMax() +" min = "+rightPair.getMin());
				
				//Min and Max are in the right side of the array
				if(rightPair.getMin() <= leftPair.getMin() && rightPair.getMax() >= leftPair.getMax())
					newMaxMin = rightPair;
				//Min and Max are in the left side of the array
				else if( leftPair.getMin() <= rightPair.getMin() && leftPair.getMax() >= rightPair.getMax())
						newMaxMin = leftPair;
				//Min is in the left side of the Array and Max is in the right half of the array
				else
				{	
					newMaxMin.setMin(leftPair.getMin());
					newMaxMin.setMax(rightPair.getMax());
				}//else
		
			}//else

			System.out.println(newMaxMin.getMax() +" - "+newMaxMin.getMin());
			return newMaxMin;
			
			
	}//findmaxdiff
	
	public static void compare(Pair nums, int[] ar, int big, int small )
	{
		//update the max
		if(nums.getMax() < ar[big] )
		{
			nums.setMax(ar[big]);
			nums.setMaxIndex(big);
		}//if
		
		//update the min
		if(nums.getMin() > ar[small])
		{
			nums.setMin(ar[small]); 
			nums.setMinIndex(small);
		}//if
		
	}//compare
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// Test your findmaxdiff() method here
		int start = 0;
		Pair maxMin1 = new Pair();
		Pair maxMin2 = new Pair();
		
		int[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
		Pair ans1 = findmaxdiff(testarray1, maxMin1, start, testarray1.length -1  );
		System.out.println("-------------------------------------");
		System.out.println("The range is "+ans1.getRange());
		System.out.println("-------------------------------------");
		// maxdiff: 8
		
		int[] testarray2 = {7, 9, 1, 6, 3, 2};
		Pair ans2 = findmaxdiff(testarray2, maxMin2, start, testarray2.length - 1);
		System.out.println("-------------------------------------");
		System.out.println("The range is "+ans2.getRange());
		System.out.println("-------------------------------------");
		// maxdiff: 5
		

		// Add test statements 
		
		
		
	}//main
}//Problem1


