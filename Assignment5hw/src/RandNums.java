import java.util.Random;

public class RandNums 
{
	public static void main( String[] args)
	{
		Random rand = new Random();
		int [] array = new int [] {1, 3, 34,  2,  34, 34, 65, 563, 5, 0 ,-12, 123};
		
		int num1  = array[rand.nextInt(array.length)];
		int num2 = array[rand.nextInt(array.length)];
		int num3 = array[rand.nextInt(array.length)];
		
		int median = Integer.MIN_VALUE;
		
		if( (num1 >= num2 && num1 <= num3) || (num1 <= num2 && num1 >= num3))
			median = num1;
		if( (num2 >= num1 && num2 <= num3) || (num2 <= num1 && num2 >= num3))
			median = num2;
		if( (num3 >= num2 && num3 <= num1) || (num3 <= num2 && num3 >= num1))
			median = num3;
		System.out.println("Num1: "+num1+ "  Num2: "+num2+"  Num3: "+num3);
		System.out.println("Median: "+median);
	}//main
}
