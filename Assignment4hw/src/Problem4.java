
public class Problem4
{
	public static int squareroot(int x)
	{
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters
		
		boolean done = false;
		int num = x/2;
		int start = 0;
		int end = num*num;
		
		while(!done)
		{
					
			if( x+1 == num*num  || x-1 == num*num || x== num*num)
			{
				done = true;
				num++;
				//if the number is a square root 
				if(x % num != 0)
					num--;
			}//if
			else if(num*num > x)
			{
				//increments until num^2 is greater than x
				end = num;
				num = num/2;
			
			} //else
			else 
			{
				start = num;
				num = (num/2) + num;
		
			}//else
				
	
		}//while
		
		return num;
		

	}//square root
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		int x1 = 8;
		int x2 = 5;
		int x3 = 17;
		
		
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		
	}
}//Problem4
