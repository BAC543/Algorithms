
public class Problem1
{
	public static void intersection(int[] s1, int[] s2)
	{
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		
		int pointer1 = 0;
		int pointer2 = 0;
		
		
		int pre = Integer.MIN_VALUE;

		
		while(s1.length > pointer1 && s2.length > pointer2)
		{
			//Outputs when both lists have the same value
			if(s1[pointer1] == s2[pointer2] && s1[pointer1] != pre)
			{

				System.out.print(" "+s1[pointer1]+",");
				
				//Ensures that the array will never take in duplcates
				pre = s1[pointer1];
				
				//increment everything to get the next elements in each list
				pointer1++;
				pointer2++;
				
			}//if
			
			//allows the second list to catch up to the s1 
			else if( s1[pointer1] > s2[pointer2])
			{
				pointer2++;
			}//if
			
			//allows the second list to catch up to the s2
			else
			{
				pointer1++;
			}//else
		}//while
		
	}//intersection
	
		public static void union(int[] s1, int[] s2)
	{
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		
		int pointer1 = 0;
		int pointer2 = 0;
		

		int pre = Integer.MIN_VALUE;
		
		//Ends when one the lists are finished
		while(s1.length > pointer1 && s2.length > pointer2)
		{
				//Increments everything when both pointers are under the same value
				if(s1[pointer1] == s2[pointer2] )
				{
					if(s1[pointer1] != pre)
					{
						System.out.print(" "+s1[pointer1]+",");
						pre = s1[pointer1];
					}
		
					pointer1++;
					pointer2++;
							
				}//if
				
				//allows the first list to catch up to the s2
				else if (s1[pointer1] < s2[pointer2] )
				{
					
					if(s1[pointer1] != pre)
					{				
						System.out.print(" "+s1[pointer1]+",");
						pre = s1[pointer1];
					}
						
					pointer1++;
					
					
				}//else
				
				//allows the second list to catch up to the s1
				else if (s1[pointer1] > s2[pointer2] )
				{
					if(s2[pointer2] != pre)
					{
						System.out.print(" "+s2[pointer2]+",");
						pre = s2[pointer2];
					}

					pointer2++;
					
				}//else
		}//while
		
		//Adds the remaining elements into the list
		
		while(s1.length > pointer1)
		{
			if(s1[pointer1] != pre)
			{
				System.out.print(" "+s1[pointer1]+",");
				pre = s1[pointer1];
			}
			pointer1++;
		}//while
		
		while(s2.length > pointer2)
		{
			if(s2[pointer2] != pre)
			{
				System.out.print(" "+s2[pointer2]+",");
				pre = s2[pointer2];
			}//if
				
			pointer2++;
		}//while
		
		
	}//union
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Test your intersection() method here
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		 System.out.println("intersection of testarray1 and testarray2: ");
		 intersection(testarray1,testarray2);
		 System.out.println("");
		
		//should output 0, 1, 2, 3, 98
		System.out.println("union of testarray1 and testarray2: ");
		 union(testarray1,testarray2);

		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100
	}//main
}//Problem1
